package com.baoshu.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;
import com.baoshu.common.Constants;
import com.baoshu.dao.mapper.TransLogMapper;
import com.baoshu.dao.model.TransLog;
import com.baoshu.dao.model.TransLogExample;
import com.baoshu.transprocess.QueueSet;
import com.baoshu.transprocess.TransHelper;


@Component("transLogService")
public class TransLogServiceImpl implements TransLogService {

	@Autowired
	private TransLogMapper transMapper;
	@Override
	public int add(String params) throws DataAccessException{
		Map<String,Object> map = TransHelper.parseXmlText(params);
		if(map.containsKey("result") && map.get("result").equals(Constants.RESULT_OK)) {
			TransLog transLog = new TransLog();
			transLog.setFlag(map.get("Flag").toString());
			transLog.setFundid(map.get("Fundid").toString());
			transLog.setChildFundid(map.get("ChildFundid").toString());
			transLog.setStkCode(map.get("StkCode").toString());
			transLog.setQty(Integer.parseInt(map.get("Qty").toString()));
			transLog.setPrice(new BigDecimal(map.get("Price").toString()));
			transLog.setMarket(map.get("Market").toString());
			transLog.setQsflag(map.get("QSFlag").toString());
			transLog.setLsno(map.get("LSno").toString());
			transLog.setDevideOrderNo(map.get("DivideOrderno").toString());
			transLog.setRequestId(map.get("RequsetID").toString());
			transLog.setOrdersNo(map.get("LSno").toString()+map.get("DivideOrderno").toString());
			transLog.setIsDone(false);
			int count = transMapper.insert(transLog);
			if(count > 0) {
				try {
					System.out.println("=====trans"+transLog.getId());
					QueueSet.mapperQueue.put(transLog);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		return 0;
		
	}
	@Override
	public TransLog get(String ordersNo) {
		TransLogExample example = new TransLogExample();
		TransLogExample.Criteria criteria = example.createCriteria();
		criteria.andOrdersNoEqualTo(ordersNo);
		List<TransLog> transLog = transMapper.selectByExample(example);
		if(!transLog.isEmpty())
			return transLog.get(0);
		return null;
	}

}
