package syu.gs_up.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import syu.gs_up.web.controller.response.BuildingResponse;
import syu.gs_up.web.dto.BuildingDto;
import syu.gs_up.web.service.BuildingService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MainApiController {

    private final BuildingService buildingService;

    @GetMapping("/buildings")
    public ResponseEntity<BuildingResponse> getAllBuildings(){
        List<BuildingDto> buildingDtos = buildingService.getAllBuildingDtos();
        BuildingResponse buildingResponse = new BuildingResponse(HttpStatus.OK, HttpStatus.OK.value(), buildingDtos);
        return new ResponseEntity<>(buildingResponse,buildingResponse.getHttpStatus());
    }

}
