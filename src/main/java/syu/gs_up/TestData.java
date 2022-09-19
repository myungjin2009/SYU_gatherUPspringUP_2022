package syu.gs_up;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import syu.gs_up.web.domain.college.Book;
import syu.gs_up.web.domain.college.Building;
import syu.gs_up.web.domain.college.ClassRoom;
import syu.gs_up.web.domain.college.Student;
import syu.gs_up.web.repository.BuildingRepository;
import syu.gs_up.web.repository.book.BookRepository;
import syu.gs_up.web.repository.classroom.ClassRoomRepository;
import syu.gs_up.web.repository.student.StudentRepository;

import java.time.LocalDate;
import java.time.LocalTime;

@Profile("secret")
@Component
@RequiredArgsConstructor
public class TestData {

    private final BuildingRepository buildingRepository;
    private final ClassRoomRepository classRoomRepository;
    private final BookRepository bookRepository;
    private final StudentRepository studentRepository;

    @EventListener(ApplicationReadyEvent.class)
    @Transactional
    public void buildingInit() {
        Building daniel = new Building("다니엘관", "삼육대학교 중심관", "37.6424", "127.1079");
        buildingRepository.save(daniel);

        for(int i=1;i<=5;i++){
            ClassRoom classRoom = new ClassRoom("10" + i + "호", "1F", daniel);
            classRoomRepository.save(classRoom);
        }

        for(int i=1;i<=3;i++){
            ClassRoom classRoom = new ClassRoom("20" + i + "호", "2F", daniel);
            classRoomRepository.save(classRoom);
        }

        Building samuel = new Building("사무엘관", "영문학과&사회복지학과", "37.6432", "127.1037");
        buildingRepository.save(samuel);


        Building silsub1 = new Building("제1실습관", "컴퓨터메카트로닉스공학부", "37.64440", "127.10543");
        buildingRepository.save(silsub1);

        ClassRoom classRoom = new ClassRoom("401"+"호","4F", silsub1);
        ClassRoom classRoom2 = new ClassRoom("402"+"호","4F", silsub1);
        ClassRoom classRoom3 = new ClassRoom("403"+"호","4F", silsub1);
        classRoomRepository.save(classRoom);
        classRoomRepository.save(classRoom2);
        classRoomRepository.save(classRoom3);

        for(int i = 1; i <= 5; i++) {
            Book testBook = new Book("Helloworld" + i +  " 스터디", LocalTime.of(9+(i*2),00,00), LocalTime.of(10+(i*2),30,00), LocalDate.of(2022,9,16), false, classRoom);
            bookRepository.save(testBook);
        }
        for(int i = 1; i <= 10; i++) {
            Student student = new Student("홍길동"+i,"test"+i+"@naver.com","1234","홍길이"+i,(i%4 + 1));
            studentRepository.save(student);
        }
    }
}
