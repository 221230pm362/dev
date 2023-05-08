package main;

import java.io.OutputStreamWriter;

public class MyResponse {

    private final OutputStreamWriter writer;

    public MyResponse(OutputStreamWriter writer) {
        this.writer = writer;
    }

    public OutputStreamWriter getWriter() {
        return writer;
    }
}
