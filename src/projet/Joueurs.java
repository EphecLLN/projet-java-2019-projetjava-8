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
	private String carte;
	
	
	public Joueurs(){
		//ArrayList<String>carteCachees = new ArrayList();
		this.cartesVisibles = new ArrayList<String>();
		this.cartesMain = new ArrayList<String>();
		this.cartesCachees = new ArrayList<String>();
	}
	
	public String demanderCarteAJouer() {
		String str = "";
		str += "Quelle Carte voulez vous jouer?; \n";
		str += "Taper 1 pour: " + cartesMain.get(0) +"\n";
		str += "Taper 2 pour: " + cartesMain.get(1) +"\n";
		str += "Taper 3 pour: " + cartesMain.get(2) +"\n";
		return str;
	}
	public String choisirCarte() {
		Scanner sc = new Scanner(System.in);
		carte = sc.nextLine();
		return carte;
	}
	
	
	public String jouerCarte(String carte) {
		String str ="";
		switch(carte) {
			case "1":
				str = "Vous jouer la carte " + cartesMain.get(0);
				break;
			case "2":
				str = "Vous jouer la carte " + cartesMain.get(1);
				break;
			case "3":
				str = "Vous jouer la carte " + cartesMain.get(2);
				break;
			default:
				System.out.println( "mauvaise sélection !");
		}
		return str + "\n";
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
	public String getCarte() {
		return carte;
	}

	/**
	 * @param carte the carte to set
	 */
	public void setCarte(String carte) {
		this.carte = carte;
	}

}