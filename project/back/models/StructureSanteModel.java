package project.back.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;

import project.back.StructureDeSante;
import project.data.DAO.implement.EnumDao;
import project.exceptions.DAOException;

public class StructureSanteModel extends AbstractTableModel {
	private static final long serialVersionUID = 1L;
	public static final int OBJECT_COL = -1;
	private Vector<Object[]> rows = new Vector<>();
	private List<StructureDeSante> structureDeSantes = new ArrayList<>();
	private String[] columns = {"ID", "Nom", "Telephone", "email","Adresse", "Login", "Password","Localite"};


	@Override
	public int getColumnCount() {
		return columns.length;
	}
	@Override
	public String getColumnName(int column) {
		
		return columns[column];
	}

	@Override
	public int getRowCount() {
		return rows.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {
		case OBJECT_COL : return structureDeSantes.get(rowIndex);
		default : return rows.get(rowIndex)[columnIndex];
		}
	}
	
	public List<StructureDeSante> getstructureDeSante() {
		return structureDeSantes;
	}
	
	public void setStructureDeSante(List<StructureDeSante> structureDeSante) throws DAOException  {
		rows.clear();
		this.structureDeSantes.clear();
		this.structureDeSantes.addAll(0, structureDeSante);
		for (StructureDeSante structureDeSante1 : structureDeSantes ){			
			rows.add( new Object [] {
					structureDeSante1.getId(),
					structureDeSante1.getNom(),
					structureDeSante1.getTel(),
					structureDeSante1.getEmail(),
					structureDeSante1.getAdresse(),
					structureDeSante1.getLogin(),
					structureDeSante1.getPassword(),
					EnumDao.rechercheLocalite(structureDeSante1.getIdLocalite())		
			});
		}

		fireTableDataChanged();
	}
	public void add(int id, String nom, String email, String adresse,int idLocalite, int tel, String login, String password) throws DAOException {
		StructureDeSante structureDeSante = new StructureDeSante(nom, email, tel, adresse, idLocalite, login, password);
		structureDeSantes.add(structureDeSante);
		rows.add( new Object [] {
				structureDeSante.getId(),
				structureDeSante.getNom(),
				structureDeSante.getTel(),
				structureDeSante.getEmail(),
				structureDeSante.getAdresse(),
				structureDeSante.getLogin(),
				structureDeSante.getPassword(),
				EnumDao.rechercheLocalite(structureDeSante.getIdLocalite())
		});
		fireTableDataChanged();
	}
	
	public void delete(StructureDeSante structureDeSante) {
		int indexOf = structureDeSantes.indexOf(structureDeSante);
		structureDeSantes.remove(structureDeSante);
		rows.remove(indexOf);

		fireTableDataChanged();
	}

	public void clear() {
		rows.clear();
		this.structureDeSantes.clear();

		fireTableDataChanged();
	}
}

