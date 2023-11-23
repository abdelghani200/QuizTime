package com.QuizTime.QuizTime.config;

import com.QuizTime.QuizTime.exception.CustomException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public Map<String, String> handleException(Exception e) {
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("error", e.getMessage());
        return errorMap;
    }

    @ExceptionHandler(CustomException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public Map<String, String> handleCustomException(CustomException e) {
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("error", e.getMessage());
        return errorMap;
    }

}
