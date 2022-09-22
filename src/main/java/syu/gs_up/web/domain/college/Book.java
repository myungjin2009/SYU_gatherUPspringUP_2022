package syu.gs_up.web.domain.college;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import syu.gs_up.web.domain.Base;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Book extends Base {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookId;


    @Column
    private LocalTime bookStartTime;

    @Column
    private LocalTime bookEndTime;

    @Column
    private LocalDate bookDay;

    @Column
    private Boolean isProlonged;

    //+StudentID 외래키도 있어야 함.
    //아직 User Entity가 없어서 추가 못함.

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "class_room_id",nullable = false)
    private ClassRoom classRoom;

    //테스트용 생성자 입니다.
    public Book(LocalTime bookStartTime, LocalTime bookEndTime, LocalDate bookDay, Boolean isProlonged, ClassRoom classRoom) {
        this.bookStartTime = bookStartTime;
        this.bookEndTime = bookEndTime;
        this.bookDay = bookDay;
        this.isProlonged = isProlonged;
        this.classRoom = classRoom;
    }
}
