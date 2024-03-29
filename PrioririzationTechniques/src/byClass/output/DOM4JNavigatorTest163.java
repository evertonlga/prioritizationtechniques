package byClass.output;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import junit.framework.TestCase;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.io.SAXReader;
import org.jaxen.BaseXPath;
import org.jaxen.Context;
import org.jaxen.ContextSupport;
import org.jaxen.FunctionCallException;
import org.jaxen.JaxenException;
import org.jaxen.Navigator;
import org.jaxen.SimpleNamespaceContext;
import org.jaxen.SimpleVariableContext;
import org.jaxen.UnsupportedAxisException;
import org.jaxen.XPath;
import org.jaxen.XPathFunctionContext;
import org.jaxen.dom.DOMXPath;
import org.jaxen.dom4j.DocumentNavigator;
import org.jaxen.dom4j.Dom4jXPath;
import org.jaxen.function.StringFunction;
import org.jaxen.pattern.Pattern;
import org.jaxen.saxpath.helpers.XPathReaderFactory;

public class DOM4JNavigatorTest163 extends TestCase {

    public DOM4JNavigatorTest163(String name) {
        super(name);
        this.reader = new SAXReader();
        this.reader.setMergeAdjacentText(true);
    }

    private SAXReader reader;

    protected static String VAR_URI = "http://jaxen.org/test-harness/var";

    protected static String TESTS_XML = "xml/test/tests.xml";

    protected static boolean verbose = false;

    protected static boolean debug = false;

    private ContextSupport contextSupport;

    protected void setUp() throws Exception {
        this.contextSupport = null;
        System.setProperty(XPathReaderFactory.DRIVER_PROPERTY, "");
        log("-----------------------------");
    }

    public void testid54249() throws JaxenException {
        Navigator nav = getNavigator();
        String url = "xml/web.xml";
        log("Document [" + url + "]");
        Object document = nav.getDocument(url);
        XPath contextpath = new BaseXPath("/web-app/servlet[1]", nav);
        log("Initial Context :: " + contextpath);
        List list = contextpath.selectNodes(document);
        Iterator iter = list.iterator();
        while (iter.hasNext()) {
            Object context = iter.next();
            assertValueOfXPath("snoop", context, "servlet-name");
            assertValueOfXPath("snoop", context, "servlet-name/text()");
        }
    }

    /**
     *  parser test cases all of which should fail
     */
    public void testForParserErrors() throws JaxenException {
        Navigator nav = getNavigator();
        String url = "xml/numbers.xml";
        log("Document [" + url + "]");
        Object document = nav.getDocument(url);
        XPath contextpath = new BaseXPath("/", nav);
        log("Initial Context :: " + contextpath);
        List list = contextpath.selectNodes(document);
        Iterator iter = list.iterator();
        while (iter.hasNext()) {
            Object context = iter.next();
            assertInvalidXPath(context, "/numbers numbers");
            assertInvalidXPath(context, "/a/b[c > d]efg");
            assertInvalidXPath(context, "/inv/child::");
            assertInvalidXPath(context, "/invoice/@test[abcd");
            assertInvalidXPath(context, "/invoice/@test[abcd > x");
            assertInvalidXPath(context, "string-length('a");
            assertInvalidXPath(context, "/descendant::()");
            assertInvalidXPath(context, "(1 + 1");
            assertInvalidXPath(context, "!false()");
        }
    }

    /**
     *  test for jaxen-24
     */
    public void testJaxen24() throws JaxenException {
        Navigator nav = getNavigator();
        String url = "xml/jaxen24.xml";
        log("Document [" + url + "]");
        Object document = nav.getDocument(url);
        XPath contextpath = new BaseXPath("/body/div", nav);
        log("Initial Context :: " + contextpath);
        List list = contextpath.selectNodes(document);
        Iterator iter = list.iterator();
        while (iter.hasNext()) {
            Object context = iter.next();
            assertCountXPath(1, context, "preceding::*[1]");
            assertValueOfXPath("span", context, "local-name(preceding::*[1])");
        }
    }

    private Object assertCountXPath2(int expectedSize, Object context, String xpathStr) throws JaxenException {
        log(debug, "  Select :: " + xpathStr);
        DOMXPath xpath = new DOMXPath(xpathStr);
        List results = xpath.selectNodes(getContext(context));
        log(debug, "    Expected Size :: " + expectedSize);
        log(debug, "    Result Size   :: " + results.size());
        if (expectedSize != results.size()) {
            log(debug, "      ## FAILED");
            log(debug, "      ## xpath: " + xpath + " = " + xpath.debug());
            Iterator resultIter = results.iterator();
            while (resultIter.hasNext()) {
                log(debug, "      --> " + resultIter.next());
            }
        }
        assertEquals(xpathStr, expectedSize, results.size());
        assertExprGetTextIdempotent(xpath);
        if (expectedSize > 0) {
            return results.get(0);
        }
        return null;
    }

    /** 
     * test predicates
     */
    public void testid54522() throws JaxenException {
        Navigator nav = getNavigator();
        String url = "xml/nitf.xml";
        log("Document [" + url + "]");
        Object document = nav.getDocument(url);
        XPath contextpath = new BaseXPath("/nitf/head/docdata", nav);
        log("Initial Context :: " + contextpath);
        List list = contextpath.selectNodes(document);
        Iterator iter = list.iterator();
        while (iter.hasNext()) {
            Object context = iter.next();
            assertCountXPath(1, context, "doc-id[@regsrc='FAKE' and @id-string='YYY']");
        }
    }

    /** 
     * test cases for the use of = with node-sets
     */
    public void testNodesetEqualsString() throws JaxenException {
        Navigator nav = getNavigator();
        String url = "xml/web.xml";
        log("Document [" + url + "]");
        Object document = nav.getDocument(url);
        XPath contextpath = new BaseXPath("/", nav);
        log("Initial Context :: " + contextpath);
        List list = contextpath.selectNodes(document);
        Iterator iter = list.iterator();
        while (iter.hasNext()) {
            Object context = iter.next();
            assertValueOfXPath("true", context, "/web-app/servlet/servlet-name = 'file'");
            assertValueOfXPath("true", context, "/web-app/servlet/servlet-name = 'snoop'");
        }
    }

    public void testCountFunctionMore() throws JaxenException {
        Navigator nav = getNavigator();
        String url = "xml/much_ado.xml";
        log("Document [" + url + "]");
        Object document = nav.getDocument(url);
        XPath contextpath = new BaseXPath("/PLAY/ACT[2]/SCENE[1]", nav);
        log("Initial Context :: " + contextpath);
        List list = contextpath.selectNodes(document);
        Iterator iter = list.iterator();
        while (iter.hasNext()) {
            Object context = iter.next();
            assertCountXPath(5, context, "/descendant::ACT");
            assertCountXPath(5, context, "../../descendant::ACT");
            assertCountXPath(141, context, "/PLAY/ACT[2]/SCENE[1]/descendant::SPEAKER");
            assertCountXPath(141, context, "descendant::SPEAKER");
            assertValueOfXPath("646", context, "count(descendant::*)+1");
            assertValueOfXPath("142", context, "count(descendant::SPEAKER)+1");
            assertValueOfXPath("2", context, "count(ancestor::*)");
            assertValueOfXPath("1", context, "count(ancestor::PLAY)");
            assertValueOfXPath("3", context, "count(ancestor-or-self::*)");
            assertValueOfXPath("1", context, "count(ancestor-or-self::PLAY)");
            assertValueOfXPath("6", context, "5+count(ancestor::*)-1");
        }
    }

    public void testStringFunction3() throws JaxenException {
        Navigator nav = getNavigator();
        String url = "xml/simple.xml";
        log("Document [" + url + "]");
        Object document = nav.getDocument(url);
        XPath contextpath = new BaseXPath("/root/c", nav);
        log("Initial Context :: " + contextpath);
        List list = contextpath.selectNodes(document);
        Iterator iter = list.iterator();
        while (iter.hasNext()) {
            Object context = iter.next();
            assertValueOfXPath("d", context, "string()");
        }
    }

