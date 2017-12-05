package com.baoshu.transprocess;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.commons.lang3.StringUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.zeromq.ZMQ;

import com.baoshu.common.Constants;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;

public class TransInterfaceProcess {
	
	public static AtomicInteger counter_integer = new AtomicInteger(300);
	public static LinkedBlockingQueue<Map<String, Object>> queue = new LinkedBlockingQueue<>();
	
	private  ZMQ.Socket requester;
	public TransInterfaceProcess() {
		
	}
	public void init() {
		{
        	ZMQ.Context context = ZMQ.context(1);
    		requester = context.socket(ZMQ.REQ);
    		requester.connect("tcp://192.168.0.136:5555");
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
						Map<String, Object> params = queue.take();
						System.out.println("===params=="+params.get("info").toString());
						String result = dealTransProcess(params.get("info").toString());
						System.out.println("==result==="+result);
						ctx = (ChannelHandlerContext)params.get("ctx");
						ctx.writeAndFlush(result);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}finally {
						if(Objects.nonNull(ctx)) {
//							ctx.close();
						}
					}
				}
				
			}
			
		});
		thread1.start();
	}
	
	//����xml�ַ���
	private Map<String, Object> parseXmlText(String text) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			Document document = DocumentHelper.parseText("<trans>" + text + "</trans>");
			Element root = document.getRootElement();
			
			Iterator<Element> modulesIterator = root.elements().iterator(); 
			while(modulesIterator.hasNext()) {
				Element ele = modulesIterator.next();
				result.put(ele.getName(), ele.getTextTrim());
			}
			
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * �µ�����
	 * @param params
	 * @return
	 */
	private String transOrder(Map<String, Object> params) {

		StringBuilder sb = new StringBuilder();
		counter_integer.getAndIncrement();
		System.out.println("��������" + counter_integer);
		sb.append(counter_integer + " order");
		sb.append(" " + params.get("Fundid").toString());
		sb.append(" " + (params.get("Flag").toString().equals("B") ? "1" : "2"));
		sb.append(" " + params.get("Price").toString());
		sb.append(" " + params.get("Qty").toString());
		sb.append(" " + params.get("LSno").toString());
		sb.append(" " + params.get("StkCode").toString());
		sb.append(" " + params.get("Market").toString());
		sb.append(" \0");
//		String request = sb.toString();
//		byte[] sendByte = request.getBytes();
//		System.out.println(requester+"====="+request);
//
//		requester.send(sendByte);
//		byte[] reply = requester.recv(0);
//		String result = new String(reply);
//		System.out.println("�µ����" + result + counter_integer);
//
//		if(result.equals("sendorderok")) {
//			return "<result>OK</result><Ordersno>1111</Ordersno>";
//		}else if(result.contains("����Ƶ�ʹ���")) {
//			return result;
//		}else {
//			return "";
//		}
		return "<result>OK</result><Ordersno>1111</Ordersno>";
	}
	
	/**
	 * ���׵�¼
	 * @param params
	 * @return
	 */
	private String transLogin(Map<String, Object> params) {
		StringBuilder sb = new StringBuilder();
		counter_integer.getAndIncrement();
		System.out.println("��������" + counter_integer);
		sb.append(counter_integer + " login");
		sb.append(" " + params.get("Fundid"));
		sb.append(" " + params.get("Password"));
		sb.append(" \0");
//		String request = sb.toString();
//		byte[] sendByte = request.getBytes();
//		requester.send(sendByte);
//		byte[] reply = requester.recv(0);
//		String result = new String(reply);
//		System.out.println("��¼���" + result + counter_integer);
		return "<result>true</result>";
	}
	


	
	public String dealTransProcess(String transInfo) {
		Map<String, Object> xmlInfo = parseXmlText(transInfo);
		String funName = xmlInfo.containsKey("Function") ? xmlInfo.get("Function").toString()  : "";
		String flagName = xmlInfo.containsKey("Flag") ? xmlInfo.get("Flag").toString()  : "";
		String result = "";
		if(StringUtils.isNotBlank(funName) && StringUtils.isNotBlank(flagName)) {
			switch(funName) {
			case Constants.FUNCTION_TYPE_JY:
				switch(flagName) {
					case Constants.FLAG_B : case Constants.FLAG_S:
						//���ý��׷���
						{
							String callbackStrJy = transOrder(xmlInfo);
							try {
								TimeUnit.MILLISECONDS.sleep(2000);
								System.out.println("���ߣ�" + callbackStrJy);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							
							Map<String, Object> jymap = parseXmlText(callbackStrJy);
							System.out.println("====="+jymap);
							if(jymap.containsKey("result") && StringUtils.isNotBlank(jymap.get("result").toString())) {
								if(jymap.get("result").equals(Constants.RESULT_OK)) {
									StringBuilder sb = new StringBuilder();
									sb.append("<result>true</result><Records><Record><Record><Ordersno>");
									sb.append(jymap.containsKey("Ordersno") ? jymap.get("Ordersno") : "");
									sb.append("</Ordersno>");
									sb.append(transInfo);
									sb.append("</Record></Records>");
									result = sb.toString();
								}else if(jymap.get("result").equals(Constants.RESULT_ERROR)) {
									StringBuilder esb = new StringBuilder();
									esb.append("<result>false</result>");
									esb.append(transInfo);
									esb.append("<err_code>-1</err_code>");
									esb.append("<err_msg>");
									esb.append(jymap.containsKey("err_msg") ? jymap.get("err_msg") : "");
									esb.append("</err_msg>");
									result = esb.toString();
								}
							}
						}
						
						break;
					case Constants.FLAG_CD:
						{
							String callbackStrCd = "<result>true</result>";
							Map<String, Object> cdmap = parseXmlText(callbackStrCd);
							if(cdmap.containsKey("result") && StringUtils.isNotBlank(cdmap.get("result").toString())) {
								
								StringBuilder cdsb = new StringBuilder();
								cdsb.append("<result>true</result>");
								cdsb.append(transInfo);
								cdsb.append("<err_code>0</err_code><err_msg>");
								cdsb.append(cdmap.containsKey("err_msg") ? cdmap.get("err_msg") : "");
								cdsb.append("</err_msg>");
								result = cdsb.toString();
								
							}
						}
						break;
					default:
						break;
				}
				break;
			case Constants.FUNCTION_TYPE_CX:
				switch(flagName) {
				case Constants.FLAG_CXDL:
					String callbackStrCj = transLogin(xmlInfo);
					Map<String, Object> cjmap = parseXmlText(callbackStrCj);
					if(cjmap.containsKey("result") && StringUtils.isNotBlank(cjmap.get("result").toString())) {
						if(cjmap.get("result").equals(Constants.RESULT_OK)) {
							StringBuilder cjsb = new StringBuilder();
							cjsb.append("<result>true</result>");
							cjsb.append(transInfo);
							cjsb.append("<err_code>0</err_code>");
							cjsb.append("<err_msg>login ok</err_msg>");
							result = cjsb.toString();
						}else {
							StringBuilder cjsb = new StringBuilder();
							cjsb.append("<result>false</result>");
							cjsb.append("<err_code>-1</err_code>");
							cjsb.append("<err_msg>");
							cjsb.append(cjmap.get("err_msg"));
							cjsb.append("</err_msg>");
							cjsb.append(transInfo);
							result = cjsb.toString();
						}
					}
					break;
				case Constants.FLAG_CJ:
				{
					String callbackStrCx = "<result>true</result>";
					Map<String, Object> cxmap = parseXmlText(callbackStrCx);
					
					if(cxmap.containsKey("result") && StringUtils.isNotBlank(cxmap.get("result").toString())) {
						if(cxmap.get("result").equals(Constants.RESULT_OK)) {
							StringBuilder cxsb = new StringBuilder();
							cxsb.append("<result>true</result>");
							cxsb.append("<FieldsDesc>Poststr|Trddate|Stkcode|Stkname|Ordersno|Market|Matchtime|Matchqty|Matchprice|Matchtype|Orderqty|Orderprice|Matchcode|Bsflag</FieldsDesc><Records>");
							cxsb.append(cxmap.containsKey("msg") && StringUtils.isNotBlank(cxmap.get("msg").toString()) ? "<Record>" + cxmap.get("msg").toString() + "</Record>" : "");
							cxsb.append("</Records>");
							cxsb.append(transInfo);
							result = cxsb.toString();
						}else if(cxmap.get("result").equals(Constants.RESULT_ERROR)) {
							StringBuilder ecxsb = new StringBuilder();
							ecxsb.append("<result>false</result>");
							ecxsb.append(transInfo);
							ecxsb.append("<err_code>");
							ecxsb.append(cxmap.containsKey("err_code") ? cxmap.get("err_code") : "");
							ecxsb.append("</err_code>");
							ecxsb.append("<err_msg>");
							ecxsb.append(cxmap.containsKey("err_msg") ? cxmap.get("err_msg") : "");
							ecxsb.append("</err_msg>");
						}
					}
				}
					break;
				}
				break;
			default:
				break;
			}
		}

		return result;
	}
	
	//�ַ���ת��Ϊ�ֽ�
  	private  ByteBuf getSendByteBuf(String message) throws UnsupportedEncodingException {
  		byte[] req = message.getBytes("utf-8");
  		ByteBuf buf = Unpooled.buffer();
  		buf.writeBytes(req);
  		return buf;
  	}
}
