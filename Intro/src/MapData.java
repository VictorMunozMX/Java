import java.util.HashMap;
import java.util.Map;

public class MapData {
    public static void main(String[] args) {
        System.out.println("MapData");

        Map<String, Integer> map = new HashMap<>();
        map.put("A", 1);
        map.put("B", 2);
        map.put("C", 3);

        System.out.println(map.get("A"));
        System.out.println(map);

        if (map.containsKey("C")) {
            System.out.println("Key C exists with index: " + map.get("C"));
        }
    }
}
