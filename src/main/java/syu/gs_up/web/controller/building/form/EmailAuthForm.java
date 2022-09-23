package syu.gs_up.web.controller.building.form;


import lombok.Data;

@Data
public class EmailAuthForm {

    private String authEmail;

    private Integer authNumber;

    public String getAuthEmail() {
        return authEmail;
    }

    public Integer getAuthNumber() {
        return authNumber;
    }

    public void setAuthEmail(String authEmail) {
        this.authEmail = authEmail;
    }

    public void setAuthNumber(Integer authNumber) {
        this.authNumber = authNumber;
    }

    public EmailAuthForm(String authEmail, Integer authNumber) {
        this.authEmail = authEmail;
        this.authNumber = authNumber;
    }
}
