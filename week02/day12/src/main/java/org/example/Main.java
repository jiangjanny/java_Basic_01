package com.example;

import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class Main {

    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) throws IOException {

        logger.info("Starting server...");

        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);

        server.createContext("/hello", new MyHandler());

        server.setExecutor(null);
        server.start();

        logger.info("Server started at http://localhost:8080/hello");
    }

    static class MyHandler implements HttpHandler {

        @Override
        public void handle(HttpExchange exchange) throws IOException {

            logger.info("=== Request Start ===");

            logger.info("Method: {}", exchange.getRequestMethod());
            logger.info("URI: {}", exchange.getRequestURI());
            logger.info("Remote Address: {}", exchange.getRemoteAddress());

            String response = "Hello World";

            exchange.sendResponseHeaders(200, response.length());

            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();

            logger.info("=== Request End ===");
        }
    }
}