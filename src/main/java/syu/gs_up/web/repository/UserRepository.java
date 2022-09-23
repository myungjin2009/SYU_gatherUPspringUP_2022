package syu.gs_up.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import syu.gs_up.web.domain.member.Student;
//import org.springframework.stereotype.Repository;
//import syu.gs_up.web.domain.member.User;

//import java.util.Optional;

//@Repository
//public interface UserRepository extends JpaRepository<User, Long> {
//    boolean existsByUsername(String username);
//    boolean existsByNickname(String nickname);
//    boolean existsByEmail(String email);
//
//}
//public interface UserRepository extends JpaRepository<User, Long> {
//    Optional<User> findByUsername(String username);
//}

public interface UserRepository extends JpaRepository<Student, Long> {
}

