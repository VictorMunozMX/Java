package org.example;

public class Bus extends Comportamiento {

    public Bus(String tipo, String color, int price) {
        super(tipo, color, price);
    }

    @Override
    public void Speed() {
        System.out.println("El bus tiene una velocidad menor a 100 km/h");
    }

    public void Mensaje(){
        System.out.println("Tipo de transporte Escolar");
    }

    public void Mantenimiento() {
        System.out.println("El bus tiene un mantenimiento cada 3 meses");
    }

    public double Costo(){
        return getPrice()*.2;
    }

}
