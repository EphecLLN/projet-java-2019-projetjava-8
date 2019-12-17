package vue;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;
import controller.*;
import projet.*;
import java.awt.event.ActionEvent;

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
			
			onClickJouer();
			
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
