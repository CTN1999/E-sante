package project.front.espace;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import project.back.Docteur;
import project.back.Patient;
import project.back.Qualification;
import project.back.StructureDeSante;
import project.back.methods.Metier;
import project.back.models.CasAlertModel;
import project.back.models.ConsultationModelPatient;
import project.back.models.ConsultationModelStructure;
import project.back.models.DocteurModel;
import project.back.models.VaccinModel;
import project.back.untils.Utilitaire;
import project.exceptions.DAOException;

import java.awt.CardLayout;
import javax.swing.border.EtchedBorder;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.JPasswordField;
import java.awt.SystemColor;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.ImageIcon;
import java.awt.GridLayout;

import javax.swing.border.CompoundBorder;

public class Espace_Structure extends JFrame{	
	private VaccinModel modeleVaccin;
	private DocteurModel modeleDoc;
	private ConsultationModelStructure modeleConsultation;
	private StructureDeSante structureDeSante;
	private static Espace_Structure instance;
	private JPanel paneltitre;
	private JButton backBtn;
	private Patient patient;
	private static final long serialVersionUID = 1L;
	private JTextField rechercherTf;
	private JTextField telephoneTf;
	private JTextField adresseTf;
	private JTextField loginTf;
	private JPasswordField passwordField1;
	private JPanel panelAction;
	private JPanel panelActionDocteur;
	private JPanel searchPanel;
	private JLabel searchLabel;
	private JButton btnGo;
	private JButton btnAjoutDocteur;
	private JLabel lblAjouterUnNouveau;
	private JLabel lblSupprimerUnMdecin;
	private JButton btnSuppDocteur;
	private JButton btnModifierDocteur;
	private JButton btnAjouterDocteurModif;
	private JButton btnListRV;
	private JButton btnListVacc;
	private JButton btnListDocteur;
	private JButton btnListCasAlerte;
	private JPanel panelConsultation;
	private JPanel panelRv;
	private JTextField dateTf;
	private int idComboxDocteur;

	public void setIdComboxDocteur(int idComboxDocteur) {
		this.idComboxDocteur = idComboxDocteur;
	}

	private JPanel piedPage;
	private JPanel panelVaccin;
	private JPanel panelTableau;
	private JPanel panelmedecin;
	private JButton btnValiderConsultation;
	private JPanel panelDocteurUpdate;
	private JPanel panelCasAlert;
	private JPanel panelPhotoVaccin;
	private JPanel panelPhotoCas;
	private JPanel panelBienvenue;
	private JButton btnInfoPatient;
	private JLabel titreStructure;
	private JLabel lblNewLabel_1;
	private JScrollPane scrollPane;
	private JTable tableDocteur;
	private JTable tableCasAlert;
	private JScrollPane scrollPane_1;
	private CasAlertModel modeleCasAlert;
	private int selectDocteur;
	private int selectConsultation;
	private int selectCombo;

	private JScrollPane scrollPane_2;
	private JTable tableVaccin;

	public JTable getTableVaccin() {
		return tableVaccin;
	}

	private JScrollPane scrollPane_3;
	private JTable tableConsultation;
	private JButton btnBackMedecin;
	private JPasswordField passwordField2;
	private JComboBox comboBox;
	




	public JComboBox getComboBox() {
		return comboBox;
	}

	public void setComboBox(JComboBox comboBox) {
		this.comboBox = comboBox;
	}

	private Espace_Structure() {

		createInstanceComponents();
		initComponents ();
	}

	public Patient getPatient() {
		return patient;
	}

	public VaccinModel getModeleVaccin() {
		return modeleVaccin;
	}

