package test;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import junit.framework.TestCase;
import org.jaxen.FunctionCallException;
import org.jaxen.JaxenException;
import org.jaxen.XPath;
import org.jaxen.dom.DOMXPath;
import org.w3c.dom.Document;

public class SubstringTest extends TestCase {

    public SubstringTest(String name) {
        super(name);
    }

    private Document doc;

    public void setUp() throws ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc = builder.newDocument();
        doc.appendChild(doc.createElement("root"));
    }

    public void testSubstringFunctionRequiresAtMostThreeArguments() throws JaxenException {
        XPath xpath = new DOMXPath("substring('a', 1, 1, 4)");
        try {
            xpath.selectNodes(doc);
            fail("Allowed substring function with four arguments");
        } catch (FunctionCallException ex) {
            assertNotNull(ex.getMessage());
        }
    }

    public void testSubstringFunctionRequiresAtLeastTwoArguments() throws JaxenException {
        XPath xpath = new DOMXPath("substring('a')");
        try {
            xpath.selectNodes(doc);
            fail("Allowed substring function with one argument");
        } catch (FunctionCallException ex) {
            assertNotNull(ex.getMessage());
        }
    }

    public void testStringLengthCountsUnicodeCharactersNotJavaChars() throws JaxenException {
        XPath xpath = new DOMXPath("substring('A?', 1, 2)");
        String result = (String) xpath.evaluate(doc);
        assertEquals("A?", result);
    }

    public void testStringLengthIndexesAndCountsUnicodeCharactersNotJavaChars() throws JaxenException {
        XPath xpath = new DOMXPath("substring('A?123', 3, 2)");
        String result = (String) xpath.evaluate(doc);
        assertEquals("12", result);
    }

    public void testNegativeStartNoLength() throws JaxenException {
        XPath xpath = new DOMXPath("substring('Hello', -50)");
        String result = (String) xpath.evaluate(doc);
        assertEquals("Hello", result);
    }

    public void testSubstringOfNumber2() throws JaxenException {
        XPath xpath = new DOMXPath("substring(1234, 2, 3)");
        String result = (String) xpath.evaluate(doc);
        assertEquals("234", result);
    }

    public void testUnusualSubstring5() throws JaxenException {
        XPath xpath = new DOMXPath("substring('12345', -42, 1 div 0)");
        String result = (String) xpath.evaluate(doc);
        assertEquals("12345", result);
    }

    public void testUnusualSubstring3() throws JaxenException {
        XPath xpath = new DOMXPath("substring('12345', 0 div 0, 3)");
        String result = (String) xpath.evaluate(doc);
        assertEquals("", result);
    }

    public void testUnusualSubstring2() throws JaxenException {
        XPath xpath = new DOMXPath("substring('12345', 0, 3)");
        String result = (String) xpath.evaluate(doc);
        assertEquals("12", result);
    }

    public void testSubstringOfNaN() throws JaxenException {
        XPath xpath = new DOMXPath("substring(0 div 0, 2)");
        String result = (String) xpath.evaluate(doc);
        assertEquals("aN", result);
    }

    public void testSubstringOfNumber() throws JaxenException {
        XPath xpath = new DOMXPath("substring(1234, 3)");
        String result = (String) xpath.evaluate(doc);
        assertEquals("34", result);
    }

    public void testUnusualSubstring4() throws JaxenException {
        XPath xpath = new DOMXPath("substring('12345', 1, 0 div 0)");
        String result = (String) xpath.evaluate(doc);
        assertEquals("", result);
    }

    public void testUnusualSubstring6() throws JaxenException {
        XPath xpath = new DOMXPath("substring('12345', -1 div 0, 1 div 0)");
        String result = (String) xpath.evaluate(doc);
        assertEquals("", result);
    }

    public void testSubstringWithNegativeLength2() throws JaxenException {
        XPath xpath = new DOMXPath("substring('12345', 2, -1)");
        String result = (String) xpath.evaluate(doc);
        assertEquals("", result);
    }

    public void testUnusualSubstring1() throws JaxenException {
        XPath xpath = new DOMXPath("substring('12345', 1.5, 2.6)");
        String result = (String) xpath.evaluate(doc);
        assertEquals("234", result);
    }

    public void testNegativeStartWithLength() throws JaxenException {
        XPath xpath = new DOMXPath("substring('Hello', -50, 20)");
        String result = (String) xpath.evaluate(doc);
        assertEquals("", result);
    }

    public void testStringLengthIndexesUnicodeCharactersNotJavaChars() throws JaxenException {
        XPath xpath = new DOMXPath("substring('A?', 3, 1)");
        String result = (String) xpath.evaluate(doc);
        assertEquals("", result);
    }

    public void testSubstringWithNegativeLength() throws JaxenException {
        XPath xpath = new DOMXPath("substring('12345', 2, -3)");
        String result = (String) xpath.evaluate(doc);
        assertEquals("", result);
    }

    public void testSubstringOfEmptyString() throws JaxenException {
        XPath xpath = new DOMXPath("substring('', 2)");
        String result = (String) xpath.evaluate(doc);
        assertEquals("", result);
    }

    public void testSubstringWithExcessiveLength() throws JaxenException {
        XPath xpath = new DOMXPath("substring('12345', 2, 32)");
        String result = (String) xpath.evaluate(doc);
        assertEquals("2345", result);
    }
}
