/**
 * 
 */
package projet;

import java.util.ArrayList;

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
	public static ArrayList<Carte> paquetCarteMelange;
	private int compteurCarte;   //Carte au dessus du paquet

	public Deck() {
		paquetCarte = new Carte[NCARTES];
		paquetCarteMelange = new ArrayList<Carte>();
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
	
	void tabToArray() {
		for (int i = 0; i< this.paquetCarte.length; i++) {
			paquetCarteMelange.add(paquetCarte[i]);
		}
		System.out.println("size : " + paquetCarteMelange.size());
	}

	/**
	 * @return the paquetCarteMelange
	 */
	public static ArrayList<Carte> getPaquetCarteMelange() {
		return paquetCarteMelange;
	}


	/**
	 * @param paquetCarteMelange the paquetCarteMelange to set
	 */
	public static void setPaquetCarteMelange(ArrayList<Carte> paquetCarteMelange) {
		Deck.paquetCarteMelange = paquetCarteMelange;
	}


	/**
	 * @return the compteurCarte
	 */
	public int getCompteurCarte() {
		return compteurCarte;
	}


	/**
	 * @param compteurCarte the compteurCarte to set
	 */
	public void setCompteurCarte(int compteurCarte) {
		this.compteurCarte = compteurCarte;
	}


	public String getPremiereCarte() {
		String premiere = paquetCarteMelange.get(0).toString();
		paquetCarteMelange.remove(0);
		compteurCarte ++;
		return premiere;
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