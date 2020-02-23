import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;

class Classifier6Test {

	private static Integer[] PERFECT_NUMS = { 6, 28, 496, 8128, 33550336 };

	@Test
	public void constructor_throws_exception_with_number_less_than_one() throws InvalidNumberException {
		Exception exception = assertThrows(InvalidNumberException.class, () -> {
			@SuppressWarnings("unused")
			Classifier6 c = new Classifier6(-1);
		});

		String expectedMessage = "Can't classify negative numbers";
		String actualMessage = exception.getMessage();
		assertTrue(expectedMessage == actualMessage);
	}

	@Test
	public void is_1_a_factor_of_10() throws InvalidNumberException {
		Classifier6 c = new Classifier6(10);
		assertTrue(c.isFactor(1));
	}

	@Test
	public void is_5_a_factor_of_25() throws InvalidNumberException {
		Classifier6 c = new Classifier6(25);
		assertTrue(c.isFactor(5));
	}

	@Test
	public void three_is_not_a_factor_of_7() throws InvalidNumberException {
		Classifier6 c = new Classifier6(7);
		assertFalse(c.isFactor(3));
	}

	@Test
	public void one_and_number_are_the_initial_values_before_isPerfect_is_called() throws InvalidNumberException {
		Classifier6 c = new Classifier6(6);
		Set<Integer> expected = new HashSet<Integer>(Arrays.asList(1, 6));
		Set<Integer> actual = c.getFactors();
		assertArrayEquals(actual.toArray(), expected.toArray());
	}

	@Test
	public void can_add_factors_and_retrieve_them() throws InvalidNumberException {
		Classifier6 c = new Classifier6(6);
		Set<Integer> expected = new HashSet<Integer>(Arrays.asList(1, 2, 3, 6));
		c.addFactor(2);
		Set<Integer> actual = c.getFactors();
		assertArrayEquals(actual.toArray(), expected.toArray());
	}

	@Test
	public void factors_for_6() throws InvalidNumberException {
		Classifier6 c = new Classifier6(6);
		Set<Integer> expected = new HashSet<Integer>(Arrays.asList(1, 2, 3, 6));
		c.calculateFactors();
		Set<Integer> actual = c.getFactors();
		assertArrayEquals(actual.toArray(), expected.toArray());
	}

	@Test
	public void factors_for_7() throws InvalidNumberException {
		Classifier6 c = new Classifier6(7);
		Set<Integer> expected = new HashSet<Integer>(Arrays.asList(1, 7));
		c.calculateFactors();
		Set<Integer> actual = c.getFactors();
		assertArrayEquals(actual.toArray(), expected.toArray());
	}

	@Test
	public void sum_of_factors_for_20() throws InvalidNumberException {
		Classifier6 c = new Classifier6(20);
		c.calculateFactors();
		int actual = c.sumOfFactors();
		int expected = 1 + 2 + 4 + 5 + 10 + 20;
		assertEquals(actual, expected);
	}

	@Test
	public void test_perfect_numbers() throws InvalidNumberException {
		for (int number : PERFECT_NUMS) {
			Classifier6 c = new Classifier6(number);
			assertTrue(c.isPerfect());
		}
	}

	@Test
	public void test_a_bunch_of_numbers() throws InvalidNumberException {
		List<Integer> expected = new ArrayList<Integer>(Arrays.asList(PERFECT_NUMS));
		for (int i = 2; i < 8130; i++) {
			Classifier6 c = new Classifier6(i);
			if (expected.contains(i))
				assertTrue(c.isPerfect());
			else
				assertFalse(c.isPerfect());
		}
	}
}
