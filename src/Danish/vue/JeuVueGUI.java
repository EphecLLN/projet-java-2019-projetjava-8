package Danish.vue;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;
import Danish.controller.*;
import Danish.model.*;
import java.awt.event.ActionEvent;
import javax.swing.event.MenuListener;

import Danish.controller.JeuController;

import javax.swing.event.MenuEvent;

@SuppressWarnings("deprecation")
public class JeuVueGUI extends JeuVue implements ActionListener, Observer {

	private JFrame jeuJFrame;
	private JPanel jeuMenu;
	private JPanel jeuPartie;
	private JPanel jeuRegles;
	private JPanel jeuInfos;
	private JTextPane Bienvenue;
	JLabel perso = new JLabel("");
	JButton jouer = new JButton("Démarrer la partie");
	JButton regles = new JButton("Règles");
	JButton infos = new JButton("Infos");
	JButton quitter = new JButton("Quitter");
	
	
	//Creation du menu une fois en jeu
	JMenu menuMenu = new JMenu("Menu");
	JMenuItem menuMenuPrincipal = new JMenuItem("Menu Principal");
	JMenuItem menuJouer = new JMenuItem("Demarrer la partie");
	JMenuItem menuRegles = new JMenuItem("Règles");
	JMenuItem menuInfos = new JMenuItem("Infos");
	JMenuItem menuQuitter = new JMenuItem("Quitter");
	private JTextField txtRgles;
	
	/**
	 * Create the panel.
	 */
	public JeuVueGUI(Jeu model, JeuController jControl) {
			
			super(model, jControl);
			
			//Construction de la fenetre
			jeuJFrame = new JFrame("Danish");
			jeuJFrame.setSize(800, 800);
			jeuJFrame.setPreferredSize(new Dimension(800,800));
			
			jeuJFrame.setLocationRelativeTo(null);
			jeuJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			jeuJFrame.getContentPane().setLayout(null);
			
			
			jeuMenu = new JPanel();
			jeuPartie = new JPanel();
			jeuRegles = new JPanel();
			jeuInfos = new JPanel();
			
			menuDemarrer();
			
			jeuJFrame.setVisible(true);
			jouer.addActionListener(this);
			regles.addActionListener(this);
			infos.addActionListener(this);
			

	}
	
	/**
	 * Affichage des bouttons et du texte de bienvenue sur le jeu.
	 */
	public void menuDemarrer() {
		jeuMenu.setSize(800, 800);
		jouer.setBounds(300, 300, 200, 30);
		regles.setBounds(300, 325, 200, 30);
		infos.setBounds(300, 350, 200, 30);
		quitter.setBounds(300, 375, 200, 30);
		jeuMenu.setLayout(null);
		
		jeuMenu.add(jouer);
		jeuMenu.add(regles);
		jeuMenu.add(infos);
		jeuMenu.add(quitter);
	    
		
		Bienvenue = new JTextPane();
		Bienvenue.setText("Bienvenue dans l'application Danish.\nPour jouer, cliquez sur \"Démarrer la partie\".\nPour connaitre les règles, cliquez \"Règles\".\nPour connaitre votre adresse IP et port de connexion, \n\tcliquez sur \"Information multioueurs\"");
		Bienvenue.setEditable(false);
		Bienvenue.setBounds(200, 150, 400, 100);
		jeuMenu.add(Bienvenue);
		
		jeuPartie.setVisible(false);
		jeuRegles.setVisible(false);
		jeuInfos.setVisible(false);
		jeuMenu.setVisible(true);
		jeuJFrame.getContentPane().add(jeuMenu);
	}

	
	
