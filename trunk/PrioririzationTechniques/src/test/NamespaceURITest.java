package test;

import java.io.IOException;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import junit.framework.TestCase;
import org.jaxen.FunctionCallException;
import org.jaxen.JaxenException;
import org.jaxen.XPath;
import org.jaxen.dom.DOMXPath;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.ProcessingInstruction;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

public class NamespaceURITest extends TestCase {

    public NamespaceURITest(String name) {
        super(name);
    }

    private Document doc;

    private DocumentBuilder builder;

    public void setUp() throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        builder = factory.newDocumentBuilder();
        doc = builder.parse("xml/basic.xml");
    }

    public void testNamespaceURIOfAttributeInNamespace() throws JaxenException {
        XPath xpath = new DOMXPath("namespace-uri(/*/@*)");
        Attr a = doc.createAttributeNS("http://www.w3.org/", "pre:name");
        doc.getDocumentElement().setAttributeNode(a);
        Object result = xpath.evaluate(doc);
        assertEquals("http://www.w3.org/", result);
    }

    public void testNamespaceURIOfComment() throws JaxenException {
        XPath xpath = new DOMXPath("namespace-uri(/a/comment())");
        Document document = builder.getDOMImplementation().createDocument(null, "a", null);
        document.getDocumentElement().appendChild(document.createComment("data"));
        String result = (String) xpath.evaluate(document);
        assertEquals("", result);
    }

    public void testNamespaceURIOfTextIsEmptyString() throws JaxenException {
        XPath xpath = new DOMXPath("namespace-uri(/*/text())");
        Text c = doc.createTextNode("test");
        doc.getDocumentElement().appendChild(c);
        String result = (String) xpath.evaluate(doc);
        assertEquals("", result);
    }

    public void testNamespaceURIOfEmptyNodeSetIsEmptyString() throws JaxenException {
        XPath xpath = new DOMXPath("namespace-uri(/aaa)");
        String result = (String) xpath.evaluate(doc);
        assertEquals("", result);
    }

    public void testNamespaceURINoArguments() throws JaxenException {
        XPath xpath = new DOMXPath("namespace-uri()");
        List results = xpath.selectNodes(doc);
        assertEquals("", results.get(0));
    }

    public void testNamespaceURIOfAttribute() throws JaxenException {
        XPath xpath = new DOMXPath("namespace-uri(/*/@*)");
        Attr a = doc.createAttribute("name");
        doc.getDocumentElement().setAttributeNode(a);
        Object result = xpath.evaluate(doc);
        assertEquals("", result);
    }

    public void testNamespaceURIOfProcessingInstructionIsEmptyString() throws JaxenException {
        XPath xpath = new DOMXPath("namespace-uri(/processing-instruction())");
        ProcessingInstruction pi = doc.createProcessingInstruction("target", "value");
        doc.appendChild(pi);
        String result = (String) xpath.evaluate(doc);
        assertEquals("", result);
    }

    public void testNamespaceURIRequiresAtMostOneArgument() throws JaxenException {
        XPath xpath = new DOMXPath("namespace-uri(/*, /*)");
        try {
            xpath.evaluate(doc);
            fail("Allowed namespace-uri function with no arguments");
        } catch (FunctionCallException ex) {
            assertNotNull(ex.getMessage());
        }
    }

    public void testNamespaceURIOfNamespaceIsNull() throws JaxenException {
        XPath xpath = new DOMXPath("namespace-uri(/*/namespace::node())");
        String result = (String) xpath.evaluate(doc);
        assertEquals("", result);
    }

    public void testNamespaceURIOfNumber() throws JaxenException {
        try {
            XPath xpath = new DOMXPath("namespace-uri(3)");
            xpath.selectNodes(doc);
            fail("namespace-uri of non-node-set");
        } catch (FunctionCallException e) {
            assertEquals("The argument to the namespace-uri function must be a node-set", e.getMessage());
        }
    }
}
