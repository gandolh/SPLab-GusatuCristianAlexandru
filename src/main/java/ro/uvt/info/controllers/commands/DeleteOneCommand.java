package ro.uvt.info.controllers.commands;

import org.springframework.data.jpa.repository.JpaRepository;

public class DeleteOneCommand<T> implements Command<Void, String> {
    private final JpaRepository<T, Integer> repository;
    private String commandContext;

    public DeleteOneCommand(JpaRepository<T, Integer> repository) {
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
