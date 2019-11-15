/**
 * 
 */
package projet;

/**
 * @author Jean Cornil
 *
 */
public class Joueurs {
	private Deck mainJoueur;
	private int nbrCartes;
	private int id;
	
	private int[][] cartesCachees;
	private int[][] cartesVisibles;
	private int[][] cartesMain;
	
	
	public Joueurs(int id, int nbrCartes){
		id = this.id;
		nbrCartes = this.nbrCartes;
	}
	
	
	/**
	 * @param carteJoueurs
	 * @param i de 0 a 2
	 * i représente la carte a remplacer dans les cartes cachées
	 * 
	 */
	
	public void estCachee(Carte carteJoueurs, int i) {
		if (i <= 2 && i >= 0) {
			cartesCachees[i][0] = carteJoueurs.getCarteCouleur();
			cartesCachees[i][1] = carteJoueurs.getCarteValeur();
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
	
	public void estVisible(Carte carteJoueurs, int i) {
		if (i <= 2 && i >= 0) {
			cartesVisibles[i][0] = carteJoueurs.getCarteCouleur();
			cartesVisibles[i][1] = carteJoueurs.getCarteValeur();
		}
		else
			System.out.println("Position impossible dans les cartes visibles");
	}
	/**
	 * 
	 * @param carteJoueurs
	 * @param i
	 */
	public void estEnMain(Carte carteJoueurs, int i) {
		cartesMain[i][0] = carteJoueurs.getCarteCouleur();
		cartesMain[i][1] = carteJoueurs.getCarteValeur();
	}
	
	/**
	 * Cree une copie de la carte remplacee en position 4 de la main ( valeur temporaire)
	 * @param etat
	 * @param i représente la carte a remonter en main
	 */
	
	public void retourneMain(String etat,int i) {
		switch(etat) {
		case "visible":
			cartesMain[3][0] = cartesVisibles[i][0];
			cartesMain[3][1] = cartesVisibles[i][1];
		case "main":
			cartesMain[3][0] = cartesMain[i][0];
			cartesMain[3][1] = cartesMain[i][1];
		}
	}
	
	/**
	 * Echange un carte de la main avec une des cartes visibles
	 * @param carteJoueur
	 * @param idCarte id en main
	 * @param etat "cachee" ou "visible"
	 * @param carteRemplacee id de la carte a remplacer
	 */
	
	public void echange(Carte carteJoueur, int idCarte, String etat,int carteRemplacee) {
		retourneMain(etat,carteRemplacee);
		switch(etat) {
		case "visible":
			estVisible(carteJoueur,carteRemplacee);
		case "main":
			estEnMain(carteJoueur,carteRemplacee);
		case "cachee":
			System.out.println("on ne peut pas echanger ses cartes avec les cartes cachees");		
		}
		cartesMain[idCarte][0] = cartesMain[3][0];
	}
	/**
	 *  Getters et Setters de la Classe Joueurs  
	 **/
	
	public int getNbrCartes() {
		return nbrCartes;
	}
	
	public void setNbrCartes(int nbrCartes) {
		this.nbrCartes = nbrCartes;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
