package syu.gs_up.web.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import syu.gs_up.web.controller.building.form.StudentForm;
import syu.gs_up.web.domain.college.EmailAuth;
import syu.gs_up.web.domain.college.Student;
import syu.gs_up.web.dto.student.StudentBook;
import syu.gs_up.web.global.ex.SessionEmptyEx;
import syu.gs_up.web.service.building.StudentService;

import java.util.Objects;
import java.util.Optional;

import static java.lang.Integer.parseInt;


@Controller
@RequiredArgsConstructor
@Slf4j
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/join")
    public String signUp(){
        return "login/Join";
    }

    @GetMapping("/login")
    public String login(){
        return "login/Login";
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

    @ResponseBody
    @PostMapping("/verifyAuthNumber") //html - 확인 버튼
    public ResponseEntity verifyEmail(@RequestParam String email, @RequestParam String authNumber) {
        //TODO 넘어온 인증번호가 일치하는지 확인
        EmailAuth emailAuth = new EmailAuth(email, parseInt(authNumber));
        Optional<EmailAuth> result = studentService.verifyNumber(emailAuth);
        if(result.isPresent()) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.badRequest().body("인증번호가 불일치합니다.");
        }


    }

    //TODO 이름, 이메일, 비밀번호, 닉네임, 포지션, 학년 필드로 변경하기!!
    //TODO join.html에 현재 학년 태그가 없습니다. 추가 부탁드립니다.
    //  AJAX 작성도 해놨습니다. 거기에 따로 학년 값 받아오는거 추가해주세요.
    @ResponseBody
    @PostMapping("/register")
    public ResponseEntity Register(@RequestBody StudentForm studentForm) {
        Student student = new Student
                (
                        studentForm.getName(),
                        studentForm.getEmail(),
                        studentForm.getPassword(),
                        studentForm.getNickName(),
                        studentForm.getGrade(),
                        studentForm.getPosition()
                );

        //TODO 하드코딩 문자열은 지양하는게 좋습니다.
        if(studentService.isDuplicateEmail(studentForm.getEmail())){
            return ResponseEntity.badRequest().body("이미 가입된 이메일입니다.");
        }else{
            studentService.join(student);
            return ResponseEntity.ok().body("가입되었습니다.");
        }
    }


    @GetMapping("/my-page")
    public String myPage(Model model,@SessionAttribute(value = "user",required = false) Student student) {
        if(Objects.isNull(student)){
            throw new SessionEmptyEx();
        }

        StudentBook studentBook = studentService.getStudentDataWithBookInfo(student.getStudentId());
        model.addAttribute("student",studentBook);
        return "/member/account";
    }
}
