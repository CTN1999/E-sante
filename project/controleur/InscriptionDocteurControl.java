package project.controleur;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import project.back.Docteur;
import project.back.Qualification;
import project.back.StructureDeSante;
import project.back.methods.Authentification;
import project.back.methods.Metier;
import project.back.models.ConsultationModelStructure;
import project.data.DAO.implement.DocteurDao;
import project.exceptions.DAOException;
import project.front.authAndIns.Fenetre_Authentification;
import project.front.authAndIns.Inscription_Docteur;
import project.front.espace.Espace_Structure;

public class InscriptionDocteurControl {
	private DocteurDao modele;
	private Inscription_Docteur vue;
	private int idStructure;
	public InscriptionDocteurControl(DocteurDao modele, Inscription_Docteur vue) {
		
		this.modele = modele;
		this.vue = vue;
		addListeners();
	}
	private void addListeners() {
		vue.addbackButton(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(vue.confirmationMessage("Voulez-vous retourner a votre espace personnel !")) {
					vue.dispose();
					Espace_Structure vue = Espace_Structure.getInstance();
					try {
						vue.setStructureDeSante(Metier.rechercherStructure(idStructure));
						vue.getTitreStructure().setText(vue.getStructureDeSante().getNom());
						ConsultationModelStructure modele = new ConsultationModelStructure();
						vue.viewDocteur();
						EspaceControlStructureSante controleur = new EspaceControlStructureSante(vue, modele);
						controleur.launch();
					} catch (DAOException e1) {
						vue.errorMessage(e1.getMessage());
					}
					
					
				
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
					int idQualification = (Qualification.valueOf(vue.getQualificationTF()).ordinal() + 1);
					Docteur docteur = new Docteur(nom, prenom, email, adresse, tel, dateDeNaissance, login, password, idQualification,idStructure);
					modele.create(docteur);
					vue.clear();
					vue.informationMessage("Inscription reussi");
				} catch (DAOException e2) {
					vue.errorMessage(e2.getMessage());
				}
				
			}
		});
		vue.addSelectQualification(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				vue.setQualificationTF(vue.getQualification().getSelectedItem().toString());
				
			}
		});
		
	}
	public void launch() {
		vue.run();
	}
	public int getIdStructure() {
		return idStructure;
	}
	public void setIdStructure(int idStructure) {
		this.idStructure = idStructure;
	}
}
