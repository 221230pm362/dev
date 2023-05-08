package main;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

public class Main {
    public static void main(String[] args) throws IOException {

        int port = 8765;
        int backlog = 0;

        // HttpServer 생성
        HttpServer hs = HttpServer.create(new InetSocketAddress(port), backlog);

        // 컨텍스트 설정 및 핸들러 등록
        hs.createContext("/test" , new MyHandler());

        //서버 시작
        hs.start();

        System.out.println("서버 시작 됨 ...");
    }
}























