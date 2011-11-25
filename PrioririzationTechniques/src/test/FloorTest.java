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

public class FloorTest extends TestCase {

    public FloorTest(String name) {
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

    public void testNegativeInfFloorIsNegativeInf() throws JaxenException {
        BaseXPath xpath = new DOMXPath("floor(-1.0 div 0.0)");
        double result = ((Double) xpath.evaluate(doc)).doubleValue();
        assertTrue(Double.isInfinite(result));
        assertTrue(result < 0);
    }

    public void testInfFloorIsInf() throws JaxenException {
        BaseXPath xpath = new DOMXPath("floor(1.0 div 0.0)");
        double result = ((Double) xpath.evaluate(doc)).doubleValue();
        assertTrue(Double.isInfinite(result));
        assertTrue(result > 0);
    }

    public void testNegativeFloor() throws JaxenException {
        BaseXPath xpath = new DOMXPath("floor(-1.5)");
        Object result = xpath.evaluate(doc);
        assertEquals(-2, ((Double) result).doubleValue(), 0.0001);
    }

    public void testBooleanFunctionRequiresExactlyOneArgument() throws JaxenException {
        BaseXPath xpath = new DOMXPath("floor(2.2, 1.2)");
        try {
            xpath.selectNodes(doc);
            fail("Allowed floor function with two arguments");
        } catch (FunctionCallException ex) {
            assertNotNull(ex.getMessage());
        }
    }

    public void testNaNFloorIsNaN() throws JaxenException {
        BaseXPath xpath = new DOMXPath("floor(1.0 div 0.0 - 2.0 div 0.0)");
        double result = ((Double) xpath.evaluate(doc)).doubleValue();
        assertTrue(Double.isNaN(result));
    }

    public void testFloorFunctionRequiresAtLeastArgument() throws JaxenException {
        BaseXPath xpath = new DOMXPath("floor()");
        try {
            xpath.selectNodes(doc);
            fail("Allowed floor function with no arguments");
        } catch (FunctionCallException ex) {
            assertNotNull(ex.getMessage());
        }
    }

    public void testFloor() throws JaxenException {
        BaseXPath xpath = new DOMXPath("floor(1.5)");
        Object result = xpath.evaluate(doc);
        assertEquals(1, ((Double) result).doubleValue(), 0.0001);
    }
}
