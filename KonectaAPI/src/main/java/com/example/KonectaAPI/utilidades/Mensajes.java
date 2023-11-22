package com.example.KonectaAPI.utilidades;

public enum Mensajes {
ERROR_REGISTRO("Error en el registro");
    private String mensaje;

    Mensajes(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
