package syu.gs_up.web.global.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import syu.gs_up.web.global.ex.SessionEmptyEx;

@ControllerAdvice
public class SessionHandler {

    @ExceptionHandler
    public String sessionHandler(SessionEmptyEx e){
        return "redirect:/login";
    }
}
