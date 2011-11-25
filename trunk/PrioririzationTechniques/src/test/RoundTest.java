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

public class RoundTest extends TestCase {

    public RoundTest(String name) {
        super(name);
    }

    private Document doc;

    public void setUp() throws ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc = builder.newDocument();
        org.w3c.dom.Element a = doc.createElementNS("", "a");
        doc.appendChild(a);
    }

    public void testNaNRoundIsNaN() throws JaxenException {
        XPath xpath = new DOMXPath("round(1.0 div 0.0 - 2.0 div 0.0)");
        double result = ((Double) xpath.evaluate(doc)).doubleValue();
        assertTrue(Double.isNaN(result));
    }

    public void testRoundFunctionRequiresAtMostOneArgument() throws JaxenException {
        XPath xpath = new DOMXPath("round(2.2, 1.2)");
        try {
            xpath.selectNodes(doc);
            fail("Allowed round function with two arguments");
        } catch (FunctionCallException ex) {
            assertNotNull(ex.getMessage());
        }
    }

    public void testRoundFunctionRequiresAtLeastOneArgument() throws JaxenException {
        XPath xpath = new DOMXPath("round()");
        try {
            xpath.selectNodes(doc);
            fail("Allowed round function with no arguments");
        } catch (FunctionCallException ex) {
            assertNotNull(ex.getMessage());
        }
    }

    public void testRound() throws JaxenException {
        XPath xpath = new DOMXPath("round(1.5)");
        Object result = xpath.evaluate(doc);
        assertEquals(2, ((Double) result).doubleValue(), 0.0001);
    }

    public void testNegativeRound() throws JaxenException {
        XPath xpath = new DOMXPath("round(-1.5)");
        Object result = xpath.evaluate(doc);
        assertEquals(-1, ((Double) result).doubleValue(), 0.0001);
    }
}
