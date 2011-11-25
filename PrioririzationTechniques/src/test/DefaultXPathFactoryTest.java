package test;

import org.jaxen.JaxenException;
import org.jaxen.expr.*;
import junit.framework.TestCase;

public class DefaultXPathFactoryTest extends TestCase {

    public void testBadAxis() throws JaxenException {
        DefaultXPathFactory factory = new DefaultXPathFactory();
        try {
            factory.createAllNodeStep(123434);
            fail("Allowed bad axis");
        } catch (JaxenException ex) {
            assertNotNull(ex.getMessage());
        }
    }
}
