package test;

import junit.framework.TestCase;
import org.jaxen.NamespaceContext;
import org.jaxen.XPath;
import org.jaxen.dom.DOMXPath;
import org.jaxen.saxpath.SAXPathException;

public class AddNamespaceTest extends TestCase {

    public AddNamespaceTest(String name) {
        super(name);
    }

    public void testDefaultContext() throws SAXPathException {
        XPath xpath = new DOMXPath("foo");
        xpath.addNamespace("cheese", "http://cheese.org");
        xpath.addNamespace("squeeze", "http://squeeze.org");
        NamespaceContext nsContext = xpath.getNamespaceContext();
        assertEquals("http://cheese.org", nsContext.translateNamespacePrefixToUri("cheese"));
        assertEquals("http://squeeze.org", nsContext.translateNamespacePrefixToUri("squeeze"));
    }
}