    public void testid54467() throws JaxenException {
        Navigator nav = getNavigator();
        String url = "xml/web.xml";
        log("Document [" + url + "]");
        Object document = nav.getDocument(url);
        XPath contextpath = new BaseXPath("/*", nav);
        log("Initial Context :: " + contextpath);
        List list = contextpath.selectNodes(document);
        Iterator iter = list.iterator();
        while (iter.hasNext()) {
            Object context = iter.next();
            assertValueOfXPath("", context, "name(..)");
            assertValueOfXPath("", context, "name(parent::node())");
            assertValueOfXPath("", context, "name(parent::*)");
            assertValueOfXPath("web-app", context, "name()");
            assertValueOfXPath("web-app", context, "name(.)");
            assertValueOfXPath("web-app", context, "name(../*)");
            assertValueOfXPath("web-app", context, "name(../child::node())");
        }
    }

    public void testNamespaceNodeCounts() throws JaxenException {
        Navigator nav = getNavigator();
        String url = "xml/testNamespaces.xml";
        log("Document [" + url + "]");
        Object document = nav.getDocument(url);
        XPath contextpath = new BaseXPath("/Template/Application1", nav);
        log("Initial Context :: " + contextpath);
        List list = contextpath.selectNodes(document);
        Iterator iter = list.iterator();
        while (iter.hasNext()) {
            Object context = iter.next();
            assertCountXPath(3, context, "namespace::*");
            assertCountXPath(0, context, "/namespace::*");
            assertCountXPath(3, context, "/Template/Application1/namespace::*");
            assertCountXPath(3, context, "/Template/Application2/namespace::*");
            assertCountXPath(25, context, "//namespace::*");
            assertCountXPath(8, context, "//namespace::xplt");
            assertCountXPath(0, context, "//namespace::somethingelse");
        }
    }

    public void testid54534() throws JaxenException {
        Navigator nav = getNavigator();
        String url = "xml/nitf.xml";
        log("Document [" + url + "]");
        Object document = nav.getDocument(url);
        XPath contextpath = new BaseXPath("/nitf/head", nav);
        log("Initial Context :: " + contextpath);
        List list = contextpath.selectNodes(document);
        Iterator iter = list.iterator();
        while (iter.hasNext()) {
            Object context = iter.next();
            assertCountXPath(1, context, "meta[@name='fake-cycle']");
            assertCountXPath(1, context, "meta[@content='FAKE']");
            assertCountXPath(8, context, "meta[@name and @content]");
            assertCountXPath(1, context, "meta[@name='fake-cycle' and @content='FAKE']");
            assertCountXPath(7, context, "meta[@name != 'fake-cycle']");
        }
    }

    public void testid54278() throws JaxenException {
        Navigator nav = getNavigator();
        String url = "xml/web.xml";
        log("Document [" + url + "]");
        Object document = nav.getDocument(url);
        XPath contextpath = new BaseXPath("/web-app/servlet[2]/servlet-name", nav);
        log("Initial Context :: " + contextpath);
        List list = contextpath.selectNodes(document);
        Iterator iter = list.iterator();
        while (iter.hasNext()) {
            Object context = iter.next();
            assertCountXPath(13, context, "following::*");
        }
    }

    public void testNamespaces() throws JaxenException {
        Navigator nav = getNavigator();
        String url = "xml/namespaces.xml";
        log("Document [" + url + "]");
        Object document = nav.getDocument(url);
        XPath contextpath = new BaseXPath("/", nav);
        log("Initial Context :: " + contextpath);
        List list = contextpath.selectNodes(document);
        SimpleNamespaceContext nsContext = new SimpleNamespaceContext();
        nsContext.addNamespace("alias", "http://fooNamespace/");
        nsContext.addNamespace("bar", "http://barNamespace/");
        nsContext.addNamespace("foo", "http://fooNamespace/");
        getContextSupport().setNamespaceContext(nsContext);
        Iterator iter = list.iterator();
        while (iter.hasNext()) {
            Object context = iter.next();
            assertValueOfXPath("Hello", context, "/foo:a/b/c");
            assertValueOfXPath("Hey", context, "/foo:a/foo:d/foo:e");
            assertValueOfXPath("Hey3", context, "/foo:a/alias:x/alias:y");
            assertValueOfXPath("Hey3", context, "/foo:a/foo:x/foo:y");
            assertValueOfXPath("Hey3", context, "/*[local-name()='a' and namespace-uri()='http://fooNamespace/']/*[local-name()='x' and namespace-uri()='http://fooNamespace/']/*[local-name()='y' and namespace-uri()='http://fooNamespace/']");
        }
    }

    public void testid54168() throws JaxenException {
        Navigator nav = getNavigator();
        String url = "xml/axis.xml";
        log("Document [" + url + "]");
        Object document = nav.getDocument(url);
        XPath contextpath = new BaseXPath("/root/a/a.3", nav);
        log("Initial Context :: " + contextpath);
        List list = contextpath.selectNodes(document);
        Iterator iter = list.iterator();
        while (iter.hasNext()) {
            Object context = iter.next();
            assertCountXPath(2, context, "preceding-sibling::*");
        }
    }

    /**
     *  jaxen-58
     */
    public void testJaxen58() throws JaxenException {
        Navigator nav = getNavigator();
        String url = "xml/jaxen24.xml";
        log("Document [" + url + "]");
        Object document = nav.getDocument(url);
        XPath contextpath = new BaseXPath("/", nav);
        log("Initial Context :: " + contextpath);
        List list = contextpath.selectNodes(document);
        Iterator iter = list.iterator();
        while (iter.hasNext()) {
            Object context = iter.next();
            assertCountXPath(0, context, "//preceding::x");
            assertCountXPath(0, context, "//following::x");
            assertCountXPath(0, context, "/descendant::*/preceding::x");
            assertCountXPath(0, context, "/descendant::node()/preceding::x");
        }
    }

    public void testTextNodes() throws JaxenException {
        Navigator nav = getNavigator();
        String url = "xml/text.xml";
        log("Document [" + url + "]");
        Object document = nav.getDocument(url);
        XPath contextpath = new BaseXPath("/", nav);
        log("Initial Context :: " + contextpath);
        List list = contextpath.selectNodes(document);
        Iterator iter = list.iterator();
        while (iter.hasNext()) {
            Object context = iter.next();
            assertCountXPath(3, context, "/foo/bar/text()");
            assertValueOfXPath("baz", context, "normalize-space(/foo/bar/text())");
        }
    }

    /** 
     * test behavior of AbsoluteLocationPath
     */
    public void testAbsoluteLocationPaths() throws JaxenException {
        Navigator nav = getNavigator();
        String url = "xml/simple.xml";
        log("Document [" + url + "]");
        Object document = nav.getDocument(url);
        XPath contextpath = new BaseXPath("/root/a", nav);
        log("Initial Context :: " + contextpath);
        List list = contextpath.selectNodes(document);
        Iterator iter = list.iterator();
        while (iter.hasNext()) {
            Object context = iter.next();
            assertValueOfXPath("ab", context, "concat( ., /root/b )");
            assertValueOfXPath("ba", context, "concat( ../b, . )");
            assertValueOfXPath("ba", context, "concat( /root/b, . )");
            assertValueOfXPath("db", context, "concat( /root/c/d, ../b )");
        }
    }

