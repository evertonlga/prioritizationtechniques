package testBag;

import java.net.URL;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.jaxen.dom4j.Dom4jXPath;

class DOM4JPerformance {

    public static void main_DOM4JPerformance(String[] args) {
        try {
            URL u = new URL("http://www.ibiblio.org/xml/examples/shakespeare/much_ado.xml");
            Document doc = new SAXReader().read(u);
            Dom4jXPath xpath = new Dom4jXPath("PLAY/ACT/SCENE/SPEECH/SPEAKER");
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
