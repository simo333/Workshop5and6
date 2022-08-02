package pl.workshop5.model;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.List;

@Service
public class BookDao {
    private static final String ADD_QUERY = "INSERT INTO books (isbn, title, author, publisher, type) VALUES (?, ?, ?, ?, ?)";
    private static final String FIND_ALL_QUERY = "SELECT * FROM books";
    private static final String FIND_BY_ID_QUERY = "SELECT * FROM books WHERE id = ?";

    private final JdbcTemplate jdbcTemplate;
    private final RowMapper<Book> bookRowMapper;

    public BookDao(DataSource dataSource, RowMapper<Book> bookRowMapper) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.bookRowMapper = bookRowMapper;
    }

    public Book add(Book book) {
        jdbcTemplate.update(ADD_QUERY, book.getIsbn(), book.getTitle(), book.getAuthor(), book.getPublisher(), book.getType());
        System.out.println("Created Record Name = " + book);
        return book;
    }

    public List<Book> all() {
        return jdbcTemplate.query(FIND_ALL_QUERY, bookRowMapper);
    }

    public Book one(Long id) {
        return jdbcTemplate.queryForObject(FIND_BY_ID_QUERY, bookRowMapper, id);
    }
}
