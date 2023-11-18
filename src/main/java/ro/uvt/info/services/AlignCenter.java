package ro.uvt.info.services;

public class AlignCenter implements AlignStrategy{
    @Override
    public void render(String text) {
        System.out.println(  "#" + text + "#");
    }
}
