package util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class SuiteGenerator {
	
	private String testClassesFolder;
	private String suiteClassName;
	private String targetPackage;
	
	public SuiteGenerator(String testClassesFolder, String suiteClassName, String targetPackage){
		this.targetPackage = targetPackage;
		this.suiteClassName = suiteClassName;
		this.testClassesFolder = testClassesFolder;
		createSuiteClass();
	}
	
	public void createSuiteClass(){
		File diretorio = new File(testClassesFolder);
		File fList[] = diretorio.listFiles();
		
		ArrayList<String> testClassesNames = new ArrayList<String>();
		for (File file : fList) {
			String name = file.getName();
			if (name.toLowerCase().contains("test")){
				int index = name.indexOf(".java");
				name = name.substring(0, index);
				testClassesNames.add(name);
			}
		}
		SuiteTemplate s = new SuiteTemplate(suiteClassName, targetPackage, testClassesFolder, testClassesNames);
		
		try {
			String destination = "src/"+targetPackage+"/"+suiteClassName+".java";
			System.out.println(destination);
			File file = new File(destination);
			if (!file.createNewFile()){
				file.delete();
				file = new File(destination);
			}
			FileWriter writer = new FileWriter(file,true);
			PrintWriter output = new PrintWriter(writer); 
			output.write(s.getCode());
			writer.close();
			output.close();
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}

}
