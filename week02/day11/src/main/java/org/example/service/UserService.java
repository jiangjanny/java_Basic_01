package org.example.service;

import org.example.exception.*;
import org.example.model.User;
import org.example.repository.UserRepository;

public class UserService {

    private final UserRepository repository = new UserRepository();

    public void login(String username, String password) {

        try {
            User user = repository.findByUsername(username);

            if (user == null) {
                throw new ApiException(ErrorCode.USER_NOT_FOUND);
            }

            if (!user.getPassword().equals(password)) {
                throw new ApiException(ErrorCode.INVALID_INPUT);
            }

            System.out.println("登入成功");

        } catch (DatabaseException e) {
            throw new ApiException(ErrorCode.DATABASE_ERROR, e);
        }
    }

    public User getUserById(int id) {

        try {
            User user = repository.findById(id);

            if (user == null) {
                throw new ApiException(ErrorCode.USER_NOT_FOUND);
            }

            return user;

        } catch (DatabaseException e) {
            throw new ApiException(ErrorCode.DATABASE_ERROR, e);
        }
    }

    public User getUserByName(String name) {

        try {
            User user = repository.findByName(name);

            if (user == null) {
                throw new ApiException(ErrorCode.USER_NOT_FOUND);
            }

            return user;

        } catch (DatabaseException e) {
            throw new ApiException(ErrorCode.DATABASE_ERROR, e);
        }
    }
}