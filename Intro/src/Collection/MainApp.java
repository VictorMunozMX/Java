package Collection;

import java.util.ArrayList;

public class MainApp {
    public static void main(String[] args){
        // ArrayList generic
        ArrayList list = new ArrayList();
        list.add("Hello");
        list.add("Bye");
        list.add(10);
        list.add(10.5);
        list.add("Victor");

        System.out.println(list.get(2));

        // we need to know the data type if you want to use it
        String str1 = (String) list.get(0);
        String str2 = String.valueOf((Integer) list.get(2));

        // ArrayList String
        ArrayList<String> list2 = new ArrayList<String>();
        list2.add("Hello");
        list2.add("Bye");
        list2.add("Victor");
        list2.add("Enrique");

        for (String str : list2){
            System.out.println(str);
        }
    }
}
