package project.controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import project.back.Patient;
import project.back.StructureDeSante;
import project.back.methods.Authentification;
import project.back.models.ConsultationModelStructure;
import project.data.DAO.implement.PatientDao;
import project.data.DAO.implement.StructureDeSanteDao;
import project.exceptions.DAOException;
import project.front.authAndIns.FInscription_structureSante;
import project.front.authAndIns.Fenetre_Authentification;
import project.front.authAndIns.Fenetre_Inscription;
import project.front.espace.Espace_Structure;
import project.front.home.Home;

public class AuthControlStructure {
	private Authentification modele;
	private Fenetre_Authentification vue;
	public AuthControlStructure(Authentification modele, Fenetre_Authentification vue) {
		
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
					
						StructureDeSante structureDeSante =modele.verifierConnexionStructure(vue.getLoginTF(), vue.getPasswordField1());
						vue.dispose();
						Espace_Structure vue = Espace_Structure.getInstance();
						vue.setStructureDeSante(structureDeSante);
						vue.getTitreStructure().setText(structureDeSante.getNom());
						ConsultationModelStructure modele = new ConsultationModelStructure();
						EspaceControlStructureSante controleur = new EspaceControlStructureSante(vue, modele);
						controleur.launch();
						
					
				} catch (DAOException e1) {
					vue.errorMessage(e1.getMessage());
				}
			}
			
		});
		vue.addcreerCompteButton(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				vue.dispose();
				StructureDeSanteDao modele = new StructureDeSanteDao();
				FInscription_structureSante vue = FInscription_structureSante.getInstance();
				InscriptionStructureControl controleur = new InscriptionStructureControl(vue, modele);
				controleur.launch();
				
			}
			
		});
		
	}
}
