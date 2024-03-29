package test;

import junit.framework.TestCase;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.StringReader;
import java.util.Iterator;
import java.util.List;
import org.jaxen.JaxenException;
import org.jaxen.XPath;
import org.jaxen.dom.DOMXPath;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

public class DOMXPathTest extends TestCase {

    public DOMXPathTest(String name) {
        super(name);
    }

    private static final String BASIC_XML = "xml/basic.xml";

    private Document doc;

    private DocumentBuilderFactory factory;

    public void setUp() throws ParserConfigurationException {
        factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        doc = factory.newDocumentBuilder().newDocument();
    }

    public void testNamespaceDeclarationsAreNotAttributes() throws JaxenException {
        Element root = doc.createElementNS("http://www.example.org/", "root");
        doc.appendChild(root);
        root.setAttributeNS("http://www.w3.org/2000/xmlns/", "xmlns", "http://www.example.org/");
        DOMXPath xpath = new DOMXPath("count(/*/@*)");
        Number value = xpath.numberValueOf(doc);
        assertEquals(0, value.intValue());
    }

    public void testConstruction() throws JaxenException {
        DOMXPath xpath = new DOMXPath("/foo/bar/baz");
        assertEquals("/foo/bar/baz", xpath.toString());
    }

    public void testIntrinsicNamespaceDeclarationOfElementBeatsContradictoryXmlnsPreAttr() throws JaxenException {
        Element root = doc.createElement("root");
        doc.appendChild(root);
        Element child = doc.createElementNS("http://www.example.org", "foo:child");
        root.appendChild(child);
        child.setAttributeNS("http://www.w3.org/2000/xmlns/", "xmlns:foo", "http://www.contradictory.org");
        XPath xpath = new DOMXPath("//namespace::node()[name(.)='foo']");
        List result = xpath.selectNodes(doc);
        assertEquals(1, result.size());
        Node node = (Node) result.get(0);
        assertEquals("http://www.example.org", node.getNodeValue());
    }

    public void testJaxen207() throws JaxenException {
        XPath xpath = new DOMXPath("contains($FinResp, \"NS_Payables_Associate\") or" + "contains($FinResp, \"NS_Payables_Manager\") or" + "contains($FinResp, \"NS_Payment_Processing\") or" + "contains($FinResp, \"NS_Vendor_Maintenance\") or" + "contains($FinResp, \"NS_IB_Receivables_Manager\") or" + "contains($FinResp, \"NS_IB_Receivables_User\") or" + "contains($FinResp, \"NS_Receivables_Manager\") or" + "contains($FinResp, \"NS_Receivables_User\") or" + "contains($FinResp, \"NS_Cash_Management_User\") or" + "contains($FinResp, \"NS_Cost_Management\") or" + "contains($FinResp, \"NS_Fixed_Assets_Manager\") or" + "contains($FinResp, \"NS_Fixed_Asset_User\") or" + "contains($FinResp, \"NS_General_Ledger_Inquiry\") or" + "contains($FinResp, \"NS_General_Ledger_User\") or" + "contains($FinResp, \"NS_General_Ledger_Supervisor\") or" + "contains($FinResp, \"NS_IB_General_Ledger_User\") or" + "contains($FinResp, \"NS_IB_Oracle_Web_ADI\") or" + "contains($FinResp, \"NS_Oracle_Web_ADI\") or" + "contains($FinResp, \"NS_CRM_Resource_Manager\") or" + "contains($FinResp, \"NS_Distributor_Manager\") or" + "contains($FinResp, \"NS_OIC_User\") or" + "contains($FinResp, \" NS_Operations_Buyer\") or" + "contains($FinResp, \"NS_Purchasing_Buyer\") or" + "contains($FinResp, \"NS_Vendor_Maintenance\") or " + "contains($FinResp, \"SL_Payables_Manager\") or" + "contains($FinResp, \"SL_Payables_Super_User\") or" + "contains($FinResp, \"SL_Payment_Processing\") or" + "contains($FinResp, \"SL_Vendor_Maintenance\") or" + "contains($InvResp, \"SL_Inventory_Super_User\") or" + "contains($FinResp, \"\") or" + "contains($FinResp, \"SL_Receivables_Supervisor\") or" + "contains($FinResp, \"SL_Receivables_User\") or" + "contains($FinResp, \"NS_Cost_Management_Inquiry\") or" + "contains($FinResp, \"SL_Fixed_Asset_User\") or" + "contains($FinResp, \"SL_Fixed_Assets_Manager\") or" + "contains($FinResp, \"SL_General_Ledger_Inquiry\") or" + "contains($FinResp, \"SL_General_Ledger_Supervisor\") or" + "contains($FinResp, \"SL_General_Ledger_User\") or" + "contains($FinResp, \"SL_Oracle_Web_ADI\") or" + "contains($FinResp, \"SL_Buyer\") or" + "contains($FinResp, \"SL_Purchasing_Inquiry\") or" + "contains($FinResp, \"SL_Payables_Manager\") or" + "contains($FinResp, \"SL_Payables_Super_User\") or" + "contains($FinResp, \"SL_Payment_Processing\") or" + "contains($FinResp, \"SL_Vendor_Maintenance\") or" + "contains($InvResp, \"SL_Inventory_Super_User\") or" + "contains($FinResp, \"\") or" + "contains($FinResp, \"SL_Receivables_Supervisor\") or" + "contains($FinResp, \"SL_Receivables_User\") or" + "contains($FinResp, \"NS_Cost_Management_Inquiry\") or" + "contains($FinResp, \"SL_Fixed_Asset_User\") or" + "contains($FinResp, \"SL_Fixed_Assets_Manager\") or" + "contains($FinResp, \"SL_General_Ledger_Inquiry\") or" + "contains($FinResp, \"SL_General_Ledger_Supervisor\") or" + "contains($FinResp, \"SL_General_Ledger_User\") or" + "contains($FinResp, \"SL_Oracle_Web_ADI\") or" + "contains($FinResp, \"SL_Buyer\") or" + "contains($FinResp, \"SL_Purchasing_Inquiry\")");
    }

