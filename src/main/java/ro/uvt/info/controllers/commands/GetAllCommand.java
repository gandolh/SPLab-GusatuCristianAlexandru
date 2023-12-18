package ro.uvt.info.controllers.commands;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public class GetAllCommand<T> implements Command<List<T>, Void> {
    private final JpaRepository<T, Integer> repository;
    public GetAllCommand(JpaRepository<T, Integer> repository) {
        this.repository = repository;
    }
    private GetAllCommand(GetAllCommand<T> gac) {
        this.repository = gac.repository;
    }

    @Override
    public List<T> execute() {
        var all =  repository.findAll();
        return  all;
    }

    @Override
    public Command<List<T>, Void> getClone() {
        return new GetAllCommand<>(this);
    }
}
