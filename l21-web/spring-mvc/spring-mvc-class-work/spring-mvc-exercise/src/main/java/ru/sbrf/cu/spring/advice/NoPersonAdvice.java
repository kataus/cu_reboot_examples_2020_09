package ru.sbrf.cu.spring.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.NoSuchElementException;

@ControllerAdvice
public class NoPersonAdvice {
    @ExceptionHandler(value = {NoSuchElementException.class})
    public ResponseEntity<Object> noPerson(RuntimeException ex, WebRequest request){
        ResponseEntity<Object> result = new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        result.getHeaders().add("some mine", "my ");
        return result;
    }
}
