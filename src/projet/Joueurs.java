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
	 */
	public void jouerCarte(int carte) {
		String str ="";
		String premiereCarte;
		ArrayList<String> m;
		ArrayList<String> k;
		int carteMoinsUn = carte -1;
		int valeur;
		int valeurDerniereCartePosee = Jeu.getValeurDerniereCartePosee();
		
		
		valeur = donnerValeur(cartesMain.get(carteMoinsUn));	
		if(valeur >= valeurDerniereCartePosee) {
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
			System.out.println("-----");
			Carte.estSpecial(valeur);
		}else if(valeur < valeurDerniereCartePosee) {
			System.out.println("Vous ne pouvez pas jouer cette carte ! \n\n");
		}
		Jeu.setValeurDerniereCartePosee(donnerValeur(Jeu.getCartesJouees().get(Jeu.getCartesJouees().size()-1)));
	}
	public int donnerValeur(String carte) {
		int valeur = 0;
		if(carte.indexOf('2') != -1) {
			valeur = 2;
		}else if(carte.indexOf('3') != -1) {
			valeur = 3;
		}else if(carte.indexOf('4') != -1) {
			valeur = 4;
		}else if(carte.indexOf('5') != -1) {
			valeur = 5;
		}else if(carte.indexOf('6') != -1) {
			valeur = 6;
		}else if(carte.indexOf('7') != -1) {
			valeur = 7;
		}else if(carte.indexOf('8') != -1) {
			valeur = 8;
		}else if(carte.indexOf('9') != -1) {
			valeur = 9;
		}else if(carte.indexOf("10") != -1) {
			valeur = 10;
		}else if(carte.indexOf("Valet") != -1) {
			valeur = 11;
		}else if(carte.indexOf("Dame") != -1) {
			valeur = 12;
		}else if(carte.indexOf("Roi") != -1) {
			valeur = 13;
		}else if(carte.indexOf("As") != -1) {
			valeur = 14;
		}
		return valeur;
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