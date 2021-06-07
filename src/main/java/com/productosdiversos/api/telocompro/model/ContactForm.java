package com.productosdiversos.api.telocompro.model;

public class ContactForm {
    
    private String correo;

    private String nombre;

    private String mensaje;

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    @Override
    public String toString() {
        return "ContactForm [correo=" + correo + ", mensaje=" + mensaje + ", nombre=" + nombre + "]";
    }

}
