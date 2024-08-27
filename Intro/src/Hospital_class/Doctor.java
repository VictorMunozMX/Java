package Hospital_class;

public class Doctor extends Profile implements rStatus{

    public Doctor(String name, int edad, String sexo) {
        super(name, edad, sexo);
    }

    public void type(){
        System.out.println("Surgeon");
    }

    @Override
    public void status() {
        System.out.println("Doctor Active");
    }

    @Override
    public void piel() {
        System.out.println("Test oscura");
    }

}
