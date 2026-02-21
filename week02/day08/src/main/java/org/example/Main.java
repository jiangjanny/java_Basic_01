package org.example;

import org.example.exception.*;
import org.example.model.ErrorResponse;
import org.example.service.UserService;

import java.util.Scanner;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        UserService service = new UserService();

        try{
            System.out.print("請輸入帳號: ");
            String username = scanner.nextLine();

            System.out.print("請輸入密碼: ");
            String password = scanner.nextLine();

            service.login(username, password);
        }catch (ApiException e) {

            ErrorResponse error = new ErrorResponse(
                    e.getErrorCode().getCode(),
                    e.getErrorCode().getMessage()
            );

            System.out.print(error);
        }finally {
            System.out.print("程式結束");
        }
    }
}