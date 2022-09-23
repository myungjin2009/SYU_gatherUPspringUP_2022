package syu.gs_up.web.repository.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import syu.gs_up.web.domain.college.Student;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query("select m from Student m where m.email = :email")
    Optional<Student> findByEmail(@Param("email") String email);


}
