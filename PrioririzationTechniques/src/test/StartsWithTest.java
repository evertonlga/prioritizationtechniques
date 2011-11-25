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

public class StartsWithTest extends TestCase {

    public StartsWithTest(String name) {
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

    public void testStartsWithString2() throws JaxenException {
        XPath xpath = new DOMXPath("starts-with('1234567890', '1234567a')");
        Boolean result = (Boolean) xpath.evaluate(doc);
        assertEquals(Boolean.FALSE, result);
    }

    public void testStartsWithFunctionRequiresAtMostTwoArguments() throws JaxenException {
        BaseXPath xpath = new DOMXPath("starts-with('a', 'a', 'a')");
        try {
            xpath.selectNodes(doc);
            fail("Allowed starts-with function with three arguments");
        } catch (FunctionCallException ex) {
            assertNotNull(ex.getMessage());
        }
    }

    public void testEmptyStringStartsWithNonEmptyString() throws JaxenException {
        XPath xpath = new DOMXPath("starts-with('', 'a')");
        Boolean result = (Boolean) xpath.evaluate(doc);
        assertEquals(Boolean.FALSE, result);
    }

    public void testStartsWithString() throws JaxenException {
        XPath xpath = new DOMXPath("starts-with('test', 't')");
        Boolean result = (Boolean) xpath.evaluate(doc);
        assertEquals(Boolean.TRUE, result);
    }

    public void testEmptyStringStartsWithEmptyString() throws JaxenException {
        XPath xpath = new DOMXPath("starts-with('', '')");
        Boolean result = (Boolean) xpath.evaluate(doc);
        assertEquals(Boolean.TRUE, result);
    }

    public void testStartsWithEmptyString() throws JaxenException {
        XPath xpath = new DOMXPath("starts-with('a', '')");
        Boolean result = (Boolean) xpath.evaluate(doc);
        assertEquals(Boolean.TRUE, result);
    }

    public void testStartsWithNumber2() throws JaxenException {
        XPath xpath = new DOMXPath("starts-with(43, '3')");
        Boolean result = (Boolean) xpath.evaluate(doc);
        assertEquals(Boolean.FALSE, result);
    }

    public void testStartsWithString3() throws JaxenException {
        XPath xpath = new DOMXPath("starts-with('superlative', 'superlative')");
        Boolean result = (Boolean) xpath.evaluate(doc);
        assertEquals(Boolean.TRUE, result);
    }

    public void testStartsWithFunctionRequiresAtLeastTwoArguments() throws JaxenException {
        BaseXPath xpath = new DOMXPath("starts-with('a')");
        try {
            xpath.selectNodes(doc);
            fail("Allowed starts-with function with one argument");
        } catch (FunctionCallException ex) {
            assertNotNull(ex.getMessage());
        }
    }

    public void testStartsWithNumber() throws JaxenException {
        XPath xpath = new DOMXPath("starts-with(33, '3')");
        Boolean result = (Boolean) xpath.evaluate(doc);
        assertEquals(Boolean.TRUE, result);
    }
}
