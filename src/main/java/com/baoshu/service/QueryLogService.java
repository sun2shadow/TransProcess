package com.baoshu.service;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.baoshu.dao.model.QueryLog;

public interface QueryLogService {

	public int add(QueryLog queryLog) throws DataAccessException;
	
	public List<QueryLog> list(String fundid, int poststr) throws DataAccessException;
	public String query(String fundid, int poststr) throws DataAccessException;
	public Map<String, Object> totalMoneyAndAmount(String ordersNo) throws DataAccessException;
}
