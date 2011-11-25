package test;

import junit.framework.Test;
import junit.framework.TestSuite;

public class SAXPathTests {

    public static Test suite() {
        TestSuite result = new TestSuite();
        result.addTestSuite(SAXPathExceptionTest.class);
        result.addTestSuite(AxisTest.class);
        return result;
    }
}
