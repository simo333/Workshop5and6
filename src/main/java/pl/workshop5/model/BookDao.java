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
    private static final String UPDATE_QUERY =
            "UPDATE books SET isbn = ?, title = ?, author = ?, publisher = ?, type = ? WHERE id = ?";
    private static final String DELETE_BY_ID_QUERY = "DELETE FROM books WHERE id = ?";


    private final JdbcTemplate jdbcTemplate;
    private final RowMapper<Book> bookRowMapper;

    public BookDao(DataSource dataSource, RowMapper<Book> bookRowMapper) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.bookRowMapper = bookRowMapper;
    }

    public void add(Book book) {
        Object[] bookParams = {book.getIsbn(), book.getTitle(), book.getAuthor(), book.getPublisher(), book.getType()};
        jdbcTemplate.update(ADD_QUERY, bookParams);
    }

    public List<Book> all() {
        return jdbcTemplate.query(FIND_ALL_QUERY, bookRowMapper);
    }

    public Book one(Long id) {
        //TODO throw exception when null
        return jdbcTemplate.queryForObject(FIND_BY_ID_QUERY, bookRowMapper, id);
    }

    public void update(Long id, Book book) {
        Object[] bookParams = {book.getIsbn(), book.getTitle(), book.getAuthor(), book.getPublisher(), book.getType()};
        if (one(id) != null) {
            jdbcTemplate.update(UPDATE_QUERY, bookParams, id);
        }
        //TODO throw exception
    }

    public void delete(Long id) {
        if (one(id) != null) {
            jdbcTemplate.update(DELETE_BY_ID_QUERY, id);
        }
        //TODO throw exception
    }
}
