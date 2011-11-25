package test;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import junit.framework.TestCase;
import org.jaxen.BaseXPath;
import org.jaxen.FunctionCallException;
import org.jaxen.JaxenException;
import org.jaxen.dom.DOMXPath;
import org.w3c.dom.Document;

public class CeilingTest extends TestCase {

    public CeilingTest(String name) {
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

    public void testNegativeCeiling() throws JaxenException {
        BaseXPath xpath = new DOMXPath("ceiling(-1.5)");
        Object result = xpath.evaluate(doc);
        assertEquals(-1, ((Double) result).doubleValue(), 0.0001);
    }

    public void testCeilingFunctionRequiresAtLeastOneArgument() throws JaxenException {
        BaseXPath xpath = new DOMXPath("ceiling()");
        try {
            xpath.selectNodes(doc);
            fail("Allowed ceiling function with no arguments");
        } catch (FunctionCallException ex) {
            assertNotNull(ex.getMessage());
        }
    }

    public void testCeiling() throws JaxenException {
        BaseXPath xpath = new DOMXPath("ceiling(1.5)");
        Object result = xpath.evaluate(doc);
        assertEquals(2, ((Double) result).doubleValue(), 0.0001);
    }

    public void testNaNCeilingIsNaN() throws JaxenException {
        BaseXPath xpath = new DOMXPath("ceiling(1.0 div 0.0 - 2.0 div 0.0)");
        double result = ((Double) xpath.evaluate(doc)).doubleValue();
        assertTrue(Double.isNaN(result));
    }

    public void testCeilingFunctionRequiresAtMostOneArgument() throws JaxenException {
        BaseXPath xpath = new DOMXPath("ceiling(2.2, 1.2)");
        try {
            xpath.selectNodes(doc);
            fail("Allowed ceiling function with two arguments");
        } catch (FunctionCallException ex) {
            assertNotNull(ex.getMessage());
        }
    }
}
