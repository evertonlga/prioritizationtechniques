package test;

import java.util.Iterator;
import java.util.NoSuchElementException;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.jaxen.UnsupportedAxisException;
import org.jaxen.util.PrecedingAxisIterator;
import org.w3c.dom.Document;
import junit.framework.TestCase;

public class PrecedingAxisIteratorTest extends TestCase {

    public PrecedingAxisIteratorTest(String name) {
        super(name);
    }

    private Iterator iterator;

    protected void setUp() throws ParserConfigurationException, UnsupportedAxisException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        Document doc = factory.newDocumentBuilder().newDocument();
        doc.appendChild(doc.createElement("root"));
        iterator = new PrecedingAxisIterator(doc, new org.jaxen.dom.DocumentNavigator());
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

    public void testRemove() {
        try {
            iterator.remove();
            fail("Removed from descendant axis iterator");
        } catch (UnsupportedOperationException ex) {
            pass();
        }
    }
}
