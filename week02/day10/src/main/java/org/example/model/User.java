package org.example.model;

public class User {

    private int id;
    private String username;
    private String password;
    private String name;

    // Login 用
    public User(String name, String password){
        this.username = username;
        this.password = password;
        this.name = username; // 暫時把 name 設成 username
    }

    //GET /user/{id} 或 query param
    public User(int id, String name){
        this.id = id;
        this.name = name;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getPassword() { return password; }
    public String getUsername() { return username; }

    @Override
    public String toString() {
        return "{ \"id\": " + id + ", \"name\": \"" + name + "\"}";
    }
}
