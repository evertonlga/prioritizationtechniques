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
import org.jaxen.function.NumberFunction;
import org.w3c.dom.Document;

public class NumberTest extends TestCase {

    public NumberTest(String name) {
        super(name);
    }

    private Document doc;

    public void setUp() throws ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc = builder.newDocument();
    }

    public void testNumberFunctionOperatesOnContextNode() throws JaxenException {
        XPath xpath = new DOMXPath("number()");
        org.w3c.dom.Element a = doc.createElementNS("", "a");
        doc.appendChild(a);
        a.appendChild(doc.createTextNode("2"));
        Double result = (Double) xpath.evaluate(doc);
        assertEquals(2, result.intValue());
    }

    public void testNumberFunctionOperatesOnFirstNodeInDocumentOrder() throws JaxenException {
        XPath xpath = new DOMXPath("number(//x)");
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
        assertEquals(Double.valueOf("2.0"), result.get(0));
    }

    public void testIsNan() {
        assertTrue(NumberFunction.isNaN(0.0 / 0.0));
    }

    public void testNumberFunctionRequiresAtMostOneArgument() throws JaxenException {
        XPath xpath = new DOMXPath("number('2.2', '1.2')");
        try {
            xpath.selectNodes(doc);
            fail("Allowed number function with two arguments");
        } catch (FunctionCallException ex) {
            assertNotNull(ex.getMessage());
        }
    }

    public void testNumberFunctionAppliedToNonNumericString() throws JaxenException {
        XPath xpath = new DOMXPath("number('Marx')");
        Double result = (Double) xpath.evaluate(doc);
        assertEquals(new Double(Double.NaN), result);
    }
}
