/**
 * 
 */
package projet;

/**
 * @author Simon
 *
 */
public class Jeu {
	private Deck deck;
	private Carte[] joueur;
	private int nbJoueurs =3;
	private Carte[] derniereCartePosee;
	private Carte[] carteCoupee;
	
	/**
	 * Chaque joueur reçoit: 3 cartes cachées, 3 cartes visibles et 3 cartes en main
	 * Le reste des cartes est placé dans la pioche
	 */
	public void distribution() {
		
		Joueurs joueurA = new Joueurs(0,0);
		Joueurs joueurB = new Joueurs(1,0);
		Joueurs joueurC = new Joueurs(2,0);
		/*
		Deck paquet =  new Deck();
		paquet.melange(200);
		for (int i =0; i<3 ; i++) {
			for(int j =0; j < nbJoueurs; j++) {
				joueurA.setCarteCachees()[i].add(paquet.length);
				paquet.remove(0);
			}
			
		}
		*/
	}
	
	public void validation() {
		
	}
}
