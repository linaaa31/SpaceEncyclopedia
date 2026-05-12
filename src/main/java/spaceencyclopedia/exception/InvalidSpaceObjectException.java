package spaceencyclopedia.exception;
/**
 * Represents a custom exception for invalid space object data.
 */
public class InvalidSpaceObjectException extends Exception {
    /**
     * Creates an exception with a default error message.
     */
    public InvalidSpaceObjectException() {
        super("Invalid planet data.");
    }
    /**
     * Creates an exception with a custom error message.
     */
    public InvalidSpaceObjectException(String message) {
        super(message);
    }
}