package main;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.*;
import java.net.URI;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class KhHandler implements HttpHandler {

    @Override
    public void handle(HttpExchange exchange) throws IOException {

        //클라이언트가 보낸 요청 확인하기

        //요청라인 (메소드, 경로, 프로토콜)
        String requestMethod = exchange.getRequestMethod();
        System.out.println("requestMethod = " + requestMethod);

        URI requestURI = exchange.getRequestURI();
        System.out.println("requestURI = " + requestURI);

        String protocol = exchange.getProtocol();
        System.out.println("protocol = " + protocol);

        //헤더
        Headers requestHeaders = exchange.getRequestHeaders();
        Set<String> keySet = requestHeaders.keySet();
        Iterator<String> it = keySet.iterator();
        while(it.hasNext()){
            String key = it.next();
            String value = requestHeaders.getFirst(key);
            System.out.println(key + " : " + value);
        }
//        for (String key : requestHeaders.keySet()) {
//            String value = requestHeaders.getFirst(key);
//            System.out.println(key + " : " + value);
//        }

        //바디
        InputStream is = exchange.getRequestBody();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);

        StringBuilder sb = new StringBuilder();
        String str = "";
        while((str = br.readLine()) != null){
            sb.append(str);
        }
        System.out.println("sb.toString() = " + sb.toString());


        //응답하기 (상태코드,헤더,바디)
        String respStr = "hello";
        //헤더
        Headers responseHeaders = exchange.getResponseHeaders();
        responseHeaders.set("tomorrow","osaka");
        //상태코드 + 헤더 (Content-Length)
        exchange.sendResponseHeaders(200 , respStr.getBytes().length);

        //바디
        OutputStream os = exchange.getResponseBody();
        OutputStreamWriter osw = new OutputStreamWriter(os);
        osw.write(respStr);
        osw.close();

    }

}
