package vue;


import java.util.*;
import javax.swing.JPanel;
import projet.*;
import controller.*;

@SuppressWarnings("deprecation")
public class JeuVueConsole extends JeuVue implements Observer {

	/**
	 * Create the panel.
	 */
	public JeuVueConsole(Jeu j, JeuController jControl) {
		super(j, jControl);
		sc = new Scanner(System.in);
		new Thread (new ReadInput()).start();	
	}

}
