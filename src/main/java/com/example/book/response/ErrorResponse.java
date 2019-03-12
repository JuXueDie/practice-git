package com.example.book.response;

import com.example.book.utils.ResponseErrorCode;

public class ErrorResponse {
    private int code;
    private String message;
    private String comment;

    public ErrorResponse() {
    }

    public ErrorResponse(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public ErrorResponse(ResponseErrorCode code) {
        this(code.getCode(), code.getMessage());
    }

    public int getCode() {
        return code;
    }

    public String getComment() {
        return comment;
    }

    public String getMessage() {
        return message;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}