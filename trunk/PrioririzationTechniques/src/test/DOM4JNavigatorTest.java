package test;

import java.util.Iterator;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.io.SAXReader;
import org.jaxen.FunctionCallException;
import org.jaxen.JaxenException;
import org.jaxen.Navigator;
import org.jaxen.UnsupportedAxisException;
import org.jaxen.XPath;
import org.jaxen.dom4j.DocumentNavigator;
import org.jaxen.dom4j.Dom4jXPath;

public class DOM4JNavigatorTest extends XPathTestBase {

    public DOM4JNavigatorTest(String name) {
        super(name);
        this.reader = new SAXReader();
        this.reader.setMergeAdjacentText(true);
    }

    private SAXReader reader;

    public void testNullPointerException() throws JaxenException {
        Document doc = DocumentHelper.createDocument();
        XPath xpath = new Dom4jXPath("/foo");
        xpath.selectSingleNode(doc);
    }

    /**
     * reported as JAXEN-104.
     * @throws FunctionCallException
     * @throws UnsupportedAxisException
     */
    public void testConcurrentModification() throws FunctionCallException, UnsupportedAxisException {
        Navigator nav = new DocumentNavigator();
        Object document = nav.getDocument("xml/testNamespaces.xml");
        Iterator descendantOrSelfAxisIterator = nav.getDescendantOrSelfAxisIterator(document);
        while (descendantOrSelfAxisIterator.hasNext()) {
            Object node = descendantOrSelfAxisIterator.next();
            Iterator namespaceAxisIterator = nav.getNamespaceAxisIterator(node);
            while (namespaceAxisIterator.hasNext()) {
                namespaceAxisIterator.next();
            }
        }
    }

    public Object getDocument(String url) throws Exception {
        return reader.read(url);
    }

    public Navigator getNavigator() {
        return new DocumentNavigator();
    }
}
