package test;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import junit.framework.TestCase;
import org.jaxen.JaxenException;
import org.jaxen.XPath;
import org.jaxen.dom.DOMXPath;
import org.w3c.dom.Document;

public class ArithmeticTest extends TestCase {

    public ArithmeticTest(String name) {
        super(name);
    }

    private Document doc;

    public void setUp() throws ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc = builder.newDocument();
        org.w3c.dom.Element a = doc.createElementNS("", "a");
        doc.appendChild(a);
    }

    public void testNumbersThatBeginWithADecimalPoint() throws JaxenException {
        XPath xpath = new DOMXPath(".5 > .4");
        Boolean result = (Boolean) xpath.evaluate(doc);
        assertTrue(result.booleanValue());
    }

    public void testNumbersThatBeginWithADecimalPoint2() throws JaxenException {
        XPath xpath = new DOMXPath(".3 <= .4 <= 1.1");
        Boolean result = (Boolean) xpath.evaluate(doc);
        assertTrue(result.booleanValue());
    }

    public void testLeftAssociativityOfLessThanOrEqual() throws JaxenException {
        XPath xpath = new DOMXPath(".3 <= .4 <= 0.9");
        Boolean result = (Boolean) xpath.evaluate(doc);
        assertFalse(result.booleanValue());
    }
}