    public void testUpdateDOMNodesReturnedBySelectNodes() throws JaxenException {
        Element root = doc.createElementNS("http://www.example.org/", "root");
        doc.appendChild(root);
        root.appendChild(doc.createComment("data"));
        DOMXPath xpath = new DOMXPath("//comment()");
        List results = xpath.selectNodes(doc);
        Node backroot = (Node) results.get(0);
        backroot.setNodeValue("test");
        assertEquals("test", backroot.getNodeValue());
    }

    public void testImplictCastFromCommentInARelationalExpression() throws JaxenException, ParserConfigurationException, SAXException, IOException {
        XPath implicitCast = new DOMXPath("//lat[(comment() >= 37)]");
        XPath explicitCast = new DOMXPath("//lat[(number(comment()) >= 37)]");
        DocumentBuilder builder = factory.newDocumentBuilder();
        ByteArrayInputStream in = new ByteArrayInputStream("<geo><lat><!--39--></lat></geo>".getBytes("UTF-8"));
        Document document = builder.parse(in);
        List result = explicitCast.selectNodes(document);
        assertEquals(1, result.size());
        result = implicitCast.selectNodes(document);
        assertEquals(1, result.size());
    }

    public void testJaxen193() throws JaxenException {
        DOMXPath xpath = new DOMXPath("/*[ * or processing-instruction() ]");
        assertEquals("/*[ * or processing-instruction() ]", xpath.toString());
    }

    public void testInconsistentNamespaceDeclarations() throws JaxenException {
        Element root = doc.createElement("root");
        doc.appendChild(root);
        Element child = doc.createElementNS("http://www.example.org", "foo:child");
        root.appendChild(child);
        child.setAttributeNS("http://www.w3.org/2000/xmlns/", "xmlns:foo", "http://www.contradictory.org");
        XPath xpath = new DOMXPath("//namespace::node()");
        List result = xpath.selectNodes(doc);
        assertEquals(3, result.size());
    }

    public void testPrecedingAxisWithPositionalPredicate() throws JaxenException, ParserConfigurationException, SAXException, IOException {
        XPath xpath = new DOMXPath("//c/preceding::*[1][name()='d']");
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse("xml/web2.xml");
        List result = xpath.selectNodes(document);
        assertEquals(1, result.size());
    }

    public void testPrecedingAxisInDocumentOrder() throws JaxenException {
        XPath xpath = new DOMXPath("preceding::*");
        Element root = doc.createElement("root");
        doc.appendChild(root);
        Element a = doc.createElement("a");
        root.appendChild(a);
        Element b = doc.createElement("b");
        root.appendChild(b);
        Element c = doc.createElement("c");
        a.appendChild(c);
        List result = xpath.selectNodes(b);
        assertEquals(2, result.size());
        assertEquals(a, result.get(0));
        assertEquals(c, result.get(1));
    }

