package ro.uvt.info.designpatternslab2023;

import java.util.ArrayList;
import java.util.List;

public class Chapter {
    private String name;
    private List<SubChapter> subChapters;

    public Chapter(String name) {
        this.name = name;
        this.subChapters = new ArrayList<SubChapter>();
    }

    private void print(){}

    public int createSubChapter(String subChapterName) {
        SubChapter newSubChapter = new SubChapter(subChapterName);
        subChapters.add(newSubChapter);
        return subChapters.size();
    }

    public SubChapter GetSubChapter(int index) {
        return subChapters.get(index);
    }
}
