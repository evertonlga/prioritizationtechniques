package techniques;

import java.util.ArrayList;
import java.util.Collections;

public class Random implements PrioritizationTechnique{

	public static ArrayList applyRandom(ArrayList testMethods) {
		Collections.shuffle(testMethods);
		return testMethods;
		
	}
}
