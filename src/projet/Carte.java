/**
 * 
 */
package projet;

/**
 * @author Simon
 *
 */

public class Carte{

	private static final String[] couleur = { "Carreau", "Coeur", "Trèfle", "Pique"};
	private static final String[] valeur = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "Valet", "Dame", "Roi", "As"};

	private byte carteCouleur;
	private byte carteValeur;

	public Carte( int suit, int rank ){
		carteValeur = (byte) rank;
		carteCouleur = (byte) suit;
	}

	public int couleur(){
		return ( carteCouleur );         // This is a shorthand for:
		//   this.cardSuit
	}

	public String couleurStr(){
		return( couleur[ carteCouleur ] );  // This is a shorthand for:
		//   this.Suit[ this.cardSuit ]
	}

	public  int valeur(){
		return ( carteValeur );
	}

	public String valeurStr(){
		return ( valeur[ carteValeur ] );
	}

	public String toString(){
		return ( valeur[ carteValeur ] + " de " + couleur[ carteCouleur ] );
	}
/*
	public static void main(String[] args) {
		for(int i=0; i < couleur.length; i++) {
			for(int j=0; j < valeur.length; j++) {
				Carte carte = new Carte(i, j);
				System.out.println(carte.toString());
			}
		}
	}
	*/
}