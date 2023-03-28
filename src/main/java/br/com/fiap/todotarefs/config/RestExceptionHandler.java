package br.com.fiap.todotarefs.config;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.Loader;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.fiap.todotarefs.models.RestError;

@RestControllerAdvice
public class RestExceptionHandler {

    Logger log = LoggerFactory.getLogger(RestExceptionHandler.class);

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<RestValidationError>> MethodArgumentNotValidExceptionHandle(){
        log.error("erro de argumento inválido");
        List<RestValidationError> errors = new ArrayList<>();
        errors.add(new RestValidationError(400, "descricao", "não deve ser vazio"))
        return ResponseEntity.badRequest().body(errors);
    }
}
