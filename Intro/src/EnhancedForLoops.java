import java.util.Arrays;
import java.util.List;

public class EnhancedForLoops {

    public static void main(String[] args) {
        int[] primeNumbers = {2, 3,5,7,11,13,17,19};
        for (int primeNumber : primeNumbers) {
            System.out.println(primeNumber);
        }

        List<String> list = Arrays.asList("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday");
        for (String day : list) {
            System.out.println(day);
        }

        int[] randomNumbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        for (int number : randomNumbers) {
            if (number > 5){
                System.out.println(number);
            }
        }
    }
}
