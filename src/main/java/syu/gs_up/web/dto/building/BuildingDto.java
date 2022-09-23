package syu.gs_up.web.dto.building;

import lombok.Data;

@Data
public class BuildingDto {

    private Long id;

    private String name;

    private String intro;

    private String latitude;

    private String longitude;

    public BuildingDto(Long id, String name, String intro, String latitude, String longitude) {
        this.id = id;
        this.name = name;
        this.intro = intro;
        this.latitude = latitude;
        this.longitude = longitude;
    }
}
