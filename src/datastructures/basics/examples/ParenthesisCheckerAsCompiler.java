package datastructures.basics.examples;

import java.util.ArrayDeque;
import java.util.Deque;

public class ParenthesisCheckerAsCompiler {

	public static void main(String[] args) {
		String inputStr = "({[]})";
		
		if(checkparanthesis(inputStr))
			System.out.println("True => Valid String with Balanced pair of Brackets");
		else
			System.out.println("False => Invalid Balanced pair of Brackets");
	}

	// function to check if brackets are balanced 
	private static boolean checkparanthesis(String inputStr) {
		char[] charArr = inputStr.toCharArray();
		Deque<Character> stackChar = new ArrayDeque<Character>();	// Using ArrayDeque is faster than using Stack class
		for(int i =0; i < charArr.length; i++) {
			char bracket = charArr[i];
			if(bracket == '[' || bracket == '{' || bracket == '(') {
				stackChar.push(bracket);	// if charArray has opening brackets, then push it to the stack
				continue;
			}
			
			// Otherwise, the current character in this For loop isn't an opening bracket
			// It must be a closing bracket, now check the stack and pop the topmost char
			// compare current char at charArr[i] with the top char of stack
			
			// stack shouldn't be empty by this moment, guard check
			if(stackChar.isEmpty()) {
				return false;
			}
			
			char popedChar;
			switch (charArr[i]) {		// if poped char is other than the charArr[i] char than return invalid
			case '}':
				popedChar = stackChar.pop();
				if(popedChar == '(' || popedChar == '[') {
					return false;
				}
				break;
			case ')':
				popedChar = stackChar.pop();
				if(popedChar == '[' || popedChar == '{') {
					return false;
				}
				break;
			case ']':
				popedChar = stackChar.pop();
				if(popedChar == '{' || popedChar == '(') {
					return false;
				}
				break;
			}
		}
		return stackChar.isEmpty();		// stack should be empty at the end of the iteration
	}

}
