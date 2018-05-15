package com.demo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.*;

/**
 * @Author wb-hx347246
 * @Date 2018/5/15 16:45
 */
public class HelloWorld {

    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("d:/ubuntu-16.04.3-desktop-amd64.iso");
        FileChannel channel = fis.getChannel();
        ByteBuffer buff = ByteBuffer.allocate(1024*1024*1024);

        Selector selector = Selector.open();

        ServerSocketChannel serverSocketChannel=ServerSocketChannel.open();

        ServerSocket socket = serverSocketChannel.socket();

        socket.bind(new InetSocketAddress(10001));

        SelectionKey register = serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        int select = selector.select();


        int read = channel.read(buff);

        buff.flip();
        System.out.println(read);
    }
}
