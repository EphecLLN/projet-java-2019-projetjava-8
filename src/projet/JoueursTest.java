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
		Joueurs j = new Joueurs(1,9);
		assertEquals(1, j.getId());
		assertEquals(9, j.getNbrCartes());
	}
	void testEstCachee() {
		Carte c1 = new Carte(1,5);
		Joueurs j = new Joueurs(1,9);
	}
}
