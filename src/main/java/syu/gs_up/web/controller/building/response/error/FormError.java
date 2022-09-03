package syu.gs_up.web.controller.building.response.error;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.HashMap;

@Data
public class FormError {
    private HttpStatus httpStatus;
    private int httpStatusCode;
    private HashMap<String,String> errorMap;

    public FormError(HttpStatus httpStatus, int httpStatusCode, HashMap<String, String> errorMap) {
        this.httpStatus = httpStatus;
        this.httpStatusCode = httpStatusCode;
        this.errorMap = errorMap;
    }
}
