package ro.uvt.info.controllers.commands;

import ro.uvt.info.models.MyPair;
import ro.uvt.info.models.Repository;

public class UpdateOneCommand<T> implements Command<Void, MyPair<String, T>> {
    private final Repository<T> repository;
    private  MyPair<String, T> commandContext;

    public UpdateOneCommand(Repository<T> repository) {
        this.repository = repository;
    }
    @Override
    public void setCommandContext( MyPair<String, T> o) {
        commandContext = o;
    }
    @Override
    public Void execute() {
        repository.update(commandContext.first, commandContext.second);
        return null;
    }
}
