package demo;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class MyHeap implements Heap {

    public static Heap empty() { return new MyHeap(); }

    private PriorityQueue<Integer> contents;
    private MyHeap() { this.contents = new PriorityQueue<>(); }

    @Override public boolean isEmpty() { return contents.isEmpty(); }
    @Override public void insert(Integer elem) { contents.add(elem); }
    @Override public void merge(Heap that) { contents.addAll(that.flush()); }
    @Override public Integer head() { return contents.peek(); }
    @Override public Integer next() { return contents.poll(); }
    @Override public List<Integer> flush() {
        List<Integer> result = new LinkedList<>();
        while(!isEmpty()) { result.add(this.next()); }
        return result;
    }

    @Override public Heap copy() {
        Heap result = empty();
        for(Integer i: contents.toArray(new Integer[]{}))
            result.insert(i);
        return result;
    }


    @Override public String toString() { return contents.toString(); }

}
