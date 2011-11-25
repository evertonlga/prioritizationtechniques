package test;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import junit.framework.TestCase;
import org.jaxen.BaseXPath;
import org.jaxen.FunctionCallException;
import org.jaxen.JaxenException;
import org.jaxen.XPath;
import org.jaxen.dom.DOMXPath;
import org.w3c.dom.Document;

public class SubstringBeforeTest extends TestCase {

    public SubstringBeforeTest(String name) {
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

    public void testSubstringBeforeNumber() throws JaxenException {
        XPath xpath = new DOMXPath("substring-before(33, '3')");
        String result = (String) xpath.evaluate(doc);
        assertEquals("", result);
    }

    public void testSubstringBeforeNumber2() throws JaxenException {
        XPath xpath = new DOMXPath("substring-before(43, '0')");
        String result = (String) xpath.evaluate(doc);
        assertEquals("", result);
    }

    public void testSubstringBeforeFunctionRequiresAtLeastTwoArguments() throws JaxenException {
        BaseXPath xpath = new DOMXPath("substring-before('a')");
        try {
            xpath.selectNodes(doc);
            fail("Allowed substring-before function with one argument");
        } catch (FunctionCallException ex) {
            assertNotNull(ex.getMessage());
        }
    }

    public void testSubstringBeforeEmptyString() throws JaxenException {
        XPath xpath = new DOMXPath("substring-before('a', '')");
        String result = (String) xpath.evaluate(doc);
        assertEquals("", result);
    }

    public void testSubstringBeforeString() throws JaxenException {
        XPath xpath = new DOMXPath("substring-before('test', 'es')");
        String result = (String) xpath.evaluate(doc);
        assertEquals("t", result);
    }

    public void testSubstringBeforeString2() throws JaxenException {
        XPath xpath = new DOMXPath("substring-before('1234567890', '1234567a')");
        String result = (String) xpath.evaluate(doc);
        assertEquals("", result);
    }

    public void testEmptyStringBeforeEmptyString() throws JaxenException {
        XPath xpath = new DOMXPath("substring-before('', '')");
        String result = (String) xpath.evaluate(doc);
        assertEquals("", result);
    }

    public void testEmptyStringSubstringBeforeNonEmptyString() throws JaxenException {
        XPath xpath = new DOMXPath("substring-before('', 'a')");
        String result = (String) xpath.evaluate(doc);
        assertEquals("", result);
    }

    public void testContainsString3() throws JaxenException {
        XPath xpath = new DOMXPath("substring-before('superlative', 'superlative')");
        String result = (String) xpath.evaluate(doc);
        assertEquals("", result);
    }

    public void testSubstringBeforeString3() throws JaxenException {
        XPath xpath = new DOMXPath("substring-before('1234567890', '456')");
        String result = (String) xpath.evaluate(doc);
        assertEquals("123", result);
    }

    public void testSubstringBeforeFunctionRequiresAtMostTwoArguments() throws JaxenException {
        BaseXPath xpath = new DOMXPath("substring-before('a', 'a', 'a')");
        try {
            xpath.selectNodes(doc);
            fail("Allowed substring-before function with three arguments");
        } catch (FunctionCallException ex) {
            assertNotNull(ex.getMessage());
        }
    }
}
