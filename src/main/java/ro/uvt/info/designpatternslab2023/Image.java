package ro.uvt.info.designpatternslab2023;


public class Image implements Element {
    private String imageName;


    public Image(String imageName) {
        this.imageName = imageName;
    }

    public void print(){
        System.out.println("Image with name: " + imageName);
    }
}
