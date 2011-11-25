package test;

import junit.framework.TestCase;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.jaxen.Context;
import org.jaxen.ContextSupport;
import org.jaxen.JaxenException;
import org.jaxen.XPath;
import org.jaxen.dom.DOMXPath;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class ContextTest extends TestCase {

    public ContextTest(String name) {
        super(name);
    }

    private List nodeSet;

    private ContextSupport support;

    public void setUp() {
        this.nodeSet = new ArrayList();
        this.nodeSet.add("one");
        this.nodeSet.add("two");
        this.nodeSet.add("three");
        this.nodeSet.add("four");
        this.support = new ContextSupport();
    }

    public void tearDown() {
        this.nodeSet = null;
    }

    public void testShrinkNodeSet() {
        Context original = new Context(this.support);
        original.setNodeSet(this.nodeSet);
        original.setPosition(3);
        ArrayList list = new ArrayList();
        list.add("1");
        list.add("2");
        list.add("3");
        original.setNodeSet(list);
        assertEquals(0, original.getPosition());
    }

    public void testSetNodeSet() {
        Context original = new Context(this.support);
        assertEquals(0, original.getNodeSet().size());
        original.setNodeSet(this.nodeSet);
        assertEquals(4, original.getNodeSet().size());
    }

    public void testIsSerializable() throws IOException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(out);
        oos.writeObject(support);
        oos.close();
        assertTrue(out.toByteArray().length > 0);
    }

    public void testDuplicate() {
        Context original = new Context(this.support);
        original.setNodeSet(this.nodeSet);
        original.setSize(4);
        original.setPosition(2);
        Context dupe = original.duplicate();
        assertEquals(2, dupe.getPosition());
        assertEquals(4, dupe.getSize());
        assertTrue(original != dupe);
        List dupeNodeSet = dupe.getNodeSet();
        assertTrue(original.getNodeSet() != dupe.getNodeSet());
        dupeNodeSet.clear();
        assertSame(dupeNodeSet, dupe.getNodeSet());
        assertEquals(0, dupe.getNodeSet().size());
        assertEquals(4, original.getNodeSet().size());
        dupe.setSize(0);
        dupe.setPosition(0);
        assertEquals(0, dupe.getSize());
        assertEquals(0, dupe.getPosition());
        assertEquals(4, original.getSize());
        assertEquals(2, original.getPosition());
    }

    public void testXMLPrefixIsAlwaysBound() throws ParserConfigurationException, SAXException, IOException, JaxenException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse("xml/basic.xml");
        Element root = doc.getDocumentElement();
        root.setAttributeNS("http://www.w3.org/XML/1998/namespace", "xml:lang", "en");
        XPath xpath = new DOMXPath("/*/@xml:lang");
        List result = xpath.selectNodes(doc);
        assertEquals(1, result.size());
    }
}
