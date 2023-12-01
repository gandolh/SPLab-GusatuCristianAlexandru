package ro.uvt.info.controllers.commands;

import ro.uvt.info.models.Book;
import ro.uvt.info.models.Repository;

public class AddOneCommand<T> implements Command<Void, T>{
    private final Repository<T> repository;
    private T commandContext;

    public AddOneCommand(Repository<T> repository) {
        this.repository = repository;
    }
    @Override
    public void setCommandContext(T o) {
        commandContext = o;
    }
    @Override
    public Void execute() {
        repository.add(commandContext);
        return null;
    }


}
