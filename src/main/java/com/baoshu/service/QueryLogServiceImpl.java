package com.baoshu.service;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import com.baoshu.dao.mapper.QueryLogMapper;
import com.baoshu.dao.model.QueryLog;
import com.baoshu.dao.model.QueryLogExample;

import java.text.ParseException;
import java.text.SimpleDateFormat;
@Component("TransLogService")
public class QueryLogServiceImpl implements QueryLogService{

	@Autowired
	private QueryLogMapper mapper;
	@Override
	public int add(QueryLog queryLog) throws DataAccessException {
		return 0;
	}

	@Override
	public Map<String, Object> totalMoneyAndAmount(String ordersNo) throws DataAccessException {
		return mapper.totalMoneyAndAmount(ordersNo);
	}

	@Override
	public List<QueryLog> list(String fundid, int poststr) throws DataAccessException {
		QueryLogExample example = new QueryLogExample();
		QueryLogExample.Criteria criteria = example.createCriteria();
		criteria.andFundidEqualTo(fundid);
		
		if(Objects.nonNull(poststr))
			criteria.andPostStrGreaterThan(poststr);
		
		SimpleDateFormat myFmt1 = new SimpleDateFormat("yyyy-MM-dd"); 
		String today = myFmt1.format(new Date());
		SimpleDateFormat myFmt2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		try {
			Date startDate = myFmt2.parse(today + " 09:00:00");
			criteria.andCreateDateGreaterThan(startDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return mapper.selectByExample(example);
	}

	@Override
	public String query(String fundid, int poststr) throws DataAccessException {
		List<QueryLog> list = list(fundid, poststr);
		
		return null;
	}

}
