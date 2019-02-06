package com.example.plataformaasesoramientoonline;

public class Entrenamientos {

    private String titulo;
    private String precio;
    private String description;

    public Entrenamientos(String titulo, String precio, String description) {
        this.titulo = titulo;
        this.precio = precio;
        this.description = description;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
