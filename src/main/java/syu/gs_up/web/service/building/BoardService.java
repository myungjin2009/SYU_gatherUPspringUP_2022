package syu.gs_up.web.service.building;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import syu.gs_up.web.domain.college.Board;
import syu.gs_up.web.domain.college.Student;
import syu.gs_up.web.dto.board.BoardDto;
import syu.gs_up.web.repository.board.BoardRepository;
import syu.gs_up.web.repository.student.StudentRepository;

import java.util.List;
import java.util.Optional;

@Service
public class BoardService {

    @Autowired
    BoardRepository boardRepository;

    @Autowired
    StudentRepository studentRepository;

    public List<Board> getList() {
        List<Board> result = boardRepository.findAll();
        return result;
    }

    public Boolean uploadBoardTEST(String title, String content) {
        //TODO 유저정보를 불러오는 로직이 있어야 함, 지금은 임시로 testStudent@naver.com 를 사용
        Optional<Student> testStudentData = studentRepository.findByEmail("testStudent@naver.com");
        if(testStudentData.isEmpty()) {
            System.out.println("BoardService.java - testStudentData가 비어있습니다!!!!");
            return false;
        } else {
            Board board = new Board(title, content, testStudentData.get());
            boardRepository.save(board);
            return true;
        }

    }
}
