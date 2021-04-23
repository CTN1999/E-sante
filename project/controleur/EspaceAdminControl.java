package project.controleur;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import project.back.Admin;
import project.back.Docteur;
import project.back.Patient;
import project.back.StructureDeSante;
import project.back.methods.Metier;
import project.data.DAO.implement.PatientDao;
import project.data.DAO.implement.StructureDeSanteDao;
import project.exceptions.DAOException;
import project.front.authAndIns.FInscription_structureSante;
import project.front.authAndIns.Fenetre_Inscription;
import project.front.espace.Espace_Admin;
import project.front.home.Home;

public class EspaceAdminControl {
	private Espace_Admin vue;
	private Metier modele;
	public EspaceAdminControl(Espace_Admin vue, Metier modele) {

		this.vue = vue;
		this.modele = modele;
		addListeners();
	}
	private void addListeners() {
		vue.addBtnLister(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(vue.getIdObserver()) {
					try {
						vue.getModeleStrucure().setStructureDeSante(modele.listerStructure());
					} catch (DAOException e1) {
						vue.errorMessage(e1.getMessage());
					}
				}
				else {
					try {
						vue.getModelePatient().setPatient(modele.listerPatient());
					} catch (DAOException e1) {
						// TODO Auto-generated catch block
						vue.errorMessage(e1.getMessage());
					}
				}

			}
		});
		vue.addBtnValider(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					Admin admin = Metier.rechercherAdmin(1);
					if(admin.getPassword().equals(vue.getPasswordField()) ) {
						admin.setPassword(vue.getPasswordField1());
						modele.modifierAdmin(admin);
						vue.informationMessage("Modification mot de passe reussi!");
						vue.clear();
					}
					else {
						throw new DAOException("L'Ancien mot de passe que vous avez saisie est incorrect");
					}
					
				} catch (DAOException e1) {
					vue.errorMessage(e1.getMessage());
				}
			}
		});
		vue.addBtnModifierUser(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					int tel = vue.getTelTf();
					String email = vue.getEmailTf();
					String adresse = vue.getAdresseTf();
					String login = vue.getLoginTf();
					String password = vue.getPasswordFieldModif();
					if(!vue.getIdObserver()) {
						if(vue.getIdSelectPatient() == -1) throw new DAOException("Vous n'avez selectionne aucun  patient");
						Patient patient= modele.listerPatient().get(vue.getIdSelectPatient());
						if(tel != 0) patient.setTel(tel);
						if(email != null) patient.setEmail(email);
						if(adresse != null) patient.setAdresse(adresse);
						if(login != null) patient.setLogin(login);
						if(password != null) patient.setPassword(password);
						vue.errorMessage(" "+patient.getId());
						modele.modifierPatient(patient);
						vue.informationMessage("modification reussi");
						vue.vieuwPatient();
					}else {
						if(vue.getIdSelectStructure() == -1) throw new DAOException("Vous n'avez selectionne aucun  patient");
						StructureDeSante structureDeSante = modele.listerStructure().get(vue.getIdSelectStructure());
						if(tel != 0) structureDeSante.setTel(tel);
						if(email != null) structureDeSante.setEmail(email);
						if(adresse != null) structureDeSante.setAdresse(adresse);
						if(login != null) structureDeSante.setLogin(login);
						if(password != null) structureDeSante.setPassword(password);
						modele.modifierStructure(structureDeSante);
						vue.informationMessage("modification reussi");
						vue.vieuwStructure();
						vue.clearModif();
					}
				} catch (DAOException e1) {
					vue.errorMessage(e1.getMessage());
				}
				catch (Exception e1) {
					vue.errorMessage(e1.getMessage());
				}
				
				
			}
		});
		
		vue.addBtnModifier(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				vue.vieuwModif();
				
				
			}
		});
		vue.addBtnAjouter(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!vue.getIdObserver()) {
					try {
						vue.dispose();
						PatientDao modele = new PatientDao();
						Fenetre_Inscription vue = Fenetre_Inscription.getInstance();
						AjoutPatientAdminControl controleur = new AjoutPatientAdminControl(modele, vue);
						controleur.launch();
					} catch (Exception e2) {
						vue.errorMessage(e2.getMessage());
					}
				}else {
					vue.dispose();
					StructureDeSanteDao modele = new StructureDeSanteDao();
					FInscription_structureSante vue = FInscription_structureSante.getInstance();
					AjoutStructureAdminControl controleur = new AjoutStructureAdminControl(vue, modele);
					controleur.launch();
				}
					
				
			}
		});
		
		vue.addBtnSupprimer(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(vue.confirmationMessage("Voulez vous vraiment supprimer ce utilisateur ?")) {
					try {
						if(vue.getIdObserver()) {
							if(vue.getIdSelectStructure()<0) vue.errorMessage("Aucun champ n'a ete selectionne"); 
							else {
								Metier.supprimerStructure(vue.getModeleStrucure().getstructureDeSante().get(vue.getIdSelectStructure()).getId());
							}
							
						}
						else {
							if(vue.getIdSelectPatient()<0) vue.errorMessage("Aucun champ n'a ete selectionne"); 
							else {
								Metier.supprimerPatient(vue.getModelePatient().getDocteurs().get(vue.getIdSelectPatient()).getId());
							}
							
						}
					} catch (Exception e2) {
						vue.errorMessage(e2.getMessage());
					}
					
				}
				

			}
		});
		vue.addBtnModifierMdp(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				vue.vieuwChange();
				
				
			}
		});
		vue.addBtnQuitter(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(vue.confirmationMessage("Voulez-vous vraiment quitter ! ")) {
					vue.dispose();
					Home home = Home.getInstance();
					home.run();
				}
				
			}
		});
		vue.addBtnRechercher(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if(vue.getIdObserver()) {
						List<StructureDeSante> structures = new ArrayList<>();
						structures.add(Metier.rechercherStructure(vue.getRechercherTf()));
						vue.getModeleStrucure().setStructureDeSante(structures);
					}
					else {
						List<Patient> patients = new ArrayList<>();
						patients.add(Metier.rechercherPatient(vue.getRechercherTf()));
						vue.getModelePatient().setPatient(patients);
					}
					

				} catch (Exception e2) {
					vue.errorMessage("ID introuvable");
				}

			}
		});

		vue.addBtnStructure(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				vue.vieuwStructure();

			}
		});
		vue.addBtnPatient(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				vue.vieuwPatient();
			}
		});
		vue.getTableStructure().getSelectionModel().addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				vue.setIdSelectStructure(vue.getTableStructure().getSelectedRow());

			}
		});
		vue.getTablePatient().getSelectionModel().addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				vue.setIdSelectPatient(vue.getTablePatient().getSelectedRow());

			}
		});

	}
	public void launch() {
		vue.run();
	}

}
