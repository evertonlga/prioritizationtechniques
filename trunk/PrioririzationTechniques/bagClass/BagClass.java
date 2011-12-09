package testBag;

import org.jaxen.test.XPathTestBase;

import org.jaxen.pattern.Pattern;
import org.jaxen.util.FollowingAxisIterator;
import org.dom4j.DocumentHelper;
import org.jaxen.FunctionContext;
//import org.dom4j.Namespace;
import org.jdom.Namespace;
import org.jaxen.UnresolvableException;
import org.jdom.input.SAXBuilder;
import java.util.List;
import java.io.FileInputStream;
import org.dom4j.tree.DefaultAttribute;
import org.jaxen.JaxenHandler;
import org.jaxen.dom4j.Dom4jXPath;
import java.io.StringReader;
import org.jaxen.dom.DocumentNavigator;
import org.dom4j.DocumentException;
import org.jaxen.function.NumberFunction;
import org.jaxen.XPath;
//import org.w3c.dom.Text;
import org.jaxen.UnsupportedAxisException;
import org.jaxen.saxpath.XPathReader;
//import org.jaxen.saxpath.base.XPathReader;
//import org.jaxen.jdom.DocumentNavigator;
import org.jaxen.jdom.JDOMXPath;
import org.jaxen.expr.Expr;
import org.dom4j.io.SAXReader;
import org.w3c.dom.*;
import org.jaxen.expr.*;
import org.jaxen.BaseXPath;
import org.jaxen.Function;
import org.jaxen.SimpleVariableContext;
import org.jaxen.JaxenRuntimeException;
import org.jaxen.FunctionCallException;
import org.jaxen.XPathFunctionContext;

import java.io.IOException;
import java.io.ObjectOutputStream;
//import org.jaxen.xom.DocumentNavigator;
//import nu.xom.Element;
import java.io.ObjectInputStream;
import org.w3c.dom.Node;
import org.jaxen.JaxenException;
import nu.xom.Builder;
import java.util.Iterator;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.io.ByteArrayInputStream;
import org.w3c.dom.Comment;
import org.jaxen.dom.*;
import org.jaxen.expr.DefaultXPathFactory;
import org.jaxen.saxpath.Axis;
import org.dom4j.tree.DefaultElement;
//import nu.xom.Document;
import java.io.StringWriter;
import org.jaxen.pattern.PatternParser;
import javax.xml.parsers.ParserConfigurationException;
import java.io.ByteArrayOutputStream;
import org.xml.sax.SAXException;
import org.xml.sax.InputSource;
import org.jaxen.dom.DOMXPath;
import org.jaxen.util.FollowingSiblingAxisIterator;
import org.jdom.Text;
import org.jaxen.util.PrecedingSiblingAxisIterator;
import org.dom4j.tree.DefaultDocument;
import org.jaxen.dom.NamespaceNode;
import junit.framework.TestSuite;
import java.util.Map;
import org.jaxen.util.DescendantAxisIterator;
import java.io.InputStream;
import org.jaxen.*;
import java.util.NoSuchElementException;
import org.w3c.dom.Element;
import org.jaxen.ContextSupport;
//import org.jaxen.saxpath.XPathSyntaxException;
//import org.jaxen.dom4j.DocumentNavigator;
import org.jaxen.Context;
import org.jaxen.saxpath.SAXPathException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import junit.framework.TestCase;
import org.jaxen.XPathSyntaxException;
import org.w3c.dom.ProcessingInstruction;
import org.jaxen.saxpath.helpers.XPathReaderFactory;
import org.jaxen.util.AncestorOrSelfAxisIterator;
import org.jdom.Attribute;
import org.jdom.JDOMException;
import junit.framework.Test;
//import org.dom4j.Element;
import java.util.HashMap;
import org.jdom.Document;
//import org.w3c.dom.Document;
import org.jaxen.function.StringFunction;
import org.jaxen.expr.iter.IterableAxis;
import org.jaxen.Navigator;
import junit.textui.TestRunner;
import org.jaxen.util.PrecedingAxisIterator;
import org.jaxen.expr.iter.IterableSelfAxis;
import org.jaxen.util.SingletonList;
import org.jaxen.xom.XOMXPath;
import java.io.File;
import org.jaxen.expr.XPathExpr;
import org.jaxen.SimpleNamespaceContext;
import org.jaxen.javabean.JavaBeanXPath;
import org.jaxen.util.SingleObjectIterator;
//import org.dom4j.Attribute;
import nu.xom.ParsingException;
import java.io.NotSerializableException;
import org.jaxen.NamespaceContext;
//import org.dom4j.Document;
import org.w3c.dom.Attr;
//import org.jdom.Element;

public class BagClass extends TestCase {

    private Iterator iterator_AncestorOrSelfAxisIteratorTest;

    private org.w3c.dom.Document doc_ArithmeticTest;

    private org.w3c.dom.Document doc_BaseXPathTest;

    private DocumentBuilder builder;

    private org.w3c.dom.Document doc_BooleanTest;

    private org.w3c.dom.Document doc_CeilingTest;

    private org.w3c.dom.Document doc_ConcatTest;

    private org.w3c.dom.Document doc_ContainsTest;

    private List nodeSet_ContextTest;

    private ContextSupport support_ContextTest;

    private org.w3c.dom.Document doc_CountTest;

    private org.w3c.dom.Document doc_DefaultNamestepTest;

    private Iterator iterator_DescendantAxisIteratorTest;

    private NamespaceNode xmlNS;

    private NamespaceNode rootNS;

    private NamespaceNode attributeNS;

//    private SAXReader reader_DOM4JNavigatorTest;

    private static final String BASIC_XML_DOM4JXPathTest = "xml/basic.xml";

    private DocumentBuilder builder_DOMNavigatorTest;

    private static final String BASIC_XML_DOMXPathTest = "xml/basic.xml";

    private org.w3c.dom.Document doc_DOMXPathTest;

    private DocumentBuilderFactory factory_DOMXPathTest;

    private org.w3c.dom.Document doc_ExtensionFunctionTest;

    private org.w3c.dom.Document doc_FalseTest;

    private org.w3c.dom.Document doc_FloorTest;

    private Iterator iterator_FollowingAxisIteratorTest;

    private Iterator iterator_FollowingSiblingAxisIteratorTest;

    private org.w3c.dom.Document doc_FunctionContextTest;

    private org.w3c.dom.Document doc_IdTest;

    private DocumentBuilder builder_IdTest;

    private String[] paths_JaxenHandlerTest = { "foo[.='bar']", "foo[.!='bar']", "/", "*", "//foo", "/*", "/.", "/foo[/bar[/baz]]", "/foo/bar/baz[(1 or 2) + 3 * 4 + 8 and 9]", "/foo/bar/baz", ".[1]", "self::node()", ".", "count(/)", "foo[1]", "/baz[(1 or 2) + 3 * 4 + 8 and 9]", "foo/bar[/baz[(1 or 2) - 3 mod 4 + 8 and 9 div 8]]", "foo/bar/yeah:baz[a/b/c and toast]", "/foo/bar[../x='123']", "/foo[@bar='1234']", "foo|bar", "/foo|/bar[@id='1234']", "count(//author/attribute::*)", "$author", "10 + $foo", "10 + (count(descendant::author) * 5)", "10 + count(descendant::author) * 5", "2 + (2 * 5)", "sum(count(//author), 5)", "sum(count(//author),count(//author/attribute::*))", "12 + sum(count(//author),count(//author/attribute::*)) div 2", "text()[.='foo']", "/*/*[@id='123']", "/child::node()/child::node()[@id='_13563275']", "$foo:bar", "//foo:bar", "/foo/bar[@a='1' and @c!='2']" };

    private String[] bogusPaths_JaxenHandlerTest = { "//:p", "/foo/bar/", "12 + sum(count(//author),count(//author/attribute::*)) / 2", "id()/2", "+" };

    private SAXBuilder builder_JDOMNavigatorTest = new SAXBuilder();

    private static final String BASIC_XML_JDOMXPathTest = "xml/basic.xml";

    private org.w3c.dom.Document doc_LangTest;

    private DocumentBuilder builder_LangTest;

    private org.w3c.dom.Document doc_LastTest;

    private org.w3c.dom.Document doc_LocalNameTest;

    private org.w3c.dom.Document doc;

    private org.w3c.dom.Document doc_NamespaceURITest;

    private DocumentBuilder builder_NamespaceURITest;

    private org.w3c.dom.Document doc_NameTest;

    private org.w3c.dom.Document doc_NodesetEqualityTest;

    private org.w3c.dom.Document doc_NormalizeSpaceTest;

    private org.w3c.dom.Document doc_NotTest;

    private org.w3c.dom.Document doc_NumberTest;

    String[] paths2 = { "foo", "*", "/", "foo/bar", "foo//bar", "/*/foo", "*[@name]", "foo/bar[1]", "foo[bar=\"contents\"]", "foo[bar='contents']", "foo|bar", "foo/title | bar/title | xyz/title", "/foo//*", "foo/text()", "foo/@*" };

    String[] bogusPaths2 = {};

    String[] ignore_bogusPaths = { "/foo/bar/", "12 + sum(count(//author),count(//author/attribute::*)) / 2", "id()/2", "+" };

    private org.w3c.dom.Document doc_PositionTest;

    private Iterator iterator_PrecedingAxisIteratorTest;

    private Iterator iterator_PrecedingSiblingAxisIteratorTest;

    private Iterator iterator_SingleObjectIteratorTest = new SingleObjectIterator(new Object());

    private org.w3c.dom.Document doc_StringLengthTest;

    private org.w3c.dom.Document doc_TranslateFunctionTest;

    private Builder builder_XOMNavigatorTest = new Builder();

    private static final String BASIC_XML_XOMXPathTest = "xml/basic.xml";

    private ConformanceXPathHandler actual_XPathReaderTest;

    private org.w3c.dom.Document doc_XPathReaderTest;

    private org.jaxen.saxpath.base.XPathReader reader_XPathReaderTest;

    private String[] paths_XPathReaderTest = { "/foo/bar[@a='1' and @b='2']", "/foo/bar[@a='1' and @b!='2']", "$varname[@a='1']", "//attribute::*[.!='crunchy']", "'//*[contains(string(text()),\"yada yada\")]'" };

    private String[][] bogusPaths_XPathReaderTest = { new String[] { "chyld::foo", "Expected valid axis name instead of [chyld]" }, new String[] { "foo/tacos()", "Expected node-type" }, new String[] { "foo/tacos()", "Expected node-type" }, new String[] { "*:foo", "Unexpected ':'" }, new String[] { "/foo/bar[baz", "Expected: ]" }, new String[] { "/cracker/cheese[(mold > 1) and (sense/taste", "Expected: )" }, new String[] { "//", "Location path cannot end with //" }, new String[] { "foo/$variable/foo", "Expected one of '.', '..', '@', '*', <QName>" } };


    private String[] paths = { "/foo/bar[@a='1' and @b='2']", "/foo/bar[@a='1' and @b!='2']", "$varname[@a='1']", "//attribute::*[.!='crunchy']", "'//*[contains(string(text()),\"yada yada\")]'" };

    private String[] bogusPaths = {"//:p", "/foo/bar/", "12 + sum(count(//author),count(//author/attribute::*)) / 2", "id()/2", "+" };

    private SAXReader reader_DOM4JNavigatorTest;

    protected static String VAR_URI = "http://jaxen.org/test-harness/var";

    protected static String TESTS_XML = "xml/test/tests.xml";

    protected static boolean verbose = false;

    protected static boolean debug = false;

    private org.jaxen.ContextSupport contextSupport;
    
    public void testDefaultContext_AddNamespaceTest() throws SAXPathException {
        XPath xpath = new DOMXPath("foo");
        xpath.addNamespace("cheese", "http://cheese.org");
        xpath.addNamespace("squeeze", "http://squeeze.org");
        NamespaceContext nsContext = xpath.getNamespaceContext();
        assertEquals("http://cheese.org", nsContext.translateNamespacePrefixToUri("cheese"));
        assertEquals("http://squeeze.org", nsContext.translateNamespacePrefixToUri("squeeze"));
    }

    public void testNoInfiniteLoops_AncestorOrSelfAxisIteratorTest() throws ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        org.w3c.dom.Document doc = factory.newDocumentBuilder().newDocument();
        doc.appendChild(doc.createElement("root"));
        iterator_AncestorOrSelfAxisIteratorTest = new AncestorOrSelfAxisIterator(doc, new org.jaxen.dom.DocumentNavigator());
        iterator_AncestorOrSelfAxisIteratorTest.next();
        try {
            iterator_AncestorOrSelfAxisIteratorTest.next();
            fail("Iterated twice");
        } catch (NoSuchElementException ex) {
        }
    }

    public void testRemove_AncestorOrSelfAxisIteratorTest() throws ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        org.w3c.dom.Document doc = factory.newDocumentBuilder().newDocument();
        doc.appendChild(doc.createElement("root"));
        iterator_AncestorOrSelfAxisIteratorTest = new AncestorOrSelfAxisIterator(doc, new org.jaxen.dom.DocumentNavigator());
        try {
            iterator_AncestorOrSelfAxisIteratorTest.remove();
            fail("Removed from iterator");
        } catch (UnsupportedOperationException ex) {
        }
    }

    public void testNumbersThatBeginWithADecimalPoint_ArithmeticTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc_ArithmeticTest = builder.newDocument();
        org.w3c.dom.Element a = doc_ArithmeticTest.createElementNS("", "a");
        doc_ArithmeticTest.appendChild(a);
        XPath xpath = new DOMXPath(".5 > .4");
        Boolean result = (Boolean) xpath.evaluate(doc_ArithmeticTest);
        assertTrue(result.booleanValue());
    }

    public void testNumbersThatBeginWithADecimalPoint2_ArithmeticTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc_ArithmeticTest = builder.newDocument();
        org.w3c.dom.Element a = doc_ArithmeticTest.createElementNS("", "a");
        doc_ArithmeticTest.appendChild(a);
        XPath xpath = new DOMXPath(".3 <= .4 <= 1.1");
        Boolean result = (Boolean) xpath.evaluate(doc_ArithmeticTest);
        assertTrue(result.booleanValue());
    }

    public void testLeftAssociativityOfLessThanOrEqual_ArithmeticTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc_ArithmeticTest = builder.newDocument();
        org.w3c.dom.Element a = doc_ArithmeticTest.createElementNS("", "a");
        doc_ArithmeticTest.appendChild(a);
        XPath xpath = new DOMXPath(".3 <= .4 <= 0.9");
        Boolean result = (Boolean) xpath.evaluate(doc_ArithmeticTest);
        assertFalse(result.booleanValue());
    }

    public void testIllegalAxisNumber_AxisTest() {
        try {
            Axis.lookup(-10009);
            fail("Looked up negative number");
        } catch (JaxenRuntimeException ex) {
            assertEquals("Illegal Axis Number", ex.getMessage());
        }
    }

    public void testSelectSingleNodeForContext_BaseXPathTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        doc_BaseXPathTest = factory.newDocumentBuilder().newDocument();
        builder = factory.newDocumentBuilder();
        BaseXPath xpath = new DOMXPath("1 + 2");
        String stringValue = xpath.stringValueOf(xpath);
        assertEquals("3", stringValue);
        Number numberValue = xpath.numberValueOf(xpath);
        assertEquals(3, numberValue.doubleValue(), 0.00001);
    }

    public void testParentOfSelection_BaseXPathTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        doc_BaseXPathTest = factory.newDocumentBuilder().newDocument();
        builder = factory.newDocumentBuilder();
        XPath xpath = new DOMXPath("(/html/a/img[contains(@src,'gif')])[2]/..");
        org.w3c.dom.Element html = doc_BaseXPathTest.createElementNS("", "html");
        org.w3c.dom.Element a1 = doc_BaseXPathTest.createElementNS("", "a");
        org.w3c.dom.Element a2 = doc_BaseXPathTest.createElementNS("", "a");
        org.w3c.dom.Element img1 = doc_BaseXPathTest.createElementNS("", "img");
        org.w3c.dom.Attr img1_src = doc_BaseXPathTest.createAttributeNS("", "src");
        img1_src.setValue("1.gif");
        org.w3c.dom.Element img2 = doc_BaseXPathTest.createElementNS("", "img");
        org.w3c.dom.Attr img2_src = doc_BaseXPathTest.createAttributeNS("", "src");
        img2_src.setValue("2.gif");
        img1.setAttributeNode(img1_src);
        img2.setAttributeNode(img2_src);
        a1.appendChild(img1);
        a2.appendChild(img2);
        html.appendChild(a1);
        html.appendChild(a2);
        doc_BaseXPathTest.appendChild(html);
        List result = xpath.selectNodes(doc_BaseXPathTest);
        assertEquals(1, result.size());
        assertEquals(a2, result.get(0));
    }

    public void testEvaluateString_BaseXPathTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        doc_BaseXPathTest = factory.newDocumentBuilder().newDocument();
        builder = factory.newDocumentBuilder();
        BaseXPath xpath = new DOMXPath("string(/*)");
        doc_BaseXPathTest.appendChild(doc_BaseXPathTest.createElement("root"));
        String stringValue = (String) xpath.evaluate(doc_BaseXPathTest);
        assertEquals("", stringValue);
    }

    public void testNumberValueOfEmptyNodeSetIsNaN_BaseXPathTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        doc_BaseXPathTest = factory.newDocumentBuilder().newDocument();
        builder = factory.newDocumentBuilder();
        BaseXPath xpath = new DOMXPath("/x");
        doc_BaseXPathTest.appendChild(doc_BaseXPathTest.createElement("root"));
        Double numberValue = (Double) xpath.numberValueOf(doc_BaseXPathTest);
        assertTrue(numberValue.isNaN());
    }

    public void testPathWithParentheses_BaseXPathTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        doc_BaseXPathTest = factory.newDocumentBuilder().newDocument();
        builder = factory.newDocumentBuilder();
        BaseXPath xpath = new DOMXPath("(/root)/child");
        Element root = doc_BaseXPathTest.createElement("root");
        doc_BaseXPathTest.appendChild(root);
        Element child = doc_BaseXPathTest.createElement("child");
        root.appendChild(child);
        assertEquals(child, xpath.selectSingleNode(doc_BaseXPathTest));
    }

    public void testEvaluateWithMultiNodeAnswer_BaseXPathTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        doc_BaseXPathTest = factory.newDocumentBuilder().newDocument();
        builder = factory.newDocumentBuilder();
        BaseXPath xpath = new DOMXPath("(/descendant-or-self::node())");
        doc_BaseXPathTest.appendChild(doc_BaseXPathTest.createElement("root"));
        List result = (List) xpath.evaluate(doc_BaseXPathTest);
        assertEquals(2, result.size());
    }

    public void testValueOfEmptyListIsEmptyString_BaseXPathTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        doc_BaseXPathTest = factory.newDocumentBuilder().newDocument();
        builder = factory.newDocumentBuilder();
        BaseXPath xpath = new DOMXPath("/element");
        doc_BaseXPathTest.appendChild(doc_BaseXPathTest.createElement("root"));
        String stringValue = xpath.stringValueOf(doc_BaseXPathTest);
        assertEquals("", stringValue);
    }

    public void testAllNodesQuery_BaseXPathTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        doc_BaseXPathTest = factory.newDocumentBuilder().newDocument();
        builder = factory.newDocumentBuilder();
        BaseXPath xpath = new DOMXPath("//. | /");
        org.w3c.dom.Element root = doc_BaseXPathTest.createElementNS("http://www.example.org/", "root");
        doc_BaseXPathTest.appendChild(root);
        String stringValue = xpath.stringValueOf(doc_BaseXPathTest);
        assertEquals("", stringValue);
    }

    public void testAncestorAxis_BaseXPathTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        doc_BaseXPathTest = factory.newDocumentBuilder().newDocument();
        builder = factory.newDocumentBuilder();
        BaseXPath xpath = new DOMXPath("ancestor::*");
        org.w3c.dom.Element root = doc_BaseXPathTest.createElementNS("", "root");
        org.w3c.dom.Element parent = doc_BaseXPathTest.createElementNS("", "parent");
        doc_BaseXPathTest.appendChild(root);
        org.w3c.dom.Element child = doc_BaseXPathTest.createElementNS("", "child");
        root.appendChild(parent);
        parent.appendChild(child);
        List result = xpath.selectNodes(child);
        assertEquals(2, result.size());
        assertEquals(root, result.get(0));
        assertEquals(parent, result.get(1));
    }

    public void testPrecedingSiblingAxisIsInDocumentOrder_BaseXPathTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        doc_BaseXPathTest = factory.newDocumentBuilder().newDocument();
        builder = factory.newDocumentBuilder();
        BaseXPath xpath = new DOMXPath("preceding-sibling::*");
        org.w3c.dom.Element root = doc_BaseXPathTest.createElementNS("", "root");
        doc_BaseXPathTest.appendChild(root);
        org.w3c.dom.Element child1 = doc_BaseXPathTest.createElementNS("", "child1");
        root.appendChild(child1);
        org.w3c.dom.Element child2 = doc_BaseXPathTest.createElementNS("", "child2");
        root.appendChild(child2);
        org.w3c.dom.Element child3 = doc_BaseXPathTest.createElementNS("", "child3");
        root.appendChild(child3);
        List result = xpath.selectNodes(child3);
        assertEquals(2, result.size());
        assertEquals(child1, result.get(0));
        assertEquals(child2, result.get(1));
    }

    public void testPrecedingAxisIsInDocumentOrder_BaseXPathTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        doc_BaseXPathTest = factory.newDocumentBuilder().newDocument();
        builder = factory.newDocumentBuilder();
        BaseXPath xpath = new DOMXPath("preceding::*");
        org.w3c.dom.Element root = doc_BaseXPathTest.createElementNS("", "root");
        doc_BaseXPathTest.appendChild(root);
        org.w3c.dom.Element parent1 = doc_BaseXPathTest.createElementNS("", "parent1");
        root.appendChild(parent1);
        org.w3c.dom.Element parent2 = doc_BaseXPathTest.createElementNS("", "parent2");
        root.appendChild(parent2);
        org.w3c.dom.Element child1 = doc_BaseXPathTest.createElementNS("", "child1");
        parent2.appendChild(child1);
        org.w3c.dom.Element child2 = doc_BaseXPathTest.createElementNS("", "child2");
        parent2.appendChild(child2);
        org.w3c.dom.Element child3 = doc_BaseXPathTest.createElementNS("", "child3");
        parent2.appendChild(child3);
        List result = xpath.selectNodes(child3);
        assertEquals(3, result.size());
        assertEquals(parent1, result.get(0));
        assertEquals(child1, result.get(1));
        assertEquals(child2, result.get(2));
    }

    public void testPrecedingAxisWithPositionalPredicate_BaseXPathTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        doc_BaseXPathTest = factory.newDocumentBuilder().newDocument();
        builder = factory.newDocumentBuilder();
        BaseXPath xpath = new DOMXPath("preceding::*[1]");
        org.w3c.dom.Element root = doc_BaseXPathTest.createElementNS("", "root");
        doc_BaseXPathTest.appendChild(root);
        org.w3c.dom.Element child1 = doc_BaseXPathTest.createElementNS("", "child1");
        root.appendChild(child1);
        org.w3c.dom.Element child2 = doc_BaseXPathTest.createElementNS("", "child2");
        root.appendChild(child2);
        org.w3c.dom.Element child3 = doc_BaseXPathTest.createElementNS("", "child3");
        root.appendChild(child3);
        List result = xpath.selectNodes(child3);
        assertEquals(1, result.size());
        assertEquals(child2, result.get(0));
    }

    public void testAncestorAxisWithPositionalPredicate_BaseXPathTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        doc_BaseXPathTest = factory.newDocumentBuilder().newDocument();
        builder = factory.newDocumentBuilder();
        BaseXPath xpath = new DOMXPath("ancestor::*[1]");
        org.w3c.dom.Element root = doc_BaseXPathTest.createElementNS("", "root");
        doc_BaseXPathTest.appendChild(root);
        org.w3c.dom.Element child1 = doc_BaseXPathTest.createElementNS("", "child1");
        root.appendChild(child1);
        org.w3c.dom.Element child2 = doc_BaseXPathTest.createElementNS("", "child2");
        child1.appendChild(child2);
        org.w3c.dom.Element child3 = doc_BaseXPathTest.createElementNS("", "child3");
        child2.appendChild(child3);
        List result = xpath.selectNodes(child3);
        assertEquals(1, result.size());
        assertEquals(child2, result.get(0));
    }

    public void testAncestorOrSelfAxis_BaseXPathTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        doc_BaseXPathTest = factory.newDocumentBuilder().newDocument();
        builder = factory.newDocumentBuilder();
        BaseXPath xpath = new DOMXPath("ancestor-or-self::*");
        org.w3c.dom.Element root = doc_BaseXPathTest.createElementNS("", "root");
        org.w3c.dom.Element parent = doc_BaseXPathTest.createElementNS("", "parent");
        doc_BaseXPathTest.appendChild(root);
        org.w3c.dom.Element child = doc_BaseXPathTest.createElementNS("", "child");
        root.appendChild(parent);
        parent.appendChild(child);
        List result = xpath.selectNodes(child);
        assertEquals(3, result.size());
        assertEquals(root, result.get(0));
        assertEquals(parent, result.get(1));
        assertEquals(child, result.get(2));
    }

    public void testAbbreviatedDoubleSlashAxis_BaseXPathTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        doc_BaseXPathTest = factory.newDocumentBuilder().newDocument();
        builder = factory.newDocumentBuilder();
        BaseXPath xpath = new DOMXPath("//x");
        org.w3c.dom.Element a = doc_BaseXPathTest.createElementNS("", "a");
        org.w3c.dom.Element b = doc_BaseXPathTest.createElementNS("", "b");
        doc_BaseXPathTest.appendChild(a);
        org.w3c.dom.Element x1 = doc_BaseXPathTest.createElementNS("", "x");
        x1.appendChild(doc_BaseXPathTest.createTextNode("1"));
        a.appendChild(x1);
        a.appendChild(b);
        org.w3c.dom.Element x2 = doc_BaseXPathTest.createElementNS("", "x");
        org.w3c.dom.Element x3 = doc_BaseXPathTest.createElementNS("", "x");
        org.w3c.dom.Element x4 = doc_BaseXPathTest.createElementNS("", "x");
        a.appendChild(x4);
        b.appendChild(x2);
        b.appendChild(x3);
        x2.appendChild(doc_BaseXPathTest.createTextNode("2"));
        x3.appendChild(doc_BaseXPathTest.createTextNode("3"));
        x4.appendChild(doc_BaseXPathTest.createTextNode("4"));
        List result = xpath.selectNodes(doc_BaseXPathTest);
        assertEquals(4, result.size());
        assertEquals(x1, result.get(0));
        assertEquals(x2, result.get(1));
        assertEquals(x3, result.get(2));
        assertEquals(x4, result.get(3));
    }

    public void testAncestorFollowedByChildren_BaseXPathTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        doc_BaseXPathTest = factory.newDocumentBuilder().newDocument();
        builder = factory.newDocumentBuilder();
        BaseXPath xpath = new DOMXPath("/a/b/x/ancestor::*/child::x");
        org.w3c.dom.Element a = doc_BaseXPathTest.createElementNS("", "a");
        org.w3c.dom.Element b = doc_BaseXPathTest.createElementNS("", "b");
        doc_BaseXPathTest.appendChild(a);
        org.w3c.dom.Element x1 = doc_BaseXPathTest.createElementNS("", "x");
        x1.appendChild(doc_BaseXPathTest.createTextNode("1"));
        a.appendChild(x1);
        a.appendChild(b);
        org.w3c.dom.Element x2 = doc_BaseXPathTest.createElementNS("", "x");
        org.w3c.dom.Element x3 = doc_BaseXPathTest.createElementNS("", "x");
        org.w3c.dom.Element x4 = doc_BaseXPathTest.createElementNS("", "x");
        a.appendChild(x4);
        b.appendChild(x2);
        b.appendChild(x3);
        x2.appendChild(doc_BaseXPathTest.createTextNode("2"));
        x3.appendChild(doc_BaseXPathTest.createTextNode("3"));
        x4.appendChild(doc_BaseXPathTest.createTextNode("4"));
        List result = xpath.selectNodes(doc_BaseXPathTest);
        assertEquals(4, result.size());
        assertEquals(x1, result.get(0));
        assertEquals(x2, result.get(1));
        assertEquals(x3, result.get(2));
        assertEquals(x4, result.get(3));
    }

    public void testDescendantAxis_BaseXPathTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        doc_BaseXPathTest = factory.newDocumentBuilder().newDocument();
        builder = factory.newDocumentBuilder();
        BaseXPath xpath = new DOMXPath("/descendant::x");
        org.w3c.dom.Element a = doc_BaseXPathTest.createElementNS("", "a");
        org.w3c.dom.Element b = doc_BaseXPathTest.createElementNS("", "b");
        doc_BaseXPathTest.appendChild(a);
        org.w3c.dom.Element x1 = doc_BaseXPathTest.createElementNS("", "x");
        x1.appendChild(doc_BaseXPathTest.createTextNode("1"));
        a.appendChild(x1);
        a.appendChild(b);
        org.w3c.dom.Element x2 = doc_BaseXPathTest.createElementNS("", "x");
        org.w3c.dom.Element x3 = doc_BaseXPathTest.createElementNS("", "x");
        org.w3c.dom.Element x4 = doc_BaseXPathTest.createElementNS("", "x");
        a.appendChild(x4);
        b.appendChild(x2);
        b.appendChild(x3);
        x2.appendChild(doc_BaseXPathTest.createTextNode("2"));
        x3.appendChild(doc_BaseXPathTest.createTextNode("3"));
        x4.appendChild(doc_BaseXPathTest.createTextNode("4"));
        List result = xpath.selectNodes(doc_BaseXPathTest);
        assertEquals(4, result.size());
        assertEquals(x1, result.get(0));
        assertEquals(x2, result.get(1));
        assertEquals(x3, result.get(2));
        assertEquals(x4, result.get(3));
    }

    public void testDescendantAxisWithAttributes_BaseXPathTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        doc_BaseXPathTest = factory.newDocumentBuilder().newDocument();
        builder = factory.newDocumentBuilder();
        BaseXPath xpath = new DOMXPath("/descendant::x/@*");
        org.w3c.dom.Element a = doc_BaseXPathTest.createElementNS("", "a");
        org.w3c.dom.Element b = doc_BaseXPathTest.createElementNS("", "b");
        doc_BaseXPathTest.appendChild(a);
        org.w3c.dom.Element x1 = doc_BaseXPathTest.createElementNS("", "x");
        a.appendChild(x1);
        a.appendChild(b);
        org.w3c.dom.Element x2 = doc_BaseXPathTest.createElementNS("", "x");
        org.w3c.dom.Element x3 = doc_BaseXPathTest.createElementNS("", "x");
        org.w3c.dom.Element x4 = doc_BaseXPathTest.createElementNS("", "x");
        a.appendChild(x4);
        b.appendChild(x2);
        b.appendChild(x3);
        Attr a1 = doc_BaseXPathTest.createAttribute("name");
        a1.setNodeValue("1");
        x1.setAttributeNode(a1);
        Attr a2 = doc_BaseXPathTest.createAttribute("name");
        a2.setNodeValue("2");
        x2.setAttributeNode(a2);
        Attr a3 = doc_BaseXPathTest.createAttribute("name");
        a3.setNodeValue("3");
        x3.setAttributeNode(a3);
        Attr a4 = doc_BaseXPathTest.createAttribute("name");
        a4.setNodeValue("4");
        x4.setAttributeNode(a4);
        List result = xpath.selectNodes(doc_BaseXPathTest);
        assertEquals(4, result.size());
        assertEquals(a1, result.get(0));
        assertEquals(a2, result.get(1));
        assertEquals(a3, result.get(2));
        assertEquals(a4, result.get(3));
    }

    public void testDescendantAxisWithNamespaceNodes_BaseXPathTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        doc_BaseXPathTest = factory.newDocumentBuilder().newDocument();
        builder = factory.newDocumentBuilder();
        BaseXPath xpath = new DOMXPath("/descendant::x/namespace::node()");
        org.w3c.dom.Element a = doc_BaseXPathTest.createElementNS("", "a");
        org.w3c.dom.Element b = doc_BaseXPathTest.createElementNS("", "b");
        doc_BaseXPathTest.appendChild(a);
        org.w3c.dom.Element x1 = doc_BaseXPathTest.createElementNS("", "x");
        a.appendChild(x1);
        a.appendChild(b);
        org.w3c.dom.Element x2 = doc_BaseXPathTest.createElementNS("", "x");
        org.w3c.dom.Element x3 = doc_BaseXPathTest.createElementNS("", "x");
        org.w3c.dom.Element x4 = doc_BaseXPathTest.createElementNS("", "x");
        a.appendChild(x4);
        b.appendChild(x2);
        b.appendChild(x3);
        Attr a1 = doc_BaseXPathTest.createAttributeNS("http://www.w3.org/2000/xmlns/", "xmlns:a");
        a1.setNodeValue("http://www.example.org/");
        x1.setAttributeNode(a1);
        Attr a2 = doc_BaseXPathTest.createAttributeNS("http://www.w3.org/2000/xmlns/", "xmlns:b");
        a2.setNodeValue("http://www.example.org/");
        x2.setAttributeNode(a2);
        Attr a3 = doc_BaseXPathTest.createAttributeNS("http://www.w3.org/2000/xmlns/", "xmlns:c");
        a3.setNodeValue("http://www.example.org/");
        x3.setAttributeNode(a3);
        Attr a4 = doc_BaseXPathTest.createAttributeNS("http://www.w3.org/2000/xmlns/", "xmlns:d");
        a4.setNodeValue("http://www.example.org/");
        x4.setAttributeNode(a4);
        List result = xpath.selectNodes(doc_BaseXPathTest);
        assertEquals(8, result.size());
        Iterator iterator = result.iterator();
        StringBuffer sb = new StringBuffer(4);
        while (iterator.hasNext()) {
            NamespaceNode ns = (NamespaceNode) iterator.next();
            if (ns.getNodeValue().equals("http://www.example.org/")) {
                String name = ns.getNodeName();
                sb.append(name);
            }
        }
        assertEquals("abcd", sb.toString());
    }

    public void testMultipleAttributesOnElement_BaseXPathTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        doc_BaseXPathTest = factory.newDocumentBuilder().newDocument();
        builder = factory.newDocumentBuilder();
        BaseXPath xpath = new DOMXPath("/descendant::x/@*");
        org.w3c.dom.Element a = doc_BaseXPathTest.createElementNS("", "a");
        org.w3c.dom.Element b = doc_BaseXPathTest.createElementNS("", "b");
        doc_BaseXPathTest.appendChild(a);
        org.w3c.dom.Element x1 = doc_BaseXPathTest.createElementNS("", "x");
        a.appendChild(x1);
        a.appendChild(b);
        Attr a1 = doc_BaseXPathTest.createAttribute("name1");
        a1.setNodeValue("1");
        x1.setAttributeNode(a1);
        Attr a2 = doc_BaseXPathTest.createAttribute("name2");
        a2.setNodeValue("2");
        x1.setAttributeNode(a2);
        Attr a3 = doc_BaseXPathTest.createAttribute("name3");
        a3.setNodeValue("3");
        x1.setAttributeNode(a3);
        Attr a4 = doc_BaseXPathTest.createAttribute("name4");
        a4.setNodeValue("4");
        x1.setAttributeNode(a4);
        List result = xpath.selectNodes(doc_BaseXPathTest);
        assertEquals(4, result.size());
        assertTrue(result.contains(a1));
        assertTrue(result.contains(a2));
        assertTrue(result.contains(a3));
        assertTrue(result.contains(a4));
    }

    public void testXMLNamespaceAttributeOrderOnAncestorAxis_BaseXPathTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        doc_BaseXPathTest = factory.newDocumentBuilder().newDocument();
        builder = factory.newDocumentBuilder();
        org.w3c.dom.Element superroot = doc_BaseXPathTest.createElement("superroot");
        doc_BaseXPathTest.appendChild(superroot);
        org.w3c.dom.Element root = doc_BaseXPathTest.createElement("root");
        superroot.appendChild(root);
        org.w3c.dom.Attr p0 = doc_BaseXPathTest.createAttributeNS("http://www.w3.org/XML/1998/namespace", "xml:id");
        p0.setValue("p0");
        superroot.setAttributeNodeNS(p0);
        org.w3c.dom.Attr p1 = doc_BaseXPathTest.createAttributeNS("http://www.w3.org/XML/1998/namespace", "xml:id");
        p1.setValue("p1");
        root.setAttributeNodeNS(p1);
        org.w3c.dom.Element child = doc_BaseXPathTest.createElement("child312");
        root.appendChild(child);
        BaseXPath xpath = new DOMXPath("ancestor::*/@xml:*");
        List result = xpath.selectNodes(child);
        assertEquals(2, result.size());
        assertEquals(p0, result.get(0));
        assertEquals(p1, result.get(1));
    }

    public void testDescendantAxisWithAttributesAndChildren_BaseXPathTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        doc_BaseXPathTest = factory.newDocumentBuilder().newDocument();
        builder = factory.newDocumentBuilder();
        BaseXPath xpath = new DOMXPath("/descendant::x/@* | /descendant::x");
        org.w3c.dom.Element a = doc_BaseXPathTest.createElementNS("", "a");
        org.w3c.dom.Element b = doc_BaseXPathTest.createElementNS("", "b");
        doc_BaseXPathTest.appendChild(a);
        org.w3c.dom.Element x1 = doc_BaseXPathTest.createElementNS("", "x");
        a.appendChild(x1);
        a.appendChild(b);
        org.w3c.dom.Element x2 = doc_BaseXPathTest.createElementNS("", "x");
        org.w3c.dom.Element x3 = doc_BaseXPathTest.createElementNS("", "x");
        org.w3c.dom.Element x4 = doc_BaseXPathTest.createElementNS("", "x");
        a.appendChild(x4);
        b.appendChild(x2);
        b.appendChild(x3);
        Attr a1 = doc_BaseXPathTest.createAttribute("name");
        a1.setNodeValue("1");
        x1.setAttributeNode(a1);
        Attr a2 = doc_BaseXPathTest.createAttribute("name");
        a2.setNodeValue("2");
        x2.setAttributeNode(a2);
        Attr a3 = doc_BaseXPathTest.createAttribute("name");
        a3.setNodeValue("3");
        x3.setAttributeNode(a3);
        Attr a4 = doc_BaseXPathTest.createAttribute("name");
        a4.setNodeValue("4");
        x4.setAttributeNode(a4);
        List result = xpath.selectNodes(doc_BaseXPathTest);
        assertEquals(8, result.size());
        assertEquals(x1, result.get(0));
        assertEquals(a1, result.get(1));
        assertEquals(x2, result.get(2));
        assertEquals(a2, result.get(3));
        assertEquals(x3, result.get(4));
        assertEquals(a3, result.get(5));
        assertEquals(x4, result.get(6));
        assertEquals(a4, result.get(7));
    }

    public void testAncestorAxisWithAttributes_BaseXPathTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        doc_BaseXPathTest = factory.newDocumentBuilder().newDocument();
        builder = factory.newDocumentBuilder();
        BaseXPath xpath = new DOMXPath("ancestor::*/@*");
        org.w3c.dom.Element a = doc_BaseXPathTest.createElementNS("", "a");
        org.w3c.dom.Element b = doc_BaseXPathTest.createElementNS("", "b");
        doc_BaseXPathTest.appendChild(a);
        a.appendChild(b);
        org.w3c.dom.Element x3 = doc_BaseXPathTest.createElementNS("", "x");
        b.appendChild(x3);
        Attr a1 = doc_BaseXPathTest.createAttribute("name");
        a1.setNodeValue("1");
        a.setAttributeNode(a1);
        Attr a2 = doc_BaseXPathTest.createAttribute("name");
        a2.setNodeValue("2");
        b.setAttributeNode(a2);
        Attr a3 = doc_BaseXPathTest.createAttribute("name");
        x3.setNodeValue("3");
        x3.setAttributeNode(a3);
        List result = xpath.selectNodes(x3);
        assertEquals(2, result.size());
        assertEquals(a1, result.get(0));
        assertEquals(a2, result.get(1));
    }

    public void testPrincipalNodeTypeOfSelfAxisIsElement_BaseXPathTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        doc_BaseXPathTest = factory.newDocumentBuilder().newDocument();
        builder = factory.newDocumentBuilder();
        BaseXPath xpath = new DOMXPath("child/@*[self::test]");
        org.w3c.dom.Element a = doc_BaseXPathTest.createElementNS("", "child");
        org.w3c.dom.Attr test = doc_BaseXPathTest.createAttributeNS("", "test");
        test.setValue("value");
        a.setAttributeNode(test);
        doc_BaseXPathTest.appendChild(a);
        List result = xpath.selectNodes(doc_BaseXPathTest);
        assertEquals(0, result.size());
    }

    public void testSelfAxisWithNodeTestCanReturnNonPrincipalNodeType_BaseXPathTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        doc_BaseXPathTest = factory.newDocumentBuilder().newDocument();
        builder = factory.newDocumentBuilder();
        BaseXPath xpath = new DOMXPath("child/@*[self::node()]");
        org.w3c.dom.Element a = doc_BaseXPathTest.createElementNS("", "child");
        org.w3c.dom.Attr test = doc_BaseXPathTest.createAttributeNS("", "test");
        test.setValue("value");
        a.setAttributeNode(test);
        doc_BaseXPathTest.appendChild(a);
        List result = xpath.selectNodes(doc_BaseXPathTest);
        assertEquals(1, result.size());
    }

    public void testDescendantOrSelfAxis_BaseXPathTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        doc_BaseXPathTest = factory.newDocumentBuilder().newDocument();
        builder = factory.newDocumentBuilder();
        BaseXPath xpath = new DOMXPath("/descendant-or-self::x");
        org.w3c.dom.Element a = doc_BaseXPathTest.createElementNS("", "a");
        org.w3c.dom.Element b = doc_BaseXPathTest.createElementNS("", "b");
        doc_BaseXPathTest.appendChild(a);
        org.w3c.dom.Element x1 = doc_BaseXPathTest.createElementNS("", "x");
        x1.appendChild(doc_BaseXPathTest.createTextNode("1"));
        a.appendChild(x1);
        a.appendChild(b);
        org.w3c.dom.Element x2 = doc_BaseXPathTest.createElementNS("", "x");
        org.w3c.dom.Element x3 = doc_BaseXPathTest.createElementNS("", "x");
        org.w3c.dom.Element x4 = doc_BaseXPathTest.createElementNS("", "x");
        a.appendChild(x4);
        b.appendChild(x2);
        b.appendChild(x3);
        x2.appendChild(doc_BaseXPathTest.createTextNode("2"));
        x3.appendChild(doc_BaseXPathTest.createTextNode("3"));
        x4.appendChild(doc_BaseXPathTest.createTextNode("4"));
        List result = xpath.selectNodes(doc_BaseXPathTest);
        assertEquals(4, result.size());
        assertEquals(x1, result.get(0));
        assertEquals(x2, result.get(1));
        assertEquals(x3, result.get(2));
        assertEquals(x4, result.get(3));
    }

    public void testDuplicateNodes_BaseXPathTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        doc_BaseXPathTest = factory.newDocumentBuilder().newDocument();
        builder = factory.newDocumentBuilder();
        BaseXPath xpath = new DOMXPath("//x | //*");
        org.w3c.dom.Element a = doc_BaseXPathTest.createElementNS("", "a");
        org.w3c.dom.Element b = doc_BaseXPathTest.createElementNS("", "b");
        doc_BaseXPathTest.appendChild(a);
        org.w3c.dom.Element x1 = doc_BaseXPathTest.createElementNS("", "x");
        x1.appendChild(doc_BaseXPathTest.createTextNode("1"));
        a.appendChild(x1);
        a.appendChild(b);
        org.w3c.dom.Element x2 = doc_BaseXPathTest.createElementNS("", "x");
        org.w3c.dom.Element x3 = doc_BaseXPathTest.createElementNS("", "x");
        org.w3c.dom.Element x4 = doc_BaseXPathTest.createElementNS("", "x");
        a.appendChild(x4);
        b.appendChild(x2);
        b.appendChild(x3);
        x2.appendChild(doc_BaseXPathTest.createTextNode("2"));
        x3.appendChild(doc_BaseXPathTest.createTextNode("3"));
        x4.appendChild(doc_BaseXPathTest.createTextNode("4"));
        List result = xpath.selectNodes(doc_BaseXPathTest);
        assertEquals(6, result.size());
    }

    public void testUnionOfNodesWithNonNodes_BaseXPathTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        doc_BaseXPathTest = factory.newDocumentBuilder().newDocument();
        builder = factory.newDocumentBuilder();
        BaseXPath xpath = new DOMXPath("count(//*) | //x ");
        org.w3c.dom.Element a = doc_BaseXPathTest.createElementNS("", "a");
        org.w3c.dom.Element b = doc_BaseXPathTest.createElementNS("", "b");
        doc_BaseXPathTest.appendChild(a);
        org.w3c.dom.Element x1 = doc_BaseXPathTest.createElementNS("", "x");
        x1.appendChild(doc_BaseXPathTest.createTextNode("1"));
        a.appendChild(x1);
        a.appendChild(b);
        org.w3c.dom.Element x2 = doc_BaseXPathTest.createElementNS("", "x");
        org.w3c.dom.Element x3 = doc_BaseXPathTest.createElementNS("", "x");
        org.w3c.dom.Element x4 = doc_BaseXPathTest.createElementNS("", "x");
        a.appendChild(x4);
        b.appendChild(x2);
        b.appendChild(x3);
        x2.appendChild(doc_BaseXPathTest.createTextNode("2"));
        x3.appendChild(doc_BaseXPathTest.createTextNode("3"));
        x4.appendChild(doc_BaseXPathTest.createTextNode("4"));
        try {
            xpath.selectNodes(doc_BaseXPathTest);
            fail("Allowed union with non-node-set");
        } catch (JaxenException ex) {
            assertNotNull(ex.getMessage());
        }
    }

    public void testUnionOfEmptyNodeSetWithNonNodes_BaseXPathTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        doc_BaseXPathTest = factory.newDocumentBuilder().newDocument();
        builder = factory.newDocumentBuilder();
        BaseXPath xpath = new DOMXPath("//y | count(//*)");
        org.w3c.dom.Element a = doc_BaseXPathTest.createElementNS("", "a");
        org.w3c.dom.Element b = doc_BaseXPathTest.createElementNS("", "b");
        doc_BaseXPathTest.appendChild(a);
        org.w3c.dom.Element x1 = doc_BaseXPathTest.createElementNS("", "x");
        x1.appendChild(doc_BaseXPathTest.createTextNode("1"));
        a.appendChild(x1);
        a.appendChild(b);
        org.w3c.dom.Element x2 = doc_BaseXPathTest.createElementNS("", "x");
        b.appendChild(x2);
        x2.appendChild(doc_BaseXPathTest.createTextNode("2"));
        try {
            xpath.selectNodes(doc_BaseXPathTest);
            fail("Allowed union with non-node-set");
        } catch (JaxenException ex) {
            assertNotNull(ex.getMessage());
        }
    }

    public void testSelectSingleNodeSelectsNothing_BaseXPathTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        doc_BaseXPathTest = factory.newDocumentBuilder().newDocument();
        builder = factory.newDocumentBuilder();
        BaseXPath xpath = new DOMXPath("id('p1')");
        org.w3c.dom.Element a = doc_BaseXPathTest.createElementNS("", "a");
        doc_BaseXPathTest.appendChild(a);
        Object result = xpath.selectSingleNode(doc_BaseXPathTest);
        assertNull(result);
    }

    public void testSAXPathExceptionThrownFromConstructor_BaseXPathTest() throws ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        doc_BaseXPathTest = factory.newDocumentBuilder().newDocument();
        builder = factory.newDocumentBuilder();
        System.setProperty(XPathReaderFactory.DRIVER_PROPERTY, "java.lang.String");
        try {
            new DOMXPath("id('p1')");
        } catch (JaxenException e) {
            assertNotNull(e.getMessage());
        } finally {
            System.setProperty(XPathReaderFactory.DRIVER_PROPERTY, "");
        }
    }

    public void testBooleanValueOfEmptyNodeSetIsFalse_BaseXPathTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        doc_BaseXPathTest = factory.newDocumentBuilder().newDocument();
        builder = factory.newDocumentBuilder();
        BaseXPath xpath = new DOMXPath("/b/c");
        org.w3c.dom.Element a = doc_BaseXPathTest.createElementNS("", "a");
        doc_BaseXPathTest.appendChild(a);
        List result = xpath.selectNodes(doc_BaseXPathTest);
        assertTrue(!xpath.booleanValueOf(result));
    }

    public void testAddNamespaceWithNonSimpleNamespaceContext_BaseXPathTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        doc_BaseXPathTest = factory.newDocumentBuilder().newDocument();
        builder = factory.newDocumentBuilder();
        BaseXPath xpath = new DOMXPath("/b/c");
        xpath.setNamespaceContext(new NamespaceContext() {

            public String translateNamespacePrefixToUri(String prefix) {
                return prefix;
            }
        });
        try {
            xpath.addNamespace("pre", "foo");
            fail("Added namespace");
        } catch (JaxenException ex) {
            assertNotNull(ex.getMessage());
        }
    }

    public void testDebug_BaseXPathTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        doc_BaseXPathTest = factory.newDocumentBuilder().newDocument();
        builder = factory.newDocumentBuilder();
        BaseXPath xpath = new DOMXPath("/b/c");
        assertEquals("[(DefaultXPath): [(DefaultAbsoluteLocationPath): [(DefaultNameStep): b]/[(DefaultNameStep): c]]]", xpath.debug());
    }

    public void testGetRootExpr_BaseXPathTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        doc_BaseXPathTest = factory.newDocumentBuilder().newDocument();
        builder = factory.newDocumentBuilder();
        BaseXPath xpath = new DOMXPath("/b/c");
        assertTrue(xpath.getRootExpr() instanceof org.jaxen.expr.LocationPath);
    }

    public void testUnionUsesDocumentOrder_BaseXPathTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        doc_BaseXPathTest = factory.newDocumentBuilder().newDocument();
        builder = factory.newDocumentBuilder();
        BaseXPath xpath = new DOMXPath("/descendant::x | /a | /a/b");
        org.w3c.dom.Element a = doc_BaseXPathTest.createElementNS("", "a");
        org.w3c.dom.Element b = doc_BaseXPathTest.createElementNS("", "b");
        doc_BaseXPathTest.appendChild(a);
        org.w3c.dom.Element x1 = doc_BaseXPathTest.createElementNS("", "x");
        x1.appendChild(doc_BaseXPathTest.createTextNode("1"));
        a.appendChild(x1);
        a.appendChild(b);
        org.w3c.dom.Element x2 = doc_BaseXPathTest.createElementNS("", "x");
        org.w3c.dom.Element x3 = doc_BaseXPathTest.createElementNS("", "x");
        org.w3c.dom.Element x4 = doc_BaseXPathTest.createElementNS("", "x");
        a.appendChild(x4);
        b.appendChild(x2);
        b.appendChild(x3);
        x2.appendChild(doc_BaseXPathTest.createTextNode("2"));
        x3.appendChild(doc_BaseXPathTest.createTextNode("3"));
        x4.appendChild(doc_BaseXPathTest.createTextNode("4"));
        List result = xpath.selectNodes(doc_BaseXPathTest);
        assertEquals(6, result.size());
        assertEquals(a, result.get(0));
        assertEquals(x1, result.get(1));
        assertEquals(b, result.get(2));
        assertEquals(x2, result.get(3));
        assertEquals(x3, result.get(4));
        assertEquals(x4, result.get(5));
    }

    public void testArithmeticAssociativity_BaseXPathTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        doc_BaseXPathTest = factory.newDocumentBuilder().newDocument();
        builder = factory.newDocumentBuilder();
        XPath xpath = new DOMXPath("2+1-1+1");
        Double result = (Double) xpath.evaluate(doc_BaseXPathTest);
        assertEquals(3, result.intValue());
    }

    public void testLogicalAssociativity_BaseXPathTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        doc_BaseXPathTest = factory.newDocumentBuilder().newDocument();
        builder = factory.newDocumentBuilder();
        XPath xpath = new DOMXPath("false() or true() and true() and false()");
        Boolean result = (Boolean) xpath.evaluate(doc_BaseXPathTest);
        assertFalse(result.booleanValue());
    }

    public void testRelationalAssociativity3_BaseXPathTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        doc_BaseXPathTest = factory.newDocumentBuilder().newDocument();
        builder = factory.newDocumentBuilder();
        XPath xpath = new DOMXPath("3 > 2 > 1");
        Boolean result = (Boolean) xpath.evaluate(doc_BaseXPathTest);
        assertFalse(result.booleanValue());
    }

    public void testRelationalAssociativity4_BaseXPathTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        doc_BaseXPathTest = factory.newDocumentBuilder().newDocument();
        builder = factory.newDocumentBuilder();
        XPath xpath = new DOMXPath("4 > 3 > 2 > 1");
        Boolean result = (Boolean) xpath.evaluate(doc_BaseXPathTest);
        assertFalse(result.booleanValue());
    }

    public void testRelationalGTAssociativity5_BaseXPathTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        doc_BaseXPathTest = factory.newDocumentBuilder().newDocument();
        builder = factory.newDocumentBuilder();
        XPath xpath = new DOMXPath("5 > 4 > 3 > 2 > 1");
        Boolean result = (Boolean) xpath.evaluate(doc_BaseXPathTest);
        assertFalse(result.booleanValue());
    }

    public void testRelationalLTAssociativity5_BaseXPathTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        doc_BaseXPathTest = factory.newDocumentBuilder().newDocument();
        builder = factory.newDocumentBuilder();
        XPath xpath = new DOMXPath("1 < 2 < 3 < 4 < 5");
        Boolean result = (Boolean) xpath.evaluate(doc_BaseXPathTest);
        assertTrue(result.booleanValue());
    }

    public void testRelationalLEAssociativity5_BaseXPathTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        doc_BaseXPathTest = factory.newDocumentBuilder().newDocument();
        builder = factory.newDocumentBuilder();
        XPath xpath = new DOMXPath("1 <= 2 <= 3 <= 4 <= 5");
        Boolean result = (Boolean) xpath.evaluate(doc_BaseXPathTest);
        assertTrue(result.booleanValue());
    }

    public void testRelationalGEAssociativity5_BaseXPathTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        doc_BaseXPathTest = factory.newDocumentBuilder().newDocument();
        builder = factory.newDocumentBuilder();
        XPath xpath = new DOMXPath("5 >= 4 >= 3 >= 2 >= 1");
        Boolean result = (Boolean) xpath.evaluate(doc_BaseXPathTest);
        assertFalse(result.booleanValue());
    }

    public void testRelationalGEAssociativity3_BaseXPathTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        doc_BaseXPathTest = factory.newDocumentBuilder().newDocument();
        builder = factory.newDocumentBuilder();
        XPath xpath = new DOMXPath("3 >= 2 >= 1");
        Boolean result = (Boolean) xpath.evaluate(doc_BaseXPathTest);
        assertTrue(result.booleanValue());
    }

    public void testRelationalGEAssociativity2_BaseXPathTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        doc_BaseXPathTest = factory.newDocumentBuilder().newDocument();
        builder = factory.newDocumentBuilder();
        XPath xpath = new DOMXPath("2 >= 1");
        Boolean result = (Boolean) xpath.evaluate(doc_BaseXPathTest);
        assertTrue(result.booleanValue());
    }

    public void testRelationalGEAssociativity4_BaseXPathTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        doc_BaseXPathTest = factory.newDocumentBuilder().newDocument();
        builder = factory.newDocumentBuilder();
        XPath xpath = new DOMXPath("4 >= 3 >= 2 >= 1");
        Boolean result = (Boolean) xpath.evaluate(doc_BaseXPathTest);
        assertFalse(result.booleanValue());
    }

    public void testRelationalAssociativity5P_BaseXPathTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        doc_BaseXPathTest = factory.newDocumentBuilder().newDocument();
        builder = factory.newDocumentBuilder();
        XPath xpath = new DOMXPath("((((5 > 4) > 3) > 2) > 1)");
        Boolean result = (Boolean) xpath.evaluate(doc_BaseXPathTest);
        assertFalse(result.booleanValue());
    }

    public void testInequalityAssociativity5_BaseXPathTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        doc_BaseXPathTest = factory.newDocumentBuilder().newDocument();
        builder = factory.newDocumentBuilder();
        XPath xpath = new DOMXPath("2 != 3 != 1 != 4 != 0");
        Boolean result = (Boolean) xpath.evaluate(doc_BaseXPathTest);
        assertTrue(result.booleanValue());
    }

    public void testInequalityAssociativity5P_BaseXPathTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        doc_BaseXPathTest = factory.newDocumentBuilder().newDocument();
        builder = factory.newDocumentBuilder();
        XPath xpath = new DOMXPath("(((2 != 3) != 1) != 4) != 0");
        Boolean result = (Boolean) xpath.evaluate(doc_BaseXPathTest);
        assertTrue(result.booleanValue());
    }

    public void testInequalityAssociativity5B_BaseXPathTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        doc_BaseXPathTest = factory.newDocumentBuilder().newDocument();
        builder = factory.newDocumentBuilder();
        XPath xpath = new DOMXPath("2 != 3 != 1 != 4 != 1");
        Boolean result = (Boolean) xpath.evaluate(doc_BaseXPathTest);
        assertFalse(result.booleanValue());
    }

    public void testInequalityAssociativity5BP_BaseXPathTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        doc_BaseXPathTest = factory.newDocumentBuilder().newDocument();
        builder = factory.newDocumentBuilder();
        XPath xpath = new DOMXPath("(((2 != 3) != 1) != 4) != 1");
        Boolean result = (Boolean) xpath.evaluate(doc_BaseXPathTest);
        assertFalse(result.booleanValue());
    }

    public void testEqualityAssociativity5_BaseXPathTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        doc_BaseXPathTest = factory.newDocumentBuilder().newDocument();
        builder = factory.newDocumentBuilder();
        XPath xpath = new DOMXPath("2 = 3 = 1 = 4 = 0");
        Boolean result = (Boolean) xpath.evaluate(doc_BaseXPathTest);
        assertTrue(result.booleanValue());
    }

    public void testEqualityAssociativity5P_BaseXPathTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        doc_BaseXPathTest = factory.newDocumentBuilder().newDocument();
        builder = factory.newDocumentBuilder();
        XPath xpath = new DOMXPath("(((2 = 3) = 1) = 4) = 0");
        Boolean result = (Boolean) xpath.evaluate(doc_BaseXPathTest);
        assertTrue(result.booleanValue());
    }

    public void testEqualityAssociativity5B_BaseXPathTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        doc_BaseXPathTest = factory.newDocumentBuilder().newDocument();
        builder = factory.newDocumentBuilder();
        XPath xpath = new DOMXPath("2 = 3 = 1 = 4 = 1");
        Boolean result = (Boolean) xpath.evaluate(doc_BaseXPathTest);
        assertFalse(result.booleanValue());
    }

    public void testEqualityAssociativity5BP_BaseXPathTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        doc_BaseXPathTest = factory.newDocumentBuilder().newDocument();
        builder = factory.newDocumentBuilder();
        XPath xpath = new DOMXPath("(((2 = 3) = 1) = 4) = 1");
        Boolean result = (Boolean) xpath.evaluate(doc_BaseXPathTest);
        assertFalse(result.booleanValue());
    }

    public void testMoreComplexArithmeticAssociativity_BaseXPathTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        doc_BaseXPathTest = factory.newDocumentBuilder().newDocument();
        builder = factory.newDocumentBuilder();
        XPath xpath = new DOMXPath("1+2+1-1+1");
        Double result = (Double) xpath.evaluate(doc_BaseXPathTest);
        assertEquals(4, result.intValue());
    }

    public void testMostComplexArithmeticAssociativity_BaseXPathTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        doc_BaseXPathTest = factory.newDocumentBuilder().newDocument();
        builder = factory.newDocumentBuilder();
        XPath xpath = new DOMXPath("1+1+2+1-1+1");
        Double result = (Double) xpath.evaluate(doc_BaseXPathTest);
        assertEquals(5, result.intValue());
    }

    public void testSimplerArithmeticAssociativity_BaseXPathTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        doc_BaseXPathTest = factory.newDocumentBuilder().newDocument();
        builder = factory.newDocumentBuilder();
        XPath xpath = new DOMXPath("1-1+1");
        Double result = (Double) xpath.evaluate(doc_BaseXPathTest);
        assertEquals(1, result.intValue());
    }

    public void testNamespaceNodesComeBeforeAttributeNodesInDocumentOrder_BaseXPathTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        doc_BaseXPathTest = factory.newDocumentBuilder().newDocument();
        builder = factory.newDocumentBuilder();
        org.w3c.dom.Element root = doc_BaseXPathTest.createElementNS("http://www.example.org", "pre:b");
        doc_BaseXPathTest.appendChild(root);
        root.setAttribute("name", "value");
        XPath xpath = new DOMXPath("/*/attribute::* | /*/namespace::node()");
        List result = xpath.selectNodes(doc_BaseXPathTest);
        assertTrue(((org.w3c.dom.Node) result.get(0)).getNodeType() == Pattern.NAMESPACE_NODE);
        assertTrue(((org.w3c.dom.Node) result.get(1)).getNodeType() == Pattern.NAMESPACE_NODE);
        assertTrue(((org.w3c.dom.Node) result.get(2)).getNodeType() == Node.ATTRIBUTE_NODE);
        xpath = new DOMXPath("/*/namespace::node() | /*/attribute::* ");
        result = xpath.selectNodes(doc_BaseXPathTest);
        assertTrue(((org.w3c.dom.Node) result.get(0)).getNodeType() == Pattern.NAMESPACE_NODE);
        assertTrue(((org.w3c.dom.Node) result.get(1)).getNodeType() == Pattern.NAMESPACE_NODE);
        assertTrue(((org.w3c.dom.Node) result.get(2)).getNodeType() == Node.ATTRIBUTE_NODE);
    }

    public void testJaxen97_BaseXPathTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        doc_BaseXPathTest = factory.newDocumentBuilder().newDocument();
        builder = factory.newDocumentBuilder();
        new DOMXPath("/aaa:element/text()");
    }

    public void testAttributeNodesOnParentComeBeforeNamespaceNodesInChildInDocumentOrder_BaseXPathTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        doc_BaseXPathTest = factory.newDocumentBuilder().newDocument();
        builder = factory.newDocumentBuilder();
        org.w3c.dom.Element root = doc_BaseXPathTest.createElement("root");
        doc_BaseXPathTest.appendChild(root);
        root.setAttribute("name", "value");
        Element child = doc_BaseXPathTest.createElementNS("http://www.example.org", "pre:child");
        root.appendChild(child);
        XPath xpath = new DOMXPath("/*/*/namespace::node() | //attribute::* ");
        List result = xpath.selectNodes(doc_BaseXPathTest);
        assertEquals(3, result.size());
        assertTrue(((org.w3c.dom.Node) result.get(0)).getNodeType() == Node.ATTRIBUTE_NODE);
        assertTrue(((org.w3c.dom.Node) result.get(1)).getNodeType() == Pattern.NAMESPACE_NODE);
    }

    public void testJaxen107_BaseXPathTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        doc_BaseXPathTest = factory.newDocumentBuilder().newDocument();
        builder = factory.newDocumentBuilder();
        org.w3c.dom.Element a = doc_BaseXPathTest.createElementNS("http://www.a.com/", "a:foo");
        doc_BaseXPathTest.appendChild(a);
        Element b = doc_BaseXPathTest.createElementNS("http://www.b.com/", "b:bar");
        a.appendChild(b);
        XPath xpath = new DOMXPath("/a:foo/b:bar/namespace::*/parent::*");
        SimpleNamespaceContext context1 = new SimpleNamespaceContext();
        context1.addNamespace("a", "http://www.a.com/");
        context1.addNamespace("b", "http://www.b.com/");
        xpath.setNamespaceContext(context1);
        List result = xpath.selectNodes(doc_BaseXPathTest);
        assertEquals(1, result.size());
        assertEquals(b, result.get(0));
    }

    public void testJaxen107FromFile_BaseXPathTest() throws JaxenException, SAXException, IOException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        doc_BaseXPathTest = factory.newDocumentBuilder().newDocument();
        builder = factory.newDocumentBuilder();
        doc_BaseXPathTest = builder.parse(new File("xml/testNamespaces.xml"));
        XPath xpath = new DOMXPath("/Template/Application2/namespace::*/parent::*");
        List result = xpath.selectNodes(doc_BaseXPathTest);
        assertEquals(1, result.size());
    }

    public void testSelectNodesReturnsANonNodeSet_BaseXPathTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        doc_BaseXPathTest = factory.newDocumentBuilder().newDocument();
        builder = factory.newDocumentBuilder();
        XPath xpath = new DOMXPath("1 + 2 + 3");
        List result = xpath.selectNodes(doc_BaseXPathTest);
        assertEquals(1, result.size());
    }

    public void testNonElementContextNode_BaseXPathTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        doc_BaseXPathTest = factory.newDocumentBuilder().newDocument();
        builder = factory.newDocumentBuilder();
        org.w3c.dom.Element a = doc_BaseXPathTest.createElementNS("http://www.a.com/", "a:foo");
        doc_BaseXPathTest.appendChild(a);
        org.w3c.dom.Text b = doc_BaseXPathTest.createTextNode("ready");
        a.appendChild(b);
        XPath xpath = new DOMXPath("..");
        List result = (List) xpath.evaluate(b);
        assertEquals(1, result.size());
        assertEquals(a, result.get(0));
    }

    public void testNonNodeContext_BaseXPathTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        doc_BaseXPathTest = factory.newDocumentBuilder().newDocument();
        builder = factory.newDocumentBuilder();
        org.w3c.dom.Element a = doc_BaseXPathTest.createElementNS("http://www.a.com/", "a:foo");
        doc_BaseXPathTest.appendChild(a);
        org.w3c.dom.Text b = doc_BaseXPathTest.createTextNode("ready");
        a.appendChild(b);
        XPath xpath = new DOMXPath("..");
        try {
            xpath.evaluate("String");
            fail("Allowed String as context");
        } catch (ClassCastException ex) {
        }
    }

    public void testIsSerializable_BaseXPathTest() throws JaxenException, IOException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        doc_BaseXPathTest = factory.newDocumentBuilder().newDocument();
        builder = factory.newDocumentBuilder();
        BaseXPath path = new BaseXPath("//foo", new DocumentNavigator());
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(out);
        oos.writeObject(path);
        oos.close();
        assertTrue(out.toByteArray().length > 0);
    }

    public void testMismatchedDepthsInContext_BaseXPathTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        doc_BaseXPathTest = factory.newDocumentBuilder().newDocument();
        builder = factory.newDocumentBuilder();
        XPath xpath = new DOMXPath("parent::*");
        org.w3c.dom.Element z = doc_BaseXPathTest.createElementNS("", "z");
        doc_BaseXPathTest.appendChild(z);
        org.w3c.dom.Element a = doc_BaseXPathTest.createElementNS("", "a");
        z.appendChild(a);
        org.w3c.dom.Element b = doc_BaseXPathTest.createElementNS("", "b");
        a.appendChild(b);
        org.w3c.dom.Element c = doc_BaseXPathTest.createElementNS("", "c");
        z.appendChild(c);
        List context = new ArrayList();
        context.add(b);
        context.add(c);
        List result = xpath.selectNodes(context);
        assertEquals(z, result.get(0));
    }

    public void testBooleanPrecedence_BinaryExprTest() throws JaxenException, ParserConfigurationException {
        DOMXPath xpath1 = new DOMXPath("false() and (false() or true())");
        Boolean result1 = (Boolean) xpath1.evaluate(null);
        assertFalse(result1.booleanValue());
        DOMXPath xpath2 = new DOMXPath("false() and false() or true()");
        Boolean result2 = (Boolean) xpath2.evaluate(null);
        assertTrue(result2.booleanValue());
        String expr = xpath1.getRootExpr().getText();
        DOMXPath xpath3 = new DOMXPath(expr);
        Boolean result3 = (Boolean) xpath3.evaluate(null);
        assertEquals(expr, result1, result3);
        assertFalse(expr, result3.booleanValue());
    }

    public void testNonEmptyNodeSetsAreTrue_BooleanTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc_BooleanTest = builder.newDocument();
        BaseXPath xpath = new DOMXPath("boolean(//x)");
        org.w3c.dom.Element a = doc_BooleanTest.createElementNS("", "a");
        org.w3c.dom.Element b = doc_BooleanTest.createElementNS("", "b");
        doc_BooleanTest.appendChild(a);
        a.appendChild(b);
        org.w3c.dom.Element x2 = doc_BooleanTest.createElementNS("", "x");
        org.w3c.dom.Element x3 = doc_BooleanTest.createElementNS("", "x");
        org.w3c.dom.Element x4 = doc_BooleanTest.createElementNS("", "x");
        a.appendChild(x4);
        b.appendChild(x2);
        b.appendChild(x3);
        x2.appendChild(doc_BooleanTest.createTextNode("false"));
        x3.appendChild(doc_BooleanTest.createTextNode("false"));
        x4.appendChild(doc_BooleanTest.createTextNode("false"));
        List result = xpath.selectNodes(doc_BooleanTest);
        assertEquals(1, result.size());
        assertEquals(Boolean.TRUE, result.get(0));
    }

    public void testEmptyNodeSetsAreFalse_BooleanTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc_BooleanTest = builder.newDocument();
        BaseXPath xpath = new DOMXPath("boolean(//y)");
        org.w3c.dom.Element a = doc_BooleanTest.createElementNS("", "a");
        org.w3c.dom.Element b = doc_BooleanTest.createElementNS("", "b");
        doc_BooleanTest.appendChild(a);
        a.appendChild(b);
        org.w3c.dom.Element x2 = doc_BooleanTest.createElementNS("", "x");
        org.w3c.dom.Element x3 = doc_BooleanTest.createElementNS("", "x");
        org.w3c.dom.Element x4 = doc_BooleanTest.createElementNS("", "x");
        a.appendChild(x4);
        b.appendChild(x2);
        b.appendChild(x3);
        x2.appendChild(doc_BooleanTest.createTextNode("false"));
        x3.appendChild(doc_BooleanTest.createTextNode("false"));
        x4.appendChild(doc_BooleanTest.createTextNode("false"));
        List result = xpath.selectNodes(doc_BooleanTest);
        assertEquals(1, result.size());
        assertEquals(Boolean.FALSE, result.get(0));
    }

    public void testZeroIsFalse_BooleanTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc_BooleanTest = builder.newDocument();
        BaseXPath xpath = new DOMXPath("boolean(0)");
        org.w3c.dom.Element a = doc_BooleanTest.createElementNS("", "a");
        List result = xpath.selectNodes(a);
        assertEquals(1, result.size());
        assertEquals(Boolean.FALSE, result.get(0));
    }

    public void testEmptyStringIsFalse_BooleanTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc_BooleanTest = builder.newDocument();
        BaseXPath xpath = new DOMXPath("boolean('')");
        org.w3c.dom.Element a = doc_BooleanTest.createElementNS("", "a");
        List result = xpath.selectNodes(a);
        assertEquals(1, result.size());
        assertEquals(Boolean.FALSE, result.get(0));
    }

    public void testNaNIsFalse_BooleanTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc_BooleanTest = builder.newDocument();
        BaseXPath xpath = new DOMXPath("boolean(0 div 0)");
        Object result = xpath.evaluate(null);
        assertEquals(Boolean.FALSE, result);
    }

    public void testNonEmptyStringIsTrue_BooleanTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc_BooleanTest = builder.newDocument();
        BaseXPath xpath = new DOMXPath("boolean('false')");
        org.w3c.dom.Element a = doc_BooleanTest.createElementNS("", "a");
        List result = xpath.selectNodes(a);
        assertEquals(1, result.size());
        assertEquals(Boolean.TRUE, result.get(0));
    }

    public void testBooleanFunctionRequiresOneArgument_BooleanTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc_BooleanTest = builder.newDocument();
        BaseXPath xpath = new DOMXPath("boolean()");
        org.w3c.dom.Element a = doc_BooleanTest.createElementNS("", "a");
        try {
            xpath.selectNodes(a);
            fail("Allowed boolean function with no arguments");
        } catch (FunctionCallException ex) {
            assertNotNull(ex.getMessage());
        }
    }

    public void testBooleanFunctionRequiresExactlyOneArgument_BooleanTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc_BooleanTest = builder.newDocument();
        BaseXPath xpath = new DOMXPath("boolean('', '')");
        org.w3c.dom.Element a = doc_BooleanTest.createElementNS("", "a");
        try {
            xpath.selectNodes(a);
            fail("Allowed boolean function with two arguments");
        } catch (FunctionCallException ex) {
            assertNotNull(ex.getMessage());
        }
    }

    public void testCeiling_CeilingTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc_CeilingTest = builder.newDocument();
        org.w3c.dom.Element a = doc_CeilingTest.createElementNS("", "a");
        doc_CeilingTest.appendChild(a);
        BaseXPath xpath = new DOMXPath("ceiling(1.5)");
        Object result = xpath.evaluate(doc_CeilingTest);
        assertEquals(2, ((Double) result).doubleValue(), 0.0001);
    }

    public void testNegativeCeiling_CeilingTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc_CeilingTest = builder.newDocument();
        org.w3c.dom.Element a = doc_CeilingTest.createElementNS("", "a");
        doc_CeilingTest.appendChild(a);
        BaseXPath xpath = new DOMXPath("ceiling(-1.5)");
        Object result = xpath.evaluate(doc_CeilingTest);
        assertEquals(-1, ((Double) result).doubleValue(), 0.0001);
    }

    public void testNaNCeilingIsNaN_CeilingTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc_CeilingTest = builder.newDocument();
        org.w3c.dom.Element a = doc_CeilingTest.createElementNS("", "a");
        doc_CeilingTest.appendChild(a);
        BaseXPath xpath = new DOMXPath("ceiling(1.0 div 0.0 - 2.0 div 0.0)");
        double result = ((Double) xpath.evaluate(doc_CeilingTest)).doubleValue();
        assertTrue(Double.isNaN(result));
    }

    public void testCeilingFunctionRequiresAtLeastOneArgument_CeilingTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc_CeilingTest = builder.newDocument();
        org.w3c.dom.Element a = doc_CeilingTest.createElementNS("", "a");
        doc_CeilingTest.appendChild(a);
        BaseXPath xpath = new DOMXPath("ceiling()");
        try {
            xpath.selectNodes(doc_CeilingTest);
            fail("Allowed ceiling function with no arguments");
        } catch (FunctionCallException ex) {
            assertNotNull(ex.getMessage());
        }
    }

    public void testCeilingFunctionRequiresAtMostOneArgument_CeilingTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc_CeilingTest = builder.newDocument();
        org.w3c.dom.Element a = doc_CeilingTest.createElementNS("", "a");
        doc_CeilingTest.appendChild(a);
        BaseXPath xpath = new DOMXPath("ceiling(2.2, 1.2)");
        try {
            xpath.selectNodes(doc_CeilingTest);
            fail("Allowed ceiling function with two arguments");
        } catch (FunctionCallException ex) {
            assertNotNull(ex.getMessage());
        }
    }

    public void testConcatFunctionRequiresAtLeastTwoArguments_ConcatTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc_ConcatTest = builder.newDocument();
        doc_ConcatTest.appendChild(doc_ConcatTest.createElement("root"));
        BaseXPath xpath = new DOMXPath("concat('a')");
        try {
            xpath.selectNodes(doc_ConcatTest);
            fail("Allowed concat function with one argument");
        } catch (FunctionCallException ex) {
            assertNotNull(ex.getMessage());
        }
    }

    public void testContainsNumber_ContainsTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc_ContainsTest = builder.newDocument();
        doc_ContainsTest.appendChild(doc_ContainsTest.createElement("root"));
        XPath xpath = new DOMXPath("contains(33, '3')");
        Boolean result = (Boolean) xpath.evaluate(doc_ContainsTest);
        assertEquals(Boolean.TRUE, result);
    }

    public void testContainsString_ContainsTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc_ContainsTest = builder.newDocument();
        doc_ContainsTest.appendChild(doc_ContainsTest.createElement("root"));
        XPath xpath = new DOMXPath("contains('test', 'es')");
        Boolean result = (Boolean) xpath.evaluate(doc_ContainsTest);
        assertEquals(Boolean.TRUE, result);
    }

    public void testContainsString3_ContainsTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc_ContainsTest = builder.newDocument();
        doc_ContainsTest.appendChild(doc_ContainsTest.createElement("root"));
        XPath xpath = new DOMXPath("contains('superlative', 'superlative')");
        Boolean result = (Boolean) xpath.evaluate(doc_ContainsTest);
        assertEquals(Boolean.TRUE, result);
    }

    public void testContainsNumber2_ContainsTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc_ContainsTest = builder.newDocument();
        doc_ContainsTest.appendChild(doc_ContainsTest.createElement("root"));
        XPath xpath = new DOMXPath("contains(43, '0')");
        Boolean result = (Boolean) xpath.evaluate(doc_ContainsTest);
        assertEquals(Boolean.FALSE, result);
    }

    public void testContainsString2_ContainsTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc_ContainsTest = builder.newDocument();
        doc_ContainsTest.appendChild(doc_ContainsTest.createElement("root"));
        XPath xpath = new DOMXPath("contains('1234567890', '1234567a')");
        Boolean result = (Boolean) xpath.evaluate(doc_ContainsTest);
        assertEquals(Boolean.FALSE, result);
    }

    public void testEmptyStringContainsNonEmptyString_ContainsTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc_ContainsTest = builder.newDocument();
        doc_ContainsTest.appendChild(doc_ContainsTest.createElement("root"));
        XPath xpath = new DOMXPath("contains('', 'a')");
        Boolean result = (Boolean) xpath.evaluate(doc_ContainsTest);
        assertEquals(Boolean.FALSE, result);
    }

    public void testEmptyStringContainsEmptyString_ContainsTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc_ContainsTest = builder.newDocument();
        doc_ContainsTest.appendChild(doc_ContainsTest.createElement("root"));
        XPath xpath = new DOMXPath("contains('', '')");
        Boolean result = (Boolean) xpath.evaluate(doc_ContainsTest);
        assertEquals(Boolean.TRUE, result);
    }

    public void testContainsEmptyString_ContainsTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc_ContainsTest = builder.newDocument();
        doc_ContainsTest.appendChild(doc_ContainsTest.createElement("root"));
        XPath xpath = new DOMXPath("contains('a', '')");
        Boolean result = (Boolean) xpath.evaluate(doc_ContainsTest);
        assertEquals(Boolean.TRUE, result);
    }

    public void testContainsFunctionRequiresAtLeastTwoArguments_ContainsTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc_ContainsTest = builder.newDocument();
        doc_ContainsTest.appendChild(doc_ContainsTest.createElement("root"));
        BaseXPath xpath = new DOMXPath("contains('a')");
        try {
            xpath.selectNodes(doc_ContainsTest);
            fail("Allowed contains function with one argument");
        } catch (FunctionCallException ex) {
            assertNotNull(ex.getMessage());
        }
    }

    public void testContainsFunctionRequiresAtMostTwoArguments_ContainsTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc_ContainsTest = builder.newDocument();
        doc_ContainsTest.appendChild(doc_ContainsTest.createElement("root"));
        BaseXPath xpath = new DOMXPath("contains('a', 'a', 'a')");
        try {
            xpath.selectNodes(doc_ContainsTest);
            fail("Allowed contains function with three arguments");
        } catch (FunctionCallException ex) {
            assertNotNull(ex.getMessage());
        }
    }

    public void testSetNodeSet_ContextTest() {
        this.nodeSet_ContextTest = new ArrayList();
        this.nodeSet_ContextTest.add("one");
        this.nodeSet_ContextTest.add("two");
        this.nodeSet_ContextTest.add("three");
        this.nodeSet_ContextTest.add("four");
        this.support_ContextTest = new ContextSupport();
        Context original = new Context(this.support_ContextTest);
        assertEquals(0, original.getNodeSet().size());
        original.setNodeSet(this.nodeSet_ContextTest);
        assertEquals(4, original.getNodeSet().size());
        this.nodeSet_ContextTest = null;
    }

    public void testShrinkNodeSet_ContextTest() {
        this.nodeSet_ContextTest = new ArrayList();
        this.nodeSet_ContextTest.add("one");
        this.nodeSet_ContextTest.add("two");
        this.nodeSet_ContextTest.add("three");
        this.nodeSet_ContextTest.add("four");
        this.support_ContextTest = new ContextSupport();
        Context original = new Context(this.support_ContextTest);
        original.setNodeSet(this.nodeSet_ContextTest);
        original.setPosition(3);
        ArrayList list = new ArrayList();
        list.add("1");
        list.add("2");
        list.add("3");
        original.setNodeSet(list);
        assertEquals(0, original.getPosition());
        this.nodeSet_ContextTest = null;
    }

    public void testDuplicate_ContextTest() {
        this.nodeSet_ContextTest = new ArrayList();
        this.nodeSet_ContextTest.add("one");
        this.nodeSet_ContextTest.add("two");
        this.nodeSet_ContextTest.add("three");
        this.nodeSet_ContextTest.add("four");
        this.support_ContextTest = new ContextSupport();
        Context original = new Context(this.support_ContextTest);
        original.setNodeSet(this.nodeSet_ContextTest);
        original.setSize(4);
        original.setPosition(2);
        Context dupe = original.duplicate();
        assertEquals(2, dupe.getPosition());
        assertEquals(4, dupe.getSize());
        assertTrue(original != dupe);
        List dupeNodeSet = dupe.getNodeSet();
        assertTrue(original.getNodeSet() != dupe.getNodeSet());
        dupeNodeSet.clear();
        assertSame(dupeNodeSet, dupe.getNodeSet());
        assertEquals(0, dupe.getNodeSet().size());
        assertEquals(4, original.getNodeSet().size());
        dupe.setSize(0);
        dupe.setPosition(0);
        assertEquals(0, dupe.getSize());
        assertEquals(0, dupe.getPosition());
        assertEquals(4, original.getSize());
        assertEquals(2, original.getPosition());
        this.nodeSet_ContextTest = null;
    }

    public void testXMLPrefixIsAlwaysBound_ContextTest() throws ParserConfigurationException, SAXException, IOException, JaxenException {
        this.nodeSet_ContextTest = new ArrayList();
        this.nodeSet_ContextTest.add("one");
        this.nodeSet_ContextTest.add("two");
        this.nodeSet_ContextTest.add("three");
        this.nodeSet_ContextTest.add("four");
        this.support_ContextTest = new ContextSupport();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        org.w3c.dom.Document doc = builder.parse("xml/basic.xml");
        Element root = doc.getDocumentElement();
        root.setAttributeNS("http://www.w3.org/XML/1998/namespace", "xml:lang", "en");
        XPath xpath = new DOMXPath("/*/@xml:lang");
        List result = xpath.selectNodes(doc);
        assertEquals(1, result.size());
        this.nodeSet_ContextTest = null;
    }

    public void testIsSerializable_ContextTest() throws IOException {
        this.nodeSet_ContextTest = new ArrayList();
        this.nodeSet_ContextTest.add("one");
        this.nodeSet_ContextTest.add("two");
        this.nodeSet_ContextTest.add("three");
        this.nodeSet_ContextTest.add("four");
        this.support_ContextTest = new ContextSupport();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(out);
        oos.writeObject(support_ContextTest);
        oos.close();
        assertTrue(out.toByteArray().length > 0);
        this.nodeSet_ContextTest = null;
    }

    public void testCount3_CountTest() throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc_CountTest = builder.parse("xml/basic.xml");
        try {
            XPath xpath = new DOMXPath("count(3)");
            xpath.selectNodes(doc_CountTest);
            fail("Allowed count of number");
        } catch (FunctionCallException e) {
            assertEquals("count() function can only be used for node-sets", e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            fail(e.getMessage());
        }
    }

    public void testCountFunctionRequiresAtLeastOneArgument_CountTest() throws JaxenException, ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc_CountTest = builder.parse("xml/basic.xml");
        BaseXPath xpath = new DOMXPath("count()");
        try {
            xpath.selectNodes(doc_CountTest);
            fail("Allowed count function with no arguments");
        } catch (FunctionCallException ex) {
            assertNotNull(ex.getMessage());
        }
    }

    public void testCountFunctionRequiresAtMostOneArgument_CountTest() throws JaxenException, ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc_CountTest = builder.parse("xml/basic.xml");
        BaseXPath xpath = new DOMXPath("count(/*, /@*)");
        try {
            xpath.selectNodes(doc_CountTest);
            fail("Allowed count function with two arguments");
        } catch (FunctionCallException ex) {
            assertNotNull(ex.getMessage());
        }
    }

    public void testCountRootElement_CountTest() throws JaxenException, ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc_CountTest = builder.parse("xml/basic.xml");
        BaseXPath xpath = new DOMXPath("count(/*)");
        Double result = (Double) xpath.evaluate(doc_CountTest);
        assertEquals(1.0, result.doubleValue(), 0.00001);
    }

    public void testIdentitySetUsageInDefaultNameStep_DefaultNamestepTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc_DefaultNamestepTest = builder.newDocument();
        XPath xpath = new DOMXPath("/a/x/preceding-sibling::x[last()]");
        org.w3c.dom.Element a = doc_DefaultNamestepTest.createElementNS("", "a");
        doc_DefaultNamestepTest.appendChild(a);
        org.w3c.dom.Element x1 = doc_DefaultNamestepTest.createElementNS("", "x");
        org.w3c.dom.Element x2 = doc_DefaultNamestepTest.createElementNS("", "x");
        org.w3c.dom.Element x3 = doc_DefaultNamestepTest.createElementNS("", "x");
        org.w3c.dom.Element x4 = doc_DefaultNamestepTest.createElementNS("", "x");
        org.w3c.dom.Element x5 = doc_DefaultNamestepTest.createElementNS("", "x");
        a.appendChild(x1);
        a.appendChild(x2);
        a.appendChild(x3);
        a.appendChild(x4);
        a.appendChild(x5);
        x1.appendChild(doc_DefaultNamestepTest.createTextNode("1"));
        x2.appendChild(doc_DefaultNamestepTest.createTextNode("2"));
        x3.appendChild(doc_DefaultNamestepTest.createTextNode("3"));
        x4.appendChild(doc_DefaultNamestepTest.createTextNode("4"));
        x5.appendChild(doc_DefaultNamestepTest.createTextNode("5"));
        List result = xpath.selectNodes(doc_DefaultNamestepTest);
        assertEquals(1, result.size());
        assertEquals(x1, result.get(0));
    }

    public void testJAXEN40_DefaultXPathExprTest() throws JaxenException, ParserConfigurationException {
        DOMXPath xpath = new DOMXPath("root/child1/grandchild1 | root/child2/grandchild2");
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        org.w3c.dom.Document doc = factory.newDocumentBuilder().newDocument();
        Element root = doc.createElement("root");
        Element child1 = doc.createElement("child1");
        Element child2 = doc.createElement("child2");
        Element grandchild1 = doc.createElement("grandchild1");
        Element grandchild2 = doc.createElement("grandchild2");
        root.appendChild(child1);
        root.appendChild(child2);
        child1.appendChild(grandchild1);
        child2.appendChild(grandchild2);
        doc.appendChild(root);
        List results = xpath.selectNodes(doc);
        assertEquals(2, results.size());
        assertTrue(results.indexOf(grandchild1) >= 0);
        assertTrue(results.indexOf(grandchild2) >= 0);
    }

    public void testJAXEN160GetText_DefaultXPathExprTest() throws JaxenException, ParserConfigurationException {
        DOMXPath xpath = new DOMXPath("$var1/foo");
        Expr expr = xpath.getRootExpr();
        assertEquals("$var1/child::foo", expr.getText());
    }

    public void testJAXEN160ToString_DefaultXPathExprTest() throws JaxenException, ParserConfigurationException {
        DOMXPath xpath = new DOMXPath("$var1/foo");
        Expr expr = xpath.getRootExpr();
        assertEquals("[(DefaultPathExpr): [(DefaultVariableReferenceExpr): var1], [(DefaultRelativeLocationPath): [(DefaultNameStep): foo]]]", expr.toString());
    }

    public void testBadAxis_DefaultXPathFactoryTest() throws JaxenException {
        DefaultXPathFactory factory = new DefaultXPathFactory();
        try {
            factory.createAllNodeStep(123434);
            fail("Allowed bad axis");
        } catch (JaxenException ex) {
            assertNotNull(ex.getMessage());
        }
    }

    public void testNoInfiniteLoops_DescendantAxisIteratorTest() throws ParserConfigurationException, UnsupportedAxisException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        org.w3c.dom.Document doc = factory.newDocumentBuilder().newDocument();
        doc.appendChild(doc.createElement("root"));
        iterator_DescendantAxisIteratorTest = new DescendantAxisIterator(doc, new org.jaxen.dom.DocumentNavigator());
        iterator_DescendantAxisIteratorTest.next();
        try {
            iterator_DescendantAxisIteratorTest.next();
            fail("Iterated too far");
        } catch (NoSuchElementException ex) {
        }
    }

    public void testRemove_DescendantAxisIteratorTest() throws ParserConfigurationException, UnsupportedAxisException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        org.w3c.dom.Document doc = factory.newDocumentBuilder().newDocument();
        doc.appendChild(doc.createElement("root"));
        iterator_DescendantAxisIteratorTest = new DescendantAxisIterator(doc, new org.jaxen.dom.DocumentNavigator());
        try {
            iterator_DescendantAxisIteratorTest.remove();
            fail("Removed from descendant axis iterator");
        } catch (UnsupportedOperationException ex) {
        }
    }

    public void testGetTextContent_DOM3NamespaceTest() throws ParserConfigurationException, JaxenException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        org.w3c.dom.Document doc = factory.newDocumentBuilder().newDocument();
        org.w3c.dom.Element root = doc.createElementNS("http://www.root.com/", "root");
        doc.appendChild(root);
        Attr a = doc.createAttributeNS("http://www.example.org/", "pre:a");
        a.setNodeValue("value");
        root.setAttributeNode(a);
        XPath xpath = new DOMXPath("namespace::node()");
        List result = xpath.selectNodes(root);
        Iterator iterator = result.iterator();
        while (iterator.hasNext()) {
            NamespaceNode node = (NamespaceNode) iterator.next();
            if (node.getLocalName() == null) rootNS = node; else if (node.getLocalName().equals("xml")) xmlNS = node; else if (node.getLocalName().equals("pre")) attributeNS = node;
        }
        assertEquals("http://www.w3.org/XML/1998/namespace", xmlNS.getTextContent());
    }

    public void testSetTextContent_DOM3NamespaceTest() throws ParserConfigurationException, JaxenException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        org.w3c.dom.Document doc = factory.newDocumentBuilder().newDocument();
        org.w3c.dom.Element root = doc.createElementNS("http://www.root.com/", "root");
        doc.appendChild(root);
        Attr a = doc.createAttributeNS("http://www.example.org/", "pre:a");
        a.setNodeValue("value");
        root.setAttributeNode(a);
        XPath xpath = new DOMXPath("namespace::node()");
        List result = xpath.selectNodes(root);
        Iterator iterator = result.iterator();
        while (iterator.hasNext()) {
            NamespaceNode node = (NamespaceNode) iterator.next();
            if (node.getLocalName() == null) rootNS = node; else if (node.getLocalName().equals("xml")) xmlNS = node; else if (node.getLocalName().equals("pre")) attributeNS = node;
        }
        try {
            rootNS.setTextContent("http://www.a.com");
            fail("set text content");
        } catch (DOMException ex) {
            assertEquals(DOMException.NO_MODIFICATION_ALLOWED_ERR, ex.code);
        }
    }

    public void testGetFeature_DOM3NamespaceTest() throws ParserConfigurationException, JaxenException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        org.w3c.dom.Document doc = factory.newDocumentBuilder().newDocument();
        org.w3c.dom.Element root = doc.createElementNS("http://www.root.com/", "root");
        doc.appendChild(root);
        Attr a = doc.createAttributeNS("http://www.example.org/", "pre:a");
        a.setNodeValue("value");
        root.setAttributeNode(a);
        XPath xpath = new DOMXPath("namespace::node()");
        List result = xpath.selectNodes(root);
        Iterator iterator = result.iterator();
        while (iterator.hasNext()) {
            NamespaceNode node = (NamespaceNode) iterator.next();
            if (node.getLocalName() == null) rootNS = node; else if (node.getLocalName().equals("xml")) xmlNS = node; else if (node.getLocalName().equals("pre")) attributeNS = node;
        }
        assertNull(attributeNS.getFeature("name", "value"));
    }

    public void testIsEqualNode_DOM3NamespaceTest() throws ParserConfigurationException, JaxenException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        org.w3c.dom.Document doc = factory.newDocumentBuilder().newDocument();
        org.w3c.dom.Element root = doc.createElementNS("http://www.root.com/", "root");
        doc.appendChild(root);
        Attr a = doc.createAttributeNS("http://www.example.org/", "pre:a");
        a.setNodeValue("value");
        root.setAttributeNode(a);
        XPath xpath = new DOMXPath("namespace::node()");
        List result = xpath.selectNodes(root);
        Iterator iterator = result.iterator();
        while (iterator.hasNext()) {
            NamespaceNode node = (NamespaceNode) iterator.next();
            if (node.getLocalName() == null) rootNS = node; else if (node.getLocalName().equals("xml")) xmlNS = node; else if (node.getLocalName().equals("pre")) attributeNS = node;
        }
        assertFalse(rootNS.isEqualNode(xmlNS));
        assertTrue(rootNS.isEqualNode(rootNS));
    }

    public void testIsSameNode_DOM3NamespaceTest() throws ParserConfigurationException, JaxenException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        org.w3c.dom.Document doc = factory.newDocumentBuilder().newDocument();
        org.w3c.dom.Element root = doc.createElementNS("http://www.root.com/", "root");
        doc.appendChild(root);
        Attr a = doc.createAttributeNS("http://www.example.org/", "pre:a");
        a.setNodeValue("value");
        root.setAttributeNode(a);
        XPath xpath = new DOMXPath("namespace::node()");
        List result = xpath.selectNodes(root);
        Iterator iterator = result.iterator();
        while (iterator.hasNext()) {
            NamespaceNode node = (NamespaceNode) iterator.next();
            if (node.getLocalName() == null) rootNS = node; else if (node.getLocalName().equals("xml")) xmlNS = node; else if (node.getLocalName().equals("pre")) attributeNS = node;
        }
        assertFalse(rootNS.isSameNode(xmlNS));
        assertTrue(rootNS.isSameNode(rootNS));
    }

    public Navigator getNavigator_DOM4JNavigatorTest() {
        return new DocumentNavigator();
    }

    public Object getDocument_DOM4JNavigatorTest(String url) throws Exception {
        return reader_DOM4JNavigatorTest.read(url);
    }

    /**
     * reported as JAXEN-104.
     * @throws FunctionCallException
     * @throws UnsupportedAxisException
     */
    public void testConcurrentModification_DOM4JNavigatorTest() throws FunctionCallException, UnsupportedAxisException {
        this.reader_DOM4JNavigatorTest = new SAXReader();
        this.reader_DOM4JNavigatorTest.setMergeAdjacentText(true);
        Navigator nav = new DocumentNavigator();
        Object document = nav.getDocument("xml/testNamespaces.xml");
        Iterator descendantOrSelfAxisIterator = nav.getDescendantOrSelfAxisIterator(document);
        while (descendantOrSelfAxisIterator.hasNext()) {
            Object node = descendantOrSelfAxisIterator.next();
            Iterator namespaceAxisIterator = nav.getNamespaceAxisIterator(node);
            while (namespaceAxisIterator.hasNext()) {
                namespaceAxisIterator.next();
            }
        }
    }

    public void testNullPointerException_DOM4JNavigatorTest() throws JaxenException {
        org.dom4j.Document doc = DocumentHelper.createDocument();
        XPath xpath = new Dom4jXPath("/foo");
        xpath.selectSingleNode(doc);
    }

    public void testConstruction_DOM4JXPathTest() throws JaxenException {
        System.setProperty(XPathReaderFactory.DRIVER_PROPERTY, "");
        new Dom4jXPath("/foo/bar/baz");
    }

    public void testSelection_DOM4JXPathTest() throws JaxenException, DocumentException {
        System.setProperty(XPathReaderFactory.DRIVER_PROPERTY, "");
        XPath xpath = new Dom4jXPath("/foo/bar/baz");
        SAXReader reader = new SAXReader();
        org.dom4j.Document doc = reader.read(BASIC_XML_DOM4JXPathTest);
        List results = xpath.selectNodes(doc);
        assertEquals(3, results.size());
        Iterator iter = results.iterator();
        assertEquals("baz", ((org.dom4j.Element) iter.next()).getName());
        assertEquals("baz", ((org.dom4j.Element) iter.next()).getName());
        assertEquals("baz", ((org.dom4j.Element) iter.next()).getName());
        assertTrue(!iter.hasNext());
    }

    public void testAsBoolean_DOM4JXPathTest() throws JaxenException, DocumentException {
        System.setProperty(XPathReaderFactory.DRIVER_PROPERTY, "");
        XPath xpath = new Dom4jXPath("/root/a = 'a'");
        SAXReader reader = new SAXReader();
        org.dom4j.Document doc = reader.read("xml/simple.xml");
        boolean answer = xpath.booleanValueOf(doc);
        assertTrue("Xpath worked: " + xpath, answer);
        xpath = new Dom4jXPath("'a' = 'b'");
        answer = xpath.booleanValueOf(doc);
        assertTrue("XPath should return false: " + xpath, !answer);
    }

    public void testJaxen20AttributeNamespaceNodes_DOM4JXPathTest() throws JaxenException {
        System.setProperty(XPathReaderFactory.DRIVER_PROPERTY, "");
        org.dom4j.Namespace ns1 = org.dom4j.Namespace.get("p1", "www.acme1.org");
        org.dom4j.Namespace ns2 = org.dom4j.Namespace.get("p2", "www.acme2.org");
        DefaultElement element = new DefaultElement("test", ns1);
        DefaultAttribute attribute = new DefaultAttribute("pre:foo", "bar", ns2);
        element.add(attribute);
        DefaultDocument doc = new DefaultDocument(element);
        XPath xpath = new Dom4jXPath("//namespace::node()");
        List results = xpath.selectNodes(doc);
        assertEquals(3, results.size());
    }

    public void testJaxen16_DOM4JXPathTest() throws JaxenException, DocumentException {
        System.setProperty(XPathReaderFactory.DRIVER_PROPERTY, "");
        String document = "<a xmlns:b=\"...\"/>";
        SAXReader reader = new SAXReader();
        org.dom4j.Document doc = reader.read(new StringReader(document));
        XPath xpath = new Dom4jXPath("/a/b");
        List results = xpath.selectNodes(doc);
        assertEquals(0, results.size());
    }

    public void testNamespaceNodesAreInherited_DOM4JXPathTest() throws JaxenException {
        System.setProperty(XPathReaderFactory.DRIVER_PROPERTY, "");
        org.dom4j.Namespace ns0 = org.dom4j.Namespace.get("p0", "www.acme0.org");
        org.dom4j.Namespace ns1 = org.dom4j.Namespace.get("p1", "www.acme1.org");
        org.dom4j.Namespace ns2 = org.dom4j.Namespace.get("p2", "www.acme2.org");
        DefaultElement element = new DefaultElement("test", ns1);
        DefaultAttribute attribute = new DefaultAttribute("pre:foo", "bar", ns2);
        element.add(attribute);
        DefaultElement root = new DefaultElement("root", ns0);
        root.add(element);
        DefaultDocument doc = new DefaultDocument(root);
        XPath xpath = new Dom4jXPath("/*/*/namespace::node()");
        List results = xpath.selectNodes(doc);
        assertEquals(4, results.size());
    }

    public void testSyntaxException_DOM4JXPathTest() throws JaxenException {
        System.setProperty(XPathReaderFactory.DRIVER_PROPERTY, "");
        String path = "/row/[some_node='val1']|[some_node='val2']";
        try {
            new Dom4jXPath(path);
            fail("Allowed union of non-node-sets");
        } catch (XPathSyntaxException success) {
            assertNotNull(success.getMessage());
        }
    }

    public Navigator getNavigator_DOMNavigatorTest() throws Exception {
        super.setUp();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        builder_DOMNavigatorTest = factory.newDocumentBuilder();
        return new DocumentNavigator();
    }

    public Object getDocument_DOMNavigatorTest(String url) throws Exception, Exception {
        super.setUp();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        builder_DOMNavigatorTest = factory.newDocumentBuilder();
        return builder_DOMNavigatorTest.parse(url);
    }

    public void testGetAttributeQNameOnElement_DOMNavigatorTest() throws Exception {
        super.setUp();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        builder_DOMNavigatorTest = factory.newDocumentBuilder();
        Navigator nav = getNavigator_DOMNavigatorTest();
        org.w3c.dom.Document doc = builder_DOMNavigatorTest.newDocument();
        Element a = doc.createElement("a");
        String qname = nav.getAttributeQName(a);
        assertNull(qname);
    }

    public void testGetElementQNameOnAttr_DOMNavigatorTest() throws Exception {
        super.setUp();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        builder_DOMNavigatorTest = factory.newDocumentBuilder();
        Navigator nav = getNavigator_JDOMNavigatorTest();
        org.w3c.dom.Document doc = builder_DOMNavigatorTest.newDocument();
        Attr a = doc.createAttribute("a");
        String qname = nav.getElementQName(a);
        assertNull(qname);
    }

    public void testGetAttributeLocalNameOnElement_DOMNavigatorTest() throws Exception {
        super.setUp();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        builder_DOMNavigatorTest = factory.newDocumentBuilder();
        Navigator nav = getNavigator_JDOMNavigatorTest();
        org.w3c.dom.Document doc = builder_DOMNavigatorTest.newDocument();
        Element a = doc.createElementNS("http://www.ex.com", "pre:a");
        String name = nav.getAttributeName(a);
        assertNull(name);
    }

    public void testGetElementLocalNameOnAttr_DOMNavigatorTest() throws Exception {
        super.setUp();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        builder_DOMNavigatorTest = factory.newDocumentBuilder();
        Navigator nav = getNavigator_JDOMNavigatorTest();
        org.w3c.dom.Document doc = builder_DOMNavigatorTest.newDocument();
        Attr a = doc.createAttributeNS("http://www.ex.com", "a");
        String name = nav.getElementName(a);
        assertNull(name);
    }

    public void testGetAttributeNamespaceURIOnElement_DOMNavigatorTest() throws Exception {
        super.setUp();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        builder_DOMNavigatorTest = factory.newDocumentBuilder();
        Navigator nav = getNavigator_JDOMNavigatorTest();
        org.w3c.dom.Document doc = builder_DOMNavigatorTest.newDocument();
        Element a = doc.createElementNS("http://www.example.org/", "a");
        String qname = nav.getAttributeNamespaceUri(a);
        assertNull(qname);
    }

    public void testGetElementNamespaceURIOnAttr_DOMNavigatorTest() throws Exception {
        super.setUp();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        builder_DOMNavigatorTest = factory.newDocumentBuilder();
        Navigator nav = getNavigator_JDOMNavigatorTest();
        org.w3c.dom.Document doc = builder_DOMNavigatorTest.newDocument();
        Attr a = doc.createAttributeNS("http://www.element.org/", "a");
        String qname = nav.getElementNamespaceUri(a);
        assertNull(qname);
    }

    public void testGetTargetOfNonPI_DOMNavigatorTest() throws Exception {
        super.setUp();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        builder_DOMNavigatorTest = factory.newDocumentBuilder();
        Navigator nav = getNavigator_JDOMNavigatorTest();
        org.w3c.dom.Document doc = builder_DOMNavigatorTest.newDocument();
        Attr a = doc.createAttributeNS("http://www.element.org/", "a");
        try {
            nav.getProcessingInstructionTarget(a);
            fail("got target of non processing instruction");
        } catch (ClassCastException ex) {
            assertNotNull(ex.getMessage());
        }
    }

    public void testGetDataOfNonPI_DOMNavigatorTest() throws Exception {
        super.setUp();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        builder_DOMNavigatorTest = factory.newDocumentBuilder();
        Navigator nav = getNavigator_JDOMNavigatorTest();
        org.w3c.dom.Document doc = builder_DOMNavigatorTest.newDocument();
        Attr a = doc.createAttributeNS("http://www.element.org/", "a");
        try {
            nav.getProcessingInstructionData(a);
            fail("got data of non processing instruction");
        } catch (ClassCastException ex) {
            assertNotNull(ex.getMessage());
        }
    }

    public void testConstruction_DOMXPathTest() throws JaxenException, ParserConfigurationException {
        factory_DOMXPathTest = DocumentBuilderFactory.newInstance();
        factory_DOMXPathTest.setNamespaceAware(true);
        doc_DOMXPathTest = factory_DOMXPathTest.newDocumentBuilder().newDocument();
        DOMXPath xpath = new DOMXPath("/foo/bar/baz");
        assertEquals("/foo/bar/baz", xpath.toString());
    }

    public void testJaxen193_DOMXPathTest() throws JaxenException, ParserConfigurationException {
        factory_DOMXPathTest = DocumentBuilderFactory.newInstance();
        factory_DOMXPathTest.setNamespaceAware(true);
        doc_DOMXPathTest = factory_DOMXPathTest.newDocumentBuilder().newDocument();
        DOMXPath xpath = new DOMXPath("/*[ * or processing-instruction() ]");
        assertEquals("/*[ * or processing-instruction() ]", xpath.toString());
    }

    public void testJaxen193InReverse_DOMXPathTest() throws JaxenException, ParserConfigurationException {
        factory_DOMXPathTest = DocumentBuilderFactory.newInstance();
        factory_DOMXPathTest.setNamespaceAware(true);
        doc_DOMXPathTest = factory_DOMXPathTest.newDocumentBuilder().newDocument();
        DOMXPath xpath = new DOMXPath("/*[ processing-instruction() or *]");
        assertEquals("/*[ processing-instruction() or *]", xpath.toString());
    }

    public void testConstructionWithNamespacePrefix_DOMXPathTest() throws JaxenException, ParserConfigurationException {
        factory_DOMXPathTest = DocumentBuilderFactory.newInstance();
        factory_DOMXPathTest.setNamespaceAware(true);
        doc_DOMXPathTest = factory_DOMXPathTest.newDocumentBuilder().newDocument();
        DOMXPath xpath = new DOMXPath("/p:foo/p:bar/a:baz");
        assertEquals("/p:foo/p:bar/a:baz", xpath.toString());
    }

    public void testNamespaceDeclarationsAreNotAttributes_DOMXPathTest() throws JaxenException, ParserConfigurationException {
        factory_DOMXPathTest = DocumentBuilderFactory.newInstance();
        factory_DOMXPathTest.setNamespaceAware(true);
        doc_DOMXPathTest = factory_DOMXPathTest.newDocumentBuilder().newDocument();
        Element root = doc_DOMXPathTest.createElementNS("http://www.example.org/", "root");
        doc_DOMXPathTest.appendChild(root);
        root.setAttributeNS("http://www.w3.org/2000/xmlns/", "xmlns", "http://www.example.org/");
        DOMXPath xpath = new DOMXPath("count(/*/@*)");
        Number value = xpath.numberValueOf(doc_DOMXPathTest);
        assertEquals(0, value.intValue());
    }

    public void testConsistentNamespaceDeclarations_DOMXPathTest() throws JaxenException, ParserConfigurationException {
        factory_DOMXPathTest = DocumentBuilderFactory.newInstance();
        factory_DOMXPathTest.setNamespaceAware(true);
        doc_DOMXPathTest = factory_DOMXPathTest.newDocumentBuilder().newDocument();
        Element root = doc_DOMXPathTest.createElement("root");
        doc_DOMXPathTest.appendChild(root);
        Element child = doc_DOMXPathTest.createElementNS("http://www.example.org", "foo:child");
        root.appendChild(child);
        child.setAttributeNS("http://www.w3.org/2000/xmlns/", "xmlns:foo2", "http://www.contradictory.org");
        XPath xpath = new DOMXPath("//namespace::node()");
        List result = xpath.selectNodes(doc_DOMXPathTest);
        assertEquals(4, result.size());
    }

    public void testInconsistentNamespaceDeclarations_DOMXPathTest() throws JaxenException, ParserConfigurationException {
        factory_DOMXPathTest = DocumentBuilderFactory.newInstance();
        factory_DOMXPathTest.setNamespaceAware(true);
        doc_DOMXPathTest = factory_DOMXPathTest.newDocumentBuilder().newDocument();
        Element root = doc_DOMXPathTest.createElement("root");
        doc_DOMXPathTest.appendChild(root);
        Element child = doc_DOMXPathTest.createElementNS("http://www.example.org", "foo:child");
        root.appendChild(child);
        child.setAttributeNS("http://www.w3.org/2000/xmlns/", "xmlns:foo", "http://www.contradictory.org");
        XPath xpath = new DOMXPath("//namespace::node()");
        List result = xpath.selectNodes(doc_DOMXPathTest);
        assertEquals(3, result.size());
    }

    public void testIntrinsicNamespaceDeclarationOfElementBeatsContradictoryXmlnsPreAttr_DOMXPathTest() throws JaxenException, ParserConfigurationException {
        factory_DOMXPathTest = DocumentBuilderFactory.newInstance();
        factory_DOMXPathTest.setNamespaceAware(true);
        doc_DOMXPathTest = factory_DOMXPathTest.newDocumentBuilder().newDocument();
        Element root = doc_DOMXPathTest.createElement("root");
        doc_DOMXPathTest.appendChild(root);
        Element child = doc_DOMXPathTest.createElementNS("http://www.example.org", "foo:child");
        root.appendChild(child);
        child.setAttributeNS("http://www.w3.org/2000/xmlns/", "xmlns:foo", "http://www.contradictory.org");
        XPath xpath = new DOMXPath("//namespace::node()[name(.)='foo']");
        List result = xpath.selectNodes(doc_DOMXPathTest);
        assertEquals(1, result.size());
        Node node = (Node) result.get(0);
        assertEquals("http://www.example.org", node.getNodeValue());
    }

    public void testIntrinsicNamespaceDeclarationOfAttrBeatsContradictoryXmlnsPreAttr_DOMXPathTest() throws JaxenException, ParserConfigurationException {
        factory_DOMXPathTest = DocumentBuilderFactory.newInstance();
        factory_DOMXPathTest.setNamespaceAware(true);
        doc_DOMXPathTest = factory_DOMXPathTest.newDocumentBuilder().newDocument();
        Element root = doc_DOMXPathTest.createElement("root");
        doc_DOMXPathTest.appendChild(root);
        root.setAttributeNS("http://www.example.org/", "foo:a", "value");
        root.setAttributeNS("http://www.w3.org/2000/xmlns/", "xmlns:foo", "http://www.contradictory.org");
        XPath xpath = new DOMXPath("//namespace::node()[name(.)='foo']");
        List result = xpath.selectNodes(doc_DOMXPathTest);
        assertEquals(1, result.size());
        Node node = (Node) result.get(0);
        assertEquals("http://www.example.org/", node.getNodeValue());
    }

    public void testIntrinsicNamespaceDeclarationOfElementBeatsContradictoryIntrinsicNamespaceOfAttr_DOMXPathTest() throws JaxenException, ParserConfigurationException {
        factory_DOMXPathTest = DocumentBuilderFactory.newInstance();
        factory_DOMXPathTest.setNamespaceAware(true);
        doc_DOMXPathTest = factory_DOMXPathTest.newDocumentBuilder().newDocument();
        Element root = doc_DOMXPathTest.createElementNS("http://www.example.org", "pre:root");
        doc_DOMXPathTest.appendChild(root);
        root.setAttributeNS("http://www.contradictory.org", "pre:foo", "value");
        XPath xpath = new DOMXPath("//namespace::node()[name(.)='pre']");
        List result = xpath.selectNodes(doc_DOMXPathTest);
        assertEquals(1, result.size());
        Node node = (Node) result.get(0);
        assertEquals("http://www.example.org", node.getNodeValue());
    }

    public void testUpdateDOMNodesReturnedBySelectNodes_DOMXPathTest() throws JaxenException, ParserConfigurationException {
        factory_DOMXPathTest = DocumentBuilderFactory.newInstance();
        factory_DOMXPathTest.setNamespaceAware(true);
        doc_DOMXPathTest = factory_DOMXPathTest.newDocumentBuilder().newDocument();
        Element root = doc_DOMXPathTest.createElementNS("http://www.example.org/", "root");
        doc_DOMXPathTest.appendChild(root);
        root.appendChild(doc_DOMXPathTest.createComment("data"));
        DOMXPath xpath = new DOMXPath("//comment()");
        List results = xpath.selectNodes(doc_DOMXPathTest);
        Node backroot = (Node) results.get(0);
        backroot.setNodeValue("test");
        assertEquals("test", backroot.getNodeValue());
    }

    public void testSelection_DOMXPathTest() throws JaxenException, ParserConfigurationException, SAXException, IOException, ParserConfigurationException {
        factory_DOMXPathTest = DocumentBuilderFactory.newInstance();
        factory_DOMXPathTest.setNamespaceAware(true);
        doc_DOMXPathTest = factory_DOMXPathTest.newDocumentBuilder().newDocument();
        XPath xpath = new DOMXPath("/foo/bar/baz");
        DocumentBuilder builder = factory_DOMXPathTest.newDocumentBuilder();
        org.w3c.dom.Document document = builder.parse(BASIC_XML_DOMXPathTest);
        List results = xpath.selectNodes(document);
        assertEquals(3, results.size());
        Iterator iter = results.iterator();
        assertEquals("baz", ((Element) iter.next()).getLocalName());
        assertEquals("baz", ((Element) iter.next()).getLocalName());
        assertEquals("baz", ((Element) iter.next()).getLocalName());
        assertTrue(!iter.hasNext());
    }

    public void testPrecedingAxisWithPositionalPredicate_DOMXPathTest() throws JaxenException, ParserConfigurationException, SAXException, IOException, ParserConfigurationException {
        factory_DOMXPathTest = DocumentBuilderFactory.newInstance();
        factory_DOMXPathTest.setNamespaceAware(true);
        doc_DOMXPathTest = factory_DOMXPathTest.newDocumentBuilder().newDocument();
        XPath xpath = new DOMXPath("//c/preceding::*[1][name()='d']");
        DocumentBuilder builder = factory_DOMXPathTest.newDocumentBuilder();
        org.w3c.dom.Document document = builder.parse("xml/web2.xml");
        List result = xpath.selectNodes(document);
        assertEquals(1, result.size());
    }

    public void testJaxen22_DOMXPathTest() throws JaxenException, ParserConfigurationException, SAXException, IOException, ParserConfigurationException {
        factory_DOMXPathTest = DocumentBuilderFactory.newInstance();
        factory_DOMXPathTest.setNamespaceAware(true);
        doc_DOMXPathTest = factory_DOMXPathTest.newDocumentBuilder().newDocument();
        XPath xpath = new DOMXPath("name(//c/preceding::*[1])");
        DocumentBuilder builder = factory_DOMXPathTest.newDocumentBuilder();
        doc_DOMXPathTest = builder.parse("xml/web2.xml");
        Object result = xpath.evaluate(doc_DOMXPathTest);
        assertEquals("d", result);
    }

    public void testJaxen207_DOMXPathTest() throws JaxenException, ParserConfigurationException {
        factory_DOMXPathTest = DocumentBuilderFactory.newInstance();
        factory_DOMXPathTest.setNamespaceAware(true);
        doc_DOMXPathTest = factory_DOMXPathTest.newDocumentBuilder().newDocument();
        XPath xpath = new DOMXPath("contains($FinResp, \"NS_Payables_Associate\") or" + "contains($FinResp, \"NS_Payables_Manager\") or" + "contains($FinResp, \"NS_Payment_Processing\") or" + "contains($FinResp, \"NS_Vendor_Maintenance\") or" + "contains($FinResp, \"NS_IB_Receivables_Manager\") or" + "contains($FinResp, \"NS_IB_Receivables_User\") or" + "contains($FinResp, \"NS_Receivables_Manager\") or" + "contains($FinResp, \"NS_Receivables_User\") or" + "contains($FinResp, \"NS_Cash_Management_User\") or" + "contains($FinResp, \"NS_Cost_Management\") or" + "contains($FinResp, \"NS_Fixed_Assets_Manager\") or" + "contains($FinResp, \"NS_Fixed_Asset_User\") or" + "contains($FinResp, \"NS_General_Ledger_Inquiry\") or" + "contains($FinResp, \"NS_General_Ledger_User\") or" + "contains($FinResp, \"NS_General_Ledger_Supervisor\") or" + "contains($FinResp, \"NS_IB_General_Ledger_User\") or" + "contains($FinResp, \"NS_IB_Oracle_Web_ADI\") or" + "contains($FinResp, \"NS_Oracle_Web_ADI\") or" + "contains($FinResp, \"NS_CRM_Resource_Manager\") or" + "contains($FinResp, \"NS_Distributor_Manager\") or" + "contains($FinResp, \"NS_OIC_User\") or" + "contains($FinResp, \" NS_Operations_Buyer\") or" + "contains($FinResp, \"NS_Purchasing_Buyer\") or" + "contains($FinResp, \"NS_Vendor_Maintenance\") or " + "contains($FinResp, \"SL_Payables_Manager\") or" + "contains($FinResp, \"SL_Payables_Super_User\") or" + "contains($FinResp, \"SL_Payment_Processing\") or" + "contains($FinResp, \"SL_Vendor_Maintenance\") or" + "contains($InvResp, \"SL_Inventory_Super_User\") or" + "contains($FinResp, \"\") or" + "contains($FinResp, \"SL_Receivables_Supervisor\") or" + "contains($FinResp, \"SL_Receivables_User\") or" + "contains($FinResp, \"NS_Cost_Management_Inquiry\") or" + "contains($FinResp, \"SL_Fixed_Asset_User\") or" + "contains($FinResp, \"SL_Fixed_Assets_Manager\") or" + "contains($FinResp, \"SL_General_Ledger_Inquiry\") or" + "contains($FinResp, \"SL_General_Ledger_Supervisor\") or" + "contains($FinResp, \"SL_General_Ledger_User\") or" + "contains($FinResp, \"SL_Oracle_Web_ADI\") or" + "contains($FinResp, \"SL_Buyer\") or" + "contains($FinResp, \"SL_Purchasing_Inquiry\") or" + "contains($FinResp, \"SL_Payables_Manager\") or" + "contains($FinResp, \"SL_Payables_Super_User\") or" + "contains($FinResp, \"SL_Payment_Processing\") or" + "contains($FinResp, \"SL_Vendor_Maintenance\") or" + "contains($InvResp, \"SL_Inventory_Super_User\") or" + "contains($FinResp, \"\") or" + "contains($FinResp, \"SL_Receivables_Supervisor\") or" + "contains($FinResp, \"SL_Receivables_User\") or" + "contains($FinResp, \"NS_Cost_Management_Inquiry\") or" + "contains($FinResp, \"SL_Fixed_Asset_User\") or" + "contains($FinResp, \"SL_Fixed_Assets_Manager\") or" + "contains($FinResp, \"SL_General_Ledger_Inquiry\") or" + "contains($FinResp, \"SL_General_Ledger_Supervisor\") or" + "contains($FinResp, \"SL_General_Ledger_User\") or" + "contains($FinResp, \"SL_Oracle_Web_ADI\") or" + "contains($FinResp, \"SL_Buyer\") or" + "contains($FinResp, \"SL_Purchasing_Inquiry\")");
    }

    public void testImplictCastFromTextInARelationalExpression_DOMXPathTest() throws JaxenException, ParserConfigurationException, SAXException, IOException, ParserConfigurationException {
        factory_DOMXPathTest = DocumentBuilderFactory.newInstance();
        factory_DOMXPathTest.setNamespaceAware(true);
        doc_DOMXPathTest = factory_DOMXPathTest.newDocumentBuilder().newDocument();
        XPath implicitCast = new DOMXPath("//lat[(text() >= 37)]");
        XPath explicitCast = new DOMXPath("//lat[(number(text()) >= 37)]");
        DocumentBuilder builder = factory_DOMXPathTest.newDocumentBuilder();
        ByteArrayInputStream in = new ByteArrayInputStream("<geo><lat>39</lat></geo>".getBytes("UTF-8"));
        org.w3c.dom.Document document = builder.parse(in);
        List result = explicitCast.selectNodes(document);
        assertEquals(1, result.size());
        result = implicitCast.selectNodes(document);
        assertEquals(1, result.size());
    }

    public void testImplictCastFromCommentInARelationalExpression_DOMXPathTest() throws JaxenException, ParserConfigurationException, SAXException, IOException, ParserConfigurationException {
        factory_DOMXPathTest = DocumentBuilderFactory.newInstance();
        factory_DOMXPathTest.setNamespaceAware(true);
        doc_DOMXPathTest = factory_DOMXPathTest.newDocumentBuilder().newDocument();
        XPath implicitCast = new DOMXPath("//lat[(comment() >= 37)]");
        XPath explicitCast = new DOMXPath("//lat[(number(comment()) >= 37)]");
        DocumentBuilder builder = factory_DOMXPathTest.newDocumentBuilder();
        ByteArrayInputStream in = new ByteArrayInputStream("<geo><lat><!--39--></lat></geo>".getBytes("UTF-8"));
        org.w3c.dom.Document document = builder.parse(in);
        List result = explicitCast.selectNodes(document);
        assertEquals(1, result.size());
        result = implicitCast.selectNodes(document);
        assertEquals(1, result.size());
    }

    public void testImplictCastFromProcessingInstructionInARelationalExpression_DOMXPathTest() throws JaxenException, ParserConfigurationException, SAXException, IOException, ParserConfigurationException {
        factory_DOMXPathTest = DocumentBuilderFactory.newInstance();
        factory_DOMXPathTest.setNamespaceAware(true);
        doc_DOMXPathTest = factory_DOMXPathTest.newDocumentBuilder().newDocument();
        XPath implicitCast = new DOMXPath("//lat[(processing-instruction() >= 37)]");
        XPath explicitCast = new DOMXPath("//lat[(number(processing-instruction()) >= 37)]");
        DocumentBuilder builder = factory_DOMXPathTest.newDocumentBuilder();
        ByteArrayInputStream in = new ByteArrayInputStream("<geo><lat><?test 39?></lat></geo>".getBytes("UTF-8"));
        org.w3c.dom.Document document = builder.parse(in);
        List result = explicitCast.selectNodes(document);
        assertEquals(1, result.size());
        result = implicitCast.selectNodes(document);
        assertEquals(1, result.size());
    }

    public void testPrecedingAxisInDocumentOrder_DOMXPathTest() throws JaxenException, ParserConfigurationException {
        factory_DOMXPathTest = DocumentBuilderFactory.newInstance();
        factory_DOMXPathTest.setNamespaceAware(true);
        doc_DOMXPathTest = factory_DOMXPathTest.newDocumentBuilder().newDocument();
        XPath xpath = new DOMXPath("preceding::*");
        Element root = doc_DOMXPathTest.createElement("root");
        doc_DOMXPathTest.appendChild(root);
        Element a = doc_DOMXPathTest.createElement("a");
        root.appendChild(a);
        Element b = doc_DOMXPathTest.createElement("b");
        root.appendChild(b);
        Element c = doc_DOMXPathTest.createElement("c");
        a.appendChild(c);
        List result = xpath.selectNodes(b);
        assertEquals(2, result.size());
        assertEquals(a, result.get(0));
        assertEquals(c, result.get(1));
    }

    public void testEqualityAgainstNonExistentNodes_EqualsTest() throws JaxenException, ParserConfigurationException {
        DOMXPath xpath = new DOMXPath("/a/b[c = ../d]");
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        org.w3c.dom.Document doc = factory.newDocumentBuilder().newDocument();
        Element root = doc.createElement("a");
        doc.appendChild(root);
        Element b = doc.createElement("b");
        root.appendChild(b);
        Element c = doc.createElement("c");
        b.appendChild(c);
        List result = (List) xpath.evaluate(doc);
        assertEquals(0, result.size());
    }

    public void testOlander_EqualsTest() throws JaxenException, SAXException, IOException, ParserConfigurationException {
        DOMXPath xpath = new DOMXPath("//BlockStatement//IfStatement[./Statement =  ./ancestor::BlockStatement/following-sibling::BlockStatement//IfStatement/Statement]");
        String data = "<?xml version='1.0'?><Block><BlockStatement><LocalVariableDeclaration><Type><PrimitiveType>boolean</PrimitiveType></Type><VariableDeclarator><VariableDeclaratorId/></VariableDeclarator><VariableDeclarator><VariableDeclaratorId/></VariableDeclarator></LocalVariableDeclaration></BlockStatement><BlockStatement><Statement><IfStatement><Expression><PrimaryExpression><PrimaryPrefix><Name>a</Name></PrimaryPrefix></PrimaryExpression></Expression><Statement><StatementExpression><PrimaryExpression><PrimaryPrefix><Name>methodB</Name></PrimaryPrefix><PrimarySuffix><Arguments/></PrimarySuffix></PrimaryExpression></StatementExpression></Statement></IfStatement></Statement></BlockStatement><BlockStatement><Statement><IfStatement><Expression><PrimaryExpression><PrimaryPrefix><Name>b</Name></PrimaryPrefix></PrimaryExpression></Expression><Statement><StatementExpression><PrimaryExpression><PrimaryPrefix><Name>methodB</Name></PrimaryPrefix><PrimarySuffix><Arguments/></PrimarySuffix></PrimaryExpression></StatementExpression></Statement></IfStatement></Statement></BlockStatement></Block>";
        StringReader reader = new StringReader(data);
        InputSource in = new InputSource(reader);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        org.w3c.dom.Document doc = factory.newDocumentBuilder().parse(in);
        List result = (List) xpath.evaluate(doc);
        assertEquals(1, result.size());
    }
    
    class MinFunction implements Function {

        public Object call(Context context, List args) {
            
            if (args.isEmpty()) return new Double(Double.NaN);
            
            Navigator navigator = context.getNavigator();
            double min = Double.MAX_VALUE;
            Iterator iterator = args.iterator();
            while (iterator.hasNext()) {
                double next = NumberFunction.evaluate(iterator.next(), navigator).doubleValue();
                min = Math.min(min, next);
            }
            return new Double(min);
        }
        
    }

    public void testRegisterExtensionFunction_ExtensionFunctionTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc_ExtensionFunctionTest = builder.newDocument();
        SimpleFunctionContext fc = new XPathFunctionContext(false);
        fc.registerFunction("http://exslt.org/math", "min", new MinFunction());
        SimpleNamespaceContext nc = new SimpleNamespaceContext();
        nc.addNamespace("math", "http://exslt.org/math");
        BaseXPath xpath = new DOMXPath("math:min(//x)");
        xpath.setFunctionContext(fc);
        xpath.setNamespaceContext(nc);
        org.w3c.dom.Element a = doc_ExtensionFunctionTest.createElementNS("", "a");
        org.w3c.dom.Element b = doc_ExtensionFunctionTest.createElementNS("", "b");
        doc_ExtensionFunctionTest.appendChild(a);
        a.appendChild(b);
        org.w3c.dom.Element x2 = doc_ExtensionFunctionTest.createElementNS("", "x");
        org.w3c.dom.Element x3 = doc_ExtensionFunctionTest.createElementNS("", "x");
        org.w3c.dom.Element x4 = doc_ExtensionFunctionTest.createElementNS("", "x");
        a.appendChild(x4);
        b.appendChild(x2);
        b.appendChild(x3);
        x2.appendChild(doc_ExtensionFunctionTest.createTextNode("2"));
        x3.appendChild(doc_ExtensionFunctionTest.createTextNode("3"));
        x4.appendChild(doc_ExtensionFunctionTest.createTextNode("4"));
        Double result = (Double) xpath.evaluate(doc_ExtensionFunctionTest);
        assertEquals(new Double(2), result);
    }

    public void testJaxen47_ExtensionFunctionTest() throws SAXPathException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc_ExtensionFunctionTest = builder.newDocument();
        org.jaxen.dom.DocumentNavigator.getInstance().parseXPath("a:b()");
    }

    public void testFalseOfNumber_FalseTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc_FalseTest = builder.newDocument();
        doc_FalseTest.appendChild(doc_FalseTest.createElement("root"));
        try {
            XPath xpath = new DOMXPath("false(3)");
            xpath.selectNodes(doc_FalseTest);
            fail("false() function took arguments");
        } catch (FunctionCallException e) {
            assertEquals("false() requires no arguments.", e.getMessage());
        }
    }

    public void testFalse_FalseTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc_FalseTest = builder.newDocument();
        doc_FalseTest.appendChild(doc_FalseTest.createElement("root"));
        XPath xpath = new DOMXPath("false()");
        Object result = xpath.evaluate(doc_FalseTest);
        assertEquals(Boolean.FALSE, result);
    }

    public void testFloor_FloorTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc_FloorTest = builder.newDocument();
        org.w3c.dom.Element a = doc_FloorTest.createElementNS("", "a");
        doc_FloorTest.appendChild(a);
        BaseXPath xpath = new DOMXPath("floor(1.5)");
        Object result = xpath.evaluate(doc_FloorTest);
        assertEquals(1, ((Double) result).doubleValue(), 0.0001);
    }

    public void testNegativeFloor_FloorTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc_FloorTest = builder.newDocument();
        org.w3c.dom.Element a = doc_FloorTest.createElementNS("", "a");
        doc_FloorTest.appendChild(a);
        BaseXPath xpath = new DOMXPath("floor(-1.5)");
        Object result = xpath.evaluate(doc_FloorTest);
        assertEquals(-2, ((Double) result).doubleValue(), 0.0001);
    }

    public void testNaNFloorIsNaN_FloorTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc_FloorTest = builder.newDocument();
        org.w3c.dom.Element a = doc_FloorTest.createElementNS("", "a");
        doc_FloorTest.appendChild(a);
        BaseXPath xpath = new DOMXPath("floor(1.0 div 0.0 - 2.0 div 0.0)");
        double result = ((Double) xpath.evaluate(doc_FloorTest)).doubleValue();
        assertTrue(Double.isNaN(result));
    }

    public void testInfFloorIsInf_FloorTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc_FloorTest = builder.newDocument();
        org.w3c.dom.Element a = doc_FloorTest.createElementNS("", "a");
        doc_FloorTest.appendChild(a);
        BaseXPath xpath = new DOMXPath("floor(1.0 div 0.0)");
        double result = ((Double) xpath.evaluate(doc_FloorTest)).doubleValue();
        assertTrue(Double.isInfinite(result));
        assertTrue(result > 0);
    }

    public void testNegativeInfFloorIsNegativeInf_FloorTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc_FloorTest = builder.newDocument();
        org.w3c.dom.Element a = doc_FloorTest.createElementNS("", "a");
        doc_FloorTest.appendChild(a);
        BaseXPath xpath = new DOMXPath("floor(-1.0 div 0.0)");
        double result = ((Double) xpath.evaluate(doc_FloorTest)).doubleValue();
        assertTrue(Double.isInfinite(result));
        assertTrue(result < 0);
    }

    public void testFloorFunctionRequiresAtLeastArgument_FloorTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc_FloorTest = builder.newDocument();
        org.w3c.dom.Element a = doc_FloorTest.createElementNS("", "a");
        doc_FloorTest.appendChild(a);
        BaseXPath xpath = new DOMXPath("floor()");
        try {
            xpath.selectNodes(doc_FloorTest);
            fail("Allowed floor function with no arguments");
        } catch (FunctionCallException ex) {
            assertNotNull(ex.getMessage());
        }
    }

    public void testBooleanFunctionRequiresExactlyOneArgument_FloorTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc_FloorTest = builder.newDocument();
        org.w3c.dom.Element a = doc_FloorTest.createElementNS("", "a");
        doc_FloorTest.appendChild(a);
        BaseXPath xpath = new DOMXPath("floor(2.2, 1.2)");
        try {
            xpath.selectNodes(doc_FloorTest);
            fail("Allowed floor function with two arguments");
        } catch (FunctionCallException ex) {
            assertNotNull(ex.getMessage());
        }
    }

    public void testNoInfiniteLoops_FollowingAxisIteratorTest() throws ParserConfigurationException, UnsupportedAxisException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        org.w3c.dom.Document doc = factory.newDocumentBuilder().newDocument();
        doc.appendChild(doc.createElement("root"));
        iterator_FollowingAxisIteratorTest = new FollowingAxisIterator(doc, new org.jaxen.dom.DocumentNavigator());
        try {
            iterator_FollowingAxisIteratorTest.next();
            fail("Iterated too far");
        } catch (NoSuchElementException ex) {
            pass_FollowingAxisIteratorTest();
        }
    }

    private void pass_FollowingAxisIteratorTest() throws ParserConfigurationException, UnsupportedAxisException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        org.w3c.dom.Document doc = factory.newDocumentBuilder().newDocument();
        doc.appendChild(doc.createElement("root"));
        iterator_FollowingAxisIteratorTest = new FollowingAxisIterator(doc, new org.jaxen.dom.DocumentNavigator());
    }

    public void testRemove_FollowingAxisIteratorTest() throws ParserConfigurationException, UnsupportedAxisException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        org.w3c.dom.Document doc = factory.newDocumentBuilder().newDocument();
        doc.appendChild(doc.createElement("root"));
        iterator_FollowingAxisIteratorTest = new FollowingAxisIterator(doc, new org.jaxen.dom.DocumentNavigator());
        try {
            iterator_FollowingAxisIteratorTest.remove();
            fail("Removed from descendant axis iterator");
        } catch (UnsupportedOperationException ex) {
            pass_FollowingAxisIteratorTest();
        }
    }

    public void testNoInfiniteLoops_FollowingSiblingAxisIteratorTest() throws ParserConfigurationException, UnsupportedAxisException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        org.w3c.dom.Document doc = factory.newDocumentBuilder().newDocument();
        doc.appendChild(doc.createElement("root"));
        iterator_FollowingSiblingAxisIteratorTest = new FollowingSiblingAxisIterator(doc, new org.jaxen.dom.DocumentNavigator());
        try {
            iterator_FollowingSiblingAxisIteratorTest.next();
            fail("Iterated too far");
        } catch (NoSuchElementException ex) {
            pass_FollowingSiblingAxisIteratorTest();
        }
    }

    private void pass_FollowingSiblingAxisIteratorTest() throws ParserConfigurationException, UnsupportedAxisException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        org.w3c.dom.Document doc = factory.newDocumentBuilder().newDocument();
        doc.appendChild(doc.createElement("root"));
        iterator_FollowingSiblingAxisIteratorTest = new FollowingSiblingAxisIterator(doc, new org.jaxen.dom.DocumentNavigator());
    }

    public void testRemove_FollowingSiblingAxisIteratorTest() throws ParserConfigurationException, UnsupportedAxisException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        org.w3c.dom.Document doc = factory.newDocumentBuilder().newDocument();
        doc.appendChild(doc.createElement("root"));
        iterator_FollowingSiblingAxisIteratorTest = new FollowingSiblingAxisIterator(doc, new org.jaxen.dom.DocumentNavigator());
        try {
            iterator_FollowingSiblingAxisIteratorTest.remove();
            fail("Removed from descendant axis iterator");
        } catch (UnsupportedOperationException ex) {
            pass_FollowingSiblingAxisIteratorTest();
        }
    }

    public void testMessageIsNonNull_FunctionCallExceptionTest() {
        JaxenException ex = new JaxenException("Hello");
        FunctionCallException rex = new FunctionCallException(ex);
        assertEquals(ex.getMessage(), rex.getMessage());
        assertEquals(ex, rex.getCause());
    }

    public void testMessageIsSaved_FunctionCallExceptionTest() {
        JaxenException ex = new JaxenException("Hello");
        FunctionCallException rex = new FunctionCallException("Goodbye", ex);
        assertEquals("Goodbye", rex.getMessage());
        assertEquals(ex, rex.getCause());
    }

    public void testJAXEN50_FunctionContextTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        doc_FunctionContextTest = factory.newDocumentBuilder().newDocument();
        Element root = doc_FunctionContextTest.createElementNS("http://www.example.org/", "root");
        doc_FunctionContextTest.appendChild(root);
        root.setAttributeNS("http://www.w3.org/2000/xmlns/", "xmlns", "http://www.example.org/");
        DOMXPath xpath = new DOMXPath("true()");
        SimpleNamespaceContext nsContext = new SimpleNamespaceContext();
        nsContext.addElementNamespaces(xpath.getNavigator(), doc_FunctionContextTest);
        xpath.setNamespaceContext(nsContext);
        boolean result = xpath.booleanValueOf(doc_FunctionContextTest);
        assertTrue(result);
    }

    public void testUnresolvableFunction_FunctionContextTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        doc_FunctionContextTest = factory.newDocumentBuilder().newDocument();
        Element root = doc_FunctionContextTest.createElementNS("http://www.example.org/", "root");
        doc_FunctionContextTest.appendChild(root);
        root.setAttributeNS("http://www.w3.org/2000/xmlns/", "xmlns", "http://www.example.org/");
        DOMXPath xpath = new DOMXPath("nonesuch()");
        try {
            xpath.evaluate(doc_FunctionContextTest);
            fail("Evaluated nonexistent function");
        } catch (UnresolvableException ex) {
            assertNotNull(ex.getMessage());
        }
    }

    public void testUnresolvableFunctionExceptionMessage_FunctionContextTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        doc_FunctionContextTest = factory.newDocumentBuilder().newDocument();
        Element root = doc_FunctionContextTest.createElementNS("http://www.example.org/", "root");
        doc_FunctionContextTest.appendChild(root);
        root.setAttributeNS("http://www.w3.org/2000/xmlns/", "xmlns", "http://www.example.org/");
        DOMXPath xpath = new DOMXPath("nonesuch()");
        try {
            xpath.evaluate(doc_FunctionContextTest);
            fail("Evaluated nonexistent function");
        } catch (UnresolvableException ex) {
            assertEquals(-1, ex.getMessage().indexOf(':'));
        }
    }

    public void testGetFunctionContext_FunctionContextTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        doc_FunctionContextTest = factory.newDocumentBuilder().newDocument();
        Element root = doc_FunctionContextTest.createElementNS("http://www.example.org/", "root");
        doc_FunctionContextTest.appendChild(root);
        root.setAttributeNS("http://www.w3.org/2000/xmlns/", "xmlns", "http://www.example.org/");
        DOMXPath xpath = new DOMXPath("/root/child");
        assertNotNull(xpath.getFunctionContext());
    }

    public void testSerializeFunctionContext_FunctionContextTest() throws JaxenException, IOException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        doc_FunctionContextTest = factory.newDocumentBuilder().newDocument();
        Element root = doc_FunctionContextTest.createElementNS("http://www.example.org/", "root");
        doc_FunctionContextTest.appendChild(root);
        root.setAttributeNS("http://www.w3.org/2000/xmlns/", "xmlns", "http://www.example.org/");
        DOMXPath xpath = new DOMXPath("/root/child");
        FunctionContext context = xpath.getFunctionContext();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ObjectOutputStream oout = new ObjectOutputStream(out);
        try {
            oout.writeObject(context);
            fail("serialized function context");
        } catch (NotSerializableException ex) {
            assertNotNull(ex.getMessage());
        }
    }

    public void testIDFunctionSelectsNothingInDocumentWithNoIds_IdTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        builder_IdTest = factory.newDocumentBuilder();
        doc_IdTest = builder_IdTest.newDocument();
        BaseXPath xpath = new DOMXPath("id('p1')");
        org.w3c.dom.Element a = doc_IdTest.createElementNS("", "a");
        org.w3c.dom.Element b = doc_IdTest.createElementNS("", "b");
        doc_IdTest.appendChild(a);
        a.appendChild(b);
        org.w3c.dom.Element x2 = doc_IdTest.createElementNS("", "x");
        org.w3c.dom.Element x3 = doc_IdTest.createElementNS("", "x");
        org.w3c.dom.Element x4 = doc_IdTest.createElementNS("", "x");
        a.appendChild(x4);
        b.appendChild(x2);
        b.appendChild(x3);
        x2.appendChild(doc_IdTest.createTextNode("2"));
        x3.appendChild(doc_IdTest.createTextNode("3"));
        x4.appendChild(doc_IdTest.createTextNode("4"));
        Attr id = doc_IdTest.createAttribute("id");
        id.setNodeValue("p1");
        x2.setAttributeNode(id);
        List result = xpath.selectNodes(doc_IdTest);
        assertEquals(0, result.size());
    }

    public void testIDFunctionRequiresAtLeastOneArgument_IdTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        builder_IdTest = factory.newDocumentBuilder();
        doc_IdTest = builder_IdTest.newDocument();
        try {
            BaseXPath xpath = new DOMXPath("id()");
            org.w3c.dom.Element a = doc_IdTest.createElementNS("", "a");
            doc_IdTest.appendChild(a);
            xpath.selectNodes(doc_IdTest);
            fail("Allowed empty id() function");
        } catch (FunctionCallException success) {
            assertNotNull(success.getMessage());
        }
    }

    public void testIDFunctionRequiresAtMostOneArgument_IdTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        builder_IdTest = factory.newDocumentBuilder();
        doc_IdTest = builder_IdTest.newDocument();
        try {
            BaseXPath xpath = new DOMXPath("id('p', 'q')");
            org.w3c.dom.Element a = doc_IdTest.createElementNS("", "a");
            doc_IdTest.appendChild(a);
            xpath.selectNodes(doc_IdTest);
            fail("Allowed two-argument id() function");
        } catch (FunctionCallException success) {
            assertNotNull(success.getMessage());
        }
    }

    public void testFindElementById_IdTest() throws JaxenException, SAXException, IOException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        builder_IdTest = factory.newDocumentBuilder();
        doc_IdTest = builder_IdTest.newDocument();
        BaseXPath xpath = new DOMXPath("id('p1')");
        String text = "<!DOCTYPE root [<!ATTLIST a id ID #REQUIRED>]><root><a id='p1'/></root>";
        StringReader reader = new StringReader(text);
        InputSource in = new InputSource(reader);
        org.w3c.dom.Document doc_IdTest = builder_IdTest.parse(in);
        List result = xpath.selectNodes(doc_IdTest);
        assertEquals(1, result.size());
        Element a = (Element) result.get(0);
        assertEquals("a", a.getNodeName());
    }

    public void testFindMultipleElementsByMultipleIDs_IdTest() throws JaxenException, SAXException, IOException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        builder_IdTest = factory.newDocumentBuilder();
        doc_IdTest = builder_IdTest.newDocument();
        BaseXPath xpath = new DOMXPath("id(//id)");
        String text = "<!DOCTYPE root [<!ATTLIST a id ID #REQUIRED>]><root><id>p1</id><id>p2</id><id>p3</id><a id='p1'/><a id='p2'/></root>";
        StringReader reader = new StringReader(text);
        InputSource in = new InputSource(reader);
        org.w3c.dom.Document doc_IdTest = builder_IdTest.parse(in);
        List result = xpath.selectNodes(doc_IdTest);
        assertEquals(2, result.size());
        Element a1 = (Element) result.get(0);
        Element a2 = (Element) result.get(1);
        assertEquals("a", a1.getNodeName());
        assertEquals("a", a2.getNodeName());
    }

    public void testIdReturnsFirstElementWithMatchingId_IdTest() throws JaxenException, SAXException, IOException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        builder_IdTest = factory.newDocumentBuilder();
        doc_IdTest = builder_IdTest.newDocument();
        BaseXPath xpath = new DOMXPath("id('p1')");
        String text = "<!DOCTYPE root [<!ATTLIST a id ID #REQUIRED>" + "<!ATTLIST b id ID #REQUIRED>]><root><a id='p1'/><b id='p1'/></root>";
        StringReader reader = new StringReader(text);
        InputSource in = new InputSource(reader);
        org.w3c.dom.Document doc_IdTest = builder_IdTest.parse(in);
        List result = xpath.selectNodes(doc_IdTest);
        assertEquals(1, result.size());
        Element a = (Element) result.get(0);
        assertEquals("a", a.getNodeName());
    }

    public void testIterableSelfNamedAxis_IterableAxisTest() throws JaxenException, SAXException {
        IterableAxis axis = new IterableSelfAxis(0);
        try {
            axis.namedAccessIterator(null, null, "name", "pre", "http://www.example.org/");
            fail("should not support operation");
        } catch (UnsupportedOperationException ex) {
            assertEquals("Named access unsupported", ex.getMessage());
        }
    }

    public void testSomething_JavaBeanNavigatorTest() throws JaxenException, Exception {
        System.setProperty(XPathReaderFactory.DRIVER_PROPERTY, "");
        JavaBeanXPath xpath = new JavaBeanXPath("brother[position()<4]/name");
        Person bob = new Person("bob", 30);
        bob.addBrother(new Person("billy", 34));
        bob.addBrother(new Person("seth", 29));
        bob.addBrother(new Person("dave", 32));
        bob.addBrother(new Person("jim", 29));
        bob.addBrother(new Person("larry", 42));
        bob.addBrother(new Person("ted", 22));
        List result = (List) xpath.evaluate(bob);
        assertEquals(3, result.size());
    }

    public void testMessageIsNonNull_JaxenExceptionTest() {
        JaxenException ex = new JaxenException("Hello");
        assertEquals("Hello", ex.getMessage());
    }

    public void testPrintStackTrace_JaxenExceptionTest() {
        StringIndexOutOfBoundsException cause = new StringIndexOutOfBoundsException("1234");
        JaxenException ex = new JaxenException(cause);
        StringWriter out = new StringWriter();
        PrintWriter pw = new PrintWriter(out);
        ex.printStackTrace(pw);
        pw.close();
        String trace = out.toString();
        assertEquals(-1, trace.indexOf("Root cause:"));
        assertTrue(trace.indexOf("Caused by: java.lang.StringIndexOutOfBoundsException") > 0);
        assertTrue(trace.indexOf("1234") > 0);
    }

    public void testValidPaths_JaxenHandlerTest() {
        String path = null;
        try {
            XPathReader reader = XPathReaderFactory.createReader();
            JaxenHandler handler = new JaxenHandler();
            handler.setXPathFactory(new DefaultXPathFactory());
            reader.setXPathHandler(handler);
            for (int i = 0; i < paths_JaxenHandlerTest.length; i++) {
                path = paths_JaxenHandlerTest[i];
                reader.parse(path);
                handler.getXPathExpr(false);
                handler.getXPathExpr();
            }
        } catch (Exception e) {
            e.printStackTrace();
            fail(path + " -> " + e.getMessage());
        }
    }

    public void testBogusPaths_JaxenHandlerTest() throws SAXPathException {
        XPathReader reader = XPathReaderFactory.createReader();
        JaxenHandler handler = new JaxenHandler();
        handler.setXPathFactory(new DefaultXPathFactory());
        reader.setXPathHandler(handler);
        for (int i = 0; i < bogusPaths_JaxenHandlerTest.length; i++) {
            String path = bogusPaths_JaxenHandlerTest[i];
            try {
                reader.parse(path);
                XPathExpr xpath = handler.getXPathExpr(false);
                fail("Parsed bogus path as: " + xpath);
            } catch (org.jaxen.saxpath.XPathSyntaxException e) {
            }
        }
    }

    public void testMessageIsNonNull_JaxenRuntimeExceptionTest() {
        JaxenException ex = new JaxenException("Hello");
        JaxenRuntimeException rex = new JaxenRuntimeException(ex);
        assertEquals(ex.getMessage(), rex.getMessage());
        assertEquals(ex, rex.getCause());
    }

    public void testPrintStackTrace_JaxenRuntimeExceptionTest() {
        JaxenException cause = new JaxenException("1234");
        JaxenRuntimeException ex = new JaxenRuntimeException(cause);
        StringWriter out = new StringWriter();
        PrintWriter pw = new PrintWriter(out);
        ex.printStackTrace(pw);
        pw.close();
        assertTrue(out.toString().indexOf("Caused by: org.jaxen.JaxenException") > 0);
        assertTrue(out.toString().indexOf("1234") > 0);
    }

    public Navigator getNavigator_JDOMNavigatorTest() {
        return new DocumentNavigator();
    }

    public Object getDocument_JDOMNavigatorTest(String url) throws Exception {
        return this.builder_JDOMNavigatorTest.build(url);
    }

    public void testNullNamespace_JDOMNavigatorTest() throws JaxenException {
        Namespace my = Namespace.getNamespace("foo", "http://mynamespace.org/");
        Document doc = new Document();
        org.jdom.Element root = new org.jdom.Element("root", my);
        doc.setRootElement(root);
        XPath nullNamespacePath = new JDOMXPath("/root");
        List selectedNodes = nullNamespacePath.selectNodes(doc);
        assertEquals(0, selectedNodes.size());
    }

    public void testConstruction_JDOMXPathTest() throws JaxenException {
        new JDOMXPath("/foo/bar/baz");
    }

    public void testSelection_JDOMXPathTest() throws JaxenException, JDOMException, IOException {
        XPath xpath = new JDOMXPath("/foo/bar/baz");
        SAXBuilder builder = new SAXBuilder();
        Document doc = builder.build(BASIC_XML_JDOMXPathTest);
        List results = xpath.selectNodes(doc);
        assertEquals(3, results.size());
        Iterator iter = results.iterator();
        assertEquals("baz", ((org.jdom.Element) iter.next()).getName());
        assertEquals("baz", ((org.jdom.Element) iter.next()).getName());
        assertEquals("baz", ((org.jdom.Element) iter.next()).getName());
        assertTrue(!iter.hasNext());
    }

    public void testGetDocumentNode_JDOMXPathTest() throws JaxenException, JDOMException, IOException {
        XPath xpath = new JDOMXPath("/");
        SAXBuilder builder = new SAXBuilder();
        Document doc = builder.build(BASIC_XML_JDOMXPathTest);
        org.jdom.Element root = doc.getRootElement();
        List results = xpath.selectNodes(root);
        assertEquals(1, results.size());
        Iterator iter = results.iterator();
        assertEquals(doc, iter.next());
    }

    public void testJaxen148_JDOMXPathTest() throws JaxenException, JDOMException, IOException {
        String xml = "<xml-document><nodes><node>" + "\ntest\n" + "</node></nodes></xml-document>";
        SAXBuilder builder = new SAXBuilder();
        Document document = builder.build(new InputSource(new StringReader(xml)));
        JDOMXPath x = new JDOMXPath("/xml-document/nodes/node/text()");
        Text t = (Text) x.selectSingleNode(document);
        assertEquals("\ntest\n", t.getText());
    }

    public void testJaxen53Text_JDOMXPathTest() throws JaxenException, JDOMException, IOException {
        XPath xpath = new JDOMXPath("//data/text() ");
        SAXBuilder builder = new SAXBuilder();
        Document doc = builder.build(new StringReader("<root>\n<data>1</data>\n</root>"));
        List results = xpath.selectNodes(doc);
        assertEquals(1, results.size());
        Iterator iter = results.iterator();
        Text result = (Text) iter.next();
        assertEquals("1", result.getValue());
    }

    public void testJaxen20AttributeNamespaceNodes_JDOMXPathTest() throws JaxenException {
        Namespace ns1 = Namespace.getNamespace("p1", "www.acme1.org");
        Namespace ns2 = Namespace.getNamespace("p2", "www.acme2.org");
        org.jdom.Element element = new org.jdom.Element("test", ns1);
        Attribute attribute = new Attribute("foo", "bar", ns2);
        element.setAttribute(attribute);
        Document doc = new Document(element);
        XPath xpath = new JDOMXPath("//namespace::node()");
        List results = xpath.selectNodes(doc);
        assertEquals(3, results.size());
    }

    public void testNamespaceNodesAreInherited_JDOMXPathTest() throws JaxenException {
        Namespace ns0 = Namespace.getNamespace("p0", "www.acme0.org");
        Namespace ns1 = Namespace.getNamespace("p1", "www.acme1.org");
        Namespace ns2 = Namespace.getNamespace("p2", "www.acme2.org");
        org.jdom.Element element = new org.jdom.Element("test", ns1);
        Attribute attribute = new Attribute("foo", "bar", ns2);
        element.setAttribute(attribute);
        org.jdom.Element root = new org.jdom.Element("root", ns0);
        root.addContent(element);
        Document doc = new Document(root);
        XPath xpath = new JDOMXPath("/*/*/namespace::node()");
        List results = xpath.selectNodes(doc);
        assertEquals(4, results.size());
    }

    public void testLangFunction_LangTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        builder_LangTest = factory.newDocumentBuilder();
        doc_LangTest = builder_LangTest.newDocument();
        BaseXPath xpath = new DOMXPath("//*[lang('en')]");
        Element a = doc_LangTest.createElementNS("", "a");
        Element b = doc_LangTest.createElementNS("", "b");
        b.setAttributeNS("http://www.w3.org/XML/1998/namespace", "xml:lang", "en");
        doc_LangTest.appendChild(a);
        a.appendChild(b);
        Element x2 = doc_LangTest.createElementNS("", "x");
        Element x3 = doc_LangTest.createElementNS("", "x");
        Element x4 = doc_LangTest.createElementNS("", "x");
        a.appendChild(x4);
        b.appendChild(x2);
        b.appendChild(x3);
        x2.appendChild(doc_LangTest.createTextNode("2"));
        x3.appendChild(doc_LangTest.createTextNode("3"));
        x4.appendChild(doc_LangTest.createTextNode("4"));
        List result = xpath.selectNodes(doc_LangTest);
        assertEquals(3, result.size());
        assertEquals(b, result.get(0));
        assertEquals(x2, result.get(1));
        assertEquals(x3, result.get(2));
    }

    public void testLangFunctionSelectsNothing_LangTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        builder_LangTest = factory.newDocumentBuilder();
        doc_LangTest = builder_LangTest.newDocument();
        BaseXPath xpath = new DOMXPath("//*[lang('fr')]");
        Element a = doc_LangTest.createElementNS("", "a");
        Element b = doc_LangTest.createElementNS("", "b");
        b.setAttributeNS("http://www.w3.org/XML/1998/namespace", "xml:lang", "en");
        doc_LangTest.appendChild(a);
        a.appendChild(b);
        Element x2 = doc_LangTest.createElementNS("", "x");
        Element x3 = doc_LangTest.createElementNS("", "x");
        Element x4 = doc_LangTest.createElementNS("", "x");
        a.appendChild(x4);
        b.appendChild(x2);
        b.appendChild(x3);
        x2.appendChild(doc_LangTest.createTextNode("2"));
        x3.appendChild(doc_LangTest.createTextNode("3"));
        x4.appendChild(doc_LangTest.createTextNode("4"));
        List result = xpath.selectNodes(doc_LangTest);
        assertEquals(0, result.size());
    }

    public void testLangFunctionSelectsSubcode_LangTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        builder_LangTest = factory.newDocumentBuilder();
        doc_LangTest = builder_LangTest.newDocument();
        BaseXPath xpath = new DOMXPath("//*[lang('fr')]");
        Element a = doc_LangTest.createElementNS("", "a");
        Element b = doc_LangTest.createElementNS("", "b");
        b.setAttributeNS("http://www.w3.org/XML/1998/namespace", "xml:lang", "fr-CA");
        doc_LangTest.appendChild(a);
        a.appendChild(b);
        Element x2 = doc_LangTest.createElementNS("", "x");
        Element x3 = doc_LangTest.createElementNS("", "x");
        Element x4 = doc_LangTest.createElementNS("", "x");
        a.appendChild(x4);
        b.appendChild(x2);
        b.appendChild(x3);
        x2.appendChild(doc_LangTest.createTextNode("2"));
        x3.appendChild(doc_LangTest.createTextNode("3"));
        x4.appendChild(doc_LangTest.createTextNode("4"));
        List result = xpath.selectNodes(doc_LangTest);
        assertEquals(3, result.size());
        assertEquals(b, result.get(0));
        assertEquals(x2, result.get(1));
        assertEquals(x3, result.get(2));
    }

    public void testHyphenRequiredAtEnd_LangTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        builder_LangTest = factory.newDocumentBuilder();
        doc_LangTest = builder_LangTest.newDocument();
        BaseXPath xpath = new DOMXPath("//*[lang('f')]");
        Element a = doc_LangTest.createElementNS("", "a");
        Element b = doc_LangTest.createElementNS("", "b");
        b.setAttributeNS("http://www.w3.org/XML/1998/namespace", "xml:lang", "fr-CA");
        doc_LangTest.appendChild(a);
        a.appendChild(b);
        Element x2 = doc_LangTest.createElementNS("", "x");
        Element x3 = doc_LangTest.createElementNS("", "x");
        Element x4 = doc_LangTest.createElementNS("", "x");
        a.appendChild(x4);
        b.appendChild(x2);
        b.appendChild(x3);
        x2.appendChild(doc_LangTest.createTextNode("2"));
        x3.appendChild(doc_LangTest.createTextNode("3"));
        x4.appendChild(doc_LangTest.createTextNode("4"));
        List result = xpath.selectNodes(doc_LangTest);
        assertEquals(0, result.size());
    }

    public void testLangFunctionSelectsEmptyNodeSet_LangTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        builder_LangTest = factory.newDocumentBuilder();
        doc_LangTest = builder_LangTest.newDocument();
        BaseXPath xpath = new DOMXPath("//*[lang(d)]");
        Element a = doc_LangTest.createElementNS("", "a");
        Element b = doc_LangTest.createElementNS("", "b");
        b.setAttributeNS("http://www.w3.org/XML/1998/namespace", "xml:lang", "fr-CA");
        doc_LangTest.appendChild(a);
        a.appendChild(b);
        Element x2 = doc_LangTest.createElementNS("", "x");
        Element x3 = doc_LangTest.createElementNS("", "x");
        Element x4 = doc_LangTest.createElementNS("", "x");
        a.appendChild(x4);
        b.appendChild(x2);
        b.appendChild(x3);
        x2.appendChild(doc_LangTest.createTextNode("2"));
        x3.appendChild(doc_LangTest.createTextNode("3"));
        x4.appendChild(doc_LangTest.createTextNode("4"));
        List result = xpath.selectNodes(doc_LangTest);
        assertEquals(0, result.size());
    }

    public void testLangFunctionSelectsNonEmptyNodeSet_LangTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        builder_LangTest = factory.newDocumentBuilder();
        doc_LangTest = builder_LangTest.newDocument();
        BaseXPath xpath = new DOMXPath("//*[lang(x)]");
        Element a = doc_LangTest.createElementNS("", "a");
        Element b = doc_LangTest.createElementNS("", "b");
        b.setAttributeNS("http://www.w3.org/XML/1998/namespace", "xml:lang", "fr-CA");
        doc_LangTest.appendChild(a);
        a.appendChild(b);
        Element x2 = doc_LangTest.createElementNS("", "x");
        Element x3 = doc_LangTest.createElementNS("", "x");
        Element x4 = doc_LangTest.createElementNS("", "x");
        a.appendChild(x4);
        b.appendChild(x2);
        b.appendChild(x3);
        x2.appendChild(doc_LangTest.createTextNode("fr"));
        x3.appendChild(doc_LangTest.createTextNode("3"));
        x4.appendChild(doc_LangTest.createTextNode("4"));
        List result = xpath.selectNodes(doc_LangTest);
        assertEquals(1, result.size());
        assertEquals(b, result.get(0));
    }

    public void testLangFunctionAppliedToNonElement_LangTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        builder_LangTest = factory.newDocumentBuilder();
        doc_LangTest = builder_LangTest.newDocument();
        BaseXPath xpath = new DOMXPath("//text()[lang('fr')]");
        Element a = doc_LangTest.createElementNS("", "a");
        Element b = doc_LangTest.createElementNS("", "b");
        b.setAttributeNS("http://www.w3.org/XML/1998/namespace", "xml:lang", "fr-CA");
        doc_LangTest.appendChild(a);
        a.appendChild(b);
        Element x2 = doc_LangTest.createElementNS("", "x");
        Element x3 = doc_LangTest.createElementNS("", "x");
        Element x4 = doc_LangTest.createElementNS("", "x");
        a.appendChild(x4);
        b.appendChild(x2);
        b.appendChild(x3);
        x2.appendChild(doc_LangTest.createTextNode("fr"));
        x3.appendChild(doc_LangTest.createTextNode("3"));
        x4.appendChild(doc_LangTest.createTextNode("4"));
        List result = xpath.selectNodes(doc_LangTest);
        assertEquals(2, result.size());
        assertEquals(x2.getFirstChild(), result.get(0));
        assertEquals(x3.getFirstChild(), result.get(1));
    }

    public void testLangFunctionAppliedToDocument_LangTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        builder_LangTest = factory.newDocumentBuilder();
        doc_LangTest = builder_LangTest.newDocument();
        BaseXPath xpath = new DOMXPath("lang('fr')");
        Element a = doc_LangTest.createElementNS("", "a");
        Element b = doc_LangTest.createElementNS("", "b");
        b.setAttributeNS("http://www.w3.org/XML/1998/namespace", "xml:lang", "fr-CA");
        doc_LangTest.appendChild(a);
        a.appendChild(b);
        Element x2 = doc_LangTest.createElementNS("", "x");
        Element x3 = doc_LangTest.createElementNS("", "x");
        Element x4 = doc_LangTest.createElementNS("", "x");
        a.appendChild(x4);
        b.appendChild(x2);
        b.appendChild(x3);
        x2.appendChild(doc_LangTest.createTextNode("fr"));
        x3.appendChild(doc_LangTest.createTextNode("3"));
        x4.appendChild(doc_LangTest.createTextNode("4"));
        Boolean result = (Boolean) xpath.evaluate(doc_LangTest);
        assertEquals(Boolean.FALSE, result);
    }

    public void testLangFunctionSelectsNumber_LangTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        builder_LangTest = factory.newDocumentBuilder();
        doc_LangTest = builder_LangTest.newDocument();
        BaseXPath xpath = new DOMXPath("//*[lang(3)]");
        Element a = doc_LangTest.createElementNS("", "a");
        Element b = doc_LangTest.createElementNS("", "b");
        b.setAttributeNS("http://www.w3.org/XML/1998/namespace", "xml:lang", "fr-CA");
        doc_LangTest.appendChild(a);
        a.appendChild(b);
        Element x2 = doc_LangTest.createElementNS("", "x");
        Element x3 = doc_LangTest.createElementNS("", "x");
        Element x4 = doc_LangTest.createElementNS("", "x");
        a.appendChild(x4);
        b.appendChild(x2);
        b.appendChild(x3);
        x2.appendChild(doc_LangTest.createTextNode("2"));
        x3.appendChild(doc_LangTest.createTextNode("3"));
        x4.appendChild(doc_LangTest.createTextNode("4"));
        List result = xpath.selectNodes(doc_LangTest);
        assertEquals(0, result.size());
    }

    public void testLangFunctionRequiresOneArgument_LangTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        builder_LangTest = factory.newDocumentBuilder();
        doc_LangTest = builder_LangTest.newDocument();
        try {
            BaseXPath xpath = new DOMXPath("lang()");
            org.w3c.dom.Element a = doc_LangTest.createElementNS("", "a");
            doc_LangTest.appendChild(a);
            xpath.selectNodes(doc_LangTest);
            fail("Allowed empty lang() function");
        } catch (FunctionCallException success) {
            assertNotNull(success.getMessage());
        }
    }

    public void testLangFunctionRequiresAtMostOneArgument_LangTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        builder_LangTest = factory.newDocumentBuilder();
        doc_LangTest = builder_LangTest.newDocument();
        try {
            BaseXPath xpath = new DOMXPath("lang('en', 'fr')");
            org.w3c.dom.Element a = doc_LangTest.createElementNS("", "a");
            doc_LangTest.appendChild(a);
            xpath.selectNodes(doc_LangTest);
            fail("Allowed empty lang() function");
        } catch (FunctionCallException success) {
            assertNotNull(success.getMessage());
        }
    }

    public void testLastFunction_LastTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc_LastTest = builder.newDocument();
        BaseXPath xpath = new DOMXPath("//x[position()=last()]");
        org.w3c.dom.Element a = doc_LastTest.createElementNS("", "a");
        org.w3c.dom.Element b = doc_LastTest.createElementNS("", "b");
        doc_LastTest.appendChild(a);
        a.appendChild(b);
        org.w3c.dom.Element x2 = doc_LastTest.createElementNS("", "x");
        org.w3c.dom.Element x3 = doc_LastTest.createElementNS("", "x");
        org.w3c.dom.Element x4 = doc_LastTest.createElementNS("", "x");
        a.appendChild(x4);
        b.appendChild(x2);
        b.appendChild(x3);
        x2.appendChild(doc_LastTest.createTextNode("2"));
        x3.appendChild(doc_LastTest.createTextNode("3"));
        x4.appendChild(doc_LastTest.createTextNode("4"));
        List result = xpath.selectNodes(doc_LastTest);
        assertEquals(2, result.size());
        assertEquals(x3, result.get(0));
        assertEquals(x4, result.get(1));
    }

    public void testLastFunctionAllowsNoArguments_LastTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc_LastTest = builder.newDocument();
        try {
            BaseXPath xpath = new DOMXPath("//x[position()=last(.)]");
            org.w3c.dom.Element a = doc_LastTest.createElementNS("", "a");
            org.w3c.dom.Element b = doc_LastTest.createElementNS("", "b");
            doc_LastTest.appendChild(a);
            a.appendChild(b);
            org.w3c.dom.Element x2 = doc_LastTest.createElementNS("", "x");
            org.w3c.dom.Element x3 = doc_LastTest.createElementNS("", "x");
            org.w3c.dom.Element x4 = doc_LastTest.createElementNS("", "x");
            a.appendChild(x4);
            b.appendChild(x2);
            b.appendChild(x3);
            x2.appendChild(doc_LastTest.createTextNode("2"));
            x3.appendChild(doc_LastTest.createTextNode("3"));
            x4.appendChild(doc_LastTest.createTextNode("4"));
            xpath.selectNodes(doc_LastTest);
            fail("last() function took arguments");
        } catch (FunctionCallException e) {
            assertEquals("last() requires no arguments.", e.getMessage());
        }
    }

    public void testStringLiteralContainsDoubleQuote_LiteralExprTest() throws JaxenException, ParserConfigurationException {
        DOMXPath xpath = new DOMXPath("'\"'");
        String expr = xpath.getRootExpr().getText();
        assertEquals("'\"'", expr);
    }

    public void testStringLiteralContainsSingleQuote_LiteralExprTest() throws JaxenException, ParserConfigurationException {
        DOMXPath xpath = new DOMXPath("\"'\"");
        String expr = xpath.getRootExpr().getText();
        assertEquals("\"'\"", expr);
    }

    public void testJaxen177_LiteralExprTest() throws JaxenException, ParserConfigurationException {
        BaseXPath baseXPath = new BaseXPath("//Name[@Attribute = '\"']", null);
        BaseXPath baseXPath2 = new BaseXPath(baseXPath.getRootExpr().getText(), null);
        assertEquals("/descendant-or-self::node()/child::Name[(attribute::Attribute = '\"')]", baseXPath2.getRootExpr().getText());
    }

    public void testLocalNameOfNumber_LocalNameTest() throws JaxenException, ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc_LocalNameTest = builder.parse("xml/basic.xml");
        try {
            XPath xpath = new DOMXPath("local-name(3)");
            xpath.selectNodes(doc_LocalNameTest);
            fail("local-name of non-node-set");
        } catch (FunctionCallException e) {
            assertEquals("The argument to the local-name function must be a node-set", e.getMessage());
        }
    }

    public void testLocalNameWithTwoArguments_LocalNameTest() throws JaxenException, ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc_LocalNameTest = builder.parse("xml/basic.xml");
        try {
            XPath xpath = new DOMXPath("local-name(/*, //*)");
            xpath.selectNodes(doc_LocalNameTest);
            fail("local-name with two arguments");
        } catch (FunctionCallException e) {
            assertEquals("local-name() requires zero or one argument.", e.getMessage());
        }
    }

    public void testLocalNameAllowsNoArguments_LocalNameTest() throws JaxenException, ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc_LocalNameTest = builder.parse("xml/basic.xml");
        XPath xpath = new DOMXPath("local-name()");
        String result = (String) xpath.evaluate(doc_LocalNameTest.getDocumentElement());
        assertEquals("foo", result);
    }

    public void testLocalNameOfCommentIsEmptyString_LocalNameTest() throws JaxenException, ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc_LocalNameTest = builder.parse("xml/basic.xml");
        XPath xpath = new DOMXPath("local-name(/comment())");
        Comment c = doc_LocalNameTest.createComment("test");
        doc_LocalNameTest.appendChild(c);
        String result = (String) xpath.evaluate(doc_LocalNameTest);
        assertEquals("", result);
    }

    public void testLocalNameOfEmptyNodeSetIsEmptyString_LocalNameTest() throws JaxenException, ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc_LocalNameTest = builder.parse("xml/basic.xml");
        XPath xpath = new DOMXPath("local-name(/aaa)");
        String result = (String) xpath.evaluate(doc_LocalNameTest);
        assertEquals("", result);
    }

    public void testLocalNameOfProcessingInstructionIsTarget_LocalNameTest() throws JaxenException, ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc_LocalNameTest = builder.parse("xml/basic.xml");
        XPath xpath = new DOMXPath("local-name(/processing-instruction())");
        ProcessingInstruction pi = doc_LocalNameTest.createProcessingInstruction("target", "value");
        doc_LocalNameTest.appendChild(pi);
        String result = (String) xpath.evaluate(doc_LocalNameTest);
        assertEquals("target", result);
    }

    public void testLocalNameOfAttribute_LocalNameTest() throws JaxenException, ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc_LocalNameTest = builder.parse("xml/basic.xml");
        XPath xpath = new DOMXPath("local-name(/*/@*)");
        Attr a = doc_LocalNameTest.createAttribute("name");
        doc_LocalNameTest.getDocumentElement().setAttributeNode(a);
        String result = (String) xpath.evaluate(doc_LocalNameTest);
        assertEquals("name", result);
    }

    public void testLocalNameOfTextIsEmptyString_LocalNameTest() throws JaxenException, ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc_LocalNameTest = builder.parse("xml/basic.xml");
        XPath xpath = new DOMXPath("local-name(/*/text())");
        org.w3c.dom.Text c = doc_LocalNameTest.createTextNode("test");
        doc_LocalNameTest.getDocumentElement().appendChild(c);
        String result = (String) xpath.evaluate(doc_LocalNameTest);
        assertEquals("", result);
    }

    public void testLocalNameOfNamespaceIsPrefix_LocalNameTest() throws JaxenException, ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc_LocalNameTest = builder.parse("xml/basic.xml");
        XPath xpath = new DOMXPath("local-name(/*/namespace::node())");
        String result = (String) xpath.evaluate(doc_LocalNameTest);
        assertEquals("xml", result);
    }

    public void testLocalNameNoArguments_LocalNameTest() throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc_LocalNameTest = builder.parse("xml/basic.xml");
        try {
            XPath xpath = new DOMXPath("local-name()");
            List results = xpath.selectNodes(doc_LocalNameTest);
            assertEquals("", results.get(0));
        } catch (Exception e) {
            e.printStackTrace();
            fail(e.getMessage());
        }
    }

    public void testModofNonIntegers_ModTest() throws JaxenException, ParserConfigurationException {
        DOMXPath xpath = new DOMXPath("5.5 mod 2.5");
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        org.w3c.dom.Document doc = factory.newDocumentBuilder().newDocument();
        Element root = doc.createElement("root");
        doc.appendChild(root);
        Double result = (Double) xpath.evaluate(doc);
        assertEquals(0.5, result.doubleValue(), 0.000001);
    }

    public void testMultipleNamespaceAxis_NamespaceTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        doc = factory.newDocumentBuilder().newDocument();
        Element root = doc.createElement("root");
        doc.appendChild(root);
        Element child = doc.createElementNS("http://www.example.org", "child");
        child.setAttributeNS("http://www.w3.org/2000/xmlns/", "xmlns:pre", "value");
        root.appendChild(child);
        XPath xpath = new DOMXPath("namespace::node()");
        List result = xpath.selectNodes(child);
        assertEquals(3, result.size());
    }

    public void testNumberOfNamespaceNodes_NamespaceTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        doc = factory.newDocumentBuilder().newDocument();
        Element root = doc.createElement("root");
        doc.appendChild(root);
        Element child = doc.createElementNS("http://www.example.org", "foo:child");
        root.appendChild(child);
        XPath xpath = new DOMXPath("//namespace::node()");
        List result = xpath.selectNodes(doc);
        assertEquals(3, result.size());
    }

    public void testNamespaceAxis_NamespaceTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        doc = factory.newDocumentBuilder().newDocument();
        Element root = doc.createElement("root");
        doc.appendChild(root);
        Element child = doc.createElementNS("http://www.example.org", "foo:child");
        root.appendChild(child);
        XPath xpath = new DOMXPath("namespace::node()");
        List result = xpath.selectNodes(child);
        assertEquals(2, result.size());
    }

    public void testUnprefixedNamespaceAxis_NamespaceTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        doc = factory.newDocumentBuilder().newDocument();
        Element root = doc.createElement("root");
        doc.appendChild(root);
        Element child = doc.createElementNS("http://www.example.org", "child");
        root.appendChild(child);
        XPath xpath = new DOMXPath("namespace::node()");
        List result = xpath.selectNodes(child);
        assertEquals(2, result.size());
    }

    public void testNamespaceNodesReadFromAttributes_NamespaceTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        doc = factory.newDocumentBuilder().newDocument();
        Element root = doc.createElement("root");
        doc.appendChild(root);
        Attr a = doc.createAttributeNS("http://www.example.org/", "a");
        a.setNodeValue("value");
        root.setAttributeNode(a);
        XPath xpath = new DOMXPath("namespace::node()");
        List result = xpath.selectNodes(root);
        assertEquals(2, result.size());
    }

    public void testUnboundNamespaceUsedInXPathExpression_NamespaceTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        doc = factory.newDocumentBuilder().newDocument();
        Element root = doc.createElementNS("http://www.example.org/", "root");
        doc.appendChild(root);
        XPath xpath = new DOMXPath("/pre:root");
        try {
            xpath.selectNodes(root);
            fail("Used unresolvable prefix");
        } catch (UnresolvableException ex) {
            assertNotNull(ex.getMessage());
        }
    }

    public void testQueryDefaultNamespace_NamespaceTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        doc = factory.newDocumentBuilder().newDocument();
        Element root = doc.createElementNS("http://www.example.org/", "root");
        doc.appendChild(root);
        XPath xpath = new DOMXPath("/pre:root");
        xpath.addNamespace("pre", "http://www.example.org/");
        List result = xpath.selectNodes(root);
        assertEquals(1, result.size());
    }

    public void testQueryDefaultNamespaceWithContext_NamespaceTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        doc = factory.newDocumentBuilder().newDocument();
        Element root = doc.createElementNS("http://www.example.org/", "root");
        doc.appendChild(root);
        XPath xpath = new DOMXPath("/pre:root");
        SimpleNamespaceContext context = new SimpleNamespaceContext();
        context.addNamespace("pre", "http://www.example.org/");
        xpath.setNamespaceContext(context);
        List result = xpath.selectNodes(root);
        assertEquals(1, result.size());
    }

    public void testNamespaceURIOfNumber_NamespaceURITest() throws JaxenException, ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        builder_NamespaceURITest = factory.newDocumentBuilder();
        doc_NamespaceURITest = builder_NamespaceURITest.parse("xml/basic.xml");
        try {
            XPath xpath = new DOMXPath("namespace-uri(3)");
            xpath.selectNodes(doc_NamespaceURITest);
            fail("namespace-uri of non-node-set");
        } catch (FunctionCallException e) {
            assertEquals("The argument to the namespace-uri function must be a node-set", e.getMessage());
        }
    }

    public void testNamespaceURINoArguments_NamespaceURITest() throws JaxenException, ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        builder_NamespaceURITest = factory.newDocumentBuilder();
        doc_NamespaceURITest = builder_NamespaceURITest.parse("xml/basic.xml");
        XPath xpath = new DOMXPath("namespace-uri()");
        List results = xpath.selectNodes(doc_NamespaceURITest);
        assertEquals("", results.get(0));
    }

    public void testNamespaceURIOfEmptyNodeSetIsEmptyString_NamespaceURITest() throws JaxenException, ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        builder_NamespaceURITest = factory.newDocumentBuilder();
        doc_NamespaceURITest = builder_NamespaceURITest.parse("xml/basic.xml");
        XPath xpath = new DOMXPath("namespace-uri(/aaa)");
        String result = (String) xpath.evaluate(doc_NamespaceURITest);
        assertEquals("", result);
    }

    public void testNamespaceURIOfProcessingInstructionIsEmptyString_NamespaceURITest() throws JaxenException, ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        builder_NamespaceURITest = factory.newDocumentBuilder();
        doc_NamespaceURITest = builder_NamespaceURITest.parse("xml/basic.xml");
        XPath xpath = new DOMXPath("namespace-uri(/processing-instruction())");
        ProcessingInstruction pi = doc_NamespaceURITest.createProcessingInstruction("target", "value");
        doc_NamespaceURITest.appendChild(pi);
        String result = (String) xpath.evaluate(doc_NamespaceURITest);
        assertEquals("", result);
    }

    public void testNamespaceURIOfAttribute_NamespaceURITest() throws JaxenException, ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        builder_NamespaceURITest = factory.newDocumentBuilder();
        doc_NamespaceURITest = builder_NamespaceURITest.parse("xml/basic.xml");
        XPath xpath = new DOMXPath("namespace-uri(/*/@*)");
        Attr a = doc_NamespaceURITest.createAttribute("name");
        doc_NamespaceURITest.getDocumentElement().setAttributeNode(a);
        Object result = xpath.evaluate(doc_NamespaceURITest);
        assertEquals("", result);
    }

    public void testNamespaceURIOfAttributeInNamespace_NamespaceURITest() throws JaxenException, ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        builder_NamespaceURITest = factory.newDocumentBuilder();
        doc_NamespaceURITest = builder_NamespaceURITest.parse("xml/basic.xml");
        XPath xpath = new DOMXPath("namespace-uri(/*/@*)");
        Attr a = doc_NamespaceURITest.createAttributeNS("http://www.w3.org/", "pre:name");
        doc_NamespaceURITest.getDocumentElement().setAttributeNode(a);
        Object result = xpath.evaluate(doc_NamespaceURITest);
        assertEquals("http://www.w3.org/", result);
    }

    public void testNamespaceURIOfTextIsEmptyString_NamespaceURITest() throws JaxenException, ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        builder_NamespaceURITest = factory.newDocumentBuilder();
        doc_NamespaceURITest = builder_NamespaceURITest.parse("xml/basic.xml");
        XPath xpath = new DOMXPath("namespace-uri(/*/text())");
        org.w3c.dom.Text c = doc_NamespaceURITest.createTextNode("test");
        doc_NamespaceURITest.getDocumentElement().appendChild(c);
        String result = (String) xpath.evaluate(doc_NamespaceURITest);
        assertEquals("", result);
    }

    public void testNamespaceURIRequiresAtMostOneArgument_NamespaceURITest() throws JaxenException, ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        builder_NamespaceURITest = factory.newDocumentBuilder();
        doc_NamespaceURITest = builder_NamespaceURITest.parse("xml/basic.xml");
        XPath xpath = new DOMXPath("namespace-uri(/*, /*)");
        try {
            xpath.evaluate(doc_NamespaceURITest);
            fail("Allowed namespace-uri function with no arguments");
        } catch (FunctionCallException ex) {
            assertNotNull(ex.getMessage());
        }
    }

    public void testNamespaceURIOfNamespaceIsNull_NamespaceURITest() throws JaxenException, ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        builder_NamespaceURITest = factory.newDocumentBuilder();
        doc_NamespaceURITest = builder_NamespaceURITest.parse("xml/basic.xml");
        XPath xpath = new DOMXPath("namespace-uri(/*/namespace::node())");
        String result = (String) xpath.evaluate(doc_NamespaceURITest);
        assertEquals("", result);
    }

    public void testNamespaceURIOfComment_NamespaceURITest() throws JaxenException, ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        builder_NamespaceURITest = factory.newDocumentBuilder();
        doc_NamespaceURITest = builder_NamespaceURITest.parse("xml/basic.xml");
        XPath xpath = new DOMXPath("namespace-uri(/a/comment())");
        org.w3c.dom.Document document = builder_NamespaceURITest.getDOMImplementation().createDocument(null, "a", null);
        document.getDocumentElement().appendChild(document.createComment("data"));
        String result = (String) xpath.evaluate(document);
        assertEquals("", result);
    }

    public void testNameOfNumber_NameTest() throws JaxenException, ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc_NameTest = builder.parse("xml/basic.xml");
        try {
            XPath xpath = new DOMXPath("name(3)");
            xpath.selectNodes(doc_NameTest);
            fail("name of non-node-set");
        } catch (FunctionCallException e) {
            assertEquals("The argument to the name function must be a node-set", e.getMessage());
        }
    }

    public void testNameWithTwoArguments_NameTest() throws JaxenException, ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc_NameTest = builder.parse("xml/basic.xml");
        try {
            XPath xpath = new DOMXPath("name(/*, //*)");
            xpath.selectNodes(doc_NameTest);
            fail("name with two arguments");
        } catch (FunctionCallException e) {
            assertEquals("name() requires zero or one argument.", e.getMessage());
        }
    }

    public void testNameAllowsNoArguments_NameTest() throws JaxenException, ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc_NameTest = builder.parse("xml/basic.xml");
        XPath xpath = new DOMXPath("name()");
        String result = (String) xpath.evaluate(doc_NameTest.getDocumentElement());
        assertEquals("foo", result);
    }

    public void testNameOfCommentIsEmptyString_NameTest() throws JaxenException, ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc_NameTest = builder.parse("xml/basic.xml");
        XPath xpath = new DOMXPath("name(/comment())");
        Comment c = doc_NameTest.createComment("test");
        doc_NameTest.appendChild(c);
        String result = (String) xpath.evaluate(doc_NameTest);
        assertEquals("", result);
    }

    public void testNameOfProcessingInstructionIsTarget_NameTest() throws JaxenException, ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc_NameTest = builder.parse("xml/basic.xml");
        XPath xpath = new DOMXPath("name(/processing-instruction())");
        ProcessingInstruction pi = doc_NameTest.createProcessingInstruction("target", "value");
        doc_NameTest.appendChild(pi);
        String result = (String) xpath.evaluate(doc_NameTest);
        assertEquals("target", result);
    }

    public void testNameOfAttribute_NameTest() throws JaxenException, ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc_NameTest = builder.parse("xml/basic.xml");
        XPath xpath = new DOMXPath("name(/*/@*)");
        Attr a = doc_NameTest.createAttribute("name");
        doc_NameTest.getDocumentElement().setAttributeNode(a);
        String result = (String) xpath.evaluate(doc_NameTest);
        assertEquals("name", result);
    }

    public void testNameOfTextIsEmptyString_NameTest() throws JaxenException, ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc_NameTest = builder.parse("xml/basic.xml");
        XPath xpath = new DOMXPath("name(/*/text())");
        org.w3c.dom.Text c = doc_NameTest.createTextNode("test");
        doc_NameTest.getDocumentElement().appendChild(c);
        String result = (String) xpath.evaluate(doc_NameTest);
        assertEquals("", result);
    }

    public void testNameOfNamespaceIsPrefix_NameTest() throws JaxenException, ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc_NameTest = builder.parse("xml/basic.xml");
        XPath xpath = new DOMXPath("name(/*/namespace::node())");
        String result = (String) xpath.evaluate(doc_NameTest);
        assertEquals("xml", result);
    }

    public void testNameNoArguments_NameTest() throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc_NameTest = builder.parse("xml/basic.xml");
        try {
            XPath xpath = new DOMXPath("name()");
            List results = xpath.selectNodes(doc_NameTest);
            assertEquals("", results.get(0));
        } catch (Exception e) {
            e.printStackTrace();
            fail(e.getMessage());
        }
    }

    public void testEqualsTwoNodesets_NodesetEqualityTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc_NodesetEqualityTest = builder.newDocument();
        Element a = doc_NodesetEqualityTest.createElementNS("", "a");
        doc_NodesetEqualityTest.appendChild(a);
        Element b1 = doc_NodesetEqualityTest.createElementNS("", "b");
        b1.appendChild(doc_NodesetEqualityTest.createTextNode("foo"));
        Element b2 = doc_NodesetEqualityTest.createElementNS("", "b");
        b2.appendChild(doc_NodesetEqualityTest.createTextNode("bar"));
        Element b3 = doc_NodesetEqualityTest.createElementNS("", "b");
        b3.appendChild(doc_NodesetEqualityTest.createTextNode("blort"));
        a.appendChild(b1);
        a.appendChild(b2);
        a.appendChild(b3);
        Element c1 = doc_NodesetEqualityTest.createElementNS("", "c");
        Element c2 = doc_NodesetEqualityTest.createElementNS("", "c");
        Element c3 = doc_NodesetEqualityTest.createElementNS("", "c");
        c2.appendChild(doc_NodesetEqualityTest.createTextNode(" 12.0 "));
        c3.appendChild(doc_NodesetEqualityTest.createTextNode("bar"));
        a.appendChild(c1);
        a.appendChild(c2);
        a.appendChild(c3);
        XPath xpath = new DOMXPath("//b = //c");
        Boolean result = (Boolean) xpath.evaluate(doc_NodesetEqualityTest);
        assertTrue(result.booleanValue());
    }

    public void testNotEqualsTwoNodesets_NodesetEqualityTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc_NodesetEqualityTest = builder.newDocument();
        Element a = doc_NodesetEqualityTest.createElementNS("", "a");
        doc_NodesetEqualityTest.appendChild(a);
        Element b1 = doc_NodesetEqualityTest.createElementNS("", "b");
        b1.appendChild(doc_NodesetEqualityTest.createTextNode("foo"));
        Element b2 = doc_NodesetEqualityTest.createElementNS("", "b");
        b2.appendChild(doc_NodesetEqualityTest.createTextNode("bar"));
        Element b3 = doc_NodesetEqualityTest.createElementNS("", "b");
        b3.appendChild(doc_NodesetEqualityTest.createTextNode("blort"));
        a.appendChild(b1);
        a.appendChild(b2);
        a.appendChild(b3);
        Element c1 = doc_NodesetEqualityTest.createElementNS("", "c");
        Element c2 = doc_NodesetEqualityTest.createElementNS("", "c");
        Element c3 = doc_NodesetEqualityTest.createElementNS("", "c");
        c2.appendChild(doc_NodesetEqualityTest.createTextNode(" 12.0 "));
        c3.appendChild(doc_NodesetEqualityTest.createTextNode("bar"));
        a.appendChild(c1);
        a.appendChild(c2);
        a.appendChild(c3);
        XPath xpath = new DOMXPath("//a != //b");
        Boolean result = (Boolean) xpath.evaluate(doc_NodesetEqualityTest);
        assertTrue(result.booleanValue());
    }

    public void testEqualsStringNodeset_NodesetEqualityTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc_NodesetEqualityTest = builder.newDocument();
        Element a = doc_NodesetEqualityTest.createElementNS("", "a");
        doc_NodesetEqualityTest.appendChild(a);
        Element b1 = doc_NodesetEqualityTest.createElementNS("", "b");
        b1.appendChild(doc_NodesetEqualityTest.createTextNode("foo"));
        Element b2 = doc_NodesetEqualityTest.createElementNS("", "b");
        b2.appendChild(doc_NodesetEqualityTest.createTextNode("bar"));
        Element b3 = doc_NodesetEqualityTest.createElementNS("", "b");
        b3.appendChild(doc_NodesetEqualityTest.createTextNode("blort"));
        a.appendChild(b1);
        a.appendChild(b2);
        a.appendChild(b3);
        Element c1 = doc_NodesetEqualityTest.createElementNS("", "c");
        Element c2 = doc_NodesetEqualityTest.createElementNS("", "c");
        Element c3 = doc_NodesetEqualityTest.createElementNS("", "c");
        c2.appendChild(doc_NodesetEqualityTest.createTextNode(" 12.0 "));
        c3.appendChild(doc_NodesetEqualityTest.createTextNode("bar"));
        a.appendChild(c1);
        a.appendChild(c2);
        a.appendChild(c3);
        XPath xpath = new DOMXPath("//b = 'blort'");
        Boolean result = (Boolean) xpath.evaluate(doc_NodesetEqualityTest);
        assertTrue(result.booleanValue());
    }

    public void testNotEqualsStringNodeset_NodesetEqualityTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc_NodesetEqualityTest = builder.newDocument();
        Element a = doc_NodesetEqualityTest.createElementNS("", "a");
        doc_NodesetEqualityTest.appendChild(a);
        Element b1 = doc_NodesetEqualityTest.createElementNS("", "b");
        b1.appendChild(doc_NodesetEqualityTest.createTextNode("foo"));
        Element b2 = doc_NodesetEqualityTest.createElementNS("", "b");
        b2.appendChild(doc_NodesetEqualityTest.createTextNode("bar"));
        Element b3 = doc_NodesetEqualityTest.createElementNS("", "b");
        b3.appendChild(doc_NodesetEqualityTest.createTextNode("blort"));
        a.appendChild(b1);
        a.appendChild(b2);
        a.appendChild(b3);
        Element c1 = doc_NodesetEqualityTest.createElementNS("", "c");
        Element c2 = doc_NodesetEqualityTest.createElementNS("", "c");
        Element c3 = doc_NodesetEqualityTest.createElementNS("", "c");
        c2.appendChild(doc_NodesetEqualityTest.createTextNode(" 12.0 "));
        c3.appendChild(doc_NodesetEqualityTest.createTextNode("bar"));
        a.appendChild(c1);
        a.appendChild(c2);
        a.appendChild(c3);
        XPath xpath = new DOMXPath("//b != 'phooey'");
        Boolean result = (Boolean) xpath.evaluate(doc_NodesetEqualityTest);
        assertTrue(result.booleanValue());
    }

    public void testEqualsNumberNodeset_NodesetEqualityTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc_NodesetEqualityTest = builder.newDocument();
        Element a = doc_NodesetEqualityTest.createElementNS("", "a");
        doc_NodesetEqualityTest.appendChild(a);
        Element b1 = doc_NodesetEqualityTest.createElementNS("", "b");
        b1.appendChild(doc_NodesetEqualityTest.createTextNode("foo"));
        Element b2 = doc_NodesetEqualityTest.createElementNS("", "b");
        b2.appendChild(doc_NodesetEqualityTest.createTextNode("bar"));
        Element b3 = doc_NodesetEqualityTest.createElementNS("", "b");
        b3.appendChild(doc_NodesetEqualityTest.createTextNode("blort"));
        a.appendChild(b1);
        a.appendChild(b2);
        a.appendChild(b3);
        Element c1 = doc_NodesetEqualityTest.createElementNS("", "c");
        Element c2 = doc_NodesetEqualityTest.createElementNS("", "c");
        Element c3 = doc_NodesetEqualityTest.createElementNS("", "c");
        c2.appendChild(doc_NodesetEqualityTest.createTextNode(" 12.0 "));
        c3.appendChild(doc_NodesetEqualityTest.createTextNode("bar"));
        a.appendChild(c1);
        a.appendChild(c2);
        a.appendChild(c3);
        XPath xpath = new DOMXPath("//c = 12");
        Boolean result = (Boolean) xpath.evaluate(doc_NodesetEqualityTest);
        assertTrue(result.booleanValue());
    }

    public void testNotEqualsNumberNodeset_NodesetEqualityTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc_NodesetEqualityTest = builder.newDocument();
        Element a = doc_NodesetEqualityTest.createElementNS("", "a");
        doc_NodesetEqualityTest.appendChild(a);
        Element b1 = doc_NodesetEqualityTest.createElementNS("", "b");
        b1.appendChild(doc_NodesetEqualityTest.createTextNode("foo"));
        Element b2 = doc_NodesetEqualityTest.createElementNS("", "b");
        b2.appendChild(doc_NodesetEqualityTest.createTextNode("bar"));
        Element b3 = doc_NodesetEqualityTest.createElementNS("", "b");
        b3.appendChild(doc_NodesetEqualityTest.createTextNode("blort"));
        a.appendChild(b1);
        a.appendChild(b2);
        a.appendChild(b3);
        Element c1 = doc_NodesetEqualityTest.createElementNS("", "c");
        Element c2 = doc_NodesetEqualityTest.createElementNS("", "c");
        Element c3 = doc_NodesetEqualityTest.createElementNS("", "c");
        c2.appendChild(doc_NodesetEqualityTest.createTextNode(" 12.0 "));
        c3.appendChild(doc_NodesetEqualityTest.createTextNode("bar"));
        a.appendChild(c1);
        a.appendChild(c2);
        a.appendChild(c3);
        XPath xpath = new DOMXPath("//c != 256");
        Boolean result = (Boolean) xpath.evaluate(doc_NodesetEqualityTest);
        assertTrue(result.booleanValue());
    }

    public void testEqualsBooleanNodeset1_NodesetEqualityTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc_NodesetEqualityTest = builder.newDocument();
        Element a = doc_NodesetEqualityTest.createElementNS("", "a");
        doc_NodesetEqualityTest.appendChild(a);
        Element b1 = doc_NodesetEqualityTest.createElementNS("", "b");
        b1.appendChild(doc_NodesetEqualityTest.createTextNode("foo"));
        Element b2 = doc_NodesetEqualityTest.createElementNS("", "b");
        b2.appendChild(doc_NodesetEqualityTest.createTextNode("bar"));
        Element b3 = doc_NodesetEqualityTest.createElementNS("", "b");
        b3.appendChild(doc_NodesetEqualityTest.createTextNode("blort"));
        a.appendChild(b1);
        a.appendChild(b2);
        a.appendChild(b3);
        Element c1 = doc_NodesetEqualityTest.createElementNS("", "c");
        Element c2 = doc_NodesetEqualityTest.createElementNS("", "c");
        Element c3 = doc_NodesetEqualityTest.createElementNS("", "c");
        c2.appendChild(doc_NodesetEqualityTest.createTextNode(" 12.0 "));
        c3.appendChild(doc_NodesetEqualityTest.createTextNode("bar"));
        a.appendChild(c1);
        a.appendChild(c2);
        a.appendChild(c3);
        XPath xpath = new DOMXPath("//c = true()");
        Boolean result = (Boolean) xpath.evaluate(doc_NodesetEqualityTest);
        assertTrue(result.booleanValue());
    }

    public void testEqualsBooleanNodeset2_NodesetEqualityTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc_NodesetEqualityTest = builder.newDocument();
        Element a = doc_NodesetEqualityTest.createElementNS("", "a");
        doc_NodesetEqualityTest.appendChild(a);
        Element b1 = doc_NodesetEqualityTest.createElementNS("", "b");
        b1.appendChild(doc_NodesetEqualityTest.createTextNode("foo"));
        Element b2 = doc_NodesetEqualityTest.createElementNS("", "b");
        b2.appendChild(doc_NodesetEqualityTest.createTextNode("bar"));
        Element b3 = doc_NodesetEqualityTest.createElementNS("", "b");
        b3.appendChild(doc_NodesetEqualityTest.createTextNode("blort"));
        a.appendChild(b1);
        a.appendChild(b2);
        a.appendChild(b3);
        Element c1 = doc_NodesetEqualityTest.createElementNS("", "c");
        Element c2 = doc_NodesetEqualityTest.createElementNS("", "c");
        Element c3 = doc_NodesetEqualityTest.createElementNS("", "c");
        c2.appendChild(doc_NodesetEqualityTest.createTextNode(" 12.0 "));
        c3.appendChild(doc_NodesetEqualityTest.createTextNode("bar"));
        a.appendChild(c1);
        a.appendChild(c2);
        a.appendChild(c3);
        XPath xpath = new DOMXPath("//d = false()");
        Boolean result = (Boolean) xpath.evaluate(doc_NodesetEqualityTest);
        assertTrue(result.booleanValue());
    }

    public void testNotEqualsBooleanNodeset1_NodesetEqualityTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc_NodesetEqualityTest = builder.newDocument();
        Element a = doc_NodesetEqualityTest.createElementNS("", "a");
        doc_NodesetEqualityTest.appendChild(a);
        Element b1 = doc_NodesetEqualityTest.createElementNS("", "b");
        b1.appendChild(doc_NodesetEqualityTest.createTextNode("foo"));
        Element b2 = doc_NodesetEqualityTest.createElementNS("", "b");
        b2.appendChild(doc_NodesetEqualityTest.createTextNode("bar"));
        Element b3 = doc_NodesetEqualityTest.createElementNS("", "b");
        b3.appendChild(doc_NodesetEqualityTest.createTextNode("blort"));
        a.appendChild(b1);
        a.appendChild(b2);
        a.appendChild(b3);
        Element c1 = doc_NodesetEqualityTest.createElementNS("", "c");
        Element c2 = doc_NodesetEqualityTest.createElementNS("", "c");
        Element c3 = doc_NodesetEqualityTest.createElementNS("", "c");
        c2.appendChild(doc_NodesetEqualityTest.createTextNode(" 12.0 "));
        c3.appendChild(doc_NodesetEqualityTest.createTextNode("bar"));
        a.appendChild(c1);
        a.appendChild(c2);
        a.appendChild(c3);
        XPath xpath = new DOMXPath("//c != false()");
        Boolean result = (Boolean) xpath.evaluate(doc_NodesetEqualityTest);
        assertTrue(result.booleanValue());
    }

    public void testNotEqualsBooleanNodeset2_NodesetEqualityTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc_NodesetEqualityTest = builder.newDocument();
        Element a = doc_NodesetEqualityTest.createElementNS("", "a");
        doc_NodesetEqualityTest.appendChild(a);
        Element b1 = doc_NodesetEqualityTest.createElementNS("", "b");
        b1.appendChild(doc_NodesetEqualityTest.createTextNode("foo"));
        Element b2 = doc_NodesetEqualityTest.createElementNS("", "b");
        b2.appendChild(doc_NodesetEqualityTest.createTextNode("bar"));
        Element b3 = doc_NodesetEqualityTest.createElementNS("", "b");
        b3.appendChild(doc_NodesetEqualityTest.createTextNode("blort"));
        a.appendChild(b1);
        a.appendChild(b2);
        a.appendChild(b3);
        Element c1 = doc_NodesetEqualityTest.createElementNS("", "c");
        Element c2 = doc_NodesetEqualityTest.createElementNS("", "c");
        Element c3 = doc_NodesetEqualityTest.createElementNS("", "c");
        c2.appendChild(doc_NodesetEqualityTest.createTextNode(" 12.0 "));
        c3.appendChild(doc_NodesetEqualityTest.createTextNode("bar"));
        a.appendChild(c1);
        a.appendChild(c2);
        a.appendChild(c3);
        XPath xpath = new DOMXPath("//d != true()");
        Boolean result = (Boolean) xpath.evaluate(doc_NodesetEqualityTest);
        assertTrue(result.booleanValue());
    }

    public void testNormalizeSpaceUsesXMLSpaceRulesNotJavaRules_NormalizeSpaceTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc_NormalizeSpaceTest = builder.newDocument();
        doc_NormalizeSpaceTest.appendChild(doc_NormalizeSpaceTest.createElement("root"));
        String data = "?X?";
        XPath xpath = new DOMXPath("normalize-space('" + data + "')");
        String result = (String) xpath.evaluate(doc_NormalizeSpaceTest);
        assertEquals(data, result);
    }

    public void testNormalizeSpaceUsesXMLSpaceRulesNotJavaRules2_NormalizeSpaceTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc_NormalizeSpaceTest = builder.newDocument();
        doc_NormalizeSpaceTest.appendChild(doc_NormalizeSpaceTest.createElement("root"));
        String data = "?X?";
        XPath xpath = new DOMXPath("normalize-space(' " + data + " ')");
        String result = (String) xpath.evaluate(doc_NormalizeSpaceTest);
        assertEquals(data, result);
    }

    public void testNormalizeSpaceInContextNode_NormalizeSpaceTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc_NormalizeSpaceTest = builder.newDocument();
        doc_NormalizeSpaceTest.appendChild(doc_NormalizeSpaceTest.createElement("root"));
        XPath xpath = new DOMXPath("normalize-space()");
        String result = (String) xpath.evaluate(doc_NormalizeSpaceTest);
        assertEquals("", result);
    }

    public void testNormalizeSpaceRequiresAtMostOneArguments_NormalizeSpaceTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc_NormalizeSpaceTest = builder.newDocument();
        doc_NormalizeSpaceTest.appendChild(doc_NormalizeSpaceTest.createElement("root"));
        BaseXPath xpath = new DOMXPath("normalize-space('a', 'a')");
        try {
            xpath.selectNodes(doc_NormalizeSpaceTest);
            fail("Allowed normalize-space function with two arguments");
        } catch (FunctionCallException ex) {
            assertNotNull(ex.getMessage());
        }
    }

    public void testZeroIsFalse_NotTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc_NotTest = builder.newDocument();
        doc_NotTest.appendChild(doc_NotTest.createElement("root"));
        BaseXPath xpath = new DOMXPath("not(0)");
        List result = xpath.selectNodes(doc_NotTest);
        assertEquals(1, result.size());
        assertEquals(Boolean.TRUE, result.get(0));
    }

    public void testOneIsTrue_NotTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc_NotTest = builder.newDocument();
        doc_NotTest.appendChild(doc_NotTest.createElement("root"));
        BaseXPath xpath = new DOMXPath("not(1)");
        List result = xpath.selectNodes(doc_NotTest);
        assertEquals(1, result.size());
        assertEquals(Boolean.FALSE, result.get(0));
    }

    public void testEmptyStringIsFalse_NotTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc_NotTest = builder.newDocument();
        doc_NotTest.appendChild(doc_NotTest.createElement("root"));
        BaseXPath xpath = new DOMXPath("not('')");
        List result = xpath.selectNodes(doc_NotTest);
        assertEquals(1, result.size());
        assertEquals(Boolean.TRUE, result.get(0));
    }

    public void testNaNIsFalse_NotTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc_NotTest = builder.newDocument();
        doc_NotTest.appendChild(doc_NotTest.createElement("root"));
        BaseXPath xpath = new DOMXPath("not(0 div 0)");
        Object result = xpath.evaluate(null);
        assertEquals(Boolean.TRUE, result);
    }

    public void testNonEmptyStringIsTrue_NotTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc_NotTest = builder.newDocument();
        doc_NotTest.appendChild(doc_NotTest.createElement("root"));
        BaseXPath xpath = new DOMXPath("not('false')");
        List result = xpath.selectNodes(doc_NotTest);
        assertEquals(1, result.size());
        assertEquals(Boolean.FALSE, result.get(0));
    }

    public void testNotFunctionRequiresOneArgument_NotTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc_NotTest = builder.newDocument();
        doc_NotTest.appendChild(doc_NotTest.createElement("root"));
        BaseXPath xpath = new DOMXPath("not()");
        try {
            xpath.selectNodes(doc_NotTest);
            fail("Allowed not() function with no arguments");
        } catch (FunctionCallException ex) {
            assertNotNull(ex.getMessage());
        }
    }

    public void testNotFunctionRequiresExactlyOneArgument_NotTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc_NotTest = builder.newDocument();
        doc_NotTest.appendChild(doc_NotTest.createElement("root"));
        BaseXPath xpath = new DOMXPath("not('', '')");
        try {
            xpath.selectNodes(doc_NotTest);
            fail("Allowed not() function with two arguments");
        } catch (FunctionCallException ex) {
            assertNotNull(ex.getMessage());
        }
    }

    public void testNumberFunctionOperatesOnFirstNodeInDocumentOrder_NumberTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc_NumberTest = builder.newDocument();
        XPath xpath = new DOMXPath("number(//x)");
        org.w3c.dom.Element a = doc_NumberTest.createElementNS("", "a");
        org.w3c.dom.Element b = doc_NumberTest.createElementNS("", "b");
        doc_NumberTest.appendChild(a);
        a.appendChild(b);
        org.w3c.dom.Element x2 = doc_NumberTest.createElementNS("", "x");
        org.w3c.dom.Element x3 = doc_NumberTest.createElementNS("", "x");
        org.w3c.dom.Element x4 = doc_NumberTest.createElementNS("", "x");
        a.appendChild(x4);
        b.appendChild(x2);
        b.appendChild(x3);
        x2.appendChild(doc_NumberTest.createTextNode("2"));
        x3.appendChild(doc_NumberTest.createTextNode("3"));
        x4.appendChild(doc_NumberTest.createTextNode("4"));
        List result = xpath.selectNodes(doc_NumberTest);
        assertEquals(1, result.size());
        assertEquals(Double.valueOf("2.0"), result.get(0));
    }

    public void testNumberFunctionOperatesOnContextNode_NumberTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc_NumberTest = builder.newDocument();
        XPath xpath = new DOMXPath("number()");
        org.w3c.dom.Element a = doc_NumberTest.createElementNS("", "a");
        doc_NumberTest.appendChild(a);
        a.appendChild(doc_NumberTest.createTextNode("2"));
        Double result = (Double) xpath.evaluate(doc_NumberTest);
        assertEquals(2, result.intValue());
    }

    public void testNumberFunctionRequiresAtMostOneArgument_NumberTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc_NumberTest = builder.newDocument();
        XPath xpath = new DOMXPath("number('2.2', '1.2')");
        try {
            xpath.selectNodes(doc_NumberTest);
            fail("Allowed number function with two arguments");
        } catch (FunctionCallException ex) {
            assertNotNull(ex.getMessage());
        }
    }

    public void testNumberFunctionAppliedToNonNumericString_NumberTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc_NumberTest = builder.newDocument();
        XPath xpath = new DOMXPath("number('Marx')");
        Double result = (Double) xpath.evaluate(doc_NumberTest);
        assertEquals(new Double(Double.NaN), result);
    }

    public void testIsNan_NumberTest() throws ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc_NumberTest = builder.newDocument();
        assertTrue(NumberFunction.isNaN(0.0 / 0.0));
    }

    public void testValidPaths_PatternHandlerTest() throws JaxenException, SAXPathException {
        for (int i = 0; i < paths2.length; i++) {
            String path = paths2[i];
            PatternParser.parse(path);
        }
    }

    public void testBogusPaths_PatternHandlerTest() throws JaxenException, SAXPathException {
        for (int i = 0; i < bogusPaths2.length; i++) {
            String path = bogusPaths2[i];
            try {
                Pattern pattern = PatternParser.parse(path);
                fail("Parsed bogus path as: " + pattern);
            } catch (XPathSyntaxException e) {
            }
        }
    }

    public void testPositionOfNumber_PositionTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc_PositionTest = builder.newDocument();
        doc_PositionTest.appendChild(doc_PositionTest.createElement("root"));
        try {
            XPath xpath = new DOMXPath("position(3)");
            xpath.selectNodes(doc_PositionTest);
            fail("position() function took arguments");
        } catch (FunctionCallException e) {
            assertEquals("position() does not take any arguments.", e.getMessage());
        }
    }

    public void testNoInfiniteLoops_PrecedingAxisIteratorTest() throws ParserConfigurationException, UnsupportedAxisException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        org.w3c.dom.Document doc = factory.newDocumentBuilder().newDocument();
        doc.appendChild(doc.createElement("root"));
        iterator_PrecedingAxisIteratorTest = new PrecedingAxisIterator(doc, new org.jaxen.dom.DocumentNavigator());
        try {
            iterator_PrecedingAxisIteratorTest.next();
            fail("Iterated too far");
        } catch (NoSuchElementException ex) {
            pass_PrecedingAxisIteratorTest();
        }
    }

    private void pass_PrecedingAxisIteratorTest() throws ParserConfigurationException, UnsupportedAxisException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        org.w3c.dom.Document doc = factory.newDocumentBuilder().newDocument();
        doc.appendChild(doc.createElement("root"));
        iterator_PrecedingAxisIteratorTest = new PrecedingAxisIterator(doc, new org.jaxen.dom.DocumentNavigator());
    }

    public void testRemove_PrecedingAxisIteratorTest() throws ParserConfigurationException, UnsupportedAxisException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        org.w3c.dom.Document doc = factory.newDocumentBuilder().newDocument();
        doc.appendChild(doc.createElement("root"));
        iterator_PrecedingAxisIteratorTest = new PrecedingAxisIterator(doc, new org.jaxen.dom.DocumentNavigator());
        try {
            iterator_PrecedingAxisIteratorTest.remove();
            fail("Removed from descendant axis iterator");
        } catch (UnsupportedOperationException ex) {
            pass_PrecedingAxisIteratorTest();
        }
    }

    public void testNoInfiniteLoops_PrecedingSiblingAxisIteratorTest() throws ParserConfigurationException, UnsupportedAxisException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        org.w3c.dom.Document doc = factory.newDocumentBuilder().newDocument();
        doc.appendChild(doc.createElement("root"));
        iterator_PrecedingSiblingAxisIteratorTest = new PrecedingSiblingAxisIterator(doc, new org.jaxen.dom.DocumentNavigator());
        try {
            iterator_PrecedingSiblingAxisIteratorTest.next();
            fail("Iterated too far");
        } catch (NoSuchElementException ex) {
            pass_PrecedingAxisIteratorTest();
        }
    }

    private void pass_PrecedingSiblingAxisIteratorTest() throws ParserConfigurationException, UnsupportedAxisException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        org.w3c.dom.Document doc = factory.newDocumentBuilder().newDocument();
        doc.appendChild(doc.createElement("root"));
        iterator_PrecedingSiblingAxisIteratorTest = new PrecedingSiblingAxisIterator(doc, new org.jaxen.dom.DocumentNavigator());
    }

    public void testRemove_PrecedingSiblingAxisIteratorTest() throws ParserConfigurationException, UnsupportedAxisException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        org.w3c.dom.Document doc = factory.newDocumentBuilder().newDocument();
        doc.appendChild(doc.createElement("root"));
        iterator_PrecedingSiblingAxisIteratorTest = new PrecedingSiblingAxisIterator(doc, new org.jaxen.dom.DocumentNavigator());
        try {
            iterator_PrecedingSiblingAxisIteratorTest.remove();
            fail("Removed from descendant axis iterator");
        } catch (UnsupportedOperationException ex) {
            pass_PrecedingAxisIteratorTest();
        }
    }

    public void testDocumentNode_PriorityTest() throws Exception {
        System.setProperty(XPathReaderFactory.DRIVER_PROPERTY, "");
        testPriority_PriorityTest("/", -0.5, Pattern.DOCUMENT_NODE);
    }

    public void testNameNode_PriorityTest() throws Exception {
        System.setProperty(XPathReaderFactory.DRIVER_PROPERTY, "");
        testPriority_PriorityTest("foo", 0, Pattern.ELEMENT_NODE);
    }

    public void testQNameNode_PriorityTest() throws Exception {
        System.setProperty(XPathReaderFactory.DRIVER_PROPERTY, "");
        testPriority_PriorityTest("foo:bar", 0, Pattern.ELEMENT_NODE);
    }

    public void testFilter_PriorityTest() throws Exception {
        System.setProperty(XPathReaderFactory.DRIVER_PROPERTY, "");
        testPriority_PriorityTest("foo[@id='123']", 0.5, Pattern.ELEMENT_NODE);
    }

    public void testURI_PriorityTest() throws Exception {
        System.setProperty(XPathReaderFactory.DRIVER_PROPERTY, "");
        testPriority_PriorityTest("foo:*", -0.25, Pattern.ELEMENT_NODE);
    }

    public void testNodeType_PriorityTest() throws Exception {
        System.setProperty(XPathReaderFactory.DRIVER_PROPERTY, "");
        testPriority_PriorityTest("text()", -0.5, Pattern.TEXT_NODE);
    }

    public void testAttribute_PriorityTest() throws Exception {
        System.setProperty(XPathReaderFactory.DRIVER_PROPERTY, "");
        testPriority_PriorityTest("@*", -0.5, Pattern.ATTRIBUTE_NODE);
    }

    public void testAnyNode_PriorityTest() throws Exception {
        System.setProperty(XPathReaderFactory.DRIVER_PROPERTY, "");
        testPriority_PriorityTest("*", -0.5, Pattern.ELEMENT_NODE);
    }

    protected void testPriority_PriorityTest(String expr, double priority, short nodeType) throws JaxenException, SAXPathException {
        System.setProperty(XPathReaderFactory.DRIVER_PROPERTY, "");
        Pattern pattern = PatternParser.parse(expr);
        double d = pattern.getPriority();
        short nt = pattern.getMatchType();
        assertEquals("expr: " + expr, new Double(priority), new Double(d));
        assertEquals("nodeType: " + expr, nodeType, nt);
    }

    public void testGetText_ProcessingInstructionNodeTest() throws JaxenException, ParserConfigurationException {
        DOMXPath xpath = new DOMXPath("processing-instruction()");
        String expr = xpath.getRootExpr().getText();
        assertEquals("child::processing-instruction()", expr);
    }

    public void testGetTextWithName_ProcessingInstructionNodeTest() throws JaxenException, ParserConfigurationException {
        DOMXPath xpath = new DOMXPath("processing-instruction('foo')");
        String expr = xpath.getRootExpr().getText();
        assertEquals("child::processing-instruction('foo')", expr);
    }

    public void testGetTextWithPredicate_ProcessingInstructionNodeTest() throws JaxenException, ParserConfigurationException {
        DOMXPath xpath = new DOMXPath("processing-instruction('foo')[1 = 1]");
        String expr = xpath.getRootExpr().getText();
        assertEquals("child::processing-instruction('foo')[(1.0 = 1.0)]", expr);
    }

    public void testRound_RoundTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc = builder.newDocument();
        org.w3c.dom.Element a = doc.createElementNS("", "a");
        doc.appendChild(a);
        XPath xpath = new DOMXPath("round(1.5)");
        Object result = xpath.evaluate(doc);
        assertEquals(2, ((Double) result).doubleValue(), 0.0001);
    }

    public void testNegativeRound_RoundTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc = builder.newDocument();
        org.w3c.dom.Element a = doc.createElementNS("", "a");
        doc.appendChild(a);
        XPath xpath = new DOMXPath("round(-1.5)");
        Object result = xpath.evaluate(doc);
        assertEquals(-1, ((Double) result).doubleValue(), 0.0001);
    }

    public void testNaNRoundIsNaN_RoundTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc = builder.newDocument();
        org.w3c.dom.Element a = doc.createElementNS("", "a");
        doc.appendChild(a);
        XPath xpath = new DOMXPath("round(1.0 div 0.0 - 2.0 div 0.0)");
        double result = ((Double) xpath.evaluate(doc)).doubleValue();
        assertTrue(Double.isNaN(result));
    }

    public void testRoundFunctionRequiresAtLeastOneArgument_RoundTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc = builder.newDocument();
        org.w3c.dom.Element a = doc.createElementNS("", "a");
        doc.appendChild(a);
        XPath xpath = new DOMXPath("round()");
        try {
            xpath.selectNodes(doc);
            fail("Allowed round function with no arguments");
        } catch (FunctionCallException ex) {
            assertNotNull(ex.getMessage());
        }
    }

    public void testRoundFunctionRequiresAtMostOneArgument_RoundTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc = builder.newDocument();
        org.w3c.dom.Element a = doc.createElementNS("", "a");
        doc.appendChild(a);
        XPath xpath = new DOMXPath("round(2.2, 1.2)");
        try {
            xpath.selectNodes(doc);
            fail("Allowed round function with two arguments");
        } catch (FunctionCallException ex) {
            assertNotNull(ex.getMessage());
        }
    }

    public void testMessageIsNonNull_SAXPathExceptionTest() {
        SAXPathException ex = new SAXPathException("Hello");
        assertEquals("Hello", ex.getMessage());
    }

    public void testPrintStackTrace_SAXPathExceptionTest() {
        StringIndexOutOfBoundsException cause = new StringIndexOutOfBoundsException("1234");
        SAXPathException ex = new SAXPathException(cause);
        StringWriter out = new StringWriter();
        PrintWriter pw = new PrintWriter(out);
        ex.printStackTrace(pw);
        pw.close();
        assertTrue(out.toString().indexOf("Caused by: java.lang.StringIndexOutOfBoundsException") > 0);
        assertTrue(out.toString().indexOf("1234") > 0);
    }

    /**
     * Need to make sure that changing the map after it's used to create the 
     * namespace context does not affect the context. i.e.
     * data encapsulation is not violated.
     */
    public void testMapCopy_SimpleNamespaceContextTest() {
        Map map = new HashMap();
        SimpleNamespaceContext context = new SimpleNamespaceContext(map);
        map.put("pre", "http://www.example.org/");
        assertNull(context.translateNamespacePrefixToUri("pre"));
    }

    public void testCantUseNonStringsAsValues_SimpleNamespaceContextTest() {
        Map map = new HashMap();
        map.put("key", new Object());
        try {
            new SimpleNamespaceContext(map);
            fail("added non String value to namespace context");
        } catch (Exception ex) {
            assertNotNull(ex.getMessage());
        }
    }

    public void testCantUseNonStringsAsKeys_SimpleNamespaceContextTest() {
        Map map = new HashMap();
        map.put(new Object(), "value");
        try {
            new SimpleNamespaceContext(map);
            fail("added non String key to namespace context");
        } catch (Exception ex) {
            assertNotNull(ex.getMessage());
        }
    }

    public void testContextFromElement_SimpleNamespaceContextTest() throws ParserConfigurationException, UnsupportedAxisException {
        SimpleNamespaceContext context = new SimpleNamespaceContext();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        org.w3c.dom.Document doc = builder.newDocument();
        Element root = doc.createElementNS("http://www.example.org/", "pre:root");
        doc.appendChild(root);
        context.addElementNamespaces(new org.jaxen.dom.DocumentNavigator(), root);
        assertEquals("http://www.example.org/", context.translateNamespacePrefixToUri("pre"));
    }

    public void testSerialization_SimpleNamespaceContextTest() throws IOException, ClassNotFoundException {
        SimpleNamespaceContext original = new SimpleNamespaceContext();
        original.addNamespace("a", "http://www.a.com");
        original.addNamespace("b", "http://www.b.com");
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(out);
        oos.writeObject(original);
        oos.close();
        byte[] pickled = out.toByteArray();
        InputStream in = new ByteArrayInputStream(pickled);
        ObjectInputStream ois = new ObjectInputStream(in);
        Object o = ois.readObject();
        SimpleNamespaceContext copy = (SimpleNamespaceContext) o;
        assertEquals("http://www.a.com", copy.translateNamespacePrefixToUri("a"));
        assertEquals("http://www.b.com", copy.translateNamespacePrefixToUri("b"));
        assertEquals("", "");
    }

    public void testRoundTripSerialization_SimpleVariableContextTest() throws IOException, ClassNotFoundException, UnresolvableException {
        SimpleVariableContext original = new SimpleVariableContext();
        original.setVariableValue("s", "String Value");
        original.setVariableValue("x", new Double(3.1415292));
        original.setVariableValue("b", Boolean.TRUE);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(out);
        oos.writeObject(original);
        oos.close();
        byte[] pickled = out.toByteArray();
        InputStream in = new ByteArrayInputStream(pickled);
        ObjectInputStream ois = new ObjectInputStream(in);
        Object o = ois.readObject();
        SimpleVariableContext copy = (SimpleVariableContext) o;
        assertEquals("String Value", copy.getVariableValue("", "", "s"));
        assertEquals(new Double(3.1415292), copy.getVariableValue("", "", "x"));
        assertEquals(Boolean.TRUE, copy.getVariableValue("", "", "b"));
        assertEquals("", "");
    }

    public void testSerializationFormatHasNotChanged_SimpleVariableContextTest() throws IOException, ClassNotFoundException, UnresolvableException {
        InputStream in = new FileInputStream("xml/simplevariablecontext.ser");
        ObjectInputStream ois = new ObjectInputStream(in);
        Object o = ois.readObject();
        SimpleVariableContext context = (SimpleVariableContext) o;
        assertEquals("String Value", context.getVariableValue("", "", "s"));
        assertEquals(new Double(3.1415292), context.getVariableValue("", "", "x"));
        assertEquals(Boolean.TRUE, context.getVariableValue("", "", "b"));
        assertEquals("", "");
    }

    public void testNoInfiniteLoops_SingleObjectIteratorTest() {
        iterator_SingleObjectIteratorTest.next();
        try {
            iterator_SingleObjectIteratorTest.next();
            fail("Iterated twice");
        } catch (NoSuchElementException ex) {
        }
    }

    public void testRemove_SingleObjectIteratorTest() {
        try {
            iterator_SingleObjectIteratorTest.remove();
            fail("Removed from iterator");
        } catch (UnsupportedOperationException ex) {
        }
    }

    public void testIndexOutOfBoundsException_SingletonListTest() {
        List list = new SingletonList(new Object());
        try {
            list.get(1);
            fail("Got element 1");
        } catch (IndexOutOfBoundsException ex) {
            assertNotNull(ex.getMessage());
        }
    }

    public void testStartsWithNumber_StartsWithTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc = builder.newDocument();
        doc.appendChild(doc.createElement("root"));
        XPath xpath = new DOMXPath("starts-with(33, '3')");
        Boolean result = (Boolean) xpath.evaluate(doc);
        assertEquals(Boolean.TRUE, result);
    }

    public void testStartsWithString_StartsWithTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc = builder.newDocument();
        doc.appendChild(doc.createElement("root"));
        XPath xpath = new DOMXPath("starts-with('test', 't')");
        Boolean result = (Boolean) xpath.evaluate(doc);
        assertEquals(Boolean.TRUE, result);
    }

    public void testStartsWithString3_StartsWithTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc = builder.newDocument();
        doc.appendChild(doc.createElement("root"));
        XPath xpath = new DOMXPath("starts-with('superlative', 'superlative')");
        Boolean result = (Boolean) xpath.evaluate(doc);
        assertEquals(Boolean.TRUE, result);
    }

    public void testStartsWithNumber2_StartsWithTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc = builder.newDocument();
        doc.appendChild(doc.createElement("root"));
        XPath xpath = new DOMXPath("starts-with(43, '3')");
        Boolean result = (Boolean) xpath.evaluate(doc);
        assertEquals(Boolean.FALSE, result);
    }

    public void testStartsWithString2_StartsWithTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc = builder.newDocument();
        doc.appendChild(doc.createElement("root"));
        XPath xpath = new DOMXPath("starts-with('1234567890', '1234567a')");
        Boolean result = (Boolean) xpath.evaluate(doc);
        assertEquals(Boolean.FALSE, result);
    }

    public void testEmptyStringStartsWithNonEmptyString_StartsWithTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc = builder.newDocument();
        doc.appendChild(doc.createElement("root"));
        XPath xpath = new DOMXPath("starts-with('', 'a')");
        Boolean result = (Boolean) xpath.evaluate(doc);
        assertEquals(Boolean.FALSE, result);
    }

    public void testEmptyStringStartsWithEmptyString_StartsWithTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc = builder.newDocument();
        doc.appendChild(doc.createElement("root"));
        XPath xpath = new DOMXPath("starts-with('', '')");
        Boolean result = (Boolean) xpath.evaluate(doc);
        assertEquals(Boolean.TRUE, result);
    }

    public void testStartsWithEmptyString_StartsWithTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc = builder.newDocument();
        doc.appendChild(doc.createElement("root"));
        XPath xpath = new DOMXPath("starts-with('a', '')");
        Boolean result = (Boolean) xpath.evaluate(doc);
        assertEquals(Boolean.TRUE, result);
    }

    public void testStartsWithFunctionRequiresAtLeastTwoArguments_StartsWithTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc = builder.newDocument();
        doc.appendChild(doc.createElement("root"));
        BaseXPath xpath = new DOMXPath("starts-with('a')");
        try {
            xpath.selectNodes(doc);
            fail("Allowed starts-with function with one argument");
        } catch (FunctionCallException ex) {
            assertNotNull(ex.getMessage());
        }
    }

    public void testStartsWithFunctionRequiresAtMostTwoArguments_StartsWithTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc = builder.newDocument();
        doc.appendChild(doc.createElement("root"));
        BaseXPath xpath = new DOMXPath("starts-with('a', 'a', 'a')");
        try {
            xpath.selectNodes(doc);
            fail("Allowed starts-with function with three arguments");
        } catch (FunctionCallException ex) {
            assertNotNull(ex.getMessage());
        }
    }

    public void testStringLengthOfNumber_StringLengthTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc_StringLengthTest = builder.newDocument();
        doc_StringLengthTest.appendChild(doc_StringLengthTest.createElement("root"));
        XPath xpath = new DOMXPath("string-length(3)");
        Double result = (Double) xpath.evaluate(doc_StringLengthTest);
        assertEquals(1, result.intValue());
    }

    public void testStringLengthOfEmptyString_StringLengthTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc_StringLengthTest = builder.newDocument();
        doc_StringLengthTest.appendChild(doc_StringLengthTest.createElement("root"));
        XPath xpath = new DOMXPath("string-length('')");
        Double result = (Double) xpath.evaluate(doc_StringLengthTest);
        assertEquals(0, result.intValue());
    }

    public void testStringLengthOfString_StringLengthTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc_StringLengthTest = builder.newDocument();
        doc_StringLengthTest.appendChild(doc_StringLengthTest.createElement("root"));
        XPath xpath = new DOMXPath("string-length('0123456789')");
        Double result = (Double) xpath.evaluate(doc_StringLengthTest);
        assertEquals(10, result.intValue());
    }

    public void testStringLengthFunctionOperatesOnContextNode_StringLengthTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc_StringLengthTest = builder.newDocument();
        doc_StringLengthTest.appendChild(doc_StringLengthTest.createElement("root"));
        BaseXPath xpath = new DOMXPath("string-length()");
        Double result = (Double) xpath.evaluate(doc_StringLengthTest);
        assertEquals(0, result.intValue());
    }

    public void testStringLengthWithPrivateUseChars_StringLengthTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc_StringLengthTest = builder.newDocument();
        doc_StringLengthTest.appendChild(doc_StringLengthTest.createElement("root"));
        XPath xpath = new DOMXPath("string-length('ab??')");
        Double result = (Double) xpath.evaluate(doc_StringLengthTest);
        assertEquals(4, result.intValue());
    }

    public void testStringLengthFunctionCountsUnicodeCharactersNotJavaChars_StringLengthTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc_StringLengthTest = builder.newDocument();
        doc_StringLengthTest.appendChild(doc_StringLengthTest.createElement("root"));
        BaseXPath xpath = new DOMXPath("string-length('?')");
        Double result = (Double) xpath.evaluate(doc_StringLengthTest);
        assertEquals(1, result.intValue());
    }

    public void testStringLengthFunctionWithMalformedString_StringLengthTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc_StringLengthTest = builder.newDocument();
        doc_StringLengthTest.appendChild(doc_StringLengthTest.createElement("root"));
        BaseXPath xpath = new DOMXPath("string-length('AB\uD834X')");
        try {
            xpath.evaluate(doc_StringLengthTest);
            fail("Allowed Malformed string");
        } catch (FunctionCallException ex) {
            assertNotNull(ex.getMessage());
        }
    }

    public void testStringLengthFunctionRequiresExactlyOneArgument_StringLengthTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc_StringLengthTest = builder.newDocument();
        doc_StringLengthTest.appendChild(doc_StringLengthTest.createElement("root"));
        BaseXPath xpath = new DOMXPath("string-length('', '')");
        try {
            xpath.selectNodes(doc_StringLengthTest);
            fail("Allowed string-length function with two arguments");
        } catch (FunctionCallException ex) {
            assertNotNull(ex.getMessage());
        }
    }

    public void testStringFunctionOperatesOnFirstNodeInDocumentOrder_StringTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc = builder.newDocument();
        XPath xpath = new DOMXPath("string(//x)");
        org.w3c.dom.Element a = doc.createElementNS("", "a");
        org.w3c.dom.Element b = doc.createElementNS("", "b");
        doc.appendChild(a);
        a.appendChild(b);
        org.w3c.dom.Element x2 = doc.createElementNS("", "x");
        org.w3c.dom.Element x3 = doc.createElementNS("", "x");
        org.w3c.dom.Element x4 = doc.createElementNS("", "x");
        a.appendChild(x4);
        b.appendChild(x2);
        b.appendChild(x3);
        x2.appendChild(doc.createTextNode("2"));
        x3.appendChild(doc.createTextNode("3"));
        x4.appendChild(doc.createTextNode("4"));
        List result = xpath.selectNodes(doc);
        assertEquals(1, result.size());
        assertEquals("2", result.get(0));
    }

    public void testStringValueOfComment_StringTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc = builder.newDocument();
        XPath xpath = new DOMXPath("string(/a/comment())");
        org.w3c.dom.Element a = doc.createElementNS("", "a");
        doc.appendChild(a);
        a.appendChild(doc.createComment("data"));
        String result = (String) xpath.evaluate(doc);
        assertEquals("data", result);
    }

    public void testStringValueOfNull_StringTest() throws ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc = builder.newDocument();
        assertEquals("", StringFunction.evaluate(null, null));
    }

    public void testStringValueOfNullWithNonNullNavigator_StringTest() throws ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc = builder.newDocument();
        assertEquals("", StringFunction.evaluate(null, new DocumentNavigator()));
    }

    public void testStringValueOfNamespaceNode_StringTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc = builder.newDocument();
        XPath xpath = new DOMXPath("string(/a/namespace::node())");
        org.w3c.dom.Element a = doc.createElementNS("", "a");
        doc.appendChild(a);
        String result = (String) xpath.evaluate(doc);
        assertEquals("http://www.w3.org/XML/1998/namespace", result);
    }

    public void testSmallNumbersDontUseExponentialNotation_StringTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc = builder.newDocument();
        XPath xpath = new DOMXPath("string(0.0000003)");
        String result = (String) xpath.evaluate(null);
        assertEquals("0.0000003", result);
    }

    public void testBigNumbersDontUseExponentialNotation_StringTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc = builder.newDocument();
        XPath xpath = new DOMXPath("string(100000000.5)");
        String result = (String) xpath.evaluate(null);
        assertEquals("100000000.5", result);
    }

    public void testStringOfInfinity_StringTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc = builder.newDocument();
        XPath xpath = new DOMXPath("string(1 div 0)");
        String result = (String) xpath.evaluate(null);
        assertEquals("Infinity", result);
    }

    public void testStringOfNegativeInfinity_StringTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc = builder.newDocument();
        XPath xpath = new DOMXPath("string(-1 div 0)");
        String result = (String) xpath.evaluate(null);
        assertEquals("-Infinity", result);
    }

    public void testStringOfNegativeZero_StringTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc = builder.newDocument();
        XPath xpath = new DOMXPath("string(-0)");
        String result = (String) xpath.evaluate(null);
        assertEquals("0", result);
    }

    public void testIntegersAreFormattedAsInts_StringTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc = builder.newDocument();
        XPath xpath = new DOMXPath("string(12)");
        String result = (String) xpath.evaluate(null);
        assertEquals("12", result);
    }

    public void testStringFunctionRequiresAtMostOneArgument_StringTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc = builder.newDocument();
        XPath xpath = new DOMXPath("string('a', 1)");
        try {
            xpath.selectNodes(doc);
            fail("Allowed string function with two arguments");
        } catch (FunctionCallException ex) {
            assertNotNull(ex.getMessage());
        }
    }

    public void testSubstringAfterNumber_SubstringAfterTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc = builder.newDocument();
        doc.appendChild(doc.createElement("root"));
        XPath xpath = new DOMXPath("substring-after(33, '3')");
        String result = (String) xpath.evaluate(doc);
        assertEquals("3", result);
    }

    public void testSubstringAfterString_SubstringAfterTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc = builder.newDocument();
        doc.appendChild(doc.createElement("root"));
        XPath xpath = new DOMXPath("substring-after('test', 'es')");
        String result = (String) xpath.evaluate(doc);
        assertEquals("t", result);
    }

    public void testSubstringAfterString4_SubstringAfterTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc = builder.newDocument();
        doc.appendChild(doc.createElement("root"));
        XPath xpath = new DOMXPath("substring-after('superlative', 'superlative')");
        String result = (String) xpath.evaluate(doc);
        assertEquals("", result);
    }

    public void testSubstringAfterNumber2_SubstringAfterTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc = builder.newDocument();
        doc.appendChild(doc.createElement("root"));
        XPath xpath = new DOMXPath("substring-after(43, '0')");
        String result = (String) xpath.evaluate(doc);
        assertEquals("", result);
    }

    public void testSubstringAfterString2_SubstringAfterTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc = builder.newDocument();
        doc.appendChild(doc.createElement("root"));
        XPath xpath = new DOMXPath("substring-after('1234567890', '1234567a')");
        String result = (String) xpath.evaluate(doc);
        assertEquals("", result);
    }

    public void testSubstringAfterString3_SubstringAfterTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc = builder.newDocument();
        doc.appendChild(doc.createElement("root"));
        XPath xpath = new DOMXPath("substring-after('1234567890', '456')");
        String result = (String) xpath.evaluate(doc);
        assertEquals("7890", result);
    }

    public void testEmptyStringSubstringAfterNonEmptyString_SubstringAfterTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc = builder.newDocument();
        doc.appendChild(doc.createElement("root"));
        XPath xpath = new DOMXPath("substring-after('', 'a')");
        String result = (String) xpath.evaluate(doc);
        assertEquals("", result);
    }

    public void testEmptyStringBeforeEmptyString_SubstringAfterTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc = builder.newDocument();
        doc.appendChild(doc.createElement("root"));
        XPath xpath = new DOMXPath("substring-after('', '')");
        String result = (String) xpath.evaluate(doc);
        assertEquals("", result);
    }

    public void testSubstringAfterEmptyString_SubstringAfterTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc = builder.newDocument();
        doc.appendChild(doc.createElement("root"));
        XPath xpath = new DOMXPath("substring-after('a', '')");
        String result = (String) xpath.evaluate(doc);
        assertEquals("a", result);
    }

    public void testSubstringAfterFunctionRequiresAtLeastTwoArguments_SubstringAfterTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc = builder.newDocument();
        doc.appendChild(doc.createElement("root"));
        BaseXPath xpath = new DOMXPath("substring-after('a')");
        try {
            xpath.selectNodes(doc);
            fail("Allowed substring-after function with one argument");
        } catch (FunctionCallException ex) {
            assertNotNull(ex.getMessage());
        }
    }

    public void testSubstringAfterFunctionRequiresAtMostTwoArguments_SubstringAfterTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc = builder.newDocument();
        doc.appendChild(doc.createElement("root"));
        BaseXPath xpath = new DOMXPath("substring-after('a', 'a', 'a')");
        try {
            xpath.selectNodes(doc);
            fail("Allowed substring-after function with three arguments");
        } catch (FunctionCallException ex) {
            assertNotNull(ex.getMessage());
        }
    }

    public void testSubstringBeforeNumber_SubstringBeforeTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc = builder.newDocument();
        doc.appendChild(doc.createElement("root"));
        XPath xpath = new DOMXPath("substring-before(33, '3')");
        String result = (String) xpath.evaluate(doc);
        assertEquals("", result);
    }

    public void testSubstringBeforeString_SubstringBeforeTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc = builder.newDocument();
        doc.appendChild(doc.createElement("root"));
        XPath xpath = new DOMXPath("substring-before('test', 'es')");
        String result = (String) xpath.evaluate(doc);
        assertEquals("t", result);
    }

    public void testContainsString3_SubstringBeforeTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc = builder.newDocument();
        doc.appendChild(doc.createElement("root"));
        XPath xpath = new DOMXPath("substring-before('superlative', 'superlative')");
        String result = (String) xpath.evaluate(doc);
        assertEquals("", result);
    }

    public void testSubstringBeforeNumber2_SubstringBeforeTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc = builder.newDocument();
        doc.appendChild(doc.createElement("root"));
        XPath xpath = new DOMXPath("substring-before(43, '0')");
        String result = (String) xpath.evaluate(doc);
        assertEquals("", result);
    }

    public void testSubstringBeforeString2_SubstringBeforeTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc = builder.newDocument();
        doc.appendChild(doc.createElement("root"));
        XPath xpath = new DOMXPath("substring-before('1234567890', '1234567a')");
        String result = (String) xpath.evaluate(doc);
        assertEquals("", result);
    }

    public void testSubstringBeforeString3_SubstringBeforeTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc = builder.newDocument();
        doc.appendChild(doc.createElement("root"));
        XPath xpath = new DOMXPath("substring-before('1234567890', '456')");
        String result = (String) xpath.evaluate(doc);
        assertEquals("123", result);
    }

    public void testEmptyStringSubstringBeforeNonEmptyString_SubstringBeforeTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc = builder.newDocument();
        doc.appendChild(doc.createElement("root"));
        XPath xpath = new DOMXPath("substring-before('', 'a')");
        String result = (String) xpath.evaluate(doc);
        assertEquals("", result);
    }

    public void testEmptyStringBeforeEmptyString_SubstringBeforeTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc = builder.newDocument();
        doc.appendChild(doc.createElement("root"));
        XPath xpath = new DOMXPath("substring-before('', '')");
        String result = (String) xpath.evaluate(doc);
        assertEquals("", result);
    }

    public void testSubstringBeforeEmptyString_SubstringBeforeTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc = builder.newDocument();
        doc.appendChild(doc.createElement("root"));
        XPath xpath = new DOMXPath("substring-before('a', '')");
        String result = (String) xpath.evaluate(doc);
        assertEquals("", result);
    }

    public void testSubstringBeforeFunctionRequiresAtLeastTwoArguments_SubstringBeforeTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc = builder.newDocument();
        doc.appendChild(doc.createElement("root"));
        BaseXPath xpath = new DOMXPath("substring-before('a')");
        try {
            xpath.selectNodes(doc);
            fail("Allowed substring-before function with one argument");
        } catch (FunctionCallException ex) {
            assertNotNull(ex.getMessage());
        }
    }

    public void testSubstringBeforeFunctionRequiresAtMostTwoArguments_SubstringBeforeTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc = builder.newDocument();
        doc.appendChild(doc.createElement("root"));
        BaseXPath xpath = new DOMXPath("substring-before('a', 'a', 'a')");
        try {
            xpath.selectNodes(doc);
            fail("Allowed substring-before function with three arguments");
        } catch (FunctionCallException ex) {
            assertNotNull(ex.getMessage());
        }
    }

    public void testSubstringOfNumber_SubstringTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc = builder.newDocument();
        doc.appendChild(doc.createElement("root"));
        XPath xpath = new DOMXPath("substring(1234, 3)");
        String result = (String) xpath.evaluate(doc);
        assertEquals("34", result);
    }

    public void testSubstringOfNumber2_SubstringTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc = builder.newDocument();
        doc.appendChild(doc.createElement("root"));
        XPath xpath = new DOMXPath("substring(1234, 2, 3)");
        String result = (String) xpath.evaluate(doc);
        assertEquals("234", result);
    }

    public void testUnusualSubstring1_SubstringTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc = builder.newDocument();
        doc.appendChild(doc.createElement("root"));
        XPath xpath = new DOMXPath("substring('12345', 1.5, 2.6)");
        String result = (String) xpath.evaluate(doc);
        assertEquals("234", result);
    }

    public void testUnusualSubstring2_SubstringTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc = builder.newDocument();
        doc.appendChild(doc.createElement("root"));
        XPath xpath = new DOMXPath("substring('12345', 0, 3)");
        String result = (String) xpath.evaluate(doc);
        assertEquals("12", result);
    }

    public void testUnusualSubstring3_SubstringTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc = builder.newDocument();
        doc.appendChild(doc.createElement("root"));
        XPath xpath = new DOMXPath("substring('12345', 0 div 0, 3)");
        String result = (String) xpath.evaluate(doc);
        assertEquals("", result);
    }

    public void testUnusualSubstring4_SubstringTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc = builder.newDocument();
        doc.appendChild(doc.createElement("root"));
        XPath xpath = new DOMXPath("substring('12345', 1, 0 div 0)");
        String result = (String) xpath.evaluate(doc);
        assertEquals("", result);
    }

    public void testUnusualSubstring5_SubstringTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc = builder.newDocument();
        doc.appendChild(doc.createElement("root"));
        XPath xpath = new DOMXPath("substring('12345', -42, 1 div 0)");
        String result = (String) xpath.evaluate(doc);
        assertEquals("12345", result);
    }

    public void testUnusualSubstring6_SubstringTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc = builder.newDocument();
        doc.appendChild(doc.createElement("root"));
        XPath xpath = new DOMXPath("substring('12345', -1 div 0, 1 div 0)");
        String result = (String) xpath.evaluate(doc);
        assertEquals("", result);
    }

    public void testSubstringOfNaN_SubstringTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc = builder.newDocument();
        doc.appendChild(doc.createElement("root"));
        XPath xpath = new DOMXPath("substring(0 div 0, 2)");
        String result = (String) xpath.evaluate(doc);
        assertEquals("aN", result);
    }

    public void testSubstringOfEmptyString_SubstringTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc = builder.newDocument();
        doc.appendChild(doc.createElement("root"));
        XPath xpath = new DOMXPath("substring('', 2)");
        String result = (String) xpath.evaluate(doc);
        assertEquals("", result);
    }

    public void testSubstringWithNegativeLength_SubstringTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc = builder.newDocument();
        doc.appendChild(doc.createElement("root"));
        XPath xpath = new DOMXPath("substring('12345', 2, -3)");
        String result = (String) xpath.evaluate(doc);
        assertEquals("", result);
    }

    public void testSubstringWithExcessiveLength_SubstringTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc = builder.newDocument();
        doc.appendChild(doc.createElement("root"));
        XPath xpath = new DOMXPath("substring('12345', 2, 32)");
        String result = (String) xpath.evaluate(doc);
        assertEquals("2345", result);
    }

    public void testSubstringWithNegativeLength2_SubstringTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc = builder.newDocument();
        doc.appendChild(doc.createElement("root"));
        XPath xpath = new DOMXPath("substring('12345', 2, -1)");
        String result = (String) xpath.evaluate(doc);
        assertEquals("", result);
    }

    public void testSubstringFunctionRequiresAtLeastTwoArguments_SubstringTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc = builder.newDocument();
        doc.appendChild(doc.createElement("root"));
        XPath xpath = new DOMXPath("substring('a')");
        try {
            xpath.selectNodes(doc);
            fail("Allowed substring function with one argument");
        } catch (FunctionCallException ex) {
            assertNotNull(ex.getMessage());
        }
    }

    public void testNegativeStartNoLength_SubstringTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc = builder.newDocument();
        doc.appendChild(doc.createElement("root"));
        XPath xpath = new DOMXPath("substring('Hello', -50)");
        String result = (String) xpath.evaluate(doc);
        assertEquals("Hello", result);
    }

    public void testNegativeStartWithLength_SubstringTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc = builder.newDocument();
        doc.appendChild(doc.createElement("root"));
        XPath xpath = new DOMXPath("substring('Hello', -50, 20)");
        String result = (String) xpath.evaluate(doc);
        assertEquals("", result);
    }

    public void testSubstringFunctionRequiresAtMostThreeArguments_SubstringTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc = builder.newDocument();
        doc.appendChild(doc.createElement("root"));
        XPath xpath = new DOMXPath("substring('a', 1, 1, 4)");
        try {
            xpath.selectNodes(doc);
            fail("Allowed substring function with four arguments");
        } catch (FunctionCallException ex) {
            assertNotNull(ex.getMessage());
        }
    }

    public void testStringLengthCountsUnicodeCharactersNotJavaChars_SubstringTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc = builder.newDocument();
        doc.appendChild(doc.createElement("root"));
        XPath xpath = new DOMXPath("substring('A?', 1, 2)");
        String result = (String) xpath.evaluate(doc);
        assertEquals("A?", result);
    }

    public void testStringLengthIndexesUnicodeCharactersNotJavaChars_SubstringTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc = builder.newDocument();
        doc.appendChild(doc.createElement("root"));
        XPath xpath = new DOMXPath("substring('A?', 3, 1)");
        String result = (String) xpath.evaluate(doc);
        assertEquals("", result);
    }

    public void testStringLengthIndexesAndCountsUnicodeCharactersNotJavaChars_SubstringTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc = builder.newDocument();
        doc.appendChild(doc.createElement("root"));
        XPath xpath = new DOMXPath("substring('A?123', 3, 2)");
        String result = (String) xpath.evaluate(doc);
        assertEquals("12", result);
    }

    public void testSumOfNumber_SumTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc = builder.newDocument();
        doc.appendChild(doc.createElement("root"));
        try {
            XPath xpath = new DOMXPath("sum(3)");
            xpath.selectNodes(doc);
            fail("sum of non-node-set");
        } catch (FunctionCallException e) {
            assertEquals("The argument to the sum function must be a node-set", e.getMessage());
        }
    }

    public void testSumNoArguments_SumTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc = builder.newDocument();
        doc.appendChild(doc.createElement("root"));
        try {
            XPath xpath = new DOMXPath("sum()");
            xpath.selectNodes(doc);
            fail("sum of nothing");
        } catch (FunctionCallException e) {
            assertEquals("sum() requires one argument.", e.getMessage());
        }
    }

    public void testTranslate_TranslateFunctionTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc_TranslateFunctionTest = builder.newDocument();
        doc_TranslateFunctionTest.appendChild(doc_TranslateFunctionTest.createElement("root"));
        XPath xpath = new DOMXPath("translate('abc', 'b', 'd')");
        String result = (String) xpath.evaluate(doc_TranslateFunctionTest);
        assertEquals("adc", result);
    }

    public void testTranslateIgnoresExtraArguments_TranslateFunctionTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc_TranslateFunctionTest = builder.newDocument();
        doc_TranslateFunctionTest.appendChild(doc_TranslateFunctionTest.createElement("root"));
        XPath xpath = new DOMXPath("translate('abc', 'b', 'dghf')");
        String result = (String) xpath.evaluate(doc_TranslateFunctionTest);
        assertEquals("adc", result);
    }

    public void testTranslateFunctionRequiresAtLeastThreeArguments_TranslateFunctionTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc_TranslateFunctionTest = builder.newDocument();
        doc_TranslateFunctionTest.appendChild(doc_TranslateFunctionTest.createElement("root"));
        XPath xpath = new DOMXPath("translate('a', 'b')");
        try {
            xpath.selectNodes(doc_TranslateFunctionTest);
            fail("Allowed translate function with two arguments");
        } catch (FunctionCallException ex) {
            assertNotNull(ex.getMessage());
        }
    }

    public void testTranslateRequiresAtMostThreeArguments_TranslateFunctionTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc_TranslateFunctionTest = builder.newDocument();
        doc_TranslateFunctionTest.appendChild(doc_TranslateFunctionTest.createElement("root"));
        XPath xpath = new DOMXPath("substring-after('a', 'a', 'a', 'a')");
        try {
            xpath.selectNodes(doc_TranslateFunctionTest);
            fail("Allowed translate function with four arguments");
        } catch (FunctionCallException ex) {
            assertNotNull(ex.getMessage());
        }
    }

    public void testTranslateStringThatContainsNonBMPChars_TranslateFunctionTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc_TranslateFunctionTest = builder.newDocument();
        doc_TranslateFunctionTest.appendChild(doc_TranslateFunctionTest.createElement("root"));
        XPath xpath = new DOMXPath("translate('ab?b', 'b', 'd')");
        String result = (String) xpath.evaluate(doc_TranslateFunctionTest);
        assertEquals("ad?d", result);
    }

    public void testTranslateStringThatContainsPrivateUseChars_TranslateFunctionTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc_TranslateFunctionTest = builder.newDocument();
        doc_TranslateFunctionTest.appendChild(doc_TranslateFunctionTest.createElement("root"));
        XPath xpath = new DOMXPath("translate('ab??', '?', '?')");
        String result = (String) xpath.evaluate(doc_TranslateFunctionTest);
        assertEquals("ab??", result);
    }

    public void testTranslateNonBMPChars_TranslateFunctionTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc_TranslateFunctionTest = builder.newDocument();
        doc_TranslateFunctionTest.appendChild(doc_TranslateFunctionTest.createElement("root"));
        XPath xpath = new DOMXPath("translate('ab?b', '?', 'd')");
        String result = (String) xpath.evaluate(doc_TranslateFunctionTest);
        assertEquals("abdb", result);
    }

    public void testTranslateNonBMPChars2_TranslateFunctionTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc_TranslateFunctionTest = builder.newDocument();
        doc_TranslateFunctionTest.appendChild(doc_TranslateFunctionTest.createElement("root"));
        XPath xpath = new DOMXPath("translate('ab?b', '?', 'da')");
        String result = (String) xpath.evaluate(doc_TranslateFunctionTest);
        assertEquals("abdb", result);
    }

    public void testTranslateWithNonBMPChars_TranslateFunctionTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc_TranslateFunctionTest = builder.newDocument();
        doc_TranslateFunctionTest.appendChild(doc_TranslateFunctionTest.createElement("root"));
        XPath xpath = new DOMXPath("translate('abc', 'c', '?')");
        String result = (String) xpath.evaluate(doc_TranslateFunctionTest);
        assertEquals("ab?", result);
    }

    public void testTranslateWithNonBMPChars2_TranslateFunctionTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc_TranslateFunctionTest = builder.newDocument();
        doc_TranslateFunctionTest.appendChild(doc_TranslateFunctionTest.createElement("root"));
        XPath xpath = new DOMXPath("translate('abc', 'c', '?b')");
        String result = (String) xpath.evaluate(doc_TranslateFunctionTest);
        assertEquals("ab?", result);
    }

    public void testTranslateWithMalformedSurrogatePair_TranslateFunctionTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc_TranslateFunctionTest = builder.newDocument();
        doc_TranslateFunctionTest.appendChild(doc_TranslateFunctionTest.createElement("root"));
        String str = "'\uD834X\uDD00b')";
        XPath xpath = new DOMXPath("translate('abc', 'c', " + str);
        try {
            xpath.evaluate(doc_TranslateFunctionTest);
            fail("Allowed malformed surrogate pair");
        } catch (FunctionCallException ex) {
            assertNotNull(ex.getMessage());
        }
    }

    public void testTranslateWithMissingLowSurrogate_TranslateFunctionTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc_TranslateFunctionTest = builder.newDocument();
        doc_TranslateFunctionTest.appendChild(doc_TranslateFunctionTest.createElement("root"));
        XPath xpath = new DOMXPath("translate('abc', 'c', 'AB\uD834X')");
        try {
            xpath.evaluate(doc_TranslateFunctionTest);
            fail("Allowed malformed surrogate pair");
        } catch (FunctionCallException ex) {
            assertNotNull(ex.getMessage());
        }
    }

    public void testTranslateWithExtraCharsInReplacementString_TranslateFunctionTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc_TranslateFunctionTest = builder.newDocument();
        doc_TranslateFunctionTest.appendChild(doc_TranslateFunctionTest.createElement("root"));
        XPath xpath = new DOMXPath("translate('abc', 'c', 'def')");
        String result = (String) xpath.evaluate(doc_TranslateFunctionTest);
        assertEquals("abd", result);
    }

    public void testTrueOfNumber_TrueTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc = builder.newDocument();
        doc.appendChild(doc.createElement("root"));
        try {
            XPath xpath = new DOMXPath("true(3)");
            xpath.selectNodes(doc);
            fail("true() function took arguments");
        } catch (FunctionCallException e) {
            assertEquals("true() requires no arguments.", e.getMessage());
        }
    }

    public void testUnresolvableVariable_UnresolvableExceptionTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        doc = factory.newDocumentBuilder().newDocument();
        doc.appendChild(doc.createElement("foo"));
        try {
            XPath xpath = new DOMXPath("//foo[bar = $var]");
            xpath.evaluate(doc);
            fail("Didn't throw Unresolvable Exception");
        } catch (UnresolvableException ex) {
            assertNotNull(ex.getMessage());
        }
    }

    public void testUnresolvableFunction_UnresolvableExceptionTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        doc = factory.newDocumentBuilder().newDocument();
        doc.appendChild(doc.createElement("foo"));
        try {
            XPath xpath = new DOMXPath("nonesuch()");
            xpath.evaluate(doc);
            fail("Didn't throw Unresolvable Exception");
        } catch (UnresolvableException ex) {
            assertNotNull(ex.getMessage());
        }
    }

    public void testMessageIsNonNull_UnsupportedAxisExceptionTest() {
        UnsupportedAxisException ex = new UnsupportedAxisException("Hello");
        assertEquals("Hello", ex.getMessage());
    }

    public void testUnresolvableVariable_VariableContextTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        doc = factory.newDocumentBuilder().newDocument();
        Element root = doc.createElementNS("http://www.example.org/", "root");
        doc.appendChild(root);
        root.setAttributeNS("http://www.w3.org/2000/xmlns/", "xmlns", "http://www.example.org/");
        DOMXPath xpath = new DOMXPath("$a/root");
        try {
            xpath.evaluate(doc);
            fail("Evaluated nonexistent variable");
        } catch (UnresolvableException ex) {
            assertEquals("Variable a", ex.getMessage());
        }
    }

    public void testGetVariableContext_VariableContextTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        doc = factory.newDocumentBuilder().newDocument();
        Element root = doc.createElementNS("http://www.example.org/", "root");
        doc.appendChild(root);
        root.setAttributeNS("http://www.w3.org/2000/xmlns/", "xmlns", "http://www.example.org/");
        DOMXPath xpath = new DOMXPath("/root/child");
        assertNotNull(xpath.getVariableContext());
    }

    public void testSetNamespacelessVariable_VariableContextTest() throws JaxenException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        doc = factory.newDocumentBuilder().newDocument();
        Element root = doc.createElementNS("http://www.example.org/", "root");
        doc.appendChild(root);
        root.setAttributeNS("http://www.w3.org/2000/xmlns/", "xmlns", "http://www.example.org/");
        SimpleVariableContext context = new SimpleVariableContext();
        context.setVariableValue("foo", "bar");
        assertEquals("bar", context.getVariableValue("", "", "foo"));
    }

    public Navigator getNavigator_XOMNavigatorTest() {
        return new DocumentNavigator();
    }

    public Object getDocument_XOMNavigatorTest(String url) throws Exception {
        return this.builder_XOMNavigatorTest.build(url);
    }

    public void testConstruction_XOMXPathTest() throws JaxenException {
        new XOMXPath("/foo/bar/baz");
    }

    public void testSelection_XOMXPathTest() throws ParsingException, IOException, JaxenException {
        XPath xpath = new XOMXPath("/foo/bar/baz");
        Builder builder = new Builder();
        nu.xom.Document doc = builder.build(BASIC_XML_XOMXPathTest);
        List results = xpath.selectNodes(doc);
        assertEquals(3, results.size());
        Iterator iter = results.iterator();
        assertEquals("baz", ((nu.xom.Element) iter.next()).getLocalName());
        assertEquals("baz", ((nu.xom.Element) iter.next()).getLocalName());
        assertEquals("baz", ((nu.xom.Element) iter.next()).getLocalName());
        assertTrue(!iter.hasNext());
    }

    public void testDefault_XPathReaderFactoryTest() throws SAXPathException {
        System.setProperty(XPathReaderFactory.DRIVER_PROPERTY, "");
        XPathReader reader = XPathReaderFactory.createReader();
        assertNotNull(reader);
        System.setProperty(XPathReaderFactory.DRIVER_PROPERTY, "");
    }

    public void testValidByProperty_XPathReaderFactoryTest() throws SAXPathException {
        System.setProperty(XPathReaderFactory.DRIVER_PROPERTY, "org.jaxen.test.MockXPathReader");
        XPathReader reader = XPathReaderFactory.createReader();
        assertNotNull(reader);
        assertSame(org.jaxen.test.MockXPathReader.class, reader.getClass());
        System.setProperty(XPathReaderFactory.DRIVER_PROPERTY, "");
    }

    public void testInvalidByProperty_XPathReaderFactoryTest() {
        System.setProperty(XPathReaderFactory.DRIVER_PROPERTY, "java.lang.String");
        try {
            XPathReaderFactory.createReader();
            fail("Should have thrown SAXPathException");
        } catch (SAXPathException e) {
            assertNotNull(e.getMessage());
        }
        System.setProperty(XPathReaderFactory.DRIVER_PROPERTY, "");
    }

    public void testNonExistantByProperty_XPathReaderFactoryTest() {
        System.setProperty(XPathReaderFactory.DRIVER_PROPERTY, "i.am.a.class.that.does.not.Exist");
        try {
            XPathReaderFactory.createReader();
            fail("Should have thrown SAXPathException");
        } catch (org.jaxen.saxpath.SAXPathException e) {
        }
        System.setProperty(XPathReaderFactory.DRIVER_PROPERTY, "");
    }

    public void testValidExplicit_XPathReaderFactoryTest() throws SAXPathException {
        XPathReader reader = XPathReaderFactory.createReader("org.jaxen.test.MockXPathReader");
        assertNotNull(reader);
        assertSame(org.jaxen.test.MockXPathReader.class, reader.getClass());
        System.setProperty(XPathReaderFactory.DRIVER_PROPERTY, "");
    }

    public void testInvalidExplicit_XPathReaderFactoryTest() {
        try {
            XPathReaderFactory.createReader("java.lang.String");
            fail("Should have thrown SAXPathException");
        } catch (org.jaxen.saxpath.SAXPathException e) {
        }
        System.setProperty(XPathReaderFactory.DRIVER_PROPERTY, "");
    }

    public void testNonExistantExplicit_XPathReaderFactoryTest() {
        try {
            XPathReaderFactory.createReader("i.am.a.class.that.does.not.Exist");
            fail("Should have thrown SAXPathException");
        } catch (org.jaxen.saxpath.SAXPathException e) {
        }
        System.setProperty(XPathReaderFactory.DRIVER_PROPERTY, "");
    }

    public void testPaths_XPathReaderTest() throws SAXPathException, ParserConfigurationException, SAXException, IOException {
        this.reader_XPathReaderTest = new org.jaxen.saxpath.base.XPathReader();
        this.actual_XPathReaderTest = new ConformanceXPathHandler();
        this.reader_XPathReaderTest.setXPathHandler(this.actual_XPathReaderTest);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc_XPathReaderTest = builder.parse("xml/basic.xml");
        for (int i = 0; i < paths.length; ++i) {
            reader_XPathReaderTest.parse(paths[i]);
        }
        this.reader_XPathReaderTest = null;
    }
    
    public void testBogusPaths_XPathReaderTest() throws SAXPathException, ParserConfigurationException, SAXException, IOException {
        this.reader_XPathReaderTest = new org.jaxen.saxpath.base.XPathReader();
        this.actual_XPathReaderTest = new ConformanceXPathHandler();
        this.reader_XPathReaderTest.setXPathHandler(this.actual_XPathReaderTest);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc_XPathReaderTest = builder.parse("xml/basic.xml");
        for (int i = 0; i < bogusPaths_XPathReaderTest.length; ++i) {
            final String[] bogusPath = bogusPaths_XPathReaderTest[i];
            try {
                reader_XPathReaderTest.parse(bogusPath[0]);
                fail("Should have thrown XPathSyntaxException for " + bogusPath[0]);
            } catch (org.jaxen.saxpath.XPathSyntaxException e) {
                assertEquals(bogusPath[1], e.getMessage());
            }
        }
        this.reader_XPathReaderTest = null;
    }

    public void testChildrenOfNumber_XPathReaderTest() throws SAXPathException, ParserConfigurationException, SAXException, IOException {
        this.reader_XPathReaderTest = new org.jaxen.saxpath.base.XPathReader();
        this.actual_XPathReaderTest = new ConformanceXPathHandler();
        this.reader_XPathReaderTest.setXPathHandler(this.actual_XPathReaderTest);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc_XPathReaderTest = builder.parse("xml/basic.xml");
        try {
            reader_XPathReaderTest.parse("1/child::test");
            fail("Should have thrown XPathSyntaxException for 1/child::test");
        } catch (org.jaxen.saxpath.XPathSyntaxException e) {
            assertEquals("Node-set expected", e.getMessage());
        }
        this.reader_XPathReaderTest = null;
    }

    public void testChildIsNumber_XPathReaderTest() throws SAXPathException, ParserConfigurationException, SAXException, IOException {
        this.reader_XPathReaderTest = new org.jaxen.saxpath.base.XPathReader();
        this.actual_XPathReaderTest = new ConformanceXPathHandler();
        this.reader_XPathReaderTest.setXPathHandler(this.actual_XPathReaderTest);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc_XPathReaderTest = builder.parse("xml/basic.xml");
        try {
            reader_XPathReaderTest.parse("jane/3");
            fail("Should have thrown XPathSyntaxException for jane/3");
        } catch (org.jaxen.saxpath.XPathSyntaxException e) {
            assertEquals("Expected one of '.', '..', '@', '*', <QName>", e.getMessage());
        }
        this.reader_XPathReaderTest = null;
    }

    public void testNumberOrNumber_XPathReaderTest() throws ParserConfigurationException, SAXException, IOException {
        this.reader_XPathReaderTest = new org.jaxen.saxpath.base.XPathReader();
        this.actual_XPathReaderTest = new ConformanceXPathHandler();
        this.reader_XPathReaderTest.setXPathHandler(this.actual_XPathReaderTest);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc_XPathReaderTest = builder.parse("xml/basic.xml");
        try {
            XPath xpath = new DOMXPath("4 | 5");
            xpath.selectNodes(doc_XPathReaderTest);
            fail("Should have thrown XPathSyntaxException for 4 | 5");
        } catch (JaxenException e) {
            assertEquals("Unions are only allowed over node-sets", e.getMessage());
        }
        this.reader_XPathReaderTest = null;
    }

    public void testStringOrNumber_XPathReaderTest() throws ParserConfigurationException, SAXException, IOException {
        this.reader_XPathReaderTest = new org.jaxen.saxpath.base.XPathReader();
        this.actual_XPathReaderTest = new ConformanceXPathHandler();
        this.reader_XPathReaderTest.setXPathHandler(this.actual_XPathReaderTest);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc_XPathReaderTest = builder.parse("xml/basic.xml");
        try {
            XPath xpath = new DOMXPath("\"test\" | 5");
            xpath.selectNodes(doc_XPathReaderTest);
            fail("Should have thrown XPathSyntaxException for \"test\" | 5");
        } catch (JaxenException e) {
            assertEquals("Unions are only allowed over node-sets", e.getMessage());
        }
        this.reader_XPathReaderTest = null;
    }

    public void testStringOrString_XPathReaderTest() throws ParserConfigurationException, SAXException, IOException {
        this.reader_XPathReaderTest = new org.jaxen.saxpath.base.XPathReader();
        this.actual_XPathReaderTest = new ConformanceXPathHandler();
        this.reader_XPathReaderTest.setXPathHandler(this.actual_XPathReaderTest);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc_XPathReaderTest = builder.parse("xml/basic.xml");
        try {
            XPath xpath = new DOMXPath("\"test\" | \"festival\"");
            xpath.selectNodes(doc_XPathReaderTest);
            fail("Should have thrown XPathSyntaxException for \"test\" | 5");
        } catch (JaxenException e) {
            assertEquals("Unions are only allowed over node-sets", e.getMessage());
        }
        this.reader_XPathReaderTest = null;
    }

    public void testUnionofNodesAndNonNodes_XPathReaderTest() throws ParserConfigurationException, SAXException, IOException {
        this.reader_XPathReaderTest = new org.jaxen.saxpath.base.XPathReader();
        this.actual_XPathReaderTest = new ConformanceXPathHandler();
        this.reader_XPathReaderTest.setXPathHandler(this.actual_XPathReaderTest);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc_XPathReaderTest = builder.parse("xml/basic.xml");
        try {
            XPath xpath = new DOMXPath("count(//*) | //* ");
            xpath.selectNodes(doc_XPathReaderTest);
            fail("Should have thrown XPathSyntaxException for \"count(//*) | //* ");
        } catch (JaxenException e) {
            assertEquals("Unions are only allowed over node-sets", e.getMessage());
        }
        this.reader_XPathReaderTest = null;
    }

    public void testValidAxis_XPathReaderTest() throws SAXPathException, ParserConfigurationException, SAXException, IOException {
        this.reader_XPathReaderTest = new org.jaxen.saxpath.base.XPathReader();
        this.actual_XPathReaderTest = new ConformanceXPathHandler();
        this.reader_XPathReaderTest.setXPathHandler(this.actual_XPathReaderTest);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc_XPathReaderTest = builder.parse("xml/basic.xml");
        reader_XPathReaderTest.parse("child::foo");
        this.reader_XPathReaderTest = null;
    }

    public void testInvalidAxis_XPathReaderTest() throws SAXPathException, ParserConfigurationException, SAXException, IOException {
        this.reader_XPathReaderTest = new org.jaxen.saxpath.base.XPathReader();
        this.actual_XPathReaderTest = new ConformanceXPathHandler();
        this.reader_XPathReaderTest.setXPathHandler(this.actual_XPathReaderTest);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc_XPathReaderTest = builder.parse("xml/basic.xml");
        try {
            reader_XPathReaderTest.parse("chyld::foo");
            fail("Should have thrown XPathSyntaxException");
        } catch (org.jaxen.saxpath.XPathSyntaxException ex) {
            assertNotNull(ex.getMessage());
        }
        this.reader_XPathReaderTest = null;
    }

    public void testLocationPathStartsWithVariable_XPathReaderTest() throws SAXPathException, ParserConfigurationException, SAXException, IOException {
        this.reader_XPathReaderTest = new org.jaxen.saxpath.base.XPathReader();
        this.actual_XPathReaderTest = new ConformanceXPathHandler();
        this.reader_XPathReaderTest.setXPathHandler(this.actual_XPathReaderTest);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc_XPathReaderTest = builder.parse("xml/basic.xml");
        reader_XPathReaderTest.parse("$variable/foo");
        this.reader_XPathReaderTest = null;
    }

    public void testLocationPathStartsWithParentheses_XPathReaderTest() throws SAXPathException, ParserConfigurationException, SAXException, IOException {
        this.reader_XPathReaderTest = new org.jaxen.saxpath.base.XPathReader();
        this.actual_XPathReaderTest = new ConformanceXPathHandler();
        this.reader_XPathReaderTest.setXPathHandler(this.actual_XPathReaderTest);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc_XPathReaderTest = builder.parse("xml/basic.xml");
        reader_XPathReaderTest.parse("(//x)/foo");
        this.reader_XPathReaderTest = null;
    }

    public void testNoSpaceAfterDiv_XPathReaderTest() throws JaxenException, ParserConfigurationException, SAXException, IOException {
        this.reader_XPathReaderTest = new org.jaxen.saxpath.base.XPathReader();
        this.actual_XPathReaderTest = new ConformanceXPathHandler();
        this.reader_XPathReaderTest.setXPathHandler(this.actual_XPathReaderTest);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc_XPathReaderTest = builder.parse("xml/basic.xml");
        XPath xpath = new DOMXPath("105 div10");
        Double result = (Double) xpath.evaluate(doc_XPathReaderTest);
        assertEquals(10.5, result.doubleValue(), 0.000001);
        this.reader_XPathReaderTest = null;
    }

    public void testNoSpaceAfterMod_XPathReaderTest() throws JaxenException, ParserConfigurationException, SAXException, IOException {
        this.reader_XPathReaderTest = new org.jaxen.saxpath.base.XPathReader();
        this.actual_XPathReaderTest = new ConformanceXPathHandler();
        this.reader_XPathReaderTest.setXPathHandler(this.actual_XPathReaderTest);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc_XPathReaderTest = builder.parse("xml/basic.xml");
        XPath xpath = new DOMXPath("105 mod10");
        Double result = (Double) xpath.evaluate(doc_XPathReaderTest);
        assertEquals(5, result.intValue());
        this.reader_XPathReaderTest = null;
    }

    public void testNoSpaceAfterPlus_XPathReaderTest() throws JaxenException, ParserConfigurationException, SAXException, IOException {
        this.reader_XPathReaderTest = new org.jaxen.saxpath.base.XPathReader();
        this.actual_XPathReaderTest = new ConformanceXPathHandler();
        this.reader_XPathReaderTest.setXPathHandler(this.actual_XPathReaderTest);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc_XPathReaderTest = builder.parse("xml/basic.xml");
        XPath xpath = new DOMXPath("105 +10");
        Double result = (Double) xpath.evaluate(doc_XPathReaderTest);
        assertEquals(115, result.intValue());
        this.reader_XPathReaderTest = null;
    }

    public void testNoSpaceAfterAnd_XPathReaderTest() throws JaxenException, ParserConfigurationException, SAXException, IOException {
        this.reader_XPathReaderTest = new org.jaxen.saxpath.base.XPathReader();
        this.actual_XPathReaderTest = new ConformanceXPathHandler();
        this.reader_XPathReaderTest.setXPathHandler(this.actual_XPathReaderTest);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc_XPathReaderTest = builder.parse("xml/basic.xml");
        XPath xpath = new DOMXPath("true() andfalse()");
        Boolean result = (Boolean) xpath.evaluate(doc_XPathReaderTest);
        assertFalse(result.booleanValue());
        this.reader_XPathReaderTest = null;
    }

    public void testNoSpaceAfterOr_XPathReaderTest() throws JaxenException, ParserConfigurationException, SAXException, IOException {
        this.reader_XPathReaderTest = new org.jaxen.saxpath.base.XPathReader();
        this.actual_XPathReaderTest = new ConformanceXPathHandler();
        this.reader_XPathReaderTest.setXPathHandler(this.actual_XPathReaderTest);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc_XPathReaderTest = builder.parse("xml/basic.xml");
        XPath xpath = new DOMXPath("true() orfalse()");
        Boolean result = (Boolean) xpath.evaluate(doc_XPathReaderTest);
        assertTrue(result.booleanValue());
        this.reader_XPathReaderTest = null;
    }

    public void testAndImmediatelyFollowedByRelativeLocationPath_XPathReaderTest() throws JaxenException, ParserConfigurationException, SAXException, IOException {
        this.reader_XPathReaderTest = new org.jaxen.saxpath.base.XPathReader();
        this.actual_XPathReaderTest = new ConformanceXPathHandler();
        this.reader_XPathReaderTest.setXPathHandler(this.actual_XPathReaderTest);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc_XPathReaderTest = builder.parse("xml/basic.xml");
        XPath xpath = new DOMXPath("true() andfoo");
        Boolean result = (Boolean) xpath.evaluate(doc_XPathReaderTest);
        assertTrue(result.booleanValue());
        this.reader_XPathReaderTest = null;
    }

    public void testGetXPath_XPathSyntaxExceptionTest() throws JaxenException {
        try {
            new DOMXPath("///triple slash");
            fail("Bad parsing");
        } catch (XPathSyntaxException ex) {
            assertEquals("///triple slash", ex.getXPath());
        }
    }

    public void testGetPositionMarker_XPathSyntaxExceptionTest() throws JaxenException {
        try {
            new DOMXPath("///triple slash");
            fail("Bad parsing");
        } catch (XPathSyntaxException ex) {
            assertTrue(ex.getPositionMarker().startsWith("  "));
            assertTrue(ex.getPositionMarker().endsWith("^"));
        }
    }

    public void testGetMultilineMessage_XPathSyntaxExceptionTest() throws JaxenException {
        try {
            new DOMXPath("///triple slash");
            fail("Bad parsing");
        } catch (XPathSyntaxException ex) {
            String message = ex.getMultilineMessage();
            assertTrue(message.indexOf("\n///triple slash\n") > 1);
            assertTrue(message.endsWith("^"));
        }
    }
    
    public void log_XPathTestBase(String text) throws Exception {
        log_XPathTestBase(verbose, text);
    }

    private void log_XPathTestBase(boolean actualVerbose, String text) throws Exception {
        if (actualVerbose) System.out.println(text);
    }

    private void assertCountXPath_XPathTestBase(int expectedSize, Object context, String xpathStr) throws JaxenException, Exception {
        assertCountXPath2_XPathTestBase(expectedSize, context, xpathStr);
    }

    private Object assertCountXPath2_XPathTestBase(int expectedSize, Object context, String xpathStr) throws JaxenException, Exception {
        log_XPathTestBase(debug, "  Select :: " + xpathStr);
        org.jaxen.dom.DOMXPath xpath = new org.jaxen.dom.DOMXPath(xpathStr);
        List results = xpath.selectNodes(getContext_XPathTestBase(context));
        log_XPathTestBase(debug, "    Expected Size :: " + expectedSize);
        log_XPathTestBase(debug, "    Result Size   :: " + results.size());
        if (expectedSize != results.size()) {
            log_XPathTestBase(debug, "      ## FAILED");
            log_XPathTestBase(debug, "      ## xpath: " + xpath + " = " + xpath.debug());
            Iterator resultIter = results.iterator();
            while (resultIter.hasNext()) {
                log_XPathTestBase(debug, "      --> " + resultIter.next());
            }
        }
        assertEquals(xpathStr, expectedSize, results.size());
        assertExprGetTextIdempotent_XPathTestBase(xpath);
        if (expectedSize > 0) {
            return results.get(0);
        }
        return null;
    }

    private void assertInvalidXPath_XPathTestBase(Object context, String xpathStr) throws Exception {
        try {
            log_XPathTestBase(debug, "  Select :: " + xpathStr);
            DOMXPath xpath = new DOMXPath(xpathStr);
            List results = xpath.selectNodes(getContext_XPathTestBase(context));
            log_XPathTestBase(debug, "    Result Size   :: " + results.size());
            fail("An exception was expected.");
        } catch (JaxenException e) {
            log_XPathTestBase(debug, "    Caught expected exception " + e.getMessage());
        }
    }

    private void assertValueOfXPath_XPathTestBase(String expected, Object context, String xpathStr) throws JaxenException, Exception {
        DOMXPath xpath = new DOMXPath(xpathStr);
        Object node = xpath.evaluate(getContext_XPathTestBase(context));
        String result = StringFunction.evaluate(node, getNavigator_XPathTestBase());
        log_XPathTestBase(debug, "  Select :: " + xpathStr);
        log_XPathTestBase(debug, "    Expected :: " + expected);
        log_XPathTestBase(debug, "    Result   :: " + result);
        if (!expected.equals(result)) {
            log_XPathTestBase(debug, "      ## FAILED");
            log_XPathTestBase(debug, "      ## xpath: " + xpath + " = " + xpath.debug());
        }
        assertEquals(xpathStr, expected, result);
        assertExprGetTextIdempotent_XPathTestBase(xpath);
    }

    private void assertExprGetTextIdempotent_XPathTestBase(BaseXPath xpath) throws JaxenException, Exception {
        assertEquals(0, ExprComparator.EXPR_COMPARATOR.compare(xpath.getRootExpr(), new BaseXPath(xpath.getRootExpr().getText(), null).getRootExpr()));
    }

    private Context getContext_XPathTestBase(Object contextNode) throws Exception {
        Context context = new Context(getContextSupport_XPathTestBase());
        List list = new ArrayList(1);
        list.add(contextNode);
        context.setNodeSet(list);
        return context;
    }

    private ContextSupport getContextSupport_XPathTestBase() throws Exception {
        if (this.contextSupport == null) {
            this.contextSupport = new ContextSupport(new SimpleNamespaceContext(), XPathFunctionContext.getInstance(), new SimpleVariableContext(), getNavigator_XPathTestBase());
        }
        return this.contextSupport;
    }
    
    public Navigator getNavigator_XPathTestBase()
    {
        return new org.jaxen.dom4j.DocumentNavigator();
    }
    
    protected Object getDocument_XPathTestBase(String url) throws Exception{
    	return reader_DOM4JNavigatorTest.read( url );
    	
    }

    public void testGetNodeType_XPathTestBase() throws FunctionCallException, UnsupportedAxisException, Exception {
        this.contextSupport = null;
        System.setProperty(XPathReaderFactory.DRIVER_PROPERTY, "");
        log_XPathTestBase("-----------------------------");
        Navigator nav = getNavigator_XPathTestBase();
        Object document = nav.getDocument("xml/testNamespaces.xml");
        int count = 0;
        Iterator descendantOrSelfAxisIterator = nav.getDescendantOrSelfAxisIterator(document);
        while (descendantOrSelfAxisIterator.hasNext()) {
            Object node = descendantOrSelfAxisIterator.next();
            Iterator namespaceAxisIterator = nav.getNamespaceAxisIterator(node);
            while (namespaceAxisIterator.hasNext()) {
                count++;
                assertEquals("Node type mismatch", Pattern.NAMESPACE_NODE, nav.getNodeType(namespaceAxisIterator.next()));
            }
        }
        assertEquals(25, count);
    }

    /**
     *  test for jaxen-24
     */
    public void testJaxen24_XPathTestBase() throws JaxenException, Exception {
        this.contextSupport = null;
        System.setProperty(XPathReaderFactory.DRIVER_PROPERTY, "");
        log_XPathTestBase("-----------------------------");
        Navigator nav = getNavigator_XPathTestBase();
        String url = "xml/jaxen24.xml";
        log_XPathTestBase("Document [" + url + "]");
        Object document = nav.getDocument(url);
        XPath contextpath = new BaseXPath("/body/div", nav);
        log_XPathTestBase("Initial Context :: " + contextpath);
        List list = contextpath.selectNodes(document);
        Iterator iter = list.iterator();
        while (iter.hasNext()) {
            Object context = iter.next();
            assertCountXPath_XPathTestBase(1, context, "preceding::*[1]");
            assertValueOfXPath_XPathTestBase("span", context, "local-name(preceding::*[1])");
        }
    }

    /**
     *  jaxen-58
     */
    public void testJaxen58_XPathTestBase() throws JaxenException, Exception {
        this.contextSupport = null;
        System.setProperty(XPathReaderFactory.DRIVER_PROPERTY, "");
        log_XPathTestBase("-----------------------------");
        Navigator nav = getNavigator_XPathTestBase();
        String url = "xml/jaxen24.xml";
        log_XPathTestBase("Document [" + url + "]");
        Object document = nav.getDocument(url);
        XPath contextpath = new BaseXPath("/", nav);
        log_XPathTestBase("Initial Context :: " + contextpath);
        List list = contextpath.selectNodes(document);
        Iterator iter = list.iterator();
        while (iter.hasNext()) {
            Object context = iter.next();
            assertCountXPath_XPathTestBase(0, context, "//preceding::x");
            assertCountXPath_XPathTestBase(0, context, "//following::x");
            assertCountXPath_XPathTestBase(0, context, "/descendant::*/preceding::x");
            assertCountXPath_XPathTestBase(0, context, "/descendant::node()/preceding::x");
        }
    }

    /**
     *  test for jaxen-3
     */
    public void testJaxen3_XPathTestBase() throws JaxenException, Exception {
        this.contextSupport = null;
        System.setProperty(XPathReaderFactory.DRIVER_PROPERTY, "");
        log_XPathTestBase("-----------------------------");
        Navigator nav = getNavigator_XPathTestBase();
        String url = "xml/simple.xml";
        log_XPathTestBase("Document [" + url + "]");
        Object document = nav.getDocument(url);
        XPath contextpath = new BaseXPath("/", nav);
        log_XPathTestBase("Initial Context :: " + contextpath);
        List list = contextpath.selectNodes(document);
        Iterator iter = list.iterator();
        while (iter.hasNext()) {
            Object context = iter.next();
            assertValueOfXPath_XPathTestBase("abd", context, "string()");
        }
    }

    public void testStringFunction1_XPathTestBase() throws JaxenException, Exception {
        this.contextSupport = null;
        System.setProperty(XPathReaderFactory.DRIVER_PROPERTY, "");
        log_XPathTestBase("-----------------------------");
        Navigator nav = getNavigator_XPathTestBase();
        String url = "xml/simple.xml";
        log_XPathTestBase("Document [" + url + "]");
        Object document = nav.getDocument(url);
        XPath contextpath = new BaseXPath("/root", nav);
        log_XPathTestBase("Initial Context :: " + contextpath);
        List list = contextpath.selectNodes(document);
        Iterator iter = list.iterator();
        while (iter.hasNext()) {
            Object context = iter.next();
            assertValueOfXPath_XPathTestBase("abd", context, "string()");
        }
    }

    public void testStringFunction2_XPathTestBase() throws JaxenException, Exception {
        this.contextSupport = null;
        System.setProperty(XPathReaderFactory.DRIVER_PROPERTY, "");
        log_XPathTestBase("-----------------------------");
        Navigator nav = getNavigator_XPathTestBase();
        String url = "xml/simple.xml";
        log_XPathTestBase("Document [" + url + "]");
        Object document = nav.getDocument(url);
        XPath contextpath = new BaseXPath("/root/a", nav);
        log_XPathTestBase("Initial Context :: " + contextpath);
        List list = contextpath.selectNodes(document);
        Iterator iter = list.iterator();
        while (iter.hasNext()) {
            Object context = iter.next();
            assertValueOfXPath_XPathTestBase("a", context, "string()");
        }
    }

    public void testStringFunction3_XPathTestBase() throws JaxenException, Exception {
        this.contextSupport = null;
        System.setProperty(XPathReaderFactory.DRIVER_PROPERTY, "");
        log_XPathTestBase("-----------------------------");
        Navigator nav = getNavigator_XPathTestBase();
        String url = "xml/simple.xml";
        log_XPathTestBase("Document [" + url + "]");
        Object document = nav.getDocument(url);
        XPath contextpath = new BaseXPath("/root/c", nav);
        log_XPathTestBase("Initial Context :: " + contextpath);
        List list = contextpath.selectNodes(document);
        Iterator iter = list.iterator();
        while (iter.hasNext()) {
            Object context = iter.next();
            assertValueOfXPath_XPathTestBase("d", context, "string()");
        }
    }

    /**
     *  test for jaxen-3
     */
    public void testJaxen3dupe_XPathTestBase() throws JaxenException, Exception {
        this.contextSupport = null;
        System.setProperty(XPathReaderFactory.DRIVER_PROPERTY, "");
        log_XPathTestBase("-----------------------------");
        Navigator nav = getNavigator_XPathTestBase();
        String url = "xml/jaxen3.xml";
        log_XPathTestBase("Document [" + url + "]");
        Object document = nav.getDocument(url);
        XPath contextpath = new BaseXPath("/", nav);
        log_XPathTestBase("Initial Context :: " + contextpath);
        List list = contextpath.selectNodes(document);
        Iterator iter = list.iterator();
        while (iter.hasNext()) {
            Object context = iter.next();
            assertCountXPath_XPathTestBase(1, context, "/Configuration/hostname/attrlist/hostname[. = 'CE-A'] ");
        }
    }

    /**
     *  parser test cases all of which should fail
     */
    public void testForParserErrors_XPathTestBase() throws JaxenException, Exception {
        this.contextSupport = null;
        System.setProperty(XPathReaderFactory.DRIVER_PROPERTY, "");
        log_XPathTestBase("-----------------------------");
        Navigator nav = getNavigator_XPathTestBase();
        String url = "xml/numbers.xml";
        log_XPathTestBase("Document [" + url + "]");
        Object document = nav.getDocument(url);
        XPath contextpath = new BaseXPath("/", nav);
        log_XPathTestBase("Initial Context :: " + contextpath);
        List list = contextpath.selectNodes(document);
        Iterator iter = list.iterator();
        while (iter.hasNext()) {
            Object context = iter.next();
            assertInvalidXPath_XPathTestBase(context, "/numbers numbers");
            assertInvalidXPath_XPathTestBase(context, "/a/b[c > d]efg");
            assertInvalidXPath_XPathTestBase(context, "/inv/child::");
            assertInvalidXPath_XPathTestBase(context, "/invoice/@test[abcd");
            assertInvalidXPath_XPathTestBase(context, "/invoice/@test[abcd > x");
            assertInvalidXPath_XPathTestBase(context, "string-length('a");
            assertInvalidXPath_XPathTestBase(context, "/descendant::()");
            assertInvalidXPath_XPathTestBase(context, "(1 + 1");
            assertInvalidXPath_XPathTestBase(context, "!false()");
        }
    }

    /**
     *  test cases for the use of underscores in names
     */
    public void testUnderscoresInNames_XPathTestBase() throws JaxenException, Exception {
        this.contextSupport = null;
        System.setProperty(XPathReaderFactory.DRIVER_PROPERTY, "");
        log_XPathTestBase("-----------------------------");
        Navigator nav = getNavigator_XPathTestBase();
        String url = "xml/underscore.xml";
        log_XPathTestBase("Document [" + url + "]");
        Object document = nav.getDocument(url);
        XPath contextpath = new BaseXPath("/", nav);
        log_XPathTestBase("Initial Context :: " + contextpath);
        List list = contextpath.selectNodes(document);
        Iterator iter = list.iterator();
        while (iter.hasNext()) {
            Object context = iter.next();
            assertCountXPath_XPathTestBase(1, context, "/root/@a");
            assertCountXPath_XPathTestBase(1, context, "/root/@_a");
            assertCountXPath_XPathTestBase(1, context, "/root/b");
            assertCountXPath_XPathTestBase(1, context, "/root/_b");
            assertValueOfXPath_XPathTestBase("1", context, "/root/@a");
            assertValueOfXPath_XPathTestBase("2", context, "/root/@_a");
            assertValueOfXPath_XPathTestBase("1", context, "/root/b");
            assertValueOfXPath_XPathTestBase("2", context, "/root/_b");
        }
    }

    /** 
     * test cases for the use of = with node-sets
     */
    public void testNodesetEqualsString_XPathTestBase() throws JaxenException, Exception {
        this.contextSupport = null;
        System.setProperty(XPathReaderFactory.DRIVER_PROPERTY, "");
        log_XPathTestBase("-----------------------------");
        Navigator nav = getNavigator_XPathTestBase();
        String url = "xml/web.xml";
        log_XPathTestBase("Document [" + url + "]");
        Object document = nav.getDocument(url);
        XPath contextpath = new BaseXPath("/", nav);
        log_XPathTestBase("Initial Context :: " + contextpath);
        List list = contextpath.selectNodes(document);
        Iterator iter = list.iterator();
        while (iter.hasNext()) {
            Object context = iter.next();
            assertValueOfXPath_XPathTestBase("true", context, "/web-app/servlet/servlet-name = 'file'");
            assertValueOfXPath_XPathTestBase("true", context, "/web-app/servlet/servlet-name = 'snoop'");
        }
    }

    public void testNodesetEqualsNumber_XPathTestBase() throws JaxenException, Exception {
        this.contextSupport = null;
        System.setProperty(XPathReaderFactory.DRIVER_PROPERTY, "");
        log_XPathTestBase("-----------------------------");
        Navigator nav = getNavigator_XPathTestBase();
        String url = "xml/numbers.xml";
        log_XPathTestBase("Document [" + url + "]");
        Object document = nav.getDocument(url);
        XPath contextpath = new BaseXPath("/", nav);
        log_XPathTestBase("Initial Context :: " + contextpath);
        List list = contextpath.selectNodes(document);
        Iterator iter = list.iterator();
        while (iter.hasNext()) {
            Object context = iter.next();
            assertValueOfXPath_XPathTestBase("true", context, "/numbers/set/nr = '-3'");
            assertValueOfXPath_XPathTestBase("true", context, "/numbers/set/nr = -3");
            assertValueOfXPath_XPathTestBase("true", context, "/numbers/set/nr = 24");
            assertValueOfXPath_XPathTestBase("true", context, "/numbers/set/nr/@value = '9999'");
            assertValueOfXPath_XPathTestBase("true", context, "/numbers/set/nr/@value = 9999.0");
            assertValueOfXPath_XPathTestBase("true", context, "/numbers/set/nr/@value = 66");
        }
    }

    /** 
     * test basic math...
     */
    public void testIntegerArithmetic_XPathTestBase() throws JaxenException, Exception {
        this.contextSupport = null;
        System.setProperty(XPathReaderFactory.DRIVER_PROPERTY, "");
        log_XPathTestBase("-----------------------------");
        Navigator nav = getNavigator_XPathTestBase();
        String url = "xml/numbers.xml";
        log_XPathTestBase("Document [" + url + "]");
        Object document = nav.getDocument(url);
        XPath contextpath = new BaseXPath("/", nav);
        log_XPathTestBase("Initial Context :: " + contextpath);
        List list = contextpath.selectNodes(document);
        Iterator iter = list.iterator();
        while (iter.hasNext()) {
            Object context = iter.next();
            assertValueOfXPath_XPathTestBase("true", context, "(8 * 2 + 1) = 17");
            assertValueOfXPath_XPathTestBase("true", context, "(1 + 8 * 2) = 17");
            assertValueOfXPath_XPathTestBase("true", context, "(7 - 3 + 1) = 5");
            assertValueOfXPath_XPathTestBase("true", context, "(8 - 4 + 5 - 6) = 3");
            assertValueOfXPath_XPathTestBase("0", context, "3 - 2 - 1");
            assertValueOfXPath_XPathTestBase("1", context, "8 div 4 div 2");
            assertValueOfXPath_XPathTestBase("3", context, "3 mod 7 mod 5");
            assertValueOfXPath_XPathTestBase("false", context, "1 = 2 = 2");
            assertValueOfXPath_XPathTestBase("false", context, "2 != 3 != 1");
            assertValueOfXPath_XPathTestBase("false", context, "3 > 2 > 1");
            assertValueOfXPath_XPathTestBase("false", context, "3 >= 2 >= 2");
            assertValueOfXPath_XPathTestBase("true", context, "1 < 2 < 3");
            assertValueOfXPath_XPathTestBase("true", context, "2 <= 2 <= 3");
        }
    }

    public void testFloatingPointArithmetic_XPathTestBase() throws JaxenException, Exception {
        this.contextSupport = null;
        System.setProperty(XPathReaderFactory.DRIVER_PROPERTY, "");
        log_XPathTestBase("-----------------------------");
        Navigator nav = getNavigator_XPathTestBase();
        String url = "xml/numbers.xml";
        log_XPathTestBase("Document [" + url + "]");
        Object document = nav.getDocument(url);
        XPath contextpath = new BaseXPath("/", nav);
        log_XPathTestBase("Initial Context :: " + contextpath);
        List list = contextpath.selectNodes(document);
        Iterator iter = list.iterator();
        while (iter.hasNext()) {
            Object context = iter.next();
            assertValueOfXPath_XPathTestBase("true", context, "(8.5 * 2.0 + 1) = 18");
            assertValueOfXPath_XPathTestBase("true", context, "(1.00 + 8.5 * 2) = 18.0");
            assertValueOfXPath_XPathTestBase("true", context, "(7.1 - 7.1 + 1.5) = 1.5");
            assertValueOfXPath_XPathTestBase("true", context, "(8.000 - 4.0 + 5 - 6.00) = 3");
            assertValueOfXPath_XPathTestBase("0", context, "3.5 - 2.5 - 1.0");
            assertValueOfXPath_XPathTestBase("1", context, "8.0 div 4.0 div 2.0");
            assertValueOfXPath_XPathTestBase("3", context, "3.0 mod 7.0 mod 5.0");
            assertValueOfXPath_XPathTestBase("false", context, "1.5 = 2.3 = 2.3");
            assertValueOfXPath_XPathTestBase("false", context, "2.1 != 3.2 != 1.9");
            assertValueOfXPath_XPathTestBase("false", context, "3.8 > 2.7 > 1.6");
            assertValueOfXPath_XPathTestBase("false", context, "3.4 >= 2.5 >= 2.5");
            assertValueOfXPath_XPathTestBase("true", context, "1.4 < 2.3 < 3.2");
            assertValueOfXPath_XPathTestBase("true", context, "2.5 <= 2.5 <= 3.5");
        }
    }

    /** 
     * test cases for preceding axis with different node types
     */
    public void testPrecedingSiblingAxis_XPathTestBase() throws JaxenException, Exception {
        this.contextSupport = null;
        System.setProperty(XPathReaderFactory.DRIVER_PROPERTY, "");
        log_XPathTestBase("-----------------------------");
        Navigator nav = getNavigator_XPathTestBase();
        String url = "xml/pi2.xml";
        log_XPathTestBase("Document [" + url + "]");
        Object document = nav.getDocument(url);
        XPath contextpath = new BaseXPath("/a/c", nav);
        log_XPathTestBase("Initial Context :: " + contextpath);
        List list = contextpath.selectNodes(document);
        Iterator iter = list.iterator();
        while (iter.hasNext()) {
            Object context = iter.next();
            assertCountXPath_XPathTestBase(1, context, "//processing-instruction()");
            assertCountXPath_XPathTestBase(1, context, "preceding-sibling::*");
            assertCountXPath_XPathTestBase(5, context, "preceding-sibling::node()");
            assertCountXPath_XPathTestBase(1, context, "preceding-sibling::*[1]");
            assertCountXPath_XPathTestBase(1, context, "preceding-sibling::processing-instruction()");
            assertValueOfXPath_XPathTestBase("order-by=\"x\"", context, "preceding-sibling::processing-instruction()");
            assertValueOfXPath_XPathTestBase("foo", context, "preceding-sibling::*[1]");
            assertValueOfXPath_XPathTestBase("order-by=\"x\"", context, "preceding-sibling::node()[2]");
        }
    }

    public void testVariableLookup_XPathTestBase() throws JaxenException, Exception {
        this.contextSupport = null;
        System.setProperty(XPathReaderFactory.DRIVER_PROPERTY, "");
        log_XPathTestBase("-----------------------------");
        Navigator nav = getNavigator_XPathTestBase();
        String url = "xml/id.xml";
        log_XPathTestBase("Document [" + url + "]");
        Object document = nav.getDocument(url);
        XPath contextpath = new BaseXPath("/", nav);
        log_XPathTestBase("Initial Context :: " + contextpath);
        List list = contextpath.selectNodes(document);
        SimpleVariableContext varContext = new SimpleVariableContext();
        varContext.setVariableValue(null, "foobar", "foobar");
        varContext.setVariableValue(null, "foo", "foo");
        getContextSupport_XPathTestBase().setVariableContext(varContext);
        Iterator iter = list.iterator();
        while (iter.hasNext()) {
            Object context = iter.next();
            assertValueOfXPath_XPathTestBase("foobar", context, "$foobar");
            assertCountXPath_XPathTestBase(1, context, "/foo[@id=$foobar]");
            assertCountXPath_XPathTestBase(0, context, "/foo[@id='$foobar']");
            assertCountXPath_XPathTestBase(1, context, "/foo[concat($foo, 'bar')=@id]");
            assertCountXPath_XPathTestBase(0, context, "CD_Library/artist[@name=$artist]");
        }
    }

    public void testAttributeParent_XPathTestBase() throws JaxenException, Exception {
        this.contextSupport = null;
        System.setProperty(XPathReaderFactory.DRIVER_PROPERTY, "");
        log_XPathTestBase("-----------------------------");
        Navigator nav = getNavigator_XPathTestBase();
        String url = "xml/id.xml";
        log_XPathTestBase("Document [" + url + "]");
        Object document = nav.getDocument(url);
        XPath contextpath = new BaseXPath("/", nav);
        log_XPathTestBase("Initial Context :: " + contextpath);
        List list = contextpath.selectNodes(document);
        Iterator iter = list.iterator();
        while (iter.hasNext()) {
            Object context = iter.next();
            assertCountXPath_XPathTestBase(1, context, "/foo/@id/parent::foo");
        }
    }

    /** 
     * attributes can also be used as context nodes
     */
    public void testAttributeAsContext_XPathTestBase() throws JaxenException, Exception {
        this.contextSupport = null;
        System.setProperty(XPathReaderFactory.DRIVER_PROPERTY, "");
        log_XPathTestBase("-----------------------------");
        Navigator nav = getNavigator_XPathTestBase();
        String url = "xml/id.xml";
        log_XPathTestBase("Document [" + url + "]");
        Object document = nav.getDocument(url);
        XPath contextpath = new BaseXPath("/foo/@id", nav);
        log_XPathTestBase("Initial Context :: " + contextpath);
        List list = contextpath.selectNodes(document);
        Iterator iter = list.iterator();
        while (iter.hasNext()) {
            Object context = iter.next();
            assertCountXPath_XPathTestBase(1, context, "parent::foo");
        }
    }

    public void testid53992_XPathTestBase() throws JaxenException, Exception {
        this.contextSupport = null;
        System.setProperty(XPathReaderFactory.DRIVER_PROPERTY, "");
        log_XPathTestBase("-----------------------------");
        Navigator nav = getNavigator_XPathTestBase();
        String url = "xml/pi.xml";
        log_XPathTestBase("Document [" + url + "]");
        Object document = nav.getDocument(url);
        XPath contextpath = new BaseXPath("/", nav);
        log_XPathTestBase("Initial Context :: " + contextpath);
        List list = contextpath.selectNodes(document);
        Iterator iter = list.iterator();
        while (iter.hasNext()) {
            Object context = iter.next();
            assertCountXPath_XPathTestBase(3, context, "//processing-instruction()");
            assertCountXPath_XPathTestBase(2, context, "//processing-instruction('cheese')");
            Object result = assertCountXPath2_XPathTestBase(1, context, "//processing-instruction('toast')");
            assertValueOfXPath_XPathTestBase("is tasty", result, "string()");
        }
    }

    /** 
     * test evaluate() extension function
     */
    public void testid54032_XPathTestBase() throws JaxenException, Exception {
        this.contextSupport = null;
        System.setProperty(XPathReaderFactory.DRIVER_PROPERTY, "");
        log_XPathTestBase("-----------------------------");
        Navigator nav = getNavigator_XPathTestBase();
        String url = "xml/evaluate.xml";
        log_XPathTestBase("Document [" + url + "]");
        Object document = nav.getDocument(url);
        XPath contextpath = new BaseXPath("/", nav);
        log_XPathTestBase("Initial Context :: " + contextpath);
        List list = contextpath.selectNodes(document);
        Iterator iter = list.iterator();
        while (iter.hasNext()) {
            Object context = iter.next();
            assertCountXPath_XPathTestBase(3, context, "evaluate('//jumps/*')");
            assertCountXPath_XPathTestBase(1, context, "evaluate('//jumps/object/dog')");
            assertCountXPath_XPathTestBase(0, context, "evaluate('//jumps/object')/evaluate");
            assertCountXPath_XPathTestBase(1, context, "evaluate('//jumps/object')/dog");
            assertCountXPath_XPathTestBase(1, context, "evaluate('//jumps/*')/dog");
            assertCountXPath_XPathTestBase(1, context, "//metatest[ evaluate(@select) = . ]");
        }
    }

    public void testid54082_XPathTestBase() throws JaxenException, Exception {
        this.contextSupport = null;
        System.setProperty(XPathReaderFactory.DRIVER_PROPERTY, "");
        log_XPathTestBase("-----------------------------");
        Navigator nav = getNavigator_XPathTestBase();
        String url = "xml/numbers.xml";
        log_XPathTestBase("Document [" + url + "]");
        Object document = nav.getDocument(url);
        XPath contextpath = new BaseXPath("/numbers/set[1]", nav);
        log_XPathTestBase("Initial Context :: " + contextpath);
        List list = contextpath.selectNodes(document);
        Iterator iter = list.iterator();
        while (iter.hasNext()) {
            Object context = iter.next();
            assertCountXPath_XPathTestBase(1, context, "*[-3 = .]");
            assertValueOfXPath_XPathTestBase("true", context, "54 < *");
            assertValueOfXPath_XPathTestBase("true", context, "55 <= *");
            assertValueOfXPath_XPathTestBase("false", context, "69 < *");
            assertValueOfXPath_XPathTestBase("true", context, "-2 > *");
            assertValueOfXPath_XPathTestBase("true", context, "-3 >= *");
            assertValueOfXPath_XPathTestBase("false", context, "-4 >= *");
        }
    }

    /** 
     * test sibling axes 
     */
    public void testid54145_XPathTestBase() throws JaxenException, Exception {
        this.contextSupport = null;
        System.setProperty(XPathReaderFactory.DRIVER_PROPERTY, "");
        log_XPathTestBase("-----------------------------");
        Navigator nav = getNavigator_XPathTestBase();
        String url = "xml/axis.xml";
        log_XPathTestBase("Document [" + url + "]");
        Object document = nav.getDocument(url);
        XPath contextpath = new BaseXPath("/root", nav);
        log_XPathTestBase("Initial Context :: " + contextpath);
        List list = contextpath.selectNodes(document);
        Iterator iter = list.iterator();
        while (iter.hasNext()) {
            Object context = iter.next();
            assertCountXPath_XPathTestBase(0, context, "preceding-sibling::*");
        }
    }

    public void testid54156_XPathTestBase() throws JaxenException, Exception {
        this.contextSupport = null;
        System.setProperty(XPathReaderFactory.DRIVER_PROPERTY, "");
        log_XPathTestBase("-----------------------------");
        Navigator nav = getNavigator_XPathTestBase();
        String url = "xml/axis.xml";
        log_XPathTestBase("Document [" + url + "]");
        Object document = nav.getDocument(url);
        org.jaxen.XPath contextpath = new org.jaxen.BaseXPath("/root/a/a.3", nav);
        log_XPathTestBase("Initial Context :: " + contextpath);
        List list = contextpath.selectNodes(document);
        Iterator iter = list.iterator();
        while (iter.hasNext()) {
            Object context = iter.next();
            assertCountXPath_XPathTestBase(2, context, "preceding::*");
        }
    }

    public void testid54168_XPathTestBase() throws JaxenException, Exception {
        this.contextSupport = null;
        System.setProperty(XPathReaderFactory.DRIVER_PROPERTY, "");
        log_XPathTestBase("-----------------------------");
        Navigator nav = getNavigator_XPathTestBase();
        String url = "xml/axis.xml";
        log_XPathTestBase("Document [" + url + "]");
        Object document = nav.getDocument(url);
        XPath contextpath = new BaseXPath("/root/a/a.3", nav);
        log_XPathTestBase("Initial Context :: " + contextpath);
        List list = contextpath.selectNodes(document);
        Iterator iter = list.iterator();
        while (iter.hasNext()) {
            Object context = iter.next();
            assertCountXPath_XPathTestBase(2, context, "preceding-sibling::*");
        }
    }

    public void testid54180_XPathTestBase() throws JaxenException, Exception {
        this.contextSupport = null;
        System.setProperty(XPathReaderFactory.DRIVER_PROPERTY, "");
        log_XPathTestBase("-----------------------------");
        Navigator nav = getNavigator_XPathTestBase();
        String url = "xml/axis.xml";
        log_XPathTestBase("Document [" + url + "]");
        Object document = nav.getDocument(url);
        XPath contextpath = new BaseXPath("/", nav);
        log_XPathTestBase("Initial Context :: " + contextpath);
        List list = contextpath.selectNodes(document);
        Iterator iter = list.iterator();
        while (iter.hasNext()) {
            Object context = iter.next();
            assertValueOfXPath_XPathTestBase("a.2", context, "name(/root/a/a.3/preceding-sibling::*[1])");
            assertValueOfXPath_XPathTestBase("a.1", context, "name(/root/a/a.3/preceding-sibling::*[2])");
        }
    }

    public void testid54197_XPathTestBase() throws JaxenException, Exception {
        this.contextSupport = null;
        System.setProperty(XPathReaderFactory.DRIVER_PROPERTY, "");
        log_XPathTestBase("-----------------------------");
        Navigator nav = getNavigator_XPathTestBase();
        String url = "xml/axis.xml";
        log_XPathTestBase("Document [" + url + "]");
        Object document = nav.getDocument(url);
        XPath contextpath = new BaseXPath("/", nav);
        log_XPathTestBase("Initial Context :: " + contextpath);
        List list = contextpath.selectNodes(document);
        Iterator iter = list.iterator();
        while (iter.hasNext()) {
            Object context = iter.next();
            assertValueOfXPath_XPathTestBase("a.4", context, "name(/root/a/a.3/following-sibling::*[1])");
            assertValueOfXPath_XPathTestBase("a.5", context, "name(/root/a/a.3/following-sibling::*[2])");
        }
    }

    public void testid54219_XPathTestBase() throws JaxenException, Exception {
        this.contextSupport = null;
        System.setProperty(XPathReaderFactory.DRIVER_PROPERTY, "");
        log_XPathTestBase("-----------------------------");
        Navigator nav = getNavigator_XPathTestBase();
        String url = "xml/web.xml";
        log_XPathTestBase("Document [" + url + "]");
        Object document = nav.getDocument(url);
        XPath contextpath = new BaseXPath("/", nav);
        log_XPathTestBase("Initial Context :: " + contextpath);
        List list = contextpath.selectNodes(document);
        Iterator iter = list.iterator();
        while (iter.hasNext()) {
            Object context = iter.next();
            assertValueOfXPath_XPathTestBase("snoop", context, "/web-app/servlet[1]/servlet-name");
            assertValueOfXPath_XPathTestBase("snoop", context, "/web-app/servlet[1]/servlet-name/text()");
            assertValueOfXPath_XPathTestBase("file", context, "/web-app/servlet[2]/servlet-name");
            assertValueOfXPath_XPathTestBase("file", context, "/web-app/servlet[2]/servlet-name/text()");
        }
    }

    public void testid54249_XPathTestBase() throws JaxenException, Exception {
        this.contextSupport = null;
        System.setProperty(XPathReaderFactory.DRIVER_PROPERTY, "");
        log_XPathTestBase("-----------------------------");
        Navigator nav = getNavigator_XPathTestBase();
        String url = "xml/web.xml";
        log_XPathTestBase("Document [" + url + "]");
        Object document = nav.getDocument(url);
        XPath contextpath = new BaseXPath("/web-app/servlet[1]", nav);
        log_XPathTestBase("Initial Context :: " + contextpath);
        List list = contextpath.selectNodes(document);
        Iterator iter = list.iterator();
        while (iter.hasNext()) {
            Object context = iter.next();
            assertValueOfXPath_XPathTestBase("snoop", context, "servlet-name");
            assertValueOfXPath_XPathTestBase("snoop", context, "servlet-name/text()");
        }
    }

    public void testid54266_XPathTestBase() throws JaxenException, Exception {
        this.contextSupport = null;
        System.setProperty(XPathReaderFactory.DRIVER_PROPERTY, "");
        log_XPathTestBase("-----------------------------");
        Navigator nav = getNavigator_XPathTestBase();
        String url = "xml/web.xml";
        log_XPathTestBase("Document [" + url + "]");
        Object document = nav.getDocument(url);
        XPath contextpath = new BaseXPath("/web-app/servlet[2]/servlet-name", nav);
        log_XPathTestBase("Initial Context :: " + contextpath);
        List list = contextpath.selectNodes(document);
        Iterator iter = list.iterator();
        while (iter.hasNext()) {
            Object context = iter.next();
            assertCountXPath_XPathTestBase(3, context, "preceding::*");
        }
    }

    public void testid54278_XPathTestBase() throws JaxenException, Exception {
        this.contextSupport = null;
        System.setProperty(XPathReaderFactory.DRIVER_PROPERTY, "");
        log_XPathTestBase("-----------------------------");
        Navigator nav = getNavigator_XPathTestBase();
        String url = "xml/web.xml";
        log_XPathTestBase("Document [" + url + "]");
        Object document = nav.getDocument(url);
        XPath contextpath = new BaseXPath("/web-app/servlet[2]/servlet-name", nav);
        log_XPathTestBase("Initial Context :: " + contextpath);
        List list = contextpath.selectNodes(document);
        Iterator iter = list.iterator();
        while (iter.hasNext()) {
            Object context = iter.next();
            assertCountXPath_XPathTestBase(13, context, "following::*");
        }
    }

    /**
     *  test name
     */
    public void testid54298_XPathTestBase() throws JaxenException, Exception {
        this.contextSupport = null;
        System.setProperty(XPathReaderFactory.DRIVER_PROPERTY, "");
        log_XPathTestBase("-----------------------------");
        Navigator nav = getNavigator_XPathTestBase();
        String url = "xml/web.xml";
        log_XPathTestBase("Document [" + url + "]");
        Object document = nav.getDocument(url);
        XPath contextpath = new BaseXPath("/", nav);
        log_XPathTestBase("Initial Context :: " + contextpath);
        List list = contextpath.selectNodes(document);
        Iterator iter = list.iterator();
        while (iter.hasNext()) {
            Object context = iter.next();
            Object result = assertCountXPath2_XPathTestBase(1, context, "*");
            assertValueOfXPath_XPathTestBase("web-app", result, "name()");
            result = assertCountXPath2_XPathTestBase(1, context, "./*");
            assertValueOfXPath_XPathTestBase("web-app", result, "name()");
            result = assertCountXPath2_XPathTestBase(1, context, "child::*");
            assertValueOfXPath_XPathTestBase("web-app", result, "name()");
            result = assertCountXPath2_XPathTestBase(1, context, "/*");
            assertValueOfXPath_XPathTestBase("web-app", result, "name()");
            result = assertCountXPath2_XPathTestBase(1, context, "/child::node()");
            assertValueOfXPath_XPathTestBase("web-app", result, "name(.)");
            result = assertCountXPath2_XPathTestBase(1, context, "child::node()");
            assertValueOfXPath_XPathTestBase("web-app", result, "name(.)");
            assertValueOfXPath_XPathTestBase("", context, "name()");
            assertValueOfXPath_XPathTestBase("", context, "name(.)");
            assertValueOfXPath_XPathTestBase("", context, "name(parent::*)");
            assertValueOfXPath_XPathTestBase("", context, "name(/)");
            assertValueOfXPath_XPathTestBase("", context, "name(/.)");
            assertValueOfXPath_XPathTestBase("", context, "name(/self::node())");
            assertValueOfXPath_XPathTestBase("web-app", context, "name(node())");
            assertValueOfXPath_XPathTestBase("web-app", context, "name(/node())");
            assertValueOfXPath_XPathTestBase("web-app", context, "name(/*)");
            assertValueOfXPath_XPathTestBase("web-app", context, "name(/child::*)");
            assertValueOfXPath_XPathTestBase("web-app", context, "name(/child::node())");
            assertValueOfXPath_XPathTestBase("web-app", context, "name(/child::node())");
            assertValueOfXPath_XPathTestBase("web-app", context, "name(child::node())");
            assertValueOfXPath_XPathTestBase("web-app", context, "name(./*)");
            assertValueOfXPath_XPathTestBase("web-app", context, "name(*)");
        }
    }

    public void testid54467_XPathTestBase() throws JaxenException, Exception {
        this.contextSupport = null;
        System.setProperty(XPathReaderFactory.DRIVER_PROPERTY, "");
        log_XPathTestBase("-----------------------------");
        Navigator nav = getNavigator_XPathTestBase();
        String url = "xml/web.xml";
        log_XPathTestBase("Document [" + url + "]");
        Object document = nav.getDocument(url);
        XPath contextpath = new BaseXPath("/*", nav);
        log_XPathTestBase("Initial Context :: " + contextpath);
        List list = contextpath.selectNodes(document);
        Iterator iter = list.iterator();
        while (iter.hasNext()) {
            Object context = iter.next();
            assertValueOfXPath_XPathTestBase("", context, "name(..)");
            assertValueOfXPath_XPathTestBase("", context, "name(parent::node())");
            assertValueOfXPath_XPathTestBase("", context, "name(parent::*)");
            assertValueOfXPath_XPathTestBase("web-app", context, "name()");
            assertValueOfXPath_XPathTestBase("web-app", context, "name(.)");
            assertValueOfXPath_XPathTestBase("web-app", context, "name(../*)");
            assertValueOfXPath_XPathTestBase("web-app", context, "name(../child::node())");
        }
    }

    /** 
     * test predicates
     */
    public void testid54522_XPathTestBase() throws JaxenException, Exception {
        this.contextSupport = null;
        System.setProperty(XPathReaderFactory.DRIVER_PROPERTY, "");
        log_XPathTestBase("-----------------------------");
        Navigator nav = getNavigator_XPathTestBase();
        String url = "xml/nitf.xml";
        log_XPathTestBase("Document [" + url + "]");
        Object document = nav.getDocument(url);
        XPath contextpath = new BaseXPath("/nitf/head/docdata", nav);
        log_XPathTestBase("Initial Context :: " + contextpath);
        List list = contextpath.selectNodes(document);
        Iterator iter = list.iterator();
        while (iter.hasNext()) {
            Object context = iter.next();
            assertCountXPath_XPathTestBase(1, context, "doc-id[@regsrc='FAKE' and @id-string='YYY']");
        }
    }

    public void testid54534_XPathTestBase() throws JaxenException, Exception {
        this.contextSupport = null;
        System.setProperty(XPathReaderFactory.DRIVER_PROPERTY, "");
        log_XPathTestBase("-----------------------------");
        Navigator nav = getNavigator_XPathTestBase();
        String url = "xml/nitf.xml";
        log_XPathTestBase("Document [" + url + "]");
        Object document = nav.getDocument(url);
        XPath contextpath = new BaseXPath("/nitf/head", nav);
        log_XPathTestBase("Initial Context :: " + contextpath);
        List list = contextpath.selectNodes(document);
        Iterator iter = list.iterator();
        while (iter.hasNext()) {
            Object context = iter.next();
            assertCountXPath_XPathTestBase(1, context, "meta[@name='fake-cycle']");
            assertCountXPath_XPathTestBase(1, context, "meta[@content='FAKE']");
            assertCountXPath_XPathTestBase(8, context, "meta[@name and @content]");
            assertCountXPath_XPathTestBase(1, context, "meta[@name='fake-cycle' and @content='FAKE']");
            assertCountXPath_XPathTestBase(7, context, "meta[@name != 'fake-cycle']");
        }
    }

    public void testid54570_XPathTestBase() throws JaxenException, Exception {
        this.contextSupport = null;
        System.setProperty(XPathReaderFactory.DRIVER_PROPERTY, "");
        log_XPathTestBase("-----------------------------");
        Navigator nav = getNavigator_XPathTestBase();
        String url = "xml/nitf.xml";
        log_XPathTestBase("Document [" + url + "]");
        Object document = nav.getDocument(url);
        XPath contextpath = new BaseXPath("/", nav);
        log_XPathTestBase("Initial Context :: " + contextpath);
        List list = contextpath.selectNodes(document);
        Iterator iter = list.iterator();
        while (iter.hasNext()) {
            Object context = iter.next();
            assertCountXPath_XPathTestBase(1, context, "/nitf/head/meta[@name='fake-cycle']");
            assertCountXPath_XPathTestBase(1, context, "/nitf/head/meta[@content='FAKE']");
            assertCountXPath_XPathTestBase(8, context, "/nitf/head/meta[@name and @content]");
            assertCountXPath_XPathTestBase(1, context, "/nitf/head/meta[@name='fake-cycle' and @content='FAKE']");
            assertCountXPath_XPathTestBase(7, context, "/nitf/head/meta[@name != 'fake-cycle']");
        }
    }

    public void testid54614_XPathTestBase() throws JaxenException, Exception {
        this.contextSupport = null;
        System.setProperty(XPathReaderFactory.DRIVER_PROPERTY, "");
        log_XPathTestBase("-----------------------------");
        Navigator nav = getNavigator_XPathTestBase();
        String url = "xml/moreover.xml";
        log_XPathTestBase("Document [" + url + "]");
        Object document = nav.getDocument(url);
        XPath contextpath = new BaseXPath("/", nav);
        log_XPathTestBase("Initial Context :: " + contextpath);
        List list = contextpath.selectNodes(document);
        Iterator iter = list.iterator();
        while (iter.hasNext()) {
            Object context = iter.next();
            assertCountXPath_XPathTestBase(1, context, "/child::node()");
            assertCountXPath_XPathTestBase(1, context, "/*");
            assertCountXPath_XPathTestBase(20, context, "/*/article");
            assertCountXPath_XPathTestBase(221, context, "//*");
            assertCountXPath_XPathTestBase(20, context, "//*[local-name()='article']");
            assertCountXPath_XPathTestBase(20, context, "//article");
            assertCountXPath_XPathTestBase(20, context, "/*/*[@code]");
            assertCountXPath_XPathTestBase(1, context, "/moreovernews/article[@code='13563275']");
            DOMXPath xpath = new DOMXPath("/moreovernews/article[@code='13563275']");
            List results = xpath.selectNodes(getContext_XPathTestBase(context));
            Object result = results.get(0);
            assertValueOfXPath_XPathTestBase("http://c.moreover.com/click/here.pl?x13563273", result, "url");
            xpath = new DOMXPath("/*/article[@code='13563275']");
            results = xpath.selectNodes(getContext_XPathTestBase(context));
            result = results.get(0);
            assertValueOfXPath_XPathTestBase("http://c.moreover.com/click/here.pl?x13563273", result, "url");
            xpath = new DOMXPath("//article[@code='13563275']");
            results = xpath.selectNodes(getContext_XPathTestBase(context));
            result = results.get(0);
            assertValueOfXPath_XPathTestBase("http://c.moreover.com/click/here.pl?x13563273", result, "url");
            xpath = new DOMXPath("//*[@code='13563275']");
            results = xpath.selectNodes(getContext_XPathTestBase(context));
            result = results.get(0);
            assertValueOfXPath_XPathTestBase("http://c.moreover.com/click/here.pl?x13563273", result, "url");
            xpath = new DOMXPath("/child::node()/child::node()[@code='13563275']");
            results = xpath.selectNodes(getContext_XPathTestBase(context));
            result = results.get(0);
            assertValueOfXPath_XPathTestBase("http://c.moreover.com/click/here.pl?x13563273", result, "url");
            xpath = new DOMXPath("/*/*[@code='13563275']");
            results = xpath.selectNodes(getContext_XPathTestBase(context));
            result = results.get(0);
            assertValueOfXPath_XPathTestBase("http://c.moreover.com/click/here.pl?x13563273", result, "url");
        }
    }

    /** 
     * test other node types
     */
    public void testNodeTypes_XPathTestBase() throws JaxenException, Exception {
        this.contextSupport = null;
        System.setProperty(XPathReaderFactory.DRIVER_PROPERTY, "");
        log_XPathTestBase("-----------------------------");
        Navigator nav = getNavigator_XPathTestBase();
        String url = "xml/contents.xml";
        log_XPathTestBase("Document [" + url + "]");
        Object document = nav.getDocument(url);
        XPath contextpath = new BaseXPath("/", nav);
        log_XPathTestBase("Initial Context :: " + contextpath);
        List list = contextpath.selectNodes(document);
        Iterator iter = list.iterator();
        while (iter.hasNext()) {
            Object context = iter.next();
            assertCountXPath_XPathTestBase(3, context, "processing-instruction()");
            assertCountXPath_XPathTestBase(3, context, "/processing-instruction()");
            assertCountXPath_XPathTestBase(1, context, "/comment()");
            assertCountXPath_XPathTestBase(1, context, "comment()");
            assertCountXPath_XPathTestBase(2, context, "/child::node()/comment()");
            assertCountXPath_XPathTestBase(2, context, "/*/comment()");
            assertCountXPath_XPathTestBase(3, context, "//comment()");
        }
    }

    /** 
     * test positioning
     */
    public void testPositioning_XPathTestBase() throws JaxenException, Exception {
        this.contextSupport = null;
        System.setProperty(XPathReaderFactory.DRIVER_PROPERTY, "");
        log_XPathTestBase("-----------------------------");
        Navigator nav = getNavigator_XPathTestBase();
        String url = "xml/fibo.xml";
        log_XPathTestBase("Document [" + url + "]");
        Object document = nav.getDocument(url);
        XPath contextpath = new BaseXPath("/", nav);
        log_XPathTestBase("Initial Context :: " + contextpath);
        List list = contextpath.selectNodes(document);
        Iterator iter = list.iterator();
        while (iter.hasNext()) {
            Object context = iter.next();
            assertCountXPath_XPathTestBase(9, context, "/*/fibonacci[position() < 10]");
            assertValueOfXPath_XPathTestBase("196417", context, "sum(//fibonacci)");
            assertValueOfXPath_XPathTestBase("325", context, "sum(//fibonacci/@index)");
            assertValueOfXPath_XPathTestBase("1", context, "/*/fibonacci[2]");
            assertValueOfXPath_XPathTestBase("75025", context, "/*/fibonacci[ count(/*/fibonacci) ]");
            assertValueOfXPath_XPathTestBase("46368", context, "/*/fibonacci[ count(/*/fibonacci) - 1 ]");
        }
    }

    public void testid54853_XPathTestBase() throws JaxenException, Exception {
        this.contextSupport = null;
        System.setProperty(XPathReaderFactory.DRIVER_PROPERTY, "");
        log_XPathTestBase("-----------------------------");
        Navigator nav = getNavigator_XPathTestBase();
        String url = "xml/web.xml";
        log_XPathTestBase("Document [" + url + "]");
        Object document = nav.getDocument(url);
        XPath contextpath = new BaseXPath("/", nav);
        log_XPathTestBase("Initial Context :: " + contextpath);
        List list = contextpath.selectNodes(document);
        Iterator iter = list.iterator();
        while (iter.hasNext()) {
            Object context = iter.next();
            assertCountXPath_XPathTestBase(19, context, "descendant-or-self::*");
            assertCountXPath_XPathTestBase(19, context, "descendant::*");
            assertCountXPath_XPathTestBase(19, context, "/descendant::*");
            assertCountXPath_XPathTestBase(19, context, "/descendant-or-self::*");
            assertCountXPath_XPathTestBase(2, context, "/descendant::servlet");
            assertCountXPath_XPathTestBase(2, context, "/descendant-or-self::servlet");
            assertCountXPath_XPathTestBase(2, context, "descendant-or-self::servlet");
            assertCountXPath_XPathTestBase(2, context, "descendant::servlet");
            assertCountXPath_XPathTestBase(2, context, "/*/servlet");
            assertValueOfXPath_XPathTestBase("2", context, "count(/*/servlet)");
            assertCountXPath_XPathTestBase(2, context, "//servlet");
            assertValueOfXPath_XPathTestBase("2", context, "count(//servlet)");
        }
    }

    public void testid54932_XPathTestBase() throws JaxenException, Exception {
        this.contextSupport = null;
        System.setProperty(XPathReaderFactory.DRIVER_PROPERTY, "");
        log_XPathTestBase("-----------------------------");
        Navigator nav = getNavigator_XPathTestBase();
        String url = "xml/web.xml";
        log_XPathTestBase("Document [" + url + "]");
        Object document = nav.getDocument(url);
        XPath contextpath = new BaseXPath("/web-app", nav);
        log_XPathTestBase("Initial Context :: " + contextpath);
        List list = contextpath.selectNodes(document);
        Iterator iter = list.iterator();
        while (iter.hasNext()) {
            Object context = iter.next();
            assertCountXPath_XPathTestBase(2, context, "/descendant::servlet");
            assertCountXPath_XPathTestBase(2, context, "/descendant-or-self::servlet");
            assertCountXPath_XPathTestBase(2, context, "descendant-or-self::servlet");
            assertCountXPath_XPathTestBase(2, context, "descendant::servlet");
        }
    }

    public void testCountFunction_XPathTestBase() throws JaxenException, Exception {
        this.contextSupport = null;
        System.setProperty(XPathReaderFactory.DRIVER_PROPERTY, "");
        log_XPathTestBase("-----------------------------");
        Navigator nav = getNavigator_XPathTestBase();
        String url = "xml/much_ado.xml";
        log_XPathTestBase("Document [" + url + "]");
        Object document = nav.getDocument(url);
        XPath contextpath = new BaseXPath("/", nav);
        log_XPathTestBase("Initial Context :: " + contextpath);
        List list = contextpath.selectNodes(document);
        Iterator iter = list.iterator();
        while (iter.hasNext()) {
            Object context = iter.next();
            assertCountXPath_XPathTestBase(5, context, "/descendant::ACT");
            assertCountXPath_XPathTestBase(5, context, "descendant::ACT");
            assertValueOfXPath_XPathTestBase("Much Ado about Nothing", context, "/PLAY/TITLE");
            assertValueOfXPath_XPathTestBase("4", context, "2+2");
            assertValueOfXPath_XPathTestBase("21", context, "5 * 4 + 1");
            assertValueOfXPath_XPathTestBase("5", context, "count(descendant::ACT)");
            assertValueOfXPath_XPathTestBase("35", context, "10 + count(descendant::ACT) * 5");
            assertValueOfXPath_XPathTestBase("75", context, "(10 + count(descendant::ACT)) * 5");
        }
    }

    public void testCountFunctionMore_XPathTestBase() throws JaxenException, Exception {
        this.contextSupport = null;
        System.setProperty(XPathReaderFactory.DRIVER_PROPERTY, "");
        log_XPathTestBase("-----------------------------");
        Navigator nav = getNavigator_XPathTestBase();
        String url = "xml/much_ado.xml";
        log_XPathTestBase("Document [" + url + "]");
        Object document = nav.getDocument(url);
        XPath contextpath = new BaseXPath("/PLAY/ACT[2]/SCENE[1]", nav);
        log_XPathTestBase("Initial Context :: " + contextpath);
        List list = contextpath.selectNodes(document);
        Iterator iter = list.iterator();
        while (iter.hasNext()) {
            Object context = iter.next();
            assertCountXPath_XPathTestBase(5, context, "/descendant::ACT");
            assertCountXPath_XPathTestBase(5, context, "../../descendant::ACT");
            assertCountXPath_XPathTestBase(141, context, "/PLAY/ACT[2]/SCENE[1]/descendant::SPEAKER");
            assertCountXPath_XPathTestBase(141, context, "descendant::SPEAKER");
            assertValueOfXPath_XPathTestBase("646", context, "count(descendant::*)+1");
            assertValueOfXPath_XPathTestBase("142", context, "count(descendant::SPEAKER)+1");
            assertValueOfXPath_XPathTestBase("2", context, "count(ancestor::*)");
            assertValueOfXPath_XPathTestBase("1", context, "count(ancestor::PLAY)");
            assertValueOfXPath_XPathTestBase("3", context, "count(ancestor-or-self::*)");
            assertValueOfXPath_XPathTestBase("1", context, "count(ancestor-or-self::PLAY)");
            assertValueOfXPath_XPathTestBase("6", context, "5+count(ancestor::*)-1");
        }
    }

    public void testCorrectPredicateApplication_XPathTestBase() throws JaxenException, Exception {
        this.contextSupport = null;
        System.setProperty(XPathReaderFactory.DRIVER_PROPERTY, "");
        log_XPathTestBase("-----------------------------");
        Navigator nav = getNavigator_XPathTestBase();
        String url = "xml/much_ado.xml";
        log_XPathTestBase("Document [" + url + "]");
        Object document = nav.getDocument(url);
        XPath contextpath = new BaseXPath("/", nav);
        log_XPathTestBase("Initial Context :: " + contextpath);
        List list = contextpath.selectNodes(document);
        Iterator iter = list.iterator();
        while (iter.hasNext()) {
            Object context = iter.next();
            assertValueOfXPath_XPathTestBase("5", context, "count(/PLAY/ACT/SCENE[1])");
        }
    }

    /** test axis node ordering
    */
    public void testAxisNodeOrdering_XPathTestBase() throws JaxenException, Exception {
        this.contextSupport = null;
        System.setProperty(XPathReaderFactory.DRIVER_PROPERTY, "");
        log_XPathTestBase("-----------------------------");
        Navigator nav = getNavigator_XPathTestBase();
        String url = "xml/web.xml";
        log_XPathTestBase("Document [" + url + "]");
        Object document = nav.getDocument(url);
        XPath contextpath = new BaseXPath("/", nav);
        log_XPathTestBase("Initial Context :: " + contextpath);
        List list = contextpath.selectNodes(document);
        Iterator iter = list.iterator();
        while (iter.hasNext()) {
            Object context = iter.next();
            assertCountXPath_XPathTestBase(1, context, "//servlet-mapping/preceding::*[1][name()='description']");
            assertCountXPath_XPathTestBase(1, context, "/web-app/servlet//description/following::*[1][name()='servlet-mapping']");
            assertCountXPath_XPathTestBase(1, context, "/web-app/servlet//description/following::*[2][name()='servlet-name']");
        }
    }

    /** 
     * test document function
     */
    public void testDocumentFunction1_XPathTestBase() throws JaxenException, Exception {
        this.contextSupport = null;
        System.setProperty(XPathReaderFactory.DRIVER_PROPERTY, "");
        log_XPathTestBase("-----------------------------");
        Navigator nav = getNavigator_XPathTestBase();
        String url = "xml/text.xml";
        log_XPathTestBase("Document [" + url + "]");
        Object document = nav.getDocument(url);
        XPath contextpath = new BaseXPath("/", nav);
        log_XPathTestBase("Initial Context :: " + contextpath);
        List list = contextpath.selectNodes(document);
        Iterator iter = list.iterator();
        while (iter.hasNext()) {
            Object context = iter.next();
            Object result = assertCountXPath2_XPathTestBase(1, context, "document('xml/web.xml')");
            assertValueOfXPath_XPathTestBase("snoop", result, "/web-app/servlet[1]/servlet-name");
            assertValueOfXPath_XPathTestBase("snoop", result, "/web-app/servlet[1]/servlet-name/text()");
            assertValueOfXPath_XPathTestBase("snoop", context, "document('xml/web.xml')/web-app/servlet[1]/servlet-name");
        }
    }

    /** 
     * Test to check if the context changes when an extension function is used.
     * First test is an example, second is the actual test.
     */
    public void testDocumentFunctionContextExample_XPathTestBase() throws JaxenException, Exception {
        this.contextSupport = null;
        System.setProperty(XPathReaderFactory.DRIVER_PROPERTY, "");
        log_XPathTestBase("-----------------------------");
        Navigator nav = getNavigator_XPathTestBase();
        String url = "xml/text.xml";
        log_XPathTestBase("Document [" + url + "]");
        Object document = nav.getDocument(url);
        XPath contextpath = new BaseXPath("/foo/bar/cheese[1]", nav);
        log_XPathTestBase("Initial Context :: " + contextpath);
        List list = contextpath.selectNodes(document);
        Iterator iter = list.iterator();
        while (iter.hasNext()) {
            Object context = iter.next();
            assertValueOfXPath_XPathTestBase("3foo3", context, "concat(./@id,'foo',@id)");
            assertValueOfXPath_XPathTestBase("3snoop3", context, "concat(./@id,document('xml/web.xml')/web-app/servlet[1]/servlet-name,./@id)");
        }
    }

    public void testDocumentFunctionActual_XPathTestBase() throws JaxenException, Exception {
        this.contextSupport = null;
        System.setProperty(XPathReaderFactory.DRIVER_PROPERTY, "");
        log_XPathTestBase("-----------------------------");
        Navigator nav = getNavigator_XPathTestBase();
        String url = "xml/message.xml";
        log_XPathTestBase("Document [" + url + "]");
        Object document = nav.getDocument(url);
        XPath contextpath = new BaseXPath("/", nav);
        log_XPathTestBase("Initial Context :: " + contextpath);
        List list = contextpath.selectNodes(document);
        Iterator iter = list.iterator();
        while (iter.hasNext()) {
            Object context = iter.next();
            assertValueOfXPath_XPathTestBase("Pruefgebiete", context, "/message/body/data/items/item[name/text()='parentinfo']/value");
            assertValueOfXPath_XPathTestBase("Pruefgebiete", context, "document('xml/message.xml')/message/body/data/items/item[name/text()='parentinfo']/value");
        }
    }

    /** 
     * test behavior of AbsoluteLocationPath
     */
    public void testAbsoluteLocationPaths_XPathTestBase() throws JaxenException, Exception {
        this.contextSupport = null;
        System.setProperty(XPathReaderFactory.DRIVER_PROPERTY, "");
        log_XPathTestBase("-----------------------------");
        Navigator nav = getNavigator_XPathTestBase();
        String url = "xml/simple.xml";
        log_XPathTestBase("Document [" + url + "]");
        Object document = nav.getDocument(url);
        XPath contextpath = new BaseXPath("/root/a", nav);
        log_XPathTestBase("Initial Context :: " + contextpath);
        List list = contextpath.selectNodes(document);
        Iterator iter = list.iterator();
        while (iter.hasNext()) {
            Object context = iter.next();
            assertValueOfXPath_XPathTestBase("ab", context, "concat( ., /root/b )");
            assertValueOfXPath_XPathTestBase("ba", context, "concat( ../b, . )");
            assertValueOfXPath_XPathTestBase("ba", context, "concat( /root/b, . )");
            assertValueOfXPath_XPathTestBase("db", context, "concat( /root/c/d, ../b )");
        }
    }

    /** 
     * test the translate() function
     */
    public void testTranslateFunction_XPathTestBase() throws JaxenException, Exception {
        this.contextSupport = null;
        System.setProperty(XPathReaderFactory.DRIVER_PROPERTY, "");
        log_XPathTestBase("-----------------------------");
        Navigator nav = getNavigator_XPathTestBase();
        String url = "xml/simple.xml";
        log_XPathTestBase("Document [" + url + "]");
        Object document = nav.getDocument(url);
        XPath contextpath = new BaseXPath("/", nav);
        log_XPathTestBase("Initial Context :: " + contextpath);
        List list = contextpath.selectNodes(document);
        Iterator iter = list.iterator();
        while (iter.hasNext()) {
            Object context = iter.next();
            assertValueOfXPath_XPathTestBase("", context, "translate( '', '', '' )");
            assertValueOfXPath_XPathTestBase("abcd", context, "translate( 'abcd', '', '' )");
            assertValueOfXPath_XPathTestBase("abcd", context, "translate( 'abcd', 'abcd', 'abcd' )");
            assertValueOfXPath_XPathTestBase("abcd", context, "translate( 'abcd', 'dcba', 'dcba' )");
            assertValueOfXPath_XPathTestBase("dcba", context, "translate( 'abcd', 'abcd', 'dcba' )");
            assertValueOfXPath_XPathTestBase("ab", context, "translate( 'abcd', 'abcd', 'ab' )");
            assertValueOfXPath_XPathTestBase("cd", context, "translate( 'abcd', 'cdab', 'cd' )");
            assertValueOfXPath_XPathTestBase("xy", context, "translate( 'abcd', 'acbd', 'xy' )");
            assertValueOfXPath_XPathTestBase("abcd", context, "translate( 'abcd', 'abcdb', 'abcdb' )");
            assertValueOfXPath_XPathTestBase("abcd", context, "translate( 'abcd', 'abcd', 'abcdb' )");
        }
    }

    public void testSubstringFunction_XPathTestBase() throws JaxenException, Exception {
        this.contextSupport = null;
        System.setProperty(XPathReaderFactory.DRIVER_PROPERTY, "");
        log_XPathTestBase("-----------------------------");
        Navigator nav = getNavigator_XPathTestBase();
        String url = "xml/simple.xml";
        log_XPathTestBase("Document [" + url + "]");
        Object document = nav.getDocument(url);
        XPath contextpath = new BaseXPath("/", nav);
        log_XPathTestBase("Initial Context :: " + contextpath);
        List list = contextpath.selectNodes(document);
        Iterator iter = list.iterator();
        while (iter.hasNext()) {
            Object context = iter.next();
            assertValueOfXPath_XPathTestBase("234", context, "substring('12345', 1.5, 2.6)");
            assertValueOfXPath_XPathTestBase("12", context, "substring('12345', 0, 3)");
            assertValueOfXPath_XPathTestBase("", context, "substring('12345', 0 div 0, 3)");
            assertValueOfXPath_XPathTestBase("", context, "substring('12345', 1, 0 div 0)");
            assertValueOfXPath_XPathTestBase("12345", context, "substring('12345', -42, 1 div 0)");
            assertValueOfXPath_XPathTestBase("", context, "substring('12345', -1 div 0, 1 div 0)");
            assertValueOfXPath_XPathTestBase("345", context, "substring('12345', 3)");
            assertValueOfXPath_XPathTestBase("12345", context, "substring('12345',1,15)");
        }
    }

    /** 
     * Some tests for the normalize-space() function
     */
    public void testNormalizeSpaceFunction_XPathTestBase() throws JaxenException, Exception {
        this.contextSupport = null;
        System.setProperty(XPathReaderFactory.DRIVER_PROPERTY, "");
        log_XPathTestBase("-----------------------------");
        Navigator nav = getNavigator_XPathTestBase();
        String url = "xml/simple.xml";
        log_XPathTestBase("Document [" + url + "]");
        Object document = nav.getDocument(url);
        XPath contextpath = new BaseXPath("/", nav);
        log_XPathTestBase("Initial Context :: " + contextpath);
        List list = contextpath.selectNodes(document);
        Iterator iter = list.iterator();
        while (iter.hasNext()) {
            Object context = iter.next();
            assertValueOfXPath_XPathTestBase("abc", context, "normalize-space('    abc    ')");
            assertValueOfXPath_XPathTestBase("a b c", context, "normalize-space(' a  b  c  ')");
            assertValueOfXPath_XPathTestBase("a b c", context, "normalize-space(' a \n b \n  c')");
            assertValueOfXPath_XPathTestBase("", context, "normalize-space(' ')");
            assertValueOfXPath_XPathTestBase("", context, "normalize-space('')");
        }
    }

    /** 
     * test cases for String extension functions
     */
    public void testStringExtensionFunctions_XPathTestBase() throws JaxenException, Exception {
        this.contextSupport = null;
        System.setProperty(XPathReaderFactory.DRIVER_PROPERTY, "");
        log_XPathTestBase("-----------------------------");
        Navigator nav = getNavigator_XPathTestBase();
        String url = "xml/web.xml";
        log_XPathTestBase("Document [" + url + "]");
        Object document = nav.getDocument(url);
        XPath contextpath = new BaseXPath("/web-app/servlet[1]", nav);
        log_XPathTestBase("Initial Context :: " + contextpath);
        List list = contextpath.selectNodes(document);
        Iterator iter = list.iterator();
        while (iter.hasNext()) {
            Object context = iter.next();
            assertValueOfXPath_XPathTestBase("SNOOPSERVLET", context, "upper-case( servlet-class )");
            assertValueOfXPath_XPathTestBase("snoopservlet", context, "lower-case( servlet-class )");
            assertValueOfXPath_XPathTestBase("SNOOPSERVLET", context, "upper-case( servlet-class, 'fr' )");
            assertValueOfXPath_XPathTestBase("SNOOPSERVLET", context, "upper-case( servlet-class, 'fr-CA' )");
            assertValueOfXPath_XPathTestBase("SNOOPSERVLET", context, "upper-case( servlet-class, 'es-ES-Traditional_WIN' )");
            assertValueOfXPath_XPathTestBase("true", context, "ends-with( servlet-class, 'Servlet' )");
            assertValueOfXPath_XPathTestBase("false", context, "ends-with( servlet-class, 'S' )");
        }
    }

    /** 
     * test cases for the lang() function
     */
    public void testLangFunction_XPathTestBase() throws JaxenException, Exception {
        this.contextSupport = null;
        System.setProperty(XPathReaderFactory.DRIVER_PROPERTY, "");
        log_XPathTestBase("-----------------------------");
        Navigator nav = getNavigator_XPathTestBase();
        String url = "xml/lang.xml";
        log_XPathTestBase("Document [" + url + "]");
        Object document = nav.getDocument(url);
        XPath contextpath = new BaseXPath("/", nav);
        log_XPathTestBase("Initial Context :: " + contextpath);
        List list = contextpath.selectNodes(document);
        Iterator iter = list.iterator();
        while (iter.hasNext()) {
            Object context = iter.next();
            assertCountXPath_XPathTestBase(0, context, "/e1/e2[lang('hr')]");
            assertCountXPath_XPathTestBase(1, context, "/e1/e2/e3[lang('en')]");
            assertCountXPath_XPathTestBase(1, context, "/e1/e2/e3[lang('en-US')]");
            assertCountXPath_XPathTestBase(0, context, "/e1/e2/e3[lang('en-GB')]");
            assertCountXPath_XPathTestBase(2, context, "/e1/e2/e3[lang('hu')]");
            assertCountXPath_XPathTestBase(0, context, "/e1/e2/e3[lang('hu-HU')]");
            assertCountXPath_XPathTestBase(1, context, "/e1/e2/e3[lang('es')]");
            assertCountXPath_XPathTestBase(0, context, "/e1/e2/e3[lang('es-BR')]");
        }
    }

    /** 
     * test namespace
     */
    public void testNamespacesAgain_XPathTestBase() throws JaxenException, Exception {
        this.contextSupport = null;
        System.setProperty(XPathReaderFactory.DRIVER_PROPERTY, "");
        log_XPathTestBase("-----------------------------");
        Navigator nav = getNavigator_XPathTestBase();
        String url = "xml/namespaces.xml";
        log_XPathTestBase("Document [" + url + "]");
        Object document = nav.getDocument(url);
        XPath contextpath = new BaseXPath("/", nav);
        log_XPathTestBase("Initial Context :: " + contextpath);
        List list = contextpath.selectNodes(document);
        SimpleNamespaceContext nsContext = new SimpleNamespaceContext();
        nsContext.addNamespace("alias", "http://fooNamespace/");
        nsContext.addNamespace("bar", "http://barNamespace/");
        nsContext.addNamespace("voo", "http://fooNamespace/");
        nsContext.addNamespace("foo", "http://fooNamespace/");
        getContextSupport_XPathTestBase().setNamespaceContext(nsContext);
        Iterator iter = list.iterator();
        while (iter.hasNext()) {
            Object context = iter.next();
            assertCountXPath_XPathTestBase(1, context, "/*");
            assertCountXPath_XPathTestBase(1, context, "/foo:a");
            assertCountXPath_XPathTestBase(1, context, "/foo:a/b");
            assertCountXPath_XPathTestBase(1, context, "/voo:a/b/c");
            assertCountXPath_XPathTestBase(1, context, "/voo:a/bar:f");
            assertCountXPath_XPathTestBase(1, context, "/*[namespace-uri()='http://fooNamespace/' and local-name()='a']");
            assertCountXPath_XPathTestBase(1, context, "/*[local-name()='a' and namespace-uri()='http://fooNamespace/']/*[local-name()='x' and namespace-uri()='http://fooNamespace/']");
            assertCountXPath_XPathTestBase(1, context, "/*[local-name()='a' and namespace-uri()='http://fooNamespace/']/*[local-name()='x' and namespace-uri()='http://fooNamespace/']/*[local-name()='y' and namespace-uri()='http://fooNamespace/']");
        }
    }

    /** 
     * the prefix here and in the document have no relation; it's their
     * namespace-uri binding that counts 
     */
    public void testPrefixDoesntMatter_XPathTestBase() throws JaxenException, Exception {
        this.contextSupport = null;
        System.setProperty(XPathReaderFactory.DRIVER_PROPERTY, "");
        log_XPathTestBase("-----------------------------");
        Navigator nav = getNavigator_XPathTestBase();
        String url = "xml/namespaces.xml";
        log_XPathTestBase("Document [" + url + "]");
        Object document = nav.getDocument(url);
        XPath contextpath = new BaseXPath("/", nav);
        log_XPathTestBase("Initial Context :: " + contextpath);
        List list = contextpath.selectNodes(document);
        SimpleNamespaceContext nsContext = new SimpleNamespaceContext();
        nsContext.addNamespace("foo", "http://somethingElse/");
        getContextSupport_XPathTestBase().setNamespaceContext(nsContext);
        Iterator iter = list.iterator();
        while (iter.hasNext()) {
            Object context = iter.next();
            assertCountXPath_XPathTestBase(0, context, "/foo:a/b/c");
        }
    }

    /** Jaxen-67, affects Jelly and Maven */
    public void testCDATASectionsAreIncludedInTextNodes_XPathTestBase() throws JaxenException, Exception {
        this.contextSupport = null;
        System.setProperty(XPathReaderFactory.DRIVER_PROPERTY, "");
        log_XPathTestBase("-----------------------------");
        Navigator nav = getNavigator_XPathTestBase();
        String url = "xml/cdata.xml";
        log_XPathTestBase("Document [" + url + "]");
        Object document = nav.getDocument(url);
        XPath contextPath = new BaseXPath("/p/text()", nav);
        log_XPathTestBase("Initial Context :: " + contextPath);
        List list = contextPath.selectNodes(document);
        StringBuffer buffer = new StringBuffer(10);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            buffer.append(StringFunction.evaluate(iterator.next(), nav));
        }
        assertEquals("awhateverb", buffer.toString());
    }

    public void testNamespaces_XPathTestBase() throws JaxenException, Exception {
        this.contextSupport = null;
        System.setProperty(XPathReaderFactory.DRIVER_PROPERTY, "");
        log_XPathTestBase("-----------------------------");
        Navigator nav = getNavigator_XPathTestBase();
        String url = "xml/namespaces.xml";
        log_XPathTestBase("Document [" + url + "]");
        Object document = nav.getDocument(url);
        XPath contextpath = new BaseXPath("/", nav);
        log_XPathTestBase("Initial Context :: " + contextpath);
        List list = contextpath.selectNodes(document);
        SimpleNamespaceContext nsContext = new SimpleNamespaceContext();
        nsContext.addNamespace("alias", "http://fooNamespace/");
        nsContext.addNamespace("bar", "http://barNamespace/");
        nsContext.addNamespace("foo", "http://fooNamespace/");
        getContextSupport_XPathTestBase().setNamespaceContext(nsContext);
        Iterator iter = list.iterator();
        while (iter.hasNext()) {
            Object context = iter.next();
            assertValueOfXPath_XPathTestBase("Hello", context, "/foo:a/b/c");
            assertValueOfXPath_XPathTestBase("Hey", context, "/foo:a/foo:d/foo:e");
            assertValueOfXPath_XPathTestBase("Hey3", context, "/foo:a/alias:x/alias:y");
            assertValueOfXPath_XPathTestBase("Hey3", context, "/foo:a/foo:x/foo:y");
            assertValueOfXPath_XPathTestBase("Hey3", context, "/*[local-name()='a' and namespace-uri()='http://fooNamespace/']/*[local-name()='x' and namespace-uri()='http://fooNamespace/']/*[local-name()='y' and namespace-uri()='http://fooNamespace/']");
        }
    }

    public void testNoNamespace_XPathTestBase() throws JaxenException, Exception {
        this.contextSupport = null;
        System.setProperty(XPathReaderFactory.DRIVER_PROPERTY, "");
        log_XPathTestBase("-----------------------------");
        Navigator nav = getNavigator_XPathTestBase();
        String url = "xml/defaultNamespace.xml";
        log_XPathTestBase("Document [" + url + "]");
        Object document = nav.getDocument(url);
        XPath contextpath = new BaseXPath("/", nav);
        log_XPathTestBase("Initial Context :: " + contextpath);
        List list = contextpath.selectNodes(document);
        Iterator iter = list.iterator();
        while (iter.hasNext()) {
            Object context = iter.next();
            assertCountXPath_XPathTestBase(0, context, "/a/b/c");
        }
    }

    public void testNamespaceResolution_XPathTestBase() throws JaxenException, Exception {
        this.contextSupport = null;
        System.setProperty(XPathReaderFactory.DRIVER_PROPERTY, "");
        log_XPathTestBase("-----------------------------");
        Navigator nav = getNavigator_XPathTestBase();
        String url = "xml/defaultNamespace.xml";
        log_XPathTestBase("Document [" + url + "]");
        Object document = nav.getDocument(url);
        XPath contextpath = new BaseXPath("/", nav);
        log_XPathTestBase("Initial Context :: " + contextpath);
        List list = contextpath.selectNodes(document);
        SimpleNamespaceContext nsContext = new SimpleNamespaceContext();
        nsContext.addNamespace("dummy", "http://dummyNamespace/");
        getContextSupport_XPathTestBase().setNamespaceContext(nsContext);
        Iterator iter = list.iterator();
        while (iter.hasNext()) {
            Object context = iter.next();
            assertCountXPath_XPathTestBase(1, context, "/dummy:a/dummy:b/dummy:c");
        }
    }

    public void testTextNodes_XPathTestBase() throws JaxenException, Exception {
        this.contextSupport = null;
        System.setProperty(XPathReaderFactory.DRIVER_PROPERTY, "");
        log_XPathTestBase("-----------------------------");
        Navigator nav = getNavigator_XPathTestBase();
        String url = "xml/text.xml";
        log_XPathTestBase("Document [" + url + "]");
        Object document = nav.getDocument(url);
        XPath contextpath = new BaseXPath("/", nav);
        log_XPathTestBase("Initial Context :: " + contextpath);
        List list = contextpath.selectNodes(document);
        Iterator iter = list.iterator();
        while (iter.hasNext()) {
            Object context = iter.next();
            assertCountXPath_XPathTestBase(3, context, "/foo/bar/text()");
            assertValueOfXPath_XPathTestBase("baz", context, "normalize-space(/foo/bar/text())");
        }
    }

    public void testNamespaceNodeCounts1_XPathTestBase() throws JaxenException, Exception {
        this.contextSupport = null;
        System.setProperty(XPathReaderFactory.DRIVER_PROPERTY, "");
        log_XPathTestBase("-----------------------------");
        Navigator nav = getNavigator_XPathTestBase();
        String url = "xml/testNamespaces.xml";
        log_XPathTestBase("Document [" + url + "]");
        Object document = nav.getDocument(url);
        XPath contextpath = new BaseXPath("/", nav);
        log_XPathTestBase("Initial Context :: " + contextpath);
        List list = contextpath.selectNodes(document);
        Iterator iter = list.iterator();
        while (iter.hasNext()) {
            Object context = iter.next();
            assertCountXPath_XPathTestBase(0, context, "namespace::*");
            assertCountXPath_XPathTestBase(0, context, "/namespace::*");
            assertCountXPath_XPathTestBase(3, context, "/Template/Application1/namespace::*");
            assertCountXPath_XPathTestBase(3, context, "/Template/Application2/namespace::*");
            assertCountXPath_XPathTestBase(25, context, "//namespace::*");
        }
    }

    public void testNamespaceNodeCounts_XPathTestBase() throws JaxenException, Exception {
        this.contextSupport = null;
        System.setProperty(XPathReaderFactory.DRIVER_PROPERTY, "");
        log_XPathTestBase("-----------------------------");
        Navigator nav = getNavigator_XPathTestBase();
        String url = "xml/testNamespaces.xml";
        log_XPathTestBase("Document [" + url + "]");
        Object document = nav.getDocument(url);
        XPath contextpath = new BaseXPath("/Template/Application1", nav);
        log_XPathTestBase("Initial Context :: " + contextpath);
        List list = contextpath.selectNodes(document);
        Iterator iter = list.iterator();
        while (iter.hasNext()) {
            Object context = iter.next();
            assertCountXPath_XPathTestBase(3, context, "namespace::*");
            assertCountXPath_XPathTestBase(0, context, "/namespace::*");
            assertCountXPath_XPathTestBase(3, context, "/Template/Application1/namespace::*");
            assertCountXPath_XPathTestBase(3, context, "/Template/Application2/namespace::*");
            assertCountXPath_XPathTestBase(25, context, "//namespace::*");
            assertCountXPath_XPathTestBase(8, context, "//namespace::xplt");
            assertCountXPath_XPathTestBase(0, context, "//namespace::somethingelse");
        }
    }

    public void testNamespaceNodesHaveParent_XPathTestBase() throws JaxenException, Exception {
        this.contextSupport = null;
        System.setProperty(XPathReaderFactory.DRIVER_PROPERTY, "");
        log_XPathTestBase("-----------------------------");
        Navigator nav = getNavigator_XPathTestBase();
        String url = "xml/testNamespaces.xml";
        log_XPathTestBase("Document [" + url + "]");
        Object document = nav.getDocument(url);
        XPath contextpath = new BaseXPath("/", nav);
        log_XPathTestBase("Initial Context :: " + contextpath);
        List list = contextpath.selectNodes(document);
        Iterator iter = list.iterator();
        while (iter.hasNext()) {
            Object context = iter.next();
            assertCountXPath_XPathTestBase(1, context, "/Template/namespace::xml/parent::Template");
        }
    }

    /** 
     * namespace nodes can also be used as context nodes
     */
    public void testNamespaceNodeAsContext_XPathTestBase() throws JaxenException, Exception {
        this.contextSupport = null;
        System.setProperty(XPathReaderFactory.DRIVER_PROPERTY, "");
        log_XPathTestBase("-----------------------------");
        Navigator nav = getNavigator_XPathTestBase();
        String url = "xml/testNamespaces.xml";
        log_XPathTestBase("Document [" + url + "]");
        Object document = nav.getDocument(url);
        XPath contextpath = new BaseXPath("/Template/namespace::xml", nav);
        log_XPathTestBase("Initial Context :: " + contextpath);
        List list = contextpath.selectNodes(document);
        Iterator iter = list.iterator();
        while (iter.hasNext()) {
            Object context = iter.next();
            assertCountXPath_XPathTestBase(1, context, "parent::Template");
        }
    }}
