package project.controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import project.back.CasAlerte;
import project.back.Patient;
import project.back.methods.Metier;
import project.back.methods.ReponseTextCovid;
import project.exceptions.DAOException;
import project.front.home.FormulaireCovid;
import project.front.home.Home;

public class TextCovidControl {
	private ReponseTextCovid modele;
	private FormulaireCovid vue;
	

	public TextCovidControl(ReponseTextCovid modele, FormulaireCovid vue) {

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
				if(vue.casCritique()) {
					vue.informationMessage(modele.getCasCritique());
					
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
					
						Home home = Home.getInstance();
						home.run();			
				}

			}

		});

	}

	

}
