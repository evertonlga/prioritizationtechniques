package test;

import junit.framework.Test;
import junit.framework.TestSuite;

public class DOMTests {

    public static Test suite() {
        TestSuite result = new TestSuite();
        result.addTest(new TestSuite(DOMNavigatorTest.class));
        result.addTest(new TestSuite(DOMXPathTest.class));
        result.addTest(new TestSuite(NamespaceTest.class));
        result.addTest(new TestSuite(DOM3NamespaceTest.class));
        return result;
    }
}
