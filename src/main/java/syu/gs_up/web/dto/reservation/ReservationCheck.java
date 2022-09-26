package syu.gs_up.web.dto.reservation;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalTime;

@Getter
@Setter
@ToString
public class ReservationCheck {

    private Long buildingId;

    private LocalTime start_time;

    private String classRoom;

    public void setStart_time(int start_time) {
        this.start_time = LocalTime.of(start_time, 0);
    }
}
