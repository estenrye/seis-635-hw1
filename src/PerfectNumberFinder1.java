import java.util.List;
import java.util.ArrayList;

public class PerfectNumberFinder1 {
	public static boolean isPerfect(int number) {
		// get factors
		List<Integer> factors = new ArrayList<Integer>();
		factors.add(1);
		factors.add(number);
		for (int i = 2; i <= Math.sqrt(number); i++) {
			if (number % i == 0) {
				factors.add(i);
				if (number/i != i)
					factors.add(number/i);
			}
		}
		// sum factors
		int sum = 0;
		for (int n : factors)
			sum += n;
		// decide if it's perfect
		return sum - number == number;
	}

	public static void main(String[] args) {
		StdOut.println(isPerfect(28));
	}
}
