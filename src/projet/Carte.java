/**
 * 
 */
package projet;

/**
 * @author Simon
 *
 */
public class Carte {

	private static final String[] couleurs = {"coeur","trefle","pique","carreau"};
	private static final String[] valeurs = {"2","3","4","5","6","7","8","9","10","Valet","Dame","Rois","As"};

	static Carte [] deck = new Carte[52];
	
	/**
	 * Constructeurs du deck créant les 52 cartes
	 */
	public static Carte[] creationCarte() {
		int k=0;
		for (int i=0; i< couleurs.length; i++) { 
			for (int j = 0; j< valeurs.length; j++) {
				deck[k]= new Carte();
				//System.out.println(deck[k].toString());
				//return (Carte[])deck[k].valeurs;
				//return (Carte[])deck[k].couleurs;
				System.out.println(deck[k].valeurs +" "+ deck[k].couleurs);
				k++;
			}
		}
		 return deck;
	
	}
	public static void main(String[] args) {
		creationCarte();
		//System.out.println(deck.toString());
	}
	@Override
	public String toString() {
		return "Carte [getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
}