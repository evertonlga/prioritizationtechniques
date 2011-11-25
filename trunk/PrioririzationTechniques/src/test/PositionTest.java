package test;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import junit.framework.TestCase;
import org.jaxen.FunctionCallException;
import org.jaxen.JaxenException;
import org.jaxen.XPath;
import org.jaxen.dom.DOMXPath;
import org.w3c.dom.Document;

public class PositionTest extends TestCase {

    public PositionTest(String name) {
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

    public void testPositionOfNumber() throws JaxenException {
        try {
            XPath xpath = new DOMXPath("position(3)");
            xpath.selectNodes(doc);
            fail("position() function took arguments");
        } catch (FunctionCallException e) {
            assertEquals("position() does not take any arguments.", e.getMessage());
        }
    }
}
