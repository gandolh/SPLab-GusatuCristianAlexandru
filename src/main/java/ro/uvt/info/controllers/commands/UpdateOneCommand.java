package ro.uvt.info.controllers.commands;

import org.springframework.data.jpa.repository.JpaRepository;
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
        T existingEntity = repository.findById(Integer.parseInt(commandContext.first)).orElseThrow();

        // use reflection to override properties
        Class<?> entityClass = existingEntity.getClass();
        Class<?> commandContextClass = commandContext.second.getClass();
        try {
            for (Field commandContextField : commandContextClass.getDeclaredFields()) {
                commandContextField.setAccessible(true);
                Field entityField = null;
                entityField = entityClass.getDeclaredField(commandContextField.getName());
                entityField.setAccessible(true);
                entityField.set(existingEntity, commandContextField.get(commandContext.second));
            }
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        repository.save(existingEntity);
        return null;
    }
}
