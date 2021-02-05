package collection.map;

import java.util.HashMap;
import java.util.Map;

public class FrequencyOfNumbersUsingMap {

	public static void main(String[] args) {

		Integer arr[] = { 9, 9, 8, 6, 8, 10, 4, 7, 6, 5, 4, 5, 3, 4, 3, 4, 5, 6, 7, 6, 1, 1, 4, 5, 6, 9, 10 };

		Map<Integer, Integer> freqCalMap = new HashMap<>();

		for (int i = 0; i < arr.length; i++) {

			Integer count = freqCalMap.get(arr[i]);
			// First time adding in Map
			if (count == null) {
				freqCalMap.put(arr[i], 1);
			}
			// Else we have to get the frequency and increment it once found in map
			else {
				freqCalMap.put(arr[i], ++count);
			}
		}
		for (Map.Entry<Integer, Integer> mapEntry : freqCalMap.entrySet()) {
			System.out.println("Number=" + mapEntry.getKey() + ", Frequency=" + mapEntry.getValue());
		}
	}

}
