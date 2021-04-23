package project.controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import project.back.Docteur;
import project.back.methods.Authentification;
import project.back.models.ConsultationModelDocteur;
import project.exceptions.DAOException;
import project.front.authAndIns.Fenetre_Authentification;
import project.front.espace.Espace_Docteur;
import project.front.home.Home;

public class AuthControlDocteur {
	private Authentification modele;
	private Fenetre_Authentification vue;
	public AuthControlDocteur(Authentification modele, Fenetre_Authentification vue) {
		
		this.modele = modele;
		this.vue = vue;
		addListeners();
		vue.getCreerCompteButton().setVisible(false);
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
						
						Docteur docteur =modele.verifierConnexionDocteur(vue.getLoginTF(), vue.getPasswordField1());
						vue.dispose();
						Espace_Docteur vue = Espace_Docteur.getInstance();
						vue.setDocteur(docteur);
						vue.getTitreDocteur().setText(docteur.getPrenom() + " " + docteur.getNom());
						ConsultationModelDocteur modele = new ConsultationModelDocteur();
						Espace_Docteur_Control controleur = new Espace_Docteur_Control(vue, modele);
						controleur.launch();
					
				} catch (DAOException e1) {
					vue.errorMessage(e1.getMessage());
				}
			}
			
		});
		
		
	}
}
