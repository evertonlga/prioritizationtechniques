package test;

import java.util.List;
import org.jaxen.util.SingletonList;
import junit.framework.TestCase;

public class SingletonListTest extends TestCase {

    public void testIndexOutOfBoundsException() {
        List list = new SingletonList(new Object());
        try {
            list.get(1);
            fail("Got element 1");
        } catch (IndexOutOfBoundsException ex) {
            assertNotNull(ex.getMessage());
        }
    }
}
