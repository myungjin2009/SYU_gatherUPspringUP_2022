package syu.gs_up.web.controller.building;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TESTmypageController {

    @GetMapping("/myPage2")
    public String TESTmypage() {
        return "member/MyPage2";
    }
}
