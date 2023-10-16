package ro.uvt.info.designpatternslab2023;


import java.util.ArrayList;
import java.util.List;

public class SubChapter {
    private String name;
    private List<Image> images;
    private List<Paragraph> paragraphs;
    private List<Table> tables;


    public SubChapter(String name) {
        this.name = name;
        images = new ArrayList<>();
        paragraphs = new ArrayList<>();
        tables = new ArrayList<>();
    }
    public void print(){}

    public void createNewParagraph(String paragraphName) {
        Paragraph newParagraph = new Paragraph(paragraphName);
        paragraphs.add(newParagraph);
    }

    public void createNewImage(String imageName) {
        Image newImage = new Image(imageName);
        images.add(newImage);
    }


    public void createNewTable(String tableName) {
        Table newTable = new Table(tableName);
        tables.add(newTable);
    }
}
