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

public class SumTest extends TestCase {

    public SumTest(String name) {
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

    public void testSumOfNumber() throws JaxenException {
        try {
            XPath xpath = new DOMXPath("sum(3)");
            xpath.selectNodes(doc);
            fail("sum of non-node-set");
        } catch (FunctionCallException e) {
            assertEquals("The argument to the sum function must be a node-set", e.getMessage());
        }
    }

    public void testSumNoArguments() throws JaxenException {
        try {
            XPath xpath = new DOMXPath("sum()");
            xpath.selectNodes(doc);
            fail("sum of nothing");
        } catch (FunctionCallException e) {
            assertEquals("sum() requires one argument.", e.getMessage());
        }
    }
}
