package test;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.jaxen.JaxenException;
import org.jaxen.dom.DOMXPath;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import junit.framework.TestCase;

public class ModTest extends TestCase {

    public void testModofNonIntegers() throws JaxenException, ParserConfigurationException {
        DOMXPath xpath = new DOMXPath("5.5 mod 2.5");
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        Document doc = factory.newDocumentBuilder().newDocument();
        Element root = doc.createElement("root");
        doc.appendChild(root);
        Double result = (Double) xpath.evaluate(doc);
        assertEquals(0.5, result.doubleValue(), 0.000001);
    }
}
