package collection.map;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class SortAHashMap {

	public static void main(String[] args) {

		Map<String, Integer> map = new HashMap<String, Integer>();

		// enter data into hashmap, Subject and their marks
		map.put("Math", 98);
		map.put("Data Structure", 85);
		map.put("Database", 91);
		map.put("Java", 95);
		map.put("Operating System", 79);
		map.put("Networking", 80);
		map.put("Data Communications", 77);
		map.put("CG and Multimedia", 83);
		map.put("Theory of computation", 91);

		// sort
		Map<String, Integer> sortedMap = sortMapByValues(map);
		
		// print Sorted Map
		for(Map.Entry<String, Integer> mapEntry : sortedMap.entrySet()) {
			System.out.println("Key=" + mapEntry.getKey() + " & Value=" + mapEntry.getValue());
		}
	}

	private static Map<String, Integer> sortMapByValues(Map<String, Integer> map) {
		/*
		 * To sort a map we don't have a direct method, hence we have to perform below steps -
		 * to sort map by its values 
		 * 1) take Map.entry to a list 
		 * 2) perform Collections.sort method by providing argument List and Comparator 
		 * 3) Once this list is sorted put its values in a new HashMap and return the sorted Map
		 */

		// 1) take Map.entry to a list
		// Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
		
		List<Map.Entry<String, Integer>> lListOfMapEntry = new LinkedList<Map.Entry<String, Integer>>(map.entrySet());
		int[] arr = new int[10];
		// 2) perform Collections.sort method by providing argument List and Comparator
		Collections.sort(lListOfMapEntry, new Comparator<Map.Entry<String, Integer>>() {

			@Override
			public int compare(Entry<String, Integer> entry1, Entry<String, Integer> entry2) {
				return entry1.getValue().compareTo(entry2.getValue());
			}
		}); // This type of class declaration is called anonymous class

		// 3) Once this list is sorted put its values in a new HashMap and return the
		// sorted Map
		Map<String, Integer> sortedMap = new LinkedHashMap<String, Integer>();
		for (Map.Entry<String, Integer> eachEntry : lListOfMapEntry) {
			sortedMap.put(eachEntry.getKey(), eachEntry.getValue());
		}

		return sortedMap;
	}

}
