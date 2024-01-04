package ro.uvt.info.persistence;

import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import ro.uvt.info.models.Book;

import java.util.List;

@Component
public class BooksRepository {
    private final BooksCrudRepository booksCrudRepository;

    public BooksRepository(BooksCrudRepository booksCrudRepository) {
        this.booksCrudRepository = booksCrudRepository;
    }

    public List<Book> findAllBooks() {
        return booksCrudRepository.findAll();
    }

    public Book findBookById(Long id) {
        return booksCrudRepository.findById(id);
    }

    public Book saveBook(Book book) {
        return booksCrudRepository.save(book);
    }

    public void deleteBookById(Long id) {
        booksCrudRepository.deleteById(id);
    }
}
