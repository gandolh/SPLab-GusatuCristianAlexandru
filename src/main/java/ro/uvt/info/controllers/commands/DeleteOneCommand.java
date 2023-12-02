package ro.uvt.info.controllers.commands;

import ro.uvt.info.models.MyPair;
import ro.uvt.info.models.Repository;

public class DeleteOneCommand<T> implements Command<Void, String> {
    private final Repository<T> repository;
    private String commandContext;

    public DeleteOneCommand(Repository<T> repository) {
        this.repository = repository;
    }
    @Override
    public void setCommandContext(String o) {
        commandContext = o;
    }

    @Override
    public Void execute() {
        repository.delete(commandContext);
        return null;
    }
}
