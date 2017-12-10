import static org.junit.Assert.*;

import org.junit.Test;

/**
 * This test case will check if the number of members is equal to the number of normalized scores calculated
 * @author Group 11
 *
 */
public class CheckMembers {				

	@Test
	public void test() {
		screen2 screen = new screen2(3, false);
		int members = screen2.memberCount;
		int[][] score = {{5,5,5}, {4,4,4}, {4,5,5}};
		double[] result = screen.normalize(score);
		assertEquals(result.length, members);
	}

}