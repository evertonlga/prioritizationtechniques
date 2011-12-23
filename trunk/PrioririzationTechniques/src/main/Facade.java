package main;

import java.io.File;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;

import org.junit.runner.JUnitCore;
import org.junit.runner.Request;

import util.SuiteGenerator;

public class Facade {

	
	private int index;
	
	public int getIndex() {
		return index;
	}


	public void setIndex(int index) {
		this.index = index;
	}


	public void Facade(){
		this.index = 0;
	}


	private void prioritizationBySuite(String nameFolder, String destinationFolder, String outputPackage, String nameFileSuite, String nameNewFileSuite, String priorizationTechinique) {
		TechniqueExecutorBySuite tes = new TechniqueExecutorBySuite();
		tes.executor(nameFolder, destinationFolder, outputPackage, nameFileSuite, nameNewFileSuite, priorizationTechinique);
		
	}

	private void priotitizationAllTestClasses(String nameFolder, String destinationFolder, String outputPackage, String priorizationTechinique, boolean isBagClass) {
//		String nameFolder = "JaxenTests";
//		String destinationFolder = "src/test";
//		String outputPackage = "test";
//		String priorizationTechinique = "Random";
		TechniqueExecutorByClass te = new TechniqueExecutorByClass();
//		te.executor(nameFolder, destinationFolder, outputPackage, priorizationTechinique, isBagClass);
	}

	private void prioritizationByBagClass(String nameFolder, String destinationFolderBag, String outputPackageBag, String priorizationTechinique) {
//		String nameFolder = "JaxenTests";
//		String destinationFolder = "src/test";
//		String outputPackage = "testBag";
//		String priorizationTechinique = "Random";		
		TechniqueExecutorAllClasses te2 = new TechniqueExecutorAllClasses();
		te2.executor(nameFolder, destinationFolderBag, outputPackageBag, priorizationTechinique);
	}
	
	private void prioritizationByClass (String nameFolder, String nameFile, String destinationFolder, String outputPackage, String priorizationTechinique){
		TechniqueExecutorByClass te = new TechniqueExecutorByClass();
		
		setIndex(getIndex()+1);
		te.executor(nameFolder, nameFile, destinationFolder, outputPackage, priorizationTechinique, getIndex());
//		System.out.println(te.indexOfTheFirstFailTestCase(nameFolder, nameFile+getIndex(), destinationFolder, outputPackage));
	}
	
	private void prioritizationAllTestCases(String nameFolder, String destinationFolderBag, String outputPackageBag, String priorizationTechinique) {
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

//		String nameFolder = args[0];
//		String destinationFolder = args[1];
//		String outputPackage = args[2];
//		String priorizationTechinique = args[3];
//		String nameFile = args[4];

		String nameFolder = "src/byClass";
		String destinationFolder = "src/byClass/output";
		String outputPackage = "byClass.output";
		String priorizationTechinique = "Random";
		String nameFile = "DOM4JNavigatorTest";

		
		Facade f = new Facade();
		for (int i = 0; i < 485; i++){
			f.prioritizationByClass(nameFolder, nameFile, destinationFolder, outputPackage, priorizationTechinique);
		}
		
		
//		f.prioritizationByClass(nameFolder, nameFile, destinationFolder, outputPackage, priorizationTechinique);
	}
}
