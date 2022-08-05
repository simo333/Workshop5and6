package pl.workshop5.exception;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(value = EmptyResultDataAccessException.class)
    public ResponseEntity<ApiException> handleEmptyResultDataAccessException(EmptyResultDataAccessException e) {
        ApiException apiException = new ApiException(
                e.getMessage(),
                HttpStatus.NOT_FOUND
        );
        return new ResponseEntity<>(apiException, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(value = HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<ApiException> handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
        System.out.println(Arrays.toString(e.getSupportedMethods()));
        ApiException apiException = new ApiException(
                e.getMessage(),
                HttpStatus.NOT_FOUND
        );
        return new ResponseEntity<>(apiException, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(value = HttpMessageNotReadableException.class)
    public ResponseEntity<ApiException> handleHttpMessageNotReadableException(HttpMessageNotReadableException e) {
        String message = "Required request body is missing";
        ApiException apiException = new ApiException(
                message,
                HttpStatus.NOT_FOUND
        );
        return new ResponseEntity<>(apiException, HttpStatus.NOT_FOUND);
    }



}
