package org.example;

import com.sun.net.httpserver.HttpServer;
import org.example.handler.HelloHandler;

import java.net.InetSocketAddress;

public class Main {
    public static void main(String[] args) throws Exception {
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);

        server.createContext("/hello", new HelloHandler());

        server.start();
        System.out.println("Server started at http://localhost:8080/hello");
    }
}
