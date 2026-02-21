package org.example.service;

import org.example.exception.*;
import org.example.model.User;
import org.example.repository.UserRepository;

public class UserService {

    private final UserRepository repository = new UserRepository();

    // Login
    public void login(String username, String password) {

        if (username == null || password == null) {
            throw new ApiException(ErrorCode.INPUT_EMPTY);
        }

        try {
            User user = repository.findByUsername(username);

            if (user == null) throw new ApiException(ErrorCode.USER_NOT_FOUND);
            if (!user.getPassword().equals(password)) throw new ApiException(ErrorCode.PASSWORD_WRONG);

            System.out.println("登入成功！");

        } catch (DatabaseException e) {
            throw new ApiException(ErrorCode.DATABASE_ERROR);
        }
    }

    // Path param
    public User getUserById(int id) {
        try {
            User user = repository.findById(id);
            if (user == null) throw new ApiException(ErrorCode.USER_NOT_FOUND);
            return user;
        } catch (DatabaseException e) {
            throw new ApiException(ErrorCode.DATABASE_ERROR);
        }
    }

    // Query param
    public User getUserByName(String name) {
        if (name == null || name.isEmpty()) {
            throw new ApiException(ErrorCode.INVALID_QUERY);
        }

        try {
            User user = repository.findByName(name);
            if (user == null) throw new ApiException(ErrorCode.USER_NOT_FOUND);
            return user;
        } catch (DatabaseException e) {
            throw new ApiException(ErrorCode.DATABASE_ERROR);
        }
    }
}