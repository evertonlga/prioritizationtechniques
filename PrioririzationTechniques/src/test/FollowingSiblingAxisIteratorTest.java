package test;

import java.util.Iterator;
import java.util.NoSuchElementException;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.jaxen.UnsupportedAxisException;
import org.jaxen.util.FollowingSiblingAxisIterator;
import org.w3c.dom.Document;
import junit.framework.TestCase;

public class FollowingSiblingAxisIteratorTest extends TestCase {

    public FollowingSiblingAxisIteratorTest(String name) {
        super(name);
    }

    private Iterator iterator;

    protected void setUp() throws ParserConfigurationException, UnsupportedAxisException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        Document doc = factory.newDocumentBuilder().newDocument();
        doc.appendChild(doc.createElement("root"));
        iterator = new FollowingSiblingAxisIterator(doc, new org.jaxen.dom.DocumentNavigator());
    }

    public void testRemove() {
        try {
            iterator.remove();
            fail("Removed from descendant axis iterator");
        } catch (UnsupportedOperationException ex) {
            pass();
        }
    }

    public void testNoInfiniteLoops() {
        try {
            iterator.next();
            fail("Iterated too far");
        } catch (NoSuchElementException ex) {
            pass();
        }
    }

    private void pass() {
    }
}
