package test;

import javax.xml.parsers.ParserConfigurationException;
import org.jaxen.BaseXPath;
import org.jaxen.JaxenException;
import org.jaxen.dom.DOMXPath;
import junit.framework.TestCase;

public class LiteralExprTest extends TestCase {

    public void testJaxen177() throws JaxenException, ParserConfigurationException {
        BaseXPath baseXPath = new BaseXPath("//Name[@Attribute = '\"']", null);
        BaseXPath baseXPath2 = new BaseXPath(baseXPath.getRootExpr().getText(), null);
        assertEquals("/descendant-or-self::node()/child::Name[(attribute::Attribute = '\"')]", baseXPath2.getRootExpr().getText());
    }

    public void testStringLiteralContainsDoubleQuote() throws JaxenException, ParserConfigurationException {
        DOMXPath xpath = new DOMXPath("'\"'");
        String expr = xpath.getRootExpr().getText();
        assertEquals("'\"'", expr);
    }

    public void testStringLiteralContainsSingleQuote() throws JaxenException, ParserConfigurationException {
        DOMXPath xpath = new DOMXPath("\"'\"");
        String expr = xpath.getRootExpr().getText();
        assertEquals("\"'\"", expr);
    }
}
