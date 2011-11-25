package test;

import junit.framework.Test;
import junit.framework.TestSuite;

public class PatternTests {

    public static Test suite() {
        TestSuite result = new TestSuite();
        result.addTest(new TestSuite(PatternHandlerTest.class));
        return result;
    }
}
