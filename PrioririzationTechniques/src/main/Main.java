package main;

import japa.parser.JavaParser;
import japa.parser.ParseException;
import japa.parser.ast.CompilationUnit;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import techniques.Random;
import extractor.CompilatonUnitExtractor;
import extractor.Extractor;
import fileGenerator.FileGenerator;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		String nameFolder = args[0];
//		String destinationFolder = args[1];
//		String outputPackage = args[2];
//		String priorizationTechinique = args[3];
		
		String nameFolder = "JaxenTests";
		String destinationFolder = "src/test";
		String outputPackage = "test";
		String priorizationTechinique = "Random";
//		TechniqueExecutorByClass te = new TechniqueExecutorByClass();
//		te.executor(nameFolder, destinationFolder, outputPackage, priorizationTechinique);
		
		String destinationFolderBag = "src/testBag";
		String outputPackageBag = "testBag";
		TechniqueExecutorAllClasses te2 = new TechniqueExecutorAllClasses();
		te2.executor(nameFolder, destinationFolderBag, outputPackageBag, priorizationTechinique);
	}
}