    /** 
     * test positioning
     */
    public void testPositioning() throws JaxenException {
        Navigator nav = getNavigator();
        String url = "xml/fibo.xml";
        log("Document [" + url + "]");
        Object document = nav.getDocument(url);
        XPath contextpath = new BaseXPath("/", nav);
        log("Initial Context :: " + contextpath);
        List list = contextpath.selectNodes(document);
        Iterator iter = list.iterator();
        while (iter.hasNext()) {
            Object context = iter.next();
            assertCountXPath(9, context, "/*/fibonacci[position() < 10]");
            assertValueOfXPath("196417", context, "sum(//fibonacci)");
            assertValueOfXPath("325", context, "sum(//fibonacci/@index)");
            assertValueOfXPath("1", context, "/*/fibonacci[2]");
            assertValueOfXPath("75025", context, "/*/fibonacci[ count(/*/fibonacci) ]");
            assertValueOfXPath("46368", context, "/*/fibonacci[ count(/*/fibonacci) - 1 ]");
        }
    }

    public void testNullPointerException() throws JaxenException {
        Document doc = DocumentHelper.createDocument();
        XPath xpath = new Dom4jXPath("/foo");
        xpath.selectSingleNode(doc);
    }

    /** 
     * test evaluate() extension function
     */
    public void testid54032() throws JaxenException {
        Navigator nav = getNavigator();
        String url = "xml/evaluate.xml";
        log("Document [" + url + "]");
        Object document = nav.getDocument(url);
        XPath contextpath = new BaseXPath("/", nav);
        log("Initial Context :: " + contextpath);
        List list = contextpath.selectNodes(document);
        Iterator iter = list.iterator();
        while (iter.hasNext()) {
            Object context = iter.next();
            assertCountXPath(3, context, "evaluate('//jumps/*')");
            assertCountXPath(1, context, "evaluate('//jumps/object/dog')");
            assertCountXPath(0, context, "evaluate('//jumps/object')/evaluate");
            assertCountXPath(1, context, "evaluate('//jumps/object')/dog");
            assertCountXPath(1, context, "evaluate('//jumps/*')/dog");
            assertCountXPath(1, context, "//metatest[ evaluate(@select) = . ]");
        }
    }

    public void testVariableLookup() throws JaxenException {
        Navigator nav = getNavigator();
        String url = "xml/id.xml";
        log("Document [" + url + "]");
        Object document = nav.getDocument(url);
        XPath contextpath = new BaseXPath("/", nav);
        log("Initial Context :: " + contextpath);
        List list = contextpath.selectNodes(document);
        SimpleVariableContext varContext = new SimpleVariableContext();
        varContext.setVariableValue(null, "foobar", "foobar");
        varContext.setVariableValue(null, "foo", "foo");
        getContextSupport().setVariableContext(varContext);
        Iterator iter = list.iterator();
        while (iter.hasNext()) {
            Object context = iter.next();
            assertValueOfXPath("foobar", context, "$foobar");
            assertCountXPath(1, context, "/foo[@id=$foobar]");
            assertCountXPath(0, context, "/foo[@id='$foobar']");
            assertCountXPath(1, context, "/foo[concat($foo, 'bar')=@id]");
            assertCountXPath(0, context, "CD_Library/artist[@name=$artist]");
        }
    }

    private ContextSupport getContextSupport() {
        if (this.contextSupport == null) {
            this.contextSupport = new ContextSupport(new SimpleNamespaceContext(), XPathFunctionContext.getInstance(), new SimpleVariableContext(), getNavigator());
        }
        return this.contextSupport;
    }

    private void assertValueOfXPath(String expected, Object context, String xpathStr) throws JaxenException {
        DOMXPath xpath = new DOMXPath(xpathStr);
        Object node = xpath.evaluate(getContext(context));
        String result = StringFunction.evaluate(node, getNavigator());
        log(debug, "  Select :: " + xpathStr);
        log(debug, "    Expected :: " + expected);
        log(debug, "    Result   :: " + result);
        if (!expected.equals(result)) {
            log(debug, "      ## FAILED");
            log(debug, "      ## xpath: " + xpath + " = " + xpath.debug());
        }
        assertEquals(xpathStr, expected, result);
        assertExprGetTextIdempotent(xpath);
    }

    /** 
     * namespace nodes can also be used as context nodes
     */
    public void testNamespaceNodeAsContext() throws JaxenException {
        Navigator nav = getNavigator();
        String url = "xml/testNamespaces.xml";
        log("Document [" + url + "]");
        Object document = nav.getDocument(url);
        XPath contextpath = new BaseXPath("/Template/namespace::xml", nav);
        log("Initial Context :: " + contextpath);
        List list = contextpath.selectNodes(document);
        Iterator iter = list.iterator();
        while (iter.hasNext()) {
            Object context = iter.next();
            assertCountXPath(1, context, "parent::Template");
        }
    }

    public void testCountFunction() throws JaxenException {
        Navigator nav = getNavigator();
        String url = "xml/much_ado.xml";
        log("Document [" + url + "]");
        Object document = nav.getDocument(url);
        XPath contextpath = new BaseXPath("/", nav);
        log("Initial Context :: " + contextpath);
        List list = contextpath.selectNodes(document);
        Iterator iter = list.iterator();
        while (iter.hasNext()) {
            Object context = iter.next();
            assertCountXPath(5, context, "/descendant::ACT");
            assertCountXPath(5, context, "descendant::ACT");
            assertValueOfXPath("Much Ado about Nothing", context, "/PLAY/TITLE");
            assertValueOfXPath("4", context, "2+2");
            assertValueOfXPath("21", context, "5 * 4 + 1");
            assertValueOfXPath("5", context, "count(descendant::ACT)");
            assertValueOfXPath("35", context, "10 + count(descendant::ACT) * 5");
            assertValueOfXPath("75", context, "(10 + count(descendant::ACT)) * 5");
        }
    }

    public Navigator getNavigator() {
        return new DocumentNavigator();
    }

    /** 
     * test document function
     */
    public void testDocumentFunction1() throws JaxenException {
        Navigator nav = getNavigator();
        String url = "xml/text.xml";
        log("Document [" + url + "]");
        Object document = nav.getDocument(url);
        XPath contextpath = new BaseXPath("/", nav);
        log("Initial Context :: " + contextpath);
        List list = contextpath.selectNodes(document);
        Iterator iter = list.iterator();
        while (iter.hasNext()) {
            Object context = iter.next();
            Object result = assertCountXPath2(1, context, "document('xml/web.xml')");
            assertValueOfXPath("snoop", result, "/web-app/servlet[1]/servlet-name");
            assertValueOfXPath("snoop", result, "/web-app/servlet[1]/servlet-name/text()");
            assertValueOfXPath("snoop", context, "document('xml/web.xml')/web-app/servlet[1]/servlet-name");
        }
    }

    public void testid54570() throws JaxenException {
        Navigator nav = getNavigator();
        String url = "xml/nitf.xml";
        log("Document [" + url + "]");
        Object document = nav.getDocument(url);
        XPath contextpath = new BaseXPath("/", nav);
        log("Initial Context :: " + contextpath);
        List list = contextpath.selectNodes(document);
        Iterator iter = list.iterator();
        while (iter.hasNext()) {
            Object context = iter.next();
            assertCountXPath(1, context, "/nitf/head/meta[@name='fake-cycle']");
            assertCountXPath(1, context, "/nitf/head/meta[@content='FAKE']");
            assertCountXPath(8, context, "/nitf/head/meta[@name and @content]");
            assertCountXPath(1, context, "/nitf/head/meta[@name='fake-cycle' and @content='FAKE']");
            assertCountXPath(7, context, "/nitf/head/meta[@name != 'fake-cycle']");
        }
    }

