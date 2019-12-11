package vue;

import java.util.*;

public abstract class JeuVue implements Observer{
	
	protected projet.Jeu j;
	protected controller.JeuController jControl;

	public JeuVue(projet.Jeu jeu, controller.JeuController controller) {
		this.j = jeu;
		this.jControl = controller;
		j.addObserver(this); // Connexion entre la vue et le modele
	}

	public abstract void affiche(String string) ;
}