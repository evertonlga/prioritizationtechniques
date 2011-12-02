package main;


import japa.parser.ast.CompilationUnit;
import japa.parser.ast.body.MethodDeclaration;

import java.util.ArrayList;

import test.AddNamespaceTest;
import test.ArithmeticTest;
import util.APFD;

import org.junit.runner.JUnitCore;
import org.junit.runner.Request;
import org.junit.runner.Result;

import extractor.CompilatonUnitExtractor;
import extractor.Extractor;

public class Main {

	private Result run;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		String nameFolder = args[0];
//		String destinationFolder = args[1];
//		String outputPackage = args[2];
//		String priorizationTechinique = args[3];	
//		
//		String nameFolder = "JaxenTests";
//		String destinationFolder = "src/test";
//		String outputPackage = "test";
//		String priorizationTechinique = "Random";
//		TechniqueExecutorByClass te = new TechniqueExecutorByClass();
//		te.executor(nameFolder, destinationFolder, outputPackage, priorizationTechinique);
		
//		String nameFolder = "JaxenTests";
		String nameFolder = "files";
		String destinationFolder = "src/test";
		String outputPackage = "test";
		String priorizationTechinique = "Random";
//		String destinationFolderBag = "src/testBag";
		String destinationFolderBag = "src/testBag2";
//		String outputPackageBag = "testBag";
		String outputPackageBag = "testBag2";
		TechniqueExecutorAllClasses te2 = new TechniqueExecutorAllClasses();
		te2.executor(nameFolder, destinationFolderBag, outputPackageBag, priorizationTechinique);
		

//		CompilatonUnitExtractor cue = new CompilatonUnitExtractor();
//		ArrayList<CompilationUnit> cUnits = cue.getCompUnitsSource("src/test");
//		CompilationUnit cunit = cUnits.get(2);
////		{modifier, imports, superClass, interfaces, names, testMethods, setUpTearDownMethods, fields, innerClasses, constructors};
//		ArrayList[] elements = Extractor.extract(cunit);
//		ArrayList<MethodDeclaration> testMethods = elements[5];
//		String nameClass = (String) elements[4].get(0);
//		
//		JUnitCore j = new JUnitCore();
//		Request request;
//		try {
//			Class<?> testClass = Class.forName("test."+nameClass);
//			int numberOfFaults = 0;
//			int [] faultIndexes = new int[testMethods.size()];
//			for (int i=0; i < testMethods.size(); i ++) {
//				request = Request.method(testClass, testMethods.get(i).getName());
//				Result result = j.run(request);
//				if (!result.wasSuccessful()){
//					faultIndexes[numberOfFaults] = i;
//					numberOfFaults++;
//				}
//			}
//			
//			System.out.println(testMethods.size());
//			System.out.println(numberOfFaults);
//			System.out.println(faultIndexes);
//			
//			int [] toAPFD = toAPFD(numberOfFaults, faultIndexes);
//			System.out.println(APFD.getAPFD(testMethods.size(), numberOfFaults, toAPFD));
////			new int [numberOfFaults];
//			
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	
	}

	private static int[] toAPFD(int numberOfFaults, int[] faultIndexes) {
		int[] returnArray = new int[numberOfFaults];
		int i = 0;
		for (int j : faultIndexes) {
			if (j > 0){
				returnArray[i] = j;
				i++;
			}
		}
		return returnArray;
	}
}
