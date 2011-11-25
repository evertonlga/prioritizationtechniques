package test;

import java.io.IOException;
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
import org.xml.sax.SAXException;

public class CountTest extends TestCase {

    public CountTest(String name) {
        super(name);
    }

    private Document doc;

    public void setUp() throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc = builder.parse("xml/basic.xml");
    }

    public void testCount3() {
        try {
            XPath xpath = new DOMXPath("count(3)");
            xpath.selectNodes(doc);
            fail("Allowed count of number");
        } catch (FunctionCallException e) {
            assertEquals("count() function can only be used for node-sets", e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            fail(e.getMessage());
        }
    }

    public void testCountFunctionRequiresAtMostOneArgument() throws JaxenException {
        BaseXPath xpath = new DOMXPath("count(/*, /@*)");
        try {
            xpath.selectNodes(doc);
            fail("Allowed count function with two arguments");
        } catch (FunctionCallException ex) {
            assertNotNull(ex.getMessage());
        }
    }

    public void testCountRootElement() throws JaxenException {
        BaseXPath xpath = new DOMXPath("count(/*)");
        Double result = (Double) xpath.evaluate(doc);
        assertEquals(1.0, result.doubleValue(), 0.00001);
    }

    public void testCountFunctionRequiresAtLeastOneArgument() throws JaxenException {
        BaseXPath xpath = new DOMXPath("count()");
        try {
            xpath.selectNodes(doc);
            fail("Allowed count function with no arguments");
        } catch (FunctionCallException ex) {
            assertNotNull(ex.getMessage());
        }
    }
}
