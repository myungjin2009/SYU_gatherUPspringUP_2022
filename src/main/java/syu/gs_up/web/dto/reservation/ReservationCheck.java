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

    private String start_time;

    private String classRoom;

//    public void setStart_time(String start_time) {
//        String[] split = start_time.split(":");
//        this.start_time = LocalTime.of(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
//    }
}
