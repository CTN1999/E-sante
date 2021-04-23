package project.front.home;
import javax.swing.JFrame;
import javax.swing.JPanel;

import project.back.Patient;
import project.back.untils.Utilitaire;

import java.awt.Dimension;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Frame;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTextArea;
public class FormulaireCovid extends JFrame {
	private static FormulaireCovid instances;
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
	private JPanel panelsoumission;
	private JButton btnSoumettre;
	private JPanel panelcase;
	private JCheckBox oui1;
	private JCheckBox non1;
	private JCheckBox oui2;
	private JCheckBox non2;
	private JCheckBox oui3;
	private JCheckBox non3;
	private JCheckBox oui4;
	private JCheckBox non4;
	private JCheckBox oui5;
	private JCheckBox non5;
	private JCheckBox oui6;
	private JCheckBox non6;
	private JCheckBox oui7;
	private JCheckBox non7;
	private JCheckBox oui8;
	private JCheckBox non8;
	private JPanel panelreponse;
	private JLabel reponseText;
	private JButton backBtn;
	private ButtonGroup buttonGroup7 ;
	private ButtonGroup buttonGroup1 ;
	private ButtonGroup buttonGroup2 ;
	private ButtonGroup buttonGroup3 ;
	private ButtonGroup buttonGroup4 ;
	private ButtonGroup buttonGroup5 ;
	private ButtonGroup buttonGroup6 ;
	private ButtonGroup buttonGroup8 ;
	private String reponse;
	private JTextArea ReponseTf;
	private Patient patient;
	
	public Patient getPatient() {
		return patient;
	}


	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	
	
	public JTextArea getReponseTf() {
		return ReponseTf;
	}

	public void setReponseTf(JTextArea reponseTf) {
		ReponseTf = reponseTf;
	}

	private FormulaireCovid()  {
		createInstanceComponents();
		initComponents ();
	}

	private void createInstanceComponents() {
		paneltitre = new JPanel();
		lblNewLabel = new JLabel("TEST-COVID19");
		paneldestextes = new JPanel();
		q1 = new JLabel("Avez-vous de la fievre?");
		q2 = new JLabel("Avez-vous déja été en contact avec une personne atteint");
		q3 = new JLabel("Sentez-vous de la fatigue (essouflement)?");
		q4 = new JLabel("Avez vous une maladie respiratoire r\u00E9currente?");
		q5 = new JLabel("Toussez-vous fréquemment?");
		q6 = new JLabel("Avez-vous des difficultés respiratoires ?");
		q7 = new JLabel("Avez-vous 60 ans ou plus");
		q8 = new JLabel("Sentez vous des douleurs thoracique");
		btnSoumettre = new JButton("SOUMETTRE");
		panelsoumission = new JPanel();
		panelcase = new JPanel();
		oui1 = new JCheckBox("oui");
		non1 = new JCheckBox("non");
		oui2 = new JCheckBox("oui");
		non2 = new JCheckBox("non");
		oui3 = new JCheckBox("oui");
		non3 = new JCheckBox("non");
		oui4 = new JCheckBox("oui");
		non4 = new JCheckBox("non");
		oui5 = new JCheckBox("oui");
		non5 = new JCheckBox("non");
		oui6 = new JCheckBox("oui");
		non6 = new JCheckBox("non");
		oui7 = new JCheckBox("oui");
		non7 = new JCheckBox("non");
		oui8 = new JCheckBox("oui");
		non8 = new JCheckBox("non");
		panelreponse = new JPanel();
		reponseText = new JLabel("Reponses: \n" + reponse);
		backBtn = new JButton("quitter");
		buttonGroup7 = new ButtonGroup();
		buttonGroup8 = new ButtonGroup();
		buttonGroup1 = new ButtonGroup();
		buttonGroup2 = new ButtonGroup();
		buttonGroup3 = new ButtonGroup();
		buttonGroup4 = new ButtonGroup();
		buttonGroup5 = new ButtonGroup();
		buttonGroup6 = new ButtonGroup();
		ReponseTf = new JTextArea();
		
		
	}
	
	

