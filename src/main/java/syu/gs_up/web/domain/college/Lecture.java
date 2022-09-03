package syu.gs_up.web.domain.college;

import lombok.Getter;

import javax.persistence.*;
import java.time.LocalTime;

@Entity
@Getter
public class Lecture {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long lectureId;

    @Column(nullable = false)
    private int startTime;

    @Column(nullable = false)
    private int endTime;

    @Column(nullable = false)
    private boolean isAvailable;

    private String professor;

    private String lectureName;

}
