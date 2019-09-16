import org.junit.Test;

import static org.junit.Assert.*;

public class VectorTest {

    public static int round(int value) {

        return (int) Math.round(value / (double) Vector.factor) * Vector.factor;
    }

    @Test
    public void testEquals1() {

        Vector a = new Vector(1, 2, 3);
        Vector b = new Vector(1, 2, 3);

        assertTrue(a.equals(b));
    }

    @Test
    public void testEquals2() {

        Vector a = new Vector(1, 2, 3);
        Vector b = new Vector(4, 5, 6);

        assertFalse(a.equals(b));
    }

    @Test
    public void testLength1() {

        Vector v = new Vector(1_000, 1_000, 0);
        assertEquals(1_414, v.calculateLength());
    }

    @Test
    public void testLength2() {

        Vector v = new Vector(0, 0, 0);
        assertEquals(0, v.calculateLength());
    }

    @Test
    public void testLength3() {

        Vector v = new Vector(35_000, 120_000, 10_000);
        assertEquals(125_000, VectorTest.round(v.calculateLength()));
    }

    @Test
    public void testAdd1() {

        Vector v = new Vector(35_000, 120_000, 10_000);
        Vector sum = v.add(Vector.ZERO);

        assertEquals(v, sum);
    }

    @Test
    public void testAdd2() {

        Vector v1 = new Vector(35_000, 120_000, 10_000);
        Vector v2 = new Vector(1_000, 1_000, -5_000);
        Vector sum = v1.add(v2);

        assertEquals(new Vector(36_000, 121_000, 5_000), sum);
    }

    @Test
    public void testSubtract1() {

        Vector v = new Vector(35_000, 120_000, 10_000);
        Vector difference = v.subtract(Vector.ZERO);

        assertEquals(v, difference);
    }

    @Test
    public void testSubtract2() {

        Vector v1 = new Vector(35_000, 120_000, 10_000);
        Vector v2 = new Vector(1_000, 1_000, -5_000);
        Vector difference = v1.subtract(v2);

        assertEquals(new Vector(34_000, 119_000, 15_000), difference);
    }

    @Test
    public void testMultiply1() {

        Vector v = new Vector(35_000, 120_000, 10_000);
        Vector product = v.multiply(0);

        assertEquals(Vector.ZERO, product);
    }

    @Test
    public void testMultiply2() {

        Vector v = new Vector(35_000, 120_000, 10_000);
        Vector product = v.multiply(1_000);

        assertEquals(v, product);
    }

    @Test
    public void testMultiply3() {

        Vector v = new Vector(35_000, 120_000, 10_000);
        Vector product = v.multiply(2_500);

        assertEquals(new Vector(87_500, 300_000, 25_000), product);
    }

    @Test(expected = ArithmeticException.class)
    public void testDivide1() {

        Vector v = new Vector(35_000, 120_000, 10_000);
        v.divide(0);
    }

    @Test
    public void testDivide2() {

        Vector v = new Vector(35_000, 120_000, 10_000);
        Vector quotient = v.divide(1_000);

        assertEquals(v, quotient);
    }

    @Test
    public void testDivide3() {

        Vector v = new Vector(35_000, 120_000, 10_000);
        Vector quotient = v.divide(2_500);

        assertEquals(new Vector(14_000, 48_000, 4_000), quotient);
    }

    @Test
    public void testFlatten() {

        Vector v = new Vector(3_423, 24_356, 1_345);
        v = v.flatten();
        assertEquals(new Vector(3_423, 24_356, 0), v);
    }

    @Test
    public void testNormalize() {

        Vector v = new Vector(3_214, 24344_234, 326_034);
        v = v.normalize();

        int roundedLength = VectorTest.round(v.length);
        assertEquals(1000, roundedLength);
    }
}
