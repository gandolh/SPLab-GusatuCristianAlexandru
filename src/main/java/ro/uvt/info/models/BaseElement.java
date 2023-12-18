package ro.uvt.info.models;


import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import jakarta.persistence.Inheritance;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import ro.uvt.info.services.ElementDeserializer;

import java.util.ArrayList;
import java.util.List;

@Getter
@JsonDeserialize(using = ElementDeserializer.class)
@Inheritance
public abstract class BaseElement implements Visitee {

    @Setter
    @OneToMany(targetEntity = BaseElement.class)
    protected List<BaseElement> elementList;
    public BaseElement() {
        this.elementList = new ArrayList<>();
    }

    public void add(BaseElement e) {
        elementList.add(e);
    }
    public void remove(BaseElement e) {
        elementList.remove(e);
    }
    public BaseElement get(int index) {
        return elementList.get(index);
    }

    public abstract BaseElement clone();
}