package project.front.authAndIns;

import javax.swing.JFrame;

import project.back.untils.Utilitaire;
import project.exceptions.DAOException;

import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Component;
import javax.swing.JButton;
import java.awt.Window.Type;
import java.awt.event.ActionListener;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;
import javax.swing.DefaultComboBoxModel;
import project.back.Qualification;

public class Inscription_Docteur extends JFrame {
	private static Inscription_Docteur instance;
	private JPanel panelTitre;
	private JPanel panelBas;
	private JTextField nomTf;
	private JLabel label1;
	private JLabel label2;
	private JLabel label3;
	private JLabel label4;
	private JLabel label5;
	private JLabel label6;
	private JLabel label7;
	private JLabel label8;
	private JLabel label9;
	private JLabel label10;
	private JLabel labeltitre;
	private JTextField prenomTf;
	private JTextField telephoneTf;
	private JTextField emailTf;
	private JTextField adresseTf;
	private JTextField dateNaissanceTf;
	private JTextField loginTF;
	private JButton creerCompteButton;
	private JButton  backbtn;
	private JComboBox qualification;
	private String qualificationTF;
	public JComboBox getQualification() {
		return qualification;
	}

	public void setQualification(JComboBox qualification) {
		this.qualification = qualification;
	}
	private JPasswordField passwordField1;
	private JPasswordField passwordField2;
	
	private Inscription_Docteur() {
		
		createInstanceComponents();
		initComponents();
		
	}
	
	private void createInstanceComponents() {
		 panelTitre = new JPanel();
		 panelBas = new JPanel();
		 label1 = new JLabel("Nom:");
		 label1.setFont(new Font("Dialog", Font.PLAIN, 14));
		 label2 = new JLabel("Prenom:");
		 label2.setFont(new Font("Dialog", Font.PLAIN, 14));
		 label3 = new JLabel("TEL:");
		 label3.setFont(new Font("Dialog", Font.PLAIN, 14));
		 label4 = new JLabel("E-mail:");
		 label4.setFont(new Font("Dialog", Font.PLAIN, 14));
		 label5 = new JLabel("Adresse:");
		 label5.setFont(new Font("Dialog", Font.PLAIN, 14));
		 label6 = new JLabel("Date de Naissance:");
		 label6.setFont(new Font("Dialog", Font.PLAIN, 14));
		 label7 = new JLabel("Login:");
		 label7.setFont(new Font("Dialog", Font.PLAIN, 14));
		 label8 = new JLabel("Qualification:");
		 label8.setFont(new Font("Dialog", Font.PLAIN, 14));
		 label9 = new JLabel("Mot de passe:");
		 label9.setFont(new Font("Dialog", Font.PLAIN, 14));
		 label10 = new JLabel("Confirmer Mdp:");
		 label10.setFont(new Font("Dialog", Font.PLAIN, 14));
		 labeltitre = new JLabel("Inscription-Docteur");
		 labeltitre.setFont(new Font("Dialog", Font.BOLD, 30));
		 labeltitre.setForeground(new Color(255, 255, 255));
		 nomTf = new JTextField();
		 prenomTf = new JTextField();
		 telephoneTf = new JTextField();
		 emailTf = new JTextField();
		 adresseTf = new JTextField();
		 dateNaissanceTf = new JTextField();
		 loginTF = new JTextField();
		 creerCompteButton = new JButton("creer compte");
		 creerCompteButton.setFont(new Font("Dialog", Font.BOLD, 17));
		 creerCompteButton.setForeground(new Color(0, 0, 0));
		 backbtn = new JButton("Annuler");
		 backbtn.setFont(new Font("Dialog", Font.BOLD, 17));
	}
	
