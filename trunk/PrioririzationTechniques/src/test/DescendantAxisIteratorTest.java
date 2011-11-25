package test;

import java.util.Iterator;
import java.util.NoSuchElementException;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.jaxen.UnsupportedAxisException;
import org.jaxen.util.DescendantAxisIterator;
import org.w3c.dom.Document;
import junit.framework.TestCase;

public class DescendantAxisIteratorTest extends TestCase {

    public DescendantAxisIteratorTest(String name) {
        super(name);
    }

    private Iterator iterator;

    protected void setUp() throws ParserConfigurationException, UnsupportedAxisException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        Document doc = factory.newDocumentBuilder().newDocument();
        doc.appendChild(doc.createElement("root"));
        iterator = new DescendantAxisIterator(doc, new org.jaxen.dom.DocumentNavigator());
    }

    public void testNoInfiniteLoops() {
        iterator.next();
        try {
            iterator.next();
            fail("Iterated too far");
        } catch (NoSuchElementException ex) {
        }
    }

    public void testRemove() {
        try {
            iterator.remove();
            fail("Removed from descendant axis iterator");
        } catch (UnsupportedOperationException ex) {
        }
    }
}
