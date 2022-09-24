package syu.gs_up.web.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import syu.gs_up.web.domain.college.Student;
import syu.gs_up.web.dto.student.LoginForm;
import syu.gs_up.web.service.building.StudentService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@Slf4j
public class LoginController {

    private final StudentService studentService;

    @PostMapping(value = "/login")
    public ResponseEntity loginSuccess(@RequestBody LoginForm principal, HttpServletRequest req){
        log.info("userInputData = {}",principal.getId());
        log.info("userInputData = {}",principal.getPw());
        Optional<Student> user = studentService.login(principal);

        if(user.isPresent()){
            Student student = user.get();
            HttpSession session = req.getSession(true);
            session.setAttribute("user",student);
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.badRequest().body("아아디 및 비밀번호를 확인해주세요");
        }
    }
}
