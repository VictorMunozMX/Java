package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Car car = new Car("Carro", "Rojo", 20000);
        car.Mensaje();
        car.Speed();

        Bus bus = new Bus("Bus", "Azul", 50000);
        bus.Mensaje();
        bus.Speed();

        Bike bike = new Bike("Bicicleta", "Verde", 500);
        bike.Mensaje();
        bike.Speed();
        bike.Color();
        bike.Comfort();

        car.Mantenimiento();
        bus.Mantenimiento();

        System.out.println("El costo de mantenimiento para el " + car.getTipo() + " es de " + car.Costo());
        System.out.println("El costo de mantenimiento para el " + bus.getTipo() + " es de " + car.Costo());

        ConnectDB db = new ConnectDB();
        db.Users();

    }
}