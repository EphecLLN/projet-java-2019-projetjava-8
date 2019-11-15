package projet;

import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class JoueursTest {

	@Test
	void testConstructeurVide() {
		Joueurs j = new Joueurs();
		assertEquals(0, j.getId());
		assertEquals(0, j.getNbrCartes());
	}
	@Test
	void testConstructeur () {
		Joueurs j = new Joueurs(2,5);
		assertEquals(2, j.getId());
		assertEquals(5, j.getNbrCartes());
	}
	@Test	
	void testEstCachee() {
		Carte c1 = new Carte(1,5);
		Joueurs j = new Joueurs(1,9);
		j.estCachee(c1,2);
		int[][] carteJ = j.getCartesCachees();
		/**
		 * test le nombre de cartes
		 */
		assertEquals(9,j.getNbrCartes());
		/**
		 * test le int correspondant a la couleur
		 */
		assertEquals(1,carteJ[2][0]);
		/**
		 * test le int correspondant a la valeur
		 */
		assertEquals(5,carteJ[2][1]);
	}
	@Test
	void testEstVisible() {
		Carte c1 = new Carte(2,3);
		Joueurs j = new Joueurs(1,7);
		j.estVisible(c1,0);
		int[][] carteJ = j.getCartesVisibles();
		/**
		 * test le nombre de cartes
		 */
		assertEquals(7,j.getNbrCartes());
		/**
		 * test le int correspondant a la couleur
		 */
		assertEquals(2,carteJ[0][0]);
		/**
		 * test le int correspondant a la valeur
		 */
		assertEquals(3,carteJ[0][1]);
	}
	@Test
	void testEstEnMain() {
		Carte c1 = new Carte(1,12);
		Joueurs j = new Joueurs(1,5);
		j.estEnMain(c1,0);
		int[][] carteJ = j.getCartesMain();
		/**
		 * test le nombre de cartes
		 */
		assertEquals(5,j.getNbrCartes());
		/**
		 * test le int correspondant a la couleur
		 */
		assertEquals(1,carteJ[0][0]);
		/**
		 * test le int correspondant a la valeur
		 */
		assertEquals(12,carteJ[0][1]);
	}
}
