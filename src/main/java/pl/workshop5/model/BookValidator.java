package pl.workshop5.model;

import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class BookValidator {

    public Set<String> validate(Book book) {
        Set<String> errors = new HashSet<>();

        if (book.getIsbn() == null) {
            errors.add("'Isbn' cannot be empty");
        }
        if (book.getTitle() == null) {
            errors.add("'Title' cannot be empty");
        }
        if (book.getAuthor() == null) {
            errors.add("'Author' cannot be empty");
        }
        if (book.getPublisher() == null) {
            errors.add("'Publisher' cannot be empty");
        }
        if (book.getType() == null) {
            errors.add("'Type' cannot be empty");
        }
        return errors;
    }
}
