package ro.uvt.info.services;

import lombok.Getter;
import ro.uvt.info.models.*;

@Getter
public class BookStatistics implements Visitor<Void> {
    private int NoImages;
    private int NoTables;
    private int NoParagraphs;

    @Override
    public Void visitBook(Book book) {
        for (Visitee element :
                book.getElementList()) {
            element.accept(this);
        }
        return null;
    }

    @Override
    public Void visitSection(Section section) {
        for (Element element :
                section.getElementList()) {
            element.accept(this);
        }
        return null;
    }

    @Override
    public Void visitTableOfContents(TableOfContents toc) {
        return null;
    }

    @Override
    public Void visitParagraph(Paragraph paragraph) {
        NoParagraphs++;
        return null;
    }

    @Override
    public Void visitImageProxy(ImageProxy imageProxy) {
        imageProxy.LoadImage().accept(this);
        return null;
    }

    @Override
    public Void visitImage(Image image) {
        NoImages++;
        return null;
    }

    @Override
    public Void visitTable(Table table) {
        NoTables++;
        return null;
    }

    @Override
    public Void visitAuthor(Author author) {
        return null;
    }

    public void printStatistics() {
        System.out.println("Book Statistics:");
        System.out.println("*** Number of images: "+ NoImages);
        System.out.println("*** Number of tables: "+ NoTables);
        System.out.println("*** Number of paragraphs: "+ NoParagraphs);

    }
}
