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

	private static void setcUnitTarget(CompilationUnit cUnitTarget) {
		FileGenerator.cUnitTarget = cUnitTarget;
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
	
	//TODO estou extraindo devia ir pra Extractor
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


	public static void generateBagClass(ArrayList<ArrayList[]> testClasses,
			String destinationFolder, String outputPackage) {
		CompilationUnit bagCompUnit = createBagCompUnit(outputPackage);
		for (ArrayList[] testCass : testClasses) {
			addingBagElements(bagCompUnit, testCass);
		}
		createTargetFile(source.toString(), destinationFolder, compilationUnit.getTypes().get(0).getName());
		
	}
	
	private static void addingBagElements(CompilationUnit bagCompUnit,
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
		
		setBagImports(bagCompUnit, imports);
		setBagMethods(bagCompUnit, setUpTearDownMethods, testMethods);
		
	}

	private static void setBagMethods(CompilationUnit bagCompUnit,
			ArrayList<MethodDeclaration> setUpTearDownMethods,
			ArrayList<MethodDeclaration> testMethods) {
		
		for (MethodDeclaration setUpOrTearDown : setUpTearDownMethods) {
			ASTHelper.addMember(bagCompUnit, setUpOrTearDown);
		}
		
		for (MethodDeclaration testMethod : testMethods) {
			ASTHelper.addMember(bagCompUnit, testMethod);
		}
	}

	private static void setBagImports(CompilationUnit bagCompUnit, ArrayList<ImportDeclaration> imports) {
		List<ImportDeclaration> bagImports = bagCompUnit.getImports();
		List<ImportDeclaration> setImports = bagCompUnit.getImports();
		for (ImportDeclaration importDeclaration : imports) {
			if (!bagImports.contains(importDeclaration))
				setImports.add(importDeclaration);
		}
		bagCompUnit.setImports(setImports);
	}

	private static CompilationUnit createBagCompUnit(String outputPackageName){
		//create the target compination unit
		CompilationUnit auxCUnit = new CompilationUnit();
		
		String name = "BagCLass";
		int modifier = 1;
				
		//setting the package declaration and imports
		NameExpr namePack = new NameExpr(outputPackageName);
		auxCUnit.setPackage(new PackageDeclaration(namePack));	

		ArrayList<ClassOrInterfaceDeclaration> superclass = new ArrayList<ClassOrInterfaceDeclaration>();
		ClassOrInterfaceDeclaration tc = new ClassOrInterfaceDeclaration();
		tc.setName("TestCase");
		superclass.add(tc);
		
		ClassOrInterfaceDeclaration type = new ClassOrInterfaceDeclaration(null, modifier, null, false, name , null, (List)superclass, null, null);
		ASTHelper.addTypeDeclaration(auxCUnit, type);
		
		return auxCUnit;
	}

}
