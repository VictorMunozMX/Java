package BasicClass;

public class Motorcycle extends Cars implements confortable{

    public Motorcycle(String name, int speed, int colour) {
        super(name, speed, colour);
    }

    @Override
    public void speed() {
        System.out.println("Motorcycle are slower than a Car.");
    }

    @Override
    public void confor() {
        System.out.println("Motorcycle are not confortable such as a Car.");
    }

//    public void confortable(){
//        System.out.println("Motorcycle are not confortable.");
//    }

}
