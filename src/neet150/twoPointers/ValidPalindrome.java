package neet150.twoPointers;

public class ValidPalindrome {

    public static void main(String[] args) {

        String str = "race a car";
        System.out.println("Is a valid Palindrome: " + validPalindrome(str));
    }

    private static boolean validPalindrome(String str) {

        int i = 0;
        int j = str.length() - 1;
        while (i < j) {
            char start = str.charAt(i);
            char end = str.charAt(j);

            if (!Character.isLetterOrDigit(start)) {
                i++;
                continue;
            }
            if (!Character.isLetterOrDigit(end)) {
                j--;
                continue;
            }
            if (Character.toLowerCase(start) != Character.toLowerCase(end)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}