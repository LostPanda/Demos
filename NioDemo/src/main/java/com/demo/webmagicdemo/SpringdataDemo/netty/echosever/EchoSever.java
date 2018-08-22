package com.demo.webmagicdemo.SpringdataDemo.netty.echosever;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import java.net.InetSocketAddress;

/**
 * @Author wb-hx347246
 * @Date 2018/5/16 10:10
 */
public class EchoSever {
//    private String host;
    private final int port;

    EchoSever(int port){
        this.port=port;
    }

    public void start() throws Exception{
        NioEventLoopGroup group = new NioEventLoopGroup();

        try {
            ServerBootstrap b = new ServerBootstrap();

            b.group(group)
                    .channel(NioServerSocketChannel.class)
                    .localAddress(new InetSocketAddress(port))
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            socketChannel.pipeline().addLast(new EchoSeverHandler());
                        }
                    });

            ChannelFuture sync = b.bind().sync();
            System.out.println("Echo server is ready! start listen on port"+sync.channel().localAddress());
            sync.channel().closeFuture().sync();
        } finally {
            group.shutdownGracefully().sync();
        }

    }
}
