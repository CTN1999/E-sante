package project.front.espace;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import project.back.untils.Utilitaire;
import project.data.DAO.implement.StructureDeSanteDao;
import project.exceptions.DAOException;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.DefaultComboBoxModel;

import project.back.Consultation;
import project.back.Patient;
import project.back.Qualification;
import project.back.StructureDeSante;
import project.back.methods.Metier;
import project.back.models.ConsultationModelPatient;

import javax.swing.JTable;

public class Espace_Patient extends JFrame{
	private static Espace_Patient instance ;
	private JPanel paneltitre;
	private JLabel TitrePatient;
	private JPanel panelsoumission;
	private JButton btnMessage;
	private JPanel panelreponse;
	private JButton backBtn;
	private Patient patient;
	private JPanel panel;
	private JScrollPane scrollPane;
	private JButton btnDemander;

	private JComboBox choixQualification;

	private JButton btnVaccin;
	private JButton btnCovid;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JComboBox listStructure;
	private ConsultationModelPatient consultationModelPatient;
	private JTable table;
	
	private String qualification;





	private Espace_Patient() {

		createInstanceComponents();
		initComponents ();
	}


	public Patient getPatient() {
		return patient;
	}
	public JTable getTable() {
		return table;
	}


	public void setPatient(Patient patient) {
		this.patient = patient;
	}


