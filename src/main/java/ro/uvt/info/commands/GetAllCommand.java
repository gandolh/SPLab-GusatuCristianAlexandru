package ro.uvt.info.commands;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.uvt.info.persistence.CrudRepository;

import java.util.List;

public class GetAllCommand<T> implements Command<Iterable<T>, Void> {
    private final CrudRepository<T, Integer> repository;
    public GetAllCommand(CrudRepository<T, Integer> repository) {
        this.repository = repository;
    }
    private GetAllCommand(GetAllCommand<T> gac) {
        this.repository = gac.repository;
    }

    @Override
    public Iterable<T> execute() {
        return repository.findAll();
    }

    @Override
    public Command<Iterable<T>, Void> getClone() {
        return new GetAllCommand<>(this);
    }
}
