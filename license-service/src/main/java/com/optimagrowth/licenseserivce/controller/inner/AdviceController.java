package com.optimagrowth.licenseserivce.controller.inner;

import com.optimagrowth.licenseserivce.api.Error;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

@RestControllerAdvice(annotations = RestController.class)
public class AdviceController {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Error> onNoSuchElementException(NoSuchElementException exception) {
        ResponseEntity.internalServerError().body(exception.getMessage());
        return ResponseEntity.internalServerError().body(Error.of(exception.getMessage()));
    }
}
