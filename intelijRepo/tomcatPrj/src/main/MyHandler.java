package main;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.*;
import java.net.URI;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MyHandler implements HttpHandler {

    @Override
    public void handle(HttpExchange exchange) throws IOException {

        System.out.println("MyHandler.handle called...");

        //요청받기 (요청정보)
        String rm = exchange.getRequestMethod();
        System.out.println("rm = " + rm);                   //  GET

        URI requestURI = exchange.getRequestURI();
        System.out.println("requestURI = " + requestURI);   //  test

        String protocol = exchange.getProtocol();
        System.out.println("protocol = " + protocol);       //  HTTP/1.1

        //요청받기 (헤더)
        Headers requestHeaders = exchange.getRequestHeaders();
        for (String key : requestHeaders.keySet()) {
            String value = requestHeaders.getFirst(key);
            System.out.println(key + " : " + value);
        }

        //요청받기 (바디)
        InputStream is = exchange.getRequestBody();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);

        StringBuilder sb = new StringBuilder();
        String data;
        while((data = br.readLine()) != null){
            sb.append(data);
        }
        System.out.println("sb = " + sb.toString());



        //응답하기 (상태코드, 헤더, 바디)
        String str = "<h1>hello~~~!</h1>";
        Headers responseHeaders = exchange.getResponseHeaders();
        responseHeaders.set("Content-Type", "text/html");
        exchange.sendResponseHeaders(200, str.getBytes().length);

        OutputStream os = exchange.getResponseBody();
        os.write(str.getBytes());
        os.close();

        System.out.println("handle 끝남");
    }

}
