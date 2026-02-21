package org.example.handler;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import org.example.model.User;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UsersHandler implements HttpHandler {

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        // 1. 假資料
        List<User> users = new ArrayList<>();
        users.add(new User(1, "Tom", "tom@test.com"));
        users.add(new User(2, "Mary", "mary@test.com"));
        users.add(new User(3, "John", "john@test.com"));

        // 2. 先用最土法：自己拼 JSON（Day4 再改 Jackson）
        StringBuilder json = new StringBuilder();
        json.append("[");

        for (int i = 0; i < users.size(); i++) {
            User u = users.get(i);
            json.append("{")
                    .append("\"id\":").append(u.getId()).append(",")
                    .append("\"name\":\"").append(u.getName()).append("\",")
                    .append("\"email\":\"").append(u.getEmail()).append("\"")
                    .append("}");
            if (i < users.size() - 1) json.append(",");
        }

        json.append("]");

        byte[] response = json.toString().getBytes();
        exchange.getResponseHeaders().add("Content-Type", "application/json");
        exchange.sendResponseHeaders(200, response.length);
        exchange.getResponseBody().write(response);
        exchange.close();
    }
}
