package syu.gs_up.web.repository.board;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import syu.gs_up.web.domain.college.Board;

import java.util.List;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {

    @Query("SELECT m FROM Board m ORDER BY postId DESC")
    List<Board> findAllOrderByPostIdDESC();
}
