package com.crispino.tiendaproductos.tiendaproductos.exceptions;

public class ProductoExiste extends Exception{
    public ProductoExiste() {
    }

    public ProductoExiste(String message) {
        super(message);
    }

    public ProductoExiste(String message, Throwable cause) {
        super(message, cause);
    }

    public ProductoExiste(Throwable cause) {
        super(cause);
    }

    public ProductoExiste(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
