package byClass.output;
import junit.framework.Test;
import junit.framework.TestSuite;
public class Suite {
public static Test suite() {
TestSuite result = new TestSuite();
result.addTest(new TestSuite(DOM4JNavigatorTest1.class));
return result;
 } 
  }