package syu.gs_up.web.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import syu.gs_up.web.domain.member.Student;
import syu.gs_up.web.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class LoginService {
    private final UserRepository userRepository;

    public Student login(String email, String password){
        return userRepository.findByemail(email)
                .filter(s ->s.getPassword().equals(password))
                .orElse(null);
    }
}
