package syu.gs_up.web.repository.book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import syu.gs_up.web.domain.college.Book;
import syu.gs_up.web.dto.book.BookDto;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;
@Repository
public interface BookRepository extends JpaRepository<Book,Long> {
    @Query("SELECT m FROM Book m JOIN m.classRoom c WHERE c.id = :classRoomID")
    List<Book> findByClassRoomId(@Param("classRoomID") Long id);

    @Query("SELECT m FROM Book m WHERE m.student.studentId = :studentId")
    Book findByUserId(@Param("studentId") Long id);

    @Modifying
    @Transactional
    @Query("update Book m " +
            "SET m.bookDay = :bookDay , m.bookStartTime = :bookStartTime, m.classRoom.classRoomId = :classRoomID " +
            "WHERE m.student.studentId = :studentId")
    Integer update(@Param("bookDay")LocalDate bookDay, @Param("bookStartTime") LocalTime bookStartTime,
                   @Param("studentId") Long id, @Param("classRoomID") Long classRoomId);
}
