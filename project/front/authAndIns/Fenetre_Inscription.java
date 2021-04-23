package project.front.authAndIns;

import javax.swing.JFrame;
import java.awt.Dimension;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.border.BevelBorder;
import java.awt.GridLayout;
import javax.swing.border.MatteBorder;

import project.back.Localite;
import project.back.untils.Utilitaire;
import project.exceptions.DAOException;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPasswordField;
import javax.swing.UIManager;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import javax.swing.JCheckBox;
import java.awt.FlowLayout;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultComboBoxModel;

public class Fenetre_Inscription extends JFrame {
	private static final long serialVersionUID = 1L;
	private static Fenetre_Inscription instance;
	private JTextField nomTf;
	private JTextField prenomTf;
	private JTextField dateNaissanceTf;
	private JTextField adresseTf;
	private JTextField telephoneTf;
	private JTextField emailTf;
	private JPasswordField passwordField1;
	private JPasswordField passwordField2;
	private JPanel paneltitre;
	private JLabel lblNewLabel;
	private JPanel paneldestextes;
	private JLabel q1;
	private JLabel q2;
	private JLabel q3;
	private JLabel q4;
	private JLabel q5;
	private JLabel q6;
	private JLabel q7;
	private JLabel q8;
	private JPanel panel;
	private JButton creerCompteButton;
	private JButton backbtn;
	private JTextField loginTF;
	private JComboBox localite;
	
	private String localiteTF;

	
	private Fenetre_Inscription() {
		createInstanceComponents();
		initComponents();
	}
	public static Fenetre_Inscription getInstance() {
		instance = new Fenetre_Inscription();
		return instance;
	}

