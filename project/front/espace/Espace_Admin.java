package project.front.espace;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;


import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import project.back.models.PatientModel;
import project.back.models.StructureSanteModel;
import project.back.untils.Utilitaire;
import project.exceptions.DAOException;
import java.awt.CardLayout;
import javax.swing.JTable;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import javax.swing.border.LineBorder;
import java.awt.SystemColor;
import javax.swing.border.TitledBorder;
import javax.swing.border.BevelBorder;
import java.awt.FlowLayout;
import javax.swing.border.EmptyBorder;
import javax.swing.border.SoftBevelBorder;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.ImageIcon;

public class Espace_Admin extends JFrame {
	private static final long serialVersionUID = 1L;
	private static Espace_Admin instance;
	private JPanel paneltitre;
	private JLabel lblNewLabel;
	private JPanel paneldestableaux;
	private JPanel panelDesButtons;
	private JTextField rechercherTf;
	private JTable tableStructure;
	private JPanel panel;
	private JButton btnRecherche;
	private JButton btnLister;
	private JButton btnAjouter;
	private JButton btnModifier;
	private JButton btnSupprimer;
	private JButton btnChanger;
	private int idSelectStructure;
	private int idSelectPatient;
	private boolean idObserver;
	private JPanel panelChange;
	private JPasswordField passwordField1;
	private JPasswordField passwordField2;
	private JPanel panelStructure;
	private Container panelPatient;
	private StructureSanteModel modeleStrucure;

	private PatientModel modelePatient;
	private JScrollPane scrollPane_1;
	private JScrollPane scrollPane;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JTable tablePatient;
	public JTable getTablePatient() {
		return tablePatient;
	}

	private JLabel titre;
	private JButton btnStructure;
	private JButton btnPatient;
	private JButton btnBack;
	private JPasswordField passwordField;
	private JButton btnChangermdp;
	private JPanel panelHome;
	private JButton btnValidationChange;
	private JPanel panelmodifier;
	private JPasswordField passwordFieldModif;
	private JTextField loginTf;
	private JTextField telTf;
	private JTextField adresseTf;
	private JTextField emailTf;
	private JButton btnModifierUser;
	public static Espace_Admin getInstance() {
		instance = new Espace_Admin();
		return instance;
	}

	private Espace_Admin() {


		createInstanceComponents ();		
		initComponents();
	}
	public StructureSanteModel getModeleStrucure() {
		return modeleStrucure;
	}
	public void createInstanceComponents () {
		modeleStrucure = new StructureSanteModel();
		modelePatient = new PatientModel();
		paneltitre = new JPanel();
		panelChange = new JPanel();
		tableStructure = new JTable();
		panelPatient = new JPanel();
		scrollPane_1 = new JScrollPane();
		panelStructure = new JPanel();
		scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBorder(new TitledBorder(null, "Patients", TitledBorder.LEADING, TitledBorder.TOP, null, null));

		tablePatient = new JTable();
		tablePatient.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		scrollPane.setViewportView(tablePatient);
		passwordField1 = new JPasswordField();
		lblNewLabel_1 = new JLabel("Ancien Mot de passe:");
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		passwordField2 = new JPasswordField();



		lblNewLabel_2 = new JLabel("Nouveau Mot de passe:");
		lblNewLabel_2.setBounds(6, 73, 165, 16);
		panelChange.add(lblNewLabel_2);
		btnModifierUser = new JButton("modifier");
		lblNewLabel_3 = new JLabel("Confime Mot de passe:");
		lblNewLabel_3.setBounds(6, 110, 173, 16);
		panelChange.add(lblNewLabel_3);
		panelDesButtons = new JPanel();
		panelDesButtons.setLayout(null);
		panelHome = new JPanel();

		btnStructure = new JButton("Structure Sante");
		btnStructure.setBackground(new Color(32, 178, 170));
		btnStructure.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnStructure.setBounds(220, 11, 109, 39);
		panelDesButtons.add(btnStructure);

		btnPatient = new JButton("Patients");
		btnPatient.setBackground(new Color(32, 178, 170));
		btnPatient.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnPatient.setBounds(394, 11, 89, 39);
		panelDesButtons.add(btnPatient);
		btnValidationChange = new JButton("Changer");
		btnValidationChange.setForeground(new Color(0, 128, 128));
		btnValidationChange.setFont(new Font("Dialog", Font.BOLD, 15));
		btnBack = new JButton("Deconnexion");
		btnBack.setBackground(new Color(32, 178, 170));
		btnBack.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnBack.setBounds(529, 11, 109, 39);
		panelDesButtons.add(btnBack);
	}

