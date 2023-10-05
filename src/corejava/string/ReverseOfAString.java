package corejava.string;

public class ReverseOfAString {

	public static void main(String[] args) {

		String inputStr = "handsOnPracticeJava";
		// Reverse a given String using only for loop
		reverseUsingLoop(inputStr);

		// Reverse a given String using only for loop
		reverseUsingStringBuffer(inputStr);
	}

	private static void reverseUsingStringBuffer(String inputStr) {
		StringBuilder strBuff = new StringBuilder(inputStr);
		System.out.println(
				"Reverse of string using StringBuffer(): inputStr=> " + inputStr + "\t Output=> " + strBuff.reverse());
	}

	private static void reverseUsingLoop(String inputStr) {

		StringBuilder reverseStr = new StringBuilder();
		for (int i = inputStr.length() - 1; i >= 0; i--) {
			reverseStr.append(inputStr.charAt(i));
		}

		System.out.println("Reverse of string using for Loop: inputStr=> " + inputStr + "\t Output=> " + reverseStr);
	}

}
