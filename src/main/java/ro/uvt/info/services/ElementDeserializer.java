package ro.uvt.info.services;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import ro.uvt.info.models.*;

import javax.swing.text.StyledEditorKit;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ElementDeserializer extends StdDeserializer<Element> {
    public ElementDeserializer() {
        this(null);
    }

    public ElementDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public Element deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JacksonException {
        JsonSerializer serializer = new JsonSerializer();
        JsonNode node = jp.getCodec().readTree(jp);
        String className = node.get("class").asText();

        if(className.equals(Book.class.toString())){
            String title = node.get("title").asText();
            var book = new Book(title);
            serializer.addElementListRecursive(node, book);
            return book;
        }


        return null;
    }


}
