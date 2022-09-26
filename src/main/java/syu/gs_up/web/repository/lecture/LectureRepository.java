package syu.gs_up.web.repository.lecture;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import syu.gs_up.web.domain.college.Lecture;

import java.time.LocalTime;
import java.util.List;

public interface LectureRepository extends JpaRepository<Lecture,Long> {

    @Query("select l from Lecture l " +
            "join l.classRoom c " +
            "where c.classRoomId = :cid ")
    List<Lecture> findLecturesByCId(@Param("cid") Long id);

    @Query("select count(l.lectureId) > 0 " +
            "from Lecture l " +
            "join l.classRoom c " +
            "join c.building b " +
            "where c.name = :room " +
            "and b.buildingId = :bId " +
            "and l.startTime <= :time " +
            "and l.endTime >= :time")
    boolean findExistingLecture(@Param("bId") Long bId,@Param("room") String classRoom,@Param("time") LocalTime start_time);
}
