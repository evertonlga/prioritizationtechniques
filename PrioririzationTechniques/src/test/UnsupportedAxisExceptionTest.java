package test;

import org.jaxen.UnsupportedAxisException;
import junit.framework.TestCase;

public class UnsupportedAxisExceptionTest extends TestCase {

    public UnsupportedAxisExceptionTest(String name) {
        super(name);
    }

    public void testMessageIsNonNull() {
        UnsupportedAxisException ex = new UnsupportedAxisException("Hello");
        assertEquals("Hello", ex.getMessage());
    }
}
