package test;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import junit.framework.TestCase;
import org.jaxen.BaseXPath;
import org.jaxen.FunctionCallException;
import org.jaxen.JaxenException;
import org.jaxen.XPath;
import org.jaxen.dom.DOMXPath;
import org.w3c.dom.Document;

public class SubstringAfterTest extends TestCase {

    public SubstringAfterTest(String name) {
        super(name);
    }

    private Document doc;

    public void setUp() throws ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc = builder.newDocument();
        doc.appendChild(doc.createElement("root"));
    }

    public void testSubstringAfterFunctionRequiresAtMostTwoArguments() throws JaxenException {
        BaseXPath xpath = new DOMXPath("substring-after('a', 'a', 'a')");
        try {
            xpath.selectNodes(doc);
            fail("Allowed substring-after function with three arguments");
        } catch (FunctionCallException ex) {
            assertNotNull(ex.getMessage());
        }
    }

    public void testSubstringAfterNumber() throws JaxenException {
        XPath xpath = new DOMXPath("substring-after(33, '3')");
        String result = (String) xpath.evaluate(doc);
        assertEquals("3", result);
    }

    public void testSubstringAfterNumber2() throws JaxenException {
        XPath xpath = new DOMXPath("substring-after(43, '0')");
        String result = (String) xpath.evaluate(doc);
        assertEquals("", result);
    }

    public void testSubstringAfterString4() throws JaxenException {
        XPath xpath = new DOMXPath("substring-after('superlative', 'superlative')");
        String result = (String) xpath.evaluate(doc);
        assertEquals("", result);
    }

    public void testSubstringAfterString3() throws JaxenException {
        XPath xpath = new DOMXPath("substring-after('1234567890', '456')");
        String result = (String) xpath.evaluate(doc);
        assertEquals("7890", result);
    }

    public void testSubstringAfterString2() throws JaxenException {
        XPath xpath = new DOMXPath("substring-after('1234567890', '1234567a')");
        String result = (String) xpath.evaluate(doc);
        assertEquals("", result);
    }

    public void testSubstringAfterEmptyString() throws JaxenException {
        XPath xpath = new DOMXPath("substring-after('a', '')");
        String result = (String) xpath.evaluate(doc);
        assertEquals("a", result);
    }

    public void testEmptyStringBeforeEmptyString() throws JaxenException {
        XPath xpath = new DOMXPath("substring-after('', '')");
        String result = (String) xpath.evaluate(doc);
        assertEquals("", result);
    }

    public void testEmptyStringSubstringAfterNonEmptyString() throws JaxenException {
        XPath xpath = new DOMXPath("substring-after('', 'a')");
        String result = (String) xpath.evaluate(doc);
        assertEquals("", result);
    }

    public void testSubstringAfterString() throws JaxenException {
        XPath xpath = new DOMXPath("substring-after('test', 'es')");
        String result = (String) xpath.evaluate(doc);
        assertEquals("t", result);
    }

    public void testSubstringAfterFunctionRequiresAtLeastTwoArguments() throws JaxenException {
        BaseXPath xpath = new DOMXPath("substring-after('a')");
        try {
            xpath.selectNodes(doc);
            fail("Allowed substring-after function with one argument");
        } catch (FunctionCallException ex) {
            assertNotNull(ex.getMessage());
        }
    }
}
