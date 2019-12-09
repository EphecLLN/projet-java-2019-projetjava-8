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
    private Carte[] derniereCartePosee;
    private static int nombreDeCartes = 3;
    private Carte[] carteCoupee;
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
	 * 
	 */
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
								joueur[i].choisirCarte();
								joueur[i].jouerCarte(joueur[i].getCarte());
						}
					}
				}
			}
		}
		new Thread (new deposerCarte()).start();
	}
	
}