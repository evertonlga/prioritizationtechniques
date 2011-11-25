package test;

import org.jaxen.xom.XOMXPath;
import nu.xom.Document;
import nu.xom.Element;
import nu.xom.Builder;

class XOMPerformance {

    public static void main(String[] args) {
        try {
            Document doc = new Builder().build("http://www.ibiblio.org/xml/examples/shakespeare/much_ado.xml");
            XOMXPath xpath = new XOMXPath("PLAY/ACT/SCENE/SPEECH/SPEAKER");
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
