package extractor;

import japa.parser.JavaParser;
import japa.parser.ParseException;
import japa.parser.ast.CompilationUnit;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class CompilatonUnitExtractor {

	public ArrayList<CompilationUnit> getCompUnitsSource(String nameDir){
		FileInputStream in = null;
		File folder = new File(nameDir);
		String[] list = folder.list();
		for (String string : list) {
			System.out.println(string);
		}
		File[] files = folder.listFiles();
		System.out.println(nameDir);
		System.out.println("NOMES DOS ARQUIVOS:");
		for (File string : files) {
			System.out.println(string.getName());
		}
		System.out.println(files);
		System.out.println("Length: "+ files.length);
				
		ArrayList<CompilationUnit> cUnitsSource = new ArrayList<CompilationUnit>();
		for (File file : files) {
			System.out.println("file   "+file);
			if (file.getName().endsWith(".java")){
				try {
					in = new FileInputStream(file);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			try {
				// parse the file
				cUnitsSource.add (JavaParser.parse(in));
			} catch (ParseException e) {
				e.printStackTrace();
			} finally {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			}
			
		}
		return cUnitsSource;
	}
	
	
	public CompilationUnit getCompUnitSource(String nameDir, String fileName){
		FileInputStream in = null;
		File folder = new File(nameDir);
		File[] files = folder.listFiles();
		
		CompilationUnit cUnitSource = new CompilationUnit();
		for (File file : files) {
			if (file.getName().endsWith(".java")){
				try {
					in = new FileInputStream(file);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			try {
				// parse the file
				CompilationUnit currentfile = JavaParser.parse(in);
				if (currentfile.getTypes().get(0).getName().equals(fileName)){
					return currentfile;
				}
				
			} catch (ParseException e) {
				e.printStackTrace();
			} finally {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			}
			
		}
		return null;
	}
}
