/**
 * 
 */
package Danish.controller;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import Danish.model.*;
import Danish.vue.*;
import Danish.network.*;

/**
 * @author Humbert MEYERS
 *
 */

public class JeuController {

	Jeu jeu;
	JeuVue jVue;
	SocketIP socketIP;
	boolean reseau = false;
	BufferedReader keyboard;
	Scanner sc = new Scanner(System.in);
	String rcv = "";
	
	/**
	 * le constructeur
	 */
	public JeuController(Jeu jeu) {
		this.jeu = jeu;
		keyboard = new BufferedReader(new InputStreamReader(System.in));
	}
	
	
	/**
	 * ajoute une vue
	 * @param jVue vue
	 */
	public void addView(JeuVue jVue) {
		this.jVue = jVue;
		
	}
	
	public void Multi(ArrayList<String> nom) throws IOException{
		jeu.videJoueur();
		jeu.addJoueur();//instantiation d'un joueur
		Connexion(jeu.getJoueurs().get(0));//connection a l'autre
		
	}
	
	/**
	 * fonction lancant la communication reseaux
	 * @param joueur de la partie
	 * @throws IOException 
	 */
	public void Connexion(Joueurs joueur) throws IOException{
		reseau = true;
		jVue.affiche("heberger vous la partie?(o/n): ");
		String heberge = sc.toString();
		boolean isServer=false;
		String ip = "localhost";
		switch(heberge.toLowerCase()){
			case"o":isServer = (true);
					jVue.affiche("en attente du client...");
				break;
			case"n":isServer = (false);
					jVue.affiche("entrez une IP pour la connection: ");
					ip = sc.toString();
				break;
			default:isServer=false;
				break;
		}
		socketIP = new SocketIP( isServer , 10990,ip);
		jVue.affiche("connection établie");
		if(isServer){//-----------------------------------------server---------------------------------------------
			socketIP.sendMessage("en attente");
			jVue.affiche("un de vos adversaire joue...");
			rcv = socketIP.waitForMessage();
			
		}else{//-------------------------------------------client-------------------------------------------------
			rcv = socketIP.waitForMessage();
			do{
			jVue.affiche(rcv);
			if(joueur.isTourFini()){
				socketIP.sendMessage("Au suivant");
				do{
					rcv = socketIP.waitForMessage();
					jVue.affiche(rcv);
				}while(true);
				
			}
			}while(true); // a revoir
		}
	}
	
	public String input(String texte){
		return jVue.input(texte);
	}
}