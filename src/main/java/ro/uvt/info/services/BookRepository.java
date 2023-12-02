package ro.uvt.info.services;

import com.sun.source.tree.ReturnTree;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ro.uvt.info.models.*;

import java.util.ArrayList;
import java.util.List;


@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class BookRepository implements Repository<Book> {
    private final List<Book> books;

    public BookRepository() {
        books = new ArrayList<>();
        Book book1 = BuildBook1();
        Book book2 = BuildBook2();
        books.add(book1);
        books.add(book2);
    }

    public List<Book> getAll() {
        return books;
    }

    public Book find(String title){
        return books.stream()
                .filter(b -> b.getTitle().equals(title))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void add(Book book) {
        books.add(book);
    }

    private Book BuildBook1(){
        Book book = new Book("Book 1");
        Section cap1 = new Section("Capitolul 1");
        Paragraph p1 = new Paragraph("Paragraph 1");
        cap1.add(p1);
        Paragraph p2 = new Paragraph("Paragraph 2");
        cap1.add(p2);
        Paragraph p3 = new Paragraph("Paragraph 3");
        cap1.add(p3);
        Paragraph p4 = new Paragraph("Paragraph 4");
        cap1.add(p4);
        cap1.add(new ImageProxy("ImageOne"));
        cap1.add(new Image("ImageTwo"));
        cap1.add(new Paragraph("Some text"));
        cap1.add(new Table("Table 1"));
        book.add(cap1);
        return book;
    }
    private Book BuildBook2(){
        Book book =new Book("Book 2");
        Section cap2 = new Section("Chapter One");
        Paragraph p5 = new Paragraph("Introduction");
        cap2.add(p5);
        Paragraph p6 = new Paragraph("Chapter content...");
        cap2.add(p6);
        ImageProxy imgProxy = new ImageProxy("ImageThree");
        cap2.add(imgProxy);
        Paragraph p7 = new Paragraph("Additional paragraph");
        cap2.add(p7);
        Table table2 = new Table("Table 2");
        cap2.add(table2);
        book.add(cap2);
        return book;
    }
}
