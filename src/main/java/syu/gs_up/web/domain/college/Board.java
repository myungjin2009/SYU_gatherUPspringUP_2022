package syu.gs_up.web.domain.college;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import syu.gs_up.web.domain.Base;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Board extends Base {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;

    @Column
    private String title;

    @Column
    private String content;

    @Column
    private String purpose;

    @Column
    private Boolean isDone;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    public Board(String title, String content, String purpose, Boolean isDone, Student student) {
        this.title = title;
        this.content = content;
        this.purpose = purpose;
        this.isDone = isDone;
        this.student = student;
    }
}
