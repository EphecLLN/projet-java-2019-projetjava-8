/**
 * 
 */
package projet;

/**
 * @author Simon
 *
 */
public class Jeu {
	private Deck paquetDeck = new Deck();
	private Carte[] joueur;
	private int nbJoueurs =3;
	private Carte[] derniereCartePosee;
	private Carte[] carteCoupee;
	private Carte[] premiereCarte;
	/**
	 * @return the premiereCarte
	 */
	

	/**
	 * Méthode qui prend la première carte du paquet et la supprime de celui-ci
	 */
	public void donnerCarte() {
		//int  premiereCarte;
		premiereCarte = paquetDeck.getPaquetCarte();
		
	}
	
	/**
	 * Chaque joueur reçoit: 3 cartes cachées, 3 cartes visibles et 3 cartes en main
	 * Le reste des cartes est placé dans la pioche
	 */
	public void distribuerCarte() {
		
		Joueurs joueurA = new Joueurs(0,0);
		Joueurs joueurB = new Joueurs(1,0);
		Joueurs joueurC = new Joueurs(2,0);
		
		// Deck paquet =  new Deck();
		paquetDeck.melange(200);
		for (int i =0; i<3 ; i++) {
			for(int j =0; j < nbJoueurs; j++) {
				//joueurA.setCarteCachees()[i].add(paquet.length);
				//paquet.remove(0);
				//donnerCarte();
				//String k = premiereCarte;
				// joueurA.setCartesCachees([i][k]);
				joueurA.setCartesCachees(joueurA.getCartesCachees()).add(premiereCarte);
				
			}
			
		}
		
	}
	
	}

	public void validation() {
		
	}
	
	/**
	 * 
	 * Getters and setters
	 */
	public String getPremiereCarte() {
		return premiereCarte;
	}

	/**
	 * @param premiereCarte the premiereCarte to set
	 */
	public void setPremiereCarte(int premiereCarte) {
		this.premiereCarte = premiereCarte;
	}
}
