package syu.gs_up.web.service.building;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import syu.gs_up.web.domain.college.*;
import syu.gs_up.web.dto.student.LoginForm;
import syu.gs_up.web.dto.student.StudentBook;
import syu.gs_up.web.repository.EmailAuthRepository;
import syu.gs_up.web.repository.student.StudentRepository;
import syu.gs_up.web.service.MailService;

import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

@Service
@RequiredArgsConstructor
@Slf4j
public class StudentService {

    private final StudentRepository studentRepository;
    private final EmailAuthRepository emailAuthRepository;
    private final MailService mailService;

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

    public Optional<EmailAuth> verifyNumber(EmailAuth emailAuth) {
        return emailAuthRepository.findEmailAndAuthNumber(emailAuth.getAuthEmail(), emailAuth.getAuthNumber());
    }

    @Transactional
    public void join(Student student) {
        studentRepository.save(student);
    }

    public Optional<Student> login(LoginForm form) {
        return studentRepository.findUserID(form.getId(),form.getPw());
    }

    public boolean isDuplicateEmail(String email) {
        return studentRepository.existsByEmail(email);
    }

    public StudentBook getStudentDataWithBookInfo(Long studentId) {
        //TODO Student - BOOk - ClassRoom - building
        Optional<Student> allRealtions = studentRepository.getAllRelations(studentId);
        Student student = allRealtions.orElseThrow();



        StudentBook studentBook = StudentBook.builder()
                .nickname(student.getNickName())
                .grade(student.getGrade())
                .position(student.getPosition())
                .build();

        if(Objects.nonNull(student.getBook())){
            Book bookData = student.getBook();
            ClassRoom classRoom = bookData.getClassRoom();
            studentBook.setId(bookData.getBookId());
            studentBook.setBookStart(bookData.getBookStartTime());
            studentBook.setBookEndTime(bookData.getBookEndTime());
            studentBook.setClassRoomName(classRoom.getName());
            studentBook.setBuildingName(classRoom.getBuilding().getName());
        }

        return studentBook;
    }
}
