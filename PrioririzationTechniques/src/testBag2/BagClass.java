package testBag2;

import java.io.IOException;
import org.jaxen.saxpath.XPathSyntaxException;
import org.jaxen.JaxenException;
import org.jaxen.XPath;
import org.w3c.dom.Document;
import javax.xml.parsers.ParserConfigurationException;
import org.jaxen.saxpath.base.XPathReader;
import org.jaxen.saxpath.SAXPathException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.xml.sax.SAXException;
import junit.framework.TestCase;
import org.jaxen.dom.DOMXPath;

import testBag.ConformanceXPathHandler;

public class BagClass extends TestCase {

    private ConformanceXPathHandler actual_XPathReaderTest;

    private Document doc_XPathReaderTest;

    private XPathReader reader_XPathReaderTest;

    private String[] paths_XPathReaderTest = { "/foo/bar[@a='1' and @b='2']", "/foo/bar[@a='1' and @b!='2']", "$varname[@a='1']", "//attribute::*[.!='crunchy']", "'//*[contains(string(text()),\"yada yada\")]'" };

    private String[][] bogusPaths_XPathReaderTest = { new String[] { "chyld::foo", "Expected valid axis name instead of [chyld]" }, new String[] { "foo/tacos()", "Expected node-type" }, new String[] { "foo/tacos()", "Expected node-type" }, new String[] { "*:foo", "Unexpected ':'" }, new String[] { "/foo/bar[baz", "Expected: ]" }, new String[] { "/cracker/cheese[(mold > 1) and (sense/taste", "Expected: )" }, new String[] { "//", "Location path cannot end with //" }, new String[] { "foo/$variable/foo", "Expected one of '.', '..', '@', '*', <QName>" } };

    public void testPaths_XPathReaderTest() throws SAXPathException, ParserConfigurationException, SAXException, IOException {
        this.reader_XPathReaderTest = new XPathReader();
        this.actual_XPathReaderTest = new ConformanceXPathHandler();
        this.reader_XPathReaderTest.setXPathHandler(this.actual_XPathReaderTest);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc_XPathReaderTest = builder.parse("xml/basic.xml");
        for (int i = 0; i < paths_XPathReaderTest.length; ++i) {
            reader_XPathReaderTest.parse(paths_XPathReaderTest[i]);
        }
        this.reader_XPathReaderTest = null;
    }

    public void testBogusPaths_XPathReaderTest() throws SAXPathException, ParserConfigurationException, SAXException, IOException {
        this.reader_XPathReaderTest = new XPathReader();
        this.actual_XPathReaderTest = new ConformanceXPathHandler();
        this.reader_XPathReaderTest.setXPathHandler(this.actual_XPathReaderTest);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc_XPathReaderTest = builder.parse("xml/basic.xml");
        for (int i = 0; i < bogusPaths_XPathReaderTest.length; ++i) {
            final String[] bogusPath = bogusPaths_XPathReaderTest[i];
            try {
                reader_XPathReaderTest.parse(bogusPath[0]);
                fail("Should have thrown XPathSyntaxException for " + bogusPath[0]);
            } catch (XPathSyntaxException e) {
                assertEquals(bogusPath[1], e.getMessage());
            }
        }
        this.reader_XPathReaderTest = null;
    }

    public void testChildrenOfNumber_XPathReaderTest() throws SAXPathException, ParserConfigurationException, SAXException, IOException {
        this.reader_XPathReaderTest = new XPathReader();
        this.actual_XPathReaderTest = new ConformanceXPathHandler();
        this.reader_XPathReaderTest.setXPathHandler(this.actual_XPathReaderTest);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc_XPathReaderTest = builder.parse("xml/basic.xml");
        try {
            reader_XPathReaderTest.parse("1/child::test");
            fail("Should have thrown XPathSyntaxException for 1/child::test");
        } catch (XPathSyntaxException e) {
            assertEquals("Node-set expected", e.getMessage());
        }
        this.reader_XPathReaderTest = null;
    }

    public void testChildIsNumber_XPathReaderTest() throws SAXPathException, ParserConfigurationException, SAXException, IOException {
        this.reader_XPathReaderTest = new XPathReader();
        this.actual_XPathReaderTest = new ConformanceXPathHandler();
        this.reader_XPathReaderTest.setXPathHandler(this.actual_XPathReaderTest);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc_XPathReaderTest = builder.parse("xml/basic.xml");
        try {
            reader_XPathReaderTest.parse("jane/3");
            fail("Should have thrown XPathSyntaxException for jane/3");
        } catch (XPathSyntaxException e) {
            assertEquals("Expected one of '.', '..', '@', '*', <QName>", e.getMessage());
        }
        this.reader_XPathReaderTest = null;
    }

