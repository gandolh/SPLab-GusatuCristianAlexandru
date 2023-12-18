package ro.uvt.info.models;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;

import java.util.ArrayList;
@Entity
@jakarta.persistence.Table(name = "ContentTable")
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
