package it.ioprogrammatore.feign.exception;

public class ProductServiceNotAvailableException extends RuntimeException {

    public ProductServiceNotAvailableException(String message) {
        super(message);
    }
}
