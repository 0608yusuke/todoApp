package Yusuke.todo.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice
public class ExceptionControllerAdvice {
    private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionControllerAdvice.class);

    @ExceptionHandler({TodoException.class})
    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    @ResponseBody
    public String handleException(TodoException e) {
        LOGGER.error("TodoException", e);
        return "error!";
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {

        LOGGER.info("InitBinder");
    }



    public static class TodoException extends RuntimeException {}
    public static class Todo2Exception extends RuntimeException {}
}