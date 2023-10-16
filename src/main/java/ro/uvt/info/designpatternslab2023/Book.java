package ro.uvt.info.designpatternslab2023;

import java.util.ArrayList;
import java.util.List;

public class Book {
    private String title;
    private Author author;
    private TableOfContents tableOfContents;
    private List<Chapter> chapters;

    public Book(String title) {
        this.title = title;
        chapters = new ArrayList<>();
    }

    private void print(){}

    public void addAuthor(Author author) {
        this.author = author;
    }

    public int createChapter(String chapterName) {
        Chapter newChapter = new Chapter(chapterName);
        this.chapters.add(newChapter);
        return this.chapters.size();
    }

    public Chapter getChapter(int indexChapterOne) {
        return chapters.get(indexChapterOne);
    }
}
