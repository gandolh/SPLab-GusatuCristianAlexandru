package ro.uvt.info.models;

import lombok.Getter;

public class Paragraph extends BaseElement implements Visitee {
    @Getter
    private String text;

    public Paragraph() { text = "";}
    public Paragraph(String text) {
        this.text = text;
    }
    public Paragraph(Paragraph other){this.text = other.text;}


    @Override
    public BaseElement clone() {
        return new Paragraph(this);
    }


    @Override
    public void accept(Visitor visitor) {
        visitor.visitParagraph(this);
    }
}
