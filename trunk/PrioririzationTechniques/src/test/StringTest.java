package test;

import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import junit.framework.TestCase;
import org.jaxen.FunctionCallException;
import org.jaxen.JaxenException;
import org.jaxen.XPath;
import org.jaxen.dom.DOMXPath;
import org.jaxen.dom.DocumentNavigator;
import org.jaxen.function.StringFunction;
import org.w3c.dom.Document;

public class StringTest extends TestCase {

    public StringTest(String name) {
        super(name);
    }

    private Document doc;

    public void setUp() throws ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc = builder.newDocument();
    }

    public void testSmallNumbersDontUseExponentialNotation() throws JaxenException {
        XPath xpath = new DOMXPath("string(0.0000003)");
        String result = (String) xpath.evaluate(null);
        assertEquals("0.0000003", result);
    }

    public void testStringOfNegativeZero() throws JaxenException {
        XPath xpath = new DOMXPath("string(-0)");
        String result = (String) xpath.evaluate(null);
        assertEquals("0", result);
    }

    public void testStringValueOfNullWithNonNullNavigator() {
        assertEquals("", StringFunction.evaluate(null, new DocumentNavigator()));
    }

    public void testStringValueOfNull() {
        assertEquals("", StringFunction.evaluate(null, null));
    }

    public void testStringFunctionOperatesOnFirstNodeInDocumentOrder() throws JaxenException {
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

    public void testStringValueOfComment() throws JaxenException {
        XPath xpath = new DOMXPath("string(/a/comment())");
        org.w3c.dom.Element a = doc.createElementNS("", "a");
        doc.appendChild(a);
        a.appendChild(doc.createComment("data"));
        String result = (String) xpath.evaluate(doc);
        assertEquals("data", result);
    }

    public void testIntegersAreFormattedAsInts() throws JaxenException {
        XPath xpath = new DOMXPath("string(12)");
        String result = (String) xpath.evaluate(null);
        assertEquals("12", result);
    }

    public void testStringOfNegativeInfinity() throws JaxenException {
        XPath xpath = new DOMXPath("string(-1 div 0)");
        String result = (String) xpath.evaluate(null);
        assertEquals("-Infinity", result);
    }

    public void testStringOfInfinity() throws JaxenException {
        XPath xpath = new DOMXPath("string(1 div 0)");
        String result = (String) xpath.evaluate(null);
        assertEquals("Infinity", result);
    }

    public void testBigNumbersDontUseExponentialNotation() throws JaxenException {
        XPath xpath = new DOMXPath("string(100000000.5)");
        String result = (String) xpath.evaluate(null);
        assertEquals("100000000.5", result);
    }

    public void testStringFunctionRequiresAtMostOneArgument() throws JaxenException {
        XPath xpath = new DOMXPath("string('a', 1)");
        try {
            xpath.selectNodes(doc);
            fail("Allowed string function with two arguments");
        } catch (FunctionCallException ex) {
            assertNotNull(ex.getMessage());
        }
    }

    public void testStringValueOfNamespaceNode() throws JaxenException {
        XPath xpath = new DOMXPath("string(/a/namespace::node())");
        org.w3c.dom.Element a = doc.createElementNS("", "a");
        doc.appendChild(a);
        String result = (String) xpath.evaluate(doc);
        assertEquals("http://www.w3.org/XML/1998/namespace", result);
    }
}
