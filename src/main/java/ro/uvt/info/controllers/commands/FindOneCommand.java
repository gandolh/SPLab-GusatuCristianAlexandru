package ro.uvt.info.controllers.commands;

import lombok.Setter;
import org.springframework.data.jpa.repository.JpaRepository;

public class FindOneCommand<T> implements Command<T, String> {
    private final JpaRepository<T, Integer> repository;
    @Setter
    private String commandContext;

    public FindOneCommand(JpaRepository<T, Integer> repository) {
        this.repository = repository;
    }
    private FindOneCommand(FindOneCommand<T> foc) {
        this.repository = foc.repository;
        this.commandContext = foc.commandContext;
    }

    @Override
    public T execute() {
        return repository.findById(Integer.parseInt(commandContext)).orElseThrow();
    }

    @Override
    public Command<T, String> getClone() {
        return new FindOneCommand<>(this);
    }
}
