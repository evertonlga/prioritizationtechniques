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

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		//
//		String nameFolder = args[0];
//		String destinationFolder = args[1];
//		String outputPackage = args[2];
//		String priorizationTechinique = args[3];	
//		
		//extractTestClasses();
		
		extractBagClass();
	}

	private static void extractTestClasses() {
		String nameFolder = "JaxenTests";
		String destinationFolder = "src/test";
		String outputPackage = "test";
		String priorizationTechinique = "Random";
		TechniqueExecutorByClass te = new TechniqueExecutorByClass();
		te.executor(nameFolder, destinationFolder, outputPackage, priorizationTechinique);
	}

	private static void extractBagClass() {
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
	}
}
