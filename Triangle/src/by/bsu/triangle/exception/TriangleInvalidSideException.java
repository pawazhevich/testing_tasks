package by.bsu.triangle.exception;

public class TriangleInvalidSideException extends Exception {
    public TriangleInvalidSideException() {
        super();
    }

    public TriangleInvalidSideException(String message) {
        super(message);
    }

    public TriangleInvalidSideException(String message, Throwable cause) {
        super(message, cause);
    }

    public TriangleInvalidSideException(Throwable cause) {
        super(cause);
    }
}
