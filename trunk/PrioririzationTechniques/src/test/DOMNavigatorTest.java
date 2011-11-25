package test;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.jaxen.Navigator;
import org.jaxen.dom.DocumentNavigator;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class DOMNavigatorTest extends XPathTestBase {

    public DOMNavigatorTest(String name) {
        super(name);
    }

    private DocumentBuilder builder;

    protected void setUp() throws Exception {
        super.setUp();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        builder = factory.newDocumentBuilder();
    }

    public Object getDocument(String url) throws Exception {
        return builder.parse(url);
    }

    public void testGetAttributeQNameOnElement() {
        Navigator nav = getNavigator();
        Document doc = builder.newDocument();
        Element a = doc.createElement("a");
        String qname = nav.getAttributeQName(a);
        assertNull(qname);
    }

    public void testGetAttributeLocalNameOnElement() {
        Navigator nav = getNavigator();
        Document doc = builder.newDocument();
        Element a = doc.createElementNS("http://www.ex.com", "pre:a");
        String name = nav.getAttributeName(a);
        assertNull(name);
    }

    public void testGetElementLocalNameOnAttr() {
        Navigator nav = getNavigator();
        Document doc = builder.newDocument();
        Attr a = doc.createAttributeNS("http://www.ex.com", "a");
        String name = nav.getElementName(a);
        assertNull(name);
    }

    public Navigator getNavigator() {
        return new DocumentNavigator();
    }

    public void testGetElementNamespaceURIOnAttr() {
        Navigator nav = getNavigator();
        Document doc = builder.newDocument();
        Attr a = doc.createAttributeNS("http://www.element.org/", "a");
        String qname = nav.getElementNamespaceUri(a);
        assertNull(qname);
    }

    public void testGetTargetOfNonPI() {
        Navigator nav = getNavigator();
        Document doc = builder.newDocument();
        Attr a = doc.createAttributeNS("http://www.element.org/", "a");
        try {
            nav.getProcessingInstructionTarget(a);
            fail("got target of non processing instruction");
        } catch (ClassCastException ex) {
            assertNotNull(ex.getMessage());
        }
    }

    public void testGetDataOfNonPI() {
        Navigator nav = getNavigator();
        Document doc = builder.newDocument();
        Attr a = doc.createAttributeNS("http://www.element.org/", "a");
        try {
            nav.getProcessingInstructionData(a);
            fail("got data of non processing instruction");
        } catch (ClassCastException ex) {
            assertNotNull(ex.getMessage());
        }
    }

    public void testGetElementQNameOnAttr() {
        Navigator nav = getNavigator();
        Document doc = builder.newDocument();
        Attr a = doc.createAttribute("a");
        String qname = nav.getElementQName(a);
        assertNull(qname);
    }

    public void testGetAttributeNamespaceURIOnElement() {
        Navigator nav = getNavigator();
        Document doc = builder.newDocument();
        Element a = doc.createElementNS("http://www.example.org/", "a");
        String qname = nav.getAttributeNamespaceUri(a);
        assertNull(qname);
    }
}
