package syu.gs_up.web.service.building;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import syu.gs_up.web.domain.college.Book;
import syu.gs_up.web.repository.book.BookRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;
    public List<Book> getTimeTable(Long id) {
        return bookRepository.findByClassRoomId(id);
    }

    public List<Book> getTimeTableAll() {
        return bookRepository.findAll();
    }


    public void reserve(Book book) {
        if(bookRepository.findByUserId(book.getStudent().getStudentId()) != null) {
            bookRepository.update(book.getBookDay(), book.getBookStartTime(),
                    book.getStudent().getStudentId(), book.getClassRoom().getClassRoomId());
        } else {
            bookRepository.save(book);
        }

    }

    @Transactional
    public void cancelBook(Long bookId) {
        bookRepository.deleteById(bookId);
    }
}
