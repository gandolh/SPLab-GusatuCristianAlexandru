package ro.uvt.info.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.uvt.info.models.Author;
import ro.uvt.info.models.Book;

public interface AuthorsRepository extends JpaRepository<Author, Integer> {
}
