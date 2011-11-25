package test;

import junit.framework.TestCase;
import org.jaxen.JaxenException;
import org.jaxen.expr.iter.IterableAxis;
import org.jaxen.expr.iter.IterableSelfAxis;
import org.xml.sax.SAXException;

public class IterableAxisTest extends TestCase {

    public void testIterableSelfNamedAxis() throws JaxenException, SAXException {
        IterableAxis axis = new IterableSelfAxis(0);
        try {
            axis.namedAccessIterator(null, null, "name", "pre", "http://www.example.org/");
            fail("should not support operation");
        } catch (UnsupportedOperationException ex) {
            assertEquals("Named access unsupported", ex.getMessage());
        }
    }
}
