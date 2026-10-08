package com.project.studentManagementSystem.Exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandle {

    @ExceptionHandler(Exception.class)
    public String handleException(Exception e){
        return (e.getMessage());
    }

    @ExceptionHandler(RuntimeException.class)
    public String handleRunTimeException(RuntimeException e){
        return (e.getMessage());
    }

    @ExceptionHandler(StudentNotFoundException.class)
    public String handleStudentNotFoundException(StudentNotFoundException e){
        return (e.getMessage());
    }
}
