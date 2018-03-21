package demo;

import java.util.List;

public interface Heap {

    boolean isEmpty();

    void insert(Integer elem);
    void merge(Heap that);

    Integer head();
    Integer next();
    List<Integer> flush();

    Heap copy();

}
