package org.example;

public abstract class Comportamiento {

    private String tipo;
    private String color;
    private int price;

    public Comportamiento(String tipo, String color, int price) {
        this.tipo = tipo;
        this.color = color;
        this.price = price;
    }

    public String getColor () {
        return color;
    }
    public void setColor () {
        this.color = color;
    }
    public int getPrice () {
        return price;
    }
    public void setPrice (int price) {
        this.price = price;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void Mensaje(){
        System.out.println("Tipo de transporte " + tipo + " es de color " + color + " y tiene un precio de " + price);
    }

    public abstract void Speed(); // Método abstracto que debe ser implementado por las subclases

}
