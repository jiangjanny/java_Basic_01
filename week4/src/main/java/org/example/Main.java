package org.example;

import org.example.model.User;
import org.example.service.UserService;

public class Main {

    public static void main(String[] args) {

        UserService service = new UserService();

        // 新增
        service.createUser(new User(null, "Tom", "tom@test.com"));

        // 查詢全部
        System.out.println(service.getAllUsers());

        // 查單筆
        System.out.println(service.getUser(1L));

        // 刪除
        service.deleteUser(1L);

        System.out.println("Done");
    }
}