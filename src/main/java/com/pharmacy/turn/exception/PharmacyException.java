package com.pharmacy.turn.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PharmacyException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    private final String message;
}
