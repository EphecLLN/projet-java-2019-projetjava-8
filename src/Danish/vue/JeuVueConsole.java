package Danish.vue;


import java.io.*;
import java.util.*;

import Danish.controller.*;
import Danish.model.*;

@SuppressWarnings("deprecation")
public class JeuVueConsole extends JeuVue implements Observer {
	
	protected Scanner sc;
	private volatile boolean fin = false;
	BufferedReader keyboard;
	
	/**
	 * 
	 * @param j le jeu dans le modele MVC
	 * @param jControl le controleur du jeu dans le modele MVC
	 */
	public JeuVueConsole(Jeu j, JeuController jControl) {
		super(j, jControl);
		update(null, null);
		sc = new Scanner(System.in);
		new Thread (new ReadInput()).start();	
	}

	@Override
	public void affiche(String string) {
		System.out.println(string);
	}

	@Override
	public void update(Observable o, Object arg) {
		
	}
	
	/**
	 * fonction lisant les entrées dans la console
	 * @param text a afficher en demandant une valeur
	 * @return String de ce que l'utilisateur à entré
	 */
	public String input(String texte){
		affiche(texte);
		String entre = "";
		try {
			entre = keyboard.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return entre;
	}
	
	
	public void menu(){	 
		String menu = input("1)règles du jeux\n2)multi joueur en réseaux\n3)informations de connexion");
		//affiche(menu);
		int nbrJoueur;
		switch(menu){
			case "1":
				input("Le 2, peut être joué sur n'importe quelle valeur, remet à 0 la valeur sur laquelle jouer."
						+ "\n\nLe 3, peut être joué sur n'importe quelle valeur, agit comme un miroir."
						+ "Cette carte copie la dernière carte jouée sur la table. Si table de jeu est vide, valeur de la carte = 3"
						+ "\n\nLe 7, la prochaine carte jouée doit obligatoirement être inférieure ou égale à 7."
						+ "\n\nLe 8, le joueur suivant passe son tour. Il n'est pas possible de mettre un deuxième 8 par dessus"
						+ "\n\nLe 10, peut être jouée sur n'importe quelle valeur, coupe le jeu. "
						+ "Le tas coupé est éliminer de la table de jeu e ne peux plus être récupéré par un joueur."
						+ "\n\nL'AS, valeur maximale. Le joueur jouant un AS choisit un autre joueur qu'il \"attaque\" (non implémenté), "
						+ "Si le joueur attaqué ne sait pas répondre par un 2, un 10, un 3, ou un AS, il récupère le tas de cartes jouées."
						+ "L'AS joué est directement ajoutée à la pile coupée.");
				affiche("--------------------------------------");//a remplacer par un clear console
				break;
			case "2":
				nbrJoueur = j.setJoueurs() + 1;	
				break;
			case "3":
				System.out.println("connexion sur le port 10990 du server");
				break;
			default:affiche("ce n'est pas un choix valable.");
				break;
		}
		menu();
	}
	
	
	
	/**
	 * set la variable end a true pour terminer la partie.
	 */
	private void fin() {
		this.fin = true;
	}

	/**
	 * affiche l exception en cas de catch.
	 */
	private void printHelpException(){
		this.affiche("Format d'entree non conforme, sans doute une lettre alphabetique.");
	}
	
	private class ReadInput implements Runnable{
		public void run() {
			while(!fin){
				try {
					menu();
					//int i = sc.nextInt();
					//jControl.printTextMenu(i, 0); 
					
					
					fin();
				}
				catch(InputMismatchException e){
					affiche("Format d'input incorrect");
					printHelpException();
					System.exit(0);
				}
			}
		}
	}
	
	/**
	 * @return the fin
	 */
	public boolean isFin() {
		return fin;
	}

	/**
	 * @param fin the fin to set
	 */
	public void setFin(boolean fin) {
		this.fin = fin;
	}

}
