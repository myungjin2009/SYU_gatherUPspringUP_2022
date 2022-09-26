package syu.gs_up.web.domain.college;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;

    @Column
    private String name;

    @Column(unique = true)
    private String email;

    @Column
    private String password;

    @Column
    private String nickName;

    @Column
    private Integer grade;

    @Column
    private String position;

    @OneToOne(mappedBy = "student",fetch = FetchType.LAZY)
    private Book book;

    //기본 생성자
    public Student(String name, String email, String password, String nickName, Integer grade, String position) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.nickName = nickName;
        this.grade = grade;
        this.position = position;
    }

    public String getEmail() {
        return this.email;
    }

    public void addBook(Book book){
        this.book = book;
    }
}
