package nonprimitive.datatype.string;

import java.util.HashSet;
import java.util.Set;

public class AllUniqueCharactersInString {

	public static void main(String[] args) {

		String inputStr = "vector";
		if(checkUniqueStr(inputStr))
			System.out.println("Valid");
		else
			System.out.println("Invalid");
	}

	private static boolean checkUniqueStr(String inputStr) {

		Set<Character> charSet = new HashSet<>();
		for (int i = 0; i < inputStr.length(); i++) {
			if (!charSet.add(inputStr.charAt(i)))
				return false;
		}
		return true;
	}

}
