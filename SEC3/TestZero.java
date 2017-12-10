
import static org.junit.Assert.*;

import org.junit.Test;

/**
 * This test case will make sure even though one team mate gets 0, the entire team's
 * score is adjusted accordingly, thus preventing targeting of team mates.
 * @author Group 11
 *
 */
public class TestZero { 	//
							//

	@Test
	public void test() {
		screen2 screen = new screen2(3,false);
		int[][] score = {{0,0,0}, {1,1,1}, {2,2,2}};
		double[] calculated = screen.normalize(score);
		double[] expected_score = {0.0, 0.33, 0.66};
		assertArrayEquals(expected_score, calculated, 0.01);
	}

}