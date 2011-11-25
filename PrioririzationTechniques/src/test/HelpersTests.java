package test;

import junit.framework.Test;
import junit.framework.TestSuite;

public class HelpersTests {

    public static Test suite() {
        TestSuite result = new TestSuite();
        result.addTest(new TestSuite(XPathReaderFactoryTest.class));
        return result;
    }
}
