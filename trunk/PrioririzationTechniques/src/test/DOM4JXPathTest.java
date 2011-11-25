package test;

import junit.framework.TestCase;
import java.io.StringReader;
import java.util.Iterator;
import java.util.List;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Namespace;
import org.dom4j.io.SAXReader;
import org.dom4j.tree.DefaultAttribute;
import org.dom4j.tree.DefaultDocument;
import org.dom4j.tree.DefaultElement;
import org.jaxen.JaxenException;
import org.jaxen.XPath;
import org.jaxen.XPathSyntaxException;
import org.jaxen.dom4j.Dom4jXPath;
import org.jaxen.saxpath.helpers.XPathReaderFactory;

public class DOM4JXPathTest extends TestCase {

    public DOM4JXPathTest(String name) {
        super(name);
    }

    private static final String BASIC_XML = "xml/basic.xml";

    public void setUp() {
        System.setProperty(XPathReaderFactory.DRIVER_PROPERTY, "");
    }

    public void testNamespaceNodesAreInherited() throws JaxenException {
        Namespace ns0 = Namespace.get("p0", "www.acme0.org");
        Namespace ns1 = Namespace.get("p1", "www.acme1.org");
        Namespace ns2 = Namespace.get("p2", "www.acme2.org");
        Element element = new DefaultElement("test", ns1);
        Attribute attribute = new DefaultAttribute("pre:foo", "bar", ns2);
        element.add(attribute);
        Element root = new DefaultElement("root", ns0);
        root.add(element);
        Document doc = new DefaultDocument(root);
        XPath xpath = new Dom4jXPath("/*/*/namespace::node()");
        List results = xpath.selectNodes(doc);
        assertEquals(4, results.size());
    }

    public void testSelection() throws JaxenException, DocumentException {
        XPath xpath = new Dom4jXPath("/foo/bar/baz");
        SAXReader reader = new SAXReader();
        Document doc = reader.read(BASIC_XML);
        List results = xpath.selectNodes(doc);
        assertEquals(3, results.size());
        Iterator iter = results.iterator();
        assertEquals("baz", ((Element) iter.next()).getName());
        assertEquals("baz", ((Element) iter.next()).getName());
        assertEquals("baz", ((Element) iter.next()).getName());
        assertTrue(!iter.hasNext());
    }

    public void testJaxen16() throws JaxenException, DocumentException {
        String document = "<a xmlns:b=\"...\"/>";
        SAXReader reader = new SAXReader();
        Document doc = reader.read(new StringReader(document));
        XPath xpath = new Dom4jXPath("/a/b");
        List results = xpath.selectNodes(doc);
        assertEquals(0, results.size());
    }

    public void testSyntaxException() throws JaxenException {
        String path = "/row/[some_node='val1']|[some_node='val2']";
        try {
            new Dom4jXPath(path);
            fail("Allowed union of non-node-sets");
        } catch (XPathSyntaxException success) {
            assertNotNull(success.getMessage());
        }
    }

    public void testJaxen20AttributeNamespaceNodes() throws JaxenException {
        Namespace ns1 = Namespace.get("p1", "www.acme1.org");
        Namespace ns2 = Namespace.get("p2", "www.acme2.org");
        Element element = new DefaultElement("test", ns1);
        Attribute attribute = new DefaultAttribute("pre:foo", "bar", ns2);
        element.add(attribute);
        Document doc = new DefaultDocument(element);
        XPath xpath = new Dom4jXPath("//namespace::node()");
        List results = xpath.selectNodes(doc);
        assertEquals(3, results.size());
    }

    public void testConstruction() throws JaxenException {
        new Dom4jXPath("/foo/bar/baz");
    }

    public void testAsBoolean() throws JaxenException, DocumentException {
        XPath xpath = new Dom4jXPath("/root/a = 'a'");
        SAXReader reader = new SAXReader();
        Document doc = reader.read("xml/simple.xml");
        boolean answer = xpath.booleanValueOf(doc);
        assertTrue("Xpath worked: " + xpath, answer);
        xpath = new Dom4jXPath("'a' = 'b'");
        answer = xpath.booleanValueOf(doc);
        assertTrue("XPath should return false: " + xpath, !answer);
    }
}
