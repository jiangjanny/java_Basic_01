package org.example;

import org.example.exception.*;
import org.example.model.ErrorResponse;
import org.example.model.User;
import org.example.service.UserService;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        UserService service = new UserService();

        try {

            System.out.print("請輸入路徑 (例如: /users/1): ");
            String path = scanner.nextLine();

            // 解析 Path
            String[] parts = path.split("/");

            if (parts.length != 3 || !"users".equals(parts[1])) {
                throw new ApiException(ErrorCode.INVALID_PATH);
            }

            int id;

            try {
                id = Integer.parseInt(parts[2]);
            } catch (NumberFormatException e) {
                throw new ApiException(ErrorCode.INVALID_ID);
            }

            User user = service.getUserById(id);
            System.out.println(user);

        } catch (ApiException e) {

            ErrorResponse error = new ErrorResponse(
                    e.getErrorCode().getCode(),
                    e.getErrorCode().getMessage()
            );

            System.out.println(error);

        } catch (Exception e) {

            ErrorResponse error = new ErrorResponse(
                    ErrorCode.SYSTEM_ERROR.getCode(),
                    ErrorCode.SYSTEM_ERROR.getMessage()
            );

            System.out.println(error);
        }
    }
}