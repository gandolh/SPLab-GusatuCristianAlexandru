package ro.uvt.info.models;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
@Getter
@Setter
public class Section extends BaseElement implements Visitee {
    protected String title;

    public Section() {
        title = "";
        elementList = new ArrayList<>();
    }

    public Section(String title) {
        this.title = title;
        elementList = new ArrayList<>();
    }

    public Section(Section other){
        this.title = other.title;
        this.elementList = new ArrayList<>(other.elementList);
    }





    @Override
    public BaseElement clone() {
        return new Section(this);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitSection(this);
    }
}
