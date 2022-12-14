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
        return bookRepository.findById(id);
    }

    @Override
    public void add(Book book) {
        bookRepository.save(book);
    }

    @Override
    public void delete(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public void update(Book book) {
        if (get(book.getId()).isPresent()) {
            bookRepository.save(book);
        }
    }

}
