package test;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.jaxen.JaxenException;
import org.jaxen.UnresolvableException;
import org.jaxen.XPath;
import org.jaxen.dom.DOMXPath;
import junit.framework.TestCase;

public class UnresolvableExceptionTest extends TestCase {

    public UnresolvableExceptionTest(String name) {
        super(name);
    }

    private org.w3c.dom.Document doc;

    protected void setUp() throws ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        doc = factory.newDocumentBuilder().newDocument();
        doc.appendChild(doc.createElement("foo"));
    }

    public void testUnresolvableFunction() throws JaxenException {
        try {
            XPath xpath = new DOMXPath("nonesuch()");
            xpath.evaluate(doc);
            fail("Didn't throw Unresolvable Exception");
        } catch (UnresolvableException ex) {
            assertNotNull(ex.getMessage());
        }
    }

    public void testUnresolvableVariable() throws JaxenException {
        try {
            XPath xpath = new DOMXPath("//foo[bar = $var]");
            xpath.evaluate(doc);
            fail("Didn't throw Unresolvable Exception");
        } catch (UnresolvableException ex) {
            assertNotNull(ex.getMessage());
        }
    }
}
