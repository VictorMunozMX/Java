package BasicClass;

public class Store {
    public static void main(String[] args) {

      Cars car = new Cars("Toyota", 100, 1);
      car.people();
      car.fuel();
      car.confor();

      Bikes bike = new Bikes("BMX", 50, 2);
      bike.people();
      bike.porpuse();

      Motorcycle moto = new Motorcycle("Harley", 150, 3);
      moto.confor();

      car.speed();
      bike.speed();
      moto.speed();
    }
}