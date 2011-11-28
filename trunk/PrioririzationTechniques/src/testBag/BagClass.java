package testBag;

import javax.xml.parsers.ParserConfigurationException;
import java.util.NoSuchElementException;
import org.jaxen.saxpath.SAXPathException;
import org.jaxen.util.AncestorOrSelfAxisIterator;
import javax.xml.parsers.DocumentBuilderFactory;
import org.jaxen.dom.DOMXPath;
import junit.framework.TestCase;
import org.jaxen.NamespaceContext;
import org.jaxen.XPath;
import java.util.Iterator;
import org.w3c.dom.Document;

public class BagClass extends TestCase {

    public void testDefaultContext() throws SAXPathException {
        XPath xpath = new DOMXPath("foo");
        xpath.addNamespace("cheese", "http://cheese.org");
        xpath.addNamespace("squeeze", "http://squeeze.org");
        NamespaceContext nsContext = xpath.getNamespaceContext();
        assertEquals("http://cheese.org", nsContext.translateNamespacePrefixToUri("cheese"));
        assertEquals("http://squeeze.org", nsContext.translateNamespacePrefixToUri("squeeze"));
    }

    protected void setUp() throws ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        Document doc = factory.newDocumentBuilder().newDocument();
        doc.appendChild(doc.createElement("root"));
        iterator = new AncestorOrSelfAxisIterator(doc, new org.jaxen.dom.DocumentNavigator());
    }

    public void testNoInfiniteLoops() {
        iterator.next();
        try {
            iterator.next();
            fail("Iterated twice");
        } catch (NoSuchElementException ex) {
        }
    }

    public void testRemove() {
        try {
            iterator.remove();
            fail("Removed from iterator");
        } catch (UnsupportedOperationException ex) {
        }
    }

    private Iterator iterator;
}
