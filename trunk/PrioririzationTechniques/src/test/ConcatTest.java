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

public class ConcatTest extends TestCase {

    public ConcatTest(String name) {
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

    public void testConcatFunctionRequiresAtLeastTwoArguments() throws JaxenException {
        BaseXPath xpath = new DOMXPath("concat('a')");
        try {
            xpath.selectNodes(doc);
            fail("Allowed concat function with one argument");
        } catch (FunctionCallException ex) {
            assertNotNull(ex.getMessage());
        }
    }
}
