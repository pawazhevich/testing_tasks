package by.bsu.triangle.util;

import by.bsu.triangle.exception.TriangleInvalidSideException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TriangleWorkerTest {

    @Test
    public void isTrianglePossibleTestSideEqualSum() throws TriangleInvalidSideException {
        double a = 4;
        double b = 5;
        double c = a + b;
        assertFalse(TriangleWorker.isTrianglePossible(a,b,c));
    }

    @Test
    public void isTrianglePossibleTestSideMoreSum() throws TriangleInvalidSideException {
        double a = 7;
        double b = 8;
        double c = a + b + 1;
        assertFalse(TriangleWorker.isTrianglePossible(c,a,b));
    }

    @Test
    public void isTrianglePossibleTestOneSideZero() {
        double a = 0;
        double b = 1;
        double c = 3;
        assertThrows(TriangleInvalidSideException.class, ()-> {
           TriangleWorker.isTrianglePossible(a,b,c);
        });
    }

    @Test
    public void isTrianglePossibleTestTooBigValues() throws TriangleInvalidSideException {
        double max = Double.MAX_VALUE - 10;
        double a = 3 + max;
        double b = 5 + max;
        double c = 4 + max;
        assertTrue(TriangleWorker.isTrianglePossible(a,b,c));
    }

    @Test
    public void isTrianglePossibleTestEquilateralTriangle() throws TriangleInvalidSideException {
        double a = 1;
        double b = 1;
        double c = 1;
        assertTrue(TriangleWorker.isTrianglePossible(a,b,c));
    }

    @Test
    public void isTrianglePossibleTestNaN() throws TriangleInvalidSideException {
        double a = 3;
        double b = 5;
        double c = Double.NaN;
        assertThrows(TriangleInvalidSideException.class, ()->{
           TriangleWorker.isTrianglePossible(a,b,c);
        });
    }
}