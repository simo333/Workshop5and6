package pl.workshop5.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.workshop5.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
}
