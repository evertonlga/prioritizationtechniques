package testBag2;

import junit.framework.Test;
import junit.framework.TestSuite;



public class Suite {

	public static Test suite() {

		TestSuite result = new TestSuite();
		result.addTest(new TestSuite(BagClass.class));
		//        result.addTest(new TestSuite(DOM4JXPathTest.class));
		return result;

	}

}
