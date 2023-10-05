package corejava.string;

import java.util.HashMap;
import java.util.Map;

public class AnagramOfTwoStringUsingMap {

	/*
	 * An anagram of a string is another string that contains the same characters,
	 * only the order of characters can be different.
	 * For example, �abcd� and �dabc� are an Anagram of each other.
	 */
	public static void main(String[] args) {

		// input
		String s1 = "listen";
		String s2 = "silent";
		checkAnagram(s1, s2);
	}

	private static void checkAnagram(String s1, String s2) {
		char[] inputStr1 = s1.toCharArray();
		char[] inputStr2 = s2.toCharArray();
		
		Map<Character, Integer> hm1 = new HashMap<>();
		Map<Character, Integer> hm2 = new HashMap<>();

		// for inputStr1
		for (int i = 0; i < inputStr1.length; i++) {
			if(hm1.get(inputStr1[i]) == null) {		// First time adding in Map
				hm1.put(inputStr1[i], 1);
			}else {		// Else we have to get the frequency and increment it once found in map
				Integer count = hm1.get(inputStr1[i]);
				hm1.put(inputStr1[i], ++count);
			}
		}
		// for inputStr2
		for (int i = 0; i < inputStr2.length; i++) {
			if(hm2.get(inputStr2[i]) == null) {		// First time adding in Map
				hm2.put(inputStr2[i], 1);
			}else {		// Else we have to get the frequency and increment it once found in map
				Integer count = hm2.get(inputStr2[i]);
				hm2.put(inputStr2[i], ++count);
			}
		}
		
		System.out.println("Strings to be checked are:\n"
                + s1 + "\n" + s2 + "\n"); 
		
		if (hm1.equals(hm2))
			System.out.println("The two strings are " + "anagrams of each other\n");
		else
			System.out.println("The two strings are not" + " anagrams of each other\n");
	}
}
