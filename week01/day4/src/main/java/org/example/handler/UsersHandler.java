package org.example.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import org.example.model.User;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UsersHandler implements HttpHandler {

    private final ObjectMapper mapper = new ObjectMapper();

    @Override
    public void handle(HttpExchange exchange) throws IOException {

        // 1. 假資料（Java 物件）
        List<User> users = new ArrayList<>();
        users.add(new User(1, "Tom", "tom@test.com"));
        users.add(new User(2, "Mary", "mary@test.com"));

        // 2. 核心魔法：物件 → JSON
        String json = mapper.writeValueAsString(users);

        // 3. 回傳 HTTP
        byte[] response = json.getBytes();
        exchange.getResponseHeaders().add("Content-Type", "application/json");
        exchange.sendResponseHeaders(200, response.length);
        exchange.getResponseBody().write(response);
        exchange.close();
    }
}
