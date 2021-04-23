package project.controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import project.back.Localite;
import project.back.Patient;
import project.back.Qualification;
import project.back.StructureDeSante;
import project.back.methods.Authentification;
import project.data.DAO.implement.DocteurDao;
import project.data.DAO.implement.StructureDeSanteDao;
import project.exceptions.DAOException;
import project.front.authAndIns.FInscription_structureSante;
import project.front.authAndIns.Fenetre_Authentification;
import project.front.home.Home;

public class InscriptionStructureControl {
	private FInscription_structureSante vue;
	private StructureDeSanteDao modele;
	
	public InscriptionStructureControl(FInscription_structureSante vue, StructureDeSanteDao modele) {
		this.vue = vue;
		this.modele = modele;
		addListeners();
	}
	public void launch() {
		vue.run();
	}
	private void addListeners() {
		
		vue.addbackButton(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(vue.confirmationMessage("Voulez-vous retourner à la page de d'acceuil")) {
					vue.dispose();
					Fenetre_Authentification vue = Fenetre_Authentification.getInstance();
					Authentification modele = new Authentification();
					AuthControlStructure controleur = new AuthControlStructure(modele, vue);
					controleur.launch();
				}
				
			}
			
		});
		vue.addcreerCompteButton(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					String nom = vue.getNomTf();
					
					String email = vue.getEmailTf();
					String adresse = vue.getAdresseTf();
					int tel = vue.getTelephoneTf();
					
					String login = vue.getLoginTF();
					String password = vue.getmdpTf1();
					int idLocalite = (Localite.valueOf(vue.getLocaliteTF()).ordinal() + 1);
					StructureDeSante structureDeSante = new StructureDeSante(nom, email, tel, adresse, idLocalite, login, password);
					modele.create(structureDeSante);
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