    public void testid54082() throws JaxenException {
        Navigator nav = getNavigator();
        String url = "xml/numbers.xml";
        log("Document [" + url + "]");
        Object document = nav.getDocument(url);
        XPath contextpath = new BaseXPath("/numbers/set[1]", nav);
        log("Initial Context :: " + contextpath);
        List list = contextpath.selectNodes(document);
        Iterator iter = list.iterator();
        while (iter.hasNext()) {
            Object context = iter.next();
            assertCountXPath(1, context, "*[-3 = .]");
            assertValueOfXPath("true", context, "54 < *");
            assertValueOfXPath("true", context, "55 <= *");
            assertValueOfXPath("false", context, "69 < *");
            assertValueOfXPath("true", context, "-2 > *");
            assertValueOfXPath("true", context, "-3 >= *");
            assertValueOfXPath("false", context, "-4 >= *");
        }
    }

    /** 
     * test cases for the lang() function
     */
    public void testLangFunction() throws JaxenException {
        Navigator nav = getNavigator();
        String url = "xml/lang.xml";
        log("Document [" + url + "]");
        Object document = nav.getDocument(url);
        XPath contextpath = new BaseXPath("/", nav);
        log("Initial Context :: " + contextpath);
        List list = contextpath.selectNodes(document);
        Iterator iter = list.iterator();
        while (iter.hasNext()) {
            Object context = iter.next();
            assertCountXPath(0, context, "/e1/e2[lang('hr')]");
            assertCountXPath(1, context, "/e1/e2/e3[lang('en')]");
            assertCountXPath(1, context, "/e1/e2/e3[lang('en-US')]");
            assertCountXPath(0, context, "/e1/e2/e3[lang('en-GB')]");
            assertCountXPath(2, context, "/e1/e2/e3[lang('hu')]");
            assertCountXPath(0, context, "/e1/e2/e3[lang('hu-HU')]");
            assertCountXPath(1, context, "/e1/e2/e3[lang('es')]");
            assertCountXPath(0, context, "/e1/e2/e3[lang('es-BR')]");
        }
    }

    public void testid54614() throws JaxenException {
        Navigator nav = getNavigator();
        String url = "xml/moreover.xml";
        log("Document [" + url + "]");
        Object document = nav.getDocument(url);
        XPath contextpath = new BaseXPath("/", nav);
        log("Initial Context :: " + contextpath);
        List list = contextpath.selectNodes(document);
        Iterator iter = list.iterator();
        while (iter.hasNext()) {
            Object context = iter.next();
            assertCountXPath(1, context, "/child::node()");
            assertCountXPath(1, context, "/*");
            assertCountXPath(20, context, "/*/article");
            assertCountXPath(221, context, "//*");
            assertCountXPath(20, context, "//*[local-name()='article']");
            assertCountXPath(20, context, "//article");
            assertCountXPath(20, context, "/*/*[@code]");
            assertCountXPath(1, context, "/moreovernews/article[@code='13563275']");
            DOMXPath xpath = new DOMXPath("/moreovernews/article[@code='13563275']");
            List results = xpath.selectNodes(getContext(context));
            Object result = results.get(0);
            assertValueOfXPath("http://c.moreover.com/click/here.pl?x13563273", result, "url");
            xpath = new DOMXPath("/*/article[@code='13563275']");
            results = xpath.selectNodes(getContext(context));
            result = results.get(0);
            assertValueOfXPath("http://c.moreover.com/click/here.pl?x13563273", result, "url");
            xpath = new DOMXPath("//article[@code='13563275']");
            results = xpath.selectNodes(getContext(context));
            result = results.get(0);
            assertValueOfXPath("http://c.moreover.com/click/here.pl?x13563273", result, "url");
            xpath = new DOMXPath("//*[@code='13563275']");
            results = xpath.selectNodes(getContext(context));
            result = results.get(0);
            assertValueOfXPath("http://c.moreover.com/click/here.pl?x13563273", result, "url");
            xpath = new DOMXPath("/child::node()/child::node()[@code='13563275']");
            results = xpath.selectNodes(getContext(context));
            result = results.get(0);
            assertValueOfXPath("http://c.moreover.com/click/here.pl?x13563273", result, "url");
            xpath = new DOMXPath("/*/*[@code='13563275']");
            results = xpath.selectNodes(getContext(context));
            result = results.get(0);
            assertValueOfXPath("http://c.moreover.com/click/here.pl?x13563273", result, "url");
        }
    }

    public void testid54156() throws JaxenException {
        Navigator nav = getNavigator();
        String url = "xml/axis.xml";
        log("Document [" + url + "]");
        Object document = nav.getDocument(url);
        XPath contextpath = new BaseXPath("/root/a/a.3", nav);
        log("Initial Context :: " + contextpath);
        List list = contextpath.selectNodes(document);
        Iterator iter = list.iterator();
        while (iter.hasNext()) {
            Object context = iter.next();
            assertCountXPath(2, context, "preceding::*");
        }
    }

    public void testid54932() throws JaxenException {
        Navigator nav = getNavigator();
        String url = "xml/web.xml";
        log("Document [" + url + "]");
        Object document = nav.getDocument(url);
        XPath contextpath = new BaseXPath("/web-app", nav);
        log("Initial Context :: " + contextpath);
        List list = contextpath.selectNodes(document);
        Iterator iter = list.iterator();
        while (iter.hasNext()) {
            Object context = iter.next();
            assertCountXPath(2, context, "/descendant::servlet");
            assertCountXPath(2, context, "/descendant-or-self::servlet");
            assertCountXPath(2, context, "descendant-or-self::servlet");
            assertCountXPath(2, context, "descendant::servlet");
        }
    }

    /** 
     * the prefix here and in the document have no relation; it's their
     * namespace-uri binding that counts 
     */
    public void testPrefixDoesntMatter() throws JaxenException {
        Navigator nav = getNavigator();
        String url = "xml/namespaces.xml";
        log("Document [" + url + "]");
        Object document = nav.getDocument(url);
        XPath contextpath = new BaseXPath("/", nav);
        log("Initial Context :: " + contextpath);
        List list = contextpath.selectNodes(document);
        SimpleNamespaceContext nsContext = new SimpleNamespaceContext();
        nsContext.addNamespace("foo", "http://somethingElse/");
        getContextSupport().setNamespaceContext(nsContext);
        Iterator iter = list.iterator();
        while (iter.hasNext()) {
            Object context = iter.next();
            assertCountXPath(0, context, "/foo:a/b/c");
        }
    }

    public void testDocumentFunctionActual() throws JaxenException {
        Navigator nav = getNavigator();
        String url = "xml/message.xml";
        log("Document [" + url + "]");
        Object document = nav.getDocument(url);
        XPath contextpath = new BaseXPath("/", nav);
        log("Initial Context :: " + contextpath);
        List list = contextpath.selectNodes(document);
        Iterator iter = list.iterator();
        while (iter.hasNext()) {
            Object context = iter.next();
            assertValueOfXPath("Pruefgebiete", context, "/message/body/data/items/item[name/text()='parentinfo']/value");
            assertValueOfXPath("Pruefgebiete", context, "document('xml/message.xml')/message/body/data/items/item[name/text()='parentinfo']/value");
        }
    }

