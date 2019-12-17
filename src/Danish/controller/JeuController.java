/**
 * 
 */
package Danish.controller;

import java.util.ArrayList;
import java.util.Scanner;

import Danish.model.*;
import Danish.vue.*;

/**
 * @author Humbert MEYERS
 *
 */

public class JeuController {

	Jeu jeu;
	JeuVue jVue;
	
	/**
	 * le constructeur
	 */
	public JeuController(Jeu jeu) {
		this.jeu = jeu;
	}
	
	
	/**
	 * ajoute une vue
	 * @param jVue vue
	 */
	public void addView(JeuVue jVue) {
		this.jVue = jVue;
		
	}
}