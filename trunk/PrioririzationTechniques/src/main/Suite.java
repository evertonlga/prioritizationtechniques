package main;

import org.jaxen.test.*;

import junit.framework.Test;
import junit.framework.TestSuite;




public class Suite {

	public static Test suite() {
        TestSuite result = new TestSuite();
		
        result.addTest(new TestSuite(test.AddNamespaceTest.class));
        result.addTest(new TestSuite(test.AncestorOrSelfAxisIteratorTest.class));
        result.addTest(new TestSuite(test.ArithmeticTest.class));
        result.addTest(new TestSuite(test.AxisTest.class));
        result.addTest(new TestSuite(test.BaseXPathTest.class));
        result.addTest(new TestSuite(test.BinaryExprTest.class));
        result.addTest(new TestSuite(test.BooleanTest.class));
        result.addTest(new TestSuite(test.CeilingTest.class));
        result.addTest(new TestSuite(test.ConcatTest.class));
        //result.addTest(new TestSuite(test.ConformanceXPathHandler.class));
        result.addTest(new TestSuite(test.ContainsTest.class));
        result.addTest(new TestSuite(test.ContextTest.class));
        result.addTest(new TestSuite(test.CountTest.class));
        result.addTest(new TestSuite(test.DefaultNamestepTest.class));
        result.addTest(new TestSuite(test.DefaultXPathExprTest.class));
        result.addTest(new TestSuite(test.DefaultXPathFactoryTest.class));
        result.addTest(new TestSuite(test.DescendantAxisIteratorTest.class));
        result.addTest(new TestSuite(test.DOM3NamespaceTest.class));
        result.addTest(new TestSuite(test.DOM4JNavigatorTest.class));
       // result.addTest(new TestSuite(test.DOM4JPerformance.class));
        result.addTest(new TestSuite(test.DOM4JXPathTest.class));
        result.addTest(new TestSuite(test.DOMNavigatorTest.class));
        result.addTest(new TestSuite(test.DOMXPathTest.class));
        
        result.addTest(new TestSuite(test.EqualsTest.class));
        //result.addTest(new TestSuite(test.ExprComparator.class));
        result.addTest(new TestSuite(test.ExtensionFunctionTest.class));
        result.addTest(new TestSuite(test.FalseTest.class));
        result.addTest(new TestSuite(test.FloorTest.class));
        result.addTest(new TestSuite(test.FollowingAxisIteratorTest.class));
        result.addTest(new TestSuite(test.FollowingSiblingAxisIteratorTest.class));
        result.addTest(new TestSuite(test.FunctionCallExceptionTest.class));
        result.addTest(new TestSuite(test.FunctionContextTest.class));
        result.addTest(new TestSuite(test.IdTest.class));
        result.addTest(new TestSuite(test.IterableAxisTest.class));
        
        result.addTest(new TestSuite(test.JavaBeanNavigatorTest.class));
        result.addTest(new TestSuite(test.JaxenExceptionTest.class));
        result.addTest(new TestSuite(test.JaxenHandlerTest.class));
        result.addTest(new TestSuite(test.JaxenRuntimeExceptionTest.class));
        result.addTest(new TestSuite(test.JDOMNavigatorTest.class));
        //result.addTest(new TestSuite(test.JDOMPerformance.class));
        result.addTest(new TestSuite(test.JDOMXPathTest.class));
        result.addTest(new TestSuite(test.LangTest.class));
        result.addTest(new TestSuite(test.LastTest.class));
        result.addTest(new TestSuite(test.LiteralExprTest.class));
        result.addTest(new TestSuite(test.LocalNameTest.class));
        //result.addTest(new TestSuite(test.MockXPathReader.class));
        result.addTest(new TestSuite(test.ModTest.class));
        result.addTest(new TestSuite(test.NamespaceTest.class));
        result.addTest(new TestSuite(test.NamespaceURITest.class));
        result.addTest(new TestSuite(test.NameTest.class));
        result.addTest(new TestSuite(test.NodesetEqualityTest.class));
        result.addTest(new TestSuite(test.NormalizeSpaceTest.class));
        result.addTest(new TestSuite(test.NotTest.class));
        result.addTest(new TestSuite(test.NumberTest.class));
        
        result.addTest(new TestSuite(test.PatternHandlerTest.class));
        //result.addTest(new TestSuite(test.Person.class)); //
        result.addTest(new TestSuite(test.PositionTest.class));
        result.addTest(new TestSuite(test.PrecedingAxisIteratorTest.class));
        result.addTest(new TestSuite(test.PrecedingSiblingAxisIteratorTest.class));
        result.addTest(new TestSuite(test.PriorityTest.class));
        result.addTest(new TestSuite(test.ProcessingInstructionNodeTest.class));
        result.addTest(new TestSuite(test.RoundTest.class));
        result.addTest(new TestSuite(test.SAXPathExceptionTest.class));
        
        result.addTest(new TestSuite(test.SimpleNamespaceContextTest.class));
        result.addTest(new TestSuite(test.SimpleVariableContextTest.class));
        result.addTest(new TestSuite(test.SingleObjectIteratorTest.class));
        result.addTest(new TestSuite(test.SingletonListTest.class));
        result.addTest(new TestSuite(test.StartsWithTest.class));
        result.addTest(new TestSuite(test.StringLengthTest.class));
        result.addTest(new TestSuite(test.StringTest.class));
        result.addTest(new TestSuite(test.SubstringAfterTest.class));
        result.addTest(new TestSuite(test.SubstringBeforeTest.class));
        result.addTest(new TestSuite(test.SubstringTest.class));
        result.addTest(new TestSuite(test.SumTest.class));
        
        result.addTest(new TestSuite(test.TranslateFunctionTest.class));
        result.addTest(new TestSuite(test.TrueTest.class));
        result.addTest(new TestSuite(test.UnresolvableExceptionTest.class));
        result.addTest(new TestSuite(test.UnsupportedAxisExceptionTest.class));
        result.addTest(new TestSuite(test.VariableContextTest.class));
        result.addTest(new TestSuite(test.XOMNavigatorTest.class));
        //result.addTest(new TestSuite(test.XOMPerformance.class));
        result.addTest(new TestSuite(test.XOMXPathTest.class));
        result.addTest(new TestSuite(test.XPathReaderFactoryTest.class));
        result.addTest(new TestSuite(test.XPathReaderTest.class));
        result.addTest(new TestSuite(test.XPathSyntaxExceptionTest.class));
//        result.addTest(new TestSuite(test.XPathTestBase.class));
		return result;
        
    }

}
