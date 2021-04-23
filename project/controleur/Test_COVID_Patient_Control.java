package project.controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import project.back.CasAlerte;
import project.back.Patient;
import project.back.methods.Authentification;
import project.back.methods.Metier;
import project.back.methods.ReponseTextCovid;
import project.back.models.ConsultationModelPatient;
import project.exceptions.DAOException;
import project.front.authAndIns.Fenetre_Authentification;
import project.front.espace.Espace_Patient;
import project.front.home.FormulaireCovid;

public class Test_COVID_Patient_Control {
	private Patient patient;
	private ReponseTextCovid modele;
	private FormulaireCovid vue;
	public Test_COVID_Patient_Control(Patient patient, ReponseTextCovid modele, FormulaireCovid vue) {
		
		this.patient = patient;
		this.modele = modele;
		this.vue = vue;
		addListeners();
	}
	public void launch() {
		vue.run();
	}
	private void addListeners() {
		vue.addBtnSoumettre(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(vue.casCritique() || vue.casCritique1()) {
					vue.informationMessage(modele.getCasCritique());
					
					try {
						CasAlerte cas = new CasAlerte(patient.getId());
						Metier.ajouterCasAlert(cas);
					} catch (DAOException e1) {
						vue.errorMessage(e1.getMessage());
					}
					
				}
				else if(vue.casMiseEnQuarantaine()) {
					vue.informationMessage(modele.getCasQuantaine());
				}
				else {
					vue.informationMessage(modele.normal());;

				}

			}});
		vue.addbackButton(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(vue.confirmationMessage("Voulez-vous retourner à la page d'acceuil")) {
					vue.dispose();
					Espace_Patient vue = Espace_Patient.getInstance();
					vue.setPatient(patient);
					vue.getTitrePatient().setText(patient.getPrenom() + " " + patient.getNom());
					ConsultationModelPatient modeleTable = new ConsultationModelPatient();
					Espace_Patient_Control  controleur = new Espace_Patient_Control(vue,modeleTable);
					controleur.launch();
					
					
									
				}

			}

		});
	}
	
}
