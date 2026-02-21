package org.example.service;

import org.example.exception.*;
import org.example.model.User;
import org.example.repository.UserRepository;


public class UserService {

    private final UserRepository repository = new UserRepository();

    public void login(String username, String password) {

        if (username == null || password == null) {
            throw new ApiException(ErrorCode.INPUT_EMPTY);
        }

        try {
            User user = repository.findByUsername(username);

            if(user == null){
                throw new ApiException(ErrorCode.USER_NOT_FOUND);
            }

            if(!user.getPassword().equals(password)){
                throw new ApiException(ErrorCode.PASSWORD_WRONG);
            }

            System.out.println("登入成功!");
        } catch (DatabaseException e) {
            throw new ApiException(ErrorCode.DATABASE_ERROR);
        }
    }
}
