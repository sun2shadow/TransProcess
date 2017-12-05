package com.baoshu.transprocess;

import java.util.HashMap;
import java.util.Map;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;


public class TransServerHandler extends ChannelInboundHandlerAdapter {

	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		System.out.println("channelActivedfhtguhjyttji!" + ctx.channel().read());
		super.channelActive(ctx);
	}

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		System.out.println("channelRead");
		ByteBuf buf = (ByteBuf)msg;  
        byte[] data = new byte[buf.readableBytes()];  
        buf.readBytes(data);  
        String request = new String(data, "utf-8");
        System.out.println(request);
//        String result = dealTransProcess(request);
        Map<String, Object> params = new HashMap<>();
        params.put("ctx", ctx);
        params.put("info", request);
        TransInterfaceProcess.queue.add(params);
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
