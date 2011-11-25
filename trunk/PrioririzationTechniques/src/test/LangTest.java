package test;

import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import junit.framework.TestCase;
import org.jaxen.BaseXPath;
import org.jaxen.FunctionCallException;
import org.jaxen.JaxenException;
import org.jaxen.dom.DOMXPath;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class LangTest extends TestCase {

    public LangTest(String name) {
        super(name);
    }

    private Document doc;

    private DocumentBuilder builder;

    public void setUp() throws ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        builder = factory.newDocumentBuilder();
        doc = builder.newDocument();
    }

    public void testLangFunction() throws JaxenException {
        BaseXPath xpath = new DOMXPath("//*[lang('en')]");
        Element a = doc.createElementNS("", "a");
        Element b = doc.createElementNS("", "b");
        b.setAttributeNS("http://www.w3.org/XML/1998/namespace", "xml:lang", "en");
        doc.appendChild(a);
        a.appendChild(b);
        Element x2 = doc.createElementNS("", "x");
        Element x3 = doc.createElementNS("", "x");
        Element x4 = doc.createElementNS("", "x");
        a.appendChild(x4);
        b.appendChild(x2);
        b.appendChild(x3);
        x2.appendChild(doc.createTextNode("2"));
        x3.appendChild(doc.createTextNode("3"));
        x4.appendChild(doc.createTextNode("4"));
        List result = xpath.selectNodes(doc);
        assertEquals(3, result.size());
        assertEquals(b, result.get(0));
        assertEquals(x2, result.get(1));
        assertEquals(x3, result.get(2));
    }

    public void testLangFunctionAppliedToDocument() throws JaxenException {
        BaseXPath xpath = new DOMXPath("lang('fr')");
        Element a = doc.createElementNS("", "a");
        Element b = doc.createElementNS("", "b");
        b.setAttributeNS("http://www.w3.org/XML/1998/namespace", "xml:lang", "fr-CA");
        doc.appendChild(a);
        a.appendChild(b);
        Element x2 = doc.createElementNS("", "x");
        Element x3 = doc.createElementNS("", "x");
        Element x4 = doc.createElementNS("", "x");
        a.appendChild(x4);
        b.appendChild(x2);
        b.appendChild(x3);
        x2.appendChild(doc.createTextNode("fr"));
        x3.appendChild(doc.createTextNode("3"));
        x4.appendChild(doc.createTextNode("4"));
        Boolean result = (Boolean) xpath.evaluate(doc);
        assertEquals(Boolean.FALSE, result);
    }

    public void testLangFunctionSelectsNonEmptyNodeSet() throws JaxenException {
        BaseXPath xpath = new DOMXPath("//*[lang(x)]");
        Element a = doc.createElementNS("", "a");
        Element b = doc.createElementNS("", "b");
        b.setAttributeNS("http://www.w3.org/XML/1998/namespace", "xml:lang", "fr-CA");
        doc.appendChild(a);
        a.appendChild(b);
        Element x2 = doc.createElementNS("", "x");
        Element x3 = doc.createElementNS("", "x");
        Element x4 = doc.createElementNS("", "x");
        a.appendChild(x4);
        b.appendChild(x2);
        b.appendChild(x3);
        x2.appendChild(doc.createTextNode("fr"));
        x3.appendChild(doc.createTextNode("3"));
        x4.appendChild(doc.createTextNode("4"));
        List result = xpath.selectNodes(doc);
        assertEquals(1, result.size());
        assertEquals(b, result.get(0));
    }

    public void testLangFunctionSelectsNumber() throws JaxenException {
        BaseXPath xpath = new DOMXPath("//*[lang(3)]");
        Element a = doc.createElementNS("", "a");
        Element b = doc.createElementNS("", "b");
        b.setAttributeNS("http://www.w3.org/XML/1998/namespace", "xml:lang", "fr-CA");
        doc.appendChild(a);
        a.appendChild(b);
        Element x2 = doc.createElementNS("", "x");
        Element x3 = doc.createElementNS("", "x");
        Element x4 = doc.createElementNS("", "x");
        a.appendChild(x4);
        b.appendChild(x2);
        b.appendChild(x3);
        x2.appendChild(doc.createTextNode("2"));
        x3.appendChild(doc.createTextNode("3"));
        x4.appendChild(doc.createTextNode("4"));
        List result = xpath.selectNodes(doc);
        assertEquals(0, result.size());
    }

    public void testLangFunctionSelectsNothing() throws JaxenException {
        BaseXPath xpath = new DOMXPath("//*[lang('fr')]");
        Element a = doc.createElementNS("", "a");
        Element b = doc.createElementNS("", "b");
        b.setAttributeNS("http://www.w3.org/XML/1998/namespace", "xml:lang", "en");
        doc.appendChild(a);
        a.appendChild(b);
        Element x2 = doc.createElementNS("", "x");
        Element x3 = doc.createElementNS("", "x");
        Element x4 = doc.createElementNS("", "x");
        a.appendChild(x4);
        b.appendChild(x2);
        b.appendChild(x3);
        x2.appendChild(doc.createTextNode("2"));
        x3.appendChild(doc.createTextNode("3"));
        x4.appendChild(doc.createTextNode("4"));
        List result = xpath.selectNodes(doc);
        assertEquals(0, result.size());
    }

    public void testLangFunctionAppliedToNonElement() throws JaxenException {
        BaseXPath xpath = new DOMXPath("//text()[lang('fr')]");
        Element a = doc.createElementNS("", "a");
        Element b = doc.createElementNS("", "b");
        b.setAttributeNS("http://www.w3.org/XML/1998/namespace", "xml:lang", "fr-CA");
        doc.appendChild(a);
        a.appendChild(b);
        Element x2 = doc.createElementNS("", "x");
        Element x3 = doc.createElementNS("", "x");
        Element x4 = doc.createElementNS("", "x");
        a.appendChild(x4);
        b.appendChild(x2);
        b.appendChild(x3);
        x2.appendChild(doc.createTextNode("fr"));
        x3.appendChild(doc.createTextNode("3"));
        x4.appendChild(doc.createTextNode("4"));
        List result = xpath.selectNodes(doc);
        assertEquals(2, result.size());
        assertEquals(x2.getFirstChild(), result.get(0));
        assertEquals(x3.getFirstChild(), result.get(1));
    }

    public void testLangFunctionRequiresOneArgument() throws JaxenException {
        try {
            BaseXPath xpath = new DOMXPath("lang()");
            org.w3c.dom.Element a = doc.createElementNS("", "a");
            doc.appendChild(a);
            xpath.selectNodes(doc);
            fail("Allowed empty lang() function");
        } catch (FunctionCallException success) {
            assertNotNull(success.getMessage());
        }
    }

    public void testLangFunctionRequiresAtMostOneArgument() throws JaxenException {
        try {
            BaseXPath xpath = new DOMXPath("lang('en', 'fr')");
            org.w3c.dom.Element a = doc.createElementNS("", "a");
            doc.appendChild(a);
            xpath.selectNodes(doc);
            fail("Allowed empty lang() function");
        } catch (FunctionCallException success) {
            assertNotNull(success.getMessage());
        }
    }

    public void testLangFunctionSelectsEmptyNodeSet() throws JaxenException {
        BaseXPath xpath = new DOMXPath("//*[lang(d)]");
        Element a = doc.createElementNS("", "a");
        Element b = doc.createElementNS("", "b");
        b.setAttributeNS("http://www.w3.org/XML/1998/namespace", "xml:lang", "fr-CA");
        doc.appendChild(a);
        a.appendChild(b);
        Element x2 = doc.createElementNS("", "x");
        Element x3 = doc.createElementNS("", "x");
        Element x4 = doc.createElementNS("", "x");
        a.appendChild(x4);
        b.appendChild(x2);
        b.appendChild(x3);
        x2.appendChild(doc.createTextNode("2"));
        x3.appendChild(doc.createTextNode("3"));
        x4.appendChild(doc.createTextNode("4"));
        List result = xpath.selectNodes(doc);
        assertEquals(0, result.size());
    }

    public void testLangFunctionSelectsSubcode() throws JaxenException {
        BaseXPath xpath = new DOMXPath("//*[lang('fr')]");
        Element a = doc.createElementNS("", "a");
        Element b = doc.createElementNS("", "b");
        b.setAttributeNS("http://www.w3.org/XML/1998/namespace", "xml:lang", "fr-CA");
        doc.appendChild(a);
        a.appendChild(b);
        Element x2 = doc.createElementNS("", "x");
        Element x3 = doc.createElementNS("", "x");
        Element x4 = doc.createElementNS("", "x");
        a.appendChild(x4);
        b.appendChild(x2);
        b.appendChild(x3);
        x2.appendChild(doc.createTextNode("2"));
        x3.appendChild(doc.createTextNode("3"));
        x4.appendChild(doc.createTextNode("4"));
        List result = xpath.selectNodes(doc);
        assertEquals(3, result.size());
        assertEquals(b, result.get(0));
        assertEquals(x2, result.get(1));
        assertEquals(x3, result.get(2));
    }

    public void testHyphenRequiredAtEnd() throws JaxenException {
        BaseXPath xpath = new DOMXPath("//*[lang('f')]");
        Element a = doc.createElementNS("", "a");
        Element b = doc.createElementNS("", "b");
        b.setAttributeNS("http://www.w3.org/XML/1998/namespace", "xml:lang", "fr-CA");
        doc.appendChild(a);
        a.appendChild(b);
        Element x2 = doc.createElementNS("", "x");
        Element x3 = doc.createElementNS("", "x");
        Element x4 = doc.createElementNS("", "x");
        a.appendChild(x4);
        b.appendChild(x2);
        b.appendChild(x3);
        x2.appendChild(doc.createTextNode("2"));
        x3.appendChild(doc.createTextNode("3"));
        x4.appendChild(doc.createTextNode("4"));
        List result = xpath.selectNodes(doc);
        assertEquals(0, result.size());
    }
}
