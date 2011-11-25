package test;

import java.io.PrintWriter;
import java.io.StringWriter;
import org.jaxen.saxpath.SAXPathException;
import junit.framework.TestCase;

public class SAXPathExceptionTest extends TestCase {

    public SAXPathExceptionTest(String name) {
        super(name);
    }

    public void testMessageIsNonNull() {
        SAXPathException ex = new SAXPathException("Hello");
        assertEquals("Hello", ex.getMessage());
    }

    public void testPrintStackTrace() {
        StringIndexOutOfBoundsException cause = new StringIndexOutOfBoundsException("1234");
        SAXPathException ex = new SAXPathException(cause);
        StringWriter out = new StringWriter();
        PrintWriter pw = new PrintWriter(out);
        ex.printStackTrace(pw);
        pw.close();
        assertTrue(out.toString().indexOf("Caused by: java.lang.StringIndexOutOfBoundsException") > 0);
        assertTrue(out.toString().indexOf("1234") > 0);
    }
}
