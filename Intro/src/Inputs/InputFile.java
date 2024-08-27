package Inputs;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class InputFile {

    public static void main(String[] args) throws Exception {

        try {
            File file = new File("C:/PRIVATE/Development/Java/Intro/src/Inputs/TestFile.txt");
            Scanner input = new Scanner(file);

            while (input.hasNextLine())
            {
                String line = input.nextLine();
                System.out.println(line);
            }
            input.close();

        } catch (FileNotFoundException e) {
            System.out.println("Missing file: " + e.getMessage());
        }

        System.out.println("Working Directory = " + System.getProperty("user.dir"));

        MyUtils myUtils = new MyUtils();
        System.out.println("Final Number: " + myUtils.calculate(11));

    }
}
