package com.restaurante.handler;

public class NegocioExeption extends RuntimeException {

    public NegocioExeption(String message) {
        super(message);
    }
}
