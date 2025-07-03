package Test01;
import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.function.Predicate;

public class LambdaTest {

    public static void main(String[] args){

        System.out.println("Hello Victor");

        Scanner sc = new Scanner(System.in);

        // return the factorial of a number
        System.out.println("Give the factorial of a number");
        System.out.println("Enter a number: ");
        int n = sc.nextInt();

        // using a lambda expression to calculate the factorial
        Factorial f = (int x) -> {
            int result = 1;
            for(int i = 1; i <= x; i++){
                result *= i;
            }
            return result;
        };
        System.out.println("The factorial of " + n + " --> " + f.fact(n));

        // clear the buffer
        sc.nextLine();

        // return a word in uppercase
        System.out.println("Give a string to convert to uppercase");
        String s = sc.nextLine();
        Cadena c = (x) -> x.toUpperCase();
        System.out.println("The string in uppercase: " + c.cad(s));

        System.out.println("Give the money that you needed:");
        double money = sc.nextDouble();
        Interes tot = (y) -> y * 1.10;

        // give format to a number
        DecimalFormat df = new DecimalFormat("#.00");
        System.out.println("The total money is: " + df.format(tot.total(money)));

    }
}

interface Factorial{
    int fact(int n);
}

interface Cadena{
    String cad(String s);
}

interface Interes{
    double total(double money);
}