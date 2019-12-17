package vue;


import java.util.*;
import javax.swing.JPanel;
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
	
	private class ReadInput implements Runnable{
		public void run() {
			while(!fin){
				try {
					jControl.printTextMenu(i, 0); 
					i = scan.nextInt();
					
					affiche("---------- Votre partie de Beat The Donjon va commencer... ----------");
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
