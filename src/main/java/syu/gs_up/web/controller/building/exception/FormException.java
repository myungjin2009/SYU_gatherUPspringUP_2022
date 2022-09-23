package syu.gs_up.web.controller.building.exception;
import lombok.Getter;
import java.util.HashMap;

@Getter
public class FormException extends RuntimeException{

    private HashMap<String,String> errorMap;
    public FormException() {
    }

    public FormException(HashMap<String,String> errorMap){
        this.errorMap = errorMap;
    }
}
