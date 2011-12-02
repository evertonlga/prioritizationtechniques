package main;

import java.io.File;

public abstract class TechniqueExecutor {
	
	public void executor(String nameFolder, String destinationFolder,
			String outputPackage, String priorizationTechinique) {
		
		createOutputFolder(destinationFolder);
	}

	private static void createOutputFolder(String destinationFolder) {
		boolean success = (new File(destinationFolder)).mkdirs(); 
		if (success)
			System.out.println("CRIOU");
	}


}
