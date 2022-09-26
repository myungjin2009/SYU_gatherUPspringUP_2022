package syu.gs_up.web.service.building;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import syu.gs_up.web.domain.college.Board;
import syu.gs_up.web.domain.college.Student;
import syu.gs_up.web.repository.board.BoardRepository;
import syu.gs_up.web.repository.student.StudentRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;

    private final StudentRepository studentRepository;

    public List<Board> getList() {
        List<Board> result = boardRepository.findAll();
        return result;
    }

    public List<Board> getListOpposite() {
        List<Board> result = boardRepository.findAllOrderByPostIdDESC();
        return result;
    }

    public Board getBoard(Long id) {
        Optional<Board> result = boardRepository.findById(id);
        return result.get();
    }

    public Boolean uploadBoard(Student user, String title, String content) {
        Optional<Student> testStudentData = studentRepository.findByEmail(user.getEmail());
        if(testStudentData.isEmpty()) {
            System.out.println("BoardService.java - 회원정보가 없습니다!!!!");
            return false;
        } else {
            Board board = new Board(title, content, testStudentData.get());
            boardRepository.save(board);
            return true;
        }

    }
}
