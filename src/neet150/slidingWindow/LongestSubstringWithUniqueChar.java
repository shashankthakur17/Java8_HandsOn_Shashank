package neet150.slidingWindow;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithUniqueChar {
    // Longest Substring Without Repeating Characters
    // https://leetcode.com/problems/longest-substring-without-repeating-characters/description/

    public static void main(String[] args) {
        /*System.out.println("Longest unique char substring = "
                + lengthOfLongestSubstring("abcabcbb"));*/

        System.out.println("Longest unique char substring = "
                + lengthOfLongestSubstring("pwwkew"));
    }

    public static int lengthOfLongestSubstring(String s) {
        int maxLength = 0, i = 0, j = 0;
        Set<Character> setUniqueChar = new HashSet<>();
        while (i < s.length()) {
            if (!setUniqueChar.contains(s.charAt(i))) {
                setUniqueChar.add(s.charAt(i));
                i++;
                maxLength = Math.max(maxLength, i - j);
            } else {
                setUniqueChar.remove(s.charAt(j));
                j++;
            }
        }
        return maxLength;
    }
}
