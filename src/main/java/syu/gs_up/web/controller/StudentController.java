package syu.gs_up.web.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import syu.gs_up.web.controller.building.form.StudentForm;
import syu.gs_up.web.domain.college.Student;
import syu.gs_up.web.service.building.StudentService;

import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
public class StudentController {

    private final StudentService studentService;


    @GetMapping("/signUp")
    public String signUp(){
        return "/login/Join";
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

        List<String> list = studentService.join(student);

        model.addAttribute("isSuccess", list.get(0));
        model.addAttribute("reason", list.get(1));

        return "/login/registerSuccessful";
    }
}
