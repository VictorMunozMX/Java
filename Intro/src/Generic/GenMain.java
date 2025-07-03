package Generic;

import java.util.ArrayList;

public class GenMain {
    public static void main(String[] args) {

        Container<Integer, String> container1 = new Container<>(1, "Hello");
//        container.setItem1(10);
//        container.setItem2("World");
        container1.printItems();

        Container<Integer, Integer> container2 = new Container<>(1, 100);
//        container.setItem1(10);
//        container.setItem2("World");
        container2.printItems();
    }

}
