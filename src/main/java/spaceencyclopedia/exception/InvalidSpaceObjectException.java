package spaceencyclopedia.exception;

public class InvalidSpaceObjectException extends Exception {

    public InvalidSpaceObjectException() {
        super("Invalid planet data.");
    }

    public InvalidSpaceObjectException(String message) {
        super(message);
    }
}