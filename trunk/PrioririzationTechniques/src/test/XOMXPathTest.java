package test;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import junit.framework.TestCase;
import nu.xom.Builder;
import nu.xom.Document;
import nu.xom.Element;
import nu.xom.ParsingException;
import org.jaxen.JaxenException;
import org.jaxen.XPath;
import org.jaxen.xom.XOMXPath;

public class XOMXPathTest extends TestCase {

    public XOMXPathTest(String name) {
        super(name);
    }

    private static final String BASIC_XML = "xml/basic.xml";

    public void testSelection() throws ParsingException, IOException, JaxenException {
        XPath xpath = new XOMXPath("/foo/bar/baz");
        Builder builder = new Builder();
        Document doc = builder.build(BASIC_XML);
        List results = xpath.selectNodes(doc);
        assertEquals(3, results.size());
        Iterator iter = results.iterator();
        assertEquals("baz", ((Element) iter.next()).getLocalName());
        assertEquals("baz", ((Element) iter.next()).getLocalName());
        assertEquals("baz", ((Element) iter.next()).getLocalName());
        assertTrue(!iter.hasNext());
    }

    public void testConstruction() throws JaxenException {
        new XOMXPath("/foo/bar/baz");
    }
}