    public void testNumberOrNumber_XPathReaderTest() throws ParserConfigurationException, SAXException, IOException {
        this.reader_XPathReaderTest = new XPathReader();
        this.actual_XPathReaderTest = new ConformanceXPathHandler();
        this.reader_XPathReaderTest.setXPathHandler(this.actual_XPathReaderTest);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc_XPathReaderTest = builder.parse("xml/basic.xml");
        try {
            XPath xpath = new DOMXPath("4 | 5");
            xpath.selectNodes(doc_XPathReaderTest);
            fail("Should have thrown XPathSyntaxException for 4 | 5");
        } catch (JaxenException e) {
            assertEquals("Unions are only allowed over node-sets", e.getMessage());
        }
        this.reader_XPathReaderTest = null;
    }

    public void testStringOrNumber_XPathReaderTest() throws ParserConfigurationException, SAXException, IOException {
        this.reader_XPathReaderTest = new XPathReader();
        this.actual_XPathReaderTest = new ConformanceXPathHandler();
        this.reader_XPathReaderTest.setXPathHandler(this.actual_XPathReaderTest);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc_XPathReaderTest = builder.parse("xml/basic.xml");
        try {
            XPath xpath = new DOMXPath("\"test\" | 5");
            xpath.selectNodes(doc_XPathReaderTest);
            fail("Should have thrown XPathSyntaxException for \"test\" | 5");
        } catch (JaxenException e) {
            assertEquals("Unions are only allowed over node-sets", e.getMessage());
        }
        this.reader_XPathReaderTest = null;
    }

    public void testStringOrString_XPathReaderTest() throws ParserConfigurationException, SAXException, IOException {
        this.reader_XPathReaderTest = new XPathReader();
        this.actual_XPathReaderTest = new ConformanceXPathHandler();
        this.reader_XPathReaderTest.setXPathHandler(this.actual_XPathReaderTest);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc_XPathReaderTest = builder.parse("xml/basic.xml");
        try {
            XPath xpath = new DOMXPath("\"test\" | \"festival\"");
            xpath.selectNodes(doc_XPathReaderTest);
            fail("Should have thrown XPathSyntaxException for \"test\" | 5");
        } catch (JaxenException e) {
            assertEquals("Unions are only allowed over node-sets", e.getMessage());
        }
        this.reader_XPathReaderTest = null;
    }

    public void testUnionofNodesAndNonNodes_XPathReaderTest() throws ParserConfigurationException, SAXException, IOException {
        this.reader_XPathReaderTest = new XPathReader();
        this.actual_XPathReaderTest = new ConformanceXPathHandler();
        this.reader_XPathReaderTest.setXPathHandler(this.actual_XPathReaderTest);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc_XPathReaderTest = builder.parse("xml/basic.xml");
        try {
            XPath xpath = new DOMXPath("count(//*) | //* ");
            xpath.selectNodes(doc_XPathReaderTest);
            fail("Should have thrown XPathSyntaxException for \"count(//*) | //* ");
        } catch (JaxenException e) {
            assertEquals("Unions are only allowed over node-sets", e.getMessage());
        }
        this.reader_XPathReaderTest = null;
    }

    public void testValidAxis_XPathReaderTest() throws SAXPathException, ParserConfigurationException, SAXException, IOException {
        this.reader_XPathReaderTest = new XPathReader();
        this.actual_XPathReaderTest = new ConformanceXPathHandler();
        this.reader_XPathReaderTest.setXPathHandler(this.actual_XPathReaderTest);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc_XPathReaderTest = builder.parse("xml/basic.xml");
        reader_XPathReaderTest.parse("child::foo");
        this.reader_XPathReaderTest = null;
    }

    public void testInvalidAxis_XPathReaderTest() throws SAXPathException, ParserConfigurationException, SAXException, IOException {
        this.reader_XPathReaderTest = new XPathReader();
        this.actual_XPathReaderTest = new ConformanceXPathHandler();
        this.reader_XPathReaderTest.setXPathHandler(this.actual_XPathReaderTest);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc_XPathReaderTest = builder.parse("xml/basic.xml");
        try {
            reader_XPathReaderTest.parse("chyld::foo");
            fail("Should have thrown XPathSyntaxException");
        } catch (XPathSyntaxException ex) {
            assertNotNull(ex.getMessage());
        }
        this.reader_XPathReaderTest = null;
    }

    public void testLocationPathStartsWithVariable_XPathReaderTest() throws SAXPathException, ParserConfigurationException, SAXException, IOException {
        this.reader_XPathReaderTest = new XPathReader();
        this.actual_XPathReaderTest = new ConformanceXPathHandler();
        this.reader_XPathReaderTest.setXPathHandler(this.actual_XPathReaderTest);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc_XPathReaderTest = builder.parse("xml/basic.xml");
        reader_XPathReaderTest.parse("$variable/foo");
        this.reader_XPathReaderTest = null;
    }

