package syu.gs_up.web.service.building;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import syu.gs_up.web.domain.college.EmailAuth;
import syu.gs_up.web.domain.college.Student;
import syu.gs_up.web.repository.EmailAuthRepository;
import syu.gs_up.web.repository.student.StudentRepository;
import syu.gs_up.web.service.MailService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;
    private final EmailAuthRepository emailAuthRepository;
    private final MailService mailService;

    public Boolean isAlreadyJoined(String email) {
        Optional<Student> validate = studentRepository.findByEmail(email);
        return validate.isPresent();
    }

    @Transactional
    public Boolean sendVerificationNumber(String email) {
        Integer number = ThreadLocalRandom.current().nextInt(100000, 1000000);

        //이메일 인증번호 송신
        try {
            mailService.sendMail(email, "Gather UP, Spring UP! 인증메일 입니다.", "인증번호는 " + number + " 입니다.");
        } catch (Exception e) {
            return false;
        }

        EmailAuth auth = new EmailAuth(email, number);
        emailAuthRepository.save(auth);

        return true;
    }

    @Transactional
    public List<String> join(Student student) {

        List<String> list = new ArrayList<>();

        try {
            studentRepository.save(student);
        } catch (Exception e) { //오류 전달
            list.add("false");
            list.add(e.getMessage());
            return list;
        }

        list.add("true");
        list.add("성공하였습니다");
        return list;
    }
}