	private void initComponents() {
		getContentPane().setLayout(null);
		setTitle("e-Sante");
		
		panelTitre.setBackground(new Color(32, 178, 170));
		panelTitre.setBounds(10, 11, 485, 63);
		getContentPane().add(panelTitre);
		panelTitre.setLayout(null);
		
		
		labeltitre.setBounds(101, 11, 312, 41);
		panelTitre.add(labeltitre);
		
		
		panelBas.setBackground(new Color(32, 178, 170));
		panelBas.setBounds(10, 422, 485, 48);
		getContentPane().add(panelBas);
		panelBas.setLayout(null);
		
		
		creerCompteButton.setBounds(33, 11, 148, 23);
		panelBas.add(creerCompteButton);
		
		
		backbtn.setBounds(248, 11, 139, 23);
		panelBas.add(backbtn);
		
		
		nomTf.setBounds(217, 82, 132, 20);
		getContentPane().add(nomTf);
		nomTf.setColumns(10);
		
		
		label1.setBounds(77, 85, 102, 14);
		getContentPane().add(label1);
		
		
		label2.setAlignmentY(Component.TOP_ALIGNMENT);
		label2.setBounds(77, 116, 102, 14);
		getContentPane().add(label2);
		
		
		
		label3.setBounds(77, 177, 102, 14);
		getContentPane().add(label3);
		
		
		label4.setBounds(77, 202, 102, 14);
		getContentPane().add(label4);
		
		
		label5.setBounds(77, 237, 102, 14);
		getContentPane().add(label5);
		
		
		label6.setBounds(77, 275, 141, 14);
		getContentPane().add(label6);
		
		
		label7.setBounds(77, 313, 102, 14);
		getContentPane().add(label7);
		
		
		label8.setBounds(77, 147, 130, 14);
		getContentPane().add(label8);
		
		
		label9.setBounds(77, 351, 116, 18);
		getContentPane().add(label9);
		
		
		label10.setBounds(77, 397, 116, 14);
		getContentPane().add(label10);
		setSize(new Dimension(522, 520));
		
		
		prenomTf.setBounds(217, 113, 132, 20);
		getContentPane().add(prenomTf);
		prenomTf.setColumns(10);
		
		
		telephoneTf.setBounds(217, 175, 132, 20);
		getContentPane().add(telephoneTf);
		telephoneTf.setColumns(10);
		
		
		emailTf.setBounds(217, 202, 132, 20);
		getContentPane().add(emailTf);
		emailTf.setColumns(10);
		
		
		adresseTf.setBounds(217, 234, 132, 20);
		getContentPane().add(adresseTf);
		adresseTf.setColumns(10);
		
		
		dateNaissanceTf.setBounds(217, 272, 132, 20);
		getContentPane().add(dateNaissanceTf);
		dateNaissanceTf.setColumns(10);
		
		
		loginTF.setBounds(217, 310, 132, 20);
		getContentPane().add(loginTF);
		loginTF.setColumns(10);
		
		qualification = new JComboBox();
		qualification.setModel(new DefaultComboBoxModel(Qualification.values()));
		qualification.setBounds(217, 144, 132, 22);
		getContentPane().add(qualification);
		
		passwordField1 = new JPasswordField();
		passwordField1.setBounds(217, 349, 132, 20);
		getContentPane().add(passwordField1);
		
		passwordField2 = new JPasswordField();
		passwordField2.setBounds(217, 391, 132, 20);
		getContentPane().add(passwordField2);
		Utilitaire.center(this, this.getSize());
		
		
		
	}
	public void run() {
		this.setVisible(true);
	}
	public static Inscription_Docteur getInstance() {
		instance = new Inscription_Docteur();
		return instance;
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



	public String getEmailTf() throws DAOException {
		if(emailTf.getText().equals("")) {
			throw new DAOException("Champs email  vide");
		}
		return emailTf.getText();
	}

	public void setEmailTf(String emailTf) {
		this.emailTf.setText(emailTf);
	}
	public void addcreerCompteButton(ActionListener actionListener) {
		creerCompteButton.addActionListener(actionListener);
	}
	public void addbackButton(ActionListener actionListener) {
		backbtn.addActionListener(actionListener);
	}
	
	public void addSelectQualification(ActionListener actionListener) {
		qualification.addActionListener(actionListener);
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

	public String getQualificationTF() {
		return qualificationTF;
	}

	public void setQualificationTF(String qualificationTF) {
		this.qualificationTF = qualificationTF;
	}
}
