package ro.uvt.info.models;

import lombok.Getter;

import java.util.ArrayList;

public class Section extends Element implements Visitee {


    @Getter
    protected String title;

    public Section(String title) {
        this.title = title;
        elementList = new ArrayList<>();
    }

    public Section(Section other){
        this.title = other.title;
        this.elementList = new ArrayList<>(other.elementList);
    }





    @Override
    public Element clone() {
        return new Section(this);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitSection(this);
    }
}
