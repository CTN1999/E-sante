package project.controleur;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import project.back.Consultation;
import project.back.Docteur;
import project.back.Patient;
import project.back.methods.Metier;
import project.back.models.CasAlertModel;
import project.back.models.ConsultationModelStructure;
import project.back.models.DocteurModel;
import project.back.models.VaccinModel;
import project.data.DAO.implement.DocteurDao;
import project.exceptions.DAOException;
import project.front.authAndIns.Inscription_Docteur;
import project.front.espace.Espace_Structure;
import project.front.home.Home;

public class EspaceControlStructureSante {
	private Espace_Structure vue;

	private ConsultationModelStructure modeleConsultation;

	public void launch() {
		vue.run();
	}

	public EspaceControlStructureSante(Espace_Structure vue, ConsultationModelStructure modeleConsultation) {

		this.vue = vue;
		this.modeleConsultation = modeleConsultation;
		addListeners();
	}

	private void addListeners() {
		vue.listDocteur(vue.getStructureDeSante().getId());
		vue.addAfficheDocteur(new ActionListener() {


			@Override
			public void actionPerformed(ActionEvent e) {
				vue.viewDocteur();
				listerDocteur();

			}
		});
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
		vue.addVoirInfoPatient(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(vue.getSelectConsultation()>=0) {

					try {
						Patient patient = Metier.rechercherPatient(vue.getModeleConsultation().getConsultations().get(vue.getSelectConsultation()).getIdPatient());
						vue.informationMessage(patient.display());
						
					} catch (DAOException e1) {
						vue.errorMessage(e1.getMessage());
					}


				}
			}
		});
		vue.addAfficherCasAlert(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				vue.viewCasAlert();
				try {
					vue.getModeleCasAlert().setCasAlertes(Metier.listerCasAlert());
				} catch (DAOException e1) {
					vue.errorMessage(e1.getMessage());
					
				}


			}
		});
		vue.addAfficherListeVaccin(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				vue.viewVaccin();
				try {
					vue.getModeleVaccin().setListVaccins(Metier.listerVaccin());
				} catch (DAOException e1) {
					vue.errorMessage(e1.getMessage());				
					}

			}
		});
		vue.addAfficherRV(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				vue.vieuwConsultation();
				afficherRv();
				

			}
		});
		vue.addBtnModifierDocteur(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				vue.viewDocteurUpdate();

			}
		});
		vue.addSupprimerDocteur(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(vue.getSelectDocteur()>=0) {
					try {
						Metier.supprimerDocteur(vue.getModeleDoc().getDocteurs().get(vue.getSelectDocteur()).getId());
						listerDocteur();
					} catch (DAOException e1) {
						vue.errorMessage(e1.getMessage());
					}
				}
				else {
					vue.errorMessage("Vous n'avez pas selectionné un docteur");
				}

			}
		});
		vue.addAjouterDocteur(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				vue.dispose();
				Inscription_Docteur vue = Inscription_Docteur.getInstance();
				DocteurDao modele = new DocteurDao();
				InscriptionDocteurControl controleur = new InscriptionDocteurControl(modele, vue);
				controleur.setIdStructure(EspaceControlStructureSante.this.vue.getStructureDeSante().getId());
				controleur.launch();

			}
		});

		vue.addRechercheDocteur(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {


				try {
					List<Docteur> docteurs = new ArrayList<>();
					docteurs.add(Metier.rechercherDocteur(vue.getRechercherTf(),vue.getStructureDeSante().getId()));
					vue.getModeleDoc().setDocteurs(docteurs);

				} catch (DAOException e1) {
					vue.errorMessage(e1.getMessage());
				}
				catch (Exception e1) {
					vue.errorMessage("L'Id docteur est introuvable");
				}

			}
		});

		vue.addBtnModifierDocteur(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				vue.viewDocteurUpdate();

			}
		});

		vue.addBtnValiderModifDocteur(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Docteur docteur = Metier.rechercherDocteur(vue.getModeleDoc().getDocteurs().get(vue.getSelectDocteur()).getId());
					docteur.setAdresse(vue.getAdresseTf());
					docteur.setLogin(vue.getLoginTF());
					docteur.setPassword(vue.getPasswordField1());
					docteur.setTel(vue.getTelephoneTf());
					Metier.modifierDocteur(docteur);
					vue.informationMessage("Modification Reussi !");
					vue.viewDocteur();
				} catch (DAOException e2) {
					vue.errorMessage(e2.getMessage());
				}

			}
		});

		vue.addBackDocteur(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				vue.viewDocteur();
				listerDocteur();

			}
		});
		vue.getTableDocteur().getSelectionModel().addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				vue.setSelectDocteur(vue.getTableDocteur().getSelectedRow());

			}
		});
		vue.addSelectDocteur(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				vue.setSelectCombo(vue.getComboBox().getSelectedIndex());

			}
		});
		vue.getTableConsultation().getSelectionModel().addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				vue.setSelectConsultation(vue.getTableConsultation().getSelectedRow());

			}
		});
		vue.addValiderConsultation(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(vue.getSelectConsultation()>=0) {

					try {
						Consultation consultation = Metier.rechercherConsultation(vue.getModeleConsultation().getConsultations().get(vue.getSelectConsultation()).getIdConsultation());
						consultation.setDateRv(vue.getDateTf());
						consultation.setValider(true);
						List<Docteur> docteurs = new ArrayList<>();
						docteurs = Metier.listerDocteur(vue.getStructureDeSante().getId());						
						consultation.setIdDocteur(docteurs.get(vue.getSelectCombo()).getId());
						
						Metier.modifierConsultation(consultation);
						afficherRv();
					} catch (DAOException e1) {
						vue.errorMessage(e1.getMessage());
					}


				}
			}
		});


	}
	public void listerDocteur() {
		try {
			vue.getModeleDoc().setDocteurs(Metier.listerDocteur(vue.getStructureDeSante().getId()));
		} catch (DAOException e1) {
			vue.errorMessage(e1.getMessage());
		}
	}
	public void afficherRv() {
		try {
			vue.getModeleConsultation().setConsultations(Metier.listerConsultationStructure(vue.getStructureDeSante().getId()));
			
		} catch (DAOException e1) {
			vue.errorMessage(e1.getMessage());
		};
	}
	

}
