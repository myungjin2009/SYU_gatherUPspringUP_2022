package syu.gs_up.web.repository.board;

import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import syu.gs_up.web.domain.college.Comment;

import java.util.List;
import java.util.Optional;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    @Query("select m from Comment m where m.board.postId = :postId")
    List<Comment> findByBoardId(@Param("postId") Long uid);
}
