package project.front.authAndIns;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.border.BevelBorder;
import java.awt.GridLayout;
import javax.swing.border.MatteBorder;

import project.back.untils.Utilitaire;
import project.exceptions.DAOException;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.Dimension;
import javax.swing.JPasswordField;
import javax.swing.UIManager;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import java.awt.FlowLayout;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import project.back.Localite;
import project.back.Qualification;

public class FInscription_structureSante extends JFrame {
	private static final long serialVersionUID = 1L;
	private static FInscription_structureSante instance;
	private JTextField nomTf;
	private JTextField adresseTf;
	private JTextField loginTf;
	private JTextField telephoneTf;
	private JTextField emailTf;
	private JPasswordField mdpTf2;
	private JPanel paneltitre;
	private JLabel lblNewLabel;
	private JPanel paneldestextes;
	private JLabel q1;
	private JLabel q3;
	private JLabel q4;
	private JLabel q5;
	private JLabel q6;
	private JLabel q7;
	private JLabel q8;
	private JPanel panel;
	private JButton creerCompteButton;
	private JButton backbtn;
	private JComboBox localite;
	private JPasswordField mdpTf1;
	private String localiteTF;
	

	public String getLocaliteTF() {
		return localiteTF;
	}

	public void setLocaliteTF(String localiteTF) {
		this.localiteTF = localiteTF;
	}

	public JComboBox getLocalite() {
		return localite;
	}

	private  FInscription_structureSante() {
		createInstanceComponents();
		initComponents();
	}
	
