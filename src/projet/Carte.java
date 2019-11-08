/**
 * 
 */
package projet;

/**
 * @author Simon
 *
 */
public class Carte {

	String[] couleurs = {"coeur","trefle","pique","carreau"};
	String[] valeurs = {"2","3","4","5","6","7","8","9","10","Valet","Dame","Rois","As"};

	Carte [] deck = new Carte[52];
	
	/**
	 * Constructeurs du deck créant les 52 cartes
	 */
	public static Carte[] creationCarte() {
		int k=0;
		for (int i=0; i< couleurs.length; i++) { 
			for (int j = 0; j< valeurs.length; j++) {
				deck[k]= new Carte();
				k++;
			}
		}
		return deck;
	}
	public static void main(String[] args) {
		creationCarte();
	}
}