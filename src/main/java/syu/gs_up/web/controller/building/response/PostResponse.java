package syu.gs_up.web.controller.building.response;

import lombok.Data;
import org.springframework.http.HttpStatus;

/**
 * 일반적인 POST 요청에 사용되는 Response입니다.
 * 입력 값에 문제가 없다면 해당 Response 객체를 통한 응답을 보내주시면 됩니다.
 */
@Data
public class PostResponse {

    private HttpStatus httpStatus;
    private String message;
    private int httpStatusCode;

    public PostResponse(HttpStatus httpStatus, String message, int httpStatusCode) {
        this.httpStatus = httpStatus;
        this.message = message;
        this.httpStatusCode = httpStatusCode;
    }
}
