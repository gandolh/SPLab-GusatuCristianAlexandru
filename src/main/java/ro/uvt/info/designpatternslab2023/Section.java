package ro.uvt.info.designpatternslab2023;

import java.util.ArrayList;
import java.util.List;

public class Section implements Element {
    protected String title;
    protected List<Element> elements;

    public Section(String title) {
        this.title = title;
        elements = new ArrayList<>();
    }

    @Override
    public void print() {
        System.out.println(title);
        for (Element element :
                elements) {
            element.print();
        }
    }

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
