package fileGenerator;

import japa.parser.ASTHelper;
import japa.parser.ast.CompilationUnit;
import japa.parser.ast.ImportDeclaration;
import japa.parser.ast.PackageDeclaration;
import japa.parser.ast.body.ClassOrInterfaceDeclaration;
import japa.parser.ast.body.ConstructorDeclaration;
import japa.parser.ast.body.FieldDeclaration;
import japa.parser.ast.body.MethodDeclaration;
import japa.parser.ast.body.TypeDeclaration;
import japa.parser.ast.expr.NameExpr;
import japa.parser.ast.type.ClassOrInterfaceType;
import japa.parser.ast.visitor.VoidVisitorAdapter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class FileGenerator {
	
	public static ClassOrInterfaceType superclass;
	private static CompilationUnit cUnitTarget;
	
	
	private static CompilationUnit createTargetCompUnit(CompilationUnit cUnitSource, String outputPackageName, ArrayList[] elements){
//		{modifier, imports, superClass, interfaces, names, testMethods, setUpTearDownMethods, fields, innerClasses, constructors};
		ArrayList<Integer> modifiers = elements[0];
		ArrayList<ImportDeclaration> imports = elements[1];
		ArrayList<ClassOrInterfaceType> superClass = elements[2];
		ArrayList<ClassOrInterfaceType> interfaces = elements[3];
		ArrayList<String> names = elements[4];
		ArrayList<MethodDeclaration> testMethods = elements[5];
		ArrayList<MethodDeclaration> setUpTearDownMethods = elements[6];
		ArrayList<FieldDeclaration> fields = elements[7];
		ArrayList<ClassOrInterfaceDeclaration> innerClasses = elements[8];
		ArrayList<ConstructorDeclaration> constructors = elements[9];
				
		//create the target compination unit
		CompilationUnit auxCUnit = new CompilationUnit();
		
		String name = names.get(0);
		int modifier = modifiers.get(0);
				
		//setting the package declaration and imports
		NameExpr namePack = new NameExpr(outputPackageName);
		auxCUnit.setPackage(new PackageDeclaration(namePack));	
		auxCUnit.setImports(imports);
		
		//Setting the name, modifiers and superclass
		ClassOrInterfaceDeclaration type = null;
		if ((superClass.size() > 0) && (interfaces.size() > 0))
			type = new ClassOrInterfaceDeclaration(null, modifier, null, false, name , null, superClass, interfaces, null);
		else if ((superClass.size() > 0))
			type = new ClassOrInterfaceDeclaration(null, modifier, null, false, name , null, superClass, null, null);
		else if (interfaces.size() >0 )
			type = new ClassOrInterfaceDeclaration(null, modifier, null, false, name , null, null, interfaces, null);
		else type = new ClassOrInterfaceDeclaration(null, modifier, null, false, name , null, null, null, null);
		ASTHelper.addTypeDeclaration(auxCUnit, type);
		
		// Setting the class constructors
		for (ConstructorDeclaration c : constructors) {
			ASTHelper.addMember(type, c);
		}
		
		// Setting the class fields
		for (FieldDeclaration field : fields) {
			ASTHelper.addMember(type, field);
		}
		
		// Setting the class the methods
		for (MethodDeclaration setUpOrTearDown : setUpTearDownMethods) {
			ASTHelper.addMember(type, setUpOrTearDown);
		}
		
		for (MethodDeclaration testMethod : testMethods) {
			ASTHelper.addMember(type, testMethod);
		}
		
		for (ClassOrInterfaceDeclaration ic : innerClasses) {
			ASTHelper.addMember(type, ic);
		}
		
		return auxCUnit;
	}
	
	private static void createTargetFile(String source, String destinationFolder, String nameFile) {
		try {
			String destination = destinationFolder+"/"+nameFile+".java";
			File file = new File(destination);
			if (!file.createNewFile()){
				file.delete();
				file = new File(destination);
			}
			FileWriter writer = new FileWriter(file,true);
			PrintWriter output = new PrintWriter(writer); 
			output.write(source);
			writer.close();
			output.close();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
	}
	
	private static List<ClassOrInterfaceType> interfaceRealizations;
	private static class ClassVisitor extends VoidVisitorAdapter {

        @Override
        public void visit(ClassOrInterfaceDeclaration n, Object o) {
        	List<ClassOrInterfaceType> superclasses = n.getExtends();
        	interfaceRealizations = n.getImplements();
        	if (superclasses != null && superclasses.size() >0 )
        		superclass = n.getExtends().get(0);
        }
    }
	
	public static void generateTestClasses(CompilationUnit compilationUnit, ArrayList[] elements, String destinationFolder, String outputPackage){
		//String source, String destinationFolder, String nameFile
		CompilationUnit source = createTargetCompUnit(compilationUnit, outputPackage, elements);
		createTargetFile(source.toString(), destinationFolder, compilationUnit.getTypes().get(0).getName());
	}


//------------- Generation of the Bag class -------------------------
	public static void generateBagClass(ArrayList<ArrayList[]> testClasses,
			String destinationFolder, String outputPackage) {
		
		CompilationUnit bagType = createBagCompUnit(outputPackage, testClasses);
		
		createTargetFile(bagType.toString(), destinationFolder, "BagClass");
		
	}
	
	private static void addingBagElements(TypeDeclaration bagType,
			ArrayList[] elements) {
		ArrayList<Integer> modifiers = elements[0];
		ArrayList<ImportDeclaration> imports = elements[1];
		ArrayList<ClassOrInterfaceType> superClass = elements[2];
		ArrayList<ClassOrInterfaceType> interfaces = elements[3];
		ArrayList<String> names = elements[4];
		ArrayList<MethodDeclaration> testMethods = elements[5];
		ArrayList<MethodDeclaration> setUpTearDownMethods = elements[6];
		ArrayList<FieldDeclaration> fields = elements[7];
		ArrayList<ClassOrInterfaceDeclaration> innerClasses = elements[8];
		ArrayList<ConstructorDeclaration> constructors = elements[9];

		for (MethodDeclaration setUpOrTearDown : setUpTearDownMethods) {
			ASTHelper.addMember(bagType, setUpOrTearDown);
		}
		
		for (MethodDeclaration testMethod : testMethods) {
			ASTHelper.addMember(bagType, testMethod);
		}
		
		for (FieldDeclaration field : fields) {
			ASTHelper.addMember(bagType, field);
		}
		
	}

//	private static void setBagImports(CompilationUnit bagCompUnit, ArrayList<ImportDeclaration> imports) {
//		List<ImportDeclaration> bagImports = bagCompUnit.getImports();
//		List<ImportDeclaration> setImports = bagCompUnit.getImports();
//		for (ImportDeclaration importDeclaration : imports) {
//			if (!bagImports.contains(importDeclaration))
//				setImports.add(importDeclaration);
//		}
//		bagCompUnit.setImports(setImports);
//	}

	private static CompilationUnit createBagCompUnit(String outputPackageName, ArrayList<ArrayList[]> testClasses){
		//create the target compination unit
		CompilationUnit auxCUnit = new CompilationUnit();
		String name = "BagClass";
		int modifier = 1;
				
		//setting the package declaration
		NameExpr namePack = new NameExpr(outputPackageName);
		auxCUnit.setPackage(new PackageDeclaration(namePack));	
		
		//setting the imports declaration
		HashSet<ImportDeclaration> importsSet = new HashSet<ImportDeclaration>();
		for (ArrayList[] testCass : testClasses) {
			ArrayList<ImportDeclaration> imports = testCass[1];
			for (ImportDeclaration imp : imports) {
				importsSet.add(imp);
			}
		}		
		auxCUnit.setImports(translateToArrayList(importsSet.toArray()));

		//setting superclass
		ArrayList<ClassOrInterfaceType> superclass = new ArrayList<ClassOrInterfaceType>();
		ClassOrInterfaceType tc = new ClassOrInterfaceType();
		tc.setName("TestCase");
		superclass.add(tc);
		List<ClassOrInterfaceType> superclassL = (List)superclass;
				
		ClassOrInterfaceDeclaration type = new ClassOrInterfaceDeclaration(null, modifier, null, false, name , null, superclassL, null, null);
		ASTHelper.addTypeDeclaration(auxCUnit, type);
		
		//setting methods
		for (ArrayList[] testCass : testClasses) {
			ArrayList<ClassOrInterfaceType> classSuper = testCass[2];
			if ((classSuper.size() > 0 ) && (superclass.get(0).getName().equals("TestCase")))
				addingBagElements (type, testCass);
			else {
				CompilationUnit newJavaFile = createTargetCompUnit(new CompilationUnit(), outputPackageName, testCass);
				createTargetFile(newJavaFile.toString(), "src/testBag", (String) testCass[4].get(0));
			}
		}
		
		return auxCUnit;
	}

	private static List<ImportDeclaration> translateToArrayList(Object[] array) {
		ArrayList<ImportDeclaration> returnArray = new ArrayList<ImportDeclaration>();
		for (Object imp : array) {
			returnArray.add((ImportDeclaration)imp);
		}
		return returnArray;
	}

}
