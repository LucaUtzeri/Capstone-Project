package Luca.Utzeri.capstone.Project.exceptions;

import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(BadRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorsPayload handleBadRequest(BadRequestException bdex){
        return new ErrorsPayload(bdex.getMessage(), LocalDateTime.now());
    }

//    @org.springframework.web.bind.annotation.ExceptionHandler(NotFoundException.class)
//    @ResponseStatus(HttpStatus.NOT_FOUND)
//    public ErrorsPayload handleNotFound(NotFoundException nfex){
//        return new ErrorsPayload(nfex.getMessage(), LocalDateTime.now());
//    }
}
