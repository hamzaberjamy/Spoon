import java.util.List;
import spoon.Launcher;
import spoon.reflect.CtModel;
import spoon.reflect.declaration.CtField;
import spoon.reflect.declaration.CtMethod;
import spoon.reflect.visitor.filter.TypeFilter;

public class Main {

	public static void main(String[] args) {
		
		Launcher launcher = new Launcher(); // Instance du Launcher
		launcher.addInputResource("C:\\Users\\user\\Desktop\\Personne.java"); // Spécification du path de la classe à analyser

		launcher.buildModel(); // Génération du méta-modèle
		CtModel model = launcher.getModel(); // Récupération du métaèmodèle
		
		List<CtField> fields = model.getElements(new TypeFilter<>(CtField.class)); // Récupérer la liste des attributs
		List<CtMethod> methods = model.getElements(new TypeFilter<>(CtMethod.class)); // Récupérer la liste des méthodes
		
		System.out.println("La liste des attributs de la classe analysée :");
		for (CtField field : fields) {
			System.out.println(field.getSimpleName()); // Afficher la liste des attributs
		}
		
		System.out.println("La liste des méthodes avec leur type de retour de la classe analysée :");
		for (CtMethod method : methods) {
			// Afficher la liste des méthodes avec leurs types respectifs
			System.out.println("le nom de la méthode : "+method.getSimpleName()+", le type de retour : "+method.getType());

		}

	}

}
