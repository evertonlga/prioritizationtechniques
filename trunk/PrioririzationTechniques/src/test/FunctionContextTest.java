package test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectOutputStream;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.jaxen.FunctionContext;
import org.jaxen.JaxenException;
import org.jaxen.SimpleNamespaceContext;
import org.jaxen.UnresolvableException;
import org.jaxen.dom.DOMXPath;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import junit.framework.TestCase;

public class FunctionContextTest extends TestCase {

    private Document doc;

    public void setUp() throws ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        doc = factory.newDocumentBuilder().newDocument();
        Element root = doc.createElementNS("http://www.example.org/", "root");
        doc.appendChild(root);
        root.setAttributeNS("http://www.w3.org/2000/xmlns/", "xmlns", "http://www.example.org/");
    }

    public void testSerializeFunctionContext() throws JaxenException, IOException {
        DOMXPath xpath = new DOMXPath("/root/child");
        FunctionContext context = xpath.getFunctionContext();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ObjectOutputStream oout = new ObjectOutputStream(out);
        try {
            oout.writeObject(context);
            fail("serialized function context");
        } catch (NotSerializableException ex) {
            assertNotNull(ex.getMessage());
        }
    }

    public void testUnresolvableFunctionExceptionMessage() throws JaxenException {
        DOMXPath xpath = new DOMXPath("nonesuch()");
        try {
            xpath.evaluate(doc);
            fail("Evaluated nonexistent function");
        } catch (UnresolvableException ex) {
            assertEquals(-1, ex.getMessage().indexOf(':'));
        }
    }

    public void testGetFunctionContext() throws JaxenException {
        DOMXPath xpath = new DOMXPath("/root/child");
        assertNotNull(xpath.getFunctionContext());
    }

    public void testUnresolvableFunction() throws JaxenException {
        DOMXPath xpath = new DOMXPath("nonesuch()");
        try {
            xpath.evaluate(doc);
            fail("Evaluated nonexistent function");
        } catch (UnresolvableException ex) {
            assertNotNull(ex.getMessage());
        }
    }

    public void testJAXEN50() throws JaxenException {
        DOMXPath xpath = new DOMXPath("true()");
        SimpleNamespaceContext nsContext = new SimpleNamespaceContext();
        nsContext.addElementNamespaces(xpath.getNavigator(), doc);
        xpath.setNamespaceContext(nsContext);
        boolean result = xpath.booleanValueOf(doc);
        assertTrue(result);
    }
}
