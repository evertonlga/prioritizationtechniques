package util;

import java.util.ArrayList;

public class SuiteTemplate {

	private ArrayList<String> testClasses;
	private String suiteName;
	private String packageName;
	private String testClassesPackage;
	private String code;
	
//	public SuiteTemplate() {
//		testClasses = new ArrayList<String>();
//	}
	
	public SuiteTemplate(String suiteName, String packageName, String testClassesPackage, ArrayList<String> testClasses) {
		this.testClasses = testClasses;
		this.suiteName = suiteName;
		this.packageName = packageName;
		this.testClassesPackage = testClassesPackage;
		this.code = generateCode();
	}
	
	public String generateCode(){
		String code = "";
		String packAdapted = packageName.replace("/", ".");
		String pack ="package "+packAdapted+";\n";
		String imports = "import junit.framework.Test;\n"+"import junit.framework.TestSuite;\n";
//				"import "+testClassesPackage+".*;\n";
		String suiteClassDeclaration = "public class "+suiteName+" {\n";
		String suiteMethod = "public static Test suite() {\n"+
		"TestSuite result = new TestSuite();\n";
		
		for (String testClass : testClasses) {
			suiteMethod+="result.addTest(new TestSuite("+testClass+".class));\n";
		}
		suiteMethod+="return result;\n } \n  }";
		
		code+= pack+imports+suiteClassDeclaration+suiteMethod;
		return code;
	}
	
	public String getCode(){
		return this.code;
	}
}
