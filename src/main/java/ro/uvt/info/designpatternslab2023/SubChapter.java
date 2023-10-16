package ro.uvt.info.designpatternslab2023;


import java.util.ArrayList;
import java.util.List;

public class SubChapter {
    private String name;
    private List<Element> elements;

    public SubChapter(String name) {
        this.name = name;
        elements = new ArrayList<>();
    }

    public void print() {
        System.out.printf("Subchapter: %s%n", name);
        for (Element element :
                elements) {
            element.print();
        }
    }

    public void createNewParagraph(String paragraphName) {
        Element newParagraph = new Paragraph(paragraphName);
        elements.add(newParagraph);
    }

    public void createNewImage(String imageName) {
        Element newImage = new Image(imageName);
        elements.add(newImage);
    }

    public void createNewTable(String tableName) {
        Element newTable = new Table(tableName);
        elements.add(newTable);
    }
}
