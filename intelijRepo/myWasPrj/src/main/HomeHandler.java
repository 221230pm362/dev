package main;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class HomeHandler implements HttpHandler {

    @Override
    public void handle(HttpExchange exchange) throws IOException {

        //응답하기
        String data = "<h1>HOME~!</h1>";
        exchange.sendResponseHeaders(200 , data.getBytes().length);

        OutputStream os = exchange.getResponseBody();
        OutputStreamWriter writer = new OutputStreamWriter(os);
        MyResponse resp = new MyResponse(writer);

        resp.getWriter().write("~~~");
    }

}
