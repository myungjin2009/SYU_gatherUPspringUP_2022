package syu.gs_up.web.controller.response;

import lombok.Data;
import org.springframework.http.HttpStatus;
import syu.gs_up.web.dto.BuildingDto;

import java.util.List;

@Data
public class BuildingResponse {

    private HttpStatus httpStatus;
    private int statusCode;
    private List<BuildingDto> buildingDtoList;

    public BuildingResponse(HttpStatus httpStatus, int statusCode, List<BuildingDto> buildingDtoList) {
        this.httpStatus = httpStatus;
        this.statusCode = statusCode;
        this.buildingDtoList = buildingDtoList;
    }
}
