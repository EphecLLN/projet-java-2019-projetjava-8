/**
 * 
 */
package projet;

/**
 * @author Simon
 *
 */
public class Main{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i=0; i < 4; i++) {
			for(int j=0; j < 13; j++) {
				Carte carte = new Carte(i, j);
				System.out.println(carte.toString());
				carte.estSpecial();
			}
		}
	}
}
