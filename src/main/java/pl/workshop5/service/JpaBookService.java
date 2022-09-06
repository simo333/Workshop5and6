package pl.workshop5.service;

import org.springframework.stereotype.Service;
import pl.workshop5.model.Book;
import pl.workshop5.repository.BookRepository;

import java.util.List;
import java.util.Optional;

@Service
public class JpaBookService implements BookService {

    private final BookRepository bookRepository;

    public JpaBookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Optional<Book> get(Long id) {
        return Optional.empty();
    }

    @Override
    public void add(Book book) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void update(Book book) {

    }

}
