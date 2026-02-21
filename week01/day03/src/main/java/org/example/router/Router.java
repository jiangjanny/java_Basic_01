package org.example.router;

import com.sun.net.httpserver.HttpServer;
import org.example.handler.UsersHandler;
// import org.example.handler.PingHandler;
// import org.example.handler.HelloHandler;

public class Router {

    public static void register(HttpServer server) {
        server.createContext("/users", new UsersHandler());
//        server.createContext("/ping", new PingHandler());
//        server.createContext("/hello", new HelloHandler());
    }
}
