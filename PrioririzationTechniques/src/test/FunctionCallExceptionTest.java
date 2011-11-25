package test;

import org.jaxen.FunctionCallException;
import org.jaxen.JaxenException;
import junit.framework.TestCase;

public class FunctionCallExceptionTest extends TestCase {

    public FunctionCallExceptionTest(String name) {
        super(name);
    }

    public void testMessageIsNonNull() {
        JaxenException ex = new JaxenException("Hello");
        FunctionCallException rex = new FunctionCallException(ex);
        assertEquals(ex.getMessage(), rex.getMessage());
        assertEquals(ex, rex.getCause());
    }

    public void testMessageIsSaved() {
        JaxenException ex = new JaxenException("Hello");
        FunctionCallException rex = new FunctionCallException("Goodbye", ex);
        assertEquals("Goodbye", rex.getMessage());
        assertEquals(ex, rex.getCause());
    }
}
