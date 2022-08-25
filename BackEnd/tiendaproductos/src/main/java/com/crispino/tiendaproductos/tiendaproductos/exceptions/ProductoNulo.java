package com.crispino.tiendaproductos.tiendaproductos.exceptions;


public class ProductoNulo extends Exception{
    public ProductoNulo() {
    }

    public ProductoNulo(String message) {
        super(message);
    }

    public ProductoNulo(String message, Throwable cause) {
        super(message, cause);
    }

    public ProductoNulo(Throwable cause) {
        super(cause);
    }

    public ProductoNulo(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
