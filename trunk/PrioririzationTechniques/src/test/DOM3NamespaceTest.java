package test;

import java.util.Iterator;
import java.util.List;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.jaxen.*;
import org.jaxen.dom.DOMXPath;
import org.jaxen.dom.NamespaceNode;
import org.w3c.dom.*;
import junit.framework.TestCase;

public class DOM3NamespaceTest extends TestCase {

    public DOM3NamespaceTest(String name) {
        super(name);
    }

    private NamespaceNode xmlNS;

    private NamespaceNode rootNS;

    private NamespaceNode attributeNS;

    protected void setUp() throws ParserConfigurationException, JaxenException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        Document doc = factory.newDocumentBuilder().newDocument();
        org.w3c.dom.Element root = doc.createElementNS("http://www.root.com/", "root");
        doc.appendChild(root);
        Attr a = doc.createAttributeNS("http://www.example.org/", "pre:a");
        a.setNodeValue("value");
        root.setAttributeNode(a);
        XPath xpath = new DOMXPath("namespace::node()");
        List result = xpath.selectNodes(root);
        Iterator iterator = result.iterator();
        while (iterator.hasNext()) {
            NamespaceNode node = (NamespaceNode) iterator.next();
            if (node.getLocalName() == null) rootNS = node; else if (node.getLocalName().equals("xml")) xmlNS = node; else if (node.getLocalName().equals("pre")) attributeNS = node;
        }
    }

    public void testIsEqualNode() {
        assertFalse(rootNS.isEqualNode(xmlNS));
        assertTrue(rootNS.isEqualNode(rootNS));
    }

    public void testGetFeature() {
        assertNull(attributeNS.getFeature("name", "value"));
    }

    public void testGetTextContent() {
        assertEquals("http://www.w3.org/XML/1998/namespace", xmlNS.getTextContent());
    }

    public void testSetTextContent() {
        try {
            rootNS.setTextContent("http://www.a.com");
            fail("set text content");
        } catch (DOMException ex) {
            assertEquals(DOMException.NO_MODIFICATION_ALLOWED_ERR, ex.code);
        }
    }

    public void testIsSameNode() {
        assertFalse(rootNS.isSameNode(xmlNS));
        assertTrue(rootNS.isSameNode(rootNS));
    }
}
