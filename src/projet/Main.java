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
		/*for(int i=0; i < 4; i++) {
			for(int j=0; j < 13; j++) {
				Carte carte = new Carte(i, j);
				System.out.println(carte.toString());
				carte.estSpecial();
			}
		}
		*/
		Deck paquet =  new Deck();
		paquet.melange(200);
		int g = 0;
		for (int i =0; i<52; i++) {
			g++;
			/*
			System.out.print(paquet.getPaquetCarte()[i].getCarteValeur());
			System.out.println(" " + paquet.getPaquetCarte()[i].getCarteCouleur());
			*/
			System.out.print(paquet.getPaquetCarte()[i].toString()+ "\n");
		}
		System.out.println(g);
	}
}
