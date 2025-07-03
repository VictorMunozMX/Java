package ListasApp;

import java.util.Arrays;

public class ArraysTest {

    private int[] array;
    private int size;

    public ArraysTest() {
        this.size = size;
    }

    public int getSize() {
        return size;
    }
    public void setSize(int size) {
        this.size = size;
        this.array = new int[size];
    }
    public int[] getArray() {
        return array;
    }
    public void setArray(int[] array) {
        this.array = array;
    }

    // create an array with the size of the object
    public int[] createArray() {
        for (int i = 0; i < array.length; i++) {
            if (i % 2 == 0) {
                array[i] = i - 2;
            } else {
                array[i] = i;
            }
        }
        return array;
    }

    public int[] sortArray() {
        Arrays.sort(array);
        return array;
    }


}
