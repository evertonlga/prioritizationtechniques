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

public class NameTest extends TestCase {

    public NameTest(String name) {
        super(name);
    }

    private Document doc;

    public void setUp() throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc = builder.parse("xml/basic.xml");
    }

    public void testNameNoArguments() {
        try {
            XPath xpath = new DOMXPath("name()");
            List results = xpath.selectNodes(doc);
            assertEquals("", results.get(0));
        } catch (Exception e) {
            e.printStackTrace();
            fail(e.getMessage());
        }
    }

    public void testNameOfTextIsEmptyString() throws JaxenException {
        XPath xpath = new DOMXPath("name(/*/text())");
        Text c = doc.createTextNode("test");
        doc.getDocumentElement().appendChild(c);
        String result = (String) xpath.evaluate(doc);
        assertEquals("", result);
    }

    public void testNameAllowsNoArguments() throws JaxenException {
        XPath xpath = new DOMXPath("name()");
        String result = (String) xpath.evaluate(doc.getDocumentElement());
        assertEquals("foo", result);
    }

    public void testNameOfProcessingInstructionIsTarget() throws JaxenException {
        XPath xpath = new DOMXPath("name(/processing-instruction())");
        ProcessingInstruction pi = doc.createProcessingInstruction("target", "value");
        doc.appendChild(pi);
        String result = (String) xpath.evaluate(doc);
        assertEquals("target", result);
    }

    public void testNameOfCommentIsEmptyString() throws JaxenException {
        XPath xpath = new DOMXPath("name(/comment())");
        Comment c = doc.createComment("test");
        doc.appendChild(c);
        String result = (String) xpath.evaluate(doc);
        assertEquals("", result);
    }

    public void testNameOfNumber() throws JaxenException {
        try {
            XPath xpath = new DOMXPath("name(3)");
            xpath.selectNodes(doc);
            fail("name of non-node-set");
        } catch (FunctionCallException e) {
            assertEquals("The argument to the name function must be a node-set", e.getMessage());
        }
    }

    public void testNameOfNamespaceIsPrefix() throws JaxenException {
        XPath xpath = new DOMXPath("name(/*/namespace::node())");
        String result = (String) xpath.evaluate(doc);
        assertEquals("xml", result);
    }

    public void testNameWithTwoArguments() throws JaxenException {
        try {
            XPath xpath = new DOMXPath("name(/*, //*)");
            xpath.selectNodes(doc);
            fail("name with two arguments");
        } catch (FunctionCallException e) {
            assertEquals("name() requires zero or one argument.", e.getMessage());
        }
    }

    public void testNameOfAttribute() throws JaxenException {
        XPath xpath = new DOMXPath("name(/*/@*)");
        Attr a = doc.createAttribute("name");
        doc.getDocumentElement().setAttributeNode(a);
        String result = (String) xpath.evaluate(doc);
        assertEquals("name", result);
    }
}
