package org.example;

import org.example.exception.*;
import org.example.model.ErrorResponse;
import org.example.model.User;
import org.example.service.UserService;
import org.example.util.ValidationUtils;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        UserService service = new UserService();

        try (Scanner scanner = new Scanner(System.in)) {

            while (true) {

                System.out.println("\n1. Login");
                System.out.println("2. GET /users/{id}");
                System.out.println("3. GET /users?name=Tom");
                System.out.println("0. Exit");

                System.out.print("選擇: ");
                int choice = Integer.parseInt(scanner.nextLine());

                try {
                    switch (choice) {

                        case 1:
                            System.out.print("帳號: ");
                            String username = scanner.nextLine();
                            System.out.print("密碼: ");
                            String password = scanner.nextLine();

                            ValidationUtils.validateLogin(username, password);
                            service.login(username, password);
                            break;

                        case 2:
                            System.out.print("輸入路徑 (/users/{id}): ");
                            String path = scanner.nextLine();
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

                            ValidationUtils.validateId(id);
                            User userById = service.getUserById(id);
                            System.out.println(userById);
                            break;

                        case 3:
                            System.out.print("輸入路徑 (/users?name=Tom): ");
                            String input = scanner.nextLine();
                            String[] queryParts = input.split("\\?");

                            if (queryParts.length != 2 || !"/users".equals(queryParts[0])) {
                                throw new ApiException(ErrorCode.INVALID_PATH);
                            }

                            String[] kv = queryParts[1].split("=");

                            if (kv.length != 2 || !"name".equals(kv[0])) {
                                throw new ApiException(ErrorCode.INVALID_QUERY);
                            }

                            String name = kv[1];
                            ValidationUtils.validateName(name);

                            User userByName = service.getUserByName(name);
                            System.out.println(userByName);
                            break;

                        case 0:
                            return;

                        default:
                            System.out.println("無效選項");
                    }

                } catch (ApiException e) {
                    System.out.println(new ErrorResponse(
                            e.getErrorCode().getCode(),
                            e.getErrorCode().getMessage()
                    ));
                }
            }

        } catch (Exception e) {
            System.out.println(new ErrorResponse(
                    ErrorCode.SYSTEM_ERROR.getCode(),
                    ErrorCode.SYSTEM_ERROR.getMessage()
            ));
        }
    }
}