package ro.uvt.info.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;

@Entity
public class Paragraph extends BaseElement implements Visitee {
    @Id
    @GeneratedValue
    private int id;

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
