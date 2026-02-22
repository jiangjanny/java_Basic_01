package org.example.repository;

import org.example.exception.DatabaseException;
import org.example.model.User;

public class UserRepository {

    public User findByUsername(String username) throws DatabaseException {

        if (Math.random() < 0.1) {
            throw new DatabaseException("資料庫連線失敗");
        }

        if ("admin".equals(username)) {
            return new User(1, "admin", "1234", "Admin");
        }

        return null;
    }

    public User findById(int id) throws DatabaseException {

        if (Math.random() < 0.1) {
            throw new DatabaseException("資料庫錯誤");
        }

        if (id == 1) {
            return new User(1, "admin", "1234", "Admin");
        }

        return null;
    }

    public User findByName(String name) throws DatabaseException {

        if (Math.random() < 0.1) {
            throw new DatabaseException("資料庫錯誤");
        }

        if ("Tom".equalsIgnoreCase(name)) {
            return new User(2, "tom", "1111", "Tom");
        }

        return null;
    }
}