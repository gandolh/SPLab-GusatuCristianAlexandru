package ro.uvt.info.services.Commands;

import org.hibernate.Hibernate;
import ro.uvt.info.models.BaseElement;
import ro.uvt.info.persistence.CrudRepository;

import java.util.List;

public class GetAllCommand<T extends BaseElement> implements Command<List<T>, Void> {
    private final CrudRepository<T, Long> repository;
    public GetAllCommand(CrudRepository<T, Long> repository) {
        this.repository = repository;
    }
    private GetAllCommand(GetAllCommand<T> gac) {
        this.repository = gac.repository;
    }

    @Override
    public List<T> execute() {

        List<T> result = repository.findAll();
//        result.forEach(el-> { Hibernate.initialize(el); el.clone();});
        return result;
    }

    @Override
    public Command<List<T>, Void> getClone() {
        return new GetAllCommand<>(this);
    }
}
