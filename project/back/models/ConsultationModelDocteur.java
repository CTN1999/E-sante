package project.back.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;

import project.back.Consultation;
import project.back.Docteur;
import project.back.Patient;
import project.back.StructureDeSante;
import project.back.methods.Metier;
import project.exceptions.DAOException;

public class ConsultationModelDocteur extends AbstractTableModel {
	private static final long serialVersionUID = 1L;
	public static final int OBJECT_COL = -1;
	private Vector<Object[]> rows = new Vector<>();
	private List<Consultation> consultations = new ArrayList<>();


	protected String[] columns = {"ID", "idPatient", "Nom Patient", "Date", "Nom Structure", "Valider", "effectuer"};
	@Override
	public int getRowCount() {

		return rows.size();
	}
	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return columns[column];
	}
	@Override
	public int getColumnCount() {

		return columns.length;
	}
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {
		case OBJECT_COL : return consultations.get(rowIndex);
		default : return rows.get(rowIndex)[columnIndex];
		}
	}

	public List<Consultation> getConsultations() {
		return consultations;
	}
	public void setConsultations(List<Consultation> consultations) throws DAOException {
		rows.clear();
		this.consultations.clear();
		this.consultations.addAll(0, consultations);
		for(Consultation consultation : consultations) {	
			try {
				String valider = "non";
				String effectuer = "non";
				Patient patient= Metier.rechercherPatient(consultation.getIdPatient());
				StructureDeSante structureDeSante= Metier.rechercherStructure(consultation.getIdStructure());
				if(consultation.getValider()) valider ="oui";
				if(consultation.getEffectuer()) effectuer = "oui";
				rows.add(new Object [] {
						consultation.getIdConsultation(),
						consultation.getIdPatient(),
						patient.getNom() + " " + patient.getPrenom(),
						consultation.getDateRv(),
						structureDeSante.getNom(),
						valider,
						effectuer

				});
				
			} catch (DAOException e) {
				throw new DAOException("ID introuvable dans la base de donnees");
			}

		}
		fireTableDataChanged();
	}
	public void delete(Consultation consultation ) {
		int indexOf = consultations.indexOf(consultation);
		consultations.remove(consultation);
		rows.remove(indexOf);

		fireTableDataChanged();
	}

	public void add(int idConsultation, int idPatient, int idStructure, int idDocteur,int idQualification, String dateRv, Boolean valider, Boolean effectuer) throws DAOException {
		Consultation consultation = new Consultation(idConsultation, idPatient, idStructure, idDocteur, idQualification, dateRv, valider, effectuer);
		consultations.add(consultation);
		try {
			String valider1 = "non";
			String effectuer1 = "non";
			Patient patient= Metier.rechercherPatient(consultation.getIdPatient());
			StructureDeSante structureDeSante= Metier.rechercherStructure(consultation.getIdStructure());
			if(consultation.getValider()) valider1 ="oui";
			if(consultation.getEffectuer()) effectuer1 = "oui";
			rows.add(new Object [] {
					consultation.getIdConsultation(),
					consultation.getIdPatient(),
					patient.getNom() + " " + patient.getPrenom(),
					consultation.getDateRv(),
					structureDeSante.getNom(),
					valider1,
					effectuer1

			});
			
		} catch (DAOException e) {
			throw new DAOException("ID introuvable dans la base de donnees");
		}
	}
	public void update(int idConsultation, int idPatient, int idStructure, int idDocteur,int idQualification, String dateRv, Boolean valider, Boolean effectuer) {
		Consultation consultation = new Consultation(idConsultation, idPatient, idStructure, idDocteur, idQualification, dateRv, valider, effectuer);
		int indexOf = consultations.indexOf(consultation);
		consultations.get(indexOf).setEffectuer(effectuer);
		Object [] obj = rows.get(indexOf);
		if(effectuer) obj[7] ="oui";
		else obj[7] ="non";
		
		
	}

	public void clear() {
		rows.clear();
		this.consultations.clear();

		fireTableDataChanged();
		
	}
}
