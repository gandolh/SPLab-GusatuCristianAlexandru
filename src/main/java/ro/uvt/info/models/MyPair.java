package ro.uvt.info.models;

public class MyPair<T1, T2> {
    public T1 first;
    public T2 second;

    public MyPair(T1 first, T2 second) {
        this.first = first;
        this.second = second;
    }
}
