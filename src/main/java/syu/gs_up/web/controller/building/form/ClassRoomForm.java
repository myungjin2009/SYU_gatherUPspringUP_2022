package syu.gs_up.web.controller.building.form;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class ClassRoomForm {

    @NotEmpty(message = "공백이 허용되지 않습니다.")
    private String name;

    @NotEmpty(message = "공백이 허용되지 않습니다.")
    private String floor;

    @NotEmpty(message = "건물은 반드시 필요합니다.")
    private String building;
}
