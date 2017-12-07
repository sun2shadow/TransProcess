package com.baoshu.transprocess;

import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import com.baoshu.common.Constants;

public class TransHelper {

	//解析xml字符串
	public static Map<String, Object> parseXmlText(String text) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			Document document = DocumentHelper.parseText("<trans>" + text + "</trans>");
			Element root = document.getRootElement();
			
			Iterator<Element> modulesIterator = root.elements().iterator(); 
			while(modulesIterator.hasNext()) {
				
				Element ele = modulesIterator.next();
				if(ele.isTextOnly()) {
					result.put(ele.getName(), ele.getTextTrim());
				}else {
					iterChilds(ele, result);
				}
				
			}
			
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public static void iterChilds(Element ele, Map<String,Object>map) {
		Iterator<Element> eles = ele.elementIterator();
		while(eles.hasNext()) {
			Element child = eles.next();
			if(child.isTextOnly()) {
				map.put(child.getName(), child.getTextTrim());
			}else {
				iterChilds(child, map);
			}
		}
	}
	public static boolean resultOk(String text) {
		Map<String,Object> map = parseXmlText(text);
		if(!map.isEmpty()) {
			String str = map.containsKey("Function") ? map.get("Function").toString() : "error";
			System.out.println(map);
			if(map.containsKey("result") && map.get("result").equals(Constants.RESULT_OK) && map.containsKey("Function") && map.get("Function").toString().equals("JY")) {
				return true;
			}
		}
		
		
		return false;
	}
	
	/**
 	 * 截取券商的名称
 	 * @param str
 	 * @return
 	 */
 	public static String getStkname(String str) {
 		String result = "";
 		if(StringUtils.isNotBlank(str)) {
 			String[] strArray = str.split("\\|");
 			try {
 				result = strArray[3];
 			}catch(ArrayIndexOutOfBoundsException e) {
 				
 			}
 		}
 		return result;
 	}
 	
 	
 	//将汉字转化为base64
 	
 	public static String charToBase64(String str) {
 		String result = "";
 		try {
			result = Base64.getEncoder().encodeToString(str.getBytes("GBK"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		return result;
 	}
 	
  	/**
  	 * 处理消息之前的字节数
  	 * @param str
  	 * @return
  	 */
 	public static String dealCount(String str) {
  		long count = str.getBytes().length;
  		String s = count + "";
  		long num = s.length();
  		StringBuilder sb = new StringBuilder();
  		if(num < 8) {
  			for(int i = 8; i >=0; i--) {
  				if(i < (8 - num)) {
  					sb.append("0");
  				}
  			}
  			sb.append(count);
  		}
  		return sb.toString();
  	}

 	
}
