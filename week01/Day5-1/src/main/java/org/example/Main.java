package org.example;

import com.sun.net.httpserver.HttpServer;
import java.net.InetSocketAddress;

public class Main {
    public static void main(String[] args) throws Exception {

        // 建立 Server
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);

        // 設定 /users 路徑
        server.createContext("/users", new UserHandler());

        server.setExecutor(null); // 預設執行緒池
        server.start();

        System.out.println("Server started at http://localhost:8080");
    }
}