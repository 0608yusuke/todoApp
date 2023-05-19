package Yusuke.todo.controller;


import Yusuke.todo.entity.Todo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice
public class ExceptionControllerAdvice {
    private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionControllerAdvice.class);

    @ExceptionHandler({TodoException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public String handleException(TodoException e) {
        LOGGER.warn("TodoException", e);
        return "error!!";
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {

        LOGGER.info("InitBinder");
    }
    @ModelAttribute
    public void modelAttribute(Todo model) {
        LOGGER.info("ModelAttribute");
        }
    public static void warn(String msg) {
        LOGGER.warn(msg);
    }



    public static class TodoException extends RuntimeException {}
}