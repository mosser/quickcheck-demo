package properties;

import com.pholser.junit.quickcheck.From;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import demo.Heap;
import generators.Empty;
import generators.EmptyHeapGenerator;
import org.junit.runner.RunWith;


import java.util.List;

import static org.junit.Assert.*;

@RunWith(JUnitQuickcheck.class)
public class HeapProperties {


    @Property
    public void theEmptyHeapIsEmpty(@From(EmptyHeapGenerator.class) Heap theHeap) {
        assertTrue(theHeap.isEmpty());
    }

    @Property
    public void theFirstElementIsTheNextOne(@Empty Heap theHeap, Integer e) {
        theHeap.insert(e);
        assertEquals(e, theHeap.next());
    }

    @Property
    public void gettingNextElementRemovesIt(@Empty Heap theHeap, Integer e) {
        theHeap.insert(e);
        theHeap.next();
        assertTrue(theHeap.isEmpty());
    }

    @Property
    public void nextElementOfAnEmptySetIsNull(@Empty Heap theHeap) {
        assertNull(theHeap.next());
    }

    @Property
    public void theHeapSortsElements(@Empty Heap h, List<Integer> elems) {
        for(Integer i: elems)
            h.insert(i);
        elems.sort(Integer::compareTo);
        assertEquals(elems, h.flush());
    }

    @Property
    public void copyCreateANewHeap(Heap h) {
        Heap copy = h.copy();
        h.flush();
        assertTrue(h.isEmpty());
        assertFalse(copy.isEmpty());
    }

    @Property
    public void sortingElementsFlushTheHeap(Heap h) {
        assertFalse(h.isEmpty());
        h.flush();
        assertTrue(h.isEmpty());
    }

    @Property
    public void nextIsOkWhenMerged(Heap left, Heap right) {
        Heap merged = left.copy(); merged.merge(right.copy());
        assertEquals(Math.min(left.head(),right.head()), (int) merged.head());
    }

    @Property
    public void mergeIsCommutative(Heap left, Heap right) {
        Heap lr = left.copy();  lr.merge(right.copy());
        Heap rl = right.copy(); rl.merge(left.copy());
        assertEquals(lr.flush(), rl.flush());
    }

}
