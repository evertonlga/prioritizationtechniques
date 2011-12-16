package main;

public class Facade {

	
	private int index;
	
	public int getIndex() {
		return index;
	}


	public void setIndex(int index) {
		this.index = index;
	}


	public void Facade(){
		this.index = 0;
	}


	private void prioritizationBySuite(String nameFolder, String destinationFolder, String outputPackage, String nameFileSuite, String nameNewFileSuite, String priorizationTechinique) {
		TechniqueExecutorBySuite tes = new TechniqueExecutorBySuite();
		tes.executor(nameFolder, destinationFolder, outputPackage, nameFileSuite, nameNewFileSuite, priorizationTechinique);
		
	}

	private void priotitizationAllTestClasses(String nameFolder, String destinationFolder, String outputPackage, String priorizationTechinique, boolean isBagClass) {
//		String nameFolder = "JaxenTests";
//		String destinationFolder = "src/test";
//		String outputPackage = "test";
//		String priorizationTechinique = "Random";
		TechniqueExecutorByClass te = new TechniqueExecutorByClass();
		te.executor(nameFolder, destinationFolder, outputPackage, priorizationTechinique, isBagClass);
	}

	private void prioritizationByBagClass(String nameFolder, String destinationFolderBag, String outputPackageBag, String priorizationTechinique) {
//		String nameFolder = "JaxenTests";
//		String destinationFolder = "src/test";
//		String outputPackage = "testBag";
//		String priorizationTechinique = "Random";		
		TechniqueExecutorAllClasses te2 = new TechniqueExecutorAllClasses();
		te2.executor(nameFolder, destinationFolderBag, outputPackageBag, priorizationTechinique);
	}
	
	private void prioritizationByClass (String nameFolder, String nameFile, String destinationFolder, String outputPackage, String priorizationTechinique){
//		ArrayList[] elements = Extractor.extract(filePath, false);
		TechniqueExecutorByClass te = new TechniqueExecutorByClass();
		setIndex(getIndex()+1);
		te.executor(nameFolder, nameFile, destinationFolder, outputPackage, priorizationTechinique, getIndex());
//		System.out.println(te.indexOfTheFirstFailTestCase(nameFolder, nameFile+getIndex(), destinationFolder, outputPackage));
	}
	
	private void prioritizationAllTestCases(String nameFolder, String destinationFolderBag, String outputPackageBag, String priorizationTechinique) {
//		String nameFolder = "JaxenTests";
//		String destinationFolder = "src/test";
//		String outputPackage = "testBag";
//		String priorizationTechinique = "Random";		
		TechniqueExecutorAllClasses te2 = new TechniqueExecutorAllClasses();
		te2.executorAllTestCases(nameFolder, destinationFolderBag, outputPackageBag, priorizationTechinique);
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		String nameFolder = args[0];
//		String destinationFolder = args[1];
//		String outputPackage = args[2];
//		String priorizationTechinique = args[3];
//		String nameFile = args[4];
		
		String nameFolder = "byClass";
		String destinationFolder = "byClassoutput";
		String outputPackage = "byClassoutput";
		String priorizationTechinique = "Random";
		String nameFile = "DOM4JNavigatorTest";
		
		Facade f = new Facade();
		
//		Class c;
//		boolean success;
//		boolean success2;
//		JUnitCore juc = new JUnitCore();
//		try {
//			c = Class.forName("byClass.output.DOM4JNavigatorTest");
//			Method[] methods = c.getDeclaredMethods();
//			int i = 0;
//			for (Method method: methods) {
//				if (method.getName().startsWith("test")){
//					i++;
//					//							System.out.println(method.getName());
//					if (!juc.run(Request.method(c, method.getName())).wasSuccessful()){
//						success = (new File("src/byClass/output/DOM4JNavigatorTest.class")).delete();
//						success2 = (new File("bin/byClass/output/DOM4JNavigatorTest.class")).delete();
//						System.out.println(i);
//					}
//				} 
//			}
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
//		for (int i = 0; i < 2; i++) {
			f.prioritizationByClass(nameFolder, nameFile, destinationFolder, outputPackage, priorizationTechinique);
//			f.prioritizationByClass(nameFolder, nameFile, destinationFolder, outputPackage, priorizationTechinique);
					
			
//			try {
//				Object foo = new Reloader().loadClass("byClass.output.DOM4JNavigatorTest").newInstance();
//			} catch (InstantiationException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (IllegalAccessException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		}
		
		
		
//		JUnitCore juc = new JUnitCore();
//		System.out.println(juc.run(Request.method(DOM4JNavigatorTest.class, "testAbsoluteLocationPaths")).wasSuccessful());
//		System.out.println(org.junit.runner.JUnitCore.runClasses(DOM4JNavigatorTest.class).getFailureCount()); 
		//main("src/test/DOM4JNavigator.java"); 
		
//		String nameFolder = args[0];
//		String destinationFolder = args[1];
//		String outputPackage = args[2];
//		String priorizationTechinique = args[3];
//		String nameFolder = "JaxenTests";
//		String destinationFolder = "src/test";
//		String outputPackage = "test";
//		String priorizationTechinique = "Random";
		
		//priotitizationAllTestClasses(nameFolder, destinationFolder, outputPackage, priorizationTechinique, false);
//		
//		extractBagClass(nameFolder, destinationFolder, outputPackage, priorizationTechinique);
//		extractSuite("src/main", "src/bySuite", "bySuite", "Random");
		
		//Executing the random prioritization in the bag class
		//extractTestClasses("bagClass", "bagClass/out", "main", "Random", true);
		
		
		
		
//				Request.method(byClass.output.DOM4JNavigatorTest.class, "testAbsoluteLocationPaths")).wasSuccessful());
		
		
//		String nameFolder = "src/bySuite";
//		String destinationFolder = "src/bySuite/output";
//		String outputPackage = "bySuite.output";
//		String priorizationTechinique = "Random";
//		String nameFileSuite = "Suite";
//		for (int i = 4; i<=40; i++){
//			String nameNewFileSuite = "Suite"+i;
//			prioritizationBySuite(nameFolder, destinationFolder, outputPackage, nameFileSuite, nameNewFileSuite, priorizationTechinique);
//		}
//		JUnitCore juc = new JUnitCore();
//		Class c;
//		for (int i = 1; i<=40; i++){
//			try {
//				c = Class.forName("bySuite.output.Suite"+i);
//				Method[] methods = c.getDeclaredMethods();
//				ArrayList<Method> testMethods = new ArrayList<Method>();
//				for (int j = 0; j < methods.length; j++) {
//					Method method = methods[j];
//					if (method.getName().startsWith("test")){
//						testMethods.add(method);
//						if (juc.run(Request.method(c, method.getName())).wasSuccessful()){
//							System.out.println(i+"   "+method.getName());
//						}
//					}
//				} 
////				System.out.println(juc.run(c).getFailureCount());
////				System.out.println(juc.run(Suite2.class).getFailureCount());
//			} catch (ClassNotFoundException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
////				c = Class.forName("Suite");
////			
//		}
		
//		JUnitCore juc = new JUnitCore();
//		System.out.println(juc.run(bySuite.output.Suite.class).getFailures().get(0).getDescription());

		
//		nameFile = "DOM4JNavigatorTest";
//		prioritizationByClass(nameFolder, nameFile, destinationFolder, outputPackage, priorizationTechinique);


}
