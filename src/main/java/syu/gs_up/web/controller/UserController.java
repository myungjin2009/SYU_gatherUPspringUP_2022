package syu.gs_up.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import syu.gs_up.web.domain.member.Student;
import syu.gs_up.web.service.UserService;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/user/join")
    public String join() {
        return "/member/joinjoin";
    }
//회원가입후 로그인화면으로 이동
    @PostMapping ("/user/join")
    public String join(Student student) {
        this.userService.join(student);
        return "/member/login";
    }
//    @GetMapping("/user/login")
//    public String login(){
//        return "/member/login";
//    }

//    @PostMapping("login")
//    public String login(Student student, HttpSession session) throws Exception{
//        student = userService.login(student);
//        if(student != null) {
//            session.setAttribute("student", student);        }
//        return "home";
//    }
//@PostMapping("/user/login")
//public String logIn(String inputEmail, String inputPassword) {
//    //login.info("id : {} , pw : {}", inputEmail, inputPassword);
//    Student student = this.student.findMember(inputEmail, inputPassword);
//    if(student != null) {
//        return "/member/loginok";
//    }
//    return "loginFail";
//}


//    @PostMapping ("/user/login")
//    public String login(Student student,Model model){
//        System.out.println("student="+student);
//        Student student=userService.loginUser(student.getEmail(),student.getPassword());
//        if(student==null){
//            model.addAttribute("loginMessage","아이디 혹은 비밀번호가 잘못되었습니다");
//            return "user/login";
//        }
//        model.addAttribute("nickname",student.getNickname());
//        return "home";
//    }

}

