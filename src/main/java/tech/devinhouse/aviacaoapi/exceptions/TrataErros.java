package tech.devinhouse.aviacaoapi.exceptions;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TrataErros {
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Void> trataErro404() {
        return ResponseEntity.notFound().build();
    }
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Void> trataErro400(){
        return ResponseEntity.badRequest().build();
    }

}