import java.util.List;
import spoon.Launcher;
import spoon.reflect.CtModel;
import spoon.reflect.declaration.CtField;
import spoon.reflect.declaration.CtMethod;
import spoon.reflect.visitor.filter.TypeFilter;

public class Main {

	public static void main(String[] args) {
		
		Launcher launcher = new Launcher(); // Launcher instance
		launcher.addInputResource("C:\\Users\\user\\Desktop\\Personne.java"); // path of class to parse

		launcher.buildModel(); // meta-model generation
		CtModel model = launcher.getModel(); // get meta-model
		
		List<CtField> fields = model.getElements(new TypeFilter<>(CtField.class)); // get class attributes list
		List<CtMethod> methods = model.getElements(new TypeFilter<>(CtMethod.class)); // get class methods list
		
		System.out.println("La liste des attributs de la classe analysée :");
		for (CtField field : fields) {
			System.out.println(field.getSimpleName()); // display class attributes list
		}
		
		System.out.println("La liste des méthodes avec leur type de retour de la classe analysée :");
		for (CtMethod method : methods) {
			// display class methods list : name & return value type
			System.out.println("Method name : "+method.getSimpleName()+", Return value type : "+method.getType());

		}

	}

}
