package test;

import java.util.Iterator;
import java.util.NoSuchElementException;
import org.jaxen.util.SingleObjectIterator;
import junit.framework.TestCase;

public class SingleObjectIteratorTest extends TestCase {

    private Iterator iterator = new SingleObjectIterator(new Object());

    public void testRemove() {
        try {
            iterator.remove();
            fail("Removed from iterator");
        } catch (UnsupportedOperationException ex) {
        }
    }

    public void testNoInfiniteLoops() {
        iterator.next();
        try {
            iterator.next();
            fail("Iterated twice");
        } catch (NoSuchElementException ex) {
        }
    }
}
