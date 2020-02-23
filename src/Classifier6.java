import java.util.HashSet;
import java.util.Set;

public class Classifier6 {
	private Set<Integer> _factors;
	private int _number;

	public Classifier6(int number) throws InvalidNumberException {
		if (number < 1)
			throw new InvalidNumberException("Can't classify negative numbers");
		_number = number;
		_factors = new HashSet<Integer>();
		_factors.add(1);
		_factors.add(_number);
	}

	boolean isFactor(int factor) {
		return _number % factor == 0;
	}

	public Set<Integer> getFactors() {
		return _factors;
	}

	void calculateFactors() {
		for (int i = 2; i < Math.sqrt(_number) + 1; i++)
			if (isFactor(i))
				addFactor(i);
	}

	void addFactor(int factor) {
		_factors.add(factor);
		_factors.add(_number / factor);
	}

	int sumOfFactors() {
		int sum = 0;
		for (int i : _factors)
			sum += i;
		return sum;
	}

	public boolean isPerfect() {
		calculateFactors();
		return sumOfFactors() - _number == _number;
	}
}