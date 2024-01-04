package ro.uvt.info.persistence;


import ro.uvt.info.models.Book;

import java.util.List;
import java.util.Optional;

public interface CrudRepository<T, TId> {
    List<T> findAll();
    T findById(TId id);
    T save(T other);
    void deleteById(TId id);
    public T update(Long id, T updatingBook);
}
