package FReader;

import java.io.*;
import java.sql.SQLOutput;

public class AppFileRead {
    public static void main(String[] args) {

        File file = new File("C:/PRIVATE/Development/Java/Intro/src/Inputs/TestFile.txt");

        try (FileReader fr = new FileReader(file);
             BufferedReader br = new BufferedReader(fr);) {

            String line = br.readLine();
            while (line != null) {
                System.out.println(line);
                line = br.readLine();
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException t) {
            System.out.println("Problem reading the file" + file.getName());
        }

    }
}
