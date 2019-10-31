package by.bsu.triangle.util;

import by.bsu.triangle.exception.TriangleInvalidSideException;

public class TriangleWorker {

   public static boolean isTrianglePossible (double a, double b, double c) throws TriangleInvalidSideException {

       if (a<=0 || b<=0 || c<=0) {
            throw new TriangleInvalidSideException("Triangle sides must be positive");
        }

       return (a < b + c) && (b < a + c) && (c < a + b);
   }
}
