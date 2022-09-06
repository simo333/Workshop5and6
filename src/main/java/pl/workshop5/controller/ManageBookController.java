package pl.workshop5.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.workshop5.model.Book;
import pl.workshop5.service.BookService;

import java.util.List;

@Controller
@RequestMapping("/admin/books")
public class ManageBookController {

    private final BookService bookService;
    private static final String REDIRECT_TO_BOOK_LIST = "redirect:/admin/books/all";

    public ManageBookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/all")
    public String showBooks(Model model) {
        List<Book> books = bookService.findAll();
        model.addAttribute("books", books);
        return "/books/all";
    }

    @GetMapping("/get/{id}")
    public String showBook(Model model, @PathVariable Long id) {
        if (bookService.get(id).isPresent()) {
            model.addAttribute("book", bookService.get(id).get());
            return "/books/get";
        }
        return REDIRECT_TO_BOOK_LIST;
    }

    @GetMapping("/add")
    public String addBookForm(Model model) {
        model.addAttribute("book", new Book());
        return "/books/add";
    }

    @PostMapping("/add")
    public String addBook(Book book) {
        bookService.add(book);
        return REDIRECT_TO_BOOK_LIST;
    }

    @GetMapping("/update/{id}")
    public String updateBookForm(Model model, @PathVariable Long id) {
        if (bookService.get(id).isPresent()) {
            model.addAttribute("book", bookService.get(id).get());
        } else {
            model.addAttribute("error", "Book with given id does not exist.");
        }
        return "/books/update";
    }

    @PostMapping("/update")
    public String updateBook(Book book) {
        bookService.update(book);
        return REDIRECT_TO_BOOK_LIST;
    }

    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable Long id) {
        bookService.delete(id);
        return REDIRECT_TO_BOOK_LIST;
    }


}
