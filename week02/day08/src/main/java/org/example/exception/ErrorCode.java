package org.example.exception;

public enum  ErrorCode {
    INPUT_EMPTY(4001, "輸入不能為空"),
    USER_NOT_FOUND(4002, "找不到使用者"),
    PASSWORD_WRONG(4003, "密碼錯誤"),
    DATABASE_ERROR(5001, "資料庫錯誤"),
    SYSTEM_ERROR(9999, "系統錯誤");

    private final  int code;
    private final String message;

    ErrorCode(int code, String message){
        this.code = code;
        this.message = message;
    }

    public int getCode() {return code;}
    public String getMessage() {return message;}
}
