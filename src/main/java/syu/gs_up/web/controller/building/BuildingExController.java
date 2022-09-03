package syu.gs_up.web.controller.building;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import syu.gs_up.web.controller.building.exception.FormException;
import syu.gs_up.web.controller.building.response.error.FormError;

@RestControllerAdvice
@Slf4j
public class BuildingExController {

    @ExceptionHandler
    public ResponseEntity<FormError> formErrorResponse(FormException e){
        FormError errorResponse = new FormError(HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.value(), e.getErrorMap());
        return new ResponseEntity<>(errorResponse,errorResponse.getHttpStatus());
    }
}
