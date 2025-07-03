package ListasApp;

import java.util.Arrays;

public class ListApp {

    public static void main(String[] args) {

        ArraysTest array = new ArraysTest();
        array.setSize(10);
        array.createArray();

        System.out.println("Array elements:" + Arrays.toString(array.getArray()));
        array.sortArray();
        System.out.println("Array elements:" + Arrays.toString(array.getArray()));

        
    }
}
