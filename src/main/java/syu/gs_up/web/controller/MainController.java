package syu.gs_up.web.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import syu.gs_up.web.domain.college.Board;
import syu.gs_up.web.domain.college.Student;
import syu.gs_up.web.service.building.BoardService;

import java.util.List;
import java.util.Objects;

@Controller
@Slf4j
@AllArgsConstructor
public class MainController {

    private final BoardService boardService;

    @GetMapping("/")
    public String main(@SessionAttribute(value = "user", required = false) Student user, Model model) {
        if (Objects.isNull(user)) {
            return "redirect:/login";
        }
        log.info("user  = {} ", user.getEmail());
        List<Board> boardList = boardService.getListOpposite();
        model.addAttribute("boardList", boardList);

        return "main/home";
    }
}
