package biz.galaxygroup.atn.mno.exceptions;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(value = {HandlerConflictException.class})
    protected ResponseEntity<Object> handleApiRequestException(HandlerConflictException e) {
        ApiException apiException = new ApiException();
        apiException.setTimestamp(ZonedDateTime.now(ZoneId.of("Z")).toString());
        apiException.setStatus(HttpStatus.CONFLICT.toString());
        apiException.setError(e.getMessage());
        return new ResponseEntity<>(apiException, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(value = {HandlerNotFoundException.class})
    protected ResponseEntity<Object> handleApiRequestException(HandlerNotFoundException e) {
        ApiException apiException = new ApiException();
        apiException.setTimestamp(ZonedDateTime.now(ZoneId.of("Z")).toString());
        apiException.setStatus(HttpStatus.NOT_FOUND.toString());
        apiException.setError(e.getMessage());
        return new ResponseEntity<>(apiException, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = {HandlerBadRequestException.class})
    protected ResponseEntity<Object> handleApiRequestException(HandlerBadRequestException e) {
        ApiException apiException = new ApiException();
        apiException.setTimestamp(ZonedDateTime.now(ZoneId.of("Z")).toString());
        apiException.setStatus(HttpStatus.BAD_REQUEST.toString());
        apiException.setError(e.getMessage());
        return new ResponseEntity<>(apiException, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {HandlerInternalServerErrorException.class})
    protected ResponseEntity<Object> handleApiRequestException(HandlerInternalServerErrorException e) {
        ApiException apiException = new ApiException();
        apiException.setTimestamp(ZonedDateTime.now(ZoneId.of("Z")).toString());
        apiException.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.toString());
        apiException.setError(e.getMessage());
        return new ResponseEntity<>(apiException, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = {HandlerAuthorizationException.class})
    protected ResponseEntity<Object> handleApiRequestException(HandlerAuthorizationException e) {
        ApiException apiException = new ApiException();
        apiException.setTimestamp(ZonedDateTime.now(ZoneId.of("Z")).toString());
        apiException.setStatus(HttpStatus.UNAUTHORIZED.toString());
        apiException.setError(e.getMessage());
        return new ResponseEntity<>(apiException, HttpStatus.UNAUTHORIZED);
    }

}