package test;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import junit.framework.TestCase;
import org.jaxen.FunctionCallException;
import org.jaxen.JaxenException;
import org.jaxen.XPath;
import org.jaxen.dom.DOMXPath;
import org.w3c.dom.Document;

public class TranslateFunctionTest extends TestCase {

    private Document doc;

    protected void setUp() throws ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc = builder.newDocument();
        doc.appendChild(doc.createElement("root"));
    }

    public void testTranslateWithNonBMPChars2() throws JaxenException {
        XPath xpath = new DOMXPath("translate('abc', 'c', '\uD834\uDD00b')");
        String result = (String) xpath.evaluate(doc);
        assertEquals("ab\uD834\uDD00", result);
    }

    public void testTranslateWithMalformedSurrogatePair() throws JaxenException {
        XPath xpath = new DOMXPath("translate('abc', 'c', '\uD834X\uDD00b')')");
        try {
            xpath.evaluate(doc);
            fail("Allowed malformed surrogate pair");
        } catch (FunctionCallException ex) {
            assertNotNull(ex.getMessage());
        }
    }

    public void testTranslateStringThatContainsPrivateUseChars() throws JaxenException {
        XPath xpath = new DOMXPath("translate('ab??', '?', '?')");
        String result = (String) xpath.evaluate(doc);
        assertEquals("ab??", result);
    }

    public void testTranslateIgnoresExtraArguments() throws JaxenException {
        XPath xpath = new DOMXPath("translate('abc', 'b', 'dghf')");
        String result = (String) xpath.evaluate(doc);
        assertEquals("adc", result);
    }

    public void testTranslateWithNonBMPChars() throws JaxenException {
        XPath xpath = new DOMXPath("translate('abc', 'c', '?')");
        String result = (String) xpath.evaluate(doc);
        assertEquals("ab?", result);
    }

    public void testTranslateStringThatContainsNonBMPChars() throws JaxenException {
        XPath xpath = new DOMXPath("translate('ab?b', 'b', 'd')");
        String result = (String) xpath.evaluate(doc);
        assertEquals("ad?d", result);
    }

    public void testTranslate() throws JaxenException {
        XPath xpath = new DOMXPath("translate('abc', 'b', 'd')");
        String result = (String) xpath.evaluate(doc);
        assertEquals("adc", result);
    }

    public void testTranslateWithMissingLowSurrogate() throws JaxenException {
        XPath xpath = new DOMXPath("translate('abc', 'c', 'AB\uD834X')");
        try {
            xpath.evaluate(doc);
            fail("Allowed malformed surrogate pair");
        } catch (FunctionCallException ex) {
            assertNotNull(ex.getMessage());
        }
    }

    public void testTranslateWithExtraCharsInReplacementString() throws JaxenException {
        XPath xpath = new DOMXPath("translate('abc', 'c', 'def')");
        String result = (String) xpath.evaluate(doc);
        assertEquals("abd", result);
    }

    public void testTranslateRequiresAtMostThreeArguments() throws JaxenException {
        XPath xpath = new DOMXPath("substring-after('a', 'a', 'a', 'a')");
        try {
            xpath.selectNodes(doc);
            fail("Allowed translate function with four arguments");
        } catch (FunctionCallException ex) {
            assertNotNull(ex.getMessage());
        }
    }

    public void testTranslateNonBMPChars2() throws JaxenException {
        XPath xpath = new DOMXPath("translate('ab?b', '?', 'da')");
        String result = (String) xpath.evaluate(doc);
        assertEquals("abdb", result);
    }

    public void testTranslateFunctionRequiresAtLeastThreeArguments() throws JaxenException {
        XPath xpath = new DOMXPath("translate('a', 'b')");
        try {
            xpath.selectNodes(doc);
            fail("Allowed translate function with two arguments");
        } catch (FunctionCallException ex) {
            assertNotNull(ex.getMessage());
        }
    }

    public void testTranslateNonBMPChars() throws JaxenException {
        XPath xpath = new DOMXPath("translate('ab?b', '?', 'd')");
        String result = (String) xpath.evaluate(doc);
        assertEquals("abdb", result);
    }
}
