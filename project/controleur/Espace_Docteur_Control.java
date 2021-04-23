package project.controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import project.back.Consultation;
import project.back.methods.Authentification;
import project.back.methods.Metier;
import project.back.models.ConsultationModelDocteur;
import project.exceptions.DAOException;
import project.front.authAndIns.Fenetre_Authentification;
import project.front.espace.Espace_Docteur;
import project.front.home.Home;

public class Espace_Docteur_Control {
	private Espace_Docteur vue;
	private ConsultationModelDocteur modele;
	private int indexof;
	public Espace_Docteur_Control(Espace_Docteur vue, ConsultationModelDocteur modele) {

		this.vue = vue;
		this.modele = modele;
		addListeners();
	}
	private void addListeners() {
		vue.addBtnLister(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				listerConsultation();

			}
		});
		
		vue.getTable().getSelectionModel().addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				indexof = vue.getTable().getSelectedRow();

			}
		});

		vue.addBtnSupprimer(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(indexof >= 0) {
					try {
						Metier.supprimerConsultation(modele.getConsultations().get(indexof).getIdConsultation());
					} catch (DAOException e1) {
						vue.errorMessage(e1.getMessage());
					}
					listerConsultation();
				}
				else {
					vue.errorMessage("Aucune consultation n'a été sélectionné");
				}

				
			}
		});
		vue.addBtnEffectuer(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(indexof>=0) {


					try {
						Consultation consult =modele.getConsultations().get(indexof);
						consult.setEffectuer(true);
						Metier.modifierConsultation(consult);
					} catch (DAOException e1) {
						vue.errorMessage(e1.getMessage());
					}
					listerConsultation();
				}
				else {
					vue.errorMessage("Aucune consultation n'a été sélectionné");
				}
				modele.fireTableDataChanged();


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
	}
	public void launch() {
		vue.run();
	}
	private void listerConsultation() {
		try {

			int id = vue.getDocteur().getId();
			modele.setConsultations(Metier.listerConsultationDocteur(id));
			vue.getTable().setModel(modele);
		} catch (DAOException e1) {
			vue.errorMessage(e1.getMessage());
		}catch (Exception e2) {
			vue.errorMessage(e2.getMessage());
		}
	}

}
