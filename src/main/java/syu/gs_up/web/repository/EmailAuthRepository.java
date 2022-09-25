package syu.gs_up.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import syu.gs_up.web.domain.college.EmailAuth;
import syu.gs_up.web.domain.college.Student;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmailAuthRepository extends JpaRepository<EmailAuth, Long> {



    @Query("select m from EmailAuth m where m.authEmail = :email and m.authNumber = :authNumber")
    Optional<EmailAuth> findEmailAndAuthNumber(@Param("email") String email, @Param("authNumber") Integer authNumber);

}
