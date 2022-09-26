package syu.gs_up.web.dto.student;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;

@Getter
@Setter
@Builder
public class StudentBook {

    private Long id;
    private String nickname;
    private String position;
    private Integer grade;

    private LocalTime bookStart;
    private LocalTime bookEndTime;

    private String classRoomName;

    private String buildingName;
}
