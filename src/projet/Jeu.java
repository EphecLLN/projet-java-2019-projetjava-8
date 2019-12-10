/**
 * 
 */
package projet;

import java.util.ArrayList;
import java.util.Scanner;
/**
 * @author Simon
 *
 */

public class Jeu {
    private static Deck paquetDeck = new Deck();
	static int nbJoueurs = 3;
    private static int valeurDerniereCartePosee = 0;
    private static int nombreDeCartes = 3;
    private static ArrayList<String> cartesCoupees;
	private static Joueurs joueur[];
    private static ArrayList<String> cartesJouees;

	/**
     * 
     */
    public Jeu() {
        Deck paquetDeck = new Deck();
        paquetDeck.melange(200);
        paquetDeck.tabToArray();
        joueur = new Joueurs[nbJoueurs];
        for (int i = 0; i< nbJoueurs; i++) {
        	joueur[i] = new Joueurs();
        }   
        cartesJouees = new ArrayList<String>();
        cartesCoupees = new ArrayList<String>();
        
        String derniereCartePosee = "";
    }
	/**
	 * Méthode qui prend la première carte du paquet et la supprime de celui-ci
	 */
	public static String donnerCarte() {
		if( Deck.getPaquetCarteMelange().size() == 0) {
			System.out.println("La pioche est vide !");
		}
		return paquetDeck.getPremiereCarte();
	}
	
	/**
	 * Chaque joueur reçoit: 3 cartes cache, 3 cartes visible et 3 cartes en main
	 * Le reste des cartes est placé dans la pioche
	 * @return 
	 */
	public static void distribuerCarte(String position) {
		for(int i =0; i < nombreDeCartes; i++) {
			for(int j =0; j < nbJoueurs; j++) {
				String premiereCarte = donnerCarte();
				ArrayList<String> k;
				switch(position) {
				case "cache":
					k = joueur[j].getCartesCachees();
					k.add(premiereCarte);
					joueur[j].setCartesCachees(k);
					break;
				case "visible":
					k = joueur[j].getCartesVisibles();
					k.add(premiereCarte);
					joueur[j].setCartesVisibles(k);
					break;
				case "main":
					k = joueur[j].getCartesMain();
					k.add(premiereCarte);
					joueur[j].setCartesMain(k);
					break;
				default:
					System.out.println("erreur");
				}	
			}	
		}
	}
	/**
	 * Cette methode permet de couper le jeu
	 */
	public static void couperCartes() {
		while(Jeu.getCartesJouees().size() > 0) {
			ArrayList<String> a;
			a = Jeu.getCartesJouees();
			Jeu.getCartesCoupees().addAll(a);
			for (int i =0; i<getCartesJouees().size(); i +=0) {
				getCartesJouees().remove(i);
			}
			System.out.println("Le jeu a ete coupe !");
			System.out.println("coupe" + getCartesCoupees());
		}	
	}
	public static void copierCarte(int valDerCarte) {
		Jeu.setValeurDerniereCartePosee(valDerCarte);
		//System.out.println("La carte est copiee");
	}
	public static int donnerValeur(String carte) {
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
	 * @return the cartesJouees
	 */
	public static ArrayList<String> getCartesJouees() {
		return cartesJouees;
	}

	/**
	 * @param cartesJouees the cartesJouees to set
	 */
	public static void setCartesJouees(ArrayList<String> cartesJouees) {
		cartesJouees = cartesJouees;
	}
	/**
	 * @return the paquetDeck
	 */
	public static Deck getPaquetDeck() {
		return paquetDeck;
	}

	/**
	 * @param paquetDeck the paquetDeck to set
	 */
	public static void setPaquetDeck(Deck paquetDeck) {
		Jeu.paquetDeck = paquetDeck;
	}
	/**
	 * @return the valeurDerniereCartePosee
	 */
	public static int getValeurDerniereCartePosee() {
		return valeurDerniereCartePosee;
	}
	/**
	 * @param valeurDerniereCartePosee the valeurDerniereCartePosee to set
	 */
	public static void setValeurDerniereCartePosee(int valeurDerniereCartePosee) {
		Jeu.valeurDerniereCartePosee = valeurDerniereCartePosee;
	}
	/**
	 * @return the cartesCoupees
	 */
	public static ArrayList<String> getCartesCoupees() {
		return cartesCoupees;
	}
	/**
	 * @param cartesCoupees the cartesCoupees to set
	 */
	public void setCartesCoupees(ArrayList<String> cartesCoupees) {
		this.cartesCoupees = cartesCoupees;
	}

	
	
	public static void main(String[] args) {
		final Jeu game = new Jeu();
		distribuerCarte("cache");
		distribuerCarte("visible");
		distribuerCarte("main");		
		// chaque joueur a ses 3 arrays cache, visible et main rempli.
		
		class deposerCarte implements Runnable{
			public void run() {
				int i=0;
				while(joueur[i].getCartesCachees().size() != 0 
						&& joueur[i].getCartesVisibles().size() != 0 
						&& joueur[i].getCartesMain().size() != 0 ) {
					for( int j = 0; j < 999999; j++) {
						for( i = 0; i <nbJoueurs ; i++) {
								System.out.println(" Joueur: " + i );
								joueur[i].demanderCarteAJouer();
								System.out.println("Vous devez jouer une valeur au dessus de : " + valeurDerniereCartePosee);
								joueur[i].choisirCarte();
								joueur[i].verifierCarte(joueur[i].getCarte());
								System.out.println("\n\n");
						}
					}
				}
			}
		}
		new Thread (new deposerCarte()).start();
		
	}
	
}