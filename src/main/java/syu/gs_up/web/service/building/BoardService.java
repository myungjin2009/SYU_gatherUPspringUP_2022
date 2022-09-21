package syu.gs_up.web.service.building;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import syu.gs_up.web.domain.college.Board;
import syu.gs_up.web.dto.board.BoardDto;
import syu.gs_up.web.repository.board.BoardRepository;

import java.util.List;

@Service
public class BoardService {

    @Autowired
    BoardRepository boardRepository;

    public List<Board> getList() {
        List<Board> result = boardRepository.findAll();
        return result;
    }
}
