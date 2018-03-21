package generators;

import com.pholser.junit.quickcheck.generator.GenerationStatus;
import com.pholser.junit.quickcheck.generator.Generator;
import com.pholser.junit.quickcheck.random.SourceOfRandomness;
import demo.Heap;
import demo.MyHeap;

public class EmptyHeapGenerator extends Generator<Heap> {

    public EmptyHeapGenerator() { super(Heap.class); }

    @Override
    public Heap generate(SourceOfRandomness sourceOfRandomness, GenerationStatus generationStatus) {
        return MyHeap.empty();
    }


}
