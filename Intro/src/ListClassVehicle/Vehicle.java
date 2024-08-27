package ListClassVehicle;

public class Vehicle {

    private String name;
    private String color;
    private boolean fourWheels;

    public Vehicle(String name, String color, boolean fourWheels) {
        this.name = name;
        this.color = color;
        this.fourWheels = fourWheels;
    }

    public String getName() {
        return name;
    }
    public String getColor() {
        return color;
    }
    public boolean getFourWheels() {
        return fourWheels;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public void setFourWheels(boolean fourWheels) {
        this.fourWheels = fourWheels;
    }

    public String toString() {
        return "Name: " + name + ", Color: " + color + ", Four Wheels: " + fourWheels;
    }

}
