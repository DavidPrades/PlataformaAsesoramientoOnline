package com.example.plataformaasesoramientoonline;

public class Administrar {

    private int logo;
    private String texto;

    public Administrar(int logo, String texto) {
        this.logo = logo;
        this.texto = texto;
    }

    public int getLogo() {
        return logo;
    }

    public void setLogo(int logo) {
        this.logo = logo;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
}
