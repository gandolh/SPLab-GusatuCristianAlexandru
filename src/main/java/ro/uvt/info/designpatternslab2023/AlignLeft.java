package ro.uvt.info.designpatternslab2023;

public class AlignLeft implements AlignStrategy {
    @Override
    public void render(Paragraph paragraph) {
        System.out.println("Paragraph: "  + paragraph.getText() + "#");
    }
}
