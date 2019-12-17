
import Danish.controller.JeuController;
import controller.*;
import vue.*;

public class JeuMVC {

	Jeu j;
	JeuController jeuControleGUI;
	JeuController jeuControleConsole;
	JeuVue jeuVueGUI;
	JeuVue jeuVueConsole;

	public JeuMVC() {
		//Creation du modele
		
		 j = new Jeu();

		//Creation de un controleur pour chaque vue
		//Chaque controleur doit avoir une reference vers le modele pour pouvoir le commander
		
		 jeuControleGUI = new JeuController(j);
		 jeuControleConsole = new JeuController(j);
				 
		//Creation des vues.
		//Chaque vue doit connaitre son controleur et avoir une reference vers le modele pour pouvoir l'observer
		
		 jeuVueGUI = new JeuVueGUI(j, jeuControleGUI);
		 jeuVueConsole = new JeuVueConsole(j, jeuControleConsole);
		
		//On donne le lien à la vue pour chaque controleur
		
		 jeuControleGUI.addView(jeuVueGUI);
		 jeuControleConsole.addView(jeuVueConsole);
		
		
	}
	
	public static void main(String args[]) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new JeuMVC();
			}
		});
	}

}