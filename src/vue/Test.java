package vue;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JDesktopPane;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JWindow;
import javax.swing.AbstractAction;
import javax.swing.Action;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTree;
import javax.swing.JTextPane;

public class Test {

	private JFrame danishGUI, windowPartie;
	//private JWindow windowPartie;
	private JFrame frameRegles;
	private JFrame frameInfos;
	//private final Action action = new SwingAction();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Test window = new Test();
					window.danishGUI.setVisible(true);
					window.windowPartie.setVisible(false);
					window.frameRegles.setVisible(false);
					window.frameInfos.setVisible(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Test() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		danishGUI = new JFrame("Danish");
		danishGUI.setSize(960, 540);
		danishGUI.setResizable(false);
		danishGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		danishGUI.getContentPane().setLayout(null);
		
		//windowPartie = new JWindow();
		windowPartie.getContentPane().setLayout(null);
		
		JButton button = new JButton("Règles");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JButton btnDmarrerLaPartie = new JButton("Démarrer la partie");
		btnDmarrerLaPartie.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				danishGUI.setVisible(false);
				windowPartie = new JFrame();
				windowPartie.setSize(960, 540);
				windowPartie.setResizable(false);
				windowPartie.setVisible(true);
			}
		});
		btnDmarrerLaPartie.setBounds(265, 255, 201, 29);
		danishGUI.getContentPane().add(btnDmarrerLaPartie);
		button.setBounds(265, 296, 201, 29);
		danishGUI.getContentPane().add(button);
		
		JButton button_1 = new JButton("Informations multijoueurs");
		button_1.setBounds(265, 337, 201, 29);
		danishGUI.getContentPane().add(button_1);
		
		JTextPane txtpnBienvenueDansLapplication = new JTextPane();
		txtpnBienvenueDansLapplication.setEditable(false);
		txtpnBienvenueDansLapplication.setText("Bienvenue dans l'application Danish.\nPour jouer, cliquez sur \"Démarrer la partie\".\npour connaitre les règles, cliquez \"Règles\".\nPour connaitre votre adresse IP et port de connexion, \n\tcliquez sur \"Information multioueurs\".");
		txtpnBienvenueDansLapplication.setBounds(209, 89, 337, 95);
		danishGUI.getContentPane().add(txtpnBienvenueDansLapplication);
	}
}
