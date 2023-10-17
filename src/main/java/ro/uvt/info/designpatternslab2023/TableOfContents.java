package ro.uvt.info.designpatternslab2023;

import java.util.List;

public class TableOfContents implements Element {
    private List<Element> elements;

    public void print(){}

    @Override
    public void add(Element e) {
        elements.add(e);
    }

    @Override
    public void remove(Element e) {
        elements.remove(e);
    }

    @Override
    public Element get(int index) {
        return elements.get(index);
    }
}
