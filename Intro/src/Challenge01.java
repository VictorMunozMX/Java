import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Challenge01 {
    public static void main(String[] args) {

        int chs = 3;
        List<Integer> myList = new ArrayList<>();
        myList.add(3);
        myList.add(48);
        myList.add(89);
        myList.add(3);
        myList.add(1);
        System.out.println(myList);
        Collections.sort(myList);
        System.out.println(myList);

        List<Integer> myList2 = new ArrayList<>();
        int secc = myList.size() - chs + 1;
        int res = 0;
        for (int i = 0; i < myList.size(); i++) {
            if (i < secc) {
                myList2.add(myList.get(i));
            }
            else
            {
                res += myList.get(i);
            }
        }

        double median;
        int size = myList2.size();
        System.out.println(myList2);
        if (size % 2 == 0) {
            median = (myList2.get(size / 2) + myList2.get(size / 2 - 1)) / 2.0;
        } else {
            median = myList2.get(size / 2);
        }

        System.out.println(median + res);
    }

}
