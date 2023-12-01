package ro.uvt.info.controllers.commands;

import lombok.Setter;
import ro.uvt.info.models.Book;
import ro.uvt.info.services.BookSaveVisitor;

import java.util.List;


/**
 * TODO: use T as SaveVisitor type.
 * TODO: Make this command generic for any serializable type.
 */
public class SaveToJsonCommand implements Command<String, Object> {
    private final BookSaveVisitor saveVisitor;
    @Setter
    private Object commandContext;

    public SaveToJsonCommand(BookSaveVisitor saveVisitor) {
        this.saveVisitor = saveVisitor;
    }

    @Override
    public String execute() {
        if (commandContext instanceof List) {
            List<Book> books = (List<Book>)commandContext;
            for (Book book : books)
                saveVisitor.visitBook(book);
        }else {
            saveVisitor.visitBook((Book)commandContext);
        }

        return saveVisitor.getJson();
    }
}
