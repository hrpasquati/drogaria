package br.com.pasquati.Drogaria.resources.exception;

import br.com.pasquati.Drogaria.services.exception.DataIntegrityException;
import br.com.pasquati.Drogaria.services.exception.ObjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler { //Classe responsavel por intercptar caso ocorra uma excessao

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandartError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request) {
        StandartError standartError = new StandartError(HttpStatus.NOT_FOUND.value(), e.getMessage(), System.currentTimeMillis());
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(standartError);
    }

    @ExceptionHandler(DataIntegrityException.class)
    public ResponseEntity<StandartError> dataIntegrity(DataIntegrityException e, HttpServletRequest request){
        StandartError standartError = new StandartError(HttpStatus.BAD_REQUEST.value(), e.getMessage(), System.currentTimeMillis());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(standartError);
    }

}
