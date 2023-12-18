package ro.uvt.info.commands;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.uvt.info.models.Book;
import ro.uvt.info.models.MyPair;
import ro.uvt.info.persistence.CrudRepository;

public class UpdateOneCommand<T> implements Command<T, MyPair<String, T>> {
    private final CrudRepository<T, Integer> repository;
    private MyPair<String, T> commandContext;

    public UpdateOneCommand(CrudRepository<T, Integer> repository) {
        this.repository = repository;
    }

    private UpdateOneCommand(UpdateOneCommand<T> uoc) {
        this.repository = uoc.repository;
        this.commandContext = uoc.commandContext;
    }

    @Override
    public void setCommandContext(MyPair<String, T> o) {
        commandContext = o;
    }

    @Override
    public Command<T, MyPair<String, T>> getClone() {
        return new UpdateOneCommand<>(this);
    }

    @Override
    public T execute() {
        T existingEntity= repository
                .findById(Integer.parseInt(commandContext.first));

        if (existingEntity.getClass() == Book.class) {
            Book updatingBook = (Book) commandContext.second;
            ((Book) existingEntity).setTitle(updatingBook.getTitle());
            ((Book) existingEntity).setAuthorList(updatingBook.getAuthorList());
            ((Book) existingEntity).setElementList(updatingBook.getElementList());
        }
        repository.save(existingEntity);
        return existingEntity;
    }


}
