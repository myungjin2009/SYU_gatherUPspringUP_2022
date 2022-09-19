package syu.gs_up.web.repository.student;

import org.springframework.data.jpa.repository.JpaRepository;
import syu.gs_up.web.domain.college.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
