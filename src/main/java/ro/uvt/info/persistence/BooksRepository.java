package ro.uvt.info.persistence;

import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.uvt.info.models.Book;

@Repository
@Primary
public interface BooksRepository extends JpaRepository<Book, Integer> {
}
