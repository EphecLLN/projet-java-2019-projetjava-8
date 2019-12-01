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
    private Carte[] carteCoupee;
    private static Joueurs joueur[];
    
    /**
     * 
     */
    public Jeu() {
        Deck paquetDeck = new Deck();
        paquetDeck.melange(200);
        joueur[0] = new Joueurs();
        joueur[1] = new Joueurs();
        joueur[2] = new Joueurs();
       // nbJoueurs = joueur.length;
        
    }
	/**
	 * @return the premiereCarte
	 */
	

	/**
	 * Méthode qui prend la première carte du paquet et la supprime de celui-ci
	 */
	public static String donnerCarte() {
		paquetDeck.melange(200);
		return paquetDeck.getPremiereCarte();
		
	}
	
	/**
	 * 
	 * @return 
	 */
	public static void distribuerCarte(String position, int nbCartes) {
		
		for (int i =0; i<nbCartes ; i++) {
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
	 * Getters and setters
	 */
	
	/**
	 * 
	 */
	public static void main(String[] args) {
		
		for (int i =0; i<3 ; i++) {
			for(int j =0; j < nbJoueurs; j++) {
				
				ArrayList<String> k= new ArrayList<String>();
				System.out.println("cartecachee" + joueur[j].getCartesCachees());
				k = joueur[j].getCartesCachees();
				System.out.println("k = " +k);
				donnerCarte();
				System.out.println("Première Carte" + premiereCarte);
				k.add(premiereCarte);
				joueur[j].setCartesCachees(k);
			}
		}
		//return joueur1.getCartesCachees();
		
	}
	
}

