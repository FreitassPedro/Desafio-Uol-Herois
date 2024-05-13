package com.pedro.desafiouolherois.expcetions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

@RestControllerAdvice
@Slf4j
public class ExceptionManager {

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> handleNoSuchElementExcpetion(NoSuchElementException e) {
        log.info("Entidade não encontrada", e);

        return ResponseEntity.badRequest().body(e.getMessage());
    }
}
