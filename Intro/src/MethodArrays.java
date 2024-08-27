public class MethodArrays {
    public static void main(String[] args) {
        //create an array of integers
        Integer[] myArray = {1, 2, 3, 4, 5};
        //create an array of strings
        String[] myStringArray = {"A", "B", "C", "D", "E"};

        // call a method that recived the array of integers or strings and print the elements
        printArray(myArray);
        printArray(myStringArray);

        System.out.println("Arrays");
        int[] array = new int[10];
        array[0] = 1;
        array[9] = 15;
        System.out.println(array[0]);
        System.out.println(array[9]);
    }

    //create a method that recived an array of integers and print the elements
    public static <T> void printArray(T[] array) {
        for (T element : array) {
            System.out.println(element);
        }
    }
}



