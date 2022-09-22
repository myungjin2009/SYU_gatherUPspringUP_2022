package syu.gs_up.web.controller.building;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import syu.gs_up.web.domain.college.Book;
import syu.gs_up.web.dto.book.BookDto;
import syu.gs_up.web.dto.classRoom.ClassRoomDto;
import syu.gs_up.web.dto.lectures.LectureDto;
import syu.gs_up.web.service.building.BookService;
import syu.gs_up.web.service.building.BuildingService;
import syu.gs_up.web.service.building.ClassRoomService;
import syu.gs_up.web.service.building.LectureService;

import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
public class BuildingController {

    private final BuildingService buildingService;
    private final ClassRoomService classRoomService;
    private final LectureService lectureService;
    private final BookService bookService;

    @GetMapping("/buildings/{id}") //id = building의 pk입니다.
    public String getClassRoomInfo(@PathVariable("id") Long id, Model model) {
        String buildingName = buildingService.getBuildingName(id);
        model.addAttribute("buildingName", buildingName);   //강의실 이름

        List<ClassRoomDto> classRoomDtos = classRoomService.getClassRoomDtoByBId(id);
        model.addAttribute("classRoom",classRoomDtos);      //강의실 호수

        for(int i = 0; i < classRoomDtos.size(); i++) {                 //강의실 호수별로 예약 내역
            List<Book> book = bookService.getTimeTable(classRoomDtos.get(i).getId());
            if(!(book.isEmpty())) {
                model.addAttribute("bookList", book);
            }
        }

        return "/reservation/reservation";
    }

    @GetMapping("/classRoom/{id}")
    public String getLectureInfo(@PathVariable("id") Long id, Model model){
        List<LectureDto> lectureDtos = lectureService.getLectureDtosById(id);
        model.addAttribute("lectures",lectureDtos);
        return "/building/classRoom";
    }
}
