package syu.gs_up.web.domain.college;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;

    @Column
    private String name;

    @Column
    private String email;

    @Column
    private String password;

    @Column
    private String nickName;

    @Column
    private Integer grade;

    //기본 생성자
    public Student(String name, String email, String password, String nickName, Integer grade) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.nickName = nickName;
        this.grade = grade;
    }

    public String getEmail() {
        return this.email;
    }
}