	private void initComponents () {
		setResizable(false);
		setTitle("E-sante");
		setSize(new Dimension(700, 500));
		getContentPane().setLayout(null);

		
		paneltitre.setBackground(new Color(32, 178, 170));
		paneltitre.setBounds(10, 11, 664, 56);
		getContentPane().add(paneltitre);
		paneltitre.setLayout(null);

		
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.ITALIC, 30));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(231, 11, 198, 34);
		paneltitre.add(lblNewLabel);

		
		paneldestextes.setBackground(new Color(255, 255, 255));
		paneldestextes.setBounds(10, 78, 343, 372);
		getContentPane().add(paneldestextes);
		paneldestextes.setLayout(null);

		
		q1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		q1.setBounds(10, 11, 245, 23);
		paneldestextes.add(q1);

		
		q2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		q2.setBounds(6, 45, 331, 35);
		paneldestextes.add(q2);

		
		q3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		q3.setBounds(10, 101, 293, 23);
		paneldestextes.add(q3);

		
		q4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		q4.setBounds(10, 149, 293, 14);
		paneldestextes.add(q4);

		
		q5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		q5.setBounds(10, 190, 293, 43);
		paneldestextes.add(q5);

		
		q6.setFont(new Font("Tahoma", Font.PLAIN, 13));
		q6.setBounds(10, 235, 293, 35);
		paneldestextes.add(q6);

		
		q7.setFont(new Font("Tahoma", Font.PLAIN, 13));
		q7.setBounds(10, 291, 293, 35);
		paneldestextes.add(q7);

		
		q8.setFont(new Font("Tahoma", Font.PLAIN, 13));
		q8.setBounds(10, 338, 293, 23);
		paneldestextes.add(q8);

		
		panelsoumission.setBackground(new Color(32, 178, 170));
		panelsoumission.setBounds(492, 87, 182, 63);
		getContentPane().add(panelsoumission);
		panelsoumission.setLayout(null);

		
		btnSoumettre.setFont(new Font("Tw Cen MT", Font.BOLD | Font.ITALIC, 20));
		btnSoumettre.setBounds(10, 11, 162, 31);
		btnSoumettre.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(casCritique()) {
					
				}
				else if (casMiseEnQuarantaine()){
					
				}
				else {
					
				}
				
				
			}
			
		});
		panelsoumission.add(btnSoumettre);

		
		panelcase.setBackground(new Color(255, 255, 255));
		panelcase.setBounds(361, 78, 119, 372);
		getContentPane().add(panelcase);
		panelcase.setLayout(null);

		
		oui1.setBounds(6, 7, 53, 23);
		panelcase.add(oui1);

		
		non1.setBounds(61, 7, 59, 23);
		panelcase.add(non1);

		
		oui2.setBounds(6, 51, 53, 23);
		panelcase.add(oui2);
		

		
		non2.setBounds(61, 51, 59, 23);
		panelcase.add(non2);

		
		oui3.setBounds(6, 97, 53, 23);
		panelcase.add(oui3);

		
		non3.setBounds(61, 97, 59, 23);
		panelcase.add(non3);
		oui4.setBounds(6, 145, 53, 23);
		panelcase.add(oui4);

		
		non4.setBounds(61, 145, 59, 23);
		panelcase.add(non4);

		
		oui5.setBounds(6, 197, 53, 23);
		panelcase.add(oui5);

		
		non5.setBounds(61, 197, 59, 23);
		panelcase.add(non5);

		
		oui6.setBounds(6, 237, 53, 23);
		panelcase.add(oui6);

		
		non6.setBounds(61, 237, 59, 23);
		panelcase.add(non6);

		
		oui7.setBounds(6, 289, 53, 23);
		panelcase.add(oui7);

		
		non7.setBounds(61, 289, 59, 23);
		panelcase.add(non7);

		
		oui8.setBounds(6, 342, 53, 23);
		panelcase.add(oui8);

		
		non8.setBounds(61, 342, 59, 23);
		panelcase.add(non8);

		
		panelreponse.setBackground(new Color(255, 255, 255));
		panelreponse.setBounds(492, 150, 182, 266);
		getContentPane().add(panelreponse);
		panelreponse.setLayout(null);

		
		reponseText.setForeground(new Color(0, 128, 128));
		reponseText.setFont(new Font("Stencil", Font.ITALIC, 18));
		reponseText.setBounds(49, 11, 106, 28);
		panelreponse.add(reponseText);
		
		
		ReponseTf.setRows(10);
		ReponseTf.setBounds(6, 67, 183, 138);
		panelreponse.add(ReponseTf);

		
		backBtn.setBounds(492, 427, 182, 23);
		getContentPane().add(backBtn);
		
		buttonGroup1.add(oui1);
		buttonGroup1.add(non1);
		buttonGroup2.add(oui2);
		buttonGroup2.add(non2);
		buttonGroup3.add(oui3);
		buttonGroup3.add(non3);
		buttonGroup4.add(oui4);
		buttonGroup4.add(non4);
		buttonGroup5.add(oui5);
		buttonGroup5.add(non5);
		buttonGroup6.add(oui6);
		buttonGroup6.add(non6);
		buttonGroup7.add(oui7);
		buttonGroup7.add(non7);
		buttonGroup8.add(oui8);
		buttonGroup8.add(non8);
		
		Utilitaire.center(this, this.getSize());
		
	}
	public void run() {
		this.setVisible(true);
	}
	public static FormulaireCovid getInstances() {
		instances = new FormulaireCovid();
		return instances;
	}
	public boolean casCritique() {
		if(oui1.isSelected() && oui2.isSelected() && oui3.isSelected() && oui4.isSelected() && oui5.isSelected() && oui6.isSelected() && oui7.isSelected() && oui8.isSelected()) {
			return true ;
		}
		else {
			return false;
		}
	}
	public boolean casCritique1() {
		if(oui1.isSelected() && oui2.isSelected() && oui3.isSelected() && oui4.isSelected() && oui5.isSelected() && oui6.isSelected() && non7.isSelected() && oui8.isSelected()) {
			return true ;
		}
		else {
			return false;
		}
	}
	public boolean casMiseEnQuarantaine() {
		if(oui1.isSelected() && oui2.isSelected() && non3.isSelected() && non4.isSelected() && oui5.isSelected() && non6.isSelected() && non7.isSelected() && non8.isSelected()) {
			return true ;
		}
		else {
			return false;
		}
		
	}
	public void addBtnSoumettre(ActionListener actionListener) {
		btnSoumettre.addActionListener(actionListener);
	}
	public void addbackButton(ActionListener actionListener) {
		backBtn.addActionListener(actionListener);
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

	public String getReponse() {
		return reponse;
	}

	public void setReponse(String reponse) {
		this.reponse = reponse;
	}
}
