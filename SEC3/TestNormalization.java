
import static org.junit.Assert.*;

import org.junit.Test;

/**
 * This test case will check if the normalization function is being
 * calculated properly. Expected scores are calculated by hand.
 * @author Group 11
 *
 */
public class TestNormalization {		
										

	@Test
	public void test() {
		screen2 screen = new screen2(3,false);
		int[][] score = {{5,5,5}, {4,4,4}, {4,5,5}};
		double[] calculated = screen.normalize(score);
		double[] expected_score = {0.36, 0.29, 0.34};
		assertArrayEquals(expected_score, calculated, 0.01);

	}

}