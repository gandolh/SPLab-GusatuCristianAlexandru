package ro.uvt.info;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import ro.uvt.info.models.*;
import ro.uvt.info.services.BookStatistics;
import ro.uvt.info.services.RenderContentVisitor;

@SpringBootApplication
public class DesignPatternsLab2023Application {

    public static void main(String[] args) {
//		SpringApplication.run(DesignPatternsLab2023Application.class, args);
        Section cap1 = new Section("Capitolul 1");
        Paragraph p1 = new Paragraph("Paragraph 1");
        cap1.add(p1);
        Paragraph p2 = new Paragraph("Paragraph 2");
        cap1.add(p2);
        Paragraph p3 = new Paragraph("Paragraph 3");
        cap1.add(p3);
        Paragraph p4 = new Paragraph("Paragraph 4");
        cap1.add(p4);
        cap1.add(new ImageProxy("ImageOne"));
        cap1.add(new Image("ImageTwo"));
        cap1.add(new Paragraph("Some text"));
        cap1.add(new Table("Table 1"));
//        cap1.accept(new RenderContentVisitor());
        BookStatistics stats = new BookStatistics();
        cap1.accept(stats);
        stats.printStatistics();

    }




}
