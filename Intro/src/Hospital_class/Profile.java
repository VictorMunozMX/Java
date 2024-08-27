package Hospital_class;

public abstract class Profile {

    String name;
    int edad;
    String sexo;

    public Profile(String name, int edad, String sexo) {
        this.name = name;
        this.edad = edad;
        this.sexo = sexo;
    }

    public String getName() {
        return name;
    }

    public int getEdad() {
        return edad;
    }

    public String getSexo() {
        return sexo;
    }

    public void setName() {
        this.name = name;
    }

    public void setEdad() {
        this.edad = edad;
    }

    public void setSexo() {
        this.sexo = sexo;
    }

    public void printProfile() {
        System.out.println("Nombre: " + name);
        System.out.println("Edad: " + edad);
        System.out.println("Sexo: " + sexo);
    }

    // abstract method just a contract, no body
    public abstract void piel();

}

