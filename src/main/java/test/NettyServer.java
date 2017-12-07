package test;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.Delimiters;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
public class NettyServer {
    private static final int port = 8087; //���÷���˶˿�
    private static  EventLoopGroup group = new NioEventLoopGroup();   // ͨ��nio��ʽ���������Ӻʹ�������   
    private static  ServerBootstrap b = new ServerBootstrap();

    /**
     * Netty����ȫ������ʵ����AbstractBootstrap��
     * �ͻ��˵���Bootstrap������˵�����    ServerBootstrap��
     **/
    public static void main(String[] args) throws InterruptedException {
        try {
            b.group(group);
            b.channel(NioServerSocketChannel.class);
            b.childHandler(new ChannelInitializer<SocketChannel>() {
                @Override
                public void initChannel(SocketChannel ch) throws Exception {
               	 ch.pipeline().addLast("framer", new DelimiterBasedFrameDecoder(8192, Delimiters.lineDelimiter()));
//               	 ch.pipeline().addLast(new StringDecoder());
//               	 ch.pipeline().addLast(new StringEncoder());
               	 ch.pipeline().addLast(new NettyServerHandler());
                }
            }); //���ù�����
            // �������󶨶˿ڼ���
            ChannelFuture f = b.bind(port).sync();
            System.out.println("����������ɹ�...");
            // �����������رռ���
            f.channel().closeFuture().sync();
        } finally {
            group.shutdownGracefully(); ////�ر�EventLoopGroup���ͷŵ�������Դ�����������߳�  
        }
    }
}
