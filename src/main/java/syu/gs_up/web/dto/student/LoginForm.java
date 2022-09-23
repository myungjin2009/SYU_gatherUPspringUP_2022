package syu.gs_up.web.dto.student;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class LoginForm {

    private String id;
    private String pw;

    public LoginForm(String id, String pw) {
        this.id = id;
        this.pw = pw;
    }
}
