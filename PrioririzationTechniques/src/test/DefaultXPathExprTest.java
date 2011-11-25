package test;

import java.util.List;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.jaxen.JaxenException;
import org.jaxen.dom.DOMXPath;
import org.jaxen.expr.Expr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import junit.framework.TestCase;

public class DefaultXPathExprTest extends TestCase {

    public void testJAXEN160ToString() throws JaxenException, ParserConfigurationException {
        DOMXPath xpath = new DOMXPath("$var1/foo");
        Expr expr = xpath.getRootExpr();
        assertEquals("[(DefaultPathExpr): [(DefaultVariableReferenceExpr): var1], [(DefaultRelativeLocationPath): [(DefaultNameStep): foo]]]", expr.toString());
    }

    public void testJAXEN160GetText() throws JaxenException, ParserConfigurationException {
        DOMXPath xpath = new DOMXPath("$var1/foo");
        Expr expr = xpath.getRootExpr();
        assertEquals("$var1/child::foo", expr.getText());
    }

    public void testJAXEN40() throws JaxenException, ParserConfigurationException {
        DOMXPath xpath = new DOMXPath("root/child1/grandchild1 | root/child2/grandchild2");
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        Document doc = factory.newDocumentBuilder().newDocument();
        Element root = doc.createElement("root");
        Element child1 = doc.createElement("child1");
        Element child2 = doc.createElement("child2");
        Element grandchild1 = doc.createElement("grandchild1");
        Element grandchild2 = doc.createElement("grandchild2");
        root.appendChild(child1);
        root.appendChild(child2);
        child1.appendChild(grandchild1);
        child2.appendChild(grandchild2);
        doc.appendChild(root);
        List results = xpath.selectNodes(doc);
        assertEquals(2, results.size());
        assertTrue(results.indexOf(grandchild1) >= 0);
        assertTrue(results.indexOf(grandchild2) >= 0);
    }
}
