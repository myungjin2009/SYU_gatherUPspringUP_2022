package syu.gs_up.web.domain.member;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Student {
//@NoArgsConstructor
    @Id @GeneratedValue
    private long studentId;

    @Column@NotEmpty
    private String email;
    @Column@NotEmpty
    private String password;

    @Column
    private String nickname;

    @Column
    private String grade;
    @Column
    private String username;

    public Student(String email, String password, String nickname, String grade, String username) {
        this.email = email;
        this.password = password;
        this.nickname = nickname;
        this.grade = grade;
        this.username = username;
    }
}

