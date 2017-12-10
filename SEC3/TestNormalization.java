import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author Group 11
 *
 */
public class TestNormalization {		//This test case will check if the normalization function is being
										//calculated properly. Expected scores are calculated by hand.

	@Test
	public void test() {
		Screen2 screen = new Screen2(3,false);
		int[][] score = {{5,5,5}, {4,4,4}, {4,5,5}};
		double[] calculated = screen.normalize(score);
		double[] expected_score = {0.36, 0.29, 0.34};
		assertArrayEquals(expected_score, calculated, 0.01);

	}

}
