package syu.gs_up.web.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import syu.gs_up.web.domain.college.Book;
import syu.gs_up.web.domain.college.ClassRoom;
import syu.gs_up.web.domain.college.Student;
import syu.gs_up.web.dto.reservation.ReservationCheck;
import syu.gs_up.web.service.building.BookService;
import syu.gs_up.web.service.building.ClassRoomService;
import syu.gs_up.web.service.building.LectureService;

import java.time.LocalDate;

@Controller
@RequiredArgsConstructor
@Slf4j
public class BookController {


    private final ClassRoomService classRoomService;
    private final BookService bookService;

    private final LectureService lectureService;

    @ResponseBody
    @PostMapping("/building/reservation")
    public ResponseEntity Reservation(@SessionAttribute(value = "user", required = false) Student user,
                              @RequestBody ReservationCheck reservationCheck) {

        ClassRoom classRoomResult = classRoomService.getClassRoomByName(reservationCheck.getClassRoom());
        Book book = new Book(reservationCheck.getStart_time(), LocalDate.now(), classRoomResult, user);
        bookService.reserve(book);

        return ResponseEntity.ok().body(reservationCheck.getBuildingId());
    }

    @DeleteMapping("/book/{bookId}/cancel")
    public ResponseEntity bookCancel(@PathVariable("bookId") Long bookId) {
        bookService.cancelBook(bookId);

        return ResponseEntity.ok().body("예약이 취소되었습니다.");
    }

    @ResponseBody
    @PostMapping("/building/reservationCheck")
    public ResponseEntity reservationCheck(@RequestBody ReservationCheck reservationCheck) {
        log.info("reservation = {}", reservationCheck);

        if (lectureService.findExistingLecture(reservationCheck)) {
            return ResponseEntity.badRequest().body("존재하는 강의가 있습니다.");
        } else {
            return ResponseEntity.ok().build();
        }
    }
}
