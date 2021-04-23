package project.front.espace;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import project.back.Docteur;
import project.back.Patient;
import project.back.Qualification;
import project.back.models.ConsultationModelDocteur;
import project.back.untils.Utilitaire;
import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;

public class Espace_Docteur extends JFrame {
	private static Espace_Docteur instance;
	private JPanel paneltitre;
	private JLabel TitreDocteur;
	private JButton backBtn;
	private Docteur docteur;
	private JScrollPane scrollPane;
	private JPanel panel;
	private JButton btnSupprimer;
	private JButton btnListerConsultation;
	private JButton btnEffectuer;
	private ConsultationModelDocteur consultationModelDocteur;
	private JTable table;

	public JTable getTable() {
		return table;
	}
	private Espace_Docteur() {

		createInstanceComponents();
		initComponents ();
		
	}
	private void createInstanceComponents() {
		paneltitre = new JPanel();
		TitreDocteur = new JLabel("NOM_DOCTEUR");
		backBtn = new JButton("Deconnexion");
		table = new JTable();
		consultationModelDocteur = new ConsultationModelDocteur();
		panel = new JPanel();
		btnSupprimer = new JButton("Supprimer");
		btnListerConsultation = new JButton("Liste Consultation");
		btnEffectuer = new JButton("Effectuer");

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
		TitreDocteur.setFont(new Font("Trebuchet MS", Font.ITALIC, 30));
		TitreDocteur.setForeground(new Color(255, 255, 255));
		TitreDocteur.setBounds(21, 6, 618, 34);
		paneltitre.add(TitreDocteur);
		backBtn.setBounds(482, 427, 192, 29);
		getContentPane().add(backBtn);
		backBtn.setForeground(Color.BLACK);
		backBtn.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		backBtn.setBackground(new Color(32, 178, 170));
		scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(10, 96, 439, 307);
		getContentPane().add(scrollPane);	
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.setModel(consultationModelDocteur);
		table.getColumnModel().getColumn(0).setPreferredWidth(50);
		table.getColumnModel().getColumn(1).setPreferredWidth(100);
		table.getColumnModel().getColumn(2).setPreferredWidth(100);
		table.getColumnModel().getColumn(3).setPreferredWidth(100);
		table.getColumnModel().getColumn(0).setPreferredWidth(75);
		table.getColumnModel().getColumn(0).setPreferredWidth(75);
		scrollPane.setViewportView(table);
		panel.setBackground(new Color(32, 178, 170));
		panel.setBounds(461, 96, 213, 307);
		getContentPane().add(panel);
		panel.setLayout(null);
		btnSupprimer.setBounds(27, 26, 146, 38);
		panel.add(btnSupprimer);
		btnListerConsultation.setBounds(27, 102, 146, 45);
		panel.add(btnListerConsultation);
		btnEffectuer.setBounds(27, 180, 146, 38);
		panel.add(btnEffectuer);
		Utilitaire.center(this, this.getSize());

	}
	public void run() {
		this.setVisible(true);
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
	public void addBtnSupprimer(ActionListener actionListener) {
		btnSupprimer.addActionListener(actionListener);
	}
	public void addBtnLister(ActionListener actionListener) {
		btnListerConsultation.addActionListener(actionListener);
	}
	public void addBtnEffectuer(ActionListener actionListener) {
		btnEffectuer.addActionListener(actionListener);
	}
	public void addbackButton(ActionListener actionListener) {
		backBtn.addActionListener(actionListener);
	}
	public static Espace_Docteur getInstance() {
		instance = new Espace_Docteur();
		return instance;
	}
	public Docteur getDocteur() {
		return docteur;
	}
	public void setDocteur(Docteur docteur) {
		this.docteur = docteur;
	}
	public JLabel getTitreDocteur() {
		return TitreDocteur;
	}

}
