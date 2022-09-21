package syu.gs_up.web.dto.board;

import syu.gs_up.web.domain.college.Board;
import syu.gs_up.web.domain.college.Student;

import javax.persistence.Column;
import java.util.List;

public class BoardDto {

    private String title;

    private String content;

    private String purpose;

    private Boolean isDone;

    private Student student;

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getPurpose() {
        return purpose;
    }

    public Boolean getDone() {
        return isDone;
    }

    public Student getStudent() {
        return student;
    }


    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public void setDone(Boolean done) {
        isDone = done;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public BoardDto(String title, String content, String purpose, Boolean isDone, Student student) {
        this.title = title;
        this.content = content;
        this.purpose = purpose;
        this.isDone = isDone;
        this.student = student;
    }
}