	public void createInstanceComponents() {

		paneltitre = new JPanel();
		lblNewLabel = new JLabel("Inscription Patient");
		paneldestextes = new JPanel();
		q1 = new JLabel("Nom: ");
		q2 = new JLabel("Pr\u00E9nom: ");
		q3 = new JLabel("Date de naissance: ");
		q4 = new JLabel("Adresse: ");
		q5 = new JLabel("T\u00E9l\u00E9phone: ");
		q6 = new JLabel("E-mail: ");
		q7 = new JLabel("Mot de passe: ");
		q8 = new JLabel("confirmer votre mdp: ");
		nomTf = new JTextField();
		prenomTf = new JTextField();
		dateNaissanceTf = new JTextField();
		adresseTf = new JTextField();
		telephoneTf = new JTextField();
		emailTf = new JTextField();
		passwordField1 = new JPasswordField();
		passwordField2 = new JPasswordField();
		panel = new JPanel();
		creerCompteButton = new JButton("Cr\u00E9er mon compte");
		backbtn = new JButton("Annuler");
		localite = new JComboBox();
		
	}
	public void initComponents() {
		setTitle("E-sante");
		setSize(new Dimension(521, 520));
		getContentPane().setLayout(null);


		paneltitre.setBackground(new Color(32, 178, 170));
		paneltitre.setBounds(10, 11, 485, 56);
		getContentPane().add(paneltitre);
		paneltitre.setLayout(null);


		lblNewLabel.setSize(new Dimension(150, 14));
		lblNewLabel.setPreferredSize(new Dimension(150, 14));
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 30));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(79, 11, 320, 34);
		paneltitre.add(lblNewLabel);


		paneldestextes.setBackground(new Color(255, 255, 255));
		paneldestextes.setBounds(10, 79, 485, 417);
		getContentPane().add(paneldestextes);
		paneldestextes.setLayout(null);


		q1.setFont(new Font("Dialog", Font.PLAIN, 14));
		q1.setBounds(40, 28, 107, 23);
		paneldestextes.add(q1);


		q2.setFont(new Font("Dialog", Font.PLAIN, 14));
		q2.setBounds(40, 60, 102, 35);
		paneldestextes.add(q2);


		q3.setFont(new Font("Dialog", Font.PLAIN, 14));
		q3.setBounds(40, 95, 142, 23);
		paneldestextes.add(q3);


		q4.setFont(new Font("Dialog", Font.PLAIN, 14));
		q4.setBounds(40, 130, 102, 23);
		paneldestextes.add(q4);


		q5.setFont(new Font("Dialog", Font.PLAIN, 14));
		q5.setBounds(40, 153, 102, 43);
		paneldestextes.add(q5);


		q6.setFont(new Font("Dialog", Font.PLAIN, 14));
		q6.setBounds(40, 189, 102, 35);
		paneldestextes.add(q6);


		q7.setFont(new Font("Dialog", Font.PLAIN, 14));
		q7.setBounds(40, 293, 107, 35);
		paneldestextes.add(q7);


		q8.setFont(new Font("Dialog", Font.PLAIN, 14));
		q8.setBounds(39, 331, 163, 23);
		paneldestextes.add(q8);


		nomTf.setBounds(194, 30, 113, 20);
		paneldestextes.add(nomTf);
		nomTf.setColumns(10);


		prenomTf.setBounds(194, 68, 113, 20);
		paneldestextes.add(prenomTf);
		prenomTf.setColumns(10);


		dateNaissanceTf.setBounds(194, 100, 113, 20);
		paneldestextes.add(dateNaissanceTf);
		dateNaissanceTf.setColumns(10);


		adresseTf.setBounds(194, 132, 113, 20);
		paneldestextes.add(adresseTf);
		adresseTf.setColumns(10);


		telephoneTf.setBounds(194, 165, 113, 20);
		paneldestextes.add(telephoneTf);
		telephoneTf.setColumns(10);


		emailTf.setBounds(194, 197, 113, 20);
		paneldestextes.add(emailTf);
		emailTf.setColumns(10);


		passwordField1.setBounds(194, 301, 113, 20);
		paneldestextes.add(passwordField1);


		passwordField2.setBounds(194, 333, 113, 20);
		paneldestextes.add(passwordField2);

		localite.setModel(new DefaultComboBoxModel(Localite.values()));
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setHgap(50);
		panel.setBackground(new Color(32, 178, 170));

		panel.setBounds(6, 357, 475, 43);
		paneldestextes.add(panel);


		creerCompteButton.setFont(new Font("Dialog", Font.BOLD, 16));
		creerCompteButton.setPreferredSize(new Dimension(200, 30));
		panel.add(creerCompteButton);


		backbtn.setFont(new Font("Dialog", Font.BOLD, 17));
		backbtn.setPreferredSize(new Dimension(100, 30));
		panel.add(backbtn);
		
		loginTF = new JTextField();
		loginTF.setBounds(194, 268, 113, 26);
		paneldestextes.add(loginTF);
		loginTF.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Login:");
		lblNewLabel_1.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(40, 273, 88, 16);
		paneldestextes.add(lblNewLabel_1);
		
		
		
		localite.setBorder(UIManager.getBorder("Button.border"));
		localite.setBounds(194, 229, 113, 27);
		paneldestextes.add(localite);
		
		JLabel localite = new JLabel("Localité");
		localite.setFont(new Font("Dialog", Font.PLAIN, 14));
		localite.setBounds(40, 233, 92, 16);
		paneldestextes.add(localite);
		Utilitaire.center(this, this.getSize());
	}


	public void run() {
		this.setVisible(true);
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

	public String getPrenomTf() throws DAOException {
		if(prenomTf.getText().equals("")) {
			throw new DAOException("Champs nom vide");
		}
		return prenomTf.getText();
	}

	public void setPrenomTf(String prenomTf) {
		this.prenomTf.setText(prenomTf);
	}

	public String getDateNaissanceTf() throws DAOException {
		if(dateNaissanceTf.getText().equals("")) {
			throw new DAOException("Champs date de naissance  vide");
		}
		return dateNaissanceTf.getText();

	}

	public void setDateNaissanceTf(String dateNaissanceTf) {
		this.dateNaissanceTf.setText(dateNaissanceTf);
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
	public JComboBox getLocalite(){
		return localite;
		
	}
	public String getLoginTF() throws DAOException {
		if(loginTF.getText().equals("")) {
			throw new DAOException("Champs login  vide");
		}
		return loginTF.getText();
	}

	public String getPasswordField1() throws DAOException {
		String password= String.valueOf(passwordField1.getPassword());
		if(password.equals("")) {

			throw new DAOException("Champs password vide  vide");
		}
		if(password.equals(getPasswordField2()))
		{
			return password;
		}
		else {
			throw new DAOException("Confirme password et password sont différents");
		}
	}



	public String getPasswordField2() throws DAOException {
		String password= String.valueOf(passwordField2.getPassword());
		if(password.equals("")) {

			throw new DAOException("Champs password vide  vide");
		}
		return password;
	}

	public void clear() {
		nomTf.setText("");
		prenomTf.setText("");
		dateNaissanceTf.setText("");
		adresseTf.setText("");
		telephoneTf.setText("");
		emailTf.setText("");
		passwordField1.setText("");
		passwordField2.setText("");
		loginTF.setText("");
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
	public String getLocaliteTF() {
		return localiteTF;
	}
	public void setLocaliteTF(String localite) {
		this.localiteTF = localite;
	}
	
}
