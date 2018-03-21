package properties;

import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.generator.InRange;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import org.junit.Ignore;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(JUnitQuickcheck.class)
public class IntegerProperties {

    @Property
    public void zeroIsNeutralForAddition(Integer a) {
        assertEquals(a, new Integer(a + 0));
    }

    @Property
    public void oneIsNeutralForMultiplication(Integer a) {
        assertEquals(a, new Integer(a * 1));
    }

    @Property
    public void zeroIsAbsorbingForMultiplication(Integer a) {
        assertEquals(new Integer(0), new Integer(a * 0));
    }

    @Property
    public void multiplicationIsCommutative(Integer a, Integer b) {
        assertEquals(a * b, b * a);
    }

    @Property
    public void additionIsCommutative(Integer a, Integer b) {
        assertEquals(a + b, b + a);
    }

    @Property
    public void additionIsAssociative(Integer a, Integer b, Integer c) {
        assertEquals(a + (b + c), (a + b) + c);
    }

    @Property
    public void multiplicationIsDistributiveOverAddition(Integer a, Integer b, Integer c) {
        assertEquals(a * (b + c), (a * b) + (a * c));
    }

    @Property
    @Ignore
    public void additionLeadsToBiggerIntegers_free(Integer a, Integer b) {
        assertTrue(a+b >= a);
        assertTrue(a+b >= b);
    }

    @Property
    @Ignore
    public void additionLeadsToBiggerIntegers_minBound(@InRange(minInt = 0) Integer a,
                                                       @InRange(minInt = 0) Integer b) {
        assertTrue(a+b >= a);
        assertTrue(a+b >= b);

    }

    @Property
    public void additionLeadsToBiggerIntegers(@InRange(minInt = 0, maxInt = Integer.MAX_VALUE/2) Integer a,
                                              @InRange(minInt = 0, maxInt = Integer.MAX_VALUE/2) Integer b) {
        assertTrue(a+b >= a);
        assertTrue(a+b >= b);

    }

}
