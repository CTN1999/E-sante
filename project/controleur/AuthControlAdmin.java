package project.controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import project.back.Admin;
import project.back.Docteur;
import project.back.methods.Authentification;
import project.back.methods.Metier;
import project.exceptions.DAOException;
import project.front.authAndIns.Fenetre_Authentification;
import project.front.espace.Espace_Admin;
import project.front.home.Home;

public class AuthControlAdmin {
	private Authentification modele;
	private Fenetre_Authentification vue;
	public AuthControlAdmin(Authentification modele, Fenetre_Authentification vue) {
		
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
					
						Admin admin =modele.verifierConnexionAdmin(vue.getLoginTF(), vue.getPasswordField1());
						AuthControlAdmin.this.vue.dispose();
						Espace_Admin vue = Espace_Admin.getInstance();
						Metier modele = new Metier();
						
						EspaceAdminControl con = new EspaceAdminControl(vue, modele);
						con.launch();
						
					
				} catch (DAOException e1) {
					vue.errorMessage(e1.getMessage());
				}
			}
			
		});
		
		
	}
}
