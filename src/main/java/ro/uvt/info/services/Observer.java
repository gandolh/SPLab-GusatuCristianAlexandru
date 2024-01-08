package ro.uvt.info.services;

import ro.uvt.info.models.Book;

import java.io.IOException;

public interface Observer {
    void update(Book book) throws IOException;
}
