package org.example;

public class Car extends Comportamiento implements Mtto{

    public Car(String tipo, String color, int price) {
        super(tipo, color, price);
    }

    public void Speed() {
        System.out.println("El coche tiene una velocidad menor a 200 km/h");
    }

    public void Mantenimiento() {
        System.out.println("El coche tiene un mantenimiento cada 6 meses");
    }

    public double Costo(){
        return getPrice()*.1;
    }

}
