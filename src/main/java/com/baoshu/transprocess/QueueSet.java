package com.baoshu.transprocess;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.LinkedBlockingQueue;

import com.baoshu.dao.model.TransLog;

import io.netty.channel.ChannelHandlerContext;

public class QueueSet {

	public static LinkedBlockingQueue<Map<String, Object>> queue = new LinkedBlockingQueue<>();
	public static LinkedBlockingQueue<ChannelHandlerContext> dataQueue = new LinkedBlockingQueue<>();
	public static ConcurrentMap<ChannelHandlerContext,Map<String, Object>> msgMap = new ConcurrentHashMap<>();
	public static LinkedBlockingQueue<TransLog> mapperQueue = new LinkedBlockingQueue<TransLog>();
}
