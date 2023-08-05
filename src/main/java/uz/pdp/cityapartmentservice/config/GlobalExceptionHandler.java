package uz.pdp.cityapartmentservice.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import uz.pdp.cityapartmentservice.exceptions.DataNotFound;
import uz.pdp.cityapartmentservice.exceptions.NotAcceptable;
import uz.pdp.cityapartmentservice.exceptions.RequestValidationException;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = {NotAcceptable.class})
    public ResponseEntity<String> notAcceptable(NotAcceptable e) {
        return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(value = {DataNotFound.class})
    public ResponseEntity<String> dataNotFound(DataNotFound e){
        return new  ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = {RequestValidationException.class})
    public ResponseEntity<String> validation(RequestValidationException e){
        return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_ACCEPTABLE);
    }
}
