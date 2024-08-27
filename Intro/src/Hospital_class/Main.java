package Hospital_class;

public class Main {
    public static void main(String[] args) {

//        Profile profile = new Profile("Juan", 25, "Masculino");
//        profile.printProfile();
//        profile.name = "Enrique";
//        profile.edad = 30 + 10;
//        String tmp = profile.getName();
//        System.out.println("New Nombre: " + tmp);
//        System.out.println("New Edad: " + profile.getEdad());

        Doctor doctor = new Doctor("Dr. Pedro", 40, "Masculino");
        doctor.printProfile();
        doctor.status();
        doctor.piel();

        Patient patient = new Patient("Maria", 30, "Femenino");
        patient.printProfile();
        patient.status();
        patient.piel();

    }
}
