package com.baoshu.transprocess;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;


public class TransServerHandler extends ChannelInboundHandlerAdapter {

	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		System.out.println("channelActive!" + ctx.channel().read());
		super.channelActive(ctx);
	}

	Map<Long, String> conMap = new ConcurrentHashMap<Long, String>();
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		System.out.println("channelRead");
//		ByteBuf buf = (ByteBuf)msg;  
//		ctx.channel().remoteAddress();
//		ctx.channel().isActive();
//		ctx.channel().read
//        byte[] b = new byte[8];
//        buf.readBytes(b);
//        int totalLong = new Integer(new String(b,"utf-8")); 
//        System.out.println(totalLong);
        
//        byte[] data = new byte[buf.readableBytes()];  
//        buf.readBytes(data);  
//        String request = new String(data, "utf-8");
//        System.out.println(request);
//        int iReceiveLength = data.length;
        
//        while(data.length < totalLong) {
//        	 byte[] bufferLeft = new byte[totalLong - iReceiveLength];
//        	 
//        }
//        String result = dealTransProcess(request);
        Map<String, Object> params;
        ByteBuf buf = (ByteBuf)msg;

//        byte[] msgByte  ;
        if(TransInterfaceProcess.msgMap.containsKey(ctx)) {
        	params = TransInterfaceProcess.msgMap.get(ctx);
        	ByteBuf oldBuf = (ByteBuf) params.get("info");
        	oldBuf.writeBytes(buf);
        	params.put("info", oldBuf);
//        	msgByte = (byte[]) params.get("info");
//        	buf.readBytes(msgByte, msgByte.length - 1, buf.readableBytes());
        }else {
        	params = new HashMap<>();
        	params.put("info", buf);
//        	msgByte = new byte[buf.readableBytes()];
//        	buf.readBytes(msgByte);
        }
        params.put("ctx", ctx);
        
        TransInterfaceProcess.msgMap.put(ctx, params);
        TransInterfaceProcess.dataQueue.put(ctx);
	}


	@Override
	public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
//		ctx.writeAndFlush(Unpooled.EMPTY_BUFFER).addListener(ChannelFutureListener.CLOSE);;
	}


	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
//		cause.printStackTrace();
//		ctx.close();
	}



}
