package test;

import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import junit.framework.TestCase;
import org.jaxen.JaxenException;
import org.jaxen.XPath;
import org.jaxen.dom.DOMXPath;
import org.w3c.dom.Document;

public class DefaultNamestepTest extends TestCase {

    public DefaultNamestepTest(String name) {
        super(name);
    }

    private Document doc;

    public void setUp() throws ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc = builder.newDocument();
    }

    public void testIdentitySetUsageInDefaultNameStep() throws JaxenException {
        XPath xpath = new DOMXPath("/a/x/preceding-sibling::x[last()]");
        org.w3c.dom.Element a = doc.createElementNS("", "a");
        doc.appendChild(a);
        org.w3c.dom.Element x1 = doc.createElementNS("", "x");
        org.w3c.dom.Element x2 = doc.createElementNS("", "x");
        org.w3c.dom.Element x3 = doc.createElementNS("", "x");
        org.w3c.dom.Element x4 = doc.createElementNS("", "x");
        org.w3c.dom.Element x5 = doc.createElementNS("", "x");
        a.appendChild(x1);
        a.appendChild(x2);
        a.appendChild(x3);
        a.appendChild(x4);
        a.appendChild(x5);
        x1.appendChild(doc.createTextNode("1"));
        x2.appendChild(doc.createTextNode("2"));
        x3.appendChild(doc.createTextNode("3"));
        x4.appendChild(doc.createTextNode("4"));
        x5.appendChild(doc.createTextNode("5"));
        List result = xpath.selectNodes(doc);
        assertEquals(1, result.size());
        assertEquals(x1, result.get(0));
    }
}
