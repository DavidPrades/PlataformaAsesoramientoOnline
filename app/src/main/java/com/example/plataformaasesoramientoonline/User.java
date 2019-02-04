package com.example.plataformaasesoramientoonline;

public class User {

    private String name;
    private String email;
    private String compra;
    private int age;
    private double cm;
    private double peso;
    private String comentarios;

    public User(){

    }
    public User(String name, String email,String compra, int age, double height, double weight, String comentarios) {
        this.name = name;
        this.email = email;
        this.compra=compra;
        this.age = age;
        this.cm = height;
        this.peso = weight;
        this.comentarios = comentarios;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getCm() {
        return cm;
    }

    public void setCm(double cm) {
        this.cm = cm;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }
    public String getCompra() {
        return compra;
    }

    public void setCompra(String compra) {
        this.compra = compra;
    }
}
