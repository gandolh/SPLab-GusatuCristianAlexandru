package ro.uvt.info.designpatternslab2023;


import java.util.List;

public class Image implements Element {
    private String imageName;
    private List<Element> elementList;

    public Image(String imageName) {
        this.imageName = imageName;
    }

    public void print(){
        System.out.println("Image with name: " + imageName);
    }

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
