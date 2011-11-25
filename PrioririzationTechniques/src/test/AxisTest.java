package test;

import org.jaxen.JaxenRuntimeException;
import org.jaxen.saxpath.Axis;
import junit.framework.TestCase;

public class AxisTest extends TestCase {

    public AxisTest(String name) {
        super(name);
    }

    public void testIllegalAxisNumber() {
        try {
            Axis.lookup(-10009);
            fail("Looked up negative number");
        } catch (JaxenRuntimeException ex) {
            assertEquals("Illegal Axis Number", ex.getMessage());
        }
    }
}
