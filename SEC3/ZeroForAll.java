import static org.junit.Assert.*;

import org.junit.Test;

import junit.framework.Assert;

/**
 * @author Group 11
 *
 */
public class ZeroForAll {			//This test case will check how the system handles a zero given to everyone.
									//An exception is thrown and if the flag is set to true, the test passes

	@Test
	public void test() {
		boolean caught = false;
		Screen2 screen = new Screen2(3, false);
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
