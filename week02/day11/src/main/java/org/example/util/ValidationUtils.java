package org.example.util;

import org.example.exception.ApiException;
import org.example.exception.ErrorCode;

public class ValidationUtils {

    public static void validateLogin(String username, String password) {

        if (username == null || username.trim().isEmpty()
                || password == null || password.trim().isEmpty()) {
            throw new ApiException(ErrorCode.INPUT_EMPTY);
        }
    }

    public static void validateId(int id) {
        if (id <= 0) {
            throw new ApiException(ErrorCode.INVALID_INPUT);
        }
    }

    public static void validateName(String name) {
        if (name == null || name.trim().length() < 2) {
            throw new ApiException(ErrorCode.INVALID_INPUT);
        }
    }
}