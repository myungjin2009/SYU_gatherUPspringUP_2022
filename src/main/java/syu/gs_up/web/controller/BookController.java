package syu.gs_up.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import syu.gs_up.web.domain.college.Book;
import syu.gs_up.web.domain.college.ClassRoom;
import syu.gs_up.web.domain.college.Student;
import syu.gs_up.web.service.building.BookService;
import syu.gs_up.web.service.building.ClassRoomService;

import java.time.LocalDate;
import java.time.LocalTime;

@Controller
@RequiredArgsConstructor
public class BookController {


    private final ClassRoomService classRoomService;
    private final BookService bookService;
    @PostMapping("/building/reservation")
    public String Reservation(@SessionAttribute(value = "user", required = false) Student user, String time, String classRoom, Integer buildingId) {

        LocalTime targetTime = LocalTime.of(Integer.parseInt(time),00);
        ClassRoom classRoomResult = classRoomService.getClassRoomByName(classRoom);
        Book book = new Book(targetTime, LocalDate.now(),classRoomResult, user);
        bookService.reserve(book);

        return("redirect:/buildings/"+buildingId);
    }
}
