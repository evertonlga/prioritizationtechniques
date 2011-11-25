package test;

import java.util.List;
import org.jaxen.JaxenException;
import org.jaxen.Navigator;
import org.jaxen.XPath;
import org.jaxen.jdom.DocumentNavigator;
import org.jaxen.jdom.JDOMXPath;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.Namespace;
import org.jdom.input.SAXBuilder;

public class JDOMNavigatorTest extends XPathTestBase {

    public JDOMNavigatorTest(String name) {
        super(name);
    }

    private SAXBuilder builder = new SAXBuilder();

    public void testNullNamespace() throws JaxenException {
        Namespace my = Namespace.getNamespace("foo", "http://mynamespace.org/");
        Document doc = new Document();
        Element root = new Element("root", my);
        doc.setRootElement(root);
        XPath nullNamespacePath = new JDOMXPath("/root");
        List selectedNodes = nullNamespacePath.selectNodes(doc);
        assertEquals(0, selectedNodes.size());
    }

    public Navigator getNavigator() {
        return new DocumentNavigator();
    }

    public Object getDocument(String url) throws Exception {
        return this.builder.build(url);
    }
}
