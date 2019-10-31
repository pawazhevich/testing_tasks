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
    public void isTrianglePossibleTestSideLessSum() throws TriangleInvalidSideException {
        double a = 7;
        double b = 8;
        double c = a + b - 1;
        assertFalse(TriangleWorker.isTrianglePossible(c,a,b));
    }

    


}