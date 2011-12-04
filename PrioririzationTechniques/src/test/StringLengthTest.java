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

public class StringLengthTest extends TestCase {

    public StringLengthTest(String name) {
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

    public void testStringLengthFunctionWithMalformedString() throws JaxenException {
        BaseXPath xpath = new DOMXPath("string-length('\uD834A\uDD00')");
        try {
            xpath.evaluate(doc);
            fail("Allowed Malformed string");
        } catch (FunctionCallException ex) {
            assertNotNull(ex.getMessage());
        }
    }

    public void testStringLengthFunctionOperatesOnContextNode() throws JaxenException {
        BaseXPath xpath = new DOMXPath("string-length()");
        Double result = (Double) xpath.evaluate(doc);
        assertEquals(0, result.intValue());
    }

    public void testStringLengthOfString() throws JaxenException {
        XPath xpath = new DOMXPath("string-length('0123456789')");
        Double result = (Double) xpath.evaluate(doc);
        assertEquals(10, result.intValue());
    }

    public void testStringLengthWithPrivateUseChars() throws JaxenException {
        XPath xpath = new DOMXPath("string-length('ab??')");
        Double result = (Double) xpath.evaluate(doc);
        assertEquals(4, result.intValue());
    }

    public void testStringLengthOfNumber() throws JaxenException {
        XPath xpath = new DOMXPath("string-length(3)");
        Double result = (Double) xpath.evaluate(doc);
        assertEquals(1, result.intValue());
    }

    public void testStringLengthOfEmptyString() throws JaxenException {
        XPath xpath = new DOMXPath("string-length('')");
        Double result = (Double) xpath.evaluate(doc);
        assertEquals(0, result.intValue());
    }

    public void testStringLengthFunctionCountsUnicodeCharactersNotJavaChars() throws JaxenException {
        BaseXPath xpath = new DOMXPath("string-length('?')");
        Double result = (Double) xpath.evaluate(doc);
        assertEquals(1, result.intValue());
    }

    public void testStringLengthFunctionRequiresExactlyOneArgument() throws JaxenException {
        BaseXPath xpath = new DOMXPath("string-length('', '')");
        try {
            xpath.selectNodes(doc);
            fail("Allowed string-length function with two arguments");
        } catch (FunctionCallException ex) {
            assertNotNull(ex.getMessage());
        }
    }
}
