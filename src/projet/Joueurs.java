/**
 * 
 */
package projet;

import java.util.ArrayList;

/**
 * @author Jean Cornil
 *
 */
public class Joueurs {
	
	private ArrayList<String> cartesCachees= new ArrayList();
	private ArrayList<String> cartesVisibles;
	private ArrayList<String> cartesMain;
	
	
	public Joueurs(){
		//ArrayList<String>carteCachees = new ArrayList();
		ArrayList<String> cartesVisibles= new ArrayList();;
		ArrayList<String> cartesMain= new ArrayList();;
	}
	/**
	 * @Override
	 */
	public String toString() {
		return "Joueurs [cartesCachees=" + cartesCachees + ", cartesVisibles=" + cartesVisibles + ", cartesMain="
				+ cartesMain + "]";
	}
	
	/**
	 * @param carteJoueurs
	 * @param i de 0 a 2
	 * i représente la carte a remplacer dans les cartes cachées
	 * 
	 */
	/*
	public void estCachee(Carte carteJoueurs, int i) {
		if (i <= 2 && i >= 0) {
			cartesCachees[i] = carteJoueurs.toString();
		}
		else
			System.out.println("Position impossible dans les cartes cachées");
	}
	
	/**
	 * 
	 * @param carteJoueurs
	 * @param i de 0 a 2
	 * i représente la carte a remplacer dans les cartes visibles
	 * 
	 */
	/*
	public void estVisible(Carte carteJoueurs, int i) {
		if (i <= 2 && i >= 0) {
			cartesVisibles[i] = carteJoueurs.toString();
		}
		else
			System.out.println("Position impossible dans les cartes visibles");
	}
	/**
	 * 
	 * @param carteJoueurs
	 * @param i
	 */
	/*
	public void estEnMain(Carte carteJoueurs, int i) {
		cartesMain[i] = carteJoueurs.toString();
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


}
