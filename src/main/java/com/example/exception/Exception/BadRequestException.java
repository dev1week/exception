package com.example.exception.Exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;
@ResponseStatus(code= HttpStatus.BAD_REQUEST, reason = "error.bad")
public class BadRequestException extends RuntimeException{

}
