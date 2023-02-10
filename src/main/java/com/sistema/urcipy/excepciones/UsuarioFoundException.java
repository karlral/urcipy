package com.sistema.urcipy.excepciones;

public class UsuarioFoundException extends Exception {
    public UsuarioFoundException() {
        super("El USUARIO con ese usuario ya existe, vualva a intentarlo");
    }
    public UsuarioFoundException(String mensaje) {
        super(mensaje);
    }
}
