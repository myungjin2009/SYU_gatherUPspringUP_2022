package syu.gs_up.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import syu.gs_up.web.controller.building.form.StudentForm;
import syu.gs_up.web.domain.college.Student;
import syu.gs_up.web.service.building.StudentService;

import java.util.List;

@Controller
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/register")
    public String Register(StudentForm studentForm, Model model) {
        Student student = new Student
                (
                    studentForm.getName(),
                    studentForm.getEmail(),
                    studentForm.getPassword(),
                    studentForm.getNickName(),
                    studentForm.getGrade()
                );

        List<String> list = studentService.join(student);

        model.addAttribute("isSuccess", list.get(0));
        model.addAttribute("reason", list.get(1));

        return "/login/registerSuccessful";
    }
}
