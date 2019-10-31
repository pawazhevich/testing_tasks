package by.bsu.triangle.util;

import by.bsu.triangle.exception.TriangleNegativeSideException;

public class TriangleWorker {

   public static boolean isTrianglePossible (double a, double b, double c) throws TriangleNegativeSideException{

       if (a<0 || b<0 || c<0) {
            throw new TriangleNegativeSideException("One of the sides is negative");
        }

       return (a <= b + c) && (b <= a + c) && (c <= a + b);
   }
}
