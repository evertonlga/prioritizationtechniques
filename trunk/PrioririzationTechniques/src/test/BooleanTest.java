package test;

import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import junit.framework.TestCase;
import org.jaxen.BaseXPath;
import org.jaxen.FunctionCallException;
import org.jaxen.JaxenException;
import org.jaxen.dom.DOMXPath;
import org.w3c.dom.Document;

public class BooleanTest extends TestCase {

    public BooleanTest(String name) {
        super(name);
    }

    private Document doc;

    public void setUp() throws ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc = builder.newDocument();
    }

    public void testEmptyStringIsFalse() throws JaxenException {
        BaseXPath xpath = new DOMXPath("boolean('')");
        org.w3c.dom.Element a = doc.createElementNS("", "a");
        List result = xpath.selectNodes(a);
        assertEquals(1, result.size());
        assertEquals(Boolean.FALSE, result.get(0));
    }

    public void testBooleanFunctionRequiresOneArgument() throws JaxenException {
        BaseXPath xpath = new DOMXPath("boolean()");
        org.w3c.dom.Element a = doc.createElementNS("", "a");
        try {
            xpath.selectNodes(a);
            fail("Allowed boolean function with no arguments");
        } catch (FunctionCallException ex) {
            assertNotNull(ex.getMessage());
        }
    }

    public void testNaNIsFalse() throws JaxenException {
        BaseXPath xpath = new DOMXPath("boolean(0 div 0)");
        Object result = xpath.evaluate(null);
        assertEquals(Boolean.FALSE, result);
    }

    public void testNonEmptyStringIsTrue() throws JaxenException {
        BaseXPath xpath = new DOMXPath("boolean('false')");
        org.w3c.dom.Element a = doc.createElementNS("", "a");
        List result = xpath.selectNodes(a);
        assertEquals(1, result.size());
        assertEquals(Boolean.TRUE, result.get(0));
    }

    public void testZeroIsFalse() throws JaxenException {
        BaseXPath xpath = new DOMXPath("boolean(0)");
        org.w3c.dom.Element a = doc.createElementNS("", "a");
        List result = xpath.selectNodes(a);
        assertEquals(1, result.size());
        assertEquals(Boolean.FALSE, result.get(0));
    }

    public void testBooleanFunctionRequiresExactlyOneArgument() throws JaxenException {
        BaseXPath xpath = new DOMXPath("boolean('', '')");
        org.w3c.dom.Element a = doc.createElementNS("", "a");
        try {
            xpath.selectNodes(a);
            fail("Allowed boolean function with two arguments");
        } catch (FunctionCallException ex) {
            assertNotNull(ex.getMessage());
        }
    }

    public void testEmptyNodeSetsAreFalse() throws JaxenException {
        BaseXPath xpath = new DOMXPath("boolean(//y)");
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
        x2.appendChild(doc.createTextNode("false"));
        x3.appendChild(doc.createTextNode("false"));
        x4.appendChild(doc.createTextNode("false"));
        List result = xpath.selectNodes(doc);
        assertEquals(1, result.size());
        assertEquals(Boolean.FALSE, result.get(0));
    }

    public void testNonEmptyNodeSetsAreTrue() throws JaxenException {
        BaseXPath xpath = new DOMXPath("boolean(//x)");
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
        x2.appendChild(doc.createTextNode("false"));
        x3.appendChild(doc.createTextNode("false"));
        x4.appendChild(doc.createTextNode("false"));
        List result = xpath.selectNodes(doc);
        assertEquals(1, result.size());
        assertEquals(Boolean.TRUE, result.get(0));
    }
}
