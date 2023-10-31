package ro.uvt.info.designpatternslab2023;

public class AlignRight implements AlignStrategy{
    @Override
    public void render(Paragraph paragraph) {
        System.out.println("Paragraph: " + "#" + paragraph.getText());
    }
}
