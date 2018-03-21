package generators;

import com.pholser.junit.quickcheck.generator.GenerationStatus;
import com.pholser.junit.quickcheck.generator.Generator;
import com.pholser.junit.quickcheck.random.SourceOfRandomness;
import demo.Heap;

public class HeapGenerator extends Generator<Heap> {

    public HeapGenerator() { super(Heap.class); }

    private boolean isEmpty;

    @Override
    public Heap generate(SourceOfRandomness sourceOfRandomness, GenerationStatus generationStatus) {
        if(isEmpty) {
            return gen().make(EmptyHeapGenerator.class)
                    .generate(sourceOfRandomness, generationStatus);
        } else {
            return gen().make(NonEmptyHeapGenerator.class)
                    .generate(sourceOfRandomness, generationStatus);
        }
    }

    public void configure(Empty empty) { this.isEmpty = true; }

}
