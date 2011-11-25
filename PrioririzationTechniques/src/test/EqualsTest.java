package test;

import java.io.IOException;
import java.io.StringReader;
import java.util.List;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.jaxen.JaxenException;
import org.jaxen.dom.DOMXPath;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import junit.framework.TestCase;

public class EqualsTest extends TestCase {

    public void testEqualityAgainstNonExistentNodes() throws JaxenException, ParserConfigurationException {
        DOMXPath xpath = new DOMXPath("/a/b[c = ../d]");
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        Document doc = factory.newDocumentBuilder().newDocument();
        Element root = doc.createElement("a");
        doc.appendChild(root);
        Element b = doc.createElement("b");
        root.appendChild(b);
        Element c = doc.createElement("c");
        b.appendChild(c);
        List result = (List) xpath.evaluate(doc);
        assertEquals(0, result.size());
    }

    public void testOlander() throws JaxenException, SAXException, IOException, ParserConfigurationException {
        DOMXPath xpath = new DOMXPath("//BlockStatement//IfStatement[./Statement =  ./ancestor::BlockStatement/following-sibling::BlockStatement//IfStatement/Statement]");
        String data = "<?xml version='1.0'?><Block><BlockStatement><LocalVariableDeclaration><Type><PrimitiveType>boolean</PrimitiveType></Type><VariableDeclarator><VariableDeclaratorId/></VariableDeclarator><VariableDeclarator><VariableDeclaratorId/></VariableDeclarator></LocalVariableDeclaration></BlockStatement><BlockStatement><Statement><IfStatement><Expression><PrimaryExpression><PrimaryPrefix><Name>a</Name></PrimaryPrefix></PrimaryExpression></Expression><Statement><StatementExpression><PrimaryExpression><PrimaryPrefix><Name>methodB</Name></PrimaryPrefix><PrimarySuffix><Arguments/></PrimarySuffix></PrimaryExpression></StatementExpression></Statement></IfStatement></Statement></BlockStatement><BlockStatement><Statement><IfStatement><Expression><PrimaryExpression><PrimaryPrefix><Name>b</Name></PrimaryPrefix></PrimaryExpression></Expression><Statement><StatementExpression><PrimaryExpression><PrimaryPrefix><Name>methodB</Name></PrimaryPrefix><PrimarySuffix><Arguments/></PrimarySuffix></PrimaryExpression></StatementExpression></Statement></IfStatement></Statement></BlockStatement></Block>";
        StringReader reader = new StringReader(data);
        InputSource in = new InputSource(reader);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        Document doc = factory.newDocumentBuilder().parse(in);
        List result = (List) xpath.evaluate(doc);
        assertEquals(1, result.size());
    }
}
