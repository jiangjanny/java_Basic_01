package org.example;

import com.sun.net.httpserver.HttpServer;
import org.example.router.Router;

import java.io.IOException;
import java.net.InetSocketAddress;

public class Main {

    public static void main(String[] args) throws IOException {

        // 1. 建立一個 HTTP Server，監聽 8080 port
        HttpServer server = HttpServer.create(
                new InetSocketAddress(8080), 0
        );

        // 2. 註冊所有路由 (/ping, /hello, /users)
        Router.register(server);

        // 3. 啟動 server
        server.start();

        System.out.println("Server started at http://localhost:8080");
    }
}
