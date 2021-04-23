package project.front.authAndIns;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import java.awt.Dimension;

import project.back.untils.Utilitaire;
import project.exceptions.DAOException;

import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import java.awt.event.ActionEvent;


public class Fenetre_Authentification extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private static Fenetre_Authentification instance;
	private JTextField loginTf;
	private JPanel paneltitre;
	private JLabel lblNewLabel;
	private JPanel paneldestextes;
	private JLabel q1;
	private JLabel q4;
	private JLabel lblNewLabel_1;
	private JButton btnConnexion;
	private JPanel panel_1;
	private JPanel panel;
	private JButton creerCompteButton;
	public JButton getCreerCompteButton() {
		return creerCompteButton;
	}





	public void setCreerCompteButton(JButton creerCompteButton) {
		this.creerCompteButton = creerCompteButton;
	}

	private JButton backBtn;
	private JPasswordField passwordTF;
	
	public static Fenetre_Authentification getInstance() {
		instance = new Fenetre_Authentification();
		return instance;
	}


	


	private Fenetre_Authentification() {
		
		createInstanceComponents ();		
		initComponents();
	}
	
	
	public void createInstanceComponents () {
		paneltitre = new JPanel();
		lblNewLabel = new JLabel("Connectez-vous");
		paneldestextes = new JPanel();
		q1 = new JLabel("Login ou e-mail: ");
		q4 = new JLabel("Password: ");
		loginTf = new JTextField();
		lblNewLabel_1 = new JLabel("S'authentifier");
		btnConnexion = new JButton("Connexion");
		panel_1 = new JPanel();
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("/Users/cheikh/eclipse-workspace/E-sante/image/icone/connexion.png"));
		lblNewLabel_2.setBounds(77, 67, 167, 136);
		panel_1.add(lblNewLabel_2);
		panel = new JPanel();
		creerCompteButton = new JButton("Cr\u00E9er mon compte");
		backBtn = new JButton("Retour");
		backBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
	}
	public void initComponents() {
		setTitle("E-sante");
		setSize(new Dimension(649, 500));
		getContentPane().setLayout(null);
		
		
		paneltitre.setBackground(new Color(32, 178, 170));
		paneltitre.setBounds(10, 11, 615, 56);
		getContentPane().add(paneltitre);
		paneltitre.setLayout(null);
		
		
		lblNewLabel.setSize(new Dimension(150, 14));
		lblNewLabel.setPreferredSize(new Dimension(150, 14));
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 30));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(175, 11, 320, 34);
		paneltitre.add(lblNewLabel);
		
		
		paneldestextes.setBackground(new Color(255, 255, 255));
		paneldestextes.setBounds(20, 78, 286, 311);
		getContentPane().add(paneldestextes);
		paneldestextes.setLayout(null);
		
		
		q1.setFont(new Font("Dialog", Font.PLAIN, 15));
		q1.setBounds(10, 87, 130, 23);
		paneldestextes.add(q1);
		
		
		q4.setFont(new Font("Dialog", Font.PLAIN, 15));
		q4.setBounds(46, 132, 86, 23);
		paneldestextes.add(q4);
		
		
		loginTf.setBounds(146, 90, 130, 20);
		paneldestextes.add(loginTf);
		loginTf.setColumns(10);
		
		
		lblNewLabel_1.setFont(new Font("Dialog", Font.PLAIN, 25));
		lblNewLabel_1.setBounds(46, 24, 218, 37);
		paneldestextes.add(lblNewLabel_1);
		
		
		btnConnexion.setBackground(new Color(224, 255, 255));
		btnConnexion.setFont(new Font("Dialog", Font.BOLD, 17));
		btnConnexion.setBounds(77, 239, 122, 37);
		paneldestextes.add(btnConnexion);
		
		passwordTF = new JPasswordField();
		passwordTF.setBounds(144, 131, 132, 26);
		paneldestextes.add(passwordTF);
		
		
		panel_1.setBackground(new Color(0, 128, 128));
		panel_1.setBounds(323, 79, 302, 311);
		getContentPane().add(panel_1);
		
		
		panel.setBackground(new Color(32, 178, 170));
		panel.setBounds(30, 401, 615, 43);
		getContentPane().add(panel);
		
		
		creerCompteButton.setPreferredSize(new Dimension(200, 30));
		creerCompteButton.setFont(new Font("Dialog", Font.BOLD, 18));
		panel.add(creerCompteButton);
		
		
		backBtn.setPreferredSize(new Dimension(95, 30));
		backBtn.setFont(new Font("Dialog", Font.BOLD, 17));
		panel.add(backBtn);
		
		Utilitaire.center(this, this.getSize());
	}
	
	public void addcreerCompteButton(ActionListener actionListener) {
		creerCompteButton.addActionListener(actionListener);
	}
	public void addbackButton(ActionListener actionListener) {
		backBtn.addActionListener(actionListener);
	}
	public void clear() {
		
		loginTf.setText("");
		passwordTF.setText("");
		
		
	}
	public void addConnexion(ActionListener actionListener) {
		btnConnexion.addActionListener(actionListener);
	}
	public void errorMessage(String message) {
		Utilitaire.displayErrorMessage(message);
		
	}
	public void informationMessage(String message) {
		Utilitaire.displayNotification(message);
	}
	public boolean confirmationMessage (String message) {
		if(Utilitaire.ConfirmMessage(message)) {
			return true ;
		}
		return false;
		
	}
	public String getPasswordField1() throws DAOException {
		String password= String.valueOf(passwordTF.getPassword());
		if(password.equals("")) {

			throw new DAOException("Champs password vide  vide");
		}
		return password;
	}
	
	public String getLoginTF() throws DAOException {
		if(loginTf.getText().equals("")) {
			throw new DAOException("Champs login  vide");
		}
		return loginTf.getText();
	}
	
	public void run() {
		this.setVisible(true);
	}
}
