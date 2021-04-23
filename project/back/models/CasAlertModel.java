package project.back.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;

import project.back.CasAlerte;
import project.back.Patient;
import project.back.methods.Metier;
import project.data.DAO.implement.EnumDao;
import project.exceptions.DAOException;

public class CasAlertModel extends AbstractTableModel{
	private static final long serialVersionUID = 1L;
	public static final int OBJECT_COL = -1;
	private Vector<Object[]> rows = new Vector<>();
	private List<CasAlerte> casAlertes = new ArrayList<>();
	private String[] columns = {"ID", "IDpatient", "Nom", "Prénom","Telephone","email", "Adresse","Login", "Password", "Localite"};

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
		case OBJECT_COL : return casAlertes.get(rowIndex);
		default : return rows.get(rowIndex)[columnIndex];
		}
	}

	public List<CasAlerte> getCasAlertes() {
		return casAlertes;
	}
	public void setCasAlertes(List<CasAlerte> casAlertes) throws DAOException {
		rows.clear();
		this.casAlertes.clear();
		this.casAlertes.addAll(0, casAlertes);
		for (CasAlerte cas : casAlertes ){
			Patient patient;
			try {
				patient = Metier.rechercherPatient(cas.getIdPatient());
			} catch (DAOException e) {
				throw new DAOException("La Liste des Cas alert est vide");
			}
			catch (Exception e) {
				throw new DAOException("La Liste des Cas alert est vide");
			}
			rows.add( new Object [] {
					cas.getIdCas(),
					patient.getId(),
					patient.getNom(),
					patient.getPrenom(),
					patient.getTel(),
					patient.getEmail(),
					patient.getAdresse(),
					patient.getLogin(),
					patient.getPassword(),
					EnumDao.rechercheLocalite(patient.getIdLocalite()),
					patient.getTel()			
			});
		}

		fireTableDataChanged();
	}

	public void delete(CasAlerte cas ) {
		int indexOf = casAlertes.indexOf(cas);
		casAlertes.remove(cas);
		rows.remove(indexOf);

		fireTableDataChanged();
	}

	public void clear() {
		rows.clear();
		this.casAlertes.clear();

		fireTableDataChanged();
	}
}
