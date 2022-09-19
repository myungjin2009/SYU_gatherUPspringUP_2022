package syu.gs_up.web.repository.book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import syu.gs_up.web.domain.college.Book;
import syu.gs_up.web.dto.book.BookDto;

import java.util.List;
import java.util.Optional;
@Repository
public interface BookRepository extends JpaRepository<Book,Long> {
    @Query("SELECT m FROM Book m JOIN m.classRoom c WHERE c.id = :classRoomID")
    List<Book> findByClassRoomId(@Param("classRoomID") Long id);
}
