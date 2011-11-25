package test;

import junit.framework.Test;
import junit.framework.TestSuite;

public class JavaBeanTests {

    public static Test suite() {
        TestSuite result = new TestSuite();
        result.addTest(new TestSuite(JavaBeanNavigatorTest.class));
        return result;
    }
}
