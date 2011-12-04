package testBag2;

//import org.jaxen.pattern.Pattern;
//import org.dom4j.DocumentHelper;
import org.jaxen.JaxenException;
import org.jaxen.XPath;
//import org.jaxen.UnsupportedAxisException;
import org.jaxen.dom4j.DocumentNavigator;
//import org.jaxen.function.StringFunction;
import java.util.List;
import org.dom4j.io.SAXReader;
import org.jaxen.dom.DOMXPath;
import junit.framework.TestCase;
import org.jaxen.*;
import org.jaxen.Navigator;
import java.util.Iterator;
//import org.jaxen.FunctionCallException;
//import org.dom4j.Document;
//import org.jaxen.dom4j.Dom4jXPath;
import java.util.ArrayList;
import org.jaxen.saxpath.helpers.XPathReaderFactory;

public class BagClass extends TestCase {

    private SAXReader reader_DOM4JNavigatorTest;

    protected static String VAR_URI = "http://jaxen.org/test-harness/var";

    protected static String TESTS_XML = "xml/test/tests.xml";

    protected static boolean verbose = false;

    protected static boolean debug = false;

    private ContextSupport contextSupport;

//    public Navigator getNavigator_DOM4JNavigatorTest() {
//        return new DocumentNavigator();
//    }
//
//    public Object getDocument_DOM4JNavigatorTest(String url) throws Exception {
//        return reader_DOM4JNavigatorTest.read(url);
//    }
//
//    /**
//     * reported as JAXEN-104.
//     * @throws FunctionCallException
//     * @throws UnsupportedAxisException
//     */
//    public void testConcurrentModification_DOM4JNavigatorTest() throws FunctionCallException, UnsupportedAxisException {
//        this.reader_DOM4JNavigatorTest = new SAXReader();
//        this.reader_DOM4JNavigatorTest.setMergeAdjacentText(true);
//        Navigator nav = new DocumentNavigator();
//        Object document = nav.getDocument("xml/testNamespaces.xml");
//        Iterator descendantOrSelfAxisIterator = nav.getDescendantOrSelfAxisIterator(document);
//        while (descendantOrSelfAxisIterator.hasNext()) {
//            Object node = descendantOrSelfAxisIterator.next();
//            Iterator namespaceAxisIterator = nav.getNamespaceAxisIterator(node);
//            while (namespaceAxisIterator.hasNext()) {
//                namespaceAxisIterator.next();
//            }
//        }
//    }
//
//    public void testNullPointerException_DOM4JNavigatorTest() throws JaxenException {
//        Document doc = DocumentHelper.createDocument();
//        XPath xpath = new Dom4jXPath("/foo");
//        xpath.selectSingleNode(doc);
//    }
//
    public void log_XPathTestBase(String text) throws Exception {
        log_XPathTestBase(verbose, text);
    }

    private void log_XPathTestBase(boolean actualVerbose, String text) throws Exception {
        if (actualVerbose) System.out.println(text);
    }

    private void assertCountXPath_XPathTestBase(int expectedSize, Object context, String xpathStr) throws JaxenException, Exception {
        assertCountXPath2_XPathTestBase(expectedSize, context, xpathStr);
    }

    private Object assertCountXPath2_XPathTestBase(int expectedSize, Object context, String xpathStr) throws JaxenException, Exception {
        log_XPathTestBase(debug, "  Select :: " + xpathStr);
        DOMXPath xpath = new DOMXPath(xpathStr);
        List results = xpath.selectNodes(getContext_XPathTestBase(context));
        log_XPathTestBase(debug, "    Expected Size :: " + expectedSize);
        log_XPathTestBase(debug, "    Result Size   :: " + results.size());
        if (expectedSize != results.size()) {
            log_XPathTestBase(debug, "      ## FAILED");
            log_XPathTestBase(debug, "      ## xpath: " + xpath + " = " + xpath.debug());
            Iterator resultIter = results.iterator();
            while (resultIter.hasNext()) {
                log_XPathTestBase(debug, "      --> " + resultIter.next());
            }
        }
        assertEquals(xpathStr, expectedSize, results.size());
        assertExprGetTextIdempotent_XPathTestBase(xpath);
        if (expectedSize > 0) {
            return results.get(0);
        }
        return null;
    }

//    private void assertInvalidXPath_XPathTestBase(Object context, String xpathStr) throws Exception {
//        try {
//            log_XPathTestBase(debug, "  Select :: " + xpathStr);
//            DOMXPath xpath = new DOMXPath(xpathStr);
//            List results = xpath.selectNodes(getContext_XPathTestBase(context));
//            log_XPathTestBase(debug, "    Result Size   :: " + results.size());
//            fail("An exception was expected.");
//        } catch (JaxenException e) {
//            log_XPathTestBase(debug, "    Caught expected exception " + e.getMessage());
//        }
//    }
//
//    private void assertValueOfXPath_XPathTestBase(String expected, Object context, String xpathStr) throws JaxenException, Exception {
//        DOMXPath xpath = new DOMXPath(xpathStr);
//        Object node = xpath.evaluate(getContext_XPathTestBase(context));
//        String result = StringFunction.evaluate(node, getNavigator_XPathTestBase());
//        log_XPathTestBase(debug, "  Select :: " + xpathStr);
//        log_XPathTestBase(debug, "    Expected :: " + expected);
//        log_XPathTestBase(debug, "    Result   :: " + result);
//        if (!expected.equals(result)) {
//            log_XPathTestBase(debug, "      ## FAILED");
//            log_XPathTestBase(debug, "      ## xpath: " + xpath + " = " + xpath.debug());
//        }
//        assertEquals(xpathStr, expected, result);
//        assertExprGetTextIdempotent_XPathTestBase(xpath);
//    }
//
    private void assertExprGetTextIdempotent_XPathTestBase(BaseXPath xpath) throws JaxenException, Exception {
        assertEquals(0, ExprComparator.EXPR_COMPARATOR.compare(xpath.getRootExpr(), new BaseXPath(xpath.getRootExpr().getText(), null).getRootExpr()));
    }

    private Context getContext_XPathTestBase(Object contextNode) throws Exception {
        Context context = new Context(getContextSupport_XPathTestBase());
        List list = new ArrayList(1);
        list.add(contextNode);
        context.setNodeSet(list);
        return context;
    }

    private ContextSupport getContextSupport_XPathTestBase() throws Exception {
        if (this.contextSupport == null) {
            this.contextSupport = new ContextSupport(new SimpleNamespaceContext(), XPathFunctionContext.getInstance(), new SimpleVariableContext(), getNavigator_XPathTestBase());
        }
        return this.contextSupport;
    }
    
