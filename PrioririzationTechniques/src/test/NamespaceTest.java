package test;

import java.util.List;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.jaxen.JaxenException;
import org.jaxen.SimpleNamespaceContext;
import org.jaxen.UnresolvableException;
import org.jaxen.XPath;
import org.jaxen.dom.DOMXPath;
import org.w3c.dom.Attr;
import org.w3c.dom.Element;
import junit.framework.TestCase;

public class NamespaceTest extends TestCase {

    public NamespaceTest(String name) {
        super(name);
    }

    private org.w3c.dom.Document doc;

    protected void setUp() throws ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        doc = factory.newDocumentBuilder().newDocument();
    }

    public void testUnprefixedNamespaceAxis() throws JaxenException {
        Element root = doc.createElement("root");
        doc.appendChild(root);
        Element child = doc.createElementNS("http://www.example.org", "child");
        root.appendChild(child);
        XPath xpath = new DOMXPath("namespace::node()");
        List result = xpath.selectNodes(child);
        assertEquals(2, result.size());
    }

    public void testNamespaceNodesReadFromAttributes() throws JaxenException {
        Element root = doc.createElement("root");
        doc.appendChild(root);
        Attr a = doc.createAttributeNS("http://www.example.org/", "a");
        a.setNodeValue("value");
        root.setAttributeNode(a);
        XPath xpath = new DOMXPath("namespace::node()");
        List result = xpath.selectNodes(root);
        assertEquals(2, result.size());
    }

    public void testMultipleNamespaceAxis() throws JaxenException {
        Element root = doc.createElement("root");
        doc.appendChild(root);
        Element child = doc.createElementNS("http://www.example.org", "child");
        child.setAttributeNS("http://www.w3.org/2000/xmlns/", "xmlns:pre", "value");
        root.appendChild(child);
        XPath xpath = new DOMXPath("namespace::node()");
        List result = xpath.selectNodes(child);
        assertEquals(3, result.size());
    }

    public void testQueryDefaultNamespace() throws JaxenException {
        Element root = doc.createElementNS("http://www.example.org/", "root");
        doc.appendChild(root);
        XPath xpath = new DOMXPath("/pre:root");
        xpath.addNamespace("pre", "http://www.example.org/");
        List result = xpath.selectNodes(root);
        assertEquals(1, result.size());
    }

    public void testUnboundNamespaceUsedInXPathExpression() throws JaxenException {
        Element root = doc.createElementNS("http://www.example.org/", "root");
        doc.appendChild(root);
        XPath xpath = new DOMXPath("/pre:root");
        try {
            xpath.selectNodes(root);
            fail("Used unresolvable prefix");
        } catch (UnresolvableException ex) {
            assertNotNull(ex.getMessage());
        }
    }

    public void testNamespaceAxis() throws JaxenException {
        Element root = doc.createElement("root");
        doc.appendChild(root);
        Element child = doc.createElementNS("http://www.example.org", "foo:child");
        root.appendChild(child);
        XPath xpath = new DOMXPath("namespace::node()");
        List result = xpath.selectNodes(child);
        assertEquals(2, result.size());
    }

    public void testNumberOfNamespaceNodes() throws JaxenException {
        Element root = doc.createElement("root");
        doc.appendChild(root);
        Element child = doc.createElementNS("http://www.example.org", "foo:child");
        root.appendChild(child);
        XPath xpath = new DOMXPath("//namespace::node()");
        List result = xpath.selectNodes(doc);
        assertEquals(3, result.size());
    }

    public void testQueryDefaultNamespaceWithContext() throws JaxenException {
        Element root = doc.createElementNS("http://www.example.org/", "root");
        doc.appendChild(root);
        XPath xpath = new DOMXPath("/pre:root");
        SimpleNamespaceContext context = new SimpleNamespaceContext();
        context.addNamespace("pre", "http://www.example.org/");
        xpath.setNamespaceContext(context);
        List result = xpath.selectNodes(root);
        assertEquals(1, result.size());
    }
}
