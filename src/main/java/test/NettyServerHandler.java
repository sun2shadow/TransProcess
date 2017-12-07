package test;

import java.net.InetAddress;
import java.util.Date;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * 
* Title: HelloServerHandler
* Description:  �����ҵ���߼�
* Version:1.0.0  
* @author Administrator
* @date 2017-8-31
 */
public class NettyServerHandler extends ChannelInboundHandlerAdapter {
    /*
     * �յ���Ϣʱ��������Ϣ
     */
//    @Override
//    protected void channelRead0(ChannelHandlerContext ctx, String msg)
//            throws Exception {
//        // �յ���Ϣֱ�Ӵ�ӡ���
//        System.out.println("����˽��ܵ���Ϣ : " + msg);
//        if("quit".equals(msg)){//����˶Ͽ�������
//            ctx.close();
//        }
//        Date date=new Date();
//        // ���ؿͻ�����Ϣ
//        ctx.writeAndFlush(date+"\n");
//    }

	
    /*
     * ��������ʱ��������Ϣ
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("���ӵĿͻ��˵�ַ:" + ctx.channel().remoteAddress());
        ctx.writeAndFlush("�ͻ���"+ InetAddress.getLocalHost().getHostName() + "�ɹ������˽������ӣ� \n");
        super.channelActive(ctx);
    }

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
      
      ByteBuf buf = (ByteBuf)msg;  
      byte[] data = new byte[buf.readableBytes()];  
      buf.readBytes(data);  
      String request = new String(data, "utf-8"); 
      System.out.println("����˽��ܵ���Ϣ : " + request);
//      Date date=new Date();
      // ���ؿͻ�����Ϣ
      ctx.writeAndFlush(request+"\n");
	}
}
