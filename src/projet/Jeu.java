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
    private static String premiereCarte;
    private static Joueurs joueur[];
    
    /**
     * 
     */
    public Jeu() {
        Deck paquetDeck = new Deck();
        paquetDeck.melange(200);
        this.premiereCarte = "";
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
	public static void donnerCarte() {
		paquetDeck.melange(200);
		premiereCarte = paquetDeck.getPremiereCarte();
		
	}
	
	/**
	 * Chaque joueur reçoit: 3 cartes cachées, 3 cartes visibles et 3 cartes en main
	 * Le reste des cartes est placé dans la pioche
	 * @return 
	 */
	public  ArrayList<String> distribuerCarte() {
		for (int i =0; i<3 ; i++) {
			for(int j =0; j < nbJoueurs; j++) {
				
				ArrayList<String> k= new ArrayList<String>();
				k = joueur[j].getCartesCachees();
				donnerCarte();
				k.add(premiereCarte);
				joueur[j].setCartesCachees(k);
				return k;
				
			}
		}
		//return joueur1.getCartesCachees();
		return null;
	}
	
	/**
	 * 
	 * Getters and setters
	 */
	public String getPremiereCarte() {
		return premiereCarte.toString();
	}

	/**
	 * @param premiereCarte the premiereCarte to set
	 */
	public void setPremiereCarte(String premiereCarte) {
		this.premiereCarte = premiereCarte;
	}
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

