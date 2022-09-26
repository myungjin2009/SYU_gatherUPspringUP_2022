package syu.gs_up.web.controller.building.form;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalTime;

@Data
public class LectureForm {

    private String lectureName;
    private String professor;

    @NotNull(message = "강의 시작 시간을 입력해주세요.")
    @Range(min = 9,max = 19)
    private LocalTime startTime;

    @NotNull(message = "강의 종료 시간을 입력해주세요.")
    @Range(min = 9,max = 19)
    private LocalTime endTime;

    @NotEmpty
    @Length(max = 1,message = "요일을 제외하고 입력해주세요.")
    private String lectureDay;

}
