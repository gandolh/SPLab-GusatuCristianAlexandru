package ro.uvt.info.controllers;

import ch.qos.logback.core.joran.sanity.Pair;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.uvt.info.controllers.commands.*;
import ro.uvt.info.models.Book;
import ro.uvt.info.models.MyPair;
import ro.uvt.info.services.BookRepository;
import ro.uvt.info.services.BookStatistics;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BooksController {
    private final Command<List<Book>, Void> getAll;
    private final Command<Book, String> getOne;
    private final Command<Void, Book> addOne;
    private final Command<Void, MyPair<String,Book>> updateOne;
    private final Command<Void, String> deleteOne;
    private final Command<String, Object> saveToJson;

    public BooksController(SaveToJsonCommand saveToJsonCmd, BookRepository bookRepository){
        saveToJson = saveToJsonCmd;
        getAll = new GetAllCommand<Book>(bookRepository);
        getOne = new FindOneCommand<Book>(bookRepository);
        addOne = new AddOneCommand<Book>(bookRepository);
        updateOne = new UpdateOneCommand<Book>(bookRepository);
        deleteOne = new DeleteOneCommand<Book>(bookRepository);

    }

    @GetMapping("/statistics")
    public ResponseEntity<?> printStatistics() {
        BookRepository bookRepository = new BookRepository();
        var book = bookRepository.getAll().get(0);
        BookStatistics stats = new BookStatistics();
        book.accept(stats);
        return new ResponseEntity<>(stats.getStatistics(), HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<?> getBooks() {
        List<Book> books = getAll.execute();
        saveToJson.setCommandContext(books);
        return new ResponseEntity<>(saveToJson.execute(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getBook(@PathVariable String id) {
        getOne.setCommandContext(id);
        Book book = getOne.execute();
        saveToJson.setCommandContext(book);
        return new ResponseEntity<>(saveToJson.execute(), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<?> addBook(@RequestBody Book book) {
        addOne.setCommandContext(book);
        addOne.execute();
        return new ResponseEntity<>("Added!", HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> putBook(@PathVariable String id, @RequestBody Book book) {
        MyPair<String,Book> pair = new MyPair<String, Book>(id, book);
        updateOne.setCommandContext(pair);
        updateOne.execute();
        return new ResponseEntity<>("Updated!", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable String id) {
        deleteOne.setCommandContext(id);
        deleteOne.execute();
        return new ResponseEntity<>("Removed!", HttpStatus.OK);
    }


}