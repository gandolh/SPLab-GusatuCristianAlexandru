package ro.uvt.info.services;

import ro.uvt.info.models.*;

import java.util.List;


public class BookSaveVisitor implements Visitor<Void> {
    private final StringBuilder buildingJson = new StringBuilder();

    @Override
    public Void visitBook(Book book) {
        String BookPropertiesTemplateJson = """
                {
                    "title": "%s",
                    "Authors": [
                """;
        buildingJson.append(String.format(BookPropertiesTemplateJson,book.getTitle()));
        for (Author author :
                book.getAuthorList()) {
            author.accept(this);
        }
        buildingJson.append("]");
        buildingJson.append(!book.getElementList().isEmpty() ? ",\n \"elementList\": [" : "");
        List<Element> books = book.getElementList();
        printChilds(books);
        buildingJson.append(!book.getElementList().isEmpty() ? "]" : "");
        buildingJson.append("}");
        return null;
    }

    private void printChilds(List<Element> books) {
        for (int i = 0; i < books.size(); i++) {
            books.get(i).accept(this);
            if (i != books.size() - 1) buildingJson.append(",");
        }
    }

    @Override
    public Void visitSection(Section section) {
        String sectionJsonTemplate = """
                {
                    "title": "%s"%s
                """;
        String json = String.format(sectionJsonTemplate,
                section.getTitle(), !section.getElementList().isEmpty() ? ", \"elementList\" : [ " : "");
        buildingJson.append(json);
        var sections = section.getElementList();
        printChilds(sections);
        buildingJson.append("}");
        return null;
    }

    @Override
    public Void visitTableOfContents(TableOfContents toc) {
        int pageCount = 1;
        String entryTemplate = "\"%s\":\"%s\"";
        buildingJson.append("{");
        for (String entry :
                toc.getEntries()) {
            if (entry != null)
                buildingJson.append(String.format(entryTemplate, entry, pageCount));
            else pageCount++;
        }
        buildingJson.append("}");
        return null;
    }

    @Override
    public Void visitParagraph(Paragraph paragraph) {
        String paragraphJsonTemplate = """
                {
                    "text": "%s"
                }
                """;
        buildingJson.append(String.format(paragraphJsonTemplate, paragraph.getText()));
        return null;
    }

    @Override
    public Void visitImageProxy(ImageProxy imageProxy) {
        imageProxy.LoadImage().accept(this);
        return null;
    }

    @Override
    public Void visitImage(Image image) {
        String imageJsonTemplate = """
                {
                    "name": "%s"
                }
                """;
        buildingJson.append(String.format(imageJsonTemplate, image.getImageName()));
        return null;
    }

    @Override
    public Void visitTable(Table table) {
        String tableJsonTemplate = """
                {
                    "title": "%s"
                }
                """;
        buildingJson.append(String.format(tableJsonTemplate, table.getTitle()));
        return null;
    }

    public Void visitAuthor(Author author) {
        String authorJsonTemplate = """
                {
                    "Author": "%s"
                }
                """;
        String json = String.format(authorJsonTemplate, author.getName());
        buildingJson.append(json);
        return null;
    }

    public String getJson(){
        return buildingJson.toString();
    }
}