	public void initComponents() {
		setTitle("e-sante");
		setSize(new Dimension(700, 500));
		getContentPane().setLayout(null);
		tablePatient.setModel(modelePatient);
		lblNewLabel = new JLabel("Espace Admin");
		paneldestableaux = new JPanel();
		paneldestableaux.setLayout(new CardLayout(0, 0));
		paneltitre.setBackground(new Color(32, 178, 170));
		paneltitre.setBounds(10, 11, 664, 56);
		getContentPane().add(paneltitre);
		paneltitre.setLayout(null);
		getContentPane().setBackground(Color.WHITE);
		paneldestableaux.add(panelStructure, "name_289504259643500");
		panelStructure.setLayout(new GridLayout(1, 0, 0, 0));
		panelStructure.setVisible(false);

		scrollPane_1.setBorder(new TitledBorder(null, "Structure de Sante", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		panelStructure.add(scrollPane_1);


		tableStructure.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		scrollPane_1.setViewportView(tableStructure);
		tableStructure.setModel(modeleStrucure);

		panelChange.setBackground(Color.WHITE);
		paneldestableaux.add(panelChange, "name_38576144026214");
		panelChange.setLayout(null);

		passwordField2.setBounds(162, 105, 130, 26);
		panelChange.add(passwordField2);


		lblNewLabel_1.setBounds(6, 45, 144, 16);
		panelChange.add(lblNewLabel_1);
		passwordField1.setBounds(162, 72, 130, 26);
		panelChange.add(passwordField1);

		passwordField = new JPasswordField();
		passwordField.setBounds(162, 40, 130, 26);
		panelChange.add(passwordField);


		btnValidationChange.setBounds(120, 156, 110, 42);
		panelChange.add(btnValidationChange);

		lblNewLabel.setSize(new Dimension(150, 14));
		lblNewLabel.setPreferredSize(new Dimension(150, 14));
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 30));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(185, 11, 253, 34);
		paneltitre.add(lblNewLabel);

		paneldestableaux.add(panelPatient, "name_289497348125800");
		panelPatient.setLayout(new GridLayout(1, 0, 0, 0));
		paneldestableaux.setBackground(new Color(255, 255, 255));
		paneldestableaux.setBounds(10, 78, 335, 311);
		getContentPane().add(paneldestableaux);


		panelDesButtons.setBackground(Color.WHITE);
		panelDesButtons.setBounds(10, 400, 664, 56);
		getContentPane().add(panelDesButtons);

		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(386, 79, 280, 310);
		getContentPane().add(panel);
		panel.setLayout(new BorderLayout(0, 0));

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(32, 178, 170));
		FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		panel.add(panel_1, BorderLayout.NORTH);

		btnRecherche = new JButton(" ▶ ");
		btnRecherche.setForeground(new Color(255, 255, 255));
		btnRecherche.setFont(new Font("Lucida Grande", Font.PLAIN, 21));
		btnRecherche.setBackground(Color.WHITE);
		btnRecherche.setSize(new Dimension(300, 25));
		btnRecherche.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panelPatient.add(scrollPane);


