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
	private  ArrayList<String> cartesMain;
	private static int carte;
	
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
		if(getCartesMain().size() > 0) {
			System.out.println("Vous jouer avec les cartes en main");
			for (int i = 0; i < getCartesMain().size(); i++) {
				j = i +1;
				str += "Taper " + j +" pour: " + cartesMain.get(i) +"\n";
			}
		}else if(getCartesVisibles().size() > 0 && getCartesMain().size() == 0) {
			System.out.println("Vous jouer avec les cartes Visible");
			for (int i = 0; i < getCartesVisibles().size(); i++) {
				j = i +1;
				str += "Taper " + j +" pour: " + cartesVisibles.get(i) +"\n";
			}
		}else if(getCartesCachees().size() > 0 && getCartesVisibles().size() == 0 && getCartesMain().size() == 0) {
			System.out.println("Vous jouer avec les cartes Cachees");
			for (int i = 0; i < getCartesVisibles().size(); i++) {
				j = i +1;
				str += "Taper " + j +" pour: " + cartesVisibles.get(i) +"\n";
			}
		}else if(getCartesCachees().size() > 0 && getCartesVisibles().size() == 0 && getCartesMain().size() == 0) {
				System.out.println("BRAVO ! Vous gagner la partie");
		}
		j++;
		//str += "Taper " + j +" si vous devez passer votre tour";
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
	public void verifierCarte(int carte) {
		int carteMoinsUn = carte -1;
		int valeur = 0;
		int valeurDerniereCartePosee = Jeu.getValeurDerniereCartePosee();
		
		if(getCartesMain().size() > 0) {
			valeur = Jeu.donnerValeur(cartesMain.get(carteMoinsUn));
			if(valeurDerniereCartePosee == 8) {
				System.out.println("Vous passez votre tour, dommage!");
				Jeu.setValeurDerniereCartePosee(9);
			}else {	
				if(valeurDerniereCartePosee == 7 && valeur <= valeurDerniereCartePosee ){
					jouerCartes(valeur);
					System.out.println(valeur);
				}else if(valeurDerniereCartePosee == 7 && valeur >= valeurDerniereCartePosee ){
					System.out.println("Vous ne pouvez pas jouer cette carte !");
					System.out.println("Pas de bol, vous recuperer le paquet !");
					recupererCartesJouees();
					Jeu.setValeurDerniereCartePosee(0);
				}else if( valeur >= valeurDerniereCartePosee || valeur == 10 || valeur == 2 || valeur ==3) {
					jouerCartes(valeur);
				}else{
					System.out.println("Vous ne pouvez pas jouer cette carte !");
					System.out.println("Pas de bol, vous recuperer le paquet !");
					recupererCartesJouees();
					Jeu.setValeurDerniereCartePosee(0);
				}
			}
		}else if(getCartesVisibles().size() > 0 && getCartesMain().size() == 0) {
			valeur = Jeu.donnerValeur(cartesVisibles.get(carteMoinsUn));
			if(valeurDerniereCartePosee == 8) {
				System.out.println("Vous passez votre tour, dommage!");
				Jeu.setValeurDerniereCartePosee(9);
			}else {	
				if(valeurDerniereCartePosee == 7 && valeur <= valeurDerniereCartePosee ){
					jouerCartes(valeur);
					System.out.println(valeur);
				}else if(valeurDerniereCartePosee == 7 && valeur >= valeurDerniereCartePosee ){
					System.out.println("Vous ne pouvez pas jouer cette carte !");
					System.out.println("Pas de bol, vous recuperer le paquet !");
					recupererCartesJouees();
					Jeu.setValeurDerniereCartePosee(0);
				}else if( valeur >= valeurDerniereCartePosee || valeur == 10 || valeur == 2 || valeur ==3) {
					jouerCartes(valeur);
				}else{
					System.out.println("Vous ne pouvez pas jouer cette carte !");
					System.out.println("Pas de bol, vous recuperer le paquet !");
					recupererCartesJouees();
					Jeu.setValeurDerniereCartePosee(0);
				}
			}
		}else if(getCartesCachees().size() > 0 && getCartesVisibles().size() == 0 && getCartesMain().size() == 0) {
			valeur = Jeu.donnerValeur(cartesCachees.get(carteMoinsUn));
			if(valeurDerniereCartePosee == 8) {
				System.out.println("Vous passez votre tour, dommage!");
				Jeu.setValeurDerniereCartePosee(9);
			}else {	
				if(valeurDerniereCartePosee == 7 && valeur <= valeurDerniereCartePosee ){
					jouerCartes(valeur);
					System.out.println(valeur);
				}else if(valeurDerniereCartePosee == 7 && valeur >= valeurDerniereCartePosee ){
					System.out.println("Vous ne pouvez pas jouer cette carte !");
					System.out.println("Pas de bol, vous recuperer le paquet !");
					recupererCartesJouees();
					Jeu.setValeurDerniereCartePosee(0);
				}else if( valeur >= valeurDerniereCartePosee || valeur == 10 || valeur == 2 || valeur ==3) {
					jouerCartes(valeur);
				}else{
					System.out.println("Vous ne pouvez pas jouer cette carte !");
					System.out.println("Pas de bol, vous recuperer le paquet !");
					recupererCartesJouees();
					Jeu.setValeurDerniereCartePosee(0);
				}
			}
		}

		
		
	}
	
	public  void jouerCartes(int carte) {
		System.out.println("COUCOU");
		String str ="";
		String premiereCarte;
		ArrayList<String> m;
		ArrayList<String> k;
		int carteMoinsUn = getCarte()-1;
		int valeur = carte;
		int valeurDerniereCartePosee = Jeu.getValeurDerniereCartePosee();
		/**
		 * Dans le cas ou on joue une carte en main
		 */
		if(getCartesMain().size() > 0) {
			str = "Vous jouer la carte " + cartesMain.get(carteMoinsUn);
			m = Jeu.getCartesJouees();
			m.add(getCartesMain().get(carteMoinsUn));
			Jeu.setCartesJouees(m);
			cartesMain.remove(carteMoinsUn);
			
			if(getCartesMain().size() < 3 && Deck.getPaquetCarteMelange().size() > 0) {
				k = getCartesMain();
				premiereCarte = Jeu.donnerCarte();
				k.add(premiereCarte);
				setCartesMain(k);
				str += "\nVous piocher la carte "+ premiereCarte;
			}
			System.out.println(str);
			
			if(Jeu.getCartesJouees().size() == 0 || valeur == 2 || valeur == 10){
				Jeu.setValeurDerniereCartePosee(0);
			}else if(valeur == 3 && Jeu.getCartesJouees().size() > 1) {
				Jeu.setValeurDerniereCartePosee(Jeu.donnerValeur(Jeu.getCartesJouees().get(Jeu.getCartesJouees().size()-2)));
			}else if (valeur == 3 && Jeu.getCartesJouees().size() == 1){
				Jeu.setValeurDerniereCartePosee(0);
			}else {
				Jeu.setValeurDerniereCartePosee(Jeu.donnerValeur(Jeu.getCartesJouees().get(Jeu.getCartesJouees().size()-1)));
			}
			Carte.estSpecial(valeur);
			
			/**
			 * Dans le cas ou on joue une carte visible
			 */	
		}else if(getCartesVisibles().size() > 0 && getCartesMain().size() == 0) {
			str = "Vous jouer la carte " + cartesVisibles.get(carteMoinsUn);
			m = Jeu.getCartesJouees();
			m.add(getCartesVisibles().get(carteMoinsUn));
			Jeu.setCartesJouees(m);
			cartesVisibles.remove(carteMoinsUn);
			System.out.println(str);
			
			if(Jeu.getCartesJouees().size() == 0 || valeur == 2 || valeur == 10){
				Jeu.setValeurDerniereCartePosee(0);
			}else if(valeur == 3) {
				Jeu.setValeurDerniereCartePosee(Jeu.donnerValeur(Jeu.getCartesJouees().get(Jeu.getCartesJouees().size()-2)));
			}else {
				Jeu.setValeurDerniereCartePosee(Jeu.donnerValeur(Jeu.getCartesJouees().get(Jeu.getCartesJouees().size()-1)));
			}
			Carte.estSpecial(valeur);
		
		/**
		 * Dans le cas ou on joue une carte cachées
		 */
		}else if(getCartesCachees().size() > 0 && getCartesVisibles().size() == 0 && getCartesMain().size() == 0) {
			str = "Vous jouer la carte " + cartesCachees.get(carteMoinsUn);
			m = Jeu.getCartesJouees();
			m.add(getCartesCachees().get(carteMoinsUn));
			Jeu.setCartesJouees(m);
			cartesCachees.remove(carteMoinsUn);
			System.out.println(str);
			
			if(Jeu.getCartesJouees().size() == 0 || valeur == 2 || valeur == 10){
				Jeu.setValeurDerniereCartePosee(0);
			}else if(valeur == 3) {
				Jeu.setValeurDerniereCartePosee(Jeu.donnerValeur(Jeu.getCartesJouees().get(Jeu.getCartesJouees().size()-2)));
			}else {
				Jeu.setValeurDerniereCartePosee(Jeu.donnerValeur(Jeu.getCartesJouees().get(Jeu.getCartesJouees().size()-1)));
			}
			Carte.estSpecial(valeur);
			}
		

	}
	/**
	 * Cette méthode va recuperer un int qui sera la valeur de la carte
	 * @param carte (valeur + couleur) en un string
	 * @return la valeur de la carte
	 */
	
	/**
	 * Cette methode permet de reprendre tout le tas de cartes jouee losqu'un joueur ne sait plus poser de cartes
	 */
	public void recupererCartesJouees() {
		while (Jeu.getCartesJouees().size() > 0) {
			String a;
			a = Jeu.getCartesJouees().get(0);
			getCartesMain().add(a);
			System.out.println("bbb");
			System.out.println(Jeu.getCartesJouees() + "1");
			System.out.println(getCartesMain() + "2");
			Jeu.getCartesJouees().remove(0);
			
		}
	}
	public void recupererValeur() {
		
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
	
	public void getCartesPosition(String position) {
		
		switch(position){
		case "main":
			getCartesMain();
			break;
		case "visible":
			getCartesVisibles();
			break;
		case "cachee":
			getCartesCachees();
			break;
		default:
				System.out.println("Erreur position");
		}
	}
	
public void SetCartesPosition(String position, ArrayList<String> cartes) {
		
		switch(position){
		case "main":
			setCartesMain(cartes);
			break;
		case "visible":
			setCartesVisibles(cartes);
			break;
		case "cachee":
			setCartesCachees(cartes);
			break;
		default:
				System.out.println("Erreur position");
		}
	}
}