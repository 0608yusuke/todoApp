package Yusuke.todo.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionControllerAdvice {
    private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionControllerAdvice.class);

    @ExceptionHandler({TodoException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public  String todoError(TodoException e, Model model) {
        LOGGER.warn("TodoException", e);
        return "/error/404";
}
    @ExceptionHandler({HttpRequestMethodNotSupportedException.class})
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    public String notFileError(HttpRequestMethodNotSupportedException e, Model model){
        LOGGER.warn("HttpRequestMethodNotSupportedException", e);
        return "/error/405";
    }
    @ExceptionHandler({Exception.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String Exception(Exception e, Model model){
        LOGGER.error("Exception", e);
        return "500";
}

    public static class TodoException extends RuntimeException {}
}