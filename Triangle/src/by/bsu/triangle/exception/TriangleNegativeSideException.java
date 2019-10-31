package by.bsu.triangle.exception;

public class TriangleNegativeSideException extends Exception {
    public TriangleNegativeSideException() {
        super();
    }

    public TriangleNegativeSideException(String message) {
        super(message);
    }

    public TriangleNegativeSideException(String message, Throwable cause) {
        super(message, cause);
    }

    public TriangleNegativeSideException(Throwable cause) {
        super(cause);
    }
}
