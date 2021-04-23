package project.front.home;

import javax.swing.JFrame;
import javax.swing.JPanel;

import project.back.methods.Authentification;
import project.back.methods.ReponseTextCovid;
import project.back.untils.Utilitaire;
import project.controleur.AuthControlAdmin;
import project.controleur.AuthControlDocteur;
import project.controleur.AuthControlPatient;
import project.controleur.AuthControlStructure;
import project.controleur.TextCovidControl;
import project.front.authAndIns.Fenetre_Authentification;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import java.awt.Dimension;

public class Home extends JFrame {
	private static Home instance;
	private JLabel home;
	private JLabel btnpatient;
	private JLabel btnDoc;
	private JLabel btnStructure;
	private JLabel btnAdmin;
	private JLabel quitter;
	private JLabel textCovid;
	private JPanel panel;
	private JLabel lblNewLabel;
	private Home() {
		
		createInstanceComponents();
		initComponents ();
	}
	private void initComponents() {
		setSize(new Dimension(700, 500));
		setResizable(false);
		
		
		panel.setBackground(new Color(0, 128, 128));
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		
		lblNewLabel.setForeground(new Color(240, 255, 255));
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 47));
		lblNewLabel.setBounds(233, 6, 320, 63);
		panel.add(lblNewLabel);
		
		
		home.setToolTipText("Home");
		home.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		home.setIcon(new ImageIcon("/Users/cheikh/eclipse-workspace/E-sante/image/icone/home_243.png"));
		home.setBounds(218, 81, 300, 257);
		panel.add(home);
		
		
		btnpatient.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				redirectionPatient();
			}
		});
		btnpatient.setIcon(new ImageIcon("/Users/cheikh/eclipse-workspace/E-sante/image/icone/patient.png"));
		btnpatient.setBounds(22, 331, 101, 112);
		panel.add(btnpatient);
		
		
		btnDoc.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				redirectionDocteur();
			}
		});
		btnDoc.setIcon(new ImageIcon("/Users/cheikh/eclipse-workspace/E-sante/image/icone/docteur.png"));
		btnDoc.setBounds(127, 331, 94, 112);
		panel.add(btnDoc);
		
		
		btnStructure.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				redirectionStructure();
			}
		});
		btnStructure.setIcon(new ImageIcon("/Users/cheikh/eclipse-workspace/E-sante/image/icone/medical.png"));
		btnStructure.setBounds(228, 350, 107, 93);
		panel.add(btnStructure);
		
		
		btnAdmin.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				redirectionAdmin();
			}
		});
		btnAdmin.setIcon(new ImageIcon("/Users/cheikh/eclipse-workspace/E-sante/image/icone/Administrator.png"));
		btnAdmin.setBounds(363, 331, 101, 112);
		panel.add(btnAdmin);
		
		
		quitter.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if(Utilitaire.ConfirmMessage("Voulez vous vraiment quitter E-sante ?")) {
					dispose();
				}
			}
		});
		quitter.setIcon(new ImageIcon("/Users/cheikh/eclipse-workspace/E-sante/image/icone/quitter.png"));
		quitter.setBounds(589, 350, 94, 93);
		panel.add(quitter);
		
		
		textCovid.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				redirectionTextCovid();
			}
		});
		textCovid.setIcon(new ImageIcon("/Users/cheikh/eclipse-workspace/E-sante/image/icone/textCovid.png"));
		textCovid.setBounds(476, 331, 101, 100);
		panel.add(textCovid);
		Utilitaire.center(this, this.getSize());
		
	}
	private void createInstanceComponents() {
		panel = new JPanel();
		home = new JLabel("");
		lblNewLabel = new JLabel("E-SANTE");
		btnpatient = new JLabel("");
		btnpatient.setToolTipText("Patient");
		btnDoc = new JLabel("");
		btnDoc.setToolTipText("Docteur");
		btnStructure = new JLabel("");
		btnStructure.setToolTipText("Structure De Sante");
		btnAdmin = new JLabel("");
		btnAdmin.setToolTipText("Administrateur");
		quitter = new JLabel("");
		quitter.setToolTipText("Quitter");
		textCovid = new JLabel("");
		textCovid.setToolTipText("Faire Test Covid-19");
	}
	public void run() {
		this.setVisible(true);
	}
	public void redirectionPatient() {
		Fenetre_Authentification vue = Fenetre_Authentification.getInstance();
		Authentification modele = new Authentification();
		AuthControlPatient controleur = new AuthControlPatient(modele, vue) ;
		controleur.launch();
		dispose();
	}
	public void redirectionTextCovid() {
		ReponseTextCovid modele = new ReponseTextCovid();
		FormulaireCovid vue = FormulaireCovid.getInstances();
		TextCovidControl controleur = new TextCovidControl(modele, vue);
		controleur.launch();
		dispose();
		
	}
	public void redirectionStructure() {
		Fenetre_Authentification vue = Fenetre_Authentification.getInstance();
		Authentification modele = new Authentification();
		AuthControlStructure controleur = new AuthControlStructure(modele, vue);
		controleur.launch();
		dispose();
	}
	public void redirectionDocteur() {
		Fenetre_Authentification vue = Fenetre_Authentification.getInstance();
		Authentification modele = new Authentification();
		AuthControlDocteur controleur = new AuthControlDocteur(modele, vue);
		controleur.launch();
		dispose();
	}
	public void redirectionAdmin() {
		Fenetre_Authentification vue = Fenetre_Authentification.getInstance();
		Authentification modele = new Authentification();
		AuthControlAdmin controleur = new AuthControlAdmin(modele, vue);
		controleur.launch();
		dispose();
	}
	public  static Home getInstance() {
		instance = new Home();
		return instance;
	}
}
