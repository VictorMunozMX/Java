package HashMapApp;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class HashMain {

	public static void main(String[] args) {
		// with linked hash map, the order of the keys is preserved
		//LinkedHashMap<String, String> dictionary = new LinkedHashMap<String, String>();

		// with tree map, the keys are sorted in natural order
		//TreeMap<String, String> dictionary = new TreeMap<String, String>();

		// with hash map, the order of the keys is not preserved
		HashMap<String, String> dictionary = new HashMap<String, String>();
		dictionary.put("cucumber", "a vegetable");
		dictionary.put("banana", "a fruit");
		dictionary.put("carrot", "a vegetable");
		dictionary.put("apple", "a fruit");

//		for (String word: dictionary.keySet()) {
//			System.out.println(word + " : " + dictionary.get(word));
//		}

		for( Map.Entry<String, String> entry: dictionary.entrySet()){
			System.out.println(entry.getKey());
			System.out.println(entry.getValue());
		}

	}
}
