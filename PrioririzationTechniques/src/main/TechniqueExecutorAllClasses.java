package main;

import japa.parser.ast.CompilationUnit;

import java.io.File;
import java.util.ArrayList;

import techniques.Random;
import extractor.CompilatonUnitExtractor;
import extractor.Extractor;
import fileGenerator.FileBagGenerator;
import fileGenerator.FileGenerator;

public class TechniqueExecutorAllClasses extends TechniqueExecutor{

	public void executor(String nameFolder, String destinationFolder,
			String outputPackage, String priorizationTechinique) {
		
		super.executor(nameFolder, destinationFolder, outputPackage, priorizationTechinique);	
		execution(nameFolder, destinationFolder, outputPackage, priorizationTechinique);
	}

	private static void execution(String nameFolder,
			String destinationFolder, String outputPackage,
			String priorizationTechinique) {
		ArrayList<CompilationUnit> compUnits = new CompilatonUnitExtractor().getCompUnitsSource(nameFolder);
		ArrayList<ArrayList[]> testClasses = new ArrayList<ArrayList[]>();
		for (CompilationUnit compilationUnit : compUnits) {			
			ArrayList[] elements = Extractor.extract(compilationUnit);
			testClasses.add(elements); 
		}
		FileBagGenerator.generateBagClass(testClasses, destinationFolder, outputPackage);
	}

}
