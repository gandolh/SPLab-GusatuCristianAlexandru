package ro.uvt.info.controllers.commands;

import ro.uvt.info.models.*;

import java.util.List;

public class GetAllCommand<T> implements Command<List<T>, Void> {
    private final Repository<T> repository;
    public GetAllCommand(Repository<T> repository) {
        this.repository = repository;
    }

    @Override
    public List<T> execute() {
        return repository.getAll();
    }
}
