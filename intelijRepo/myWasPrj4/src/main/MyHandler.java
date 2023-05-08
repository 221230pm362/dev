package main;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.util.HashMap;

public class MyHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {

        //요청받기 (요청라인, 헤더, 바디)
        String requestMethod = exchange.getRequestMethod();
        URI uri = exchange.getRequestURI();
        String protocol = exchange.getProtocol();

        HashMap<String, MyServlet> servletMap = new HashMap<>();
        servletMap.put("/app/login" , new LoginServlet());
        servletMap.put("/app/join" , new JoinServlet());

        String uriStr = uri.toString();
        MyServlet o = servletMap.get(uriStr);
        if(o == null){
            exchange.sendResponseHeaders(404, 0);
            return;
        }

        //클라가 보낸 데이터 읽어서 처리
        InputStream is = exchange.getRequestBody();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);
        StringBuilder sb = new StringBuilder();
        while(true){
            String str = br.readLine();
            if(str == null){break;}
            sb.append(str);
        }
        String data = sb.toString();
        System.out.println("data = " + data);

        HashMap<String, String> paramMap = new HashMap<>();
        
        String[] paramArr = data.split("&");
        for (String temp : paramArr) {
            String[] param = temp.split("=");
            String key = param[0];
            String value = param[1];
            paramMap.put(key, value);
        }
        System.out.println("paramArr = " + paramMap);
        

        MyRequest req = new MyRequest(paramMap);
        MyResponse resp = new MyResponse();
        o.service(req , resp);

        //응답하기 (상태코드, 헤더, 바디)
        exchange.sendResponseHeaders(200, 0);

    }
}