	private void createInstanceComponents() {
		paneltitre = new JPanel();
		TitrePatient = new JLabel();
		btnMessage = new JButton("MESSAGE");
		panelsoumission = new JPanel();
		panelreponse = new JPanel();
		panelreponse.setLayout(new BorderLayout(0, 0));
		scrollPane = new JScrollPane();

		table = new JTable();
		table.setEnabled(false);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

		scrollPane.setViewportView(table);
		consultationModelPatient = new ConsultationModelPatient();
		backBtn = new JButton("Deconnexion");
		panel = new JPanel();
		lblNewLabel_1 = new JLabel("Demande Consultation:");
		lblNewLabel_2 = new JLabel("Choix type de Docteur:");
		lblNewLabel_3 = new JLabel("Structure De Sante:");
		btnCovid = new JButton("Test Covid-19");
		btnDemander = new JButton("Demander");
		choixQualification = new JComboBox();






	}
	private void initComponents ()  {
		getContentPane().setBackground(Color.WHITE);
		setResizable(false);
		setTitle("E-sante");
		setSize(new Dimension(700, 500));
		getContentPane().setLayout(null);


		paneltitre.setBackground(new Color(32, 178, 170));
		paneltitre.setBounds(10, 11, 664, 56);
		getContentPane().add(paneltitre);
		paneltitre.setLayout(null);


		TitrePatient.setFont(new Font("Trebuchet MS", Font.ITALIC, 30));
		TitrePatient.setForeground(new Color(255, 255, 255));
		TitrePatient.setBounds(22, 11, 625, 34);
		paneltitre.add(TitrePatient);


		panelsoumission.setBackground(new Color(32, 178, 170));
		panelsoumission.setBounds(427, 87, 247, 63);
		getContentPane().add(panelsoumission);
		panelsoumission.setLayout(null);


		btnMessage.setFont(new Font("Tw Cen MT", Font.BOLD | Font.ITALIC, 20));
		btnMessage.setBounds(34, 11, 159, 31);

		panelsoumission.add(btnMessage);


		panelreponse.setBackground(new Color(255, 255, 255));
		panelreponse.setBounds(427, 150, 247, 266);
		getContentPane().add(panelreponse);


		backBtn.setBounds(482, 427, 192, 29);
		getContentPane().add(backBtn);


		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 87, 405, 329);
		getContentPane().add(panel);
		panel.setLayout(null);


		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.BOLD, 19));
		lblNewLabel_1.setBounds(50, 24, 283, 16);
		panel.add(lblNewLabel_1);


		lblNewLabel_2.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(16, 52, 158, 16);
		panel.add(lblNewLabel_2);


		lblNewLabel_3.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(16, 93, 138, 16);
		panel.add(lblNewLabel_3);


		listStructure = new JComboBox();
		listStructure();

		listStructure.setBounds(203, 90, 130, 27);
		panel.add(listStructure);


		btnCovid.setForeground(Color.BLACK);
		btnCovid.setBackground(new Color(32, 178, 170));
		btnCovid.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnCovid.setBounds(26, 194, 148, 65);
		panel.add(btnCovid);

		btnVaccin = new JButton("S'Inscrire Pour Le Vaccin");
		btnVaccin.setForeground(Color.BLACK);
		btnVaccin.setBackground(new Color(32, 178, 170));
		btnVaccin.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnVaccin.setBounds(202, 194, 164, 65);
		panel.add(btnVaccin);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		panelreponse.add(scrollPane, BorderLayout.CENTER);
		backBtn.setForeground(Color.BLACK);
		backBtn.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		backBtn.setBackground(new Color(32, 178, 170));



		btnDemander.setBackground(new Color(32, 178, 170));
		btnDemander.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		btnDemander.setBounds(113, 129, 117, 29);
		panel.add(btnDemander);


		choixQualification.setModel(new DefaultComboBoxModel(Qualification.values()));
		choixQualification.setBounds(203, 49, 130, 27);
		panel.add(choixQualification);
		table.setModel(consultationModelPatient);
		table.getColumnModel().getColumn(0).setPreferredWidth(50);
		table.getColumnModel().getColumn(1).setPreferredWidth(100);
		table.getColumnModel().getColumn(2).setPreferredWidth(100);
		table.getColumnModel().getColumn(3).setPreferredWidth(100);
		table.getColumnModel().getColumn(0).setPreferredWidth(75);
		table.getColumnModel().getColumn(0).setPreferredWidth(75);


		Utilitaire.center(this, this.getSize());

	}

	public void addbackButton(ActionListener actionListener) {
		backBtn.addActionListener(actionListener);
	}
	public void addSelectStructure(ActionListener actionListener) {
		listStructure.addActionListener(actionListener);
	}

	public void addBtnDemander(ActionListener actionListener) {
		btnDemander.addActionListener(actionListener);

	}
	public void addCovid (ActionListener actionListener) {
		btnCovid.addActionListener(actionListener);
	}
	public void addBtnMessage(ActionListener actionListener) {
		btnMessage.addActionListener(actionListener);
	}
	public void addVaccin (ActionListener actionListener) {
		btnVaccin.addActionListener(actionListener);
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
	public void addSelectQualification(ActionListener actionListener) {
		choixQualification.addActionListener(actionListener);
	}

	public void run() {
		this.setVisible(true);
	}


	public static Espace_Patient getInstance() {
		instance = new Espace_Patient();
		return instance;
	}
	public JLabel getTitrePatient() {
		return TitrePatient;
	}


	public void setTitrePatient(JLabel titrePatient) {
		TitrePatient = titrePatient;
	}
	public void listStructure() {
		List<StructureDeSante> structureDeSantes = new ArrayList<>();

		try {
			structureDeSantes = Metier.listerStructure();
			for(StructureDeSante structureDeSante : structureDeSantes ) {
				listStructure.addItem(structureDeSante.getNom());

			}
		} catch (DAOException e) {

			errorMessage(e.getMessage());
		}
	}
	public JComboBox getChoixQualification() {
		return choixQualification;
	}


	public void setChoixQualification(JComboBox choixQualification) {
		this.choixQualification = choixQualification;
	}


	public JComboBox getListStructure() {
		return listStructure;
	}
	public String getQualification() {
		return qualification;
	}


	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	public JButton getBtnDemander() {
		return btnDemander;
	}


	public void setListStructure(JComboBox listStructure) {
		this.listStructure = listStructure;
	}
	
}


