package test;

import junit.framework.TestCase;
import org.jaxen.JaxenException;
import org.jaxen.XPathSyntaxException;
import org.jaxen.dom.*;

public class XPathSyntaxExceptionTest extends TestCase {

    public XPathSyntaxExceptionTest(String name) {
        super(name);
    }

    public void testGetPositionMarker() throws JaxenException {
        try {
            new DOMXPath("///triple slash");
            fail("Bad parsing");
        } catch (XPathSyntaxException ex) {
            assertTrue(ex.getPositionMarker().startsWith("  "));
            assertTrue(ex.getPositionMarker().endsWith("^"));
        }
    }

    public void testGetMultilineMessage() throws JaxenException {
        try {
            new DOMXPath("///triple slash");
            fail("Bad parsing");
        } catch (XPathSyntaxException ex) {
            String message = ex.getMultilineMessage();
            assertTrue(message.indexOf("\n///triple slash\n") > 1);
            assertTrue(message.endsWith("^"));
        }
    }

    public void testGetXPath() throws JaxenException {
        try {
            new DOMXPath("///triple slash");
            fail("Bad parsing");
        } catch (XPathSyntaxException ex) {
            assertEquals("///triple slash", ex.getXPath());
        }
    }
}
