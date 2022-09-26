package syu.gs_up;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import syu.gs_up.web.domain.college.*;
import syu.gs_up.web.repository.BuildingRepository;
import syu.gs_up.web.repository.board.BoardRepository;
import syu.gs_up.web.repository.board.CommentRepository;
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
    private final BoardRepository boardRepository;

    private final CommentRepository commentRepository;

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

        ClassRoom classRoom = new ClassRoom("401호","4F", silsub1);
        ClassRoom classRoom2 = new ClassRoom("402호","4F", silsub1);
        ClassRoom classRoom3 = new ClassRoom("403호","4F", silsub1);
        classRoomRepository.save(classRoom);
        classRoomRepository.save(classRoom2);
        classRoomRepository.save(classRoom3);

        Student testStudent = new Student("테스트","testStudent@naver.com","1234","테스팅닉네임",1, "backEnd");
        studentRepository.save(testStudent);

        Book testBook2 = new Book(LocalTime.of(9,00,00), LocalTime.of(10,30,00), LocalDate.of(2022,9,16), false, classRoom);
        testBook2.addStudent(testStudent);
        bookRepository.save(testBook2);

        testStudent.addBook(testBook2);


        for(int i = 1; i <= 5; i++) {
            Book testBook = new Book(LocalTime.of(9+(i*2),00,00), LocalTime.of(10+(i*2),30,00), LocalDate.of(2022,9,16), false, classRoom);
            bookRepository.save(testBook);
        }


        for(int i = 1; i <= 10; i++) {
            Student student = new Student("홍길동"+i,"test"+i+"@naver.com","1234","홍길이"+i,(i%4 + 1), "designer");
            studentRepository.save(student);
        }


        Student student = new Student("강감찬","test@naver.com","5678","감찬이",3, "frontEnd");
        studentRepository.save(student);
        Board board = new Board("코딩 같이할 사람!!","3학년 캡스톤디자인 CRUD 같이 공부하실 분 구해봐요",false, student);
        boardRepository.save(board);
        Board board2 = new Board("같이 자료구조 스터디 하실 분","자료구조 너무 어렵네요.. 백엔드 단에서 설명 가능하신 분",true, student);
        boardRepository.save(board2);
        Board board3 = new Board("앱 디자인 잘하시는 분!!","앱디자이너 한 분 모십니다",false, student);
        boardRepository.save(board3);
        Board board4 = new Board("컴메 스터디","백엔드 스프링부트 같이 공부하실 분 있나요?",true, student);
        boardRepository.save(board4);
        Board board5 = new Board("자바스크립트 방","같이 하실 분 환영해요",false, student);
        boardRepository.save(board5);
        Comment comment = new Comment(testStudent, board2, "저 참여해도 될까요?");
        commentRepository.save(comment);
        Comment comment2 = new Comment(testStudent, board2, "와~~~ 저도같이 하고싶네요");
        commentRepository.save(comment2);
        Comment comment3 = new Comment(student, board2, "그거 한 시간 안에 못하던데");
        commentRepository.save(comment3);
    }
}
