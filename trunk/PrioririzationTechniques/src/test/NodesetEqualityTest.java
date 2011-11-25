package test;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import junit.framework.TestCase;
import org.jaxen.JaxenException;
import org.jaxen.XPath;
import org.jaxen.dom.DOMXPath;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class NodesetEqualityTest extends TestCase {

    private Document doc;

    public void setUp() throws ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc = builder.newDocument();
        Element a = doc.createElementNS("", "a");
        doc.appendChild(a);
        Element b1 = doc.createElementNS("", "b");
        b1.appendChild(doc.createTextNode("foo"));
        Element b2 = doc.createElementNS("", "b");
        b2.appendChild(doc.createTextNode("bar"));
        Element b3 = doc.createElementNS("", "b");
        b3.appendChild(doc.createTextNode("blort"));
        a.appendChild(b1);
        a.appendChild(b2);
        a.appendChild(b3);
        Element c1 = doc.createElementNS("", "c");
        Element c2 = doc.createElementNS("", "c");
        Element c3 = doc.createElementNS("", "c");
        c2.appendChild(doc.createTextNode(" 12.0 "));
        c3.appendChild(doc.createTextNode("bar"));
        a.appendChild(c1);
        a.appendChild(c2);
        a.appendChild(c3);
    }

    public void testEqualsBooleanNodeset1() throws JaxenException {
        XPath xpath = new DOMXPath("//c = true()");
        Boolean result = (Boolean) xpath.evaluate(doc);
        assertTrue(result.booleanValue());
    }

    public void testEqualsNumberNodeset() throws JaxenException {
        XPath xpath = new DOMXPath("//c = 12");
        Boolean result = (Boolean) xpath.evaluate(doc);
        assertTrue(result.booleanValue());
    }

    public void testNotEqualsBooleanNodeset2() throws JaxenException {
        XPath xpath = new DOMXPath("//d != true()");
        Boolean result = (Boolean) xpath.evaluate(doc);
        assertTrue(result.booleanValue());
    }

    public void testEqualsStringNodeset() throws JaxenException {
        XPath xpath = new DOMXPath("//b = 'blort'");
        Boolean result = (Boolean) xpath.evaluate(doc);
        assertTrue(result.booleanValue());
    }

    public void testEqualsBooleanNodeset2() throws JaxenException {
        XPath xpath = new DOMXPath("//d = false()");
        Boolean result = (Boolean) xpath.evaluate(doc);
        assertTrue(result.booleanValue());
    }

    public void testNotEqualsTwoNodesets() throws JaxenException {
        XPath xpath = new DOMXPath("//a != //b");
        Boolean result = (Boolean) xpath.evaluate(doc);
        assertTrue(result.booleanValue());
    }

    public void testNotEqualsStringNodeset() throws JaxenException {
        XPath xpath = new DOMXPath("//b != 'phooey'");
        Boolean result = (Boolean) xpath.evaluate(doc);
        assertTrue(result.booleanValue());
    }

    public void testEqualsTwoNodesets() throws JaxenException {
        XPath xpath = new DOMXPath("//b = //c");
        Boolean result = (Boolean) xpath.evaluate(doc);
        assertTrue(result.booleanValue());
    }

    public void testNotEqualsNumberNodeset() throws JaxenException {
        XPath xpath = new DOMXPath("//c != 256");
        Boolean result = (Boolean) xpath.evaluate(doc);
        assertTrue(result.booleanValue());
    }

    public void testNotEqualsBooleanNodeset1() throws JaxenException {
        XPath xpath = new DOMXPath("//c != false()");
        Boolean result = (Boolean) xpath.evaluate(doc);
        assertTrue(result.booleanValue());
    }
}
