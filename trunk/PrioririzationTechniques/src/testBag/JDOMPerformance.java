package testBag;

import java.net.URL;
import org.jaxen.jdom.JDOMXPath;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;

class JDOMPerformance {

    public static void main_JDOMPerformance(String[] args) {
        try {
            URL u = new URL("http://www.ibiblio.org/xml/examples/shakespeare/much_ado.xml");
            Document doc = new SAXBuilder().build(u);
            JDOMXPath xpath = new JDOMXPath("PLAY/ACT/SCENE/SPEECH/SPEAKER");
            long start = System.currentTimeMillis();
            int count = 0;
            for (int i = 0; i < 1000; i++) {
                Element speaker = (Element) xpath.selectSingleNode(doc);
                count += (speaker == null ? 0 : 1);
            }
            long end = System.currentTimeMillis();
            System.out.println((end - start));
            System.out.println(count);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
