package com.example.book.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class HttpResponse {

    @JsonInclude(Include.NON_NULL)
    private ErrorResponse error;

    //FIXME 欄位用意為何？
    //FIXME dummy定義的欄位 用意未知
    private String requestId;

    public HttpResponse() {
    }

    public ErrorResponse getError() {
        return error;
    }

    public void setError(ErrorResponse error) {
        this.error = error;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }
}