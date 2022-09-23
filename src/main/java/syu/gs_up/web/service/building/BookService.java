package syu.gs_up.web.service.building;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
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
}
