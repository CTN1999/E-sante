package project.controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import project.back.Patient;
import project.back.methods.Authentification;
import project.back.methods.Metier;
import project.back.models.ConsultationModelDocteur;
import project.back.models.ConsultationModelPatient;
import project.data.DAO.implement.PatientDao;
import project.exceptions.DAOException;
import project.front.authAndIns.Fenetre_Authentification;
import project.front.authAndIns.Fenetre_Inscription;
import project.front.espace.Espace_Patient;
import project.front.home.Home;

public class AuthControlPatient {
	private Authentification modele;
	private Fenetre_Authentification vue;
	public AuthControlPatient(Authentification modele, Fenetre_Authentification vue) {
		
		this.modele = modele;
		this.vue = vue;
		addListeners();
	}
	public void launch() {
		vue.run();
	}
	private void addListeners() {
		vue.addbackButton(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(vue.confirmationMessage("Voulez-vous retourner à la page d'acceuil")) {
					vue.dispose();
					Home home = Home.getInstance();
					home.run();
				}
				
			}
			
		});
		vue.addConnexion(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
						
						Patient patient =modele.verifierConnexionPatient(vue.getLoginTF(), vue.getPasswordField1());
						vue.dispose();
						Espace_Patient vue = Espace_Patient.getInstance();
						vue.setPatient(patient);
						vue.getTitrePatient().setText(patient.getPrenom() + " " + patient.getNom());
						ConsultationModelPatient modeleTable = new ConsultationModelPatient();
						Espace_Patient_Control  controleur = new Espace_Patient_Control(vue, modeleTable);
						controleur.launch();
						
					
				} catch (DAOException e1) {
					vue.errorMessage(e1.getMessage());
				}
				catch(Exception e2) {
					vue.errorMessage(e2.getMessage());
				}
			}
			
		});
		vue.addcreerCompteButton(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				vue.dispose();
				PatientDao modele = new PatientDao();
				Fenetre_Inscription vue = Fenetre_Inscription.getInstance();
				InscripPatientControl controleur = new InscripPatientControl(modele, vue);
				controleur.launch();
				
			}
			
		});
		
	}
	
}
