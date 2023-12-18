package ro.uvt.info.models;


import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import ro.uvt.info.services.ElementDeserializer;

import java.util.ArrayList;
import java.util.List;

@Getter
@JsonDeserialize(using = ElementDeserializer.class)
@Inheritance()
@Entity
public abstract class BaseElement implements Visitee {
    @Id
    @GeneratedValue
    private Long id;

    public BaseElement() {}

    public void add(BaseElement e) {}
    public void remove(BaseElement e) {}
    public BaseElement get(int index) { throw new UnsupportedOperationException("not implemented for BaseElement");}
    public BaseElement clone(){
        throw new UnsupportedOperationException("not implemented for BaseElement");
    }
}
