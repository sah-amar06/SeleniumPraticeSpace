package Selenium;

public class ElementException extends RuntimeException {

    public ElementException(String message) {
        super(message);
    }

    public ElementException(String message, Throwable cause) {
        super(message, cause);
    }
}
