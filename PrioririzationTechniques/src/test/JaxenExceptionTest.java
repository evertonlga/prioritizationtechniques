package test;

import java.io.PrintWriter;
import java.io.StringWriter;
import org.jaxen.JaxenException;
import junit.framework.TestCase;

public class JaxenExceptionTest extends TestCase {

    public JaxenExceptionTest(String name) {
        super(name);
    }

    public void testMessageIsNonNull() {
        JaxenException ex = new JaxenException("Hello");
        assertEquals("Hello", ex.getMessage());
    }

    public void testPrintStackTrace() {
        StringIndexOutOfBoundsException cause = new StringIndexOutOfBoundsException("1234");
        JaxenException ex = new JaxenException(cause);
        StringWriter out = new StringWriter();
        PrintWriter pw = new PrintWriter(out);
        ex.printStackTrace(pw);
        pw.close();
        String trace = out.toString();
        assertEquals(-1, trace.indexOf("Root cause:"));
        assertTrue(trace.indexOf("Caused by: java.lang.StringIndexOutOfBoundsException") > 0);
        assertTrue(trace.indexOf("1234") > 0);
    }
}
