package vue;


import java.util.*;
import javax.swing.JPanel;

import Danish.controller.JeuController;
import projet.*;
import controller.*;

@SuppressWarnings("deprecation")
public class JeuVueConsole extends JeuVue implements Observer {
	
	protected Scanner sc;
	private volatile boolean fin = false;
	
	
	/**
	 * 
	 * @param j le jeu dans le modele MVC
	 * @param jControl le controleur du jeu dans le modele MVC
	 */
	public JeuVueConsole(Jeu j, JeuController jControl) {
		super(j, jControl);
		update(null, null);
		sc = new Scanner(System.in);
		new Thread (new ReadInput()).start();	
	}

	@Override
	public void affiche(String string) {
		System.out.println(string);
	}

	@Override
	public void update(Observable o, Object arg) {
		
	}
	
	/**
	 * set la variable end a true pour terminer la partie.
	 */
	private void fin() {
		this.fin = true;
	}

	/**
	 * affiche l exception en cas de catch.
	 */
	private void printHelpException(){
		this.affiche("Format d'entree non conforme, sans doute une lettre alphabetique.");
	}
	
	private class ReadInput implements Runnable{
		public void run() {
			while(!fin){
				try {
					//jControl.printTextMenu(i, 0); 
					//i = scan.nextInt();
					
					affiche("---------- Votre partie va bientot commencer ... ----------");
					fin();
				}
				catch(InputMismatchException e){
					affiche("Format d'input incorrect");
					printHelpException();
					System.exit(0);
				}
			}
		}
	}
	
	/**
	 * @return the fin
	 */
	public boolean isFin() {
		return fin;
	}

	/**
	 * @param fin the fin to set
	 */
	public void setFin(boolean fin) {
		this.fin = fin;
	}

}
