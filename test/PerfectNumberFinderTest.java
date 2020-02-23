import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PerfectNumberFinderTest {
	private static Integer[] PERFECT_NUMS = { 6, 28, 496, 8128, 33550336 };

	@Test
	public void test_perfection() {
		for (int i : PERFECT_NUMS)
			assertTrue(PerfectNumberFinder1.isPerfect(i));
	}

	@Test
	public void test_non_perfection() {
		List<Integer> expected = new ArrayList<Integer>(Arrays.asList(PERFECT_NUMS));
		for (int i = 2; i < 100000; i++) {
			if (expected.contains(i))
				assertTrue(PerfectNumberFinder1.isPerfect(i));
			else
				assertFalse(PerfectNumberFinder1.isPerfect(i));
		}
	}

//	@Test
//	public void test_perfection_for_2nd_version() {
//		for (int i : PERFECT_NUMS)
//			assertTrue(PerfectNumberFinder2.isPerfect(i));
//	}
//
//	@Test
//	public void test_non_perfection_for_2nd_version() {
//		List<Integer> expected = new ArrayList<Integer>(Arrays.asList(PERFECT_NUMS));
//		for (int i = 2; i < 100000; i++) {
//			if (expected.contains(i))
//				assertTrue(PerfectNumberFinder2.isPerfect(i));
//			else
//				assertFalse(PerfectNumberFinder2.isPerfect(i));
//		}
//		assertTrue(PerfectNumberFinder2.isPerfect(PERFECT_NUMS[4]));
//	}
}
