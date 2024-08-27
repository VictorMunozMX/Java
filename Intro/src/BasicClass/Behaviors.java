package BasicClass;

public abstract class Behaviors {

    String name;
    int speed;
    int colour;

    // create a constructor
    public Behaviors(String name, int speed, int colour) {
        this.name = name;
        this.speed = speed;
        this.colour = colour;
    }

    // create a method
    public void display() {
        System.out.println("Name: " + name);
        System.out.println("Speed: " + speed);
        System.out.println("Colour: " + colour);
    }

    // create an abstract method, this method will be implemented in the subclasses, also,
    // the subclasses will have their own implementation of this method.
    // besides, abstrac methos dosn't have a body.
    public abstract void speed();

    public void people(){
        System.out.println("Cars are used to transport people.");
    }

    public void size(){
        System.out.println("Cars come in different sizes.");
    }

}
