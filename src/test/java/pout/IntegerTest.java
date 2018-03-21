package pout;

import org.junit.Test;

import static org.junit.Assert.*;

public class IntegerTest {


    @Test public void zeroIsNeutralForAddition() {
        assertEquals(42, 42 + 0);
        assertEquals(0, 0 + 0);
        assertEquals(Integer.MIN_VALUE, Integer.MIN_VALUE + 0);
        assertEquals(Integer.MAX_VALUE, Integer.MAX_VALUE + 0);
    }


    @Test public void zeroIsAbsorbinglForMultiplication() {
        assertEquals(0, 42 * 0);
        assertEquals(0, 0 * 0);
        assertEquals(0, Integer.MIN_VALUE * 0);
        assertEquals(0, Integer.MAX_VALUE * 0);
    }


    @Test public void additionIsCommutative() {
        assertEquals(0 + 1, 1 + 0);
        assertEquals(-1+1, 1 + -1);
        assertEquals(42 + 24, 24 + 42);
    }

    @Test public void additionLeadsToBiggerNumbers() {
        int a = 1234567;
        int b = 4567890;
        assertTrue(a+b > a);
        assertTrue(a+b > b);
    }

    @Test public void multiplicationIsDistributiveOverAddition() {
        assertEquals((42*(31+5)) , (42*31) + (42*5));
    }

}
