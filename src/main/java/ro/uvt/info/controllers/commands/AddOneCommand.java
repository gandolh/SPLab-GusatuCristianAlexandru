package ro.uvt.info.controllers.commands;

import org.springframework.data.jpa.repository.JpaRepository;

public class AddOneCommand<T> implements Command<Void, T>{
    private final JpaRepository<T, Integer> repository;
    private T commandContext;

    public AddOneCommand(JpaRepository<T, Integer> repository) {
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
    public Command<Void, T> getClone() {
        return new AddOneCommand<>(this);
    }

    @Override
    public Void execute() {
        repository.save(commandContext);
        return null;
    }


}
