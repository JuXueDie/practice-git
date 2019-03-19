package com.example.book.utils;

import com.example.book.response.BasicSuccessResp;
import com.example.book.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static com.example.book.utils.ResponseErrorCode.BAD_REQUEST;

public class Utils {

    public static BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    public static ResponseEntity<?> getResponseEntity(boolean result) {
        if (!result) {
            ErrorResponse errorResponse = new ErrorResponse(BAD_REQUEST);
            return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
        }
        BasicSuccessResp resp = new BasicSuccessResp();
        resp.setSuccess(true);
        return ResponseEntity.ok(resp);
    }
}
