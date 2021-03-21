package refactorizando.blog.ejemplogeneral.controller.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import refactorizando.blog.ejemplogeneral.constants.ErrorConstants;
import refactorizando.blog.ejemplogeneral.exception.ApiError;
import refactorizando.blog.ejemplogeneral.exception.user.FailedToCreateOrUpdateUser;
import refactorizando.blog.ejemplogeneral.exception.user.UserNotFoundException;

import java.time.Instant;

@RestControllerAdvice
public class UserControllerExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {UserNotFoundException.class})
    public ResponseEntity<ApiError> handleUserNotFoundException(RuntimeException exception, WebRequest request){
        ApiError apiError=createApiError(request);
        apiError.setMessage(ErrorConstants.USER_NOT_FOUND_MESSAGE);
        apiError.setStatus(HttpStatus.NOT_FOUND);
        return new  ResponseEntity<ApiError>(apiError,HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(value = {FailedToCreateOrUpdateUser.class})
    public ResponseEntity<ApiError> handleFailedToCreateUserException(RuntimeException exception,WebRequest request){
        ApiError apiError=createApiError(request);
        apiError.setMessage(ErrorConstants.FAILED_TO_CRATE_USER);
        apiError.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(apiError,HttpStatus.INTERNAL_SERVER_ERROR);
    }


    public ApiError createApiError(WebRequest request){
        ApiError apiError=new ApiError();
        apiError.setInstant(Instant.now());
        apiError.setPath(request.getContextPath());
        return  apiError;
    }
}
