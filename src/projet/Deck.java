/**
 * 
 */
package projet;

/**
 * La classe Deck represente le paquet de carte à jouer. 
 * Il est composé de 52 cartes et peut être mélangé.
 * 
 * @author Humbert
 *
 */
public class Deck{

	public static final int NCARTES = 52; //Nombre de cartes totales dans un deck

	private Carte[] paquetCarte;      //Ensemble des cartes du paquet
	private int compteurCarte;   //Carte au dessus du paquet

	public Deck() {
		paquetCarte = new Carte[NCARTES];
		int i = 0;
		
		for(int couleur = 0; couleur < 4; couleur++) {
			for(int valeur = 0; valeur < 13; valeur++) {
				paquetCarte[i++] = new Carte(couleur, valeur);
			}
		}
		compteurCarte = 0;       //Nouveau paquet de carte
	}
	
	
	/**
	 * Cette methode melange le paquet le nombre de fois que l'on veut.
	 * @param n un entier positif déterminant le nombre de fois que l'on veut melanger le paquet
	 */
	public void melange(int n)
    {
 	 int carte1, carte2, k;
  
 	 for ( k = 0; k < n; k++ )
 	 {
 	     carte1 = (int) ( NCARTES * Math.random() );  // Prends 2 cartes aléatoirement
 	     carte2 = (int) ( NCARTES * Math.random() );  // dans le paquet
  
 	    
 	     Carte tmp = paquetCarte[carte1];
 	     paquetCarte[carte1] = paquetCarte[carte2];
 	     paquetCarte[carte2] = tmp;
 	 }
  
 	 compteurCarte = 0;   // Reset current card to deal
    }

	public String getPremiereCarte() {
		return paquetCarte[0].toString();
	}

	/**
	 * @return the paquet
	 */
	public Carte[] getPaquetCarte() {
		return paquetCarte;
	}


	/**
	 * @param paquet the paquet to set
	 */
	public void setPaquetCarte(Carte[] paquetCarte) {
		this.paquetCarte = paquetCarte;
	}


	/**
	 * @return the ncartes
	 */
	public static int getNcartes() {
		return NCARTES;
	}

}