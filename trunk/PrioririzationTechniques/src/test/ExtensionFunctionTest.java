package test;

import java.util.Iterator;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import junit.framework.TestCase;
import org.jaxen.*;
import org.jaxen.dom.DOMXPath;
import org.jaxen.function.NumberFunction;
import org.jaxen.saxpath.SAXPathException;
import org.w3c.dom.Document;

public class ExtensionFunctionTest extends TestCase {

    public ExtensionFunctionTest(String name) {
        super(name);
    }

    private Document doc;

    public void setUp() throws ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc = builder.newDocument();
    }

    public void testJaxen47() throws SAXPathException {
        org.jaxen.dom.DocumentNavigator.getInstance().parseXPath("a:b()");
    }

    public void testRegisterExtensionFunction() throws JaxenException {
        SimpleFunctionContext fc = new XPathFunctionContext(false);
        fc.registerFunction("http://exslt.org/math", "min", new MinFunction());
        SimpleNamespaceContext nc = new SimpleNamespaceContext();
        nc.addNamespace("math", "http://exslt.org/math");
        BaseXPath xpath = new DOMXPath("math:min(//x)");
        xpath.setFunctionContext(fc);
        xpath.setNamespaceContext(nc);
        org.w3c.dom.Element a = doc.createElementNS("", "a");
        org.w3c.dom.Element b = doc.createElementNS("", "b");
        doc.appendChild(a);
        a.appendChild(b);
        org.w3c.dom.Element x2 = doc.createElementNS("", "x");
        org.w3c.dom.Element x3 = doc.createElementNS("", "x");
        org.w3c.dom.Element x4 = doc.createElementNS("", "x");
        a.appendChild(x4);
        b.appendChild(x2);
        b.appendChild(x3);
        x2.appendChild(doc.createTextNode("2"));
        x3.appendChild(doc.createTextNode("3"));
        x4.appendChild(doc.createTextNode("4"));
        Double result = (Double) xpath.evaluate(doc);
        assertEquals(new Double(2), result);
    }

    class MinFunction implements Function {

        public Object call(Context context, List args) {
            if (args.isEmpty()) return new Double(Double.NaN);
            Navigator navigator = context.getNavigator();
            double min = Double.MAX_VALUE;
            Iterator iterator = args.iterator();
            while (iterator.hasNext()) {
                double next = NumberFunction.evaluate(iterator.next(), navigator).doubleValue();
                min = Math.min(min, next);
            }
            return new Double(min);
        }
    }
}
