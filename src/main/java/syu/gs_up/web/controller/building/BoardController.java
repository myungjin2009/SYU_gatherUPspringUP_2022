package syu.gs_up.web.controller.building;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import syu.gs_up.web.controller.building.form.CommentForm;
import syu.gs_up.web.controller.building.form.CreateBoardForm;
import syu.gs_up.web.domain.college.Board;
import syu.gs_up.web.domain.college.Comment;
import syu.gs_up.web.domain.college.Student;
import syu.gs_up.web.dto.board.BoardDto;
import syu.gs_up.web.service.building.BoardService;
import syu.gs_up.web.service.building.CommentService;

import java.util.List;
import java.util.Objects;

@Controller
public class BoardController {

    @Autowired
    BoardService boardService;

    @Autowired
    CommentService commentService;

    @GetMapping("/boardList")
    public String board(Model model){

        List<Board> boardList = boardService.getList();
        model.addAttribute("boardList", boardList);

        return "board/boardList";
    }


    @GetMapping("/board")
    public String boardView(@RequestParam Integer uid, @SessionAttribute(value = "user", required = false) Student user, Model model) {
        Board board = boardService.getBoard(Long.valueOf(uid));
        model.addAttribute("board",board);

        List<Comment> comment = commentService.getComment(Long.valueOf(uid));
        model.addAttribute("comment", comment);
        Integer commentCount = comment.size();
        model.addAttribute("commentCount", commentCount);

        if (Objects.isNull(user)) {
            model.addAttribute("sessions", null);
        } else {
            model.addAttribute("sessions", user);
        }
        return "board/boardView";
    }

    @PostMapping("/boardView/writeComment")
    public String writeComment(@SessionAttribute(value = "user", required = false) Student user, CommentForm commentForm) {
        Board board = boardService.getBoard(Long.valueOf(commentForm.getUid()));
        Comment comment = new Comment(user, board, commentForm.getComments());
        commentService.saveComment(comment);
        return "redirect:/board?uid=" + commentForm.getUid();
    }

    @GetMapping("/writeBoard")
    public String writeBoard(@SessionAttribute(value = "user", required = false) Student user, Model model) {
        if (Objects.isNull(user)) {
            return "redirect:/login";
        }

        return "board/writeBoard";
    }

    @PostMapping("/writeBoard")
    public String uploadBoard(@SessionAttribute(value = "user", required = false) Student user, CreateBoardForm createBoardForm) {
        Boolean result = boardService.uploadBoard(user, createBoardForm.getTitle(), createBoardForm.getContent());
        if(result == false) {
            return null;
        } else {
            return "redirect:/boardList";
        }
    }
}
