package test;

import junit.framework.Test;
import junit.framework.TestSuite;

public class XOMTests {

    public static Test suite() {
        TestSuite result = new TestSuite();
        result.addTest(new TestSuite(XOMNavigatorTest.class));
        result.addTest(new TestSuite(XOMXPathTest.class));
        return result;
    }
}