    public Navigator getNavigator_XPathTestBase()
    {
        return new DocumentNavigator();
    }
//    
//    protected Object getDocument_XPathTestBase(String url) throws Exception{
//    	return reader_DOM4JNavigatorTest.read( url );
//    	
//    }
//
//    public void testGetNodeType_XPathTestBase() throws FunctionCallException, UnsupportedAxisException, Exception {
//        this.contextSupport = null;
//        System.setProperty(XPathReaderFactory.DRIVER_PROPERTY, "");
//        log_XPathTestBase("-----------------------------");
//        Navigator nav = getNavigator_XPathTestBase();
//        Object document = nav.getDocument("xml/testNamespaces.xml");
//        int count = 0;
//        Iterator descendantOrSelfAxisIterator = nav.getDescendantOrSelfAxisIterator(document);
//        while (descendantOrSelfAxisIterator.hasNext()) {
//            Object node = descendantOrSelfAxisIterator.next();
//            Iterator namespaceAxisIterator = nav.getNamespaceAxisIterator(node);
//            while (namespaceAxisIterator.hasNext()) {
//                count++;
//                assertEquals("Node type mismatch", Pattern.NAMESPACE_NODE, nav.getNodeType(namespaceAxisIterator.next()));
//            }
//        }
//        assertEquals(25, count);
//    }
//
//    /**
//     *  test for jaxen-24
//     */
//    public void testJaxen24_XPathTestBase() throws JaxenException, Exception {
//        this.contextSupport = null;
//        System.setProperty(XPathReaderFactory.DRIVER_PROPERTY, "");
//        log_XPathTestBase("-----------------------------");
//        Navigator nav = getNavigator_XPathTestBase();
//        String url = "xml/jaxen24.xml";
//        log_XPathTestBase("Document [" + url + "]");
//        Object document = nav.getDocument(url);
//        XPath contextpath = new BaseXPath("/body/div", nav);
//        log_XPathTestBase("Initial Context :: " + contextpath);
//        List list = contextpath.selectNodes(document);
//        Iterator iter = list.iterator();
//        while (iter.hasNext()) {
//            Object context = iter.next();
//            assertCountXPath_XPathTestBase(1, context, "preceding::*[1]");
//            assertValueOfXPath_XPathTestBase("span", context, "local-name(preceding::*[1])");
//        }
//    }
//
//    /**
//     *  jaxen-58
//     */
//    public void testJaxen58_XPathTestBase() throws JaxenException, Exception {
//        this.contextSupport = null;
//        System.setProperty(XPathReaderFactory.DRIVER_PROPERTY, "");
//        log_XPathTestBase("-----------------------------");
//        Navigator nav = getNavigator_XPathTestBase();
//        String url = "xml/jaxen24.xml";
//        log_XPathTestBase("Document [" + url + "]");
//        Object document = nav.getDocument(url);
//        XPath contextpath = new BaseXPath("/", nav);
//        log_XPathTestBase("Initial Context :: " + contextpath);
//        List list = contextpath.selectNodes(document);
//        Iterator iter = list.iterator();
//        while (iter.hasNext()) {
//            Object context = iter.next();
//            assertCountXPath_XPathTestBase(0, context, "//preceding::x");
//            assertCountXPath_XPathTestBase(0, context, "//following::x");
//            assertCountXPath_XPathTestBase(0, context, "/descendant::*/preceding::x");
//            assertCountXPath_XPathTestBase(0, context, "/descendant::node()/preceding::x");
//        }
//    }
//
//    /**
//     *  test for jaxen-3
//     */
//    public void testJaxen3_XPathTestBase() throws JaxenException, Exception {
//        this.contextSupport = null;
//        System.setProperty(XPathReaderFactory.DRIVER_PROPERTY, "");
//        log_XPathTestBase("-----------------------------");
//        Navigator nav = getNavigator_XPathTestBase();
//        String url = "xml/simple.xml";
//        log_XPathTestBase("Document [" + url + "]");
//        Object document = nav.getDocument(url);
//        XPath contextpath = new BaseXPath("/", nav);
//        log_XPathTestBase("Initial Context :: " + contextpath);
//        List list = contextpath.selectNodes(document);
//        Iterator iter = list.iterator();
//        while (iter.hasNext()) {
//            Object context = iter.next();
//            assertValueOfXPath_XPathTestBase("abd", context, "string()");
//        }
//    }
//
//    public void testStringFunction1_XPathTestBase() throws JaxenException, Exception {
//        this.contextSupport = null;
//        System.setProperty(XPathReaderFactory.DRIVER_PROPERTY, "");
//        log_XPathTestBase("-----------------------------");
//        Navigator nav = getNavigator_XPathTestBase();
//        String url = "xml/simple.xml";
//        log_XPathTestBase("Document [" + url + "]");
//        Object document = nav.getDocument(url);
//        XPath contextpath = new BaseXPath("/root", nav);
//        log_XPathTestBase("Initial Context :: " + contextpath);
//        List list = contextpath.selectNodes(document);
//        Iterator iter = list.iterator();
//        while (iter.hasNext()) {
//            Object context = iter.next();
//            assertValueOfXPath_XPathTestBase("abd", context, "string()");
//        }
//    }
//
//    public void testStringFunction2_XPathTestBase() throws JaxenException, Exception {
//        this.contextSupport = null;
//        System.setProperty(XPathReaderFactory.DRIVER_PROPERTY, "");
//        log_XPathTestBase("-----------------------------");
//        Navigator nav = getNavigator_XPathTestBase();
//        String url = "xml/simple.xml";
//        log_XPathTestBase("Document [" + url + "]");
//        Object document = nav.getDocument(url);
//        XPath contextpath = new BaseXPath("/root/a", nav);
//        log_XPathTestBase("Initial Context :: " + contextpath);
//        List list = contextpath.selectNodes(document);
//        Iterator iter = list.iterator();
//        while (iter.hasNext()) {
//            Object context = iter.next();
//            assertValueOfXPath_XPathTestBase("a", context, "string()");
//        }
//    }
//
//    public void testStringFunction3_XPathTestBase() throws JaxenException, Exception {
//        this.contextSupport = null;
//        System.setProperty(XPathReaderFactory.DRIVER_PROPERTY, "");
//        log_XPathTestBase("-----------------------------");
//        Navigator nav = getNavigator_XPathTestBase();
//        String url = "xml/simple.xml";
//        log_XPathTestBase("Document [" + url + "]");
//        Object document = nav.getDocument(url);
//        XPath contextpath = new BaseXPath("/root/c", nav);
//        log_XPathTestBase("Initial Context :: " + contextpath);
//        List list = contextpath.selectNodes(document);
//        Iterator iter = list.iterator();
//        while (iter.hasNext()) {
//            Object context = iter.next();
//            assertValueOfXPath_XPathTestBase("d", context, "string()");
//        }
//    }
//
//    /**
//     *  test for jaxen-3
//     */
//    public void testJaxen3dupe_XPathTestBase() throws JaxenException, Exception {
//        this.contextSupport = null;
//        System.setProperty(XPathReaderFactory.DRIVER_PROPERTY, "");
//        log_XPathTestBase("-----------------------------");
//        Navigator nav = getNavigator_XPathTestBase();
//        String url = "xml/jaxen3.xml";
//        log_XPathTestBase("Document [" + url + "]");
//        Object document = nav.getDocument(url);
//        XPath contextpath = new BaseXPath("/", nav);
//        log_XPathTestBase("Initial Context :: " + contextpath);
//        List list = contextpath.selectNodes(document);
//        Iterator iter = list.iterator();
//        while (iter.hasNext()) {
//            Object context = iter.next();
//            assertCountXPath_XPathTestBase(1, context, "/Configuration/hostname/attrlist/hostname[. = 'CE-A'] ");
//        }
//    }
//
//    /**
//     *  parser test cases all of which should fail
//     */
//    public void testForParserErrors_XPathTestBase() throws JaxenException, Exception {
//        this.contextSupport = null;
//        System.setProperty(XPathReaderFactory.DRIVER_PROPERTY, "");
//        log_XPathTestBase("-----------------------------");
//        Navigator nav = getNavigator_XPathTestBase();
//        String url = "xml/numbers.xml";
//        log_XPathTestBase("Document [" + url + "]");
//        Object document = nav.getDocument(url);
//        XPath contextpath = new BaseXPath("/", nav);
//        log_XPathTestBase("Initial Context :: " + contextpath);
//        List list = contextpath.selectNodes(document);
//        Iterator iter = list.iterator();
//        while (iter.hasNext()) {
//            Object context = iter.next();
//            assertInvalidXPath_XPathTestBase(context, "/numbers numbers");
//            assertInvalidXPath_XPathTestBase(context, "/a/b[c > d]efg");
//            assertInvalidXPath_XPathTestBase(context, "/inv/child::");
//            assertInvalidXPath_XPathTestBase(context, "/invoice/@test[abcd");
//            assertInvalidXPath_XPathTestBase(context, "/invoice/@test[abcd > x");
//            assertInvalidXPath_XPathTestBase(context, "string-length('a");
//            assertInvalidXPath_XPathTestBase(context, "/descendant::()");
//            assertInvalidXPath_XPathTestBase(context, "(1 + 1");
//            assertInvalidXPath_XPathTestBase(context, "!false()");
//        }
//    }
//
//    /**
//     *  test cases for the use of underscores in names
//     */
//    public void testUnderscoresInNames_XPathTestBase() throws JaxenException, Exception {
//        this.contextSupport = null;
//        System.setProperty(XPathReaderFactory.DRIVER_PROPERTY, "");
//        log_XPathTestBase("-----------------------------");
//        Navigator nav = getNavigator_XPathTestBase();
//        String url = "xml/underscore.xml";
//        log_XPathTestBase("Document [" + url + "]");
//        Object document = nav.getDocument(url);
//        XPath contextpath = new BaseXPath("/", nav);
//        log_XPathTestBase("Initial Context :: " + contextpath);
//        List list = contextpath.selectNodes(document);
//        Iterator iter = list.iterator();
//        while (iter.hasNext()) {
//            Object context = iter.next();
//            assertCountXPath_XPathTestBase(1, context, "/root/@a");
//            assertCountXPath_XPathTestBase(1, context, "/root/@_a");
//            assertCountXPath_XPathTestBase(1, context, "/root/b");
//            assertCountXPath_XPathTestBase(1, context, "/root/_b");
//            assertValueOfXPath_XPathTestBase("1", context, "/root/@a");
//            assertValueOfXPath_XPathTestBase("2", context, "/root/@_a");
//            assertValueOfXPath_XPathTestBase("1", context, "/root/b");
//            assertValueOfXPath_XPathTestBase("2", context, "/root/_b");
//        }
//    }
//
//    /** 
//     * test cases for the use of = with node-sets
//     */
//    public void testNodesetEqualsString_XPathTestBase() throws JaxenException, Exception {
//        this.contextSupport = null;
//        System.setProperty(XPathReaderFactory.DRIVER_PROPERTY, "");
//        log_XPathTestBase("-----------------------------");
//        Navigator nav = getNavigator_XPathTestBase();
//        String url = "xml/web.xml";
//        log_XPathTestBase("Document [" + url + "]");
//        Object document = nav.getDocument(url);
//        XPath contextpath = new BaseXPath("/", nav);
//        log_XPathTestBase("Initial Context :: " + contextpath);
//        List list = contextpath.selectNodes(document);
//        Iterator iter = list.iterator();
//        while (iter.hasNext()) {
//            Object context = iter.next();
//            assertValueOfXPath_XPathTestBase("true", context, "/web-app/servlet/servlet-name = 'file'");
//            assertValueOfXPath_XPathTestBase("true", context, "/web-app/servlet/servlet-name = 'snoop'");
//        }
//    }
//
//    public void testNodesetEqualsNumber_XPathTestBase() throws JaxenException, Exception {
//        this.contextSupport = null;
//        System.setProperty(XPathReaderFactory.DRIVER_PROPERTY, "");
//        log_XPathTestBase("-----------------------------");
//        Navigator nav = getNavigator_XPathTestBase();
//        String url = "xml/numbers.xml";
//        log_XPathTestBase("Document [" + url + "]");
//        Object document = nav.getDocument(url);
//        XPath contextpath = new BaseXPath("/", nav);
//        log_XPathTestBase("Initial Context :: " + contextpath);
//        List list = contextpath.selectNodes(document);
//        Iterator iter = list.iterator();
//        while (iter.hasNext()) {
//            Object context = iter.next();
//            assertValueOfXPath_XPathTestBase("true", context, "/numbers/set/nr = '-3'");
//            assertValueOfXPath_XPathTestBase("true", context, "/numbers/set/nr = -3");
//            assertValueOfXPath_XPathTestBase("true", context, "/numbers/set/nr = 24");
//            assertValueOfXPath_XPathTestBase("true", context, "/numbers/set/nr/@value = '9999'");
//            assertValueOfXPath_XPathTestBase("true", context, "/numbers/set/nr/@value = 9999.0");
//            assertValueOfXPath_XPathTestBase("true", context, "/numbers/set/nr/@value = 66");
//        }
//    }
//
//    /** 
//     * test basic math...
//     */
//    public void testIntegerArithmetic_XPathTestBase() throws JaxenException, Exception {
//        this.contextSupport = null;
//        System.setProperty(XPathReaderFactory.DRIVER_PROPERTY, "");
//        log_XPathTestBase("-----------------------------");
//        Navigator nav = getNavigator_XPathTestBase();
//        String url = "xml/numbers.xml";
//        log_XPathTestBase("Document [" + url + "]");
//        Object document = nav.getDocument(url);
//        XPath contextpath = new BaseXPath("/", nav);
//        log_XPathTestBase("Initial Context :: " + contextpath);
//        List list = contextpath.selectNodes(document);
//        Iterator iter = list.iterator();
//        while (iter.hasNext()) {
//            Object context = iter.next();
//            assertValueOfXPath_XPathTestBase("true", context, "(8 * 2 + 1) = 17");
//            assertValueOfXPath_XPathTestBase("true", context, "(1 + 8 * 2) = 17");
//            assertValueOfXPath_XPathTestBase("true", context, "(7 - 3 + 1) = 5");
//            assertValueOfXPath_XPathTestBase("true", context, "(8 - 4 + 5 - 6) = 3");
//            assertValueOfXPath_XPathTestBase("0", context, "3 - 2 - 1");
//            assertValueOfXPath_XPathTestBase("1", context, "8 div 4 div 2");
//            assertValueOfXPath_XPathTestBase("3", context, "3 mod 7 mod 5");
//            assertValueOfXPath_XPathTestBase("false", context, "1 = 2 = 2");
//            assertValueOfXPath_XPathTestBase("false", context, "2 != 3 != 1");
//            assertValueOfXPath_XPathTestBase("false", context, "3 > 2 > 1");
//            assertValueOfXPath_XPathTestBase("false", context, "3 >= 2 >= 2");
//            assertValueOfXPath_XPathTestBase("true", context, "1 < 2 < 3");
//            assertValueOfXPath_XPathTestBase("true", context, "2 <= 2 <= 3");
//        }
//    }
//
//    public void testFloatingPointArithmetic_XPathTestBase() throws JaxenException, Exception {
//        this.contextSupport = null;
//        System.setProperty(XPathReaderFactory.DRIVER_PROPERTY, "");
//        log_XPathTestBase("-----------------------------");
//        Navigator nav = getNavigator_XPathTestBase();
//        String url = "xml/numbers.xml";
//        log_XPathTestBase("Document [" + url + "]");
//        Object document = nav.getDocument(url);
//        XPath contextpath = new BaseXPath("/", nav);
//        log_XPathTestBase("Initial Context :: " + contextpath);
//        List list = contextpath.selectNodes(document);
//        Iterator iter = list.iterator();
//        while (iter.hasNext()) {
//            Object context = iter.next();
//            assertValueOfXPath_XPathTestBase("true", context, "(8.5 * 2.0 + 1) = 18");
//            assertValueOfXPath_XPathTestBase("true", context, "(1.00 + 8.5 * 2) = 18.0");
//            assertValueOfXPath_XPathTestBase("true", context, "(7.1 - 7.1 + 1.5) = 1.5");
//            assertValueOfXPath_XPathTestBase("true", context, "(8.000 - 4.0 + 5 - 6.00) = 3");
//            assertValueOfXPath_XPathTestBase("0", context, "3.5 - 2.5 - 1.0");
//            assertValueOfXPath_XPathTestBase("1", context, "8.0 div 4.0 div 2.0");
//            assertValueOfXPath_XPathTestBase("3", context, "3.0 mod 7.0 mod 5.0");
//            assertValueOfXPath_XPathTestBase("false", context, "1.5 = 2.3 = 2.3");
//            assertValueOfXPath_XPathTestBase("false", context, "2.1 != 3.2 != 1.9");
//            assertValueOfXPath_XPathTestBase("false", context, "3.8 > 2.7 > 1.6");
//            assertValueOfXPath_XPathTestBase("false", context, "3.4 >= 2.5 >= 2.5");
//            assertValueOfXPath_XPathTestBase("true", context, "1.4 < 2.3 < 3.2");
//            assertValueOfXPath_XPathTestBase("true", context, "2.5 <= 2.5 <= 3.5");
//        }
//    }
//
//    /** 
//     * test cases for preceding axis with different node types
//     */
//    public void testPrecedingSiblingAxis_XPathTestBase() throws JaxenException, Exception {
//        this.contextSupport = null;
//        System.setProperty(XPathReaderFactory.DRIVER_PROPERTY, "");
//        log_XPathTestBase("-----------------------------");
//        Navigator nav = getNavigator_XPathTestBase();
//        String url = "xml/pi2.xml";
//        log_XPathTestBase("Document [" + url + "]");
//        Object document = nav.getDocument(url);
//        XPath contextpath = new BaseXPath("/a/c", nav);
//        log_XPathTestBase("Initial Context :: " + contextpath);
//        List list = contextpath.selectNodes(document);
//        Iterator iter = list.iterator();
//        while (iter.hasNext()) {
//            Object context = iter.next();
//            assertCountXPath_XPathTestBase(1, context, "//processing-instruction()");
//            assertCountXPath_XPathTestBase(1, context, "preceding-sibling::*");
//            assertCountXPath_XPathTestBase(5, context, "preceding-sibling::node()");
//            assertCountXPath_XPathTestBase(1, context, "preceding-sibling::*[1]");
//            assertCountXPath_XPathTestBase(1, context, "preceding-sibling::processing-instruction()");
//            assertValueOfXPath_XPathTestBase("order-by=\"x\"", context, "preceding-sibling::processing-instruction()");
//            assertValueOfXPath_XPathTestBase("foo", context, "preceding-sibling::*[1]");
//            assertValueOfXPath_XPathTestBase("order-by=\"x\"", context, "preceding-sibling::node()[2]");
//        }
//    }
//
//    public void testVariableLookup_XPathTestBase() throws JaxenException, Exception {
//        this.contextSupport = null;
//        System.setProperty(XPathReaderFactory.DRIVER_PROPERTY, "");
//        log_XPathTestBase("-----------------------------");
//        Navigator nav = getNavigator_XPathTestBase();
//        String url = "xml/id.xml";
//        log_XPathTestBase("Document [" + url + "]");
//        Object document = nav.getDocument(url);
//        XPath contextpath = new BaseXPath("/", nav);
//        log_XPathTestBase("Initial Context :: " + contextpath);
//        List list = contextpath.selectNodes(document);
//        SimpleVariableContext varContext = new SimpleVariableContext();
//        varContext.setVariableValue(null, "foobar", "foobar");
//        varContext.setVariableValue(null, "foo", "foo");
//        getContextSupport_XPathTestBase().setVariableContext(varContext);
//        Iterator iter = list.iterator();
//        while (iter.hasNext()) {
//            Object context = iter.next();
//            assertValueOfXPath_XPathTestBase("foobar", context, "$foobar");
//            assertCountXPath_XPathTestBase(1, context, "/foo[@id=$foobar]");
//            assertCountXPath_XPathTestBase(0, context, "/foo[@id='$foobar']");
//            assertCountXPath_XPathTestBase(1, context, "/foo[concat($foo, 'bar')=@id]");
//            assertCountXPath_XPathTestBase(0, context, "CD_Library/artist[@name=$artist]");
//        }
//    }
//
//    public void testAttributeParent_XPathTestBase() throws JaxenException, Exception {
//        this.contextSupport = null;
//        System.setProperty(XPathReaderFactory.DRIVER_PROPERTY, "");
//        log_XPathTestBase("-----------------------------");
//        Navigator nav = getNavigator_XPathTestBase();
//        String url = "xml/id.xml";
//        log_XPathTestBase("Document [" + url + "]");
//        Object document = nav.getDocument(url);
//        XPath contextpath = new BaseXPath("/", nav);
//        log_XPathTestBase("Initial Context :: " + contextpath);
//        List list = contextpath.selectNodes(document);
//        Iterator iter = list.iterator();
//        while (iter.hasNext()) {
//            Object context = iter.next();
//            assertCountXPath_XPathTestBase(1, context, "/foo/@id/parent::foo");
//        }
//    }
//
//    /** 
//     * attributes can also be used as context nodes
//     */
//    public void testAttributeAsContext_XPathTestBase() throws JaxenException, Exception {
//        this.contextSupport = null;
//        System.setProperty(XPathReaderFactory.DRIVER_PROPERTY, "");
//        log_XPathTestBase("-----------------------------");
//        Navigator nav = getNavigator_XPathTestBase();
//        String url = "xml/id.xml";
//        log_XPathTestBase("Document [" + url + "]");
//        Object document = nav.getDocument(url);
//        XPath contextpath = new BaseXPath("/foo/@id", nav);
//        log_XPathTestBase("Initial Context :: " + contextpath);
//        List list = contextpath.selectNodes(document);
//        Iterator iter = list.iterator();
//        while (iter.hasNext()) {
//            Object context = iter.next();
//            assertCountXPath_XPathTestBase(1, context, "parent::foo");
//        }
//    }
//
//    public void testid53992_XPathTestBase() throws JaxenException, Exception {
//        this.contextSupport = null;
//        System.setProperty(XPathReaderFactory.DRIVER_PROPERTY, "");
//        log_XPathTestBase("-----------------------------");
//        Navigator nav = getNavigator_XPathTestBase();
//        String url = "xml/pi.xml";
//        log_XPathTestBase("Document [" + url + "]");
//        Object document = nav.getDocument(url);
//        XPath contextpath = new BaseXPath("/", nav);
//        log_XPathTestBase("Initial Context :: " + contextpath);
//        List list = contextpath.selectNodes(document);
//        Iterator iter = list.iterator();
//        while (iter.hasNext()) {
//            Object context = iter.next();
//            assertCountXPath_XPathTestBase(3, context, "//processing-instruction()");
//            assertCountXPath_XPathTestBase(2, context, "//processing-instruction('cheese')");
//            Object result = assertCountXPath2_XPathTestBase(1, context, "//processing-instruction('toast')");
//            assertValueOfXPath_XPathTestBase("is tasty", result, "string()");
//        }
//    }
//
//    /** 
//     * test evaluate() extension function
//     */
//    public void testid54032_XPathTestBase() throws JaxenException, Exception {
//        this.contextSupport = null;
//        System.setProperty(XPathReaderFactory.DRIVER_PROPERTY, "");
//        log_XPathTestBase("-----------------------------");
//        Navigator nav = getNavigator_XPathTestBase();
//        String url = "xml/evaluate.xml";
//        log_XPathTestBase("Document [" + url + "]");
//        Object document = nav.getDocument(url);
//        XPath contextpath = new BaseXPath("/", nav);
//        log_XPathTestBase("Initial Context :: " + contextpath);
//        List list = contextpath.selectNodes(document);
//        Iterator iter = list.iterator();
//        while (iter.hasNext()) {
//            Object context = iter.next();
//            assertCountXPath_XPathTestBase(3, context, "evaluate('//jumps/*')");
//            assertCountXPath_XPathTestBase(1, context, "evaluate('//jumps/object/dog')");
//            assertCountXPath_XPathTestBase(0, context, "evaluate('//jumps/object')/evaluate");
//            assertCountXPath_XPathTestBase(1, context, "evaluate('//jumps/object')/dog");
//            assertCountXPath_XPathTestBase(1, context, "evaluate('//jumps/*')/dog");
//            assertCountXPath_XPathTestBase(1, context, "//metatest[ evaluate(@select) = . ]");
//        }
//    }
//
//    public void testid54082_XPathTestBase() throws JaxenException, Exception {
//        this.contextSupport = null;
//        System.setProperty(XPathReaderFactory.DRIVER_PROPERTY, "");
//        log_XPathTestBase("-----------------------------");
//        Navigator nav = getNavigator_XPathTestBase();
//        String url = "xml/numbers.xml";
//        log_XPathTestBase("Document [" + url + "]");
//        Object document = nav.getDocument(url);
//        XPath contextpath = new BaseXPath("/numbers/set[1]", nav);
//        log_XPathTestBase("Initial Context :: " + contextpath);
//        List list = contextpath.selectNodes(document);
//        Iterator iter = list.iterator();
//        while (iter.hasNext()) {
//            Object context = iter.next();
//            assertCountXPath_XPathTestBase(1, context, "*[-3 = .]");
//            assertValueOfXPath_XPathTestBase("true", context, "54 < *");
//            assertValueOfXPath_XPathTestBase("true", context, "55 <= *");
//            assertValueOfXPath_XPathTestBase("false", context, "69 < *");
//            assertValueOfXPath_XPathTestBase("true", context, "-2 > *");
//            assertValueOfXPath_XPathTestBase("true", context, "-3 >= *");
//            assertValueOfXPath_XPathTestBase("false", context, "-4 >= *");
//        }
//    }
//
//    /** 
//     * test sibling axes 
//     */
//    public void testid54145_XPathTestBase() throws JaxenException, Exception {
//        this.contextSupport = null;
//        System.setProperty(XPathReaderFactory.DRIVER_PROPERTY, "");
//        log_XPathTestBase("-----------------------------");
//        Navigator nav = getNavigator_XPathTestBase();
//        String url = "xml/axis.xml";
//        log_XPathTestBase("Document [" + url + "]");
//        Object document = nav.getDocument(url);
//        XPath contextpath = new BaseXPath("/root", nav);
//        log_XPathTestBase("Initial Context :: " + contextpath);
//        List list = contextpath.selectNodes(document);
//        Iterator iter = list.iterator();
//        while (iter.hasNext()) {
//            Object context = iter.next();
//            assertCountXPath_XPathTestBase(0, context, "preceding-sibling::*");
//        }
//    }

