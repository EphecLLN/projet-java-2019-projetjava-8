package vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VueGUITest2 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VueGUITest2 frame = new VueGUITest2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VueGUITest2() {
		
		JPanel menu = new JPanel();
		JPanel partie = new JPanel();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		
		
		JButton btnDemarrerLaPartie = new JButton("Demarrer la partie");
		btnDemarrerLaPartie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				this.setContentPane(partie);
			}
		});
		btnDemarrerLaPartie.setBounds(138, 45, 164, 29);
		menu.add(btnDemarrerLaPartie);
		
		JButton button = new JButton("Règles");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button.setBounds(138, 119, 164, 29);
		menu.add(button);
		
		JButton button_1 = new JButton("Informations");
		button_1.setBounds(138, 193, 164, 29);
		menu.add(button_1);
		
	}
}
