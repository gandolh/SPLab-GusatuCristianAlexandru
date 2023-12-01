package ro.uvt.info.models;

import java.util.List;

public interface Repository<T> {
    public List<T> getAll();
    public T find(String Id);
    void add(T obj);
}
