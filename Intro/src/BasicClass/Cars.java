package BasicClass;

public class Cars extends Behaviors implements confortable{

    public Cars(String name, int speed, int colour) {
        super(name, speed, colour);
    }

    @Override
    public void speed() {
        System.out.println("Cars are faster than a Motorcycle.");
    }

    public void fuel(){
        System.out.println("Cars run on fuel.");
    }

    @Override
    public void confor() {
        System.out.println("Cars are confortable than a Motorcycle.");
    }

//    public void confortable(){
//        System.out.println("Cars are confortable.");
//    }

}
