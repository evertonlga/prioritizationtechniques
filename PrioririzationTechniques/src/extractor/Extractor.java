package extractor;

import japa.parser.ast.CompilationUnit;
import japa.parser.ast.ImportDeclaration;
import japa.parser.ast.body.BodyDeclaration;
import japa.parser.ast.body.ClassOrInterfaceDeclaration;
import japa.parser.ast.body.ConstructorDeclaration;
import japa.parser.ast.body.FieldDeclaration;
import japa.parser.ast.body.MethodDeclaration;
import japa.parser.ast.body.TypeDeclaration;
import japa.parser.ast.type.ClassOrInterfaceType;
import japa.parser.ast.visitor.VoidVisitorAdapter;

import java.util.ArrayList;
import java.util.List;


public class Extractor {

	public static ClassOrInterfaceType superclass = null;
	private static List<ClassOrInterfaceType> interfaceRealizations = new ArrayList<ClassOrInterfaceType>();
	private static CompilationUnit compilationUnit;
	
	private static ArrayList<MethodDeclaration> getTestMethods(String className, boolean isBagClass) {
		List<TypeDeclaration> types = compilationUnit.getTypes();
		ArrayList<MethodDeclaration> testMethods = new ArrayList<MethodDeclaration>();
		for (TypeDeclaration type : types) {
			List<BodyDeclaration> members = type.getMembers();
			for (BodyDeclaration member : members) {
				if (member instanceof MethodDeclaration) {
					MethodDeclaration method = (MethodDeclaration) member;
					if (!method.getName().startsWith("setUp") && !method.getName().startsWith("tearDown")){
//						if (!isBagClass)
//							method.setName(method.getName()+"_"+className);
						testMethods.add(method);
					}
				}
			}
		}
		return testMethods;
	}
	
	private static ArrayList<ClassOrInterfaceDeclaration> getInnerClasses() {
		List<TypeDeclaration> types = compilationUnit.getTypes();
		ArrayList<ClassOrInterfaceDeclaration> classes = new ArrayList<ClassOrInterfaceDeclaration>();
		for (TypeDeclaration type : types) {
			List<BodyDeclaration> members = type.getMembers();
			for (BodyDeclaration member : members) {
				if (member instanceof ClassOrInterfaceDeclaration) {
					ClassOrInterfaceDeclaration innerClass = (ClassOrInterfaceDeclaration) member;
					classes.add(innerClass);
				}
			}
		}
		return classes;
	}
	
	private static ArrayList<MethodDeclaration> getSetUpTearDownMethods() {
		List<TypeDeclaration> types = compilationUnit.getTypes();
		ArrayList<MethodDeclaration> setUpTearDownMethods = new ArrayList<MethodDeclaration>();
		for (TypeDeclaration type : types) {
			List<BodyDeclaration> members = type.getMembers();
			for (BodyDeclaration member : members) {
				if (member instanceof MethodDeclaration) {
					MethodDeclaration method = (MethodDeclaration) member;
					if ((method.getName().equals("setUp")) || method.getName().equals("tearDown")){
						setUpTearDownMethods.add(method);
					}
				}
			}
		}
		return setUpTearDownMethods;
	}
	
	private static ArrayList<FieldDeclaration> getFields() {
		List<TypeDeclaration> types = compilationUnit.getTypes();
		ArrayList<FieldDeclaration> fields = new ArrayList<FieldDeclaration>();
		for (TypeDeclaration type : types) {
			List<BodyDeclaration> members = type.getMembers();
			for (BodyDeclaration member : members) {
				if (member instanceof FieldDeclaration) {
					FieldDeclaration field = (FieldDeclaration) member;
					fields.add(field);
				}
			}
		}
		return fields;
		
	}
	
	private static ArrayList<ConstructorDeclaration> getConstructors() {
		List<TypeDeclaration> types = compilationUnit.getTypes();
		ArrayList<ConstructorDeclaration> constructors = new ArrayList<ConstructorDeclaration>();
		for (TypeDeclaration type : types) {
			List<BodyDeclaration> members = type.getMembers();
			for (BodyDeclaration member : members) {
				if (member instanceof ConstructorDeclaration) {
					ConstructorDeclaration cons = (ConstructorDeclaration) member;
					constructors.add(cons);
				}
			}
		}
		return constructors;
	}
	
	private static List<ImportDeclaration> extractImports(){
		return compilationUnit.getImports();
	}
	
	private static ArrayList<Integer> extractModifiers(){
		TypeDeclaration typeSource = compilationUnit.getTypes().get(0);
		int modifier = typeSource.getModifiers();
		ArrayList<Integer> array = new ArrayList<Integer>();
		array.add(new Integer(modifier));
		return array;
	}
	
