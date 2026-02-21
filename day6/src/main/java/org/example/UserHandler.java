package org.example;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserHandler implements HttpHandler {

    private final List<User> users = new ArrayList<>();
    private int nextId = 1;

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String method = exchange.getRequestMethod();
        String path = exchange.getRequestURI().getPath();
        String response = "";
        int statusCode = 200;

        try {
            switch (method) {
                case "GET":
                    response = handleGet(path);
                    statusCode = response.equals("User not found") ? 404 : 200;
                    break;
                case "POST":
                    response = handlePost(exchange);
                    statusCode = response.startsWith("{") ? 201 : 400;
                    break;
                case "PUT":
                    response = handlePut(exchange, path);
                    statusCode = response.startsWith("{") ? 200 : 404;
                    break;
                case "DELETE":
                    statusCode = handleDelete(path);
                    response = "";
                    break;
                default:
                    response = "Method Not Allowed";
                    statusCode = 405;
            }
        } catch (Exception e) {
            response = "Internal Server Error: " + e.getMessage();
            statusCode = 500;
        }

        exchange.sendResponseHeaders(statusCode, response.getBytes().length);
        OutputStream os = exchange.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }

    private String handleGet(String path) {
        if (path.equals("/users")) {
            StringBuilder sb = new StringBuilder("[");
            for (int i = 0; i < users.size(); i++) {
                sb.append(users.get(i).toJson());
                if (i < users.size() - 1) sb.append(",");
            }
            sb.append("]");
            return sb.toString();
        }

        String[] parts = path.split("/");
        if (parts.length == 3) {
            int id = Integer.parseInt(parts[2]);
            Optional<User> user = users.stream().filter(u -> u.getId() == id).findFirst();
            return user.map(User::toJson).orElse("User not found");
        }
        return "Invalid GET path";
    }

    // POST / PUT 用簡單 form-data: name=xxx&email=xxx
    private String handlePost(HttpExchange exchange) throws IOException {
        String body = new String(exchange.getRequestBody().readAllBytes()).trim();

        // 去掉 { } 和 "
        body = body.replace("{", "").replace("}", "").replace("\"", "");
        String[] kvs = body.split(",");
        String name = null, email = null;
        for (String kv : kvs) {
            String[] pair = kv.split(":");
            if (pair.length < 2) continue;
            if (pair[0].trim().equals("name")) name = pair[1].trim();
            if (pair[0].trim().equals("email")) email = pair[1].trim();
        }

        if (name == null || email == null) return "Invalid body: must include name and email";

        User user = new User(nextId++, name, email);
        users.add(user);
        return user.toJson();
    }

    private String handlePut(HttpExchange exchange, String path) throws IOException {
        String[] pathParts = path.split("/");
        if (pathParts.length != 3) return "Invalid PUT path";

        int id = Integer.parseInt(pathParts[2]);
        Optional<User> optUser = users.stream().filter(u -> u.getId() == id).findFirst();
        if (optUser.isEmpty()) return "User not found";

        User user = optUser.get();

        byte[] bodyBytes = exchange.getRequestBody().readAllBytes();
        String body = new String(bodyBytes).trim();
        String[] parts = body.split("&");
        for (String kv : parts) {
            String[] pair = kv.split("=");
            if (pair[0].equals("name")) user.setName(pair[1]);
            if (pair[0].equals("email")) user.setEmail(pair[1]);
        }
        return user.toJson();
    }

    private int handleDelete(String path) {
        String[] parts = path.split("/");
        if (parts.length != 3) return 400;

        int id = Integer.parseInt(parts[2]);
        boolean removed = users.removeIf(u -> u.getId() == id);
        return removed ? 204 : 404;
    }
}