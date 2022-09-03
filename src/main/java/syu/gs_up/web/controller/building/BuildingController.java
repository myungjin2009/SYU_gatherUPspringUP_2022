package syu.gs_up.web.controller.building;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import syu.gs_up.web.dto.classRoom.ClassRoomDto;
import syu.gs_up.web.dto.lectures.LectureDto;
import syu.gs_up.web.service.building.ClassRoomService;
import syu.gs_up.web.service.building.LectureService;

import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
public class BuildingController {

    private final ClassRoomService classRoomService;
    private final LectureService lectureService;

    @GetMapping("/buildings/{id}") //id = building의 pk입니다.
    public String getClassRoomInfo(@PathVariable("id") Long id,
                                   Model model) {
        List<ClassRoomDto> classRoomDtos = classRoomService.getClassRoomDtoByBId(id);
        model.addAttribute("classRoom",classRoomDtos);
        return "/building/building";
    }

    @GetMapping("/classRoom/{id}")
    public String getLectureInfo(@PathVariable("id") Long id,
                                 Model model){
        List<LectureDto> lectureDtos = lectureService.getLectureDtosById(id);
        model.addAttribute("lectures",lectureDtos);
        return "/building/classRoom";
    }
}
