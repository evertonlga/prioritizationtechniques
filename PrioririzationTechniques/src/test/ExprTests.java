package test;

import junit.framework.Test;
import junit.framework.TestSuite;

public class ExprTests {

    public static Test suite() {
        TestSuite result = new TestSuite();
        result.addTest(new TestSuite(DefaultXPathExprTest.class));
        result.addTest(new TestSuite(DefaultNamestepTest.class));
        result.addTest(new TestSuite(ModTest.class));
        result.addTest(new TestSuite(EqualsTest.class));
        result.addTest(new TestSuite(LiteralExprTest.class));
        result.addTest(new TestSuite(BinaryExprTest.class));
        result.addTest(new TestSuite(ProcessingInstructionNodeTest.class));
        return result;
    }
}
