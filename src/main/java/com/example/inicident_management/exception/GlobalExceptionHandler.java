package com.example.inicident_management.exception;

import com.example.inicident_management.dto.ResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
@ExceptionHandler(UserException.class)
    public ResponseEntity<ResponseDto> handleUserException(UserException exception, WebRequest request){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseDto(HttpStatus.BAD_REQUEST.toString(),exception.getMessage()));

    }
    @ExceptionHandler(IncidentException.class)
    public ResponseEntity<ResponseDto> handleIncidentException(IncidentException exception, WebRequest request){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseDto(HttpStatus.BAD_REQUEST.toString(),exception.getMessage()));

    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseDto> handleOtherException(Exception exception,WebRequest request){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseDto(HttpStatus.INTERNAL_SERVER_ERROR.toString(),"Somethin Went Wrong Please Try Again Later"));
    }
}
