package syu.gs_up.web.repository.lecture;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import syu.gs_up.web.domain.college.Lecture;

import java.util.List;

public interface LectureRepository extends JpaRepository<Lecture,Long> {

    @Query("select l from Lecture l " +
            "join l.classRoom c " +
            "where c.id = :cid")
    List<Lecture> findLecturesByCId(@Param("cid") Long id);
}
