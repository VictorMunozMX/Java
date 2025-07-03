import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello, Streams!");

        // Print 1 to 9 with intStream
        IntStream.range(1, 10)
                .forEach((x)-> System.out.print(x));
        System.out.println();

        // Print 1 to 9 with intStream and skip 5
        IntStream.range(1, 10)
                .skip(5)
                .forEach((x)-> System.out.print(x));
        System.out.println();

        // Print 1 to 9 with intStream and sum
        int val = IntStream.range(1, 5)
                .sum();
                System.out.print(val);
        System.out.println();

        // Show the stream of string and find the first element
        Stream.of("Hello", "Bye", "Welcome","Thanks")
                .sorted()
                .findFirst()
                .ifPresent((x)-> System.out.print(x));
        System.out.println();

        // Show the stream of string and find the items with c and sort
        String[] items = {"car", "bus", "suv","truch","van","cycle"};
        Stream.of(items)
                .filter((x)-> x.startsWith("c"))
                .sorted()
                .forEach((x)-> System.out.print(x + ", "));
        System.out.println();

        // get the average of the square of the numbers
        Arrays.stream(new int[] {5, 2, 7, 1, 3})
                .map(x-> x * x)
                .average()
                .ifPresent((x)-> System.out.print(x));
        System.out.println();

        // get the list of string and convert to lower case and filter the string starting with b
        List<String> list = Arrays.asList("Hello", "Bye", "Welcome","Thanks", "Bonsiur", "Weird");
        list.stream()
                .map(String::toLowerCase)
                .filter((x)-> x.startsWith("b"))
                .forEach((x)-> System.out.print(x + ", "));
        System.out.println();

        // Read the file and sort the words with length greater than 6
        try {
            Stream<String> line = Files.lines(Paths.get("Files/wordFile.txt"));
            line.sorted()
                    .filter((x)-> x.length() > 6)
                    .forEach((x)-> System.out.print(x + ", "));
            line.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println();

        // Read the file and filter the words with th and sort and print
        List<String> words = null;
        try {
            words = Files.lines(Paths.get("Files/wordFile.txt"))
                        .filter((x)-> x.contains("th"))
                        .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        words.forEach((x)-> System.out.print(x + ", "));
        System.out.println();

        // Read the file and split the lines and filter the lines with more than 3 words
        Stream<String> rows = null;
        try {
            rows = Files.lines(Paths.get("Files/stockDataCsv.txt"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        int rowCount = (int) rows
                .map(x-> x.split(","))
                .filter(x-> x.length > 3)
                .count();
        rows.close();
        System.out.println(rowCount + " rows.");

        Stream<String> rows1 = null;
        try {
            rows1 = Files.lines(Paths.get("Files/stockDataCsv.txt"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        rows1.map(x-> x.split(","))
                .filter(x-> x.length > 3)
                .filter(x-> Integer.parseInt(x[1].trim()) > 15)
                .forEach(x -> System.out.println(x[0].trim() + " " + x[2].trim() + " " + x[3]));
        rows1.close();

    }
}