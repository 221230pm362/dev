package main;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

public class Main {
    public static void main(String[] args) throws IOException {

        int port = 8765;
        int backlog = 0;

        // 서버 생성
        HttpServer server = HttpServer.create(new InetSocketAddress(port), backlog);

        // 컨텍스트 설정
        server.createContext("/home", new HomeHandler());

        // 서버 실행
        server.start();

        System.out.println("server started ...");
    }
}