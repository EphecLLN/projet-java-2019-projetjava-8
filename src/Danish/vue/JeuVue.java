package vue;

import java.util.*;

@SuppressWarnings("deprecation")
public abstract class JeuVue implements Observer{
	
	protected projet.Jeu j;
	protected Danish.controller.JeuController jControl;

	public JeuVue(projet.Jeu jeu, Danish.controller.JeuController controller) {
		this.j = jeu;
		this.jControl = controller;
		j.addObserver(this); // Connexion entre la vue et le modele
	}

	public abstract void affiche(String string) ;
}