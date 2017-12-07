package test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.baoshu.dao.mapper.TransLogMapper;
import com.baoshu.dao.model.TransLog;
import com.baoshu.service.TransLogService;

public class Test {

	private static TransLogService transLogService;
	private static ApplicationContext ctx=null;  

	public static void main(String[] args) {
		
		 
	        ctx = new ClassPathXmlApplicationContext(  
	                "classpath:/applicationContext-dao.xml");  
	        transLogService = (TransLogService) ctx  
	                .getBean("transLogService");     
	        System.out.println(transLogService);
		String str = "<result>true</result><Records><Record><Ordersno>0010000351</Ordersno><Function>JY</Function><Flag>B</Flag><Fundid>58200001</Fundid><ChildFundid>001</ChildFundid><StkCode>000001</StkCode><Qty>100</Qty><Price>13.02</Price><Market>SZ</Market><QSFlag>XBZQ</QSFlag><LSno>001000035</LSno><DivideOrderno>1</DivideOrderno><RequsetID>31</RequsetID></Record></Records>";
		//		transLogService.add(str);
//		System.out.println(parseXmlText(str));
		
	}

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
}
