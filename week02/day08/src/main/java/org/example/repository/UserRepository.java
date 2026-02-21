package org.example.repository;

import org.example.exception.DatabaseException;
import org.example.model.User;

public class UserRepository {

    public User findByUsername(String username) throws DatabaseException {

        if (Math.random() < 0.2) {
            throw new DatabaseException("資料庫連線失敗");
        }

        if ("admin".equals(username)) {
            return new User("admin", "1234");
        }

        return null;
    }
}