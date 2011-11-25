package test;

import junit.framework.Test;
import junit.framework.TestSuite;

public class FunctionTests {

    public static Test suite() {
        TestSuite result = new TestSuite();
        result.addTest(new TestSuite(TranslateFunctionTest.class));
        result.addTest(new TestSuite(SubstringTest.class));
        result.addTest(new TestSuite(SubstringBeforeTest.class));
        result.addTest(new TestSuite(SubstringAfterTest.class));
        result.addTest(new TestSuite(LangTest.class));
        result.addTest(new TestSuite(LastTest.class));
        result.addTest(new TestSuite(ConcatTest.class));
        result.addTest(new TestSuite(ContainsTest.class));
        result.addTest(new TestSuite(StringLengthTest.class));
        result.addTest(new TestSuite(StartsWithTest.class));
        result.addTest(new TestSuite(CountTest.class));
        result.addTest(new TestSuite(LocalNameTest.class));
        result.addTest(new TestSuite(NameTest.class));
        result.addTest(new TestSuite(NamespaceURITest.class));
        result.addTest(new TestSuite(SumTest.class));
        result.addTest(new TestSuite(NumberTest.class));
        result.addTest(new TestSuite(RoundTest.class));
        result.addTest(new TestSuite(StringTest.class));
        result.addTest(new TestSuite(BooleanTest.class));
        result.addTest(new TestSuite(CeilingTest.class));
        result.addTest(new TestSuite(FloorTest.class));
        result.addTest(new TestSuite(IdTest.class));
        result.addTest(new TestSuite(TrueTest.class));
        result.addTest(new TestSuite(FalseTest.class));
        result.addTest(new TestSuite(NotTest.class));
        result.addTest(new TestSuite(NormalizeSpaceTest.class));
        result.addTest(new TestSuite(PositionTest.class));
        result.addTest(new TestSuite(ExtensionFunctionTest.class));
        return result;
    }
}
