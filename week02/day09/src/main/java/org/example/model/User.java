package org.example.model;

public class User {

    private int id;
    private String username;
    private String password;
    private String name;

    // 登入用
    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.name = username; // 可用 username 當 name
    }

    // GET /users/{id} 用
    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getPassword() { return password; }
    public String getUsername() { return username; }
}