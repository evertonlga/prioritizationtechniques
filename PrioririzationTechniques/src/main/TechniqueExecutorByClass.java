package main;

import japa.parser.ast.CompilationUnit;
import java.util.ArrayList;

import techniques.Random;
import extractor.CompilatonUnitExtractor;
import extractor.Extractor;
import fileGenerator.FileGenerator;

public class TechniqueExecutorByClass extends TechniqueExecutor{

	public void executor(String nameFolder, String destinationFolder,
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
			FileGenerator.generateTestClasses(compilationUnit, elements, destinationFolder, outputPackage);
		}
	}

	public static ArrayList applyTechnique(ArrayList elements, String priorizationTechinique) {
		if (priorizationTechinique.equals("Random")){
			return Random.applyRandom(elements);
		}
		return null;
	}


	public void executor(String nameFolder, String nameFile,
			String destinationFolder, String outputPackage,
			String priorizationTechinique) {
		super.executor(nameFolder, destinationFolder, outputPackage);	
		execution(nameFolder, nameFile, destinationFolder, outputPackage, priorizationTechinique, false);
		
	}


	private void execution(String nameFolder, String nameFile,
			String destinationFolder, String outputPackage,
			String priorizationTechinique, boolean b) {
		ArrayList<CompilationUnit> compUnits = new CompilatonUnitExtractor().getCompUnitsSource(nameFolder);
		for (CompilationUnit compilationUnit : compUnits) {	 		
			if (compilationUnit.getTypes().get(0).getName().equals(nameFile)){
				ArrayList[] elements = Extractor.extract(compilationUnit, false); 
				elements[5] = applyTechnique(elements[5], priorizationTechinique);
				FileGenerator.generateTestClasses(compilationUnit, elements, destinationFolder, outputPackage);
				return;
			}
		}
		
	}
}
