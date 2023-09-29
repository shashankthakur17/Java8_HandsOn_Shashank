package neet150.arraysAndHashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.LinkedHashMap;
import java.util.stream.Collectors;

public class TopKFrequentElements {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        Arrays.stream(topKFrequent(nums, k)).forEach(System.out::println);
    }

    public static int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> rsMap = new HashMap<>();
        for (int val : nums) {
            if (rsMap.containsKey(val)) {
                Integer count = rsMap.get(val);
                rsMap.put(val, count + 1);
            } else {
                rsMap.put(val, 1);
            }
        }

        // Sort
        HashMap<Integer, Integer> sortedMap = rsMap.entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (e1, e2) -> e2, LinkedHashMap::new));

        int[] resultArr = new int[k];
        //Integer[] keyArray = .toArray(new Integer[sortedMap.keySet().size()]);
        List<Integer> listKeys = new ArrayList<>(sortedMap.keySet());

        for (int i = 0; i < k; i++) {
            resultArr[i] = listKeys.get(i);
        }
        return resultArr;
    }
}
