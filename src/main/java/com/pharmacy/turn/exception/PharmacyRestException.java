package com.pharmacy.turn.exception;

public class PharmacyRestException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public PharmacyRestException(String message) {
        super(message);
    }

}
