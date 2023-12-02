package ro.uvt.info.services;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ro.uvt.info.models.*;

import javax.swing.plaf.PanelUI;
import java.util.Iterator;
import java.util.List;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class JsonSerializer {
    private final BookSaveVisitor saveVisitor;

    public JsonSerializer() {
        saveVisitor = new BookSaveVisitor();
    }

    public String serialize(Visitee book) {
        saveVisitor.clearBuffer();
        book.accept(saveVisitor);
        return saveVisitor.getJson();
    }

    public String serialize(List<Visitee> books) {
        StringBuilder jsonBuilder = new StringBuilder();
        jsonBuilder.append("[");
        for (int i = 0; i < books.size(); i++) {
            saveVisitor.clearBuffer();
            books.get(i).accept(saveVisitor);
            jsonBuilder.append(saveVisitor.getJson());
            if (i != books.size() - 1)
                jsonBuilder.append(",");
        }
        jsonBuilder.append("]");

        return jsonBuilder.toString();
    }


    public void addElementListRecursive(JsonNode node, Section section)
    {
        JsonNode elementListNode = node.get("elementList");

        if(elementListNode !=null) {
            Iterator<JsonNode> elementList = elementListNode.elements();

            while (elementList.hasNext()){
                String title = node.get("title").asText();
                Section tmpSection = new Section(title);
                addElementListRecursive(elementList.next(), tmpSection);
                section.add(tmpSection);
            }

        }else{
            section.getElementList().add(deserializeBaseType(node));
        }
    }

    private Element deserializeBaseType(JsonNode node){
        String className = node.get("class").asText();

        if(className.equals(Image.class.toString())){
            String imageName = node.get("imageName").asText();
            return new Image(imageName);
        }
        if(className.equals(Paragraph.class.toString())){
            String text = node.get("text").asText();
            return new Paragraph(text);
        }

        if(className.equals(Table.class.toString())){
            String title = node.get("title").asText();
            return new Table(title);
        }
        return null;
    }

}
