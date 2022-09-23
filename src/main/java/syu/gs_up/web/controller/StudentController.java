package syu.gs_up.web.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import syu.gs_up.web.controller.building.form.StudentForm;
import syu.gs_up.web.domain.college.Student;
import syu.gs_up.web.dto.student.LoginForm;
import syu.gs_up.web.service.building.StudentService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@Slf4j
public class StudentController {

    private final StudentService studentService;


    @GetMapping("/signUp")
    public String signUp(){
        return "/login/Join";
    }

    @GetMapping("/login")
    public String login(){
        return "/login/Login";
    }

    @PostMapping("/login")
    public String loginSuccess(LoginForm principal, HttpServletRequest req){
        log.info("userInputData = {}",principal.getId());
        log.info("userInputData = {}",principal.getPw());
        Optional<Student> user = studentService.login(principal);

        if(user.isPresent()){
            Student student = user.get();
            HttpSession session = req.getSession(true);
            session.setAttribute("user",student);
            return "redirect:/";
        }else{
            return "/login";
        }
    }

    @ResponseBody
    @PostMapping("/test")
    public String test(@RequestBody LoginForm form){
        log.info("input = {}",form.getId());
        return "success";
    }


    @ResponseBody
    @PostMapping("/sendAuthNumber") //html - 인증번호 받기 버튼
    public void checkEmail(@RequestParam String email) {
        //TODO 이메일이 DB에 존재하는지 확인
        //Boolean result = studentService.isAlreadyJoined(email);;

        Boolean result = studentService.sendVerificationNumber(email);
        if(result) {
            System.out.println("메일을 보냈습니다.");
        }
    }

    @PostMapping("/verifyAuthNumber") //html - 확인 버튼
    public String verifyEmail(String vNumber) {
        //TODO 넘어온 인증번호가 일치하는지 확인
        //TODO 일치하면 회원가입 통과

        return null;
    }


    //TODO 이름, 이메일, 비밀번호, 닉네임, 포지션, 학년 필드로 변경하기!!
    @ResponseBody
    @PostMapping("/register")
    public String Register(StudentForm studentForm, Model model) {
        Student student = new Student
                (
                        studentForm.getName(),
                        studentForm.getEmail(),
                        studentForm.getPassword(),
                        studentForm.getNickName(),
                        studentForm.getGrade(),
                        studentForm.getPosition()
                );

        try{
            studentService.join(student);
        }catch(IllegalAccessException e){
            log.error("controller ex");
            return "중복";
        }
        return "가입되셨습니다.";

//
//        model.addAttribute("isSuccess", list.get(0));
//        model.addAttribute("reason", list.get(1));

//        return "/login/registerSuccessful";
    }
}
