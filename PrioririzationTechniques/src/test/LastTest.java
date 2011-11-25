package test;

import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import junit.framework.TestCase;
import org.jaxen.BaseXPath;
import org.jaxen.FunctionCallException;
import org.jaxen.JaxenException;
import org.jaxen.dom.DOMXPath;
import org.w3c.dom.Document;

public class LastTest extends TestCase {

    public LastTest(String name) {
        super(name);
    }

    private Document doc;

    public void setUp() throws ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc = builder.newDocument();
    }

    public void testLastFunctionAllowsNoArguments() throws JaxenException {
        try {
            BaseXPath xpath = new DOMXPath("//x[position()=last(.)]");
            org.w3c.dom.Element a = doc.createElementNS("", "a");
            org.w3c.dom.Element b = doc.createElementNS("", "b");
            doc.appendChild(a);
            a.appendChild(b);
            org.w3c.dom.Element x2 = doc.createElementNS("", "x");
            org.w3c.dom.Element x3 = doc.createElementNS("", "x");
            org.w3c.dom.Element x4 = doc.createElementNS("", "x");
            a.appendChild(x4);
            b.appendChild(x2);
            b.appendChild(x3);
            x2.appendChild(doc.createTextNode("2"));
            x3.appendChild(doc.createTextNode("3"));
            x4.appendChild(doc.createTextNode("4"));
            xpath.selectNodes(doc);
            fail("last() function took arguments");
        } catch (FunctionCallException e) {
            assertEquals("last() requires no arguments.", e.getMessage());
        }
    }

    public void testLastFunction() throws JaxenException {
        BaseXPath xpath = new DOMXPath("//x[position()=last()]");
        org.w3c.dom.Element a = doc.createElementNS("", "a");
        org.w3c.dom.Element b = doc.createElementNS("", "b");
        doc.appendChild(a);
        a.appendChild(b);
        org.w3c.dom.Element x2 = doc.createElementNS("", "x");
        org.w3c.dom.Element x3 = doc.createElementNS("", "x");
        org.w3c.dom.Element x4 = doc.createElementNS("", "x");
        a.appendChild(x4);
        b.appendChild(x2);
        b.appendChild(x3);
        x2.appendChild(doc.createTextNode("2"));
        x3.appendChild(doc.createTextNode("3"));
        x4.appendChild(doc.createTextNode("4"));
        List result = xpath.selectNodes(doc);
        assertEquals(2, result.size());
        assertEquals(x3, result.get(0));
        assertEquals(x4, result.get(1));
    }
}
