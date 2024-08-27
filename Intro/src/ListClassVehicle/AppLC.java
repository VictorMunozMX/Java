package ListClassVehicle;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class AppLC {
    public static void main(String[] args){

        // AyyayList is better for adding and removing elements. Also Arraylist
        // is implemnt from LinkeidList
        List<Vehicle> vehicles = new LinkedList<Vehicle>();
//        ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
        vehicles.add(new Vehicle("Golf", "Red", true));
        vehicles.add(new Vehicle("Murano", "Black", false));
        vehicles.add(new Vehicle("Neon", "Blue", true));

        List<Student> students = new ArrayList<Student>();
        students.add(new Student("John", 20));
        students.add(new Student("Mary", 22));
        students.add(new Student("Paul", 21));

//        for (Vehicle vehicle : vehicles) {
//            System.out.println(vehicle);
//        }

        // instead use a for I create a method to print the elements. Outside the main class
        // this is another option to print the elements to simplify code
        printElements(vehicles);
        printElements(students);
    }

    // This method is not necessary, but it is a good practice to create a method
    public static void printElements(List<?> list){
        for (Object element : list) {
            System.out.println(element);
        }
    }

}
