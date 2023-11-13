package ro.uvt.info.models;


import java.util.ArrayList;
import java.util.List;

public abstract class Element {

    protected List<Element> elementList;
    public Element() {
        this.elementList = new ArrayList<>();
    }

    public void add(Element e) {
//        el
        elementList.add(e);
    }
    public void remove(Element e) {
        elementList.remove(e);
    }
    public Element get(int index) {
        return elementList.get(index);
    }

    public abstract void print();
    public abstract Element clone();
}
