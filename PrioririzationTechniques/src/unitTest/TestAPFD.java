package unitTest;

import junit.framework.TestCase;
import util.APFD;


public class TestAPFD extends TestCase{

	public void testGetAPFD(){
		assertEquals(0.9, APFD.getAPFD(5, 1, new int[]{1}), 0.001);
		assertEquals(0.5, APFD.getAPFD(5, 1, new int[]{3}), 0.001);
	}
}
