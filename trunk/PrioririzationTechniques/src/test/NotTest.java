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

public class NotTest extends TestCase {

    public NotTest(String name) {
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

    public void testNaNIsFalse() throws JaxenException {
        BaseXPath xpath = new DOMXPath("not(0 div 0)");
        Object result = xpath.evaluate(null);
        assertEquals(Boolean.TRUE, result);
    }

    public void testZeroIsFalse() throws JaxenException {
        BaseXPath xpath = new DOMXPath("not(0)");
        List result = xpath.selectNodes(doc);
        assertEquals(1, result.size());
        assertEquals(Boolean.TRUE, result.get(0));
    }

    public void testNotFunctionRequiresOneArgument() throws JaxenException {
        BaseXPath xpath = new DOMXPath("not()");
        try {
            xpath.selectNodes(doc);
            fail("Allowed not() function with no arguments");
        } catch (FunctionCallException ex) {
            assertNotNull(ex.getMessage());
        }
    }

    public void testNotFunctionRequiresExactlyOneArgument() throws JaxenException {
        BaseXPath xpath = new DOMXPath("not('', '')");
        try {
            xpath.selectNodes(doc);
            fail("Allowed not() function with two arguments");
        } catch (FunctionCallException ex) {
            assertNotNull(ex.getMessage());
        }
    }

    public void testNonEmptyStringIsTrue() throws JaxenException {
        BaseXPath xpath = new DOMXPath("not('false')");
        List result = xpath.selectNodes(doc);
        assertEquals(1, result.size());
        assertEquals(Boolean.FALSE, result.get(0));
    }

    public void testOneIsTrue() throws JaxenException {
        BaseXPath xpath = new DOMXPath("not(1)");
        List result = xpath.selectNodes(doc);
        assertEquals(1, result.size());
        assertEquals(Boolean.FALSE, result.get(0));
    }

    public void testEmptyStringIsFalse() throws JaxenException {
        BaseXPath xpath = new DOMXPath("not('')");
        List result = xpath.selectNodes(doc);
        assertEquals(1, result.size());
        assertEquals(Boolean.TRUE, result.get(0));
    }
}
