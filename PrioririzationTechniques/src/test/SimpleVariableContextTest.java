package test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import org.jaxen.SimpleVariableContext;
import org.jaxen.UnresolvableException;
import junit.framework.TestCase;

public class SimpleVariableContextTest extends TestCase {

    public void testSerializationFormatHasNotChanged() throws IOException, ClassNotFoundException, UnresolvableException {
        InputStream in = new FileInputStream("xml/simplevariablecontext.ser");
        ObjectInputStream ois = new ObjectInputStream(in);
        Object o = ois.readObject();
        SimpleVariableContext context = (SimpleVariableContext) o;
        assertEquals("String Value", context.getVariableValue("", "", "s"));
        assertEquals(new Double(3.1415292), context.getVariableValue("", "", "x"));
        assertEquals(Boolean.TRUE, context.getVariableValue("", "", "b"));
        assertEquals("", "");
    }

    public void testRoundTripSerialization() throws IOException, ClassNotFoundException, UnresolvableException {
        SimpleVariableContext original = new SimpleVariableContext();
        original.setVariableValue("s", "String Value");
        original.setVariableValue("x", new Double(3.1415292));
        original.setVariableValue("b", Boolean.TRUE);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(out);
        oos.writeObject(original);
        oos.close();
        byte[] pickled = out.toByteArray();
        InputStream in = new ByteArrayInputStream(pickled);
        ObjectInputStream ois = new ObjectInputStream(in);
        Object o = ois.readObject();
        SimpleVariableContext copy = (SimpleVariableContext) o;
        assertEquals("String Value", copy.getVariableValue("", "", "s"));
        assertEquals(new Double(3.1415292), copy.getVariableValue("", "", "x"));
        assertEquals(Boolean.TRUE, copy.getVariableValue("", "", "b"));
        assertEquals("", "");
    }
}
