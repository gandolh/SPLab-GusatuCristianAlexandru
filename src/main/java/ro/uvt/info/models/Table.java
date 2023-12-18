package ro.uvt.info.models;



import lombok.Getter;

import java.util.ArrayList;

public class Table extends BaseElement implements Visitee {
    @Getter
    private String title;

    public Table() {
        title = "";
    }

    public Table(String title) {
        this.title = title;
    }
    public Table(Table other){
        this.title = other.title;
        this.elementList = new ArrayList<>(other.elementList);
    }


    @Override
    public BaseElement clone() {
        return new Table(this);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitTable(this);
    }
}
