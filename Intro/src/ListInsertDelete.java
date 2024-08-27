
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListInsertDelete {
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        int Q = 2;

        for (int i = 0; i < Q; i++) {
            String key;
            if (i == 0) {
                key = "Insert";
            } else {
                key = "Delete";
            }

            if (key.equals("Insert")) {
                int x = 5;
                int y = 10;
                list.add(x, y);
            }

            if (key.equals("Delete")) {
                int x = 0;
                list.remove(x);
            }
        }

        System.out.println(list);
    }
}
