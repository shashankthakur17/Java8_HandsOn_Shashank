package handson.problems.arrays;

public class FizzBizz {

	public static void main(String[] args) {
		
		int n = 100;
		int [] arr = new int[n];
		int count = 1; 
		// populate arr
		for(int i=0; i<n; i++) {
			arr[i] = count;
			count++;
		}
		
		// pring FizzBuzz
		for(int i=0; i<n; i++) {
			if(arr[i] % 3 == 0 && arr[i] % 5 == 0)
				System.out.print("FizzBuzz"+" ");
			else if(arr[i] % 5 == 0)
				System.out.print("Buzz"+" ");
			else if(arr[i] % 3 == 0)
				System.out.print("Fizz"+" ");
			else
				System.out.print(arr[i]+" ");
		}
	}

}
