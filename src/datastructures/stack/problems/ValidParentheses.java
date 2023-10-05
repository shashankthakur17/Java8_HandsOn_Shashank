package datastructures.stack.problems;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {

    //https://leetcode.com/problems/valid-parentheses/
    public boolean isValid(String s) {

        Map<Character, Character> myBracketDictionary = new HashMap<>();
        myBracketDictionary.put(')', '(');
        myBracketDictionary.put('}', '{');
        myBracketDictionary.put(']', '[');

        Stack<Character> charStack = new Stack<>();
        for (char c : s.toCharArray()) {
            // open bracket block
            if (c == '(' || c == '{' || c == '[') {
                charStack.push(c);
            } else {
                // definitely closing bracket block
                if (!charStack.isEmpty() && charStack.peek() == myBracketDictionary.get(c)) {
                    charStack.pop();
                } else {
                    return false;
                }
            }
        }
        return charStack.isEmpty();
    }

    public static void main(String[] args) {
        ValidParentheses vs = new ValidParentheses();
        System.out.println("Is valid parentheses = " + vs.isValid("()[]{}"));
        // try s = "((({{{[[[]]]}}})))" or "{(]]"
    }
}
