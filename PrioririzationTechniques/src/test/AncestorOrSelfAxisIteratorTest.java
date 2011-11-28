package test;

import java.util.Iterator;
import java.util.NoSuchElementException;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.jaxen.util.AncestorOrSelfAxisIterator;
import org.w3c.dom.Document;
import junit.framework.TestCase;

public class AncestorOrSelfAxisIteratorTest extends TestCase {

    public AncestorOrSelfAxisIteratorTest(String name) {
        super(name);
    }

    private Iterator iterator;

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
}
