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
		File[] files = folder.listFiles();
		
		ArrayList<CompilationUnit> cUnitsSource = new ArrayList<CompilationUnit>();
		for (File file : files) {
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
	
}
