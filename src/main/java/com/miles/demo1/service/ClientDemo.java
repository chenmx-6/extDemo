package com.miles.demo1.service;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @Classname SendFile
 * @Description TODO
 * @Date 2021-8-26 18:24
 * @Created by ChenMX
 */
public class ClientDemo {
    public static void main(String[] args) throws Exception {
        //输入对方接收的ip地址和端口号
        Socket socket = new Socket(InetAddress.getByName("127.0.0.1"), 9000);
        //创建输出流
        OutputStream outputStream = socket.getOutputStream();
        //创建接受文件流
        FileInputStream fileInputStream = new FileInputStream(new File("D:\\Downloads\\文档\\XBOM系统\\小鹏全员沟通会.txt"));
        //创建缓冲数组
        byte[] buffer = new byte[1024];
        int len = 0;
        //循环输出
        while ((len = fileInputStream.read(buffer)) != -1) {
            outputStream.write(buffer, 0, len);
        }
        socket.shutdownOutput();//告诉服务器，已经传输完毕，可以向下执行代码

        //接收来自于服务端的信息
        InputStream inputStream = socket.getInputStream();
        //需要用到管道流Bytearray来接收
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        //创建缓冲区数组
        byte[] buffer2 = new byte[1024];
        int len2 = 0;
        while ((len2 = inputStream.read(buffer2)) != -1) {
            baos.write(buffer2, 0, len2);
        }
        System.out.println(baos.toString());

        baos.close();
        inputStream.close();
        fileInputStream.close();
        outputStream.close();
        socket.close();
    }

}

