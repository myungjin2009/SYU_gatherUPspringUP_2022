package syu.gs_up.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import syu.gs_up.web.domain.college.EmailAuth;

import java.util.List;

@Repository
public interface EmailAuthRepository extends JpaRepository<EmailAuth, Long> {

}