	/**
	 * Gestion du clic de lancement de partie.
	 */
	public void onClickJouer() {
		jeuPartie.setLayout(null);
		
		jeuPartie.setSize(800, 800);
		jeuMenu.setVisible(false);
		
		
		menuMenu.setBounds(0, 0, 124, 19);
		jeuPartie.add(menuMenu);
		menuMenu.add(menuMenuPrincipal);
		menuMenu.add(menuRegles);
		menuMenu.add(menuInfos);
		menuMenu.add(menuQuitter);
		
		jeuJFrame.getContentPane().add(jeuPartie);
		
	}
	/**
	 * Gestion du clic d'affichage des règles.
	 */
	public void onClickRegles() {
		jeuRegles.setSize(800, 800);
		jeuRegles.setLayout(null);
		
		jeuMenu.setVisible(false);
		jeuRegles.setVisible(true);
		
		menuMenu.setBounds(0, 0, 124, 19);
		jeuRegles.add(menuMenu);
		menuMenu.add(menuMenuPrincipal);
		menuMenu.add(menuJouer);
		menuMenu.add(menuInfos);
		menuMenu.add(menuQuitter);
		
		jeuJFrame.getContentPane().add(jeuRegles);
		
		JTextPane txtpnLePeut = new JTextPane();
		txtpnLePeut.setEditable(false);
		txtpnLePeut.setText("Les règles du jeu sont simple :\n\nLe 2, peut être joué sur n'importe quelle valeur, remet à 0 la valeur sur laquelle jouer.\n\nLe 3, peut être joué sur n'importe quelle valeur, agit comme un miroir. Cette carte copie la dernière carte jouée sur la table. Si table de jeu est vide, valeur de la carte = 3\n\nLe 7, la prochaine carte jouée doit obligatoirement être inférieure ou égale à 7.\n\nLe 8, le joueur suivant passe son tour. Il n'est pas possible de mettre un deuxième 8 par dessus\n\nLe 10, peut être jouée sur n'importe quelle valeur, coupe le jeu. Le tas coupé est éliminer de la table de jeu e ne peux plus être récupéré par un joueur.\n\nL'AS, Valeur maximale. Le joueur jouant un AS choisit un autre joueur qu'il \"attaque\", Si le joueur attaqué ne sait pas répondre par un 2, un 10, un 3, ou un AS, il récupère le tas de cartes jouées. L'AS joué est directement ajoutée à la pile coupée.");
		txtpnLePeut.setBounds(150, 150, 500, 500);
		jeuRegles.add(txtpnLePeut);
		
		txtRgles = new JTextField();
		txtRgles.setAutoscrolls(false);
		txtRgles.setFont(new Font("Lucida Grande", Font.BOLD, 26));
		txtRgles.setBackground(SystemColor.window);
		txtRgles.setEditable(false);
		txtRgles.setText("  RÈGLES");
		txtRgles.setBounds(325, 100, 150, 42);
		jeuRegles.add(txtRgles);
		txtRgles.setColumns(10);
		
	}
	/**
	 * Gestion du clic d'affichage des infos.
	 */
	public void onClickInfos() {
		jeuInfos.setSize(800, 800);
		jeuInfos.setLayout(null);
		
		jeuMenu.setVisible(false);
		jeuInfos.setVisible(true);
		
		menuMenu.setBounds(0, 0, 124, 19);
		jeuRegles.add(menuMenu);
		menuMenu.add(menuMenuPrincipal);
		menuMenu.add(menuJouer);
		menuMenu.add(menuRegles);
		menuMenu.add(menuQuitter);
		
		jeuJFrame.getContentPane().add(jeuInfos);
		
	}
	/**
	 * Gestion du clic pour quitter avec un pop up de confirmation.
	 */
	public void onClickQuitter() {
		JDialog.setDefaultLookAndFeelDecorated(false);
	    int response = JOptionPane.showConfirmDialog(null, "Voulez vous vraiment quitter ?", "Quit",
	        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
	    if (response == JOptionPane.NO_OPTION) {
	      System.out.println("Conituer jeu");
	    } else if (response == JOptionPane.YES_OPTION) {
	      System.out.println("Quitter jeu");
	      System.exit(0);
	    } else if (response == JOptionPane.CLOSED_OPTION) {
	      System.out.println("Quitter jeu");
	    }
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		 Object  source = e.getSource();
		 if (source == menuMenuPrincipal){
	    	 menuDemarrer();
	     }
		 else if (source == jouer && source == menuJouer){
	    	 onClickJouer();
	     }
	     else if (source == regles && source == menuRegles) {
	    	 onClickRegles();
	     }    
	     else if (source == infos && source == menuInfos) {
	    	 onClickInfos();
	     }
	     else if (source == quitter && source == menuQuitter) {
	    	 onClickQuitter();
	     }
     }

	@Override
	public void affiche(String string) {
		System.out.println(string);
		perso.setText(string);
		
	}

	@Override
	public void update(Observable o, Object arg) {
		jeuJFrame.pack();
		
	}
}
