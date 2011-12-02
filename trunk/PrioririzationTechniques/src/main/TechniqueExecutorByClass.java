package main;

import japa.parser.ast.CompilationUnit;
import java.util.ArrayList;

import techniques.Random;
import extractor.CompilatonUnitExtractor;
import extractor.Extractor;
import fileGenerator.FileGenerator;

public class TechniqueExecutorByClass extends TechniqueExecutor{

	public void executor(String nameFolder, String destinationFolder,
			String outputPackage, String priorizationTechinique) {
		super.executor(nameFolder, destinationFolder, outputPackage, priorizationTechinique);	
		execution(nameFolder, destinationFolder, outputPackage, priorizationTechinique);
	}


	private void execution(String nameFolder,
			String destinationFolder, String outputPackage,
			String priorizationTechinique) {
		ArrayList<CompilationUnit> compUnits = new CompilatonUnitExtractor().getCompUnitsSource(nameFolder);
		for (CompilationUnit compilationUnit : compUnits) {			
			ArrayList[] elements = Extractor.extract(compilationUnit);
			elements[5] = applyTechnique(elements[5], priorizationTechinique);
			FileGenerator.generateTestClasses(compilationUnit, elements, destinationFolder, outputPackage);
		}
	}

	private static ArrayList applyTechnique(ArrayList elements, String priorizationTechinique) {
		if (priorizationTechinique.equals("Random")){
			return Random.applyRandom(elements);
		}
		return null;
	}
}
