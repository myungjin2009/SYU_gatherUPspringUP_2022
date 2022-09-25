package syu.gs_up.web.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import syu.gs_up.web.domain.college.Student;

import java.util.Objects;

@Controller
@Slf4j
public class MainController {

    @GetMapping("/")
    public String main(@SessionAttribute(value = "user", required = false) Student user) {
        if (Objects.isNull(user)) {
            return "redirect:/login";
        }

        log.info("user  = {} ", user.getEmail());

        return "main/home";
    }
}
