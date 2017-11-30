package com.baoshu.transprocess;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.apache.commons.lang3.StringUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import com.baoshu.common.Constants;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.Constant;
import io.netty.util.ReferenceCountUtil;

public class TransServerHandler extends ChannelInboundHandlerAdapter {

	
	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {

	}

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
//		ByteBuf buf = (ByteBuf) msg;  
//		String recieved = getMessage(buf);  
		String body = (String)msg;
        System.out.println("服务器接收到消息：" + body);
        
        try {
        	String result = dealTransProcess(body);
        	ctx.writeAndFlush(getSendByteBuf(result + "$_"));
        }catch(UnsupportedEncodingException e) {
        	e.printStackTrace();
        }
	}

	@Override
	public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
		ctx.flush();
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		cause.printStackTrace();
		ctx.close();
	} 

	//字节转化为字符串
	private String getMessage(ByteBuf buf) {
		byte[] con = new byte[buf.readableBytes()];
		buf.readBytes(con);
		try {
			return new String(con, "utf-8");
		}catch (UnsupportedEncodingException e) {  
            e.printStackTrace();  
            return null;  
        } 
	}
	//字符串转化为字节
	private ByteBuf getSendByteBuf(String message) throws UnsupportedEncodingException {
		byte[] req = message.getBytes("utf-8");
		ByteBuf buf = Unpooled.buffer();
		buf.writeBytes(req);
		return buf;
	}
	//解析xml字符串
	private Map<String, Object> parseXmlText(String text) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			Document document = DocumentHelper.parseText("<trans>" + text + "</trans>");
			Element root = document.getRootElement();
			
			Iterator<Element> modulesIterator = root.elements().iterator(); 
			while(modulesIterator.hasNext()) {
				Element ele = modulesIterator.next();
//				System.out.println(ele.getName() + ":" + ele.getTextTrim());
				result.put(ele.getName(), ele.getTextTrim());
			}
			
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
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
						//调用交易方法
						{
							String callbackStrJy = "<result>OK</result><Ordersno>1111</Ordersno>";
							Map<String, Object> jymap = parseXmlText(callbackStrJy);
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
			default:
				break;
			}
		}

		return result;
	}
	
}
