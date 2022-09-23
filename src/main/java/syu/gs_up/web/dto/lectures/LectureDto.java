package syu.gs_up.web.dto.lectures;

import lombok.Data;

@Data
public class LectureDto {

    private String lectureName;
    private String professor;
    private String lectureDay;

    private int startTime;
    private int endTime;

    public LectureDto(String lectureName, String professor, String lectureDay, int startTime, int endTime) {
        this.lectureName = lectureName;
        this.professor = professor;
        this.lectureDay = lectureDay;
        this.startTime = startTime;
        this.endTime = endTime;
    }
}
