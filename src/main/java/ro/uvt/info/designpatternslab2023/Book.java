package ro.uvt.info.designpatternslab2023;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class Book extends Section {
    private TableOfContents tableOfContents;
    private List<Author> authors;

    public Book(String title) {
        super(title);
        authors = new ArrayList<>();
    }

    @Override
    public void print(){
        System.out.println("Book: " + title );
        System.out.println();

        System.out.println("Authors: ");
        for (Author author :
                authors) {
            author.print();
        }
        System.out.println();

        for (Element element :
                elements) {
            element.print();
        }


    }

    public void addAuthor(Author author) {
        this.authors.add(author);
    }

}
