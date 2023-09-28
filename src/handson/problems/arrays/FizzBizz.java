package handson.problems.arrays;

public class FizzBizz {
    /*
     * Say Fizz if the number is divisible by 3.
     * Say Buzz if the number is divisible by 5.
     * Say FizzBuzz if the number is divisible by both 3 and 5.
     * Return the number itself, if the number is not divisible by 3 and 5.
     * */
    public static void main(String[] args) {
        int n = 100;
        int[] arr = new int[100];
        int count = 1;
        // populate arr
        for (int i = 0; i < n; i++) {
            arr[i] = count;
            count++;
        }

        // pring FizzBuzz
        for (int i = 0; i < n; i++) {
            if (arr[i] % 3 == 0 && arr[i] % 5 == 0)
                System.out.print("FizzBuzz" + " ");
            else if (arr[i] % 5 == 0)
                System.out.print("Buzz" + " ");
            else if (arr[i] % 3 == 0)
                System.out.print("Fizz" + " ");
            else
                System.out.print(arr[i] + " ");
        }
    }
}
