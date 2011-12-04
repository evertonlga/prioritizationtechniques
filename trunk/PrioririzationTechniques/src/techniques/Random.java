package techniques;

import japa.parser.ast.stmt.Statement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Random implements PrioritizationTechnique{

	public static ArrayList applyRandom(ArrayList testMethods) {
		Collections.shuffle(testMethods);
		return testMethods;
		
	}
	
	public static ArrayList applyRandombySuite(List<Statement> list) {
		Statement first = list.get(0);
		Statement last = list.get(list.size()-1);
		List<Statement> sublist = list.subList(1, list.size()-1);
		Collections.shuffle(sublist);
		ArrayList<Statement> returnArray = new ArrayList<Statement>(sublist);
		for (Statement statement : returnArray) {
			System.out.println(statement.toString().substring(statement.toString().indexOf("test.")+5, statement.toString().indexOf(".class")));
		}
		returnArray.add(0, first);
		returnArray.add(returnArray.size(), last);
		return returnArray;
	}
}
