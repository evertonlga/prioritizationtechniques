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

public class ContainsTest extends TestCase {

    public ContainsTest(String name) {
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

    public void testEmptyStringContainsNonEmptyString() throws JaxenException {
        XPath xpath = new DOMXPath("contains('', 'a')");
        Boolean result = (Boolean) xpath.evaluate(doc);
        assertEquals(Boolean.FALSE, result);
    }

    public void testContainsString() throws JaxenException {
        XPath xpath = new DOMXPath("contains('test', 'es')");
        Boolean result = (Boolean) xpath.evaluate(doc);
        assertEquals(Boolean.TRUE, result);
    }

    public void testEmptyStringContainsEmptyString() throws JaxenException {
        XPath xpath = new DOMXPath("contains('', '')");
        Boolean result = (Boolean) xpath.evaluate(doc);
        assertEquals(Boolean.TRUE, result);
    }

    public void testContainsString2() throws JaxenException {
        XPath xpath = new DOMXPath("contains('1234567890', '1234567a')");
        Boolean result = (Boolean) xpath.evaluate(doc);
        assertEquals(Boolean.FALSE, result);
    }

    public void testContainsFunctionRequiresAtLeastTwoArguments() throws JaxenException {
        BaseXPath xpath = new DOMXPath("contains('a')");
        try {
            xpath.selectNodes(doc);
            fail("Allowed contains function with one argument");
        } catch (FunctionCallException ex) {
            assertNotNull(ex.getMessage());
        }
    }

    public void testContainsFunctionRequiresAtMostTwoArguments() throws JaxenException {
        BaseXPath xpath = new DOMXPath("contains('a', 'a', 'a')");
        try {
            xpath.selectNodes(doc);
            fail("Allowed contains function with three arguments");
        } catch (FunctionCallException ex) {
            assertNotNull(ex.getMessage());
        }
    }

    public void testContainsString3() throws JaxenException {
        XPath xpath = new DOMXPath("contains('superlative', 'superlative')");
        Boolean result = (Boolean) xpath.evaluate(doc);
        assertEquals(Boolean.TRUE, result);
    }

    public void testContainsNumber() throws JaxenException {
        XPath xpath = new DOMXPath("contains(33, '3')");
        Boolean result = (Boolean) xpath.evaluate(doc);
        assertEquals(Boolean.TRUE, result);
    }

    public void testContainsEmptyString() throws JaxenException {
        XPath xpath = new DOMXPath("contains('a', '')");
        Boolean result = (Boolean) xpath.evaluate(doc);
        assertEquals(Boolean.TRUE, result);
    }

    public void testContainsNumber2() throws JaxenException {
        XPath xpath = new DOMXPath("contains(43, '0')");
        Boolean result = (Boolean) xpath.evaluate(doc);
        assertEquals(Boolean.FALSE, result);
    }
}
