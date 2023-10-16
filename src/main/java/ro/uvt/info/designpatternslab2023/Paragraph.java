package ro.uvt.info.designpatternslab2023;

public class Paragraph implements Element {
    private String text;

    public void print(){
        System.out.println("Paragraph: " + text);
    }

    public Paragraph(String text) {
        this.text = text;
    }
}
