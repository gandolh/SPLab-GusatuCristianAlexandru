package ro.uvt.info.controllers.commands;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.uvt.info.models.Book;
import ro.uvt.info.models.MyPair;

import java.lang.reflect.Field;

public class UpdateOneCommand<T> implements Command<Void, MyPair<String, T>> {
    private final JpaRepository<T, Integer> repository;
    private MyPair<String, T> commandContext;

    public UpdateOneCommand(JpaRepository<T, Integer> repository) {
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
    public Command<Void, MyPair<String, T>> getClone() {
        return new UpdateOneCommand<>(this);
    }

    @Override
    public Void execute() {
        T existingEntity= repository
                .findById(Integer.parseInt(commandContext.first))
                .orElseThrow();

        if (existingEntity.getClass() == Book.class) {
            Book updatingBook = (Book) commandContext.second;
            ((Book) existingEntity).setTitle(updatingBook.getTitle());
            ((Book) existingEntity).setAuthorList(updatingBook.getAuthorList());
            ((Book) existingEntity).setElementList(updatingBook.getElementList());
        }
        repository.save(existingEntity);
        return null;
    }


}
