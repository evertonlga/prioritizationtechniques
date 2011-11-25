package test;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.textui.TestRunner;
import org.jaxen.JaxenException;
import org.jaxen.pattern.Pattern;
import org.jaxen.pattern.PatternParser;
import org.jaxen.saxpath.SAXPathException;
import org.jaxen.saxpath.helpers.XPathReaderFactory;

public class PriorityTest extends TestCase {

    public PriorityTest(String name) {
        super(name);
    }

    public void setUp() {
        System.setProperty(XPathReaderFactory.DRIVER_PROPERTY, "");
    }

    public static Test suite() {
        return new TestSuite(PriorityTest.class);
    }

    public void testNameNode() throws Exception {
        testPriority("foo", 0, Pattern.ELEMENT_NODE);
    }

    public void testURI() throws Exception {
        testPriority("foo:*", -0.25, Pattern.ELEMENT_NODE);
    }

    public void testNodeType() throws Exception {
        testPriority("text()", -0.5, Pattern.TEXT_NODE);
    }

    public void testDocumentNode() throws Exception {
        testPriority("/", -0.5, Pattern.DOCUMENT_NODE);
    }

    public void testAnyNode() throws Exception {
        testPriority("*", -0.5, Pattern.ELEMENT_NODE);
    }

    public void testAttribute() throws Exception {
        testPriority("@*", -0.5, Pattern.ATTRIBUTE_NODE);
    }

    protected void testPriority(String expr, double priority, short nodeType) throws JaxenException, SAXPathException {
        Pattern pattern = PatternParser.parse(expr);
        double d = pattern.getPriority();
        short nt = pattern.getMatchType();
        assertEquals("expr: " + expr, new Double(priority), new Double(d));
        assertEquals("nodeType: " + expr, nodeType, nt);
    }

    public void testFilter() throws Exception {
        testPriority("foo[@id='123']", 0.5, Pattern.ELEMENT_NODE);
    }

    public void testQNameNode() throws Exception {
        testPriority("foo:bar", 0, Pattern.ELEMENT_NODE);
    }

    public static void main(String[] args) {
        TestRunner.run(suite());
    }
}
