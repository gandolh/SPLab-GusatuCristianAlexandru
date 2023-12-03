package ro.uvt.info.controllers.commands;

import org.springframework.beans.factory.annotation.Autowired;
import ro.uvt.info.models.MyPair;
import ro.uvt.info.models.Repository;

public class DeleteOneCommand<T> implements Command<Void, String> {
    private final Repository<T> repository;
    private String commandContext;

    public DeleteOneCommand(Repository<T> repository) {
        this.repository = repository;
    }
    private DeleteOneCommand(DeleteOneCommand<T> doc){
        repository = doc.repository;
        commandContext = doc.commandContext;
    }

    @Override
    public void setCommandContext(String o) {
        commandContext = o;
    }

    @Override
    public Command<Void, String> getClone() {
        return new DeleteOneCommand<>(this);
    }

    @Override
    public Void execute() {
        repository.delete(commandContext);
        return null;
    }
}
