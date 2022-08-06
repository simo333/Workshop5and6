package pl.workshop5.model;

import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class BookValidator {

    public Set<String> validate(Book book) {
        Set<String> errors = new HashSet<>();

        if (book.getIsbn() == null || book.getIsbn().trim().isEmpty()) {
            errors.add("'Isbn' cannot be empty");
        }
        if (book.getTitle() == null || book.getTitle().trim().isEmpty()) {
            errors.add("'Title' cannot be empty");
        }
        if (book.getAuthor() == null || book.getAuthor().trim().isEmpty()) {
            errors.add("'Author' cannot be empty");
        }
        if (book.getPublisher() == null || book.getPublisher().trim().isEmpty()) {
            errors.add("'Publisher' cannot be empty");
        }
        if (book.getType() == null || book.getType().trim().isEmpty()) {
            errors.add("'Type' cannot be empty");
        }
        return errors;
    }
}
