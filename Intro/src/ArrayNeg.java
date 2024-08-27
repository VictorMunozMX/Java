import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArrayNeg {
    public static void main(String[] args) {
        // Define the input string
        String numbers = "1 -2 -5 3";

        // Create a Scanner object for the input string
        Scanner lineScanner = new Scanner(numbers);

        // Create a List to store the integers
        List<Integer> array = new ArrayList<>();

        // Read each integer from the input string and add it to the list
        while (lineScanner.hasNextInt()) {
            int x = lineScanner.nextInt();
            array.add(x);
        }

        // Close the Scanner
        lineScanner.close();

        // Iterate over the list and print negative numbers
        int size = array.size();
        int sum = 0;
        int res = 0;
        int vec = 0;
        int cnt = size;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < cnt; j++) {
                while (vec <= i) {
                    sum += array.get(j + vec);
                    vec++;
                }
                if (sum < 0) {
//                    res += sum;
                    res++;
                }
                vec = 0;
                sum = 0;
            }
            cnt--;
        }
        System.out.println("Number of lines: " + res);
    }
}
