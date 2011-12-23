package util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class AnalysisBatGenerator {
	
	public static void generateAnalysisBat(String testClassesFolder){
		try {
			File f = new File("analysis/run.bat");
			if (f.exists()){
				f.delete();
			}
			FileWriter file = new FileWriter("analysis/run.bat",true);
			
			String str = "";
			
			String clear = "java -cp lib/generateOutputFile.jar; main.ClearEnvironment"+ "\r\n";
			String classExecution = "java -cp lib/testClasses.jar;lib/Jaxen2.jar;lib/generateOutputFile.jar;lib/dom4j-2.0.0-ALPHA-2.jar;lib/hamcrest-core-1.1.jar;lib/jdom-1.1.2.jar;lib/xom-1.2.7.jar;lib/junit-4.10.jar; main.Main ";
			File folder = new File(testClassesFolder);
			String str2 = "";
			for (File testClass : folder.listFiles()) {
				if (testClass.getName().endsWith(".java")){
					String name = testClass.getName().substring(0, testClass.getName().indexOf(".java"));
					str2+= classExecution + name + "\r\n";
				}
			}
			
			str+= clear + str2;
			
			file.write(str);
			file.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main (String args[]){
		generateAnalysisBat("src/byClass/output");
	}

}
