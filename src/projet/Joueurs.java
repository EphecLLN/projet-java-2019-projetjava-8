/**
 * 
 */
package projet;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Jean Cornil
 *
 */
public class Joueurs {
	
	private ArrayList<String> cartesCachees;
	private ArrayList<String> cartesVisibles;
	private ArrayList<String> cartesMain;
	private int carte;
	
	public Joueurs(){
		//ArrayList<String>carteCachees = new ArrayList();
		this.cartesVisibles = new ArrayList<String>();
		this.cartesMain = new ArrayList<String>();
		this.cartesCachees = new ArrayList<String>();
	}
	/**
	 * Cette méthode permet d'afficher les carte actuellement en main
	 * et demande à l'utilisateur d' en selectionner une pour la jouer
	 * @return Les cartes en main
	 */
	public String demanderCarteAJouer() {
		String str = "";
		int j = 0;
		str += "Quelle Carte voulez vous jouer?; \n";
	for (int i = 0; i < getCartesMain().size(); i++) {
		j = i +1;
		str += "Taper " + j +" pour: " + cartesMain.get(i) +"\n";
		}
	j++;
	str += "Taper " + j +" pour piocher une carte";
	System.out.println(str);
	return str;
	}
	/**
	 * Cette méthode permet à l'utilisateur de sélectionner la cartes qu'il veut jouer
	 * @return la carte à jouer
	 */
	public int choisirCarte() {
		Scanner sc = new Scanner(System.in);
		carte = sc.nextInt();
		return carte;
	}
	
	/**
	 * Cette méthode pose la carte choisie sur la table, la suprimme de notre main et en pioche une nouvelle
	 * @param carte que l'on joue
	 * @return message annoncant la carte jouee et la carte piochee
	 */
	public String jouerCarte(int carte) {
		String str ="";
		String premiereCarte;
		ArrayList<String> m;
		ArrayList<String> k;
		int carteMoinsUn = carte -1;
		
		str = "Vous jouer la carte " + cartesMain.get(carteMoinsUn);
		m = Jeu.getCartesJouees();
		m.add(getCartesMain().get(carteMoinsUn));
		Jeu.setCartesJouees(m);
		 
		k = getCartesMain();
		premiereCarte = Jeu.donnerCarte();
		k.add(premiereCarte);
		setCartesMain(k);
		cartesMain.remove(carteMoinsUn);
		str += "\nVous piocher la carte "+ premiereCarte;
		
		System.out.println(str);
		
		return str;
	}
	
	
	/**
	 * @Override
	 */
	public String toString() {
		return "Joueurs [cartesCachees=" + cartesCachees + ", cartesVisibles=" + cartesVisibles + ", cartesMain="
				+ cartesMain + "]";
	}
		
	/**
	 *  Getters et Setters de la Classe Joueurs  
	 **/
	/**
	 * @return the cartesCachees
	 */
	public ArrayList<String> getCartesCachees() {
		return cartesCachees;
	}

	/**
	 * @param cartesCachees the cartesCachees to set
	 */
	public void setCartesCachees(ArrayList<String> cartesCachees) {
		this.cartesCachees = cartesCachees;
	}

	/**
	 * @return the cartesVisibles
	 */
	public ArrayList<String> getCartesVisibles() {
		return cartesVisibles;
	}

	/**
	 * @param cartesVisibles the cartesVisibles to set
	 */
	public void setCartesVisibles(ArrayList<String> cartesVisibles) {
		this.cartesVisibles = cartesVisibles;
	}

	/**
	 * @return the cartesMain
	 */
	public ArrayList<String> getCartesMain() {
		return cartesMain;
	}

	/**
	 * @param cartesMain the cartesMain to set
	 */
	public void setCartesMain(ArrayList<String> cartesMain) {
		this.cartesMain = cartesMain;
	}
	/**
	 * @return the carte
	 */
	public int getCarte() {
		return carte;
	}

	/**
	 * @param carte the carte to set
	 */
	public void setCarte(int carte) {
		this.carte = carte;
	}
}