package main;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		
//		String nameFolder = args[0];
//		String destinationFolder = args[1];
//		String outputPackage = args[2];
//		String priorizationTechinique = args[3];	
		
//		extractTestClasses(nameFolder, destinationFolder, outputPackage, priorizationTechinique);
//		
//		extractBagClass(nameFolder, destinationFolder, outputPackage, priorizationTechinique);
		extractSuite("src/main", "src/bySuite", "bySuite", "Random");
	}

	private static void extractSuite(String nameFolder, String destinationFolder, String outputPackage, String priorizationTechinique) {
		TechniqueExecutorBySuite tes = new TechniqueExecutorBySuite();
		tes.executor(nameFolder, destinationFolder, outputPackage, priorizationTechinique);
		
	}

	private static void extractTestClasses(String nameFolder, String destinationFolder, String outputPackage, String priorizationTechinique) {
//		String nameFolder = "JaxenTests";
//		String destinationFolder = "src/test";
//		String outputPackage = "test";
//		String priorizationTechinique = "Random";
		TechniqueExecutorByClass te = new TechniqueExecutorByClass();
		te.executor(nameFolder, destinationFolder, outputPackage, priorizationTechinique);
	}

	private static void extractBagClass(String nameFolder, String destinationFolderBag, String outputPackageBag, String priorizationTechinique) {
//		String nameFolder = "JaxenTests";
//		String destinationFolder = "src/test";
//		String outputPackage = "testBag";
//		String priorizationTechinique = "Random";		
		TechniqueExecutorAllClasses te2 = new TechniqueExecutorAllClasses();
		te2.executor(nameFolder, destinationFolderBag, outputPackageBag, priorizationTechinique);
	}
}
