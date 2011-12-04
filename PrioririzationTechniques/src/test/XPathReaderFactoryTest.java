package test;

import junit.framework.TestCase;
import org.jaxen.saxpath.SAXPathException;
import org.jaxen.saxpath.XPathReader;
import org.jaxen.saxpath.helpers.XPathReaderFactory;

public class XPathReaderFactoryTest extends TestCase {

    public XPathReaderFactoryTest(String name) {
        super(name);
    }

    protected void tearDown() {
        System.setProperty(XPathReaderFactory.DRIVER_PROPERTY, "");
    }

    public void testDefault() throws SAXPathException {
        System.setProperty(XPathReaderFactory.DRIVER_PROPERTY, "");
        XPathReader reader = XPathReaderFactory.createReader();
        assertNotNull(reader);
    }

    public void testInvalidExplicit() {
        try {
            XPathReaderFactory.createReader("java.lang.String");
            fail("Should have thrown SAXPathException");
        } catch (org.jaxen.saxpath.SAXPathException e) {
        }
    }

    public void testValidByProperty() throws SAXPathException {
        System.setProperty(XPathReaderFactory.DRIVER_PROPERTY, "org.jaxen.test.MockXPathReader");
        XPathReader reader = XPathReaderFactory.createReader();
        assertNotNull(reader);
        assertSame(org.jaxen.test.MockXPathReader.class, reader.getClass());
    }

    public void testNonExistantExplicit() {
        try {
            XPathReaderFactory.createReader("i.am.a.class.that.does.not.Exist");
            fail("Should have thrown SAXPathException");
        } catch (org.jaxen.saxpath.SAXPathException e) {
        }
    }

    public void testInvalidByProperty() {
        System.setProperty(XPathReaderFactory.DRIVER_PROPERTY, "java.lang.String");
        try {
            XPathReaderFactory.createReader();
            fail("Should have thrown SAXPathException");
        } catch (SAXPathException e) {
            assertNotNull(e.getMessage());
        }
    }

    public void testValidExplicit() throws SAXPathException {
        XPathReader reader = XPathReaderFactory.createReader("org.jaxen.test.MockXPathReader");
        assertNotNull(reader);
        assertSame(org.jaxen.test.MockXPathReader.class, reader.getClass());
    }

    public void testNonExistantByProperty() {
        System.setProperty(XPathReaderFactory.DRIVER_PROPERTY, "i.am.a.class.that.does.not.Exist");
        try {
            XPathReaderFactory.createReader();
            fail("Should have thrown SAXPathException");
        } catch (org.jaxen.saxpath.SAXPathException e) {
        }
    }
}