	public void createInstanceComponents() {
		paneltitre = new JPanel();
		lblNewLabel = new JLabel("Inscription Structure de Sante");
		paneldestextes = new JPanel();
		q1 = new JLabel("Nom: ");
		q3 = new JLabel("Localit\u00E9: ");
		q4 = new JLabel("Adresse: ");
		q5 = new JLabel("T\u00E9l\u00E9phone: ");
		q6 = new JLabel("E-mail: ");
		q7 = new JLabel("Mot de passe: ");
		q8 = new JLabel("confirmer votre mdp: ");
		nomTf = new JTextField();
		adresseTf = new JTextField();
		loginTf = new JTextField();
		telephoneTf = new JTextField();
		emailTf = new JTextField();
		mdpTf2 = new JPasswordField();
		panel = new JPanel();
		creerCompteButton = new JButton("Cr\u00E9er mon compte");
		backbtn = new JButton("Annuler");
		localite = new JComboBox();
	}
	public void initComponents() {
		setTitle("E-sante");
		setSize(new Dimension(534, 500));
		getContentPane().setLayout(null);
		
		
		paneltitre.setBackground(new Color(32, 178, 170));
		paneltitre.setBounds(27, 10, 485, 56);
		getContentPane().add(paneltitre);
		paneltitre.setLayout(null);
		
		
		lblNewLabel.setSize(new Dimension(150, 14));
		lblNewLabel.setPreferredSize(new Dimension(150, 14));
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 27));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(24, 6, 436, 34);
		paneltitre.add(lblNewLabel);
		
		
		paneldestextes.setBackground(new Color(255, 255, 255));
		paneldestextes.setBounds(27, 78, 485, 372);
		getContentPane().add(paneldestextes);
		paneldestextes.setLayout(null);
		
		
		q1.setFont(new Font("Dialog", Font.PLAIN, 14));
		q1.setBounds(42, 11, 114, 23);
		paneldestextes.add(q1);
		
		
		q3.setFont(new Font("Dialog", Font.PLAIN, 14));
		q3.setBounds(42, 89, 114, 23);
		paneldestextes.add(q3);
		
		
		q4.setFont(new Font("Dialog", Font.PLAIN, 14));
		q4.setBounds(42, 55, 114, 23);
		paneldestextes.add(q4);
		
		
		q5.setFont(new Font("Dialog", Font.PLAIN, 14));
		q5.setBounds(42, 123, 114, 43);
		paneldestextes.add(q5);
		
		
		q6.setFont(new Font("Dialog", Font.PLAIN, 14));
		q6.setBounds(42, 168, 114, 35);
		paneldestextes.add(q6);
		
		
		q7.setFont(new Font("Dialog", Font.PLAIN, 14));
		q7.setBounds(42, 245, 107, 35);
		paneldestextes.add(q7);
		
		
		q8.setFont(new Font("Dialog", Font.PLAIN, 14));
		q8.setBounds(42, 283, 149, 23);
		paneldestextes.add(q8);
		
		
		nomTf.setBounds(201, 14, 125, 20);
		paneldestextes.add(nomTf);
		nomTf.setColumns(10);
		
		
		adresseTf.setBounds(201, 54, 125, 20);
		paneldestextes.add(adresseTf);
		adresseTf.setColumns(10);
		
		
		loginTf.setBounds(201, 216, 125, 20);
		paneldestextes.add(loginTf);
		loginTf.setColumns(10);
		
		
		telephoneTf.setBounds(201, 136, 125, 20);
		paneldestextes.add(telephoneTf);
		telephoneTf.setColumns(10);
		
		
		emailTf.setBounds(201, 177, 125, 20);
		paneldestextes.add(emailTf);
		emailTf.setColumns(10);
		
		
		mdpTf2.setBounds(194, 285, 132, 20);
		paneldestextes.add(mdpTf2);
		
		
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setHgap(50);
		panel.setBackground(new Color(32, 178, 170));
		
		panel.setBounds(0, 323, 485, 43);
		paneldestextes.add(panel);
		
		
		creerCompteButton.setFont(new Font("Dialog", Font.BOLD, 15));
		creerCompteButton.setPreferredSize(new Dimension(200, 30));
		panel.add(creerCompteButton);
		
		
		backbtn.setPreferredSize(new Dimension(100, 30));
		backbtn.setFont(new Font("Dialog", Font.BOLD, 17));
		panel.add(backbtn);
		
		JLabel loginTF = new JLabel("Login:");
		loginTF.setFont(new Font("Dialog", Font.PLAIN, 14));
		loginTF.setBounds(42, 217, 100, 16);
		paneldestextes.add(loginTF);
		
		 
		localite.setModel(new DefaultComboBoxModel(Localite.values()));
		localite.setBounds(201, 89, 125, 27);
		paneldestextes.add(localite);
		
		mdpTf1 = new JPasswordField();
		mdpTf1.setBounds(201, 250, 125, 26);
		paneldestextes.add(mdpTf1);
		Utilitaire.center(this, this.getSize());
		// Utilitaire.setLookAndFeel(this);
	}
	
	public String getNomTf() throws DAOException {
		if(nomTf.getText().equals("")) {
			throw new DAOException("Champs nom vide");
		}
		return nomTf.getText();
	}

	public void setNomTf(String nomTf) {
		this.nomTf.setText(nomTf);
	}
	public String getAdresseTf() throws DAOException {
		if(adresseTf.getText().equals("")) {
			throw new DAOException("Champs adresse  vide");
		}

		return adresseTf.getText();
	}

	public void setAdresseTf(String adresseTf) {
		this.adresseTf.setText(adresseTf);
	}

	public int getTelephoneTf() throws DAOException {
		if(telephoneTf.getText().equals("")) {
			throw new DAOException("Champs telephone vide  vide");
		}
		int tel = Integer.valueOf(telephoneTf.getText());
		return tel;
		


	}



	public String getEmailTf() throws DAOException {
		if(emailTf.getText().equals("")) {
			throw new DAOException("Champs email  vide");
		}
		return emailTf.getText();
	}

	public void setEmailTf(String emailTf) {
		this.emailTf.setText(emailTf);
	}
	
	public String getLoginTF() throws DAOException {
		if(loginTf.getText().equals("")) {
			throw new DAOException("Champs login  vide");
		}
		return loginTf.getText();
	}

	public String getmdpTf1() throws DAOException {
		String password= String.valueOf(mdpTf1.getPassword());
		if(password.equals("")) {

			throw new DAOException("Champs password vide  vide");
		}
		if(password.equals(getmdpTf2()))
		{
			return password;
		}
		else {
			throw new DAOException("Confirme password et password sont différents");
		}
	}



	public String getmdpTf2() throws DAOException {
		String password= String.valueOf(mdpTf2.getPassword());
		if(password.equals("")) {

			throw new DAOException("Champs password vide  vide");
		}
		return password;
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
	
	

	public void run() {
		this.setVisible(true);
	}
	public void clear() {
		nomTf.setText("");
		adresseTf.setText("");
		telephoneTf.setText("");
		emailTf.setText("");
		mdpTf1.setText("");
		mdpTf2.setText("");
		loginTf.setText("");
	}
	public void addcreerCompteButton(ActionListener actionListener) {
		creerCompteButton.addActionListener(actionListener);
	}
	public void addbackButton(ActionListener actionListener) {
		backbtn.addActionListener(actionListener);
	}
	
	public void addSelectLocalite(ActionListener actionListener) {
		localite.addActionListener(actionListener);
	}

	public  static FInscription_structureSante getInstance() {
		instance = new FInscription_structureSante();
		return instance;
	}
	
}
