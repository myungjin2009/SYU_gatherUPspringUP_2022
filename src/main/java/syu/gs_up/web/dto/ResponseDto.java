package syu.gs_up.web.dto;

import lombok.Data;

@Data
public class ResponseDto {

    private String head;
    private String body;


    public String getHead() {
        return head;
    }

    public String getBody() {
        return body;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
