package syu.gs_up.web.service.building;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import syu.gs_up.web.domain.college.Comment;
import syu.gs_up.web.repository.board.CommentRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;

    public List<Comment> getComment(Long uid) {
        List<Comment> result = commentRepository.findByBoardId(uid);
        return result;
    }

    public void saveComment(Comment comment) {
        commentRepository.save(comment);
    }
}
