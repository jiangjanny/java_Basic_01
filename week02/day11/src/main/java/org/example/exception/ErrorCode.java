package org.example.exception;

public enum ErrorCode {

    INPUT_EMPTY(4001, "輸入不能為空"),
    USER_NOT_FOUND(4004, "使用者不存在"),
    INVALID_PATH(4005, "Path 格式錯誤"),
    INVALID_ID(4006, "ID 格式錯誤"),
    INVALID_QUERY(4007, "Query 格式錯誤"),
    INVALID_INPUT(4008, "輸入不合法"),
    DATABASE_ERROR(5001, "資料庫錯誤"),
    SYSTEM_ERROR(9999, "系統錯誤");

    private final int code;
    private final String message;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() { return code; }
    public String getMessage() { return message; }
}