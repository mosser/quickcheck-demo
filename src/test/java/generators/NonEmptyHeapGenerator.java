package generators;

import com.pholser.junit.quickcheck.generator.GenerationStatus;
import com.pholser.junit.quickcheck.generator.Generator;
import com.pholser.junit.quickcheck.random.SourceOfRandomness;
import demo.Heap;
import demo.MyHeap;

public class NonEmptyHeapGenerator extends Generator<Heap> {

    public NonEmptyHeapGenerator() { super(Heap.class); }

    private int minElements = 1;
    private int maxElements = 100;

    @Override
    public Heap generate(SourceOfRandomness sourceOfRandomness, GenerationStatus generationStatus) {
        int howManyElements = sourceOfRandomness.nextInt(minElements,maxElements);
        Heap theHeap = MyHeap.empty();
        for(int i = 0; i < howManyElements; i++) {
            theHeap.insert(sourceOfRandomness.nextInt());
        }
        return theHeap;
    }


}
