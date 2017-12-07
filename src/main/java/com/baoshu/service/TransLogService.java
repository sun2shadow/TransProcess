package com.baoshu.service;

import com.baoshu.dao.model.TransLog;

public interface TransLogService {

	public int add(String params);
	
	public TransLog get(String ordersNo);
}