    /** Jaxen-67, affects Jelly and Maven */
    public void testCDATASectionsAreIncludedInTextNodes() throws JaxenException {
        Navigator nav = getNavigator();
        String url = "xml/cdata.xml";
        log("Document [" + url + "]");
        Object document = nav.getDocument(url);
        XPath contextPath = new BaseXPath("/p/text()", nav);
        log("Initial Context :: " + contextPath);
        List list = contextPath.selectNodes(document);
        StringBuffer buffer = new StringBuffer(10);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            buffer.append(StringFunction.evaluate(iterator.next(), nav));
        }
        assertEquals("awhateverb", buffer.toString());
    }

    /** test axis node ordering
    */
    public void testAxisNodeOrdering() throws JaxenException {
        Navigator nav = getNavigator();
        String url = "xml/web.xml";
        log("Document [" + url + "]");
        Object document = nav.getDocument(url);
        XPath contextpath = new BaseXPath("/", nav);
        log("Initial Context :: " + contextpath);
        List list = contextpath.selectNodes(document);
        Iterator iter = list.iterator();
        while (iter.hasNext()) {
            Object context = iter.next();
            assertCountXPath(1, context, "//servlet-mapping/preceding::*[1][name()='description']");
            assertCountXPath(1, context, "/web-app/servlet//description/following::*[1][name()='servlet-mapping']");
            assertCountXPath(1, context, "/web-app/servlet//description/following::*[2][name()='servlet-name']");
        }
    }

    private void assertInvalidXPath(Object context, String xpathStr) {
        try {
            log(debug, "  Select :: " + xpathStr);
            DOMXPath xpath = new DOMXPath(xpathStr);
            List results = xpath.selectNodes(getContext(context));
            log(debug, "    Result Size   :: " + results.size());
            fail("An exception was expected.");
        } catch (JaxenException e) {
            log(debug, "    Caught expected exception " + e.getMessage());
        }
    }

    public void testSubstringFunction() throws JaxenException {
        Navigator nav = getNavigator();
        String url = "xml/simple.xml";
        log("Document [" + url + "]");
        Object document = nav.getDocument(url);
        XPath contextpath = new BaseXPath("/", nav);
        log("Initial Context :: " + contextpath);
        List list = contextpath.selectNodes(document);
        Iterator iter = list.iterator();
        while (iter.hasNext()) {
            Object context = iter.next();
            assertValueOfXPath("234", context, "substring('12345', 1.5, 2.6)");
            assertValueOfXPath("12", context, "substring('12345', 0, 3)");
            assertValueOfXPath("", context, "substring('12345', 0 div 0, 3)");
            assertValueOfXPath("", context, "substring('12345', 1, 0 div 0)");
            assertValueOfXPath("12345", context, "substring('12345', -42, 1 div 0)");
            assertValueOfXPath("", context, "substring('12345', -1 div 0, 1 div 0)");
            assertValueOfXPath("345", context, "substring('12345', 3)");
            assertValueOfXPath("12345", context, "substring('12345',1,15)");
        }
    }

    /** 
     * Test to check if the context changes when an extension function is used.
     * First test is an example, second is the actual test.
     */
    public void testDocumentFunctionContextExample() throws JaxenException {
        Navigator nav = getNavigator();
        String url = "xml/text.xml";
        log("Document [" + url + "]");
        Object document = nav.getDocument(url);
        XPath contextpath = new BaseXPath("/foo/bar/cheese[1]", nav);
        log("Initial Context :: " + contextpath);
        List list = contextpath.selectNodes(document);
        Iterator iter = list.iterator();
        while (iter.hasNext()) {
            Object context = iter.next();
            assertValueOfXPath("3foo3", context, "concat(./@id,'foo',@id)");
            assertValueOfXPath("3snoop3", context, "concat(./@id,document('xml/web.xml')/web-app/servlet[1]/servlet-name,./@id)");
        }
    }

    public void testNamespaceNodeCounts1() throws JaxenException {
        Navigator nav = getNavigator();
        String url = "xml/testNamespaces.xml";
        log("Document [" + url + "]");
        Object document = nav.getDocument(url);
        XPath contextpath = new BaseXPath("/", nav);
        log("Initial Context :: " + contextpath);
        List list = contextpath.selectNodes(document);
        Iterator iter = list.iterator();
        while (iter.hasNext()) {
            Object context = iter.next();
            assertCountXPath(0, context, "namespace::*");
            assertCountXPath(0, context, "/namespace::*");
            assertCountXPath(3, context, "/Template/Application1/namespace::*");
            assertCountXPath(3, context, "/Template/Application2/namespace::*");
            assertCountXPath(25, context, "//namespace::*");
        }
    }

    public Object getDocument(String url) throws Exception {
        return reader.read(url);
    }

    /**
     * reported as JAXEN-104.
     * @throws FunctionCallException
     * @throws UnsupportedAxisException
     */
    public void testConcurrentModification() throws FunctionCallException, UnsupportedAxisException {
        Navigator nav = new DocumentNavigator();
        Object document = nav.getDocument("xml/testNamespaces.xml");
        Iterator descendantOrSelfAxisIterator = nav.getDescendantOrSelfAxisIterator(document);
        while (descendantOrSelfAxisIterator.hasNext()) {
            Object node = descendantOrSelfAxisIterator.next();
            Iterator namespaceAxisIterator = nav.getNamespaceAxisIterator(node);
            while (namespaceAxisIterator.hasNext()) {
                namespaceAxisIterator.next();
            }
        }
    }

    /** 
     * test basic math...
     */
    public void testIntegerArithmetic() throws JaxenException {
        Navigator nav = getNavigator();
        String url = "xml/numbers.xml";
        log("Document [" + url + "]");
        Object document = nav.getDocument(url);
        XPath contextpath = new BaseXPath("/", nav);
        log("Initial Context :: " + contextpath);
        List list = contextpath.selectNodes(document);
        Iterator iter = list.iterator();
        while (iter.hasNext()) {
            Object context = iter.next();
            assertValueOfXPath("true", context, "(8 * 2 + 1) = 17");
            assertValueOfXPath("true", context, "(1 + 8 * 2) = 17");
            assertValueOfXPath("true", context, "(7 - 3 + 1) = 5");
            assertValueOfXPath("true", context, "(8 - 4 + 5 - 6) = 3");
            assertValueOfXPath("0", context, "3 - 2 - 1");
            assertValueOfXPath("1", context, "8 div 4 div 2");
            assertValueOfXPath("3", context, "3 mod 7 mod 5");
            assertValueOfXPath("false", context, "1 = 2 = 2");
            assertValueOfXPath("false", context, "2 != 3 != 1");
            assertValueOfXPath("false", context, "3 > 2 > 1");
            assertValueOfXPath("false", context, "3 >= 2 >= 2");
            assertValueOfXPath("true", context, "1 < 2 < 3");
            assertValueOfXPath("true", context, "2 <= 2 <= 3");
        }
    }

    private void assertExprGetTextIdempotent(BaseXPath xpath) throws JaxenException {
        assertEquals(0, ExprComparator.EXPR_COMPARATOR.compare(xpath.getRootExpr(), new BaseXPath(xpath.getRootExpr().getText(), null).getRootExpr()));
    }

    public void testid54197() throws JaxenException {
        Navigator nav = getNavigator();
        String url = "xml/axis.xml";
        log("Document [" + url + "]");
        Object document = nav.getDocument(url);
        XPath contextpath = new BaseXPath("/", nav);
        log("Initial Context :: " + contextpath);
        List list = contextpath.selectNodes(document);
        Iterator iter = list.iterator();
        while (iter.hasNext()) {
            Object context = iter.next();
            assertValueOfXPath("a.4", context, "name(/root/a/a.3/following-sibling::*[1])");
            assertValueOfXPath("a.5", context, "name(/root/a/a.3/following-sibling::*[2])");
        }
    }

    private void assertCountXPath(int expectedSize, Object context, String xpathStr) throws JaxenException {
        assertCountXPath2(expectedSize, context, xpathStr);
    }

    public void testid54219() throws JaxenException {
        Navigator nav = getNavigator();
        String url = "xml/web.xml";
        log("Document [" + url + "]");
        Object document = nav.getDocument(url);
        XPath contextpath = new BaseXPath("/", nav);
        log("Initial Context :: " + contextpath);
        List list = contextpath.selectNodes(document);
        Iterator iter = list.iterator();
        while (iter.hasNext()) {
            Object context = iter.next();
            assertValueOfXPath("snoop", context, "/web-app/servlet[1]/servlet-name");
            assertValueOfXPath("snoop", context, "/web-app/servlet[1]/servlet-name/text()");
            assertValueOfXPath("file", context, "/web-app/servlet[2]/servlet-name");
            assertValueOfXPath("file", context, "/web-app/servlet[2]/servlet-name/text()");
        }
    }

    private void log(boolean actualVerbose, String text) {
        if (actualVerbose) System.out.println(text);
    }

    public void testGetNodeType() throws FunctionCallException, UnsupportedAxisException {
        Navigator nav = getNavigator();
        Object document = nav.getDocument("xml/testNamespaces.xml");
        int count = 0;
        Iterator descendantOrSelfAxisIterator = nav.getDescendantOrSelfAxisIterator(document);
        while (descendantOrSelfAxisIterator.hasNext()) {
            Object node = descendantOrSelfAxisIterator.next();
            Iterator namespaceAxisIterator = nav.getNamespaceAxisIterator(node);
            while (namespaceAxisIterator.hasNext()) {
                count++;
                assertEquals("Node type mismatch", Pattern.NAMESPACE_NODE, nav.getNodeType(namespaceAxisIterator.next()));
            }
        }
        assertEquals(25, count);
    }

    public void testNamespaceNodesHaveParent() throws JaxenException {
        Navigator nav = getNavigator();
        String url = "xml/testNamespaces.xml";
        log("Document [" + url + "]");
        Object document = nav.getDocument(url);
        XPath contextpath = new BaseXPath("/", nav);
        log("Initial Context :: " + contextpath);
        List list = contextpath.selectNodes(document);
        Iterator iter = list.iterator();
        while (iter.hasNext()) {
            Object context = iter.next();
            assertCountXPath(1, context, "/Template/namespace::xml/parent::Template");
        }
    }

    /** 
     * attributes can also be used as context nodes
     */
    public void testAttributeAsContext() throws JaxenException {
        Navigator nav = getNavigator();
        String url = "xml/id.xml";
        log("Document [" + url + "]");
        Object document = nav.getDocument(url);
        XPath contextpath = new BaseXPath("/foo/@id", nav);
        log("Initial Context :: " + contextpath);
        List list = contextpath.selectNodes(document);
        Iterator iter = list.iterator();
        while (iter.hasNext()) {
            Object context = iter.next();
            assertCountXPath(1, context, "parent::foo");
        }
    }

    /** 
     * Some tests for the normalize-space() function
     */
    public void testNormalizeSpaceFunction() throws JaxenException {
        Navigator nav = getNavigator();
        String url = "xml/simple.xml";
        log("Document [" + url + "]");
        Object document = nav.getDocument(url);
        XPath contextpath = new BaseXPath("/", nav);
        log("Initial Context :: " + contextpath);
        List list = contextpath.selectNodes(document);
        Iterator iter = list.iterator();
        while (iter.hasNext()) {
            Object context = iter.next();
            assertValueOfXPath("abc", context, "normalize-space('    abc    ')");
            assertValueOfXPath("a b c", context, "normalize-space(' a  b  c  ')");
            assertValueOfXPath("a b c", context, "normalize-space(' a \n b \n  c')");
            assertValueOfXPath("", context, "normalize-space(' ')");
            assertValueOfXPath("", context, "normalize-space('')");
        }
    }

    /** 
     * test the translate() function
     */
    public void testTranslateFunction() throws JaxenException {
        Navigator nav = getNavigator();
        String url = "xml/simple.xml";
        log("Document [" + url + "]");
        Object document = nav.getDocument(url);
        XPath contextpath = new BaseXPath("/", nav);
        log("Initial Context :: " + contextpath);
        List list = contextpath.selectNodes(document);
        Iterator iter = list.iterator();
        while (iter.hasNext()) {
            Object context = iter.next();
            assertValueOfXPath("", context, "translate( '', '', '' )");
            assertValueOfXPath("abcd", context, "translate( 'abcd', '', '' )");
            assertValueOfXPath("abcd", context, "translate( 'abcd', 'abcd', 'abcd' )");
            assertValueOfXPath("abcd", context, "translate( 'abcd', 'dcba', 'dcba' )");
            assertValueOfXPath("dcba", context, "translate( 'abcd', 'abcd', 'dcba' )");
            assertValueOfXPath("ab", context, "translate( 'abcd', 'abcd', 'ab' )");
            assertValueOfXPath("cd", context, "translate( 'abcd', 'cdab', 'cd' )");
            assertValueOfXPath("xy", context, "translate( 'abcd', 'acbd', 'xy' )");
            assertValueOfXPath("abcd", context, "translate( 'abcd', 'abcdb', 'abcdb' )");
            assertValueOfXPath("abcd", context, "translate( 'abcd', 'abcd', 'abcdb' )");
        }
    }

    /** 
     * test cases for String extension functions
     */
    public void testStringExtensionFunctions() throws JaxenException {
        Navigator nav = getNavigator();
        String url = "xml/web.xml";
        log("Document [" + url + "]");
        Object document = nav.getDocument(url);
        XPath contextpath = new BaseXPath("/web-app/servlet[1]", nav);
        log("Initial Context :: " + contextpath);
        List list = contextpath.selectNodes(document);
        Iterator iter = list.iterator();
        while (iter.hasNext()) {
            Object context = iter.next();
            assertValueOfXPath("SNOOPSERVLET", context, "upper-case( servlet-class )");
            assertValueOfXPath("snoopservlet", context, "lower-case( servlet-class )");
            assertValueOfXPath("SNOOPSERVLET", context, "upper-case( servlet-class, 'fr' )");
            assertValueOfXPath("SNOOPSERVLET", context, "upper-case( servlet-class, 'fr-CA' )");
            assertValueOfXPath("SNOOPSERVLET", context, "upper-case( servlet-class, 'es-ES-Traditional_WIN' )");
            assertValueOfXPath("true", context, "ends-with( servlet-class, 'Servlet' )");
            assertValueOfXPath("false", context, "ends-with( servlet-class, 'S' )");
        }
    }

    public void log(String text) {
        log(verbose, text);
    }

    /**
     *  test cases for the use of underscores in names
     */
    public void testUnderscoresInNames() throws JaxenException {
        Navigator nav = getNavigator();
        String url = "xml/underscore.xml";
        log("Document [" + url + "]");
        Object document = nav.getDocument(url);
        XPath contextpath = new BaseXPath("/", nav);
        log("Initial Context :: " + contextpath);
        List list = contextpath.selectNodes(document);
        Iterator iter = list.iterator();
        while (iter.hasNext()) {
            Object context = iter.next();
            assertCountXPath(1, context, "/root/@a");
            assertCountXPath(1, context, "/root/@_a");
            assertCountXPath(1, context, "/root/b");
            assertCountXPath(1, context, "/root/_b");
            assertValueOfXPath("1", context, "/root/@a");
            assertValueOfXPath("2", context, "/root/@_a");
            assertValueOfXPath("1", context, "/root/b");
            assertValueOfXPath("2", context, "/root/_b");
        }
    }

    /** 
     * test namespace
     */
    public void testNamespacesAgain() throws JaxenException {
        Navigator nav = getNavigator();
        String url = "xml/namespaces.xml";
        log("Document [" + url + "]");
        Object document = nav.getDocument(url);
        XPath contextpath = new BaseXPath("/", nav);
        log("Initial Context :: " + contextpath);
        List list = contextpath.selectNodes(document);
        SimpleNamespaceContext nsContext = new SimpleNamespaceContext();
        nsContext.addNamespace("alias", "http://fooNamespace/");
        nsContext.addNamespace("bar", "http://barNamespace/");
        nsContext.addNamespace("voo", "http://fooNamespace/");
        nsContext.addNamespace("foo", "http://fooNamespace/");
        getContextSupport().setNamespaceContext(nsContext);
        Iterator iter = list.iterator();
        while (iter.hasNext()) {
            Object context = iter.next();
            assertCountXPath(1, context, "/*");
            assertCountXPath(1, context, "/foo:a");
            assertCountXPath(1, context, "/foo:a/b");
            assertCountXPath(1, context, "/voo:a/b/c");
            assertCountXPath(1, context, "/voo:a/bar:f");
            assertCountXPath(1, context, "/*[namespace-uri()='http://fooNamespace/' and local-name()='a']");
            assertCountXPath(1, context, "/*[local-name()='a' and namespace-uri()='http://fooNamespace/']/*[local-name()='x' and namespace-uri()='http://fooNamespace/']");
            assertCountXPath(1, context, "/*[local-name()='a' and namespace-uri()='http://fooNamespace/']/*[local-name()='x' and namespace-uri()='http://fooNamespace/']/*[local-name()='y' and namespace-uri()='http://fooNamespace/']");
        }
    }

    public void testid53992() throws JaxenException {
        Navigator nav = getNavigator();
        String url = "xml/pi.xml";
        log("Document [" + url + "]");
        Object document = nav.getDocument(url);
        XPath contextpath = new BaseXPath("/", nav);
        log("Initial Context :: " + contextpath);
        List list = contextpath.selectNodes(document);
        Iterator iter = list.iterator();
        while (iter.hasNext()) {
            Object context = iter.next();
            assertCountXPath(3, context, "//processing-instruction()");
            assertCountXPath(2, context, "//processing-instruction('cheese')");
            Object result = assertCountXPath2(1, context, "//processing-instruction('toast')");
            assertValueOfXPath("is tasty", result, "string()");
        }
    }

    /** 
     * test sibling axes 
     */
    public void testid54145() throws JaxenException {
        Navigator nav = getNavigator();
        String url = "xml/axis.xml";
        log("Document [" + url + "]");
        Object document = nav.getDocument(url);
        XPath contextpath = new BaseXPath("/root", nav);
        log("Initial Context :: " + contextpath);
        List list = contextpath.selectNodes(document);
        Iterator iter = list.iterator();
        while (iter.hasNext()) {
            Object context = iter.next();
            assertCountXPath(0, context, "preceding-sibling::*");
        }
    }

    public void testid54180() throws JaxenException {
        Navigator nav = getNavigator();
        String url = "xml/axis.xml";
        log("Document [" + url + "]");
        Object document = nav.getDocument(url);
        XPath contextpath = new BaseXPath("/", nav);
        log("Initial Context :: " + contextpath);
        List list = contextpath.selectNodes(document);
        Iterator iter = list.iterator();
        while (iter.hasNext()) {
            Object context = iter.next();
            assertValueOfXPath("a.2", context, "name(/root/a/a.3/preceding-sibling::*[1])");
            assertValueOfXPath("a.1", context, "name(/root/a/a.3/preceding-sibling::*[2])");
        }
    }

    public void testFloatingPointArithmetic() throws JaxenException {
        Navigator nav = getNavigator();
        String url = "xml/numbers.xml";
        log("Document [" + url + "]");
        Object document = nav.getDocument(url);
        XPath contextpath = new BaseXPath("/", nav);
        log("Initial Context :: " + contextpath);
        List list = contextpath.selectNodes(document);
        Iterator iter = list.iterator();
        while (iter.hasNext()) {
            Object context = iter.next();
            assertValueOfXPath("true", context, "(8.5 * 2.0 + 1) = 18");
            assertValueOfXPath("true", context, "(1.00 + 8.5 * 2) = 18.0");
            assertValueOfXPath("true", context, "(7.1 - 7.1 + 1.5) = 1.5");
            assertValueOfXPath("true", context, "(8.000 - 4.0 + 5 - 6.00) = 3");
            assertValueOfXPath("0", context, "3.5 - 2.5 - 1.0");
            assertValueOfXPath("1", context, "8.0 div 4.0 div 2.0");
            assertValueOfXPath("3", context, "3.0 mod 7.0 mod 5.0");
            assertValueOfXPath("false", context, "1.5 = 2.3 = 2.3");
            assertValueOfXPath("false", context, "2.1 != 3.2 != 1.9");
            assertValueOfXPath("false", context, "3.8 > 2.7 > 1.6");
            assertValueOfXPath("false", context, "3.4 >= 2.5 >= 2.5");
            assertValueOfXPath("true", context, "1.4 < 2.3 < 3.2");
            assertValueOfXPath("true", context, "2.5 <= 2.5 <= 3.5");
        }
    }

    /** 
     * test other node types
     */
    public void testNodeTypes() throws JaxenException {
        Navigator nav = getNavigator();
        String url = "xml/contents.xml";
        log("Document [" + url + "]");
        Object document = nav.getDocument(url);
        XPath contextpath = new BaseXPath("/", nav);
        log("Initial Context :: " + contextpath);
        List list = contextpath.selectNodes(document);
        Iterator iter = list.iterator();
        while (iter.hasNext()) {
            Object context = iter.next();
            assertCountXPath(3, context, "processing-instruction()");
            assertCountXPath(3, context, "/processing-instruction()");
            assertCountXPath(1, context, "/comment()");
            assertCountXPath(1, context, "comment()");
            assertCountXPath(2, context, "/child::node()/comment()");
            assertCountXPath(2, context, "/*/comment()");
            assertCountXPath(3, context, "//comment()");
        }
    }

    public void testStringFunction1() throws JaxenException {
        Navigator nav = getNavigator();
        String url = "xml/simple.xml";
        log("Document [" + url + "]");
        Object document = nav.getDocument(url);
        XPath contextpath = new BaseXPath("/root", nav);
        log("Initial Context :: " + contextpath);
        List list = contextpath.selectNodes(document);
        Iterator iter = list.iterator();
        while (iter.hasNext()) {
            Object context = iter.next();
            assertValueOfXPath("abd", context, "string()");
        }
    }

    /**
     *  test for jaxen-3
     */
    public void testJaxen3() throws JaxenException {
        Navigator nav = getNavigator();
        String url = "xml/simple.xml";
        log("Document [" + url + "]");
        Object document = nav.getDocument(url);
        XPath contextpath = new BaseXPath("/", nav);
        log("Initial Context :: " + contextpath);
        List list = contextpath.selectNodes(document);
        Iterator iter = list.iterator();
        while (iter.hasNext()) {
            Object context = iter.next();
            assertValueOfXPath("abd", context, "string()");
        }
    }

    public void testNodesetEqualsNumber() throws JaxenException {
        Navigator nav = getNavigator();
        String url = "xml/numbers.xml";
        log("Document [" + url + "]");
        Object document = nav.getDocument(url);
        XPath contextpath = new BaseXPath("/", nav);
        log("Initial Context :: " + contextpath);
        List list = contextpath.selectNodes(document);
        Iterator iter = list.iterator();
        while (iter.hasNext()) {
            Object context = iter.next();
            assertValueOfXPath("true", context, "/numbers/set/nr = '-3'");
            assertValueOfXPath("true", context, "/numbers/set/nr = -3");
            assertValueOfXPath("true", context, "/numbers/set/nr = 24");
            assertValueOfXPath("true", context, "/numbers/set/nr/@value = '9999'");
            assertValueOfXPath("true", context, "/numbers/set/nr/@value = 9999.0");
            assertValueOfXPath("true", context, "/numbers/set/nr/@value = 66");
        }
    }

    public void testCorrectPredicateApplication() throws JaxenException {
        Navigator nav = getNavigator();
        String url = "xml/much_ado.xml";
        log("Document [" + url + "]");
        Object document = nav.getDocument(url);
        XPath contextpath = new BaseXPath("/", nav);
        log("Initial Context :: " + contextpath);
        List list = contextpath.selectNodes(document);
        Iterator iter = list.iterator();
        while (iter.hasNext()) {
            Object context = iter.next();
            assertValueOfXPath("5", context, "count(/PLAY/ACT/SCENE[1])");
        }
    }

    public void testAttributeParent() throws JaxenException {
        Navigator nav = getNavigator();
        String url = "xml/id.xml";
        log("Document [" + url + "]");
        Object document = nav.getDocument(url);
        XPath contextpath = new BaseXPath("/", nav);
        log("Initial Context :: " + contextpath);
        List list = contextpath.selectNodes(document);
        Iterator iter = list.iterator();
        while (iter.hasNext()) {
            Object context = iter.next();
            assertCountXPath(1, context, "/foo/@id/parent::foo");
        }
    }

    /**
     *  test name
     */
    public void testid54298() throws JaxenException {
        Navigator nav = getNavigator();
        String url = "xml/web.xml";
        log("Document [" + url + "]");
        Object document = nav.getDocument(url);
        XPath contextpath = new BaseXPath("/", nav);
        log("Initial Context :: " + contextpath);
        List list = contextpath.selectNodes(document);
        Iterator iter = list.iterator();
        while (iter.hasNext()) {
            Object context = iter.next();
            Object result = assertCountXPath2(1, context, "*");
            assertValueOfXPath("web-app", result, "name()");
            result = assertCountXPath2(1, context, "./*");
            assertValueOfXPath("web-app", result, "name()");
            result = assertCountXPath2(1, context, "child::*");
            assertValueOfXPath("web-app", result, "name()");
            result = assertCountXPath2(1, context, "/*");
            assertValueOfXPath("web-app", result, "name()");
            result = assertCountXPath2(1, context, "/child::node()");
            assertValueOfXPath("web-app", result, "name(.)");
            result = assertCountXPath2(1, context, "child::node()");
            assertValueOfXPath("web-app", result, "name(.)");
            assertValueOfXPath("", context, "name()");
            assertValueOfXPath("", context, "name(.)");
            assertValueOfXPath("", context, "name(parent::*)");
            assertValueOfXPath("", context, "name(/)");
            assertValueOfXPath("", context, "name(/.)");
            assertValueOfXPath("", context, "name(/self::node())");
            assertValueOfXPath("web-app", context, "name(node())");
            assertValueOfXPath("web-app", context, "name(/node())");
            assertValueOfXPath("web-app", context, "name(/*)");
            assertValueOfXPath("web-app", context, "name(/child::*)");
            assertValueOfXPath("web-app", context, "name(/child::node())");
            assertValueOfXPath("web-app", context, "name(/child::node())");
            assertValueOfXPath("web-app", context, "name(child::node())");
            assertValueOfXPath("web-app", context, "name(./*)");
            assertValueOfXPath("web-app", context, "name(*)");
        }
    }

    private Context getContext(Object contextNode) {
        Context context = new Context(getContextSupport());
        List list = new ArrayList(1);
        list.add(contextNode);
        context.setNodeSet(list);
        return context;
    }

    public void testid54853() throws JaxenException {
        Navigator nav = getNavigator();
        String url = "xml/web.xml";
        log("Document [" + url + "]");
        Object document = nav.getDocument(url);
        XPath contextpath = new BaseXPath("/", nav);
        log("Initial Context :: " + contextpath);
        List list = contextpath.selectNodes(document);
        Iterator iter = list.iterator();
        while (iter.hasNext()) {
            Object context = iter.next();
            assertCountXPath(19, context, "descendant-or-self::*");
            assertCountXPath(19, context, "descendant::*");
            assertCountXPath(19, context, "/descendant::*");
            assertCountXPath(19, context, "/descendant-or-self::*");
            assertCountXPath(2, context, "/descendant::servlet");
            assertCountXPath(2, context, "/descendant-or-self::servlet");
            assertCountXPath(2, context, "descendant-or-self::servlet");
            assertCountXPath(2, context, "descendant::servlet");
            assertCountXPath(2, context, "/*/servlet");
            assertValueOfXPath("2", context, "count(/*/servlet)");
            assertCountXPath(2, context, "//servlet");
            assertValueOfXPath("2", context, "count(//servlet)");
        }
    }

    public void testStringFunction2() throws JaxenException {
        Navigator nav = getNavigator();
        String url = "xml/simple.xml";
        log("Document [" + url + "]");
        Object document = nav.getDocument(url);
        XPath contextpath = new BaseXPath("/root/a", nav);
        log("Initial Context :: " + contextpath);
        List list = contextpath.selectNodes(document);
        Iterator iter = list.iterator();
        while (iter.hasNext()) {
            Object context = iter.next();
            assertValueOfXPath("a", context, "string()");
        }
    }

    /** 
     * test cases for preceding axis with different node types
     */
    public void testPrecedingSiblingAxis() throws JaxenException {
        Navigator nav = getNavigator();
        String url = "xml/pi2.xml";
        log("Document [" + url + "]");
        Object document = nav.getDocument(url);
        XPath contextpath = new BaseXPath("/a/c", nav);
        log("Initial Context :: " + contextpath);
        List list = contextpath.selectNodes(document);
        Iterator iter = list.iterator();
        while (iter.hasNext()) {
            Object context = iter.next();
            assertCountXPath(1, context, "//processing-instruction()");
            assertCountXPath(1, context, "preceding-sibling::*");
            assertCountXPath(5, context, "preceding-sibling::node()");
            assertCountXPath(1, context, "preceding-sibling::*[1]");
            assertCountXPath(1, context, "preceding-sibling::processing-instruction()");
            assertValueOfXPath("order-by=\"x\"", context, "preceding-sibling::processing-instruction()");
            assertValueOfXPath("foo", context, "preceding-sibling::*[1]");
            assertValueOfXPath("order-by=\"x\"", context, "preceding-sibling::node()[2]");
        }
    }

    /**
     *  test for jaxen-3
     */
    public void testJaxen3dupe() throws JaxenException {
        Navigator nav = getNavigator();
        String url = "xml/jaxen3.xml";
        log("Document [" + url + "]");
        Object document = nav.getDocument(url);
        XPath contextpath = new BaseXPath("/", nav);
        log("Initial Context :: " + contextpath);
        List list = contextpath.selectNodes(document);
        Iterator iter = list.iterator();
        while (iter.hasNext()) {
            Object context = iter.next();
            assertCountXPath(1, context, "/Configuration/hostname/attrlist/hostname[. = 'CE-A'] ");
        }
    }

    public void testNoNamespace() throws JaxenException {
        Navigator nav = getNavigator();
        String url = "xml/defaultNamespace.xml";
        log("Document [" + url + "]");
        Object document = nav.getDocument(url);
        XPath contextpath = new BaseXPath("/", nav);
        log("Initial Context :: " + contextpath);
        List list = contextpath.selectNodes(document);
        Iterator iter = list.iterator();
        while (iter.hasNext()) {
            Object context = iter.next();
            assertCountXPath(0, context, "/a/b/c");
        }
    }

    public void testNamespaceResolution() throws JaxenException {
        Navigator nav = getNavigator();
        String url = "xml/defaultNamespace.xml";
        log("Document [" + url + "]");
        Object document = nav.getDocument(url);
        XPath contextpath = new BaseXPath("/", nav);
        log("Initial Context :: " + contextpath);
        List list = contextpath.selectNodes(document);
        SimpleNamespaceContext nsContext = new SimpleNamespaceContext();
        nsContext.addNamespace("dummy", "http://dummyNamespace/");
        getContextSupport().setNamespaceContext(nsContext);
        Iterator iter = list.iterator();
        while (iter.hasNext()) {
            Object context = iter.next();
            assertCountXPath(1, context, "/dummy:a/dummy:b/dummy:c");
        }
    }

    public void testid54266() throws JaxenException {
        Navigator nav = getNavigator();
        String url = "xml/web.xml";
        log("Document [" + url + "]");
        Object document = nav.getDocument(url);
        XPath contextpath = new BaseXPath("/web-app/servlet[2]/servlet-name", nav);
        log("Initial Context :: " + contextpath);
        List list = contextpath.selectNodes(document);
        Iterator iter = list.iterator();
        while (iter.hasNext()) {
            Object context = iter.next();
            assertCountXPath(3, context, "preceding::*");
        }
    }
}
