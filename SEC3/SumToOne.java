import static org.junit.Assert.*;
import org.junit.Test;


/**
 * @author Group 11
 *
 */
public class SumToOne {				//This test case will check if all normalized scores add to 1

	@Test
	public void test() {
		Screen2 screen = new Screen2(3,false);
		int[][] score = {{3,3,2}, {5,5,5}, {2,2,3}};
		double[] calculated = screen.normalize(score);
		double expected_score = 0;
		for(int i = 0; i < calculated.length; i++){
			expected_score += calculated[i];
		}
		assertEquals(1.0, expected_score, 0.1);
	}

}
