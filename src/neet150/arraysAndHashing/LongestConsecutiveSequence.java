package neet150.arraysAndHashing;

import java.util.HashSet;
import java.util.stream.Collectors;
import java.util.LinkedHashSet;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};
        System.out.println(consecutiveSequence(nums));
    }

    private static int consecutiveSequence(int[] nums) {
        HashSet<Integer> setNums = new HashSet<>();
        for (int num : nums) setNums.add(num); // Add all elements of array to a HashSet
        // Hoping the loops will use fewer iterations if we sort the Set
        HashSet<Integer> sortedHashSet = setNums.stream()
                .sorted()
                .collect(Collectors.toCollection(LinkedHashSet::new));
        int max = 0;
        for (Integer num : sortedHashSet) {
            if (!sortedHashSet.contains(num - 1)) { // This is our start of the sequence
                int count = 1;
                while (sortedHashSet.contains(++num)) {
                    count++;
                }
                max = Math.max(count, max);
            }
        }
        return max;
    }
}
