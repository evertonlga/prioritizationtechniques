package test;

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

public class NormalizeSpaceTest extends TestCase {

    public NormalizeSpaceTest(String name) {
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

    public void testNormalizeSpaceRequiresAtMostOneArguments() throws JaxenException {
        BaseXPath xpath = new DOMXPath("normalize-space('a', 'a')");
        try {
            xpath.selectNodes(doc);
            fail("Allowed normalize-space function with two arguments");
        } catch (FunctionCallException ex) {
            assertNotNull(ex.getMessage());
        }
    }

    public void testNormalizeSpaceUsesXMLSpaceRulesNotJavaRules() throws JaxenException {
        String data = "?X?";
        XPath xpath = new DOMXPath("normalize-space('" + data + "')");
        String result = (String) xpath.evaluate(doc);
        assertEquals(data, result);
    }

    public void testNormalizeSpaceUsesXMLSpaceRulesNotJavaRules2() throws JaxenException {
        String data = "?X?";
        XPath xpath = new DOMXPath("normalize-space(' " + data + " ')");
        String result = (String) xpath.evaluate(doc);
        assertEquals(data, result);
    }

    public void testNormalizeSpaceInContextNode() throws JaxenException {
        XPath xpath = new DOMXPath("normalize-space()");
        String result = (String) xpath.evaluate(doc);
        assertEquals("", result);
    }
}
