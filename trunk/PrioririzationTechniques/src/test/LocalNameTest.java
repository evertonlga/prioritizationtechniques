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
import org.w3c.dom.Comment;
import org.w3c.dom.Document;
import org.w3c.dom.ProcessingInstruction;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

public class LocalNameTest extends TestCase {

    public LocalNameTest(String name) {
        super(name);
    }

    private Document doc;

    public void setUp() throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc = builder.parse("xml/basic.xml");
    }

    public void testLocalNameOfAttribute() throws JaxenException {
        XPath xpath = new DOMXPath("local-name(/*/@*)");
        Attr a = doc.createAttribute("name");
        doc.getDocumentElement().setAttributeNode(a);
        String result = (String) xpath.evaluate(doc);
        assertEquals("name", result);
    }

    public void testLocalNameOfTextIsEmptyString() throws JaxenException {
        XPath xpath = new DOMXPath("local-name(/*/text())");
        Text c = doc.createTextNode("test");
        doc.getDocumentElement().appendChild(c);
        String result = (String) xpath.evaluate(doc);
        assertEquals("", result);
    }

    public void testLocalNameAllowsNoArguments() throws JaxenException {
        XPath xpath = new DOMXPath("local-name()");
        String result = (String) xpath.evaluate(doc.getDocumentElement());
        assertEquals("foo", result);
    }

    public void testLocalNameNoArguments() {
        try {
            XPath xpath = new DOMXPath("local-name()");
            List results = xpath.selectNodes(doc);
            assertEquals("", results.get(0));
        } catch (Exception e) {
            e.printStackTrace();
            fail(e.getMessage());
        }
    }

    public void testLocalNameOfProcessingInstructionIsTarget() throws JaxenException {
        XPath xpath = new DOMXPath("local-name(/processing-instruction())");
        ProcessingInstruction pi = doc.createProcessingInstruction("target", "value");
        doc.appendChild(pi);
        String result = (String) xpath.evaluate(doc);
        assertEquals("target", result);
    }

    public void testLocalNameOfCommentIsEmptyString() throws JaxenException {
        XPath xpath = new DOMXPath("local-name(/comment())");
        Comment c = doc.createComment("test");
        doc.appendChild(c);
        String result = (String) xpath.evaluate(doc);
        assertEquals("", result);
    }

    public void testLocalNameOfNamespaceIsPrefix() throws JaxenException {
        XPath xpath = new DOMXPath("local-name(/*/namespace::node())");
        String result = (String) xpath.evaluate(doc);
        assertEquals("xml", result);
    }

    public void testLocalNameOfEmptyNodeSetIsEmptyString() throws JaxenException {
        XPath xpath = new DOMXPath("local-name(/aaa)");
        String result = (String) xpath.evaluate(doc);
        assertEquals("", result);
    }

    public void testLocalNameWithTwoArguments() throws JaxenException {
        try {
            XPath xpath = new DOMXPath("local-name(/*, //*)");
            xpath.selectNodes(doc);
            fail("local-name with two arguments");
        } catch (FunctionCallException e) {
            assertEquals("local-name() requires zero or one argument.", e.getMessage());
        }
    }

    public void testLocalNameOfNumber() throws JaxenException {
        try {
            XPath xpath = new DOMXPath("local-name(3)");
            xpath.selectNodes(doc);
            fail("local-name of non-node-set");
        } catch (FunctionCallException e) {
            assertEquals("The argument to the local-name function must be a node-set", e.getMessage());
        }
    }
}
