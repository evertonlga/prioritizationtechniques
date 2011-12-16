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
		ArrayList<CompilationUnit> compUnits = new CompilatonUnitExtractor().getCompUnitsSource(nameFolder);
		System.out.println(nameFolder);
		System.out.println("AQUI 0");
//		System.out.println(compUnits);
		for (CompilationUnit compilationUnit : compUnits) {	 		
			if (compilationUnit.getTypes().get(0).getName().equals(nameFile)){
				ArrayList[] elements = Extractor.extract(compilationUnit, false); 
				elements[5] = applyTechnique(elements[5], priorizationTechinique);
				System.out.println("AQUI");
				FileGenerator.generateTestClasses(compilationUnit, elements, destinationFolder, outputPackage, nameFile+index);
				return;
			}
		}
		
	}
	
	public int indexOfTheFirstFailTestCase(String nameFolder, String nameFile, String destinationFolder, String outputPackageOrig){
		
		destinationFolder = destinationFolder.replace('.', '/');
		String outputPackage = outputPackageOrig.replace('.', '/');
		
		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
		String fileToCompile = destinationFolder+"/"+nameFile+".java";
		String copiledFile1 = destinationFolder+"/"+nameFile+".class";
		String copiledFile2 = "bin/"+outputPackage+"/"+nameFile+".class";
		
		
//		boolean success2 = (new File("bin/byClass/output/DOM4JNavigatorTest.class")).delete();
//		System.out.println(success2);
		
//		int compilationResult = compiler.run(null, null, null, fileToCompile);
		
//		 // arquivo a ser movido
//        File arquivo = new File(destinationFolder+"/"+nameFile+".class");
//    
//        // diretorio de destino
//        File dir = new File("bin/"+outputPackage);
//    
//        // move o arquivo para o novo diretorio
//        boolean ok = arquivo.renameTo(new File(dir, arquivo.getName()));
//		
//		try {
//			Class c = Class.forName(outputPackageOrig+"."+nameFile);
//			Method[] methods = c.getDeclaredMethods();
//			int i = 0;
//			JUnitCore juc = new JUnitCore();
//			for (Method method: methods) {
//				if (method.getName().startsWith("test")){
//					i++;
//					if (!juc.run(Request.method(c, method.getName())).wasSuccessful()){
//						boolean success = (new File("bin/"+outputPackage+"/"+nameFile+".class")).delete();
//						return i;
//					}
//				} 
//			}
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}
//		
		return -1;
	}
	
}
