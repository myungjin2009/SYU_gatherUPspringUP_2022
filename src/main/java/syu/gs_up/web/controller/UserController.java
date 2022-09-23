package syu.gs_up.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import syu.gs_up.web.domain.member.Student;
import syu.gs_up.web.service.UserService;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/user/join")
    public String join() {
        return "/main/join";
    }

    @PostMapping ("/user/join")
    public String join(Student student) {
        this.userService.join(student);
        return "login";
    }
}
//    @GetMapping("/auth/login")
//    public String login() {
//        return "/user/user-login";
//    }}

