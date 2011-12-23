package main;

import japa.parser.ast.CompilationUnit;

import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;

import org.junit.runner.JUnitCore;
import org.junit.runner.Request;


import techniques.Randomize;
import extractor.CompilatonUnitExtractor;
import extractor.Extractor;
import fileGenerator.FileGenerator;

public class TechniqueExecutorByClass extends TechniqueExecutor{

	public void executor(String nameFolder, String nameFile, String destinationFolder,
			String outputPackage, String priorizationTechinique, boolean isBagClass) {
		super.executor(nameFolder, destinationFolder, outputPackage);	
		execution(nameFolder, destinationFolder, outputPackage, priorizationTechinique, isBagClass);
	}


	private void execution(String nameFolder,
			String destinationFolder, String outputPackage,
			String priorizationTechinique, boolean isBagClass) {
		ArrayList<CompilationUnit> compUnits = new CompilatonUnitExtractor().getCompUnitsSource(nameFolder);
		for (CompilationUnit compilationUnit : compUnits) {	 		
			ArrayList[] elements = Extractor.extract(compilationUnit, isBagClass); 
			elements[5] = applyTechnique(elements[5], priorizationTechinique);
			FileGenerator.generateTestClasses(compilationUnit, elements, destinationFolder, outputPackage, "");
		}
	}

	public static ArrayList applyTechnique(ArrayList elements, String priorizationTechinique) {
		if (priorizationTechinique.equals("Random")){
			return Randomize.applyRandom(elements);
		}
		return null;
	}


	public void executor(String nameFolder, String nameFile,
			String destinationFolder, String outputPackage,
			String priorizationTechinique, int index) {
		super.executor(nameFolder, destinationFolder, outputPackage);	
		execution(nameFolder, nameFile, destinationFolder, outputPackage, priorizationTechinique, false, index);
		
	}


	private void execution(String nameFolder, String nameFile,
			String destinationFolder, String outputPackage,
			String priorizationTechinique, boolean b, int index) {
		CompilationUnit compUnit = new CompilatonUnitExtractor().getCompUnitSource(nameFolder, nameFile);
		
		ArrayList[] elements = Extractor.extract(compUnit, false); 
		elements[5] = applyTechnique(elements[5], priorizationTechinique);
		FileGenerator.generateTestClasses(compUnit, elements, destinationFolder, outputPackage, nameFile+index);
	}
	
	public int indexOfTheFirstFailTestCase(String nameFolder, String nameFile, Class cl){

		Class c;
		JUnitCore juc = new JUnitCore();

		Method[] methods = cl.getDeclaredMethods();
		int i = 0;
		for (Method method: methods) {
			if (method.getName().startsWith("test")){
				i++;
				//							System.out.println(method.getName());
				if (!juc.run(Request.method(cl, method.getName())).wasSuccessful()){

					return i;
				}
			} 
		}
		return -1;
	}
	
}
