import java.util.*;

public class HashSet {
    public static void main(String[] args) {
        // create two arrays with 5 elements each type string
        String[] array1 = {"Vic", "Karem", "Vic", "Kat", "Kat"};
        String[] array2 = {"Mun", "Esp", "Mun", "Tom", "Tom"};
        //create a list with pares of strings between the two arrays
        List<String> list = new ArrayList<>();
        for (int i = 0; i < array1.length; i++) {
            list.add(array1[i] + " " + array2[i]);
        }
        // sort the list
        Collections.sort(list);

        // Use a LinkedHashMap to count occurrences of each pair and maintain order
        Map<String, Integer> countMap = new LinkedHashMap<>();
        for (String pair : list) {
            countMap.put(pair, countMap.getOrDefault(pair, 0) + 1);
        }

        // Create the result list
        List<Integer> res = new ArrayList<>();
        int d = 0;
        for (Map.Entry<String, Integer> entry : countMap.entrySet()) {
            d++;
            for (int i = 0; i < entry.getValue(); i++) {
                res.add(d);
            }
        }

        // Print the result
        for (Integer numero : res) {
            System.out.println(numero);
        }

    }
}