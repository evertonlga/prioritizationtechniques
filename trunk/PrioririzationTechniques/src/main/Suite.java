package main;

import org.jaxen.test.*;

import junit.framework.Test;
import junit.framework.TestSuite;




public class Suite {

	public static Test suite() {
        TestSuite result = new TestSuite();
		
        result.addTest(new TestSuite(AddNamespaceTest.class));
        result.addTest(new TestSuite(AncestorOrSelfAxisIteratorTest.class));
        result.addTest(new TestSuite(ArithmeticTest.class));
        result.addTest(new TestSuite(AxisTest.class));
        result.addTest(new TestSuite(BaseXPathTest.class));
        result.addTest(new TestSuite(BinaryExprTest.class));
        result.addTest(new TestSuite(BooleanTest.class));
        result.addTest(new TestSuite(CeilingTest.class));
        result.addTest(new TestSuite(ConcatTest.class));
        //result.addTest(new TestSuite(ConformanceXPathHandler.class));
        result.addTest(new TestSuite(ContainsTest.class));
        result.addTest(new TestSuite(ContextTest.class));
        result.addTest(new TestSuite(CountTest.class));
        result.addTest(new TestSuite(DefaultNamestepTest.class));
        result.addTest(new TestSuite(DefaultXPathExprTest.class));
        result.addTest(new TestSuite(DefaultXPathFactoryTest.class));
        result.addTest(new TestSuite(DescendantAxisIteratorTest.class));
        result.addTest(new TestSuite(DOM3NamespaceTest.class));
        result.addTest(new TestSuite(DOM4JNavigatorTest.class));
       // result.addTest(new TestSuite(DOM4JPerformance.class));
        result.addTest(new TestSuite(DOM4JXPathTest.class));
        result.addTest(new TestSuite(DOMNavigatorTest.class));
        result.addTest(new TestSuite(DOMXPathTest.class));
        
        result.addTest(new TestSuite(EqualsTest.class));
        //result.addTest(new TestSuite(ExprComparator.class));
        result.addTest(new TestSuite(ExtensionFunctionTest.class));
        result.addTest(new TestSuite(FalseTest.class));
        result.addTest(new TestSuite(FloorTest.class));
        result.addTest(new TestSuite(FollowingAxisIteratorTest.class));
        result.addTest(new TestSuite(FollowingSiblingAxisIteratorTest.class));
        result.addTest(new TestSuite(FunctionCallExceptionTest.class));
        result.addTest(new TestSuite(FunctionContextTest.class));
        result.addTest(new TestSuite(IdTest.class));
        result.addTest(new TestSuite(IterableAxisTest.class));
        
        result.addTest(new TestSuite(JavaBeanNavigatorTest.class));
        result.addTest(new TestSuite(JaxenExceptionTest.class));
        result.addTest(new TestSuite(JaxenHandlerTest.class));
        result.addTest(new TestSuite(JaxenRuntimeExceptionTest.class));
        result.addTest(new TestSuite(JDOMNavigatorTest.class));
        //result.addTest(new TestSuite(JDOMPerformance.class));
        result.addTest(new TestSuite(JDOMXPathTest.class));
        result.addTest(new TestSuite(LangTest.class));
        result.addTest(new TestSuite(LastTest.class));
        result.addTest(new TestSuite(LiteralExprTest.class));
        result.addTest(new TestSuite(LocalNameTest.class));
        //result.addTest(new TestSuite(MockXPathReader.class));
        result.addTest(new TestSuite(ModTest.class));
        result.addTest(new TestSuite(NamespaceTest.class));
        result.addTest(new TestSuite(NamespaceURITest.class));
        result.addTest(new TestSuite(NameTest.class));
        result.addTest(new TestSuite(NodesetEqualityTest.class));
        result.addTest(new TestSuite(NormalizeSpaceTest.class));
        result.addTest(new TestSuite(NotTest.class));
        result.addTest(new TestSuite(NumberTest.class));
        
        result.addTest(new TestSuite(PatternHandlerTest.class));
        //result.addTest(new TestSuite(Person.class)); //
        result.addTest(new TestSuite(PositionTest.class));
        result.addTest(new TestSuite(PrecedingAxisIteratorTest.class));
        result.addTest(new TestSuite(PrecedingSiblingAxisIteratorTest.class));
        result.addTest(new TestSuite(PriorityTest.class));
        result.addTest(new TestSuite(ProcessingInstructionNodeTest.class));
        result.addTest(new TestSuite(RoundTest.class));
        result.addTest(new TestSuite(SAXPathExceptionTest.class));
        
        result.addTest(new TestSuite(SimpleNamespaceContextTest.class));
        result.addTest(new TestSuite(SimpleVariableContextTest.class));
        result.addTest(new TestSuite(SingleObjectIteratorTest.class));
        result.addTest(new TestSuite(SingletonListTest.class));
        result.addTest(new TestSuite(StartsWithTest.class));
        result.addTest(new TestSuite(StringLengthTest.class));
        result.addTest(new TestSuite(StringTest.class));
        result.addTest(new TestSuite(SubstringAfterTest.class));
        result.addTest(new TestSuite(SubstringBeforeTest.class));
        result.addTest(new TestSuite(SubstringTest.class));
        result.addTest(new TestSuite(SumTest.class));
        
        result.addTest(new TestSuite(TranslateFunctionTest.class));
        result.addTest(new TestSuite(TrueTest.class));
        result.addTest(new TestSuite(UnresolvableExceptionTest.class));
        result.addTest(new TestSuite(UnsupportedAxisExceptionTest.class));
        result.addTest(new TestSuite(VariableContextTest.class));
        result.addTest(new TestSuite(XOMNavigatorTest.class));
        //result.addTest(new TestSuite(XOMPerformance.class));
        result.addTest(new TestSuite(XOMXPathTest.class));
        result.addTest(new TestSuite(XPathReaderFactoryTest.class));
        result.addTest(new TestSuite(XPathReaderTest.class));
        result.addTest(new TestSuite(XPathSyntaxExceptionTest.class));
//        result.addTest(new TestSuite(XPathTestBase.class));
		return result;
        
    }

}
