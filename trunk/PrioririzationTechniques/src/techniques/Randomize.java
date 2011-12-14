package techniques;

import japa.parser.ast.body.MethodDeclaration;
import japa.parser.ast.stmt.Statement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Randomize implements PrioritizationTechnique{

	public static ArrayList applyRandom(ArrayList testMethods) {
		Collections.shuffle(testMethods);
		
//		java.util.Random ran = new java.util.Random();
//	    
//	    for(int i = 0; i < testMethods.size(); i++){
//	      int pos = ran.nextInt(testMethods.size());
//	      MethodDeclaration temp = (MethodDeclaration) testMethods.get(i);
//	      testMethods.set(i, testMethods.get(pos));
//	      testMethods.set(pos, temp);
//	    }
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
