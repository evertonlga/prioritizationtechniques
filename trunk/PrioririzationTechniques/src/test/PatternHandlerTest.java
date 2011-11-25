package test;

import junit.framework.TestCase;
import org.jaxen.JaxenException;
import org.jaxen.pattern.Pattern;
import org.jaxen.pattern.PatternParser;
import org.jaxen.saxpath.SAXPathException;
import org.jaxen.saxpath.XPathSyntaxException;

public class PatternHandlerTest extends TestCase {

    public PatternHandlerTest(String name) {
        super(name);
    }

    String[] paths = { "foo", "*", "/", "foo/bar", "foo//bar", "/*/foo", "*[@name]", "foo/bar[1]", "foo[bar=\"contents\"]", "foo[bar='contents']", "foo|bar", "foo/title | bar/title | xyz/title", "/foo//*", "foo/text()", "foo/@*" };

    String[] bogusPaths = {};

    String[] ignore_bogusPaths = { "/foo/bar/", "12 + sum(count(//author),count(//author/attribute::*)) / 2", "id()/2", "+" };

    public void testValidPaths() throws JaxenException, SAXPathException {
        for (int i = 0; i < paths.length; i++) {
            String path = paths[i];
            PatternParser.parse(path);
        }
    }

    public void testBogusPaths() throws JaxenException, SAXPathException {
        for (int i = 0; i < bogusPaths.length; i++) {
            String path = bogusPaths[i];
            try {
                Pattern pattern = PatternParser.parse(path);
                fail("Parsed bogus path as: " + pattern);
            } catch (XPathSyntaxException e) {
            }
        }
    }
}
