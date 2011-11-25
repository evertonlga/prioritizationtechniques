package test;

import junit.framework.Test;
import junit.framework.TestSuite;

public class UtilTests {

    public static Test suite() {
        TestSuite result = new TestSuite();
        result.addTest(new TestSuite(SingletonListTest.class));
        result.addTest(new TestSuite(SingleObjectIteratorTest.class));
        result.addTest(new TestSuite(AncestorOrSelfAxisIteratorTest.class));
        result.addTest(new TestSuite(DescendantAxisIteratorTest.class));
        result.addTest(new TestSuite(FollowingAxisIteratorTest.class));
        result.addTest(new TestSuite(FollowingSiblingAxisIteratorTest.class));
        result.addTest(new TestSuite(PrecedingAxisIteratorTest.class));
        result.addTest(new TestSuite(PrecedingSiblingAxisIteratorTest.class));
        return result;
    }
}
