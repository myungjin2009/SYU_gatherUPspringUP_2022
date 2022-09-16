package syu.gs_up.web.dto.book;

import syu.gs_up.web.domain.college.ClassRoom;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

public class BookDto {

    private Long bookId;
    private String bookPurpose;
    private LocalTime bookStartTime;

    private LocalTime bookEndTime;

    private LocalDate bookDay;

    private Boolean isProlonged;

    //+StudentID 외래키도 있어야 함.
    //아직 User Entity가 없어서 추가 못함.

    public BookDto(Long bookId, String bookPurpose, LocalTime bookStartTime, LocalTime bookEndTime, LocalDate bookDay, Boolean isProlonged) {
        this.bookId = bookId;
        this.bookPurpose = bookPurpose;
        this.bookStartTime = bookStartTime;
        this.bookEndTime = bookEndTime;
        this.bookDay = bookDay;
        this.isProlonged = isProlonged;
    }
}
