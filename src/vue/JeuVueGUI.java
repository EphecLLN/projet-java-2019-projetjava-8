/**
 * 
 */
package vue;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;
import javax.swing.border.Border;

import controller.JeuController;
import projet.Jeu;

/**
 * @author Humbert MEYERS
 *
 */
@SuppressWarnings("deprecation")
public class JeuVueGUI extends JeuVue implements ActionListener, Observer {

	private JFrame jeuJFrame;

	public JeuVueGUI(Jeu model, JeuController jeuController) {
		super(model, jeuController);
		
		
		//initialisation de la fenetre
		jeuJFrame = new JFrame(" ");
		jeuJFrame.setSize(1600, 800);
		jeuJFrame.setPreferredSize(new Dimension(1600,800));
		
		
		//jeuJFrame.setResizable(false);
		jeuJFrame.setLocationRelativeTo(null);
		jeuJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	
}
