package main;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class MyHandler implements HttpHandler {

    @Override
    public void handle(HttpExchange exchange) throws IOException {

        //join
        //login
        //edit
        //quit
        URI uri = exchange.getRequestURI();
        System.out.println("uri = " + uri);
        String uriStr = uri.toString();

        HashMap<String, MyHttpServlet> map = new HashMap<>();
        map.put("/app/login" , new LoginServlet());
        map.put("/app/join" , new JoinServlet());

        MyHttpServlet s = map.get(uriStr);
        s.service();


//        if(uri.toString().equals("/app/login")){
//            LoginServlet s = new LoginServlet();
//            s.service();
//        }else if(uri.toString().equals("/app/join")){
//            JoinServlet s = new JoinServlet();
//            s.service();
//        }

    }

}





















