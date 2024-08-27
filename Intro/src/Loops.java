public class Loops {
    public static void main(String[] args) {
        // for loop
        for (int i = 0; i < 5; i++) {
            System.out.println("for loop: " + i);
        }

        // while loop
        int j = 0;
        while (j < 5) {
            System.out.println("while loop: " + j);
            j++;
        }

        // do-while loop
        int k = 0;
        do {
            System.out.println("do-while loop: " + k);
            k++;
        } while (k < 5);

        // for-each loop
        int[] numbers = {1, 2, 3, 4, 5};
        for (int number : numbers) {
            System.out.println("for-each loop: " + number);
        }
    }
}