    public void testid54156_XPathTestBase() throws JaxenException, Exception {
        this.contextSupport = null;
        System.setProperty(XPathReaderFactory.DRIVER_PROPERTY, "");
        log_XPathTestBase("-----------------------------");
        Navigator nav = getNavigator_XPathTestBase();
        String url = "xml/axis.xml";
        log_XPathTestBase("Document [" + url + "]");
        Object document = nav.getDocument(url);
        XPath contextpath = new BaseXPath("/root/a/a.3", nav);
        log_XPathTestBase("Initial Context :: " + contextpath);
        List list = contextpath.selectNodes(document);
        Iterator iter = list.iterator();
        while (iter.hasNext()) {
            Object context = iter.next();
            assertCountXPath_XPathTestBase(2, context, "preceding::*");
        }
    }

//    public void testid54168_XPathTestBase() throws JaxenException, Exception {
//        this.contextSupport = null;
//        System.setProperty(XPathReaderFactory.DRIVER_PROPERTY, "");
//        log_XPathTestBase("-----------------------------");
//        Navigator nav = getNavigator_XPathTestBase();
//        String url = "xml/axis.xml";
//        log_XPathTestBase("Document [" + url + "]");
//        Object document = nav.getDocument(url);
//        XPath contextpath = new BaseXPath("/root/a/a.3", nav);
//        log_XPathTestBase("Initial Context :: " + contextpath);
//        List list = contextpath.selectNodes(document);
//        Iterator iter = list.iterator();
//        while (iter.hasNext()) {
//            Object context = iter.next();
//            assertCountXPath_XPathTestBase(2, context, "preceding-sibling::*");
//        }
//    }
//
//    public void testid54180_XPathTestBase() throws JaxenException, Exception {
//        this.contextSupport = null;
//        System.setProperty(XPathReaderFactory.DRIVER_PROPERTY, "");
//        log_XPathTestBase("-----------------------------");
//        Navigator nav = getNavigator_XPathTestBase();
//        String url = "xml/axis.xml";
//        log_XPathTestBase("Document [" + url + "]");
//        Object document = nav.getDocument(url);
//        XPath contextpath = new BaseXPath("/", nav);
//        log_XPathTestBase("Initial Context :: " + contextpath);
//        List list = contextpath.selectNodes(document);
//        Iterator iter = list.iterator();
//        while (iter.hasNext()) {
//            Object context = iter.next();
//            assertValueOfXPath_XPathTestBase("a.2", context, "name(/root/a/a.3/preceding-sibling::*[1])");
//            assertValueOfXPath_XPathTestBase("a.1", context, "name(/root/a/a.3/preceding-sibling::*[2])");
//        }
//    }
//
//    public void testid54197_XPathTestBase() throws JaxenException, Exception {
//        this.contextSupport = null;
//        System.setProperty(XPathReaderFactory.DRIVER_PROPERTY, "");
//        log_XPathTestBase("-----------------------------");
//        Navigator nav = getNavigator_XPathTestBase();
//        String url = "xml/axis.xml";
//        log_XPathTestBase("Document [" + url + "]");
//        Object document = nav.getDocument(url);
//        XPath contextpath = new BaseXPath("/", nav);
//        log_XPathTestBase("Initial Context :: " + contextpath);
//        List list = contextpath.selectNodes(document);
//        Iterator iter = list.iterator();
//        while (iter.hasNext()) {
//            Object context = iter.next();
//            assertValueOfXPath_XPathTestBase("a.4", context, "name(/root/a/a.3/following-sibling::*[1])");
//            assertValueOfXPath_XPathTestBase("a.5", context, "name(/root/a/a.3/following-sibling::*[2])");
//        }
//    }
//
//    public void testid54219_XPathTestBase() throws JaxenException, Exception {
//        this.contextSupport = null;
//        System.setProperty(XPathReaderFactory.DRIVER_PROPERTY, "");
//        log_XPathTestBase("-----------------------------");
//        Navigator nav = getNavigator_XPathTestBase();
//        String url = "xml/web.xml";
//        log_XPathTestBase("Document [" + url + "]");
//        Object document = nav.getDocument(url);
//        XPath contextpath = new BaseXPath("/", nav);
//        log_XPathTestBase("Initial Context :: " + contextpath);
//        List list = contextpath.selectNodes(document);
//        Iterator iter = list.iterator();
//        while (iter.hasNext()) {
//            Object context = iter.next();
//            assertValueOfXPath_XPathTestBase("snoop", context, "/web-app/servlet[1]/servlet-name");
//            assertValueOfXPath_XPathTestBase("snoop", context, "/web-app/servlet[1]/servlet-name/text()");
//            assertValueOfXPath_XPathTestBase("file", context, "/web-app/servlet[2]/servlet-name");
//            assertValueOfXPath_XPathTestBase("file", context, "/web-app/servlet[2]/servlet-name/text()");
//        }
//    }
//
//    public void testid54249_XPathTestBase() throws JaxenException, Exception {
//        this.contextSupport = null;
//        System.setProperty(XPathReaderFactory.DRIVER_PROPERTY, "");
//        log_XPathTestBase("-----------------------------");
//        Navigator nav = getNavigator_XPathTestBase();
//        String url = "xml/web.xml";
//        log_XPathTestBase("Document [" + url + "]");
//        Object document = nav.getDocument(url);
//        XPath contextpath = new BaseXPath("/web-app/servlet[1]", nav);
//        log_XPathTestBase("Initial Context :: " + contextpath);
//        List list = contextpath.selectNodes(document);
//        Iterator iter = list.iterator();
//        while (iter.hasNext()) {
//            Object context = iter.next();
//            assertValueOfXPath_XPathTestBase("snoop", context, "servlet-name");
//            assertValueOfXPath_XPathTestBase("snoop", context, "servlet-name/text()");
//        }
//    }
//
//    public void testid54266_XPathTestBase() throws JaxenException, Exception {
//        this.contextSupport = null;
//        System.setProperty(XPathReaderFactory.DRIVER_PROPERTY, "");
//        log_XPathTestBase("-----------------------------");
//        Navigator nav = getNavigator_XPathTestBase();
//        String url = "xml/web.xml";
//        log_XPathTestBase("Document [" + url + "]");
//        Object document = nav.getDocument(url);
//        XPath contextpath = new BaseXPath("/web-app/servlet[2]/servlet-name", nav);
//        log_XPathTestBase("Initial Context :: " + contextpath);
//        List list = contextpath.selectNodes(document);
//        Iterator iter = list.iterator();
//        while (iter.hasNext()) {
//            Object context = iter.next();
//            assertCountXPath_XPathTestBase(3, context, "preceding::*");
//        }
//    }
//
//    public void testid54278_XPathTestBase() throws JaxenException, Exception {
//        this.contextSupport = null;
//        System.setProperty(XPathReaderFactory.DRIVER_PROPERTY, "");
//        log_XPathTestBase("-----------------------------");
//        Navigator nav = getNavigator_XPathTestBase();
//        String url = "xml/web.xml";
//        log_XPathTestBase("Document [" + url + "]");
//        Object document = nav.getDocument(url);
//        XPath contextpath = new BaseXPath("/web-app/servlet[2]/servlet-name", nav);
//        log_XPathTestBase("Initial Context :: " + contextpath);
//        List list = contextpath.selectNodes(document);
//        Iterator iter = list.iterator();
//        while (iter.hasNext()) {
//            Object context = iter.next();
//            assertCountXPath_XPathTestBase(13, context, "following::*");
//        }
//    }
//
//    /**
//     *  test name
//     */
//    public void testid54298_XPathTestBase() throws JaxenException, Exception {
//        this.contextSupport = null;
//        System.setProperty(XPathReaderFactory.DRIVER_PROPERTY, "");
//        log_XPathTestBase("-----------------------------");
//        Navigator nav = getNavigator_XPathTestBase();
//        String url = "xml/web.xml";
//        log_XPathTestBase("Document [" + url + "]");
//        Object document = nav.getDocument(url);
//        XPath contextpath = new BaseXPath("/", nav);
//        log_XPathTestBase("Initial Context :: " + contextpath);
//        List list = contextpath.selectNodes(document);
//        Iterator iter = list.iterator();
//        while (iter.hasNext()) {
//            Object context = iter.next();
//            Object result = assertCountXPath2_XPathTestBase(1, context, "*");
//            assertValueOfXPath_XPathTestBase("web-app", result, "name()");
//            result = assertCountXPath2_XPathTestBase(1, context, "./*");
//            assertValueOfXPath_XPathTestBase("web-app", result, "name()");
//            result = assertCountXPath2_XPathTestBase(1, context, "child::*");
//            assertValueOfXPath_XPathTestBase("web-app", result, "name()");
//            result = assertCountXPath2_XPathTestBase(1, context, "/*");
//            assertValueOfXPath_XPathTestBase("web-app", result, "name()");
//            result = assertCountXPath2_XPathTestBase(1, context, "/child::node()");
//            assertValueOfXPath_XPathTestBase("web-app", result, "name(.)");
//            result = assertCountXPath2_XPathTestBase(1, context, "child::node()");
//            assertValueOfXPath_XPathTestBase("web-app", result, "name(.)");
//            assertValueOfXPath_XPathTestBase("", context, "name()");
//            assertValueOfXPath_XPathTestBase("", context, "name(.)");
//            assertValueOfXPath_XPathTestBase("", context, "name(parent::*)");
//            assertValueOfXPath_XPathTestBase("", context, "name(/)");
//            assertValueOfXPath_XPathTestBase("", context, "name(/.)");
//            assertValueOfXPath_XPathTestBase("", context, "name(/self::node())");
//            assertValueOfXPath_XPathTestBase("web-app", context, "name(node())");
//            assertValueOfXPath_XPathTestBase("web-app", context, "name(/node())");
//            assertValueOfXPath_XPathTestBase("web-app", context, "name(/*)");
//            assertValueOfXPath_XPathTestBase("web-app", context, "name(/child::*)");
//            assertValueOfXPath_XPathTestBase("web-app", context, "name(/child::node())");
//            assertValueOfXPath_XPathTestBase("web-app", context, "name(/child::node())");
//            assertValueOfXPath_XPathTestBase("web-app", context, "name(child::node())");
//            assertValueOfXPath_XPathTestBase("web-app", context, "name(./*)");
//            assertValueOfXPath_XPathTestBase("web-app", context, "name(*)");
//        }
//    }
//
//    public void testid54467_XPathTestBase() throws JaxenException, Exception {
//        this.contextSupport = null;
//        System.setProperty(XPathReaderFactory.DRIVER_PROPERTY, "");
//        log_XPathTestBase("-----------------------------");
//        Navigator nav = getNavigator_XPathTestBase();
//        String url = "xml/web.xml";
//        log_XPathTestBase("Document [" + url + "]");
//        Object document = nav.getDocument(url);
//        XPath contextpath = new BaseXPath("/*", nav);
//        log_XPathTestBase("Initial Context :: " + contextpath);
//        List list = contextpath.selectNodes(document);
//        Iterator iter = list.iterator();
//        while (iter.hasNext()) {
//            Object context = iter.next();
//            assertValueOfXPath_XPathTestBase("", context, "name(..)");
//            assertValueOfXPath_XPathTestBase("", context, "name(parent::node())");
//            assertValueOfXPath_XPathTestBase("", context, "name(parent::*)");
//            assertValueOfXPath_XPathTestBase("web-app", context, "name()");
//            assertValueOfXPath_XPathTestBase("web-app", context, "name(.)");
//            assertValueOfXPath_XPathTestBase("web-app", context, "name(../*)");
//            assertValueOfXPath_XPathTestBase("web-app", context, "name(../child::node())");
//        }
//    }
//
//    /** 
//     * test predicates
//     */
//    public void testid54522_XPathTestBase() throws JaxenException, Exception {
//        this.contextSupport = null;
//        System.setProperty(XPathReaderFactory.DRIVER_PROPERTY, "");
//        log_XPathTestBase("-----------------------------");
//        Navigator nav = getNavigator_XPathTestBase();
//        String url = "xml/nitf.xml";
//        log_XPathTestBase("Document [" + url + "]");
//        Object document = nav.getDocument(url);
//        XPath contextpath = new BaseXPath("/nitf/head/docdata", nav);
//        log_XPathTestBase("Initial Context :: " + contextpath);
//        List list = contextpath.selectNodes(document);
//        Iterator iter = list.iterator();
//        while (iter.hasNext()) {
//            Object context = iter.next();
//            assertCountXPath_XPathTestBase(1, context, "doc-id[@regsrc='FAKE' and @id-string='YYY']");
//        }
//    }
//
//    public void testid54534_XPathTestBase() throws JaxenException, Exception {
//        this.contextSupport = null;
//        System.setProperty(XPathReaderFactory.DRIVER_PROPERTY, "");
//        log_XPathTestBase("-----------------------------");
//        Navigator nav = getNavigator_XPathTestBase();
//        String url = "xml/nitf.xml";
//        log_XPathTestBase("Document [" + url + "]");
//        Object document = nav.getDocument(url);
//        XPath contextpath = new BaseXPath("/nitf/head", nav);
//        log_XPathTestBase("Initial Context :: " + contextpath);
//        List list = contextpath.selectNodes(document);
//        Iterator iter = list.iterator();
//        while (iter.hasNext()) {
//            Object context = iter.next();
//            assertCountXPath_XPathTestBase(1, context, "meta[@name='fake-cycle']");
//            assertCountXPath_XPathTestBase(1, context, "meta[@content='FAKE']");
//            assertCountXPath_XPathTestBase(8, context, "meta[@name and @content]");
//            assertCountXPath_XPathTestBase(1, context, "meta[@name='fake-cycle' and @content='FAKE']");
//            assertCountXPath_XPathTestBase(7, context, "meta[@name != 'fake-cycle']");
//        }
//    }
//
//    public void testid54570_XPathTestBase() throws JaxenException, Exception {
//        this.contextSupport = null;
//        System.setProperty(XPathReaderFactory.DRIVER_PROPERTY, "");
//        log_XPathTestBase("-----------------------------");
//        Navigator nav = getNavigator_XPathTestBase();
//        String url = "xml/nitf.xml";
//        log_XPathTestBase("Document [" + url + "]");
//        Object document = nav.getDocument(url);
//        XPath contextpath = new BaseXPath("/", nav);
//        log_XPathTestBase("Initial Context :: " + contextpath);
//        List list = contextpath.selectNodes(document);
//        Iterator iter = list.iterator();
//        while (iter.hasNext()) {
//            Object context = iter.next();
//            assertCountXPath_XPathTestBase(1, context, "/nitf/head/meta[@name='fake-cycle']");
//            assertCountXPath_XPathTestBase(1, context, "/nitf/head/meta[@content='FAKE']");
//            assertCountXPath_XPathTestBase(8, context, "/nitf/head/meta[@name and @content]");
//            assertCountXPath_XPathTestBase(1, context, "/nitf/head/meta[@name='fake-cycle' and @content='FAKE']");
//            assertCountXPath_XPathTestBase(7, context, "/nitf/head/meta[@name != 'fake-cycle']");
//        }
//    }
//
//    public void testid54614_XPathTestBase() throws JaxenException, Exception {
//        this.contextSupport = null;
//        System.setProperty(XPathReaderFactory.DRIVER_PROPERTY, "");
//        log_XPathTestBase("-----------------------------");
//        Navigator nav = getNavigator_XPathTestBase();
//        String url = "xml/moreover.xml";
//        log_XPathTestBase("Document [" + url + "]");
//        Object document = nav.getDocument(url);
//        XPath contextpath = new BaseXPath("/", nav);
//        log_XPathTestBase("Initial Context :: " + contextpath);
//        List list = contextpath.selectNodes(document);
//        Iterator iter = list.iterator();
//        while (iter.hasNext()) {
//            Object context = iter.next();
//            assertCountXPath_XPathTestBase(1, context, "/child::node()");
//            assertCountXPath_XPathTestBase(1, context, "/*");
//            assertCountXPath_XPathTestBase(20, context, "/*/article");
//            assertCountXPath_XPathTestBase(221, context, "//*");
//            assertCountXPath_XPathTestBase(20, context, "//*[local-name()='article']");
//            assertCountXPath_XPathTestBase(20, context, "//article");
//            assertCountXPath_XPathTestBase(20, context, "/*/*[@code]");
//            assertCountXPath_XPathTestBase(1, context, "/moreovernews/article[@code='13563275']");
//            DOMXPath xpath = new DOMXPath("/moreovernews/article[@code='13563275']");
//            List results = xpath.selectNodes(getContext_XPathTestBase(context));
//            Object result = results.get(0);
//            assertValueOfXPath_XPathTestBase("http://c.moreover.com/click/here.pl?x13563273", result, "url");
//            xpath = new DOMXPath("/*/article[@code='13563275']");
//            results = xpath.selectNodes(getContext_XPathTestBase(context));
//            result = results.get(0);
//            assertValueOfXPath_XPathTestBase("http://c.moreover.com/click/here.pl?x13563273", result, "url");
//            xpath = new DOMXPath("//article[@code='13563275']");
//            results = xpath.selectNodes(getContext_XPathTestBase(context));
//            result = results.get(0);
//            assertValueOfXPath_XPathTestBase("http://c.moreover.com/click/here.pl?x13563273", result, "url");
//            xpath = new DOMXPath("//*[@code='13563275']");
//            results = xpath.selectNodes(getContext_XPathTestBase(context));
//            result = results.get(0);
//            assertValueOfXPath_XPathTestBase("http://c.moreover.com/click/here.pl?x13563273", result, "url");
//            xpath = new DOMXPath("/child::node()/child::node()[@code='13563275']");
//            results = xpath.selectNodes(getContext_XPathTestBase(context));
//            result = results.get(0);
//            assertValueOfXPath_XPathTestBase("http://c.moreover.com/click/here.pl?x13563273", result, "url");
//            xpath = new DOMXPath("/*/*[@code='13563275']");
//            results = xpath.selectNodes(getContext_XPathTestBase(context));
//            result = results.get(0);
//            assertValueOfXPath_XPathTestBase("http://c.moreover.com/click/here.pl?x13563273", result, "url");
//        }
//    }
//
//    /** 
//     * test other node types
//     */
//    public void testNodeTypes_XPathTestBase() throws JaxenException, Exception {
//        this.contextSupport = null;
//        System.setProperty(XPathReaderFactory.DRIVER_PROPERTY, "");
//        log_XPathTestBase("-----------------------------");
//        Navigator nav = getNavigator_XPathTestBase();
//        String url = "xml/contents.xml";
//        log_XPathTestBase("Document [" + url + "]");
//        Object document = nav.getDocument(url);
//        XPath contextpath = new BaseXPath("/", nav);
//        log_XPathTestBase("Initial Context :: " + contextpath);
//        List list = contextpath.selectNodes(document);
//        Iterator iter = list.iterator();
//        while (iter.hasNext()) {
//            Object context = iter.next();
//            assertCountXPath_XPathTestBase(3, context, "processing-instruction()");
//            assertCountXPath_XPathTestBase(3, context, "/processing-instruction()");
//            assertCountXPath_XPathTestBase(1, context, "/comment()");
//            assertCountXPath_XPathTestBase(1, context, "comment()");
//            assertCountXPath_XPathTestBase(2, context, "/child::node()/comment()");
//            assertCountXPath_XPathTestBase(2, context, "/*/comment()");
//            assertCountXPath_XPathTestBase(3, context, "//comment()");
//        }
//    }
//
//    /** 
//     * test positioning
//     */
//    public void testPositioning_XPathTestBase() throws JaxenException, Exception {
//        this.contextSupport = null;
//        System.setProperty(XPathReaderFactory.DRIVER_PROPERTY, "");
//        log_XPathTestBase("-----------------------------");
//        Navigator nav = getNavigator_XPathTestBase();
//        String url = "xml/fibo.xml";
//        log_XPathTestBase("Document [" + url + "]");
//        Object document = nav.getDocument(url);
//        XPath contextpath = new BaseXPath("/", nav);
//        log_XPathTestBase("Initial Context :: " + contextpath);
//        List list = contextpath.selectNodes(document);
//        Iterator iter = list.iterator();
//        while (iter.hasNext()) {
//            Object context = iter.next();
//            assertCountXPath_XPathTestBase(9, context, "/*/fibonacci[position() < 10]");
//            assertValueOfXPath_XPathTestBase("196417", context, "sum(//fibonacci)");
//            assertValueOfXPath_XPathTestBase("325", context, "sum(//fibonacci/@index)");
//            assertValueOfXPath_XPathTestBase("1", context, "/*/fibonacci[2]");
//            assertValueOfXPath_XPathTestBase("75025", context, "/*/fibonacci[ count(/*/fibonacci) ]");
//            assertValueOfXPath_XPathTestBase("46368", context, "/*/fibonacci[ count(/*/fibonacci) - 1 ]");
//        }
//    }
//
//    public void testid54853_XPathTestBase() throws JaxenException, Exception {
//        this.contextSupport = null;
//        System.setProperty(XPathReaderFactory.DRIVER_PROPERTY, "");
//        log_XPathTestBase("-----------------------------");
//        Navigator nav = getNavigator_XPathTestBase();
//        String url = "xml/web.xml";
//        log_XPathTestBase("Document [" + url + "]");
//        Object document = nav.getDocument(url);
//        XPath contextpath = new BaseXPath("/", nav);
//        log_XPathTestBase("Initial Context :: " + contextpath);
//        List list = contextpath.selectNodes(document);
//        Iterator iter = list.iterator();
//        while (iter.hasNext()) {
//            Object context = iter.next();
//            assertCountXPath_XPathTestBase(19, context, "descendant-or-self::*");
//            assertCountXPath_XPathTestBase(19, context, "descendant::*");
//            assertCountXPath_XPathTestBase(19, context, "/descendant::*");
//            assertCountXPath_XPathTestBase(19, context, "/descendant-or-self::*");
//            assertCountXPath_XPathTestBase(2, context, "/descendant::servlet");
//            assertCountXPath_XPathTestBase(2, context, "/descendant-or-self::servlet");
//            assertCountXPath_XPathTestBase(2, context, "descendant-or-self::servlet");
//            assertCountXPath_XPathTestBase(2, context, "descendant::servlet");
//            assertCountXPath_XPathTestBase(2, context, "/*/servlet");
//            assertValueOfXPath_XPathTestBase("2", context, "count(/*/servlet)");
//            assertCountXPath_XPathTestBase(2, context, "//servlet");
//            assertValueOfXPath_XPathTestBase("2", context, "count(//servlet)");
//        }
//    }
//
//    public void testid54932_XPathTestBase() throws JaxenException, Exception {
//        this.contextSupport = null;
//        System.setProperty(XPathReaderFactory.DRIVER_PROPERTY, "");
//        log_XPathTestBase("-----------------------------");
//        Navigator nav = getNavigator_XPathTestBase();
//        String url = "xml/web.xml";
//        log_XPathTestBase("Document [" + url + "]");
//        Object document = nav.getDocument(url);
//        XPath contextpath = new BaseXPath("/web-app", nav);
//        log_XPathTestBase("Initial Context :: " + contextpath);
//        List list = contextpath.selectNodes(document);
//        Iterator iter = list.iterator();
//        while (iter.hasNext()) {
//            Object context = iter.next();
//            assertCountXPath_XPathTestBase(2, context, "/descendant::servlet");
//            assertCountXPath_XPathTestBase(2, context, "/descendant-or-self::servlet");
//            assertCountXPath_XPathTestBase(2, context, "descendant-or-self::servlet");
//            assertCountXPath_XPathTestBase(2, context, "descendant::servlet");
//        }
//    }
//
//    public void testCountFunction_XPathTestBase() throws JaxenException, Exception {
//        this.contextSupport = null;
//        System.setProperty(XPathReaderFactory.DRIVER_PROPERTY, "");
//        log_XPathTestBase("-----------------------------");
//        Navigator nav = getNavigator_XPathTestBase();
//        String url = "xml/much_ado.xml";
//        log_XPathTestBase("Document [" + url + "]");
//        Object document = nav.getDocument(url);
//        XPath contextpath = new BaseXPath("/", nav);
//        log_XPathTestBase("Initial Context :: " + contextpath);
//        List list = contextpath.selectNodes(document);
//        Iterator iter = list.iterator();
//        while (iter.hasNext()) {
//            Object context = iter.next();
//            assertCountXPath_XPathTestBase(5, context, "/descendant::ACT");
//            assertCountXPath_XPathTestBase(5, context, "descendant::ACT");
//            assertValueOfXPath_XPathTestBase("Much Ado about Nothing", context, "/PLAY/TITLE");
//            assertValueOfXPath_XPathTestBase("4", context, "2+2");
//            assertValueOfXPath_XPathTestBase("21", context, "5 * 4 + 1");
//            assertValueOfXPath_XPathTestBase("5", context, "count(descendant::ACT)");
//            assertValueOfXPath_XPathTestBase("35", context, "10 + count(descendant::ACT) * 5");
//            assertValueOfXPath_XPathTestBase("75", context, "(10 + count(descendant::ACT)) * 5");
//        }
//    }
//
//    public void testCountFunctionMore_XPathTestBase() throws JaxenException, Exception {
//        this.contextSupport = null;
//        System.setProperty(XPathReaderFactory.DRIVER_PROPERTY, "");
//        log_XPathTestBase("-----------------------------");
//        Navigator nav = getNavigator_XPathTestBase();
//        String url = "xml/much_ado.xml";
//        log_XPathTestBase("Document [" + url + "]");
//        Object document = nav.getDocument(url);
//        XPath contextpath = new BaseXPath("/PLAY/ACT[2]/SCENE[1]", nav);
//        log_XPathTestBase("Initial Context :: " + contextpath);
//        List list = contextpath.selectNodes(document);
//        Iterator iter = list.iterator();
//        while (iter.hasNext()) {
//            Object context = iter.next();
//            assertCountXPath_XPathTestBase(5, context, "/descendant::ACT");
//            assertCountXPath_XPathTestBase(5, context, "../../descendant::ACT");
//            assertCountXPath_XPathTestBase(141, context, "/PLAY/ACT[2]/SCENE[1]/descendant::SPEAKER");
//            assertCountXPath_XPathTestBase(141, context, "descendant::SPEAKER");
//            assertValueOfXPath_XPathTestBase("646", context, "count(descendant::*)+1");
//            assertValueOfXPath_XPathTestBase("142", context, "count(descendant::SPEAKER)+1");
//            assertValueOfXPath_XPathTestBase("2", context, "count(ancestor::*)");
//            assertValueOfXPath_XPathTestBase("1", context, "count(ancestor::PLAY)");
//            assertValueOfXPath_XPathTestBase("3", context, "count(ancestor-or-self::*)");
//            assertValueOfXPath_XPathTestBase("1", context, "count(ancestor-or-self::PLAY)");
//            assertValueOfXPath_XPathTestBase("6", context, "5+count(ancestor::*)-1");
//        }
//    }
//
//    public void testCorrectPredicateApplication_XPathTestBase() throws JaxenException, Exception {
//        this.contextSupport = null;
//        System.setProperty(XPathReaderFactory.DRIVER_PROPERTY, "");
//        log_XPathTestBase("-----------------------------");
//        Navigator nav = getNavigator_XPathTestBase();
//        String url = "xml/much_ado.xml";
//        log_XPathTestBase("Document [" + url + "]");
//        Object document = nav.getDocument(url);
//        XPath contextpath = new BaseXPath("/", nav);
//        log_XPathTestBase("Initial Context :: " + contextpath);
//        List list = contextpath.selectNodes(document);
//        Iterator iter = list.iterator();
//        while (iter.hasNext()) {
//            Object context = iter.next();
//            assertValueOfXPath_XPathTestBase("5", context, "count(/PLAY/ACT/SCENE[1])");
//        }
//    }
//
//    /** test axis node ordering
//    */
//    public void testAxisNodeOrdering_XPathTestBase() throws JaxenException, Exception {
//        this.contextSupport = null;
//        System.setProperty(XPathReaderFactory.DRIVER_PROPERTY, "");
//        log_XPathTestBase("-----------------------------");
//        Navigator nav = getNavigator_XPathTestBase();
//        String url = "xml/web.xml";
//        log_XPathTestBase("Document [" + url + "]");
//        Object document = nav.getDocument(url);
//        XPath contextpath = new BaseXPath("/", nav);
//        log_XPathTestBase("Initial Context :: " + contextpath);
//        List list = contextpath.selectNodes(document);
//        Iterator iter = list.iterator();
//        while (iter.hasNext()) {
//            Object context = iter.next();
//            assertCountXPath_XPathTestBase(1, context, "//servlet-mapping/preceding::*[1][name()='description']");
//            assertCountXPath_XPathTestBase(1, context, "/web-app/servlet//description/following::*[1][name()='servlet-mapping']");
//            assertCountXPath_XPathTestBase(1, context, "/web-app/servlet//description/following::*[2][name()='servlet-name']");
//        }
//    }
//
//    /** 
//     * test document function
//     */
//    public void testDocumentFunction1_XPathTestBase() throws JaxenException, Exception {
//        this.contextSupport = null;
//        System.setProperty(XPathReaderFactory.DRIVER_PROPERTY, "");
//        log_XPathTestBase("-----------------------------");
//        Navigator nav = getNavigator_XPathTestBase();
//        String url = "xml/text.xml";
//        log_XPathTestBase("Document [" + url + "]");
//        Object document = nav.getDocument(url);
//        XPath contextpath = new BaseXPath("/", nav);
//        log_XPathTestBase("Initial Context :: " + contextpath);
//        List list = contextpath.selectNodes(document);
//        Iterator iter = list.iterator();
//        while (iter.hasNext()) {
//            Object context = iter.next();
//            Object result = assertCountXPath2_XPathTestBase(1, context, "document('xml/web.xml')");
//            assertValueOfXPath_XPathTestBase("snoop", result, "/web-app/servlet[1]/servlet-name");
//            assertValueOfXPath_XPathTestBase("snoop", result, "/web-app/servlet[1]/servlet-name/text()");
//            assertValueOfXPath_XPathTestBase("snoop", context, "document('xml/web.xml')/web-app/servlet[1]/servlet-name");
//        }
//    }
//
//    /** 
//     * Test to check if the context changes when an extension function is used.
//     * First test is an example, second is the actual test.
//     */
//    public void testDocumentFunctionContextExample_XPathTestBase() throws JaxenException, Exception {
//        this.contextSupport = null;
//        System.setProperty(XPathReaderFactory.DRIVER_PROPERTY, "");
//        log_XPathTestBase("-----------------------------");
//        Navigator nav = getNavigator_XPathTestBase();
//        String url = "xml/text.xml";
//        log_XPathTestBase("Document [" + url + "]");
//        Object document = nav.getDocument(url);
//        XPath contextpath = new BaseXPath("/foo/bar/cheese[1]", nav);
//        log_XPathTestBase("Initial Context :: " + contextpath);
//        List list = contextpath.selectNodes(document);
//        Iterator iter = list.iterator();
//        while (iter.hasNext()) {
//            Object context = iter.next();
//            assertValueOfXPath_XPathTestBase("3foo3", context, "concat(./@id,'foo',@id)");
//            assertValueOfXPath_XPathTestBase("3snoop3", context, "concat(./@id,document('xml/web.xml')/web-app/servlet[1]/servlet-name,./@id)");
//        }
//    }
//
//    public void testDocumentFunctionActual_XPathTestBase() throws JaxenException, Exception {
//        this.contextSupport = null;
//        System.setProperty(XPathReaderFactory.DRIVER_PROPERTY, "");
//        log_XPathTestBase("-----------------------------");
//        Navigator nav = getNavigator_XPathTestBase();
//        String url = "xml/message.xml";
//        log_XPathTestBase("Document [" + url + "]");
//        Object document = nav.getDocument(url);
//        XPath contextpath = new BaseXPath("/", nav);
//        log_XPathTestBase("Initial Context :: " + contextpath);
//        List list = contextpath.selectNodes(document);
//        Iterator iter = list.iterator();
//        while (iter.hasNext()) {
//            Object context = iter.next();
//            assertValueOfXPath_XPathTestBase("Pruefgebiete", context, "/message/body/data/items/item[name/text()='parentinfo']/value");
//            assertValueOfXPath_XPathTestBase("Pruefgebiete", context, "document('xml/message.xml')/message/body/data/items/item[name/text()='parentinfo']/value");
//        }
//    }
//
//    /** 
//     * test behavior of AbsoluteLocationPath
//     */
//    public void testAbsoluteLocationPaths_XPathTestBase() throws JaxenException, Exception {
//        this.contextSupport = null;
//        System.setProperty(XPathReaderFactory.DRIVER_PROPERTY, "");
//        log_XPathTestBase("-----------------------------");
//        Navigator nav = getNavigator_XPathTestBase();
//        String url = "xml/simple.xml";
//        log_XPathTestBase("Document [" + url + "]");
//        Object document = nav.getDocument(url);
//        XPath contextpath = new BaseXPath("/root/a", nav);
//        log_XPathTestBase("Initial Context :: " + contextpath);
//        List list = contextpath.selectNodes(document);
//        Iterator iter = list.iterator();
//        while (iter.hasNext()) {
//            Object context = iter.next();
//            assertValueOfXPath_XPathTestBase("ab", context, "concat( ., /root/b )");
//            assertValueOfXPath_XPathTestBase("ba", context, "concat( ../b, . )");
//            assertValueOfXPath_XPathTestBase("ba", context, "concat( /root/b, . )");
//            assertValueOfXPath_XPathTestBase("db", context, "concat( /root/c/d, ../b )");
//        }
//    }
//
//    /** 
//     * test the translate() function
//     */
//    public void testTranslateFunction_XPathTestBase() throws JaxenException, Exception {
//        this.contextSupport = null;
//        System.setProperty(XPathReaderFactory.DRIVER_PROPERTY, "");
//        log_XPathTestBase("-----------------------------");
//        Navigator nav = getNavigator_XPathTestBase();
//        String url = "xml/simple.xml";
//        log_XPathTestBase("Document [" + url + "]");
//        Object document = nav.getDocument(url);
//        XPath contextpath = new BaseXPath("/", nav);
//        log_XPathTestBase("Initial Context :: " + contextpath);
//        List list = contextpath.selectNodes(document);
//        Iterator iter = list.iterator();
//        while (iter.hasNext()) {
//            Object context = iter.next();
//            assertValueOfXPath_XPathTestBase("", context, "translate( '', '', '' )");
//            assertValueOfXPath_XPathTestBase("abcd", context, "translate( 'abcd', '', '' )");
//            assertValueOfXPath_XPathTestBase("abcd", context, "translate( 'abcd', 'abcd', 'abcd' )");
//            assertValueOfXPath_XPathTestBase("abcd", context, "translate( 'abcd', 'dcba', 'dcba' )");
//            assertValueOfXPath_XPathTestBase("dcba", context, "translate( 'abcd', 'abcd', 'dcba' )");
//            assertValueOfXPath_XPathTestBase("ab", context, "translate( 'abcd', 'abcd', 'ab' )");
//            assertValueOfXPath_XPathTestBase("cd", context, "translate( 'abcd', 'cdab', 'cd' )");
//            assertValueOfXPath_XPathTestBase("xy", context, "translate( 'abcd', 'acbd', 'xy' )");
//            assertValueOfXPath_XPathTestBase("abcd", context, "translate( 'abcd', 'abcdb', 'abcdb' )");
//            assertValueOfXPath_XPathTestBase("abcd", context, "translate( 'abcd', 'abcd', 'abcdb' )");
//        }
//    }
//
//    public void testSubstringFunction_XPathTestBase() throws JaxenException, Exception {
//        this.contextSupport = null;
//        System.setProperty(XPathReaderFactory.DRIVER_PROPERTY, "");
//        log_XPathTestBase("-----------------------------");
//        Navigator nav = getNavigator_XPathTestBase();
//        String url = "xml/simple.xml";
//        log_XPathTestBase("Document [" + url + "]");
//        Object document = nav.getDocument(url);
//        XPath contextpath = new BaseXPath("/", nav);
//        log_XPathTestBase("Initial Context :: " + contextpath);
//        List list = contextpath.selectNodes(document);
//        Iterator iter = list.iterator();
//        while (iter.hasNext()) {
//            Object context = iter.next();
//            assertValueOfXPath_XPathTestBase("234", context, "substring('12345', 1.5, 2.6)");
//            assertValueOfXPath_XPathTestBase("12", context, "substring('12345', 0, 3)");
//            assertValueOfXPath_XPathTestBase("", context, "substring('12345', 0 div 0, 3)");
//            assertValueOfXPath_XPathTestBase("", context, "substring('12345', 1, 0 div 0)");
//            assertValueOfXPath_XPathTestBase("12345", context, "substring('12345', -42, 1 div 0)");
//            assertValueOfXPath_XPathTestBase("", context, "substring('12345', -1 div 0, 1 div 0)");
//            assertValueOfXPath_XPathTestBase("345", context, "substring('12345', 3)");
//            assertValueOfXPath_XPathTestBase("12345", context, "substring('12345',1,15)");
//        }
//    }
//
//    /** 
//     * Some tests for the normalize-space() function
//     */
//    public void testNormalizeSpaceFunction_XPathTestBase() throws JaxenException, Exception {
//        this.contextSupport = null;
//        System.setProperty(XPathReaderFactory.DRIVER_PROPERTY, "");
//        log_XPathTestBase("-----------------------------");
//        Navigator nav = getNavigator_XPathTestBase();
//        String url = "xml/simple.xml";
//        log_XPathTestBase("Document [" + url + "]");
//        Object document = nav.getDocument(url);
//        XPath contextpath = new BaseXPath("/", nav);
//        log_XPathTestBase("Initial Context :: " + contextpath);
//        List list = contextpath.selectNodes(document);
//        Iterator iter = list.iterator();
//        while (iter.hasNext()) {
//            Object context = iter.next();
//            assertValueOfXPath_XPathTestBase("abc", context, "normalize-space('    abc    ')");
//            assertValueOfXPath_XPathTestBase("a b c", context, "normalize-space(' a  b  c  ')");
//            assertValueOfXPath_XPathTestBase("a b c", context, "normalize-space(' a \n b \n  c')");
//            assertValueOfXPath_XPathTestBase("", context, "normalize-space(' ')");
//            assertValueOfXPath_XPathTestBase("", context, "normalize-space('')");
//        }
//    }
//
//    /** 
//     * test cases for String extension functions
//     */
//    public void testStringExtensionFunctions_XPathTestBase() throws JaxenException, Exception {
//        this.contextSupport = null;
//        System.setProperty(XPathReaderFactory.DRIVER_PROPERTY, "");
//        log_XPathTestBase("-----------------------------");
//        Navigator nav = getNavigator_XPathTestBase();
//        String url = "xml/web.xml";
//        log_XPathTestBase("Document [" + url + "]");
//        Object document = nav.getDocument(url);
//        XPath contextpath = new BaseXPath("/web-app/servlet[1]", nav);
//        log_XPathTestBase("Initial Context :: " + contextpath);
//        List list = contextpath.selectNodes(document);
//        Iterator iter = list.iterator();
//        while (iter.hasNext()) {
//            Object context = iter.next();
//            assertValueOfXPath_XPathTestBase("SNOOPSERVLET", context, "upper-case( servlet-class )");
//            assertValueOfXPath_XPathTestBase("snoopservlet", context, "lower-case( servlet-class )");
//            assertValueOfXPath_XPathTestBase("SNOOPSERVLET", context, "upper-case( servlet-class, 'fr' )");
//            assertValueOfXPath_XPathTestBase("SNOOPSERVLET", context, "upper-case( servlet-class, 'fr-CA' )");
//            assertValueOfXPath_XPathTestBase("SNOOPSERVLET", context, "upper-case( servlet-class, 'es-ES-Traditional_WIN' )");
//            assertValueOfXPath_XPathTestBase("true", context, "ends-with( servlet-class, 'Servlet' )");
//            assertValueOfXPath_XPathTestBase("false", context, "ends-with( servlet-class, 'S' )");
//        }
//    }
//
//    /** 
//     * test cases for the lang() function
//     */
//    public void testLangFunction_XPathTestBase() throws JaxenException, Exception {
//        this.contextSupport = null;
//        System.setProperty(XPathReaderFactory.DRIVER_PROPERTY, "");
//        log_XPathTestBase("-----------------------------");
//        Navigator nav = getNavigator_XPathTestBase();
//        String url = "xml/lang.xml";
//        log_XPathTestBase("Document [" + url + "]");
//        Object document = nav.getDocument(url);
//        XPath contextpath = new BaseXPath("/", nav);
//        log_XPathTestBase("Initial Context :: " + contextpath);
//        List list = contextpath.selectNodes(document);
//        Iterator iter = list.iterator();
//        while (iter.hasNext()) {
//            Object context = iter.next();
//            assertCountXPath_XPathTestBase(0, context, "/e1/e2[lang('hr')]");
//            assertCountXPath_XPathTestBase(1, context, "/e1/e2/e3[lang('en')]");
//            assertCountXPath_XPathTestBase(1, context, "/e1/e2/e3[lang('en-US')]");
//            assertCountXPath_XPathTestBase(0, context, "/e1/e2/e3[lang('en-GB')]");
//            assertCountXPath_XPathTestBase(2, context, "/e1/e2/e3[lang('hu')]");
//            assertCountXPath_XPathTestBase(0, context, "/e1/e2/e3[lang('hu-HU')]");
//            assertCountXPath_XPathTestBase(1, context, "/e1/e2/e3[lang('es')]");
//            assertCountXPath_XPathTestBase(0, context, "/e1/e2/e3[lang('es-BR')]");
//        }
//    }
//
//    /** 
//     * test namespace
//     */
//    public void testNamespacesAgain_XPathTestBase() throws JaxenException, Exception {
//        this.contextSupport = null;
//        System.setProperty(XPathReaderFactory.DRIVER_PROPERTY, "");
//        log_XPathTestBase("-----------------------------");
//        Navigator nav = getNavigator_XPathTestBase();
//        String url = "xml/namespaces.xml";
//        log_XPathTestBase("Document [" + url + "]");
//        Object document = nav.getDocument(url);
//        XPath contextpath = new BaseXPath("/", nav);
//        log_XPathTestBase("Initial Context :: " + contextpath);
//        List list = contextpath.selectNodes(document);
//        SimpleNamespaceContext nsContext = new SimpleNamespaceContext();
//        nsContext.addNamespace("alias", "http://fooNamespace/");
//        nsContext.addNamespace("bar", "http://barNamespace/");
//        nsContext.addNamespace("voo", "http://fooNamespace/");
//        nsContext.addNamespace("foo", "http://fooNamespace/");
//        getContextSupport_XPathTestBase().setNamespaceContext(nsContext);
//        Iterator iter = list.iterator();
//        while (iter.hasNext()) {
//            Object context = iter.next();
//            assertCountXPath_XPathTestBase(1, context, "/*");
//            assertCountXPath_XPathTestBase(1, context, "/foo:a");
//            assertCountXPath_XPathTestBase(1, context, "/foo:a/b");
//            assertCountXPath_XPathTestBase(1, context, "/voo:a/b/c");
//            assertCountXPath_XPathTestBase(1, context, "/voo:a/bar:f");
//            assertCountXPath_XPathTestBase(1, context, "/*[namespace-uri()='http://fooNamespace/' and local-name()='a']");
//            assertCountXPath_XPathTestBase(1, context, "/*[local-name()='a' and namespace-uri()='http://fooNamespace/']/*[local-name()='x' and namespace-uri()='http://fooNamespace/']");
//            assertCountXPath_XPathTestBase(1, context, "/*[local-name()='a' and namespace-uri()='http://fooNamespace/']/*[local-name()='x' and namespace-uri()='http://fooNamespace/']/*[local-name()='y' and namespace-uri()='http://fooNamespace/']");
//        }
//    }
//
//    /** 
//     * the prefix here and in the document have no relation; it's their
//     * namespace-uri binding that counts 
//     */
//    public void testPrefixDoesntMatter_XPathTestBase() throws JaxenException, Exception {
//        this.contextSupport = null;
//        System.setProperty(XPathReaderFactory.DRIVER_PROPERTY, "");
//        log_XPathTestBase("-----------------------------");
//        Navigator nav = getNavigator_XPathTestBase();
//        String url = "xml/namespaces.xml";
//        log_XPathTestBase("Document [" + url + "]");
//        Object document = nav.getDocument(url);
//        XPath contextpath = new BaseXPath("/", nav);
//        log_XPathTestBase("Initial Context :: " + contextpath);
//        List list = contextpath.selectNodes(document);
//        SimpleNamespaceContext nsContext = new SimpleNamespaceContext();
//        nsContext.addNamespace("foo", "http://somethingElse/");
//        getContextSupport_XPathTestBase().setNamespaceContext(nsContext);
//        Iterator iter = list.iterator();
//        while (iter.hasNext()) {
//            Object context = iter.next();
//            assertCountXPath_XPathTestBase(0, context, "/foo:a/b/c");
//        }
//    }
//
//    /** Jaxen-67, affects Jelly and Maven */
//    public void testCDATASectionsAreIncludedInTextNodes_XPathTestBase() throws JaxenException, Exception {
//        this.contextSupport = null;
//        System.setProperty(XPathReaderFactory.DRIVER_PROPERTY, "");
//        log_XPathTestBase("-----------------------------");
//        Navigator nav = getNavigator_XPathTestBase();
//        String url = "xml/cdata.xml";
//        log_XPathTestBase("Document [" + url + "]");
//        Object document = nav.getDocument(url);
//        XPath contextPath = new BaseXPath("/p/text()", nav);
//        log_XPathTestBase("Initial Context :: " + contextPath);
//        List list = contextPath.selectNodes(document);
//        StringBuffer buffer = new StringBuffer(10);
//        Iterator iterator = list.iterator();
//        while (iterator.hasNext()) {
//            buffer.append(StringFunction.evaluate(iterator.next(), nav));
//        }
//        assertEquals("awhateverb", buffer.toString());
//    }
//
//    public void testNamespaces_XPathTestBase() throws JaxenException, Exception {
//        this.contextSupport = null;
//        System.setProperty(XPathReaderFactory.DRIVER_PROPERTY, "");
//        log_XPathTestBase("-----------------------------");
//        Navigator nav = getNavigator_XPathTestBase();
//        String url = "xml/namespaces.xml";
//        log_XPathTestBase("Document [" + url + "]");
//        Object document = nav.getDocument(url);
//        XPath contextpath = new BaseXPath("/", nav);
//        log_XPathTestBase("Initial Context :: " + contextpath);
//        List list = contextpath.selectNodes(document);
//        SimpleNamespaceContext nsContext = new SimpleNamespaceContext();
//        nsContext.addNamespace("alias", "http://fooNamespace/");
//        nsContext.addNamespace("bar", "http://barNamespace/");
//        nsContext.addNamespace("foo", "http://fooNamespace/");
//        getContextSupport_XPathTestBase().setNamespaceContext(nsContext);
//        Iterator iter = list.iterator();
//        while (iter.hasNext()) {
//            Object context = iter.next();
//            assertValueOfXPath_XPathTestBase("Hello", context, "/foo:a/b/c");
//            assertValueOfXPath_XPathTestBase("Hey", context, "/foo:a/foo:d/foo:e");
//            assertValueOfXPath_XPathTestBase("Hey3", context, "/foo:a/alias:x/alias:y");
//            assertValueOfXPath_XPathTestBase("Hey3", context, "/foo:a/foo:x/foo:y");
//            assertValueOfXPath_XPathTestBase("Hey3", context, "/*[local-name()='a' and namespace-uri()='http://fooNamespace/']/*[local-name()='x' and namespace-uri()='http://fooNamespace/']/*[local-name()='y' and namespace-uri()='http://fooNamespace/']");
//        }
//    }
//
//    public void testNoNamespace_XPathTestBase() throws JaxenException, Exception {
//        this.contextSupport = null;
//        System.setProperty(XPathReaderFactory.DRIVER_PROPERTY, "");
//        log_XPathTestBase("-----------------------------");
//        Navigator nav = getNavigator_XPathTestBase();
//        String url = "xml/defaultNamespace.xml";
//        log_XPathTestBase("Document [" + url + "]");
//        Object document = nav.getDocument(url);
//        XPath contextpath = new BaseXPath("/", nav);
//        log_XPathTestBase("Initial Context :: " + contextpath);
//        List list = contextpath.selectNodes(document);
//        Iterator iter = list.iterator();
//        while (iter.hasNext()) {
//            Object context = iter.next();
//            assertCountXPath_XPathTestBase(0, context, "/a/b/c");
//        }
//    }
//
//    public void testNamespaceResolution_XPathTestBase() throws JaxenException, Exception {
//        this.contextSupport = null;
//        System.setProperty(XPathReaderFactory.DRIVER_PROPERTY, "");
//        log_XPathTestBase("-----------------------------");
//        Navigator nav = getNavigator_XPathTestBase();
//        String url = "xml/defaultNamespace.xml";
//        log_XPathTestBase("Document [" + url + "]");
//        Object document = nav.getDocument(url);
//        XPath contextpath = new BaseXPath("/", nav);
//        log_XPathTestBase("Initial Context :: " + contextpath);
//        List list = contextpath.selectNodes(document);
//        SimpleNamespaceContext nsContext = new SimpleNamespaceContext();
//        nsContext.addNamespace("dummy", "http://dummyNamespace/");
//        getContextSupport_XPathTestBase().setNamespaceContext(nsContext);
//        Iterator iter = list.iterator();
//        while (iter.hasNext()) {
//            Object context = iter.next();
//            assertCountXPath_XPathTestBase(1, context, "/dummy:a/dummy:b/dummy:c");
//        }
//    }
//
//    public void testTextNodes_XPathTestBase() throws JaxenException, Exception {
//        this.contextSupport = null;
//        System.setProperty(XPathReaderFactory.DRIVER_PROPERTY, "");
//        log_XPathTestBase("-----------------------------");
//        Navigator nav = getNavigator_XPathTestBase();
//        String url = "xml/text.xml";
//        log_XPathTestBase("Document [" + url + "]");
//        Object document = nav.getDocument(url);
//        XPath contextpath = new BaseXPath("/", nav);
//        log_XPathTestBase("Initial Context :: " + contextpath);
//        List list = contextpath.selectNodes(document);
//        Iterator iter = list.iterator();
//        while (iter.hasNext()) {
//            Object context = iter.next();
//            assertCountXPath_XPathTestBase(3, context, "/foo/bar/text()");
//            assertValueOfXPath_XPathTestBase("baz", context, "normalize-space(/foo/bar/text())");
//        }
//    }
//
//    public void testNamespaceNodeCounts1_XPathTestBase() throws JaxenException, Exception {
//        this.contextSupport = null;
//        System.setProperty(XPathReaderFactory.DRIVER_PROPERTY, "");
//        log_XPathTestBase("-----------------------------");
//        Navigator nav = getNavigator_XPathTestBase();
//        String url = "xml/testNamespaces.xml";
//        log_XPathTestBase("Document [" + url + "]");
//        Object document = nav.getDocument(url);
//        XPath contextpath = new BaseXPath("/", nav);
//        log_XPathTestBase("Initial Context :: " + contextpath);
//        List list = contextpath.selectNodes(document);
//        Iterator iter = list.iterator();
//        while (iter.hasNext()) {
//            Object context = iter.next();
//            assertCountXPath_XPathTestBase(0, context, "namespace::*");
//            assertCountXPath_XPathTestBase(0, context, "/namespace::*");
//            assertCountXPath_XPathTestBase(3, context, "/Template/Application1/namespace::*");
//            assertCountXPath_XPathTestBase(3, context, "/Template/Application2/namespace::*");
//            assertCountXPath_XPathTestBase(25, context, "//namespace::*");
//        }
//    }
//
//    public void testNamespaceNodeCounts_XPathTestBase() throws JaxenException, Exception {
//        this.contextSupport = null;
//        System.setProperty(XPathReaderFactory.DRIVER_PROPERTY, "");
//        log_XPathTestBase("-----------------------------");
//        Navigator nav = getNavigator_XPathTestBase();
//        String url = "xml/testNamespaces.xml";
//        log_XPathTestBase("Document [" + url + "]");
//        Object document = nav.getDocument(url);
//        XPath contextpath = new BaseXPath("/Template/Application1", nav);
//        log_XPathTestBase("Initial Context :: " + contextpath);
//        List list = contextpath.selectNodes(document);
//        Iterator iter = list.iterator();
//        while (iter.hasNext()) {
//            Object context = iter.next();
//            assertCountXPath_XPathTestBase(3, context, "namespace::*");
//            assertCountXPath_XPathTestBase(0, context, "/namespace::*");
//            assertCountXPath_XPathTestBase(3, context, "/Template/Application1/namespace::*");
//            assertCountXPath_XPathTestBase(3, context, "/Template/Application2/namespace::*");
//            assertCountXPath_XPathTestBase(25, context, "//namespace::*");
//            assertCountXPath_XPathTestBase(8, context, "//namespace::xplt");
//            assertCountXPath_XPathTestBase(0, context, "//namespace::somethingelse");
//        }
//    }
//
//    public void testNamespaceNodesHaveParent_XPathTestBase() throws JaxenException, Exception {
//        this.contextSupport = null;
//        System.setProperty(XPathReaderFactory.DRIVER_PROPERTY, "");
//        log_XPathTestBase("-----------------------------");
//        Navigator nav = getNavigator_XPathTestBase();
//        String url = "xml/testNamespaces.xml";
//        log_XPathTestBase("Document [" + url + "]");
//        Object document = nav.getDocument(url);
//        XPath contextpath = new BaseXPath("/", nav);
//        log_XPathTestBase("Initial Context :: " + contextpath);
//        List list = contextpath.selectNodes(document);
//        Iterator iter = list.iterator();
//        while (iter.hasNext()) {
//            Object context = iter.next();
//            assertCountXPath_XPathTestBase(1, context, "/Template/namespace::xml/parent::Template");
//        }
//    }
//
//    /** 
//     * namespace nodes can also be used as context nodes
//     */
//    public void testNamespaceNodeAsContext_XPathTestBase() throws JaxenException, Exception {
//        this.contextSupport = null;
//        System.setProperty(XPathReaderFactory.DRIVER_PROPERTY, "");
//        log_XPathTestBase("-----------------------------");
//        Navigator nav = getNavigator_XPathTestBase();
//        String url = "xml/testNamespaces.xml";
//        log_XPathTestBase("Document [" + url + "]");
//        Object document = nav.getDocument(url);
//        XPath contextpath = new BaseXPath("/Template/namespace::xml", nav);
//        log_XPathTestBase("Initial Context :: " + contextpath);
//        List list = contextpath.selectNodes(document);
//        Iterator iter = list.iterator();
//        while (iter.hasNext()) {
//            Object context = iter.next();
//            assertCountXPath_XPathTestBase(1, context, "parent::Template");
//        }
//    }
}
