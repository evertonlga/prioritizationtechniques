package main;

import java.util.ArrayList;

import org.junit.runner.JUnitCore;
import org.junit.runner.Request;

import extractor.Extractor;

import test.DOM4JNavigatorTest;


public class Main {

	
	private static void prioritizationBySuite(String nameFolder, String destinationFolder, String outputPackage, String priorizationTechinique) {
		TechniqueExecutorBySuite tes = new TechniqueExecutorBySuite();
		tes.executor(nameFolder, destinationFolder, outputPackage, priorizationTechinique);
		
	}

	private static void priotitizationAllTestClasses(String nameFolder, String destinationFolder, String outputPackage, String priorizationTechinique, boolean isBagClass) {
//		String nameFolder = "JaxenTests";
//		String destinationFolder = "src/test";
//		String outputPackage = "test";
//		String priorizationTechinique = "Random";
		TechniqueExecutorByClass te = new TechniqueExecutorByClass();
		te.executor(nameFolder, destinationFolder, outputPackage, priorizationTechinique, isBagClass);
	}

	private static void prioritizationByBagClass(String nameFolder, String destinationFolderBag, String outputPackageBag, String priorizationTechinique) {
//		String nameFolder = "JaxenTests";
//		String destinationFolder = "src/test";
//		String outputPackage = "testBag";
//		String priorizationTechinique = "Random";		
		TechniqueExecutorAllClasses te2 = new TechniqueExecutorAllClasses();
		te2.executor(nameFolder, destinationFolderBag, outputPackageBag, priorizationTechinique);
	}
	
	private static void prioritizationByClass (String nameFolder, String nameFile, String destinationFolder, String outputPackage, String priorizationTechinique){
//		ArrayList[] elements = Extractor.extract(filePath, false);
		TechniqueExecutorByClass te = new TechniqueExecutorByClass();
		te.executor(nameFolder, nameFile, destinationFolder, outputPackage, priorizationTechinique);
	}
	
	private static void prioritizationAllTestCases(String nameFolder, String destinationFolderBag, String outputPackageBag, String priorizationTechinique) {
//		String nameFolder = "JaxenTests";
//		String destinationFolder = "src/test";
//		String outputPackage = "testBag";
//		String priorizationTechinique = "Random";		
		TechniqueExecutorAllClasses te2 = new TechniqueExecutorAllClasses();
		te2.executorAllTestCases(nameFolder, destinationFolderBag, outputPackageBag, priorizationTechinique);
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		JUnitCore juc = new JUnitCore();
		System.out.println(juc.run(Request.method(DOM4JNavigatorTest.class, "testAbsoluteLocationPaths")).wasSuccessful());
//		System.out.println(org.junit.runner.JUnitCore.runClasses(DOM4JNavigatorTest.class).getFailureCount()); 
		//main("src/test/DOM4JNavigator.java"); 
		
//		String nameFolder = args[0];
//		String destinationFolder = args[1];
//		String outputPackage = args[2];
//		String priorizationTechinique = args[3];
//		String nameFolder = "JaxenTests";
//		String destinationFolder = "src/test";
//		String outputPackage = "test";
//		String priorizationTechinique = "Random";
		
		//priotitizationAllTestClasses(nameFolder, destinationFolder, outputPackage, priorizationTechinique, false);
//		
//		extractBagClass(nameFolder, destinationFolder, outputPackage, priorizationTechinique);
//		extractSuite("src/main", "src/bySuite", "bySuite", "Random");
		
		//Executing the random prioritization in the bag class
		//extractTestClasses("bagClass", "bagClass/out", "main", "Random", true);
		
		String nameFolder = "JaxenTests";
		String destinationFolder = "src/byClass";
		String outputPackage = "byClass";
		String priorizationTechinique = "Random";
		String nameFile = "DefaultXPathExprTest";
		prioritizationByClass(nameFolder, nameFile, destinationFolder, outputPackage, priorizationTechinique);
	}

}
