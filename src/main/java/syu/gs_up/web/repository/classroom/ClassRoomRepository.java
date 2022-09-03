package syu.gs_up.web.repository.classroom;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import syu.gs_up.web.domain.college.ClassRoom;

import java.util.List;

public interface ClassRoomRepository extends JpaRepository<ClassRoom,Long> {


    @Query("select c from ClassRoom c " +
            "join c.building b " +
            "where b.buildingId = :bid")
    List<ClassRoom> findByBuildingId(@Param("bid") Long id);

}
