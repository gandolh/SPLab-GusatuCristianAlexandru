package ro.uvt.info.commands;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.uvt.info.persistence.CrudRepository;

public class DeleteOneCommand<T> implements Command<Void, String> {
    private final CrudRepository<T, Integer> repository;
    private String commandContext;

    public DeleteOneCommand(CrudRepository<T, Integer> repository) {
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
        repository.deleteById(Integer.parseInt(commandContext));
        return null;
    }
}