    public void testLocationPathStartsWithParentheses_XPathReaderTest() throws SAXPathException, ParserConfigurationException, SAXException, IOException {
        this.reader_XPathReaderTest = new XPathReader();
        this.actual_XPathReaderTest = new ConformanceXPathHandler();
        this.reader_XPathReaderTest.setXPathHandler(this.actual_XPathReaderTest);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc_XPathReaderTest = builder.parse("xml/basic.xml");
        reader_XPathReaderTest.parse("(//x)/foo");
        this.reader_XPathReaderTest = null;
    }

    public void testNoSpaceAfterDiv_XPathReaderTest() throws JaxenException, ParserConfigurationException, SAXException, IOException {
        this.reader_XPathReaderTest = new XPathReader();
        this.actual_XPathReaderTest = new ConformanceXPathHandler();
        this.reader_XPathReaderTest.setXPathHandler(this.actual_XPathReaderTest);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc_XPathReaderTest = builder.parse("xml/basic.xml");
        XPath xpath = new DOMXPath("105 div10");
        Double result = (Double) xpath.evaluate(doc_XPathReaderTest);
        assertEquals(10.5, result.doubleValue(), 0.000001);
        this.reader_XPathReaderTest = null;
    }

    public void testNoSpaceAfterMod_XPathReaderTest() throws JaxenException, ParserConfigurationException, SAXException, IOException {
        this.reader_XPathReaderTest = new XPathReader();
        this.actual_XPathReaderTest = new ConformanceXPathHandler();
        this.reader_XPathReaderTest.setXPathHandler(this.actual_XPathReaderTest);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc_XPathReaderTest = builder.parse("xml/basic.xml");
        XPath xpath = new DOMXPath("105 mod10");
        Double result = (Double) xpath.evaluate(doc_XPathReaderTest);
        assertEquals(5, result.intValue());
        this.reader_XPathReaderTest = null;
    }

    public void testNoSpaceAfterPlus_XPathReaderTest() throws JaxenException, ParserConfigurationException, SAXException, IOException {
        this.reader_XPathReaderTest = new XPathReader();
        this.actual_XPathReaderTest = new ConformanceXPathHandler();
        this.reader_XPathReaderTest.setXPathHandler(this.actual_XPathReaderTest);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc_XPathReaderTest = builder.parse("xml/basic.xml");
        XPath xpath = new DOMXPath("105 +10");
        Double result = (Double) xpath.evaluate(doc_XPathReaderTest);
        assertEquals(115, result.intValue());
        this.reader_XPathReaderTest = null;
    }

    public void testNoSpaceAfterAnd_XPathReaderTest() throws JaxenException, ParserConfigurationException, SAXException, IOException {
        this.reader_XPathReaderTest = new XPathReader();
        this.actual_XPathReaderTest = new ConformanceXPathHandler();
        this.reader_XPathReaderTest.setXPathHandler(this.actual_XPathReaderTest);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc_XPathReaderTest = builder.parse("xml/basic.xml");
        XPath xpath = new DOMXPath("true() andfalse()");
        Boolean result = (Boolean) xpath.evaluate(doc_XPathReaderTest);
        assertFalse(result.booleanValue());
        this.reader_XPathReaderTest = null;
    }

    public void testNoSpaceAfterOr_XPathReaderTest() throws JaxenException, ParserConfigurationException, SAXException, IOException {
        this.reader_XPathReaderTest = new XPathReader();
        this.actual_XPathReaderTest = new ConformanceXPathHandler();
        this.reader_XPathReaderTest.setXPathHandler(this.actual_XPathReaderTest);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc_XPathReaderTest = builder.parse("xml/basic.xml");
        XPath xpath = new DOMXPath("true() orfalse()");
        Boolean result = (Boolean) xpath.evaluate(doc_XPathReaderTest);
        assertTrue(result.booleanValue());
        this.reader_XPathReaderTest = null;
    }

    public void testAndImmediatelyFollowedByRelativeLocationPath_XPathReaderTest() throws JaxenException, ParserConfigurationException, SAXException, IOException {
        this.reader_XPathReaderTest = new XPathReader();
        this.actual_XPathReaderTest = new ConformanceXPathHandler();
        this.reader_XPathReaderTest.setXPathHandler(this.actual_XPathReaderTest);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc_XPathReaderTest = builder.parse("xml/basic.xml");
        XPath xpath = new DOMXPath("true() andfoo");
        Boolean result = (Boolean) xpath.evaluate(doc_XPathReaderTest);
        assertTrue(result.booleanValue());
        this.reader_XPathReaderTest = null;
    }
}
