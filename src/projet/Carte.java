/**
 * 
 */
package projet;

/**
 * @author Simon
 *
 */

public class Carte{

	private static final String[] couleur = { "Carreau", "Coeur", "Trefle", "Pique"};
	private static final String[] valeur = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "Valet", "Dame", "Roi", "As"};
	protected  boolean estJouee = false;
	protected  boolean estCoupee = false;
	protected  boolean estDansPioche = true;

	private byte carteCouleur;
	private byte carteValeur;

	public Carte( int suit, int rank ){
		carteValeur = (byte) rank;
		carteCouleur = (byte) suit;
	}

	public static  void estSpecial(int valeur) {
		/*String valeur = "";
		if(carte.indexOf('2') != -1) {
			valeur = "2";
		}else if(carte.indexOf('3') != -1) {
			valeur = "3";
		}else if(carte.indexOf('7') != -1) {
			valeur = "7";
		}else if(carte.indexOf('8') != -1) {
			valeur = "8";
		}else if(carte.indexOf("10") != -1) {
			valeur = "10";
		}else if(carte.indexOf("As") != -1) {
			valeur = "As";
		}
		*/
		switch(valeur ) {
			case 2 : 
				System.out.println("Je suis special, Je remet à 0"); 
				break;
			case 3:
				System.out.println("Je suis special, je copie la carte précédente"); 
				Jeu.setValeurDerniereCartePosee(Jeu.donnerValeur(Jeu.getCartesJouees().get(Jeu.getCartesJouees().size()-2)));
				System.out.println("valderncarte " + Jeu.getValeurDerniereCartePosee());
				break;
			case 7:
				System.out.println("Je suis special, Le suivant doit jouer une carte inférieure à 7"); 
				break;
			case 8:
				System.out.println("Je suis special, le joueur suivant passe son tour"); 
				break;
			case 10:
				System.out.println("Je suis special, Je coupe le jeu");
				Jeu.couperCartes();
				break;
			case 14: 
				System.out.println("Je suis special, j' attaque un joueur de mon choix"); 
				break;
			default : 
				System.out.println("Je suis banal");
		}
	}
	public String toString(){
		return ( this.valeur[ this.carteValeur ] + " de " + this.couleur[ this.carteCouleur ] );
	}
	
	/**
	 * @return the carteCouleur
	 */
	public byte getCarteCouleur() {
		return carteCouleur;
	}

	/**
	 * @param carteCouleur the carteCouleur to set
	 */
	public void setCarteCouleur(byte carteCouleur) {
		this.carteCouleur = carteCouleur;
	}

	/**
	 * @return the carteValeur
	 */
	public byte getCarteValeur() {
		return carteValeur;
	}

	/**
	 * @param carteValeur the carteValeur to set
	 */
	public void setCarteValeur(byte carteValeur) {
		this.carteValeur = carteValeur;
	}

	/**
	 * @return the couleur
	 */
	public static String[] getCouleur() {
		return couleur;
	}

	/**
	 * @return the valeur
	 */
	public static String[] getValeur() {
		return valeur;
	}
	/**
	 * @param estJouee the estJouee to set
	 */
	public void setEstJouee(boolean estJouee) {
		this.estJouee = estJouee;
	}



	/**
	 * @param estCoupee the estCoupee to set
	 */
	public void setEstCoupee(boolean estCoupee) {
		this.estCoupee = estCoupee;
	}



	/**
	 * @param estDansPioche the estDansPioche to set
	 */
	public void setEstDansPioche(boolean estDansPioche) {
		this.estDansPioche = estDansPioche;
	}
}