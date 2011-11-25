package test;

import junit.framework.Test;
import junit.framework.TestSuite;

public class JDOMTests {

    public static Test suite() {
        TestSuite result = new TestSuite();
        result.addTest(new TestSuite(JDOMNavigatorTest.class));
        result.addTest(new TestSuite(JDOMXPathTest.class));
        return result;
    }
}
