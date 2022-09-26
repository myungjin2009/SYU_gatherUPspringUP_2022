package syu.gs_up.web.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import syu.gs_up.web.domain.college.Book;
import syu.gs_up.web.domain.college.ClassRoom;
import syu.gs_up.web.domain.college.Student;
import syu.gs_up.web.dto.reservation.ReservationCheck;
import syu.gs_up.web.service.building.BookService;
import syu.gs_up.web.service.building.ClassRoomService;
import syu.gs_up.web.service.building.LectureService;

import java.time.LocalDate;
import java.time.LocalTime;

@Controller
@RequiredArgsConstructor
@Slf4j
public class BookController {


    private final ClassRoomService classRoomService;
    private final BookService bookService;

    private final LectureService lectureService;

    @PostMapping("/building/reservation")
    public String Reservation(@SessionAttribute(value = "user", required = false) Student user, String time, String classRoom, Integer buildingId) {

        LocalTime targetTime = LocalTime.of(Integer.parseInt(time), 00);
        ClassRoom classRoomResult = classRoomService.getClassRoomByName(classRoom);
        Book book = new Book(targetTime, LocalDate.now(), classRoomResult, user);
        bookService.reserve(book);

        return ("redirect:/buildings/" + buildingId);
    }

    @DeleteMapping("/book/{bookId}/cancel")
    public ResponseEntity bookCancel(@PathVariable("bookId") Long bookId) {
        bookService.cancelBook(bookId);

        return ResponseEntity.ok().body("예약이 취소되었습니다.");
    }

    @ResponseBody
    @PostMapping("/building/reservationCheck")
    public ResponseEntity reservationCheck(@RequestBody ReservationCheck reservationCheck){
        log.info("reservation = {}",reservationCheck);

        if(lectureService.findExistingLecture(reservationCheck)){
            return ResponseEntity.badRequest().body("존재하는 강의가 있습니다.");
        }else{
            return ResponseEntity.ok().build();
        }
    }
}
