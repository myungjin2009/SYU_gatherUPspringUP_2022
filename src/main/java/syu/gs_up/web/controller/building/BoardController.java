package syu.gs_up.web.controller.building;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import syu.gs_up.web.controller.building.form.CreateBoardForm;
import syu.gs_up.web.domain.college.Board;
import syu.gs_up.web.dto.board.BoardDto;
import syu.gs_up.web.service.building.BoardService;

import java.util.List;

@Controller
public class BoardController {

    @Autowired
    BoardService boardService;

    @GetMapping("/boardList")
    public String board(Model model){

        List<Board> boardList = boardService.getList();
        model.addAttribute("boardList", boardList);

        return "/board/boardList";
    }

    @GetMapping("/writeBoard")
    public String writeBoard(Model model) {

        return "/board/writeBoard";
    }

    @PostMapping("/writeBoard")
    public String uploadBoard(CreateBoardForm createBoardForm) {
        Boolean result = boardService.uploadBoardTEST(createBoardForm.getTitle(), createBoardForm.getContent());
        if(result == false) {
            return null;
        } else {
            return "redirect:/boardList";
        }
    }
}
