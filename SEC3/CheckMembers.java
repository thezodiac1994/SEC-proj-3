import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author Group 11
 *
 */
public class CheckMembers {				//This test case will check if the number of members is equal
										//to the number of normalized scores calculated

	@Test
	public void test() {
		Screen2 screen = new Screen2(3, false);
		int members = Screen2.memberCount;
		System.out.println(members);
		int[][] score = {{5,5,5}, {4,4,4}, {4,5,5}};
		double[] result = screen.normalize(score);
		assertEquals(result.length, members);
	}

}
