package techniques;

import japa.parser.JavaParser;
import japa.parser.ParseException;
import japa.parser.ast.CompilationUnit;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import extractor.Extractor;
import fileGenerator.FileGenerator;

public class Random implements PrioritizationTechnique{

	public static ArrayList applyRandom(ArrayList testMethods) {
		Collections.shuffle(testMethods);
		return testMethods;
		
	}
	
//	public static void main (String args[]){
//		// Test Folder 
//		
//				
//	}

}
