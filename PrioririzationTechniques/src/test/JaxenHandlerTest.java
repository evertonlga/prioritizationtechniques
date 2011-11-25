package test;

import junit.framework.TestCase;
import org.jaxen.JaxenHandler;
import org.jaxen.expr.DefaultXPathFactory;
import org.jaxen.expr.XPathExpr;
import org.jaxen.saxpath.SAXPathException;
import org.jaxen.saxpath.XPathReader;
import org.jaxen.saxpath.XPathSyntaxException;
import org.jaxen.saxpath.helpers.XPathReaderFactory;

public class JaxenHandlerTest extends TestCase {

    public JaxenHandlerTest(String name) {
        super(name);
    }

    private String[] paths = { "foo[.='bar']", "foo[.!='bar']", "/", "*", "//foo", "/*", "/.", "/foo[/bar[/baz]]", "/foo/bar/baz[(1 or 2) + 3 * 4 + 8 and 9]", "/foo/bar/baz", ".[1]", "self::node()", ".", "count(/)", "foo[1]", "/baz[(1 or 2) + 3 * 4 + 8 and 9]", "foo/bar[/baz[(1 or 2) - 3 mod 4 + 8 and 9 div 8]]", "foo/bar/yeah:baz[a/b/c and toast]", "/foo/bar[../x='123']", "/foo[@bar='1234']", "foo|bar", "/foo|/bar[@id='1234']", "count(//author/attribute::*)", "$author", "10 + $foo", "10 + (count(descendant::author) * 5)", "10 + count(descendant::author) * 5", "2 + (2 * 5)", "sum(count(//author), 5)", "sum(count(//author),count(//author/attribute::*))", "12 + sum(count(//author),count(//author/attribute::*)) div 2", "text()[.='foo']", "/*/*[@id='123']", "/child::node()/child::node()[@id='_13563275']", "$foo:bar", "//foo:bar", "/foo/bar[@a='1' and @c!='2']" };

    private String[] bogusPaths = { "//:p", "/foo/bar/", "12 + sum(count(//author),count(//author/attribute::*)) / 2", "id()/2", "+" };

    public void testBogusPaths() throws SAXPathException {
        XPathReader reader = XPathReaderFactory.createReader();
        JaxenHandler handler = new JaxenHandler();
        handler.setXPathFactory(new DefaultXPathFactory());
        reader.setXPathHandler(handler);
        for (int i = 0; i < bogusPaths.length; i++) {
            String path = bogusPaths[i];
            try {
                reader.parse(path);
                XPathExpr xpath = handler.getXPathExpr(false);
                fail("Parsed bogus path as: " + xpath);
            } catch (XPathSyntaxException e) {
            }
        }
    }

    public void testValidPaths() {
        String path = null;
        try {
            XPathReader reader = XPathReaderFactory.createReader();
            JaxenHandler handler = new JaxenHandler();
            handler.setXPathFactory(new DefaultXPathFactory());
            reader.setXPathHandler(handler);
            for (int i = 0; i < paths.length; i++) {
                path = paths[i];
                reader.parse(path);
                handler.getXPathExpr(false);
                handler.getXPathExpr();
            }
        } catch (Exception e) {
            e.printStackTrace();
            fail(path + " -> " + e.getMessage());
        }
    }
}