    public void testJaxen22() throws JaxenException, ParserConfigurationException, SAXException, IOException {
        XPath xpath = new DOMXPath("name(//c/preceding::*[1])");
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc = builder.parse("xml/web2.xml");
        Object result = xpath.evaluate(doc);
        assertEquals("d", result);
    }

    public void testJaxen193InReverse() throws JaxenException {
        DOMXPath xpath = new DOMXPath("/*[ processing-instruction() or *]");
        assertEquals("/*[ processing-instruction() or *]", xpath.toString());
    }

    public void testConsistentNamespaceDeclarations() throws JaxenException {
        Element root = doc.createElement("root");
        doc.appendChild(root);
        Element child = doc.createElementNS("http://www.example.org", "foo:child");
        root.appendChild(child);
        child.setAttributeNS("http://www.w3.org/2000/xmlns/", "xmlns:foo2", "http://www.contradictory.org");
        XPath xpath = new DOMXPath("//namespace::node()");
        List result = xpath.selectNodes(doc);
        assertEquals(4, result.size());
    }

    public void testIntrinsicNamespaceDeclarationOfAttrBeatsContradictoryXmlnsPreAttr() throws JaxenException {
        Element root = doc.createElement("root");
        doc.appendChild(root);
        root.setAttributeNS("http://www.example.org/", "foo:a", "value");
        root.setAttributeNS("http://www.w3.org/2000/xmlns/", "xmlns:foo", "http://www.contradictory.org");
        XPath xpath = new DOMXPath("//namespace::node()[name(.)='foo']");
        List result = xpath.selectNodes(doc);
        assertEquals(1, result.size());
        Node node = (Node) result.get(0);
        assertEquals("http://www.example.org/", node.getNodeValue());
    }

    public void testImplictCastFromProcessingInstructionInARelationalExpression() throws JaxenException, ParserConfigurationException, SAXException, IOException {
        XPath implicitCast = new DOMXPath("//lat[(processing-instruction() >= 37)]");
        XPath explicitCast = new DOMXPath("//lat[(number(processing-instruction()) >= 37)]");
        DocumentBuilder builder = factory.newDocumentBuilder();
        ByteArrayInputStream in = new ByteArrayInputStream("<geo><lat><?test 39?></lat></geo>".getBytes("UTF-8"));
        Document document = builder.parse(in);
        List result = explicitCast.selectNodes(document);
        assertEquals(1, result.size());
        result = implicitCast.selectNodes(document);
        assertEquals(1, result.size());
    }

    public void testConstructionWithNamespacePrefix() throws JaxenException {
        DOMXPath xpath = new DOMXPath("/p:foo/p:bar/a:baz");
        assertEquals("/p:foo/p:bar/a:baz", xpath.toString());
    }

    public void testIntrinsicNamespaceDeclarationOfElementBeatsContradictoryIntrinsicNamespaceOfAttr() throws JaxenException {
        Element root = doc.createElementNS("http://www.example.org", "pre:root");
        doc.appendChild(root);
        root.setAttributeNS("http://www.contradictory.org", "pre:foo", "value");
        XPath xpath = new DOMXPath("//namespace::node()[name(.)='pre']");
        List result = xpath.selectNodes(doc);
        assertEquals(1, result.size());
        Node node = (Node) result.get(0);
        assertEquals("http://www.example.org", node.getNodeValue());
    }

    public void testSelection() throws JaxenException, ParserConfigurationException, SAXException, IOException {
        XPath xpath = new DOMXPath("/foo/bar/baz");
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(BASIC_XML);
        List results = xpath.selectNodes(document);
        assertEquals(3, results.size());
        Iterator iter = results.iterator();
        assertEquals("baz", ((Element) iter.next()).getLocalName());
        assertEquals("baz", ((Element) iter.next()).getLocalName());
        assertEquals("baz", ((Element) iter.next()).getLocalName());
        assertTrue(!iter.hasNext());
    }

    public void testImplictCastFromTextInARelationalExpression() throws JaxenException, ParserConfigurationException, SAXException, IOException {
        XPath implicitCast = new DOMXPath("//lat[(text() >= 37)]");
        XPath explicitCast = new DOMXPath("//lat[(number(text()) >= 37)]");
        DocumentBuilder builder = factory.newDocumentBuilder();
        ByteArrayInputStream in = new ByteArrayInputStream("<geo><lat>39</lat></geo>".getBytes("UTF-8"));
        Document document = builder.parse(in);
        List result = explicitCast.selectNodes(document);
        assertEquals(1, result.size());
        result = implicitCast.selectNodes(document);
        assertEquals(1, result.size());
    }
}
