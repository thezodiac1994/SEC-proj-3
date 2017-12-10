import static org.junit.Assert.*;

import org.junit.Test;

import junit.framework.Assert;

/**
 * This test case will check how the system handles a zero given to everyone.
 * An exception is thrown and if the flag is set to true, the test passes
 * @author Group 11
 *
 */
public class ZeroForAll {			
									

	@Test
	public void test() {
		boolean caught = false;
		screen2 screen = new screen2(3, false);
		int[][] score = {{0,0,0}, {0,0,0}, {0,0,0}};
		try{
			double[] result = screen.normalize(score);
		}
		
		catch(ArithmeticException e){
			caught = true;
		}
		
		assertEquals(true, caught);
		
		
		

	
		
	}

}