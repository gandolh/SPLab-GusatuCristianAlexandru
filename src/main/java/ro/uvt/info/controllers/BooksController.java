package ro.uvt.info.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.uvt.info.controllers.commands.*;
import ro.uvt.info.models.Book;
import ro.uvt.info.services.BookRepository;
import ro.uvt.info.services.BookSaveVisitor;
import ro.uvt.info.services.BookStatistics;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BooksController {
    private final Command<List<Book>, Void> getAll;
    private final Command<Book, String> getOne;
    private final Command<Void, Book> AddOne;
    private final Command<String, Object> saveToJson;

    public BooksController(){

        BookSaveVisitor saveVisitor =  new BookSaveVisitor();
        BookRepository bookRepository =  new BookRepository();
        saveToJson = new SaveToJsonCommand(saveVisitor);
        getAll = new GetAllCommand<Book>(bookRepository);
        getOne = new FindOneCommand<Book>(bookRepository);
        AddOne = new AddOneCommand<Book>(bookRepository);

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
        AddOne.setCommandContext(book);
        AddOne.execute();
        return new ResponseEntity<>("Done!", HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> putBook() {
        return new ResponseEntity<>("", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBook() {
        return new ResponseEntity<>("", HttpStatus.OK);
    }


}