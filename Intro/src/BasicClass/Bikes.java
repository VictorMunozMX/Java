package BasicClass;

public class Bikes extends Behaviors{

    public Bikes(String name, int speed, int colour) {
        super(name, speed, colour);
    }

    @Override
    public void speed() {
        System.out.println("Bikes are slower than a Car and Motorcycle.");
    }

    // override the people method
    public void people(){
        System.out.println("Bikes are used to transport just one person.");
    }

    public void porpuse(){
        System.out.println("Bikes are used for exercise and transportation.");
    }
}
