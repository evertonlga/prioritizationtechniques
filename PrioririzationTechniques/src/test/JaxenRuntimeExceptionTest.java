package test;

import java.io.PrintWriter;
import java.io.StringWriter;
import org.jaxen.JaxenException;
import org.jaxen.JaxenRuntimeException;
import junit.framework.TestCase;

public class JaxenRuntimeExceptionTest extends TestCase {

    public JaxenRuntimeExceptionTest(String name) {
        super(name);
    }

    public void testMessageIsNonNull() {
        JaxenException ex = new JaxenException("Hello");
        JaxenRuntimeException rex = new JaxenRuntimeException(ex);
        assertEquals(ex.getMessage(), rex.getMessage());
        assertEquals(ex, rex.getCause());
    }

    public void testPrintStackTrace() {
        JaxenException cause = new JaxenException("1234");
        JaxenRuntimeException ex = new JaxenRuntimeException(cause);
        StringWriter out = new StringWriter();
        PrintWriter pw = new PrintWriter(out);
        ex.printStackTrace(pw);
        pw.close();
        assertTrue(out.toString().indexOf("Caused by: org.jaxen.JaxenException") > 0);
        assertTrue(out.toString().indexOf("1234") > 0);
    }
}
