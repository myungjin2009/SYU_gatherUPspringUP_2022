package syu.gs_up.web.dto.classRoom;

import lombok.Data;

@Data
public class ClassRoomDto {

    private Long id;
    private String name;
    private String floor;

    public ClassRoomDto(Long id, String name, String floor) {
        this.id = id;
        this.name = name;
        this.floor = floor;
    }
}
