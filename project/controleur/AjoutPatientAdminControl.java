package project.controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import project.back.Localite;
import project.back.Patient;
import project.back.methods.Authentification;
import project.back.methods.Metier;
import project.data.DAO.implement.PatientDao;
import project.exceptions.DAOException;
import project.front.authAndIns.Fenetre_Authentification;
import project.front.authAndIns.Fenetre_Inscription;
import project.front.espace.Espace_Admin;

public class AjoutPatientAdminControl {
	private PatientDao modele;
	private Fenetre_Inscription vue;
	public AjoutPatientAdminControl(PatientDao modele, Fenetre_Inscription vue) {
		
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
				if(vue.confirmationMessage("Voulez-vous retourner à votre page Administrateur")) {
					vue.dispose();
					Espace_Admin vue = Espace_Admin.getInstance();
					Metier modele = new Metier();
					EspaceAdminControl controleur = new EspaceAdminControl(vue, modele);
					controleur.launch();
					
				}

			}

		});
		vue.addcreerCompteButton(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				try {
					String nom = vue.getNomTf();
					String prenom = vue.getPrenomTf();
					String email = vue.getEmailTf();
					String adresse = vue.getAdresseTf();
					int tel = vue.getTelephoneTf();
					String dateDeNaissance = vue.getDateNaissanceTf();
					String login = vue.getLoginTF();
					String password = vue.getPasswordField1();
					int idLocalite = (Localite.valueOf(vue.getLocaliteTF()).ordinal() + 1);
					Patient patient = new Patient(nom, prenom, email, adresse, tel, dateDeNaissance, login, password, idLocalite);
					modele.create(patient);
					vue.clear();
					vue.informationMessage("Inscription reussi");
				} catch (DAOException e1) {
					vue.errorMessage(e1.getMessage());
				}



			}

		});
		vue.addSelectLocalite(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				vue.setLocaliteTF(vue.getLocalite().getSelectedItem().toString());


			}

		});
	}
	
}
