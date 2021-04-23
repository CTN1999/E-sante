package project.controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import project.back.Consultation;
import project.back.Patient;
import project.back.Qualification;
import project.back.VaccinCovid;
import project.back.methods.Authentification;
import project.back.methods.Metier;
import project.back.methods.ReponseTextCovid;
import project.back.models.ConsultationModelPatient;
import project.data.DAO.implement.ConsultationDao;
import project.exceptions.DAOException;
import project.front.authAndIns.Fenetre_Authentification;
import project.front.espace.Espace_Patient;
import project.front.home.FormulaireCovid;
import project.front.home.Home;

public class Espace_Patient_Control {
	private Espace_Patient vue = Espace_Patient.getInstance();
	private ConsultationModelPatient modeleTable;
	public Espace_Patient_Control(Espace_Patient vue,ConsultationModelPatient modeleTable) {
		this.vue = vue;
		this.modeleTable = modeleTable;
		addListeners();
	}
	private int idStructure;

	public void launch() {
		vue.run();
	}
	private void addListeners() {

		vue.addbackButton(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(vue.confirmationMessage("Voulez-vous vraiment quitter ! ")) {
					vue.dispose();
					Home home = Home.getInstance();
					home.run();
				}
			}



		});

		vue.addCovid(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				vue.dispose();
				ReponseTextCovid modele = new ReponseTextCovid();
				FormulaireCovid vue = FormulaireCovid.getInstances();
				Patient patient = Espace_Patient_Control.this.vue.getPatient();
				Test_COVID_Patient_Control controleur = new Test_COVID_Patient_Control(patient, modele, vue);
				controleur.launch();


			}
		});
		vue.addBtnMessage(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				listerConsultation();		
			}
		});
		vue.addBtnDemander(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				try {
					int idPatient = vue.getPatient().getId();
					int idQualification =(Qualification.valueOf(vue.getQualification()).ordinal() + 1);
					Consultation consultation = new Consultation(idPatient, idStructure, 0, idQualification, "", false, false);
					ConsultationDao dao = new ConsultationDao();
					dao.create(consultation);
					listerConsultation();
					vue.informationMessage("Demande effectuer avec succée !!");


				} catch (DAOException e1) {
					vue.errorMessage(e1.getMessage());
				}


			}
		});

		vue.addVaccin(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(vue.confirmationMessage("Voulez-vous vraiment vous inscrire ?")) {
					VaccinCovid vaccinCovid = new VaccinCovid(vue.getPatient().getId());
					try {
						Metier.ajouterPatientVaccin(vaccinCovid);
					} catch (DAOException e1) {
						vue.errorMessage(e1.getMessage());
					}
				}

			}
		});
		vue.addSelectQualification(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				vue.setQualification(vue.getChoixQualification().getSelectedItem().toString());

			}
		});
		vue.addSelectStructure(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				idStructure = vue.getListStructure().getSelectedIndex() + 1;				
			}
		});

	}
	private void listerConsultation() {
		try {
			int id = vue.getPatient().getId();
			modeleTable.setConsultations(Metier.listerConsultationPatient(id));
			vue.getTable().setModel(modeleTable);
		} catch (DAOException e1) {
			vue.errorMessage(e1.getMessage());
		}

	}

}
