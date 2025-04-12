package com.igorsouza.games.handlers;

import com.igorsouza.games.exceptions.GameNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GameControllerExceptionHandler {

     @ExceptionHandler(GameNotFoundException.class)
     public ResponseEntity<String> handleGameNotFoundException(GameNotFoundException e) {
         return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
     }
}
