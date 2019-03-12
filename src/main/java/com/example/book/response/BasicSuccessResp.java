package com.example.book.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class BasicSuccessResp extends HttpResponse {

    private boolean success = true;

    private String message;

    public String getMessage() {
        return message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public BasicSuccessResp withMessage(String message) {
        this.message = message;
        return this;
    }

    public BasicSuccessResp withSuccess(boolean success) {
        this.success = success;
        return this;
    }

}
