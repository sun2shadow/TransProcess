package com.baoshu.transprocess;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Base64;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.commons.lang3.StringUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.zeromq.ZMQ;

import com.baoshu.common.Constants;
import com.baoshu.dao.model.QueryLog;
import com.baoshu.dao.model.TransLog;
import com.baoshu.service.QueryLogService;
import com.baoshu.service.TransLogService;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;

public class TransInterfaceProcess {
	
	public static AtomicInteger counter_integer = new AtomicInteger(9300);
	@Autowired
	private TransLogService transLogService;
	@Autowired
	private QueryLogService queryLogService;
	private  ZMQ.Socket requester;
	public TransInterfaceProcess() {
		
	}
	public void init() {
		{
        	ZMQ.Context context = ZMQ.context(1);
    		requester = context.socket(ZMQ.REQ);
    		requester.connect("tcp://192.168.0.229:5555");
    		
//    		String request = "1 connect tcp://180.167.17.121:20910 \0";
//    		byte[] sendByte = request.getBytes();
//    		requester.send(sendByte);
//    		byte[] reply = requester.recv(0);
//    		System.out.println("Received " + new String(reply));
        }
	}
	public void dealTrans() {
		System.out.println("thread start");
		Thread thread1 = new Thread(new Runnable() {

			@Override
			public void run() {
				ChannelHandlerContext ctx = null;
				while(true) {
					try {
						Map<String, Object> params = QueueSet.queue.take();
//						System.out.println("===params=="+params.get("info").toString());
						String result = dealTransProcess(params.get("info").toString());
						System.out.println("==result==="+TransHelper.dealCount(result)+result);
						
						ctx = (ChannelHandlerContext)params.get("ctx");
						ctx.writeAndFlush(getSendByteBuf(TransHelper.dealCount(result)+result));
						
						if(TransHelper.resultOk(result)) {
							System.out.println("=transService==="+transLogService);
							transLogService.add(result);
						}
						
//						Thread.sleep(500); 
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (UnsupportedEncodingException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}finally {
						if(Objects.nonNull(ctx)) {
							ctx.close();
						}
					}
				}
				
			}
			
		});
		thread1.start();
		//不停的读取channel的数据
		Thread thread2 = new Thread(new Runnable() {

			@Override
			public void run() {
				ChannelHandlerContext ctx = null;
				while(true) {
					try {
						ctx = QueueSet.dataQueue.take();
						Map<String, Object> params = QueueSet.msgMap.containsKey(ctx)?QueueSet.msgMap.get(ctx):new HashMap<>();
						ByteBuf buf = (ByteBuf) params.get("info");
						if(ctx.channel().isActive()) {
							
							byte[] b = new byte[8];
							buf.readBytes(b);
							int count = new Integer(new String(b));
							System.out.println("字节数："+count);
							byte[] data = new byte[count];
							buf.readBytes(data); 
							
							try {
								String request = new String(data, "utf-8");
								Map<String, Object> dealData = new HashMap<>();
								dealData.put("ctx", ctx);
								dealData.put("info", request);
								QueueSet.queue.put(dealData);
//								System.out.println("调用接口的数据："+request);
							} catch (UnsupportedEncodingException e) {
								buf.release();
								QueueSet.msgMap.remove(ctx);
								e.printStackTrace();
							}
							
						}else {
							QueueSet.msgMap.remove(ctx);
							buf.release();
						}
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}
			
		});
		thread2.start();
		
		Thread thread3 = new Thread(new Runnable() {

			@Override
			public void run() {
				while(true) {
					try {
						TransLog transLog = QueueSet.mapperQueue.take();
						String result = transSearch(transLog.getLsno() + transLog.getDevideOrderNo());
						String[] strArray = result.split(" ");
						if(!result.equals("notfund") && strArray.length > 1) {
							//委托总数量
							int totalNum = transLog.getQty();
							//已成交数量
							int num = Integer.parseInt(strArray[1]);
							if(totalNum >= num) {
								QueueSet.mapperQueue.put(transLog);
							}
							
							String ordersNo = transLog.getLsno() + transLog.getDevideOrderNo();
							QueryLog queryLog = new QueryLog();
							queryLog.setOrdersNo(ordersNo);
							queryLog.setFundid(transLog.getFundid());
							Map<String, Object> moneyAndAmount = queryLogService.totalMoneyAndAmount(ordersNo);
							BigDecimal searchMoney = new BigDecimal(strArray[0]);
							queryLog.setUseMoney(searchMoney.subtract(new BigDecimal(moneyAndAmount.get("useMoneys").toString())));
							int searchAmount = new Integer(strArray[1]);
							queryLog.setUseAmount(searchAmount - new Integer(moneyAndAmount.get("useAmounts").toString()));
							queryLog.setPostStr(LocalDateTime.now().getNano());
							queryLogService.add(queryLog);
						}
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}
			
		});
		thread3.start();
	}
	

	
	/**
	 * 下单交易
	 * @param params
	 * @return
	 */
	private String transOrder(Map<String, Object> params, String transInfo) {

		StringBuilder sb = new StringBuilder();
		counter_integer.getAndIncrement();
		System.out.println("计数器：" + counter_integer);
		sb.append(counter_integer + " order");
		sb.append(" " + params.get("Fundid").toString());
		String flag = params.get("Flag").toString();
		switch(flag) {
		case "B":
			flag = "1";
			break;
		case "S":
			flag = "2";
			break;
		case "RB":
			flag = "61";
			break;
		case "RS":
			flag = "62";
			break;
		case "MQHQ":
			flag = "63";
			break;
			default :
				break;
		}
		sb.append(" " + flag);
		sb.append(" " + params.get("Price").toString());
		sb.append(" " + params.get("Qty").toString());
		sb.append(" " + params.get("LSno").toString());
		sb.append(" " + params.get("StkCode").toString());
		sb.append(" " + params.get("Market").toString());
		sb.append(" \0");
		String request = sb.toString();
		byte[] sendByte = request.getBytes();
		System.out.println("下单请求"+request);

//		requester.send(sendByte);
//		byte[] reply = requester.recv(0);
//		String result = new String(reply);
		String result = "sendorderok";
		System.out.println("下单结果" + result + counter_integer);

		if(result.equals("sendorderok")) {
			return "<result>true</result><Records><Record><Ordersno>"+params.get("LSno").toString()+params.get("DivideOrderno").toString()+"</Ordersno>"
					+ transInfo
					+ "</Record></Records>";
		}else {
			return "<result>false</result>"
					+ transInfo
					+ "<err_code>-1</err_code><err_msg>资金不足</err_msg>";
		}
		
	}
	/**
	 * 撤单处理
	 * @param params
	 * @param transInfo
	 * @return
	 */
	private String transCancelOrder(Map<String, Object>params, String transInfo) {
		StringBuilder sb = new StringBuilder();
		counter_integer.getAndIncrement();
		System.out.println("撤单计数器：" + counter_integer);
		return "<result>true</result>" + transInfo + "<err_code>0</err_code><err_msg>ok</err_msg>";
	}
	/**
	 * 交易登录
	 * @param params
	 * @return
	 */
	private String transLogin(Map<String, Object> params, String transInfo) {
//		StringBuilder sb = new StringBuilder();
//		counter_integer.getAndIncrement();
//		System.out.println("登录计数器：" + counter_integer);
//		sb.append(counter_integer + " login");
////		sb.append(" " + params.get("Fundid"));
////		sb.append(" " + params.get("Password"));
//		sb.append(" 58200001");
//		sb.append(" 111111");
//		sb.append(" \0");
//		String request = sb.toString();
//		System.out.print(requester+"登录参数："+request);
//		byte[] sendByte = request.getBytes();
//		requester.send(sendByte);
//		byte[] reply = requester.recv(0);
//		String result = new String(reply);
//		System.out.println("登录结果" + result + counter_integer);//登录结果loginok501
		String result = "loginok";
		String str = "";
		if(result.contains("loginok")) {
			str =  "<result>true</result><err_code>0</err_code><err_code>0</err_code>";
		}else {
			str = "<result>false</result><err_code>-1</err_code><err_code>错误信息</err_code>";
		}
		return str + transInfo;
	}
	

	/**
	 * 调用查询交易接口
	 * @param params
	 * @param transInfo
	 * @return
	 */
	private String transSearch(String ordersNo) {
		StringBuilder sb = new StringBuilder();
		counter_integer.getAndIncrement();
		System.out.println("查询计数器：" + counter_integer);
		sb.append(counter_integer + " query");
		sb.append(" " + ordersNo);
		sb.append(" \0");
		String request = sb.toString();
		System.out.println("查询接口调用参数"+request);
		byte[] sendByte = request.getBytes();
		requester.send(sendByte);
		byte[] reply = requester.recv(0);
		String result = new String(reply);
//		String result = "queryok";
		System.out.println("查询接口调用"+result);
		
//		StringBuilder cxsb = new StringBuilder();
//		
//		if(result.contains("queryok")) {
//			cxsb.append("<result>true</result>");
//			cxsb.append("<FieldsDesc>Poststr|Trddate|Stkcode|Stkname|Ordersno|Market|Matchtime|Matchqty|Matchprice|Matchtype|Orderqty|Orderprice|Matchcode|Bsflag</FieldsDesc><Records>");
//			cxsb.append("<Records>");
//			String record = StringUtils.isNotBlank(result) ? "<Record>"+ "0102000000120539|20170322|000001|xr2wstL40NA=|7679|SZ|173113|100|1.000|0|||0102000000120539|B" +"</Record>":"";
//			cxsb.append(record);
//			cxsb.append("</Records>");
//			
//		}else {
//			cxsb.append("<result>false</result>");
//			cxsb.append("<err_code>-1</err_code>");
//			cxsb.append("<err_msg>");
//			cxsb.append(result);
//			cxsb.append("</err_msg>");
//		}
//		cxsb.append(transInfo);
		return result;
	}

	
	public String dealTransProcess(String transInfo) {
		Map<String, Object> xmlInfo = TransHelper.parseXmlText(transInfo);
		String funName = xmlInfo.containsKey("Function") ? xmlInfo.get("Function").toString()  : "";
		String flagName = xmlInfo.containsKey("Flag") ? xmlInfo.get("Flag").toString()  : "";
		String result = "";
		if(StringUtils.isNotBlank(funName) && StringUtils.isNotBlank(flagName)) {
			switch(funName) {
			case Constants.FUNCTION_TYPE_JY:
				switch(flagName) {
					case Constants.FLAG_B : case Constants.FLAG_S:
						case Constants.FLAG_RB:case Constants.FLAG_RS:
						case Constants.FLAG_MQHQ:
						//调用交易方法
						result = transOrder(xmlInfo, transInfo);
						break;
					case Constants.FLAG_CD:
						result = transCancelOrder(xmlInfo, transInfo);
						break;
					default:
						break;
				}
				break;
			case Constants.FUNCTION_TYPE_CX:
				switch(flagName) {
				case Constants.FLAG_CXDL:
					result = transLogin(xmlInfo, transInfo);
					break;
				case Constants.FLAG_CJ:
//					result = transSearch(xmlInfo, transInfo);
					break;
				}
				break;
			default:
				break;
			}
		}

		return result;
	}
	
	//字符串转化为字节
  	private  ByteBuf getSendByteBuf(String message) throws UnsupportedEncodingException {
  		byte[] req = message.getBytes("utf-8");
  		ByteBuf buf = Unpooled.buffer();
  		buf.writeBytes(req);
  		return buf;
  	}
  	private String searchFromDB(String xmlInfo) {
  		Map<String, Object> queryInfo = TransHelper.parseXmlText(xmlInfo);
  		String fundid = queryInfo.get("Fundid").toString();
  		String postStr = queryInfo.get("Poststr").toString();
  		if(StringUtils.isBlank(postStr)) {
//  			queryLogService
  		}
  		return "";
  	}
}
