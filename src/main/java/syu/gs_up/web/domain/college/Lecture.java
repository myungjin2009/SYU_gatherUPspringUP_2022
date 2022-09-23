package syu.gs_up.web.domain.college;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Lecture {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long lectureId;

    @Column(nullable = false)
    private int startTime;

    @Column(nullable = false)
    private int endTime;

    private String professor;

    private String lectureName;

    @Column(nullable = false)
    private String lectureDay;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "class_room_id")
    private ClassRoom classRoom;

    public Lecture(int startTime, int endTime, String professor, String lectureName, String lectureDay,ClassRoom classRoom) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.professor = professor;
        this.lectureName = lectureName;
        this.lectureDay = lectureDay;
        this.classRoom = classRoom;
    }
}
