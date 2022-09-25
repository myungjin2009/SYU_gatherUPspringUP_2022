package syu.gs_up.web.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import syu.gs_up.web.SessionConst;
import syu.gs_up.web.SessionManager;
import syu.gs_up.web.domain.member.Student;
import syu.gs_up.web.service.LoginForm;
import syu.gs_up.web.service.LoginService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Slf4j
@Controller
@RequiredArgsConstructor


public class LoginController {

    private final LoginService loginService;
    private final SessionManager sessionManager;

    @GetMapping("/user/login")
    public String loginForm(@ModelAttribute("login") LoginForm form) {
        return "/member/login";
    }

    @PostMapping("/user/login")
    public String login(HttpServletRequest request, @Valid @ModelAttribute LoginForm form, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/member/login";
        }
        Student loginStudent = loginService.login(form.getEmail(), form.getPassword());

        if (loginStudent == null) {
            bindingResult.reject("loginFail", "아이디 또는 비밀번호가 맞지 않습니다.");
            return "/member/login";
        }
        //로그인 성공 세션있음 반환 없음 신규생성
        HttpSession session = request.getSession();
        //로그인회원정보 보관
        session.setAttribute(SessionConst.LOGIN_STUDENT, loginStudent);
        return "home";
    }

    @PostMapping("/user/logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        return "redirect:/";
    }

}
