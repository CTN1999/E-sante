package project.back.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;

import project.back.Patient;
import project.back.VaccinCovid;
import project.back.methods.Metier;
import project.data.DAO.implement.EnumDao;
import project.exceptions.DAOException;

public class VaccinModel extends AbstractTableModel {
	private static final long serialVersionUID = 1L;
	public static final int OBJECT_COL = -1;
	private Vector<Object[]> rows = new Vector<>();
	private List<VaccinCovid> listVaccins = new ArrayList<>();
	private String[] columns = {"ID", "IDpatient", "Nom", "Prénom", "tel","email", "Adresse", "Login", "Password","Localite"};

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
		case OBJECT_COL : return listVaccins.get(rowIndex);
		default : return rows.get(rowIndex)[columnIndex];
		}
	}

	public List<VaccinCovid> getListVaccins() {
		return listVaccins;
	}
	public void setListVaccins(List<VaccinCovid> listVaccins) throws DAOException {
		rows.clear();
		this.listVaccins.clear();
		this.listVaccins.addAll(0, listVaccins);
		for (VaccinCovid listvaccin : listVaccins ){
			Patient patient;
			try {
				patient = Metier.rechercherPatient(listvaccin.getIdPatient());
			} catch (DAOException e) {
				throw new DAOException("Liste Patient voulant le vaccin vide");
			}
			rows.add( new Object [] {
					listvaccin.getIdVaccin(),
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

	public void delete(VaccinCovid vaccinCovid) {
		int indexOf = listVaccins.indexOf(vaccinCovid);
		listVaccins.remove(vaccinCovid);
		rows.remove(indexOf);

		fireTableDataChanged();
	}

	public void clear() {
		rows.clear();
		this.listVaccins.clear();

		fireTableDataChanged();
	}
}
