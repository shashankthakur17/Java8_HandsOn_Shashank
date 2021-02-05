package nonprimitive.datatype.string;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class FirstNonDuplicateCharOfString {

	public static void main(String[] args) {

		String inputStr = "hqghumeaylnlfdxfircvscxggbwkfnqduxwfnfozvs";

		printDuplicateChars(inputStr);
	}

	private static void printDuplicateChars(String inputStr) {

		Map<Character, Integer> charCountMap = new LinkedHashMap<>();

		for (int i = 0; i < inputStr.length(); i++) {
			char c = inputStr.charAt(i);
			if (charCountMap.containsKey(c)) {
				charCountMap.put(c, charCountMap.get(c) + 1);
			} else {
				charCountMap.put(c, 1); // first occurence of this character
			}
		} // by this for loop char frequencies in inputStr is recorded/poplated

		// now traverse and print only the duplicates
		Set<Character> charKeySet = charCountMap.keySet();
		for (char c : charKeySet) {
			if (charCountMap.get(c).equals(1))
				{System.out.println("First NonDuplicate character: " + c + "\t Frequency: " + charCountMap.get(c));
				break;}
			
		}
	}

}
