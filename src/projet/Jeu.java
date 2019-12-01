/**
 * 
 */
package projet;
import java.util.ArrayList;
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
       // nbJoueurs = joueur.length;   
    }
	/**
	 * @return the premiereCarte
	 */
	

	/**
	 * Méthode qui prend la première carte du paquet et la supprime de celui-ci
	 */
	public static String donnerCarte() {
		//paquetDeck.melange(200);
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
	 * 
	 */
	public static void main(String[] args) {
		Jeu game = new Jeu();
		distribuerCarte("cache");
		distribuerCarte("visible");
		distribuerCarte("main");		
		// chaque joueur a ses 3 arrays cache, visible et main rempli.
		
		
		for (int j = 0; j < nbJoueurs; j++) {
			for( int i = 0; i < 3; i++) {
				System.out.println("joueur " + j + " cache " + i + " : " + joueur[j].getCartesCachees().get(i));
	
				System.out.println("joueur " + j + " visible " + i + " : " + joueur[j].getCartesVisibles().get(i));
	
				System.out.println("joueur " + j + " main " + i + " : " + joueur[j].getCartesMain().get(i));
			}
		}	
		
		System.out.println(Deck.paquetCarteMelange.size());
		
	}
	
}