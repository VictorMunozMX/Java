package org.example;

public class Bike extends Comportamiento implements Contrato {

    public Bike(String tipo, String color, int price) {
        super(tipo, color, price);
    }

    @Override
    public void Speed() {
        System.out.println("La bicicleta tiene una velocidad maxima a 30 km/h");
    }

    public void Color(){
        System.out.println("Bike color: " + getColor());
    }

    @Override
    public void Comfort() {
        System.out.println("La bicicleta es no comoda para viajes largos");
    }

}
