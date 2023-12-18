package ro.uvt.info.commands;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.uvt.info.persistence.CrudRepository;

public class AddOneCommand<T> implements Command<T, T>{
    private final CrudRepository<T, Integer> repository;
    private T commandContext;

    public AddOneCommand(CrudRepository<T, Integer> repository) {
        this.repository = repository;
    }
    private AddOneCommand(AddOneCommand<T> aoc) {
        this.repository = aoc.repository;
        this.commandContext = aoc.commandContext;
    }
    @Override
    public void setCommandContext(T o) {
        commandContext = o;
    }

    @Override
    public Command<T, T> getClone() {
        return new AddOneCommand<>(this);
    }

    @Override
    public T execute() {
        repository.save(commandContext);
        return commandContext;
    }


}
