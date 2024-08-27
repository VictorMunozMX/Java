package Hospital_class;

public class Patient extends Profile implements rStatus{

    public Patient(String name, int edad, String sexo) {
        super(name, edad, sexo);
    }

    public void illness(){
        System.out.println("Covid-19");
    }

    //    public void status(){
//        System.out.println("Inactive");
//    }

    @Override
    public void status() {
        System.out.println("Patient Inactive");
    }

    @Override
    public void piel() {
        System.out.println("Test clara");
    }

}