		panelHome.setBackground(Color.WHITE);
		paneldestableaux.add(panelHome, "name_58761797252823");
		panelHome.setLayout(null);
		panelHome.setVisible(true);
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("/Users/cheikh/eclipse-workspace/E-sante/image/icone/Administrator.png"));
		lblNewLabel_4.setBounds(104, 35, 141, 202);
		panelHome.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("Administrateur");
		lblNewLabel_5.setFont(new Font("Dialog", Font.BOLD, 24));
		lblNewLabel_5.setForeground(new Color(0, 128, 128));
		lblNewLabel_5.setBounds(63, 201, 227, 36);
		panelHome.add(lblNewLabel_5);

		panelmodifier = new JPanel();
		panelmodifier.setBackground(Color.WHITE);
		paneldestableaux.add(panelmodifier, "name_143046632681923");
		panelmodifier.setLayout(null);

		passwordFieldModif = new JPasswordField();
		passwordFieldModif.setBounds(163, 189, 130, 26);
		panelmodifier.add(passwordFieldModif);

		loginTf = new JTextField();
		loginTf.setBounds(163, 151, 130, 26);
		panelmodifier.add(loginTf);
		loginTf.setColumns(10);

		telTf = new JTextField();
		telTf.setColumns(10);
		telTf.setBounds(163, 113, 130, 26);
		panelmodifier.add(telTf);

		adresseTf = new JTextField();
		adresseTf.setColumns(10);
		adresseTf.setBounds(163, 75, 130, 26);
		panelmodifier.add(adresseTf);

		emailTf = new JTextField();
		emailTf.setBounds(163, 37, 130, 26);
		panelmodifier.add(emailTf);
		emailTf.setColumns(10);

		JLabel lblNewLabel_7 = new JLabel("Email:");
		lblNewLabel_7.setBounds(74, 42, 71, 16);
		panelmodifier.add(lblNewLabel_7);

		JLabel lblNewLabel_7_1 = new JLabel("Adresse:");
		lblNewLabel_7_1.setBounds(74, 80, 71, 16);
		panelmodifier.add(lblNewLabel_7_1);

		JLabel lblNewLabel_7_2 = new JLabel("Tel:");
		lblNewLabel_7_2.setBounds(74, 118, 71, 16);
		panelmodifier.add(lblNewLabel_7_2);

		JLabel lblNewLabel_7_3 = new JLabel("Login:");
		lblNewLabel_7_3.setBounds(74, 156, 71, 16);
		panelmodifier.add(lblNewLabel_7_3);

		JLabel lblNewLabel_7_4 = new JLabel("Password:");
		lblNewLabel_7_4.setBounds(74, 194, 71, 16);
		panelmodifier.add(lblNewLabel_7_4);

		JLabel lblNewLabel_8 = new JLabel("Renseigner juste les champs que vous voulez supprimer");
		lblNewLabel_8.setForeground(new Color(0, 128, 128));
		lblNewLabel_8.setFont(new Font("Dialog", Font.BOLD, 11));
		lblNewLabel_8.setBounds(6, 6, 323, 24);
		panelmodifier.add(lblNewLabel_8);


		btnModifierUser.setFont(new Font("Dialog", Font.BOLD, 15));
		btnModifierUser.setForeground(new Color(0, 128, 128));
		btnModifierUser.setBackground(new Color(255, 255, 255));
		btnModifierUser.setBounds(90, 234, 117, 40);
		panelmodifier.add(btnModifierUser);

		JLabel lblNewLabel_6 = new JLabel("Search");
		lblNewLabel_6.setForeground(Color.WHITE);
		panel_1.add(lblNewLabel_6);
		rechercherTf = new JTextField();
		panel_1.add(rechercherTf);
		rechercherTf.setColumns(10);
		btnRecherche.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_1.add(btnRecherche);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 139, 139));
		panel.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(null);

		btnLister = new JButton("Lister");
		btnLister.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		btnLister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnLister.setBounds(71, 51, 117, 39);
		panel_2.add(btnLister);

		btnAjouter = new JButton("Ajouter");
		btnAjouter.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		btnAjouter.setBounds(71, 92, 117, 39);
		panel_2.add(btnAjouter);

		btnModifier = new JButton("Modifier\n");
		btnModifier.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		btnModifier.setBounds(71, 134, 117, 40);
		panel_2.add(btnModifier);

		btnSupprimer = new JButton("Supprimer");
		btnSupprimer.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		btnSupprimer.setBounds(71, 174, 117, 40);
		panel_2.add(btnSupprimer);

		titre = new JLabel("");
		titre.setForeground(Color.WHITE);
		titre.setBackground(Color.WHITE);
		titre.setFont(new Font("Dialog", Font.PLAIN, 24));
		titre.setBounds(30, 6, 204, 33);
		panel_2.add(titre);

		btnChangermdp = new JButton("Changer votre mot de passe");
		btnChangermdp.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		btnChangermdp.setBounds(16, 222, 247, 40);
		panel_2.add(btnChangermdp);

		btnChanger = new JButton("changer votre login ou password");


		Utilitaire.center(this, this.getSize());
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




	public void setPanelDesButtons(JPanel panelDesButtons) {
		this.panelDesButtons = panelDesButtons;
	}

	public JTextField getTextField() {
		return rechercherTf;
	}



	public JTable getTableStructure() {
		return tableStructure;
	}

	public void setTableStructure(JTable tableStructure) {
		this.tableStructure = tableStructure;
	}





	public JButton getBtnRecherche() {
		return btnRecherche;
	}



	public JButton getBtnLister() {
		return btnLister;
	}



	public JButton getBtnAjouter() {
		return btnAjouter;
	}



	public JButton getBtnModifier() {
		return btnModifier;
	}



	public JButton getBtnSupprimer() {
		return btnSupprimer;
	}

	public void setBtnSupprimer(JButton btnSupprimer) {
		this.btnSupprimer = btnSupprimer;
	}

	public JButton getBtnChanger() {
		return btnChanger;
	}

	public void setBtnChanger(JButton btnChanger) {
		this.btnChanger = btnChanger;
	}

	public int getIdSelectStructure() {
		return idSelectStructure;
	}
	public int getRechercherTf() throws DAOException {
		Integer idSearch= Integer.valueOf(rechercherTf.getText());
		if(idSearch.equals(null))throw new DAOException("Champ de recherche vide ");
		return idSearch;
	}

	public void setIdSelectStructure(int idSelectStructure) {
		this.idSelectStructure = idSelectStructure;
	}

	public int getIdSelectPatient() {
		return idSelectPatient;
	}

	public void setIdSelectPatient(int idSelectPatient) {
		this.idSelectPatient = idSelectPatient;
	}

	public boolean getIdObserver() {
		return idObserver;
	}

	public void setIdObserver(boolean idObserver) {
		this.idObserver = idObserver;
	}


	public static void setInstance(Espace_Admin instance) {
		Espace_Admin.instance = instance;
	}
	public void addBtnRechercher(ActionListener actionListener) {
		btnRecherche.addActionListener(actionListener);
	}
	public void addBtnLister(ActionListener actionListener) {
		btnLister.addActionListener(actionListener);
	}
	public void addBtnModifier(ActionListener actionListener) {
		btnModifier.addActionListener(actionListener);
	}
	public void addBtnAjouter(ActionListener actionListener) {
		btnAjouter.addActionListener(actionListener);
	}
	public void addBtnSupprimer(ActionListener actionListener) {
		btnSupprimer.addActionListener(actionListener);
	}
	public void addBtnStructure(ActionListener actionListener) {
		btnStructure.addActionListener(actionListener);
	}
	public void addBtnPatient(ActionListener actionListener) {
		btnPatient.addActionListener(actionListener);
	}
	public void addBtnModifierMdp(ActionListener actionListener) {
		btnChangermdp.addActionListener(actionListener);
	}
	public void addBtnQuitter(ActionListener actionListener) {
		btnBack.addActionListener(actionListener);
	}
	public void addBtnValider(ActionListener actionListener) {
		btnValidationChange.addActionListener(actionListener);
	}
	public void addBtnModifierUser(ActionListener actionListener) {
		btnModifierUser.addActionListener(actionListener);
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
	public String getPasswordField() throws DAOException {
		String password= String.valueOf(passwordField.getPassword());
		if(password.equals("")) {

			throw new DAOException("Champs password vide  vide");
		}
		return password;
	}


	public String getPasswordField2() throws DAOException {
		String password= String.valueOf(passwordField2.getPassword());
		if(password.equals("")) {

			throw new DAOException("Champs password vide  vide");
		}
		return password;
	}
	public void clear() {
		passwordField.setText("");
		passwordField1.setText("");
		passwordField2.setText("");
	}

	public void vieuwStructure(){
		panelChange.setVisible(false);
		panelPatient.setVisible(false);
		panelmodifier.setVisible(false);
		panelStructure.setVisible(true);
		setIdObserver(true);
		titre.setText("Structure de Sante");
	}
	public void vieuwPatient(){
		panelChange.setVisible(false);
		panelPatient.setVisible(true);
		panelmodifier.setVisible(false);
		panelStructure.setVisible(false);
		setIdObserver(false);
		titre.setText("Patient");
	}
	public void vieuwChange(){
		panelChange.setVisible(true);
		panelPatient.setVisible(false);
		panelStructure.setVisible(false);
		panelmodifier.setVisible(false);
		setIdObserver(false);

	}
	public void vieuwModif(){
		panelChange.setVisible(false);
		panelPatient.setVisible(false);
		panelStructure.setVisible(false);
		panelmodifier.setVisible(true);
		panelHome.setVisible(false);

	}
	public void clearModif() {
		emailTf.setText("");
		loginTf.setText("");
		telTf.setText("");
		passwordFieldModif.setText("");
		adresseTf.setText("");

	}

	public PatientModel getModelePatient() {
		return modelePatient;
	}

	public String getPasswordFieldModif() {
		String password;
		if(String.valueOf(passwordFieldModif.getPassword()).equals(""))
		{
			password= null;
		}
		else {
			password=String.valueOf(passwordFieldModif.getPassword());
		}
		return password;
	}

	public String getLoginTf() {
		String login;
		if(loginTf.getText().equals("")) {
			login=null;
		}
		else {
			login=loginTf.getText();
		}
		return login;
	}

	public int getTelTf() {
		int tel;
		if(telTf.getText().equals("")) {
			tel=0;
		}
		else {
			tel=Integer.valueOf(telTf.getText());
		}

		return tel;
	}

	public String getAdresseTf() {
		String add;
		if(adresseTf.getText().equals("")) {
			add = null;
		}else {
			add=adresseTf.getText();
		}

		return add;
	}

	public String getEmailTf() {
		String add;
		if(emailTf.getText().equals("")) {
			add = null;
		}else {
			add=emailTf.getText();
		}

		return add;
	}

}
