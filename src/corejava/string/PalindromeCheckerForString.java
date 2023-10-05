package corejava.string;

public class PalindromeCheckerForString {

	public static void main(String[] args) {

		String inputStr = "123454321";

		checkPalindromeUsingStrBuilder(inputStr);

		checkPalindromeUsingStrReverse(inputStr);
	}

	private static void checkPalindromeUsingStrBuilder(String inputStr) {
		StringBuilder reverseStr = new StringBuilder();
		for (int i = inputStr.length() - 1; i >= 0; i--) {
			reverseStr.append(inputStr.charAt(i));
		}

		if (inputStr.contentEquals(reverseStr))
			System.out.println("String Reverse: Input is palindrome");
		else
			System.out.println("String Reverse: Input is NOT a palindrome");
	}

	private static void checkPalindromeUsingStrReverse(String inputStr) {

		StringBuilder sb = new StringBuilder(inputStr);
        sb.reverse();
        if (inputStr.contentEquals(sb))
			System.out.println("StringBuilder: Input is palindrome");
		else
			System.out.println("StringBuilder: Input is NOT a palindrome");
	}

}
