package syu.gs_up.web.service.building;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import syu.gs_up.web.domain.college.Student;
import syu.gs_up.web.repository.student.StudentRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Transactional
    public List<String> join(Student student) {

        List<String> list = new ArrayList<>();

        Optional<Student> validate = studentRepository.findByEmail(student.getEmail());
        if(validate.isEmpty() == false) {
            list.add("false");
            list.add("이미 존재하는 이메일 입니다");
        } else {

            try{
                studentRepository.save(student);
            }
            catch(Exception e) { //오류 전달
                list.add("false");
                list.add(e.getMessage());
                return list;
            }

        }

        list.add("true");
        list.add("성공하였습니다");
        return list;
    }
}