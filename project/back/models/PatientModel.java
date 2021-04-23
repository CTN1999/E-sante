package project.back.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;

import project.back.Patient;
import project.data.DAO.implement.EnumDao;
import project.exceptions.DAOException;

public class PatientModel extends AbstractTableModel {
	private static final long serialVersionUID = 1L;
	public static final int OBJECT_COL = -1;
	private Vector<Object[]> rows = new Vector<>();
	private List<Patient> patients = new ArrayList<>();
	
	private String[] columns = {"ID", "Nom", "Prénom","email", "Adresse","Telephone", "Login", "Password","Localite"};

	@Override
	public int getColumnCount() {
		
		return columns.length;
	}
	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return columns[column];
	}

	@Override
	public int getRowCount() {
		return rows.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {
		case OBJECT_COL : return patients.get(rowIndex);
		default : return rows.get(rowIndex)[columnIndex];
		}
	}
	
	public void clear() {
		rows.clear();
		this.patients.clear();

		fireTableDataChanged();
	}
	
	public List<Patient> getDocteurs() {
		return patients;
	}
	
	public void setPatient(List<Patient> patients) throws DAOException {
		rows.clear();
		this.patients.clear();
		this.patients.addAll(0, patients);
		for (Patient patient : patients ){			
			rows.add( new Object [] {
					patient.getId(),
					patient.getNom(),
					patient.getPrenom(),
					patient.getEmail(),
					patient.getAdresse(),
					patient.getTel(),
					patient.getLogin(),
					patient.getPassword(),
					EnumDao.rechercheLocalite(patient.getIdLocalite()),
								
			});
		}

		fireTableDataChanged();
	}
	
	public void add(int id, String nom, String prenom, String email, String adresse,int idLocalite, int tel, String dateDeNaissance,
			String login, String password) throws DAOException {
		Patient patient = new Patient(id, nom, prenom, email, adresse, tel, dateDeNaissance, login, password, idLocalite);
		patients.add(patient);
		rows.add( new Object [] {
				patient.getId(),
				patient.getNom(),
				patient.getPrenom(),
				patient.getTel(),
				patient.getEmail(),
				patient.getAdresse(),
				patient.getLogin(),
				patient.getPassword(),
				EnumDao.rechercheLocalite(patient.getIdLocalite())
		});

		fireTableDataChanged();
	}
	public void delete(Patient patient) {
		int indexOf = patients.indexOf(patient);
		patients.remove(patient);
		rows.remove(indexOf);
		
		fireTableDataChanged();
	}
	
	public void update (int id, String nom, String prenom, String email, String adresse,int idLocalite, int tel, String dateDeNaissance,
			String login, String password) {
		Patient patient = new Patient(id, nom, prenom, email, adresse, tel, dateDeNaissance, login, password, idLocalite);
		int indexOf = patients.indexOf(patient);
		patients.get(indexOf).setLogin(login);
		patients.get(indexOf).setPassword(password);
		patients.get(indexOf).setTel(tel);
		patients.get(indexOf).setAdresse(adresse);
		
		Object [] obj = rows.get(indexOf);
		obj[5] = tel;
		obj[4] = adresse;
		obj[7] = login;
		obj[8] = password;
		
		fireTableDataChanged();
	}
}
