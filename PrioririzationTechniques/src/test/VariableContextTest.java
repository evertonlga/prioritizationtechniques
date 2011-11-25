package test;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.jaxen.JaxenException;
import org.jaxen.SimpleVariableContext;
import org.jaxen.UnresolvableException;
import org.jaxen.dom.DOMXPath;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import junit.framework.TestCase;

public class VariableContextTest extends TestCase {

    private Document doc;

    public void setUp() throws ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        doc = factory.newDocumentBuilder().newDocument();
        Element root = doc.createElementNS("http://www.example.org/", "root");
        doc.appendChild(root);
        root.setAttributeNS("http://www.w3.org/2000/xmlns/", "xmlns", "http://www.example.org/");
    }

    public void testSetNamespacelessVariable() throws JaxenException {
        SimpleVariableContext context = new SimpleVariableContext();
        context.setVariableValue("foo", "bar");
        assertEquals("bar", context.getVariableValue("", "", "foo"));
    }

    public void testUnresolvableVariable() throws JaxenException {
        DOMXPath xpath = new DOMXPath("$a/root");
        try {
            xpath.evaluate(doc);
            fail("Evaluated nonexistent variable");
        } catch (UnresolvableException ex) {
            assertEquals("Variable a", ex.getMessage());
        }
    }

    public void testGetVariableContext() throws JaxenException {
        DOMXPath xpath = new DOMXPath("/root/child");
        assertNotNull(xpath.getVariableContext());
    }
}
