package syu.gs_up.web.service.building;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import syu.gs_up.web.domain.college.Book;
import syu.gs_up.web.dto.book.BookDto;
import syu.gs_up.web.repository.book.BookRepository;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;
    public List<BookDto> getTimeTable(Long id) {
        List<Book> result = bookRepository.findByClassRoomId(10L);
        System.out.println(result);
        return result;
    }
}
