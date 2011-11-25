package test;

import javax.xml.parsers.ParserConfigurationException;
import org.jaxen.JaxenException;
import org.jaxen.dom.DOMXPath;
import junit.framework.TestCase;

public class BinaryExprTest extends TestCase {

    public void testBooleanPrecedence() throws JaxenException, ParserConfigurationException {
        DOMXPath xpath1 = new DOMXPath("false() and (false() or true())");
        Boolean result1 = (Boolean) xpath1.evaluate(null);
        assertFalse(result1.booleanValue());
        DOMXPath xpath2 = new DOMXPath("false() and false() or true()");
        Boolean result2 = (Boolean) xpath2.evaluate(null);
        assertTrue(result2.booleanValue());
        String expr = xpath1.getRootExpr().getText();
        DOMXPath xpath3 = new DOMXPath(expr);
        Boolean result3 = (Boolean) xpath3.evaluate(null);
        assertEquals(expr, result1, result3);
        assertFalse(expr, result3.booleanValue());
    }
}
