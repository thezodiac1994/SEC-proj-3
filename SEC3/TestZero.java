import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author Group 11
 *
 */
public class TestZero { 	//This test case will make sure even though one teammate gets 0, the entire team's
							//score is adjusted accordingly, thus preventing targeting of teammates.

	@Test
	public void test() {
		Screen2 screen = new Screen2(3,false);
		int[][] score = {{0,0,0}, {1,1,1}, {2,2,2}};
		double[] calculated = screen.normalize(score);
		double[] expected_score = {0.0, 0.33, 0.66};
		assertArrayEquals(expected_score, calculated, 0.01);
	}

}
