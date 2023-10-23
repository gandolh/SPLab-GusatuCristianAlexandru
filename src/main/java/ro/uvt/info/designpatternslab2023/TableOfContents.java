package ro.uvt.info.designpatternslab2023;

import java.util.ArrayList;
import java.util.List;

public class TableOfContents implements Element {
    private List<Element> elementList;

    public TableOfContents(){
        elementList = new ArrayList<>();
    }

    public TableOfContents(TableOfContents other){
        elementList = new ArrayList<>(other.elementList);
    }

    public void print(){}

    @Override
    public void add(Element e) {
        elementList.add(e);
    }

    @Override
    public void remove(Element e) {
        elementList.remove(e);
    }

    @Override
    public Element get(int index) {
        return elementList.get(index);
    }
}
