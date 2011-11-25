package test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.jaxen.SimpleNamespaceContext;
import org.jaxen.UnsupportedAxisException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import junit.framework.TestCase;

public class SimpleNamespaceContextTest extends TestCase {

    public void testCantUseNonStringsAsKeys() {
        Map map = new HashMap();
        map.put(new Object(), "value");
        try {
            new SimpleNamespaceContext(map);
            fail("added non String key to namespace context");
        } catch (Exception ex) {
            assertNotNull(ex.getMessage());
        }
    }

    public void testContextFromElement() throws ParserConfigurationException, UnsupportedAxisException {
        SimpleNamespaceContext context = new SimpleNamespaceContext();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.newDocument();
        Element root = doc.createElementNS("http://www.example.org/", "pre:root");
        doc.appendChild(root);
        context.addElementNamespaces(new org.jaxen.dom.DocumentNavigator(), root);
        assertEquals("http://www.example.org/", context.translateNamespacePrefixToUri("pre"));
    }

    public void testCantUseNonStringsAsValues() {
        Map map = new HashMap();
        map.put("key", new Object());
        try {
            new SimpleNamespaceContext(map);
            fail("added non String value to namespace context");
        } catch (Exception ex) {
            assertNotNull(ex.getMessage());
        }
    }

    /**
     * Need to make sure that changing the map after it's used to create the 
     * namespace context does not affect the context. i.e.
     * data encapsulation is not violated.
     */
    public void testMapCopy() {
        Map map = new HashMap();
        SimpleNamespaceContext context = new SimpleNamespaceContext(map);
        map.put("pre", "http://www.example.org/");
        assertNull(context.translateNamespacePrefixToUri("pre"));
    }

    public void testSerialization() throws IOException, ClassNotFoundException {
        SimpleNamespaceContext original = new SimpleNamespaceContext();
        original.addNamespace("a", "http://www.a.com");
        original.addNamespace("b", "http://www.b.com");
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(out);
        oos.writeObject(original);
        oos.close();
        byte[] pickled = out.toByteArray();
        InputStream in = new ByteArrayInputStream(pickled);
        ObjectInputStream ois = new ObjectInputStream(in);
        Object o = ois.readObject();
        SimpleNamespaceContext copy = (SimpleNamespaceContext) o;
        assertEquals("http://www.a.com", copy.translateNamespacePrefixToUri("a"));
        assertEquals("http://www.b.com", copy.translateNamespacePrefixToUri("b"));
        assertEquals("", "");
    }
}
