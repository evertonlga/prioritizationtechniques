package main;

import japa.parser.ast.CompilationUnit;
import japa.parser.ast.body.MethodDeclaration;

import java.util.ArrayList;

import techniques.Randomize;

import extractor.CompilatonUnitExtractor;
import extractor.Extractor;
import fileGenerator.FileGenerator;

public class TechniqueExecutorBySuite extends TechniqueExecutor {
	
	public void executor(String nameFolder, String destinationFolder,
			String outputPackage, String nameFileSuite, String nameNewFileSuite ,String priorizationTechinique){
		super.executor(nameFolder, destinationFolder, outputPackage);	
		execution(nameFolder, destinationFolder, outputPackage, nameFileSuite, nameNewFileSuite, priorizationTechinique);
	}

	private void execution(String nameFolder, String destinationFolder,
			String outputPackage, String nameFileSuite, String nameNewFileSuite, String priorizationTechinique) {
		CompilationUnit compUnit = new CompilatonUnitExtractor().getCompUnitSource(nameFolder, nameFileSuite);
		ArrayList[] elements = Extractor.extract(compUnit, false); 
		elements[5] = applyTechnique(elements[5].get(0), priorizationTechinique);
		FileGenerator.generateTestClasses(compUnit, elements, destinationFolder, outputPackage, nameNewFileSuite);
		
	}
	
	private static ArrayList applyTechnique(Object meth, String priorizationTechinique) {
		MethodDeclaration method = (MethodDeclaration)meth;
		if (priorizationTechinique.equals("Random")){
			method.getBody().setStmts(Randomize.applyRandombySuite(method.getBody().getStmts()));
		}
		ArrayList returnArray = new ArrayList();
		returnArray.add(method);
		return returnArray;
	}
}
