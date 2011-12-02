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
import japa.parser.ast.stmt.BlockStmt;
import japa.parser.ast.stmt.Statement;
import japa.parser.ast.type.ClassOrInterfaceType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class FileBagGenerator extends FileGenerator{
	
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

		List<Statement> setUpStatements = new ArrayList<Statement>();
		List<Statement> tearDownStatements = new ArrayList<Statement>();
		List<NameExpr> exceptionsSetUp = new ArrayList<NameExpr>();
		List<NameExpr> exceptionsTearDown = new ArrayList<NameExpr>();
		for (MethodDeclaration setUpOrTearDown : setUpTearDownMethods) {			
			if (setUpOrTearDown.getName().toLowerCase().startsWith("setup")){
				setUpStatements.addAll(setUpOrTearDown.getBody().getStmts());
				exceptionsSetUp = setUpOrTearDown.getThrows();
			}else if (setUpOrTearDown.getName().toLowerCase().startsWith("teardown")){
				tearDownStatements.addAll(setUpOrTearDown.getBody().getStmts());
				exceptionsTearDown = setUpOrTearDown.getThrows();
			}
		}
		
		for (MethodDeclaration testMethod : testMethods) {
			if ((setUpStatements.size() > 0 || tearDownStatements.size() > 0)  && testMethod.getModifiers() != 1028){
				List<Statement> bodySt = testMethod.getBody().getStmts();			
				List<Statement> testMethodStat = new ArrayList<Statement>();
				List<Statement> setUpCopy = copy(setUpStatements);
				List<Statement> tearDownCopy = copy(tearDownStatements);
				
				testMethodStat.addAll(setUpCopy);
				if (bodySt != null && bodySt.size() > 0 )
					testMethodStat.addAll(bodySt);
				testMethodStat.addAll(tearDownCopy);
				BlockStmt b = new BlockStmt(testMethodStat);
				testMethod.setBody(b);
					
				List<NameExpr> newListThrows = testMethod.getThrows();
				if (newListThrows == null)
					newListThrows = new ArrayList<NameExpr>();
				if (exceptionsSetUp != null && exceptionsSetUp.size() > 0)
					newListThrows.addAll(exceptionsSetUp);
				if (exceptionsTearDown != null && exceptionsTearDown.size() > 0)
					newListThrows.addAll(exceptionsTearDown);
				if (newListThrows != null && newListThrows.size() > 0)
					testMethod.setThrows(newListThrows);
			}			
			ASTHelper.addMember(bagType, testMethod);
		}		
	}

	private static List<Statement> copy(List<Statement> setUpStatements) {
		ArrayList<Statement> returnState = new ArrayList<Statement>();
		for (Statement statement : setUpStatements) {
			returnState.add(statement);
		}
		return returnState;
	}

	private static CompilationUnit createBagCompUnit(String outputPackageName, ArrayList<ArrayList[]> testClasses){
		//create the target compination unit
		CompilationUnit auxCUnit = new CompilationUnit();
		String name = "BagClass";
		int modifier = 1;
				
		//setting the package declaration
		NameExpr namePack = new NameExpr(outputPackageName);
		auxCUnit.setPackage(new PackageDeclaration(namePack));	
		
		//setting superclass
		ArrayList<ClassOrInterfaceType> superclass = new ArrayList<ClassOrInterfaceType>();
		ClassOrInterfaceType tc = new ClassOrInterfaceType();
		tc.setName("TestCase");
		superclass.add(tc);
		List<ClassOrInterfaceType> superclassL = (List)superclass;

		ClassOrInterfaceDeclaration type = new ClassOrInterfaceDeclaration(null, modifier, null, false, name , null, superclassL, null, null);
		ASTHelper.addTypeDeclaration(auxCUnit, type);
		
		//setting the imports declaration
		HashSet<ImportDeclaration> importsSet = new HashSet<ImportDeclaration>();
		ArrayList<FieldDeclaration> fieldSet = new ArrayList<FieldDeclaration>();
		for (ArrayList[] testCass : testClasses) {
			ArrayList<ClassOrInterfaceType> classSuper = testCass[2];
			if ((classSuper.size() > 0 ) && (superclass.get(0).getName().equals("TestCase"))){
				ArrayList<ImportDeclaration> imports = testCass[1];
				for (ImportDeclaration imp : imports) {
					importsSet.add(imp);
				}
				ArrayList<FieldDeclaration> fields = testCass[7];
				for (FieldDeclaration fieldDeclaration : fields) {
					addFieldWithoutRepetition(fieldSet, fieldDeclaration);
				}
			}
			
		}		
		auxCUnit.setImports(translateToArrayList(importsSet.toArray()));
		
		//setting bagClass fields
		settingFields(type, fieldSet);
				
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

	private static void addFieldWithoutRepetition(
			ArrayList<FieldDeclaration> fieldSet, FieldDeclaration fieldDeclaration) {
		String typeStr = fieldDeclaration.getType().toString();
		int i = typeStr.lastIndexOf(".");
		String sub = typeStr.substring(i+1, typeStr.length());
		
		boolean notFound = true;
		int index = 0;
		while (notFound && index < fieldSet.size()){
			FieldDeclaration field = fieldSet.get(index);
			if (field.getVariables().get(0).equals(fieldDeclaration.getVariables().get(0))){
				notFound = false;
			}else index++;
		}
		if (notFound){
			fieldSet.add(fieldDeclaration);
		}
		
	}

	private static void settingFields(ClassOrInterfaceDeclaration type,
			ArrayList<FieldDeclaration> fieldSet) {
		for (FieldDeclaration field : fieldSet) {
			ASTHelper.addMember(type, field);
		}

	}

	private static List<ImportDeclaration> translateToArrayList(Object[] array) {
		ArrayList<ImportDeclaration> returnArray = new ArrayList<ImportDeclaration>();
		for (Object imp : array) {
			returnArray.add((ImportDeclaration)imp);
		}
		return returnArray;
	}
}
