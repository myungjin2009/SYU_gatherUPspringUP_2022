package syu.gs_up.web.dto.lectures;

import lombok.Data;

import java.time.LocalTime;

@Data
public class LectureDto {

    private String lectureName;
    private String professor;
    private String lectureDay;

    private LocalTime startTime;
    private LocalTime endTime;

    public LectureDto(String lectureName, String professor, String lectureDay, LocalTime startTime, LocalTime endTime) {
        this.lectureName = lectureName;
        this.professor = professor;
        this.lectureDay = lectureDay;
        this.startTime = startTime;
        this.endTime = endTime;
    }
}
