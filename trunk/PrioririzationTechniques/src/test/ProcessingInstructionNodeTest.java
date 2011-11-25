package test;

import javax.xml.parsers.ParserConfigurationException;
import org.jaxen.JaxenException;
import org.jaxen.dom.DOMXPath;
import junit.framework.TestCase;

public class ProcessingInstructionNodeTest extends TestCase {

    public void testGetTextWithName() throws JaxenException, ParserConfigurationException {
        DOMXPath xpath = new DOMXPath("processing-instruction('foo')");
        String expr = xpath.getRootExpr().getText();
        assertEquals("child::processing-instruction('foo')", expr);
    }

    public void testGetTextWithPredicate() throws JaxenException, ParserConfigurationException {
        DOMXPath xpath = new DOMXPath("processing-instruction('foo')[1 = 1]");
        String expr = xpath.getRootExpr().getText();
        assertEquals("child::processing-instruction('foo')[(1.0 = 1.0)]", expr);
    }

    public void testGetText() throws JaxenException, ParserConfigurationException {
        DOMXPath xpath = new DOMXPath("processing-instruction()");
        String expr = xpath.getRootExpr().getText();
        assertEquals("child::processing-instruction()", expr);
    }
}
