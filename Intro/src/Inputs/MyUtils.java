package Inputs;

public class MyUtils {

    // creating a new exception using exception handling
    public int calculate(int number) throws Exception {
        if (number < 10) {
            throw new fooException("Number is less than 10");
        }
        return number - 10;
    }

    public class fooException extends Exception {
        public fooException(String message) {
            super(message);
        }
    }

}
