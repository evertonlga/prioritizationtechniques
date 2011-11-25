package test;

import org.jaxen.Navigator;
import org.jaxen.xom.DocumentNavigator;
import nu.xom.Builder;

public class XOMNavigatorTest extends XPathTestBase {

    public XOMNavigatorTest(String name) {
        super(name);
    }

    private Builder builder = new Builder();

    public Object getDocument(String url) throws Exception {
        return this.builder.build(url);
    }

    public Navigator getNavigator() {
        return new DocumentNavigator();
    }
}
