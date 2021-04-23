package project.back.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;
import project.back.Docteur;

import project.data.DAO.implement.EnumDao;
import project.exceptions.DAOException;

public class DocteurModel extends AbstractTableModel {
	private static final long serialVersionUID = 1L;
	public static final int OBJECT_COL = -1;
	private Vector<Object[]> rows = new Vector<>();
	private List<Docteur> docteurs = new ArrayList<>();

	private String[] columns = {"ID", "Nom", "Prénom", "Tel","email", "Adresse", "Login", "Password", "Qualification"};


	@Override
	public int getRowCount() {

		return rows.size();
	}
	@Override
	public String getColumnName(int column) {
		
		return columns[column];
	}

	@Override
	public int getColumnCount() {

		return columns.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {

		switch (columnIndex) {
		case OBJECT_COL : return docteurs.get(rowIndex);
		default : return rows.get(rowIndex)[columnIndex];
		}
	}

	public void clear() {
		rows.clear();
		this.docteurs.clear();

		fireTableDataChanged();
	}

	public List<Docteur> getDocteurs() {
		return docteurs;
	}

	public void setDocteurs(List<Docteur> docteurs) throws DAOException {
		rows.clear();
		this.docteurs.clear();
		this.docteurs.addAll(0, docteurs);
		for (Docteur docteur : docteurs ){			
			rows.add( new Object [] {
					docteur.getId(),
					docteur.getNom(),
					docteur.getPrenom(),
					docteur.getTel(),
					docteur.getEmail(),
					docteur.getAdresse(),
					docteur.getLogin(),
					docteur.getPassword(),
					EnumDao.rechercheQualification(docteur.getIdQualification())
			});
		}

		fireTableDataChanged();
	}
	public void add(int id, String nom, String prenom, String email, String adresse, int tel, String dateDeNaissance,
			String login, String password, int idQualification, int idStructure) throws DAOException {
		Docteur docteur = new Docteur(id, nom, prenom, email, adresse, tel, dateDeNaissance, login, password, idQualification, idStructure);
		docteurs.add(docteur);
		rows.add( new Object [] {
				docteur.getId(),
				docteur.getNom(),
				docteur.getPrenom(),
				docteur.getTel(),
				docteur.getEmail(),
				docteur.getAdresse(),
				docteur.getLogin(),
				docteur.getPassword(),
				EnumDao.rechercheQualification(docteur.getIdQualification())
		});

		fireTableDataChanged();
	}
	
	public void delete(Docteur docteur) {
		int indexOf = docteurs.indexOf(docteur);
		docteurs.remove(docteur);
		rows.remove(indexOf);
		
		fireTableDataChanged();
	}
	public void update (int id, String nom, String prenom, String email, String adresse, int tel, String dateDeNaissance,
			String login, String password, int idQualification, int idStructure) {
		Docteur docteur = new Docteur(id, nom, prenom, email, adresse, tel, dateDeNaissance, login, password, idQualification, idStructure);
		int indexOf = docteurs.indexOf(docteur);
		docteurs.get(indexOf).setLogin(login);
		docteurs.get(indexOf).setPassword(password);
		docteurs.get(indexOf).setTel(tel);
		docteurs.get(indexOf).setAdresse(adresse);
		
		Object [] obj = rows.get(indexOf);
		obj[5] = tel;
		obj[4] = adresse;
		obj[7] = login;
		obj[8] = password;
		
		fireTableDataChanged();
	}

}