	public void setModeleVaccin(VaccinModel modeleVaccin) {
		this.modeleVaccin = modeleVaccin;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	public CasAlertModel getModeleCasAlert() {
		return modeleCasAlert;
	}

	public void setModeleCasAlert(CasAlertModel modeleCasAlert) {
		this.modeleCasAlert = modeleCasAlert;
	}
	private void createInstanceComponents() {
		paneltitre = new JPanel();
		panelAction = new JPanel();
		panelActionDocteur = new JPanel();
		modeleDoc = new DocteurModel();
		modeleCasAlert = new CasAlertModel();
		modeleVaccin = new VaccinModel();
		searchPanel = new JPanel();
		scrollPane = new JScrollPane();
		tableDocteur = new JTable();
		modeleConsultation = new ConsultationModelStructure();
		tableDocteur.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tableDocteur.setModel(modeleDoc);

		tableDocteur.getColumnModel().getColumn(0).setPreferredWidth(25);
		scrollPane.setViewportView(tableDocteur);

		searchPanel.setBackground(new Color(32, 178, 170));
		searchLabel = new JLabel("Rechercher selon l'id : ");
		rechercherTf = new JTextField();
		rechercherTf.setToolTipText("Recherche selon l'ID");
		btnGo = new JButton("Go");
		btnAjoutDocteur = new JButton("\u2794");
		lblAjouterUnNouveau = new JLabel("Ajouter un nouveau m\u00E9decin : ");
		lblSupprimerUnMdecin = new JLabel("Supprimer un m\u00E9decin : ");
		btnSuppDocteur = new JButton("\u279C");

		btnModifierDocteur = new JButton("\u279C");
		telephoneTf = new JTextField();
		adresseTf = new JTextField();
		loginTf = new JTextField();
		btnAjouterDocteurModif = new JButton("Ajouter");
		passwordField1 = new JPasswordField();
		btnListRV = new JButton("Rendez-vous");
		btnListRV.setForeground(Color.BLACK);
		btnListVacc = new JButton("Vaccin");
		btnListDocteur = new JButton("Docteur");
		btnListCasAlerte = new JButton("Cas Alert");
		piedPage = new JPanel();
		panelConsultation = new JPanel();
		panelConsultation.setLayout(new GridLayout(1, 0, 0, 0));

		scrollPane_3 = new JScrollPane();
		scrollPane_3.setBorder(new TitledBorder(null, "Consultation", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelConsultation.add(scrollPane_3);

		tableConsultation = new JTable();
		tableConsultation.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
		scrollPane_3.setViewportView(tableConsultation);
		panelVaccin = new JPanel();
		panelVaccin.setLayout(new GridLayout(1, 0, 0, 0));

		scrollPane_2 = new JScrollPane();
		scrollPane_2.setBorder(new TitledBorder(null, "List Vaccin", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		scrollPane_2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane_2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		panelVaccin.add(scrollPane_2);
		comboBox = new JComboBox();
		tableVaccin = new JTable();
		tableVaccin.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		scrollPane_2.setViewportView(tableVaccin);
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBorder(new TitledBorder(null, "Cas Alert", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		tableCasAlert = new JTable();
		tableCasAlert.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);


	}

	private void initComponents () {
		getContentPane().setBackground(Color.WHITE);
		setResizable(false);
		setTitle("E-sante");
		setSize(new Dimension(700, 500));
		getContentPane().setLayout(null);

		paneltitre.setBackground(new Color(32, 178, 170));
		paneltitre.setBounds(10, 11, 664, 56);
		getContentPane().add(paneltitre);
		paneltitre.setLayout(null);
		tableCasAlert.setModel(modeleCasAlert);
		titreStructure = new JLabel("");
		titreStructure.setForeground(Color.WHITE);
		titreStructure.setFont(new Font("Lucida Grande", Font.BOLD, 23));
		titreStructure.setBounds(6, 6, 630, 44);
		paneltitre.add(titreStructure);

		tableConsultation.setModel(modeleConsultation);
		panelAction.setBounds(315, 79, 360, 336);
		getContentPane().add(panelAction);
		panelAction.setLayout(new CardLayout(0, 0));
		panelAction.add(panelActionDocteur, "name_131040912196277");
		panelActionDocteur.setLayout(null);
		searchPanel.setLayout(null);
		searchPanel.setBounds(0, 0, 360, 41);
		panelActionDocteur.add(searchPanel);
		tableVaccin.setModel(modeleVaccin);

		panelActionDocteur.setBackground(Color.WHITE);
		searchLabel.setFont(new Font("Dialog", Font.PLAIN, 13));
		searchLabel.setBounds(10, 7, 163, 16);
		searchPanel.add(searchLabel);


		rechercherTf.setColumns(10);
		rechercherTf.setBorder(new LineBorder(new Color(171, 173, 179)));
		rechercherTf.setBounds(197, 8, 82, 16);
		searchPanel.add(rechercherTf);

		btnModifierDocteur.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnModifierDocteur.setBackground(Color.CYAN);
		btnGo.setPreferredSize(new Dimension(50, 20));
		btnGo.setFont(new Font("Goudy Old Style", Font.PLAIN, 14));
		btnGo.setBounds(289, 6, 50, 20);
		searchPanel.add(btnGo);


		btnAjoutDocteur.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnAjoutDocteur.setBackground(Color.CYAN);
		btnAjoutDocteur.setBounds(261, 63, 49, 21);
		panelActionDocteur.add(btnAjoutDocteur);


		lblAjouterUnNouveau.setFont(new Font("Goudy Old Style", Font.PLAIN, 17));
		lblAjouterUnNouveau.setBounds(10, 63, 239, 16);
		panelActionDocteur.add(lblAjouterUnNouveau);


		lblSupprimerUnMdecin.setFont(new Font("Goudy Old Style", Font.PLAIN, 17));
		lblSupprimerUnMdecin.setBounds(40, 108, 209, 16);
		panelActionDocteur.add(lblSupprimerUnMdecin);

		btnGo.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnGo.setBackground(SystemColor.activeCaption);
		btnSuppDocteur.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnSuppDocteur.setBackground(Color.CYAN);
		btnSuppDocteur.setBounds(261, 108, 49, 21);
		panelActionDocteur.add(btnSuppDocteur);

		JLabel lblModifierUnMdecin = new JLabel("Modifier un m\u00E9decin : ");
		lblModifierUnMdecin.setFont(new Font("Goudy Old Style", Font.PLAIN, 17));
		lblModifierUnMdecin.setBounds(52, 146, 197, 16);
		panelActionDocteur.add(lblModifierUnMdecin);
		btnModifierDocteur.setBounds(261, 146, 49, 21);
		panelActionDocteur.add(btnModifierDocteur);

		panelDocteurUpdate = new JPanel();
		panelAction.add(panelDocteurUpdate, "name_131091615540061");
		panelDocteurUpdate.setLayout(null);

		JLabel searchLabel_1 = new JLabel("Modifier un m\u00E9decin : ");
		searchLabel_1.setBounds(72, 24, 244, 22);
		searchLabel_1.setFont(new Font("Goudy Old Style", Font.PLAIN, 20));
		panelDocteurUpdate.add(searchLabel_1);

		JLabel searchLabel_2 = new JLabel("T\u00E9l\u00E9phone : ");
		searchLabel_2.setFont(new Font("Goudy Old Style", Font.PLAIN, 17));
		searchLabel_2.setBounds(49, 71, 104, 16);
		panelDocteurUpdate.add(searchLabel_2);


		telephoneTf.setBounds(178, 71, 86, 20);
		panelDocteurUpdate.add(telephoneTf);
		telephoneTf.setColumns(10);

		JLabel searchLabel_3 = new JLabel("Adresse : ");
		searchLabel_3.setFont(new Font("Goudy Old Style", Font.PLAIN, 17));
		searchLabel_3.setBounds(72, 102, 91, 16);
		panelDocteurUpdate.add(searchLabel_3);


		adresseTf.setBounds(178, 102, 86, 20);
		panelDocteurUpdate.add(adresseTf);
		adresseTf.setColumns(10);

		JLabel searchLabel_4 = new JLabel("Login : ");
		searchLabel_4.setFont(new Font("Goudy Old Style", Font.PLAIN, 17));
		searchLabel_4.setBounds(86, 130, 67, 16);
		panelDocteurUpdate.add(searchLabel_4);


		loginTf.setBounds(178, 134, 86, 20);
		panelDocteurUpdate.add(loginTf);
		loginTf.setColumns(10);

		JLabel searchLabel_5 = new JLabel("Password : ");
		searchLabel_5.setFont(new Font("Goudy Old Style", Font.PLAIN, 17));
		searchLabel_5.setBounds(55, 164, 98, 22);
		panelDocteurUpdate.add(searchLabel_5);


		btnAjouterDocteurModif.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		btnAjouterDocteurModif.setBackground(new Color(32, 178, 170));
		btnAjouterDocteurModif.setBounds(86, 248, 147, 29);
		panelDocteurUpdate.add(btnAjouterDocteurModif);


		passwordField1.setBounds(178, 167, 86, 20);
		panelDocteurUpdate.add(passwordField1);

		btnBackMedecin = new JButton("↵");
		btnBackMedecin.setFont(new Font("Lucida Grande", Font.BOLD, 33));
		btnBackMedecin.setBorder(new CompoundBorder());
		btnBackMedecin.setBackground(Color.WHITE);
		btnBackMedecin.setBounds(6, 6, 49, 22);
		panelDocteurUpdate.add(btnBackMedecin);

		JLabel lblNewLabel_4 = new JLabel("ConfimPassword:");
		lblNewLabel_4.setFont(new Font("Dialog", Font.PLAIN, 17));
		lblNewLabel_4.setBounds(6, 192, 147, 22);
		panelDocteurUpdate.add(lblNewLabel_4);
		
		passwordField2 = new JPasswordField();
		passwordField2.setBounds(178, 199, 86, 26);
		panelDocteurUpdate.add(passwordField2);

		panelRv = new JPanel();
		panelAction.add(panelRv, "name_2133315120000");
		panelRv.setLayout(null);
		searchPanel.setToolTipText("Recherche selon l'ID");
		JLabel searchLabel_1_1 = new JLabel("Valider rendez vous : ");
		searchLabel_1_1.setFont(new Font("Goudy Old Style", Font.PLAIN, 22));
		searchLabel_1_1.setBounds(86, 23, 232, 22);
		panelRv.add(searchLabel_1_1);

		JLabel searchLabel_1_1_1 = new JLabel("Date : ");
		searchLabel_1_1_1.setFont(new Font("Goudy Old Style", Font.PLAIN, 18));
		searchLabel_1_1_1.setBounds(49, 77, 79, 22);
		panelRv.add(searchLabel_1_1_1);

		dateTf = new JTextField();
		dateTf.setBounds(138, 80, 86, 20);
		panelRv.add(dateTf);
		dateTf.setColumns(10);

		btnValiderConsultation = new JButton("Valider");
		btnValiderConsultation.setBounds(88, 164, 89, 39);
		panelRv.add(btnValiderConsultation);

		btnInfoPatient = new JButton("➜");
		btnInfoPatient.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnInfoPatient.setBackground(Color.CYAN);
		btnInfoPatient.setBounds(284, 244, 49, 21);
		panelRv.add(btnInfoPatient);

		JLabel lblVoirInformationSur = new JLabel("voir Information sur patient:");
		lblVoirInformationSur.setFont(new Font("Dialog", Font.PLAIN, 17));
		lblVoirInformationSur.setBounds(23, 244, 232, 16);
		panelRv.add(lblVoirInformationSur);

		
		comboBox.setBounds(138, 112, 86, 27);
		panelRv.add(comboBox);

		JLabel lblNewLabel_3 = new JLabel("Docteur:");
		lblNewLabel_3.setFont(new Font("Dialog", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(23, 116, 96, 16);
		panelRv.add(lblNewLabel_3);

		panelPhotoVaccin = new JPanel();
		panelAction.add(panelPhotoVaccin, "name_123176263551896");
		panelPhotoVaccin.setLayout(null);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("/Users/cheikh/eclipse-workspace/E-sante/image/vac1.jpg"));
		lblNewLabel.setBounds(0, 0, 360, 336);
		panelPhotoVaccin.add(lblNewLabel);

		panelPhotoCas = new JPanel();
		panelAction.add(panelPhotoCas, "name_123186143388158");
		panelPhotoCas.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon("/Users/cheikh/eclipse-workspace/E-sante/image/masque.jpg"));
		lblNewLabel_2.setBounds(6, 0, 348, 330);
		panelPhotoCas.add(lblNewLabel_2);

		panelBienvenue = new JPanel();
		panelAction.add(panelBienvenue, "name_123284769508208");
		panelBienvenue.setLayout(null);

		lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("/Users/cheikh/eclipse-workspace/E-sante/image/espace.jpg"));
		lblNewLabel_1.setBounds(0, 0, 360, 336);
		panelBienvenue.add(lblNewLabel_1);

		panelTableau = new JPanel();
		panelTableau.setBounds(10, 79, 275, 336);
		getContentPane().add(panelTableau);
		panelTableau.setLayout(new CardLayout(0, 0));

		panelmedecin = new JPanel();
		panelmedecin.setBorder(null);
		panelTableau.add(panelmedecin, "name_131158382959489");
		panelmedecin.setLayout(new GridLayout(1, 0, 0, 0));


		scrollPane.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Docteurs", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		panelmedecin.add(scrollPane);


		panelCasAlert = new JPanel();
		panelTableau.add(panelCasAlert, "name_131182662288656");
		panelCasAlert.setLayout(new GridLayout(1, 0, 0, 0));


		panelCasAlert.add(scrollPane_1);


		scrollPane_1.setViewportView(tableCasAlert);



		panelTableau.add(panelVaccin, "name_131242610122263");
		panelTableau.add(panelConsultation, "name_946110516400");
		piedPage.setLayout(null);
		piedPage.setBackground(Color.WHITE);
		piedPage.setBounds(10, 420, 664, 52);
		getContentPane().add(piedPage);
		btnListRV.setBounds(10, 11, 100, 35);
		piedPage.add(btnListRV);
		btnListRV.setBackground(Color.CYAN);
		btnListRV.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnListVacc.setBounds(146, 11, 100, 35);
		piedPage.add(btnListVacc);
		btnListVacc.setBackground(Color.CYAN);
		btnListVacc.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnListDocteur.setBounds(284, 11, 92, 35);
		piedPage.add(btnListDocteur);
		btnListDocteur.setBackground(Color.CYAN);
		btnListDocteur.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnListCasAlerte.setBounds(411, 11, 100, 35);
		piedPage.add(btnListCasAlerte);
		btnListCasAlerte.setBackground(Color.CYAN);
		btnListCasAlerte.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		backBtn = new JButton("Deconnexion");
		backBtn.setBounds(538, 11, 100, 35);
		piedPage.add(backBtn);
		backBtn.setForeground(Color.BLACK);
		backBtn.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		backBtn.setBackground(Color.CYAN);
		
		btnListCasAlerte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnListDocteur.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		vieuwConsultation();

		Utilitaire.center(this, this.getSize());

	}
	public void run() {
		this.setVisible(true);
		vieuwAcceuil();
	}

	public DocteurModel getModeleDoc() {
		return modeleDoc;
	}

	public ConsultationModelStructure getModeleConsultation() {
		return modeleConsultation;
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
	public int getRechercherTf() throws DAOException {
		Integer idSearch= Integer.valueOf(rechercherTf.getText());
		if(idSearch.equals(null))throw new DAOException("Champ de recherche vide ");
		return idSearch;
	}

	public StructureDeSante getStructureDeSante() {
		return structureDeSante;
	}

	public void setStructureDeSante(StructureDeSante structureDeSante) {
		this.structureDeSante = structureDeSante;
	}
	public JLabel getTitreStructure() {
		return titreStructure;
	}

	public void viewCasAlert() {
		panelCasAlert.setVisible(true);
		panelPhotoCas.setVisible(true);
		panelmedecin.setVisible(false);
		panelConsultation.setVisible(false);
		panelVaccin.setVisible(false);
		panelActionDocteur.setVisible(false);
		panelDocteurUpdate.setVisible(false);
		panelPhotoVaccin.setVisible(false);
		panelBienvenue.setVisible(false);
		panelRv.setVisible(false);	
	}
	public void viewVaccin() {
		panelCasAlert.setVisible(false);
		panelPhotoCas.setVisible(false);
		panelmedecin.setVisible(false);
		panelConsultation.setVisible(false);
		panelVaccin.setVisible(true);
		panelActionDocteur.setVisible(false);
		panelDocteurUpdate.setVisible(false);
		panelPhotoVaccin.setVisible(true);
		panelBienvenue.setVisible(false);
		panelRv.setVisible(false);
	}

	public void viewDocteur() {
		panelCasAlert.setVisible(false);
		panelPhotoCas.setVisible(false);
		panelmedecin.setVisible(true);
		panelConsultation.setVisible(false);
		panelVaccin.setVisible(true);
		panelActionDocteur.setVisible(true);
		panelDocteurUpdate.setVisible(false);
		panelPhotoVaccin.setVisible(true);
		panelBienvenue.setVisible(false);
		panelRv.setVisible(false);
	}
	public void viewDocteurUpdate() {
		panelCasAlert.setVisible(false);
		panelPhotoCas.setVisible(false);
		panelmedecin.setVisible(true);
		panelConsultation.setVisible(false);
		panelVaccin.setVisible(false);
		panelActionDocteur.setVisible(false);
		panelDocteurUpdate.setVisible(true);
		panelPhotoVaccin.setVisible(false);
		panelBienvenue.setVisible(false);
		panelRv.setVisible(false);
	}

	public void vieuwConsultation() {
		panelCasAlert.setVisible(false);
		panelPhotoCas.setVisible(false);
		panelmedecin.setVisible(false);
		panelConsultation.setVisible(true);
		panelVaccin.setVisible(false);
		panelActionDocteur.setVisible(false);
		panelDocteurUpdate.setVisible(false);
		panelPhotoVaccin.setVisible(false);
		panelBienvenue.setVisible(false);
		panelRv.setVisible(true);
	}
	public void vieuwAcceuil() {
		panelCasAlert.setVisible(false);
		panelPhotoCas.setVisible(false);
		panelmedecin.setVisible(false);
		panelConsultation.setVisible(false);
		panelVaccin.setVisible(false);
		panelActionDocteur.setVisible(false);
		panelDocteurUpdate.setVisible(false);
		panelPhotoVaccin.setVisible(false);
		panelBienvenue.setVisible(true);
		panelRv.setVisible(false);
	}
	public void addbackButton(ActionListener actionListener) {
		backBtn.addActionListener(actionListener);
	}
	public void addSelectDocteur(ActionListener actionListener) {
		comboBox.addActionListener(actionListener);
	}
	
	public void addAfficheDocteur(ActionListener actionListener) {
		btnListDocteur.addActionListener(actionListener);
	}
	public void addBtnModifierDocteur(ActionListener actionListener) {
		btnModifierDocteur.addActionListener(actionListener);
	}
	public void addAfficherCasAlert(ActionListener actionListener) {
		btnListCasAlerte.addActionListener(actionListener);
	}
	public void addAfficherListeVaccin(ActionListener actionListener) {
		btnListVacc.addActionListener(actionListener);
	}
	public void addListeConsultationn(ActionListener actionListener) {
		btnListRV.addActionListener(actionListener);
	}
	
	public void addValiderConsultation(ActionListener actionListener){
		btnValiderConsultation.addActionListener(actionListener);
	}
	public void addVoirInfoPatient(ActionListener actionListener) {
		btnInfoPatient.addActionListener(actionListener);
	}
	public void addSupprimerDocteur(ActionListener actionListener) {
		btnSuppDocteur.addActionListener(actionListener);
	}
	public void addAjouterDocteur(ActionListener actionListener) {
		btnAjoutDocteur.addActionListener(actionListener);
	}
	public void addRechercheDocteur(ActionListener actionListener) {
		btnGo.addActionListener(actionListener);
	}
	public void addAfficherRV (ActionListener actionListener) {
		btnListRV.addActionListener(actionListener);
	}
	public void addBtnValiderModifDocteur(ActionListener actionListener) {
		btnAjouterDocteurModif.addActionListener(actionListener);
	}
	public void addBackDocteur(ActionListener actionListener) {
		btnBackMedecin.addActionListener(actionListener);
	}
	public static Espace_Structure getInstance() {
		instance = new Espace_Structure();
		return instance;
	}

	public int getSelectDocteur() {
		return selectDocteur;
	}

	public void setSelectDocteur(int selectDocteur) {
		this.selectDocteur = selectDocteur;
	}

	public int getSelectConsultation() {
		return selectConsultation;
	}

	public void setSelectConsultation(int selectConsultation) {
		this.selectConsultation = selectConsultation;
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
		if(loginTf.getText().equals("")) {
			throw new DAOException("Champs login  vide");
		}
		return loginTf.getText();
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
	
	

	public int getSelectCombo() {
		return selectCombo;
	}

	public void setSelectCombo(int selectCombo) {
		this.selectCombo = selectCombo;
	}
	public JTable getTableDocteur() {
		return tableDocteur;
	}

	public void setTableDocteur(JTable tableDocteur) {
		this.tableDocteur = tableDocteur;
	}

	public JTable getTableConsultation() {
		return tableConsultation;
	}

	public void setTableConsultation(JTable tableConsultation) {
		this.tableConsultation = tableConsultation;
	}
	public String getDateTf() throws DAOException {
		String date =  dateTf.getText();
		if(date.equals("")) throw new DAOException("le champ date est vide !");
		return date;
	}
	public void listDocteur(int id) {
		List<Docteur> docteurs = new ArrayList<>();

		try {
			docteurs = Metier.listerDocteur(id);
			for(Docteur docteur : docteurs ) {
				getComboBox().addItem(docteur.getPrenom() + " " + docteur.getNom());

			}
		} catch (Exception e) {

			errorMessage(e.getMessage());
		}
	}
}


