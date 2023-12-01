package ro.uvt.info.controllers.commands;

import lombok.Setter;
import ro.uvt.info.models.Book;
import ro.uvt.info.models.Repository;

public class FindOneCommand<T> implements Command<T, String> {
    private final Repository<T> repository;
    @Setter
    private String commandContext;

    public FindOneCommand(Repository<T> repository) {
        this.repository = repository;
    }

    @Override
    public T execute() {
        return repository.find(commandContext);
    }
}
