package syu.gs_up.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BookController {

    @GetMapping("/building/reservation")
    public String Reservation(Model model) {
        //model.addAttribute(강의실, 호수, 시간표, 기존 예약 정보);
        return("/building/reservation");
    }
}