	private static ArrayList<ClassOrInterfaceType> extractSuperClass(){
		TypeDeclaration typeSource = compilationUnit.getTypes().get(0);

		ClassOrInterfaceType tc = new ClassOrInterfaceType();
		ArrayList<ClassOrInterfaceType> list = new ArrayList<ClassOrInterfaceType>();
		ClassVisitor cv = new ClassVisitor();
		cv.visit((ClassOrInterfaceDeclaration) typeSource, null);
		
		if (superclass != null){
			tc.setName(superclass.getName());
			list.add(tc);
		}		
		return list;
	}
	
	private static ArrayList<ClassOrInterfaceType> extractInterfaces(){
		ArrayList<ClassOrInterfaceType> list = new ArrayList<ClassOrInterfaceType>();
		if (interfaceRealizations != null)
			for (ClassOrInterfaceType i : interfaceRealizations) {
				list.add(i);
			}
		return list;
	}
	
	public static ArrayList[] extract(CompilationUnit compilationUnit, boolean isBagClass){
		ArrayList<MethodDeclaration> testMethods = new ArrayList<MethodDeclaration>();
		ArrayList<MethodDeclaration> setUpTearDownMethods = new ArrayList<MethodDeclaration>();
		ArrayList<FieldDeclaration> fields = new ArrayList<FieldDeclaration>();
		ArrayList<Integer> modifier;
		ArrayList<ImportDeclaration> imports;
		
		ArrayList<String> names;
		ArrayList<ClassOrInterfaceDeclaration> innerClasses = new ArrayList<ClassOrInterfaceDeclaration>();
		ArrayList<ConstructorDeclaration> constructors = new ArrayList<ConstructorDeclaration>();
		
		Extractor.compilationUnit = compilationUnit;
		
		names = getName();
		modifier = extractModifiers();
		imports = new ArrayList<ImportDeclaration>(extractImports());
		ArrayList<ClassOrInterfaceType> superClass = new ArrayList<ClassOrInterfaceType>(extractSuperClass());
		ArrayList<ClassOrInterfaceType> interfaces = new ArrayList<ClassOrInterfaceType>(extractInterfaces());
		
		
		testMethods = getTestMethods(names.get(0), isBagClass);
		setUpTearDownMethods = getSetUpTearDownMethods();
		fields = getFields();
		innerClasses = getInnerClasses();
		constructors = getConstructors();
		
		ArrayList[] returnElements = {modifier, imports, superClass, interfaces, names, testMethods, setUpTearDownMethods, fields, innerClasses, constructors};
		return returnElements;
	}
	
//	public static ArrayList[] extract(String filePath, boolean isBagClass){
//		ArrayList<MethodDeclaration> testMethods = new ArrayList<MethodDeclaration>();
//		ArrayList<MethodDeclaration> setUpTearDownMethods = new ArrayList<MethodDeclaration>();
//		ArrayList<FieldDeclaration> fields = new ArrayList<FieldDeclaration>();
//		ArrayList<Integer> modifier;
//		ArrayList<ImportDeclaration> imports;
//		
//		ArrayList<String> names;
//		ArrayList<ClassOrInterfaceDeclaration> innerClasses = new ArrayList<ClassOrInterfaceDeclaration>();
//		ArrayList<ConstructorDeclaration> constructors = new ArrayList<ConstructorDeclaration>();
//		
//		ArrayList<CompilationUnit> compUnits = new CompilatonUnitExtractor().getCompUnitsSource(filePath);
//		Extractor.compilationUnit = compUnits.get(0);
//		
//		names = getName();
//		modifier = extractModifiers();
//		imports = new ArrayList<ImportDeclaration>(extractImports());
//		ArrayList<ClassOrInterfaceType> superClass = new ArrayList<ClassOrInterfaceType>(extractSuperClass());
//		ArrayList<ClassOrInterfaceType> interfaces = new ArrayList<ClassOrInterfaceType>(extractInterfaces());
//		
//		
//		testMethods = getTestMethods(names.get(0), isBagClass);
//		setUpTearDownMethods = getSetUpTearDownMethods();
//		fields = getFields();
//		innerClasses = getInnerClasses();
//		constructors = getConstructors();
//		
//		ArrayList[] returnElements = {modifier, imports, superClass, interfaces, names, testMethods, setUpTearDownMethods, fields, innerClasses, constructors};
//		return returnElements;
//	}
	
	private static ArrayList<String> getName() {
		ArrayList<String> names = new ArrayList<String>();
		names.add(compilationUnit.getTypes().get(0).getName());
		return names;
	}

	private static class ClassVisitor extends VoidVisitorAdapter {

		@Override
        public void visit(ClassOrInterfaceDeclaration n, Object o) {
        	List<ClassOrInterfaceType> superclasses = n.getExtends();
        	interfaceRealizations = n.getImplements();
        	if (superclasses != null && superclasses.size() >0 )
        		superclass = n.getExtends().get(0);
        	else superclass = null;
        }
    }

}
