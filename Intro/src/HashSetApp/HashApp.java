package HashSetApp;

import java.util.HashSet;
import java.util.LinkedHashSet;

public class HashApp {
    public static void main(String[] args) {

        // HashSet is a collection that does not allow duplicate elements
        // it does not guarantee the order of the elements
        // HashSet<Integer> values = new HashSet<Integer>();

        // if I want to keep the order of the elements I can use LinkedHashSet
        LinkedHashSet<Animal> animals = new LinkedHashSet<Animal>();

        //HashSet<Animal> animals = new HashSet<Animal>();
        Animal animal1 = new Animal("Dog", 5);
        Animal animal2 = new Animal("Cat", 3);
        Animal animal3 = new Animal("Bird", 2);
        Animal animal4 = new Animal("Dog", 5);
        Animal animal5 = new Animal("Kangaroo", 5);

        animals.add(animal1);
        animals.add(animal2);
        animals.add(animal3);
        animals.add(animal4);
        animals.add(animal5);

        System.out.println(animal1.equals(animal4));

        for (Animal animal : animals) {
            System.out.println(animal);
        }

    }

}
