package Danish.vue;

import java.util.*;

import Danish.model.*;
import Danish.controller.*;

@SuppressWarnings("deprecation")
public abstract class JeuVue implements Observer{
	
	protected Jeu j;
	protected JeuController jControl;

	public JeuVue(Jeu jeu, JeuController controller) {
		this.j = jeu;
		this.jControl = controller;
		j.addObserver(this); // Connexion entre la vue et le modele
	}
	
	public abstract String input(String texte);
	public abstract void affiche(String string);
	public abstract void menu();
}