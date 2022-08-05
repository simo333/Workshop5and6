package pl.workshop5.controller;

import org.springframework.web.bind.annotation.*;
import pl.workshop5.model.Book;
import pl.workshop5.model.BookDao;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookDao bookDao;

    public BookController(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @GetMapping
    public List<Book> findAllBooks() {
        return bookDao.all();
    }

    @GetMapping("/{id}")
    public Book findById(@PathVariable Long id) {
        return bookDao.one(id);
    }

    @PostMapping
    public void createBook(@RequestBody Book book) {
        bookDao.add(book);
    }

    @PutMapping("/{id}")
    public void updateBook(@PathVariable Long id, @RequestBody Book book) {
        bookDao.update(id, book);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookDao.delete(id);
    }

}