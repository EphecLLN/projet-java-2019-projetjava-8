/**
 * 
 */
package projet;

/**
 * @author Jean Cornil
 *
 */
public class Joueurs {
	private int nbrCartes;
	private int id;
	
	private String[] cartesCachees= {
			"","",""
		};
	private String[] cartesVisibles= {
			"","",""
		};
	private String[] cartesMain= {
			"","",""
		};
	
	public Joueurs(){
		id = 0;
		nbrCartes = 0;
	}
	
	public Joueurs(int id, int nbrCartes){
		this.id = id;
		this.nbrCartes = nbrCartes;
	}
	
	/**
	 * @param carteJoueurs
	 * @param i de 0 a 2
	 * i représente la carte a remplacer dans les cartes cachées
	 * 
	 */
	
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
	public void estEnMain(Carte carteJoueurs, int i) {
		cartesMain[i] = carteJoueurs.toString();
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

	/**
	 * @return the cartesCachees
	 */
	public String[] getCartesCachees() {
		return cartesCachees;
	}

	/**
	 * @param cartesCachees the cartesCachees to set
	 */
	public void setCartesCachees(String[] cartesCachees) {
		this.cartesCachees = cartesCachees;
	}

	/**
	 * @return the cartesVisibles
	 */
	public String[] getCartesVisibles() {
		return cartesVisibles;
	}

	/**
	 * @param cartesVisibles the cartesVisibles to set
	 */
	public void setCartesVisibles(String[] cartesVisibles) {
		this.cartesVisibles = cartesVisibles;
	}

	/**
	 * @return the cartesMain
	 */
	public String[] getCartesMain() {
		return cartesMain;
	}

	/**
	 * @param cartesMain the cartesMain to set
	 */
	public void setCartesMain(String[] cartesMain) {
		this.cartesMain = cartesMain;
	}


}
