package nonprimitive.datatype.string;

public class PalindromCheckerForString {

	public static void main(String[] args) {

		String inputStr = "123454321";

		checkPalindromeUsingStrBuilder(inputStr);

		checkPalindromUsingStrReverse(inputStr);
	}

	private static void checkPalindromUsingStrReverse(String inputStr) {
		String reverseStr = "";
		for (int i = inputStr.length() - 1; i >= 0; i--) {
			reverseStr += inputStr.charAt(i);
		}

		if (inputStr.equals(reverseStr))
			System.out.println("String Reverse: Input is palindrom");
		else
			System.out.println("String Reverse: Input is NOT a palindrom");
	}

	private static void checkPalindromeUsingStrBuilder(String inputStr) {

		StringBuilder sb = new StringBuilder(inputStr);
		sb = sb.reverse();
		if (inputStr.equals(sb.toString()))
			System.out.println("StringBuilder: Input is palindrom");
		else
			System.out.println("StringBuilder: Input is NOT a palindrom");
	}

}
