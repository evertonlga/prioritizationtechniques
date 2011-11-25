package test;

import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import junit.framework.TestCase;
import org.jaxen.JaxenException;
import org.jaxen.XPath;
import org.jaxen.dom.DOMXPath;
import org.jaxen.saxpath.SAXPathException;
import org.jaxen.saxpath.base.XPathReader;
import org.jaxen.saxpath.XPathSyntaxException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class XPathReaderTest extends TestCase {

    public XPathReaderTest(String name) {
        super(name);
    }

    private ConformanceXPathHandler actual;

    private Document doc;

    private XPathReader reader;

    private String[] paths = { "/foo/bar[@a='1' and @b='2']", "/foo/bar[@a='1' and @b!='2']", "$varname[@a='1']", "//attribute::*[.!='crunchy']", "'//*[contains(string(text()),\"yada yada\")]'" };

    private String[][] bogusPaths = { new String[] { "chyld::foo", "Expected valid axis name instead of [chyld]" }, new String[] { "foo/tacos()", "Expected node-type" }, new String[] { "foo/tacos()", "Expected node-type" }, new String[] { "*:foo", "Unexpected ':'" }, new String[] { "/foo/bar[baz", "Expected: ]" }, new String[] { "/cracker/cheese[(mold > 1) and (sense/taste", "Expected: )" }, new String[] { "//", "Location path cannot end with //" }, new String[] { "foo/$variable/foo", "Expected one of '.', '..', '@', '*', <QName>" } };

    public void setUp() throws ParserConfigurationException, SAXException, IOException {
        this.reader = new XPathReader();
        this.actual = new ConformanceXPathHandler();
        this.reader.setXPathHandler(this.actual);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc = builder.parse("xml/basic.xml");
    }

    public void tearDown() {
        this.reader = null;
    }

    public void testChildrenOfNumber() throws SAXPathException {
        try {
            reader.parse("1/child::test");
            fail("Should have thrown XPathSyntaxException for 1/child::test");
        } catch (XPathSyntaxException e) {
            assertEquals("Node-set expected", e.getMessage());
        }
    }

    public void testAndImmediatelyFollowedByRelativeLocationPath() throws JaxenException {
        XPath xpath = new DOMXPath("true() andfoo");
        Boolean result = (Boolean) xpath.evaluate(doc);
        assertTrue(result.booleanValue());
    }

    public void testChildIsNumber() throws SAXPathException {
        try {
            reader.parse("jane/3");
            fail("Should have thrown XPathSyntaxException for jane/3");
        } catch (XPathSyntaxException e) {
            assertEquals("Expected one of '.', '..', '@', '*', <QName>", e.getMessage());
        }
    }

    public void testNoSpaceAfterPlus() throws JaxenException {
        XPath xpath = new DOMXPath("105 +10");
        Double result = (Double) xpath.evaluate(doc);
        assertEquals(115, result.intValue());
    }

    public void testLocationPathStartsWithParentheses() throws SAXPathException {
        reader.parse("(//x)/foo");
    }

    public void testBogusPaths() throws SAXPathException {
        for (int i = 0; i < bogusPaths.length; ++i) {
            final String[] bogusPath = bogusPaths[i];
            try {
                reader.parse(bogusPath[0]);
                fail("Should have thrown XPathSyntaxException for " + bogusPath[0]);
            } catch (XPathSyntaxException e) {
                assertEquals(bogusPath[1], e.getMessage());
            }
        }
    }

    public void testInvalidAxis() throws SAXPathException {
        try {
            reader.parse("chyld::foo");
            fail("Should have thrown XPathSyntaxException");
        } catch (XPathSyntaxException ex) {
            assertNotNull(ex.getMessage());
        }
    }

    public void testNumberOrNumber() {
        try {
            XPath xpath = new DOMXPath("4 | 5");
            xpath.selectNodes(doc);
            fail("Should have thrown XPathSyntaxException for 4 | 5");
        } catch (JaxenException e) {
            assertEquals("Unions are only allowed over node-sets", e.getMessage());
        }
    }

    public void testNoSpaceAfterDiv() throws JaxenException {
        XPath xpath = new DOMXPath("105 div10");
        Double result = (Double) xpath.evaluate(doc);
        assertEquals(10.5, result.doubleValue(), 0.000001);
    }

    public void testLocationPathStartsWithVariable() throws SAXPathException {
        reader.parse("$variable/foo");
    }

    public void testNoSpaceAfterAnd() throws JaxenException {
        XPath xpath = new DOMXPath("true() andfalse()");
        Boolean result = (Boolean) xpath.evaluate(doc);
        assertFalse(result.booleanValue());
    }

    public void testStringOrNumber() {
        try {
            XPath xpath = new DOMXPath("\"test\" | 5");
            xpath.selectNodes(doc);
            fail("Should have thrown XPathSyntaxException for \"test\" | 5");
        } catch (JaxenException e) {
            assertEquals("Unions are only allowed over node-sets", e.getMessage());
        }
    }

    public void testUnionofNodesAndNonNodes() {
        try {
            XPath xpath = new DOMXPath("count(//*) | //* ");
            xpath.selectNodes(doc);
            fail("Should have thrown XPathSyntaxException for \"count(//*) | //* ");
        } catch (JaxenException e) {
            assertEquals("Unions are only allowed over node-sets", e.getMessage());
        }
    }

    public void testPaths() throws SAXPathException {
        for (int i = 0; i < paths.length; ++i) {
            reader.parse(paths[i]);
        }
    }

    public void testNoSpaceAfterMod() throws JaxenException {
        XPath xpath = new DOMXPath("105 mod10");
        Double result = (Double) xpath.evaluate(doc);
        assertEquals(5, result.intValue());
    }

    public void testValidAxis() throws SAXPathException {
        reader.parse("child::foo");
    }

    public void testNoSpaceAfterOr() throws JaxenException {
        XPath xpath = new DOMXPath("true() orfalse()");
        Boolean result = (Boolean) xpath.evaluate(doc);
        assertTrue(result.booleanValue());
    }

    public void testStringOrString() {
        try {
            XPath xpath = new DOMXPath("\"test\" | \"festival\"");
            xpath.selectNodes(doc);
            fail("Should have thrown XPathSyntaxException for \"test\" | 5");
        } catch (JaxenException e) {
            assertEquals("Unions are only allowed over node-sets", e.getMessage());
        }
    }
}
