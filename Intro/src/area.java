import java.util.Scanner;

public class area {
    public static void main(String[] args) {
        int length = 10;
        int breadth = 20;
        int area = length * breadth;
        System.out.println("Area of rectangle is: " + area);

        // add area of circle
        // change to read the radius from user input
        int radius;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the radius of circle: ");
        radius = sc.nextInt();
        double areaCircle = 3.14 * radius * radius;
        System.out.println("Area of circle is: " + areaCircle);
    }
}
