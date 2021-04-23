package project.data.DAO.implement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import project.back.Patient;
import project.data.DAO.DBManager;
import project.data.DAO.IDao;
import project.exceptions.DAOException;

public class PatientDao implements IDao<Patient> {

	@Override
	public void create(Patient entity) throws DAOException {
		try (Connection connection = DBManager.getConnection()) {
			String query = "Insert into patient (nom, prenom, email, adresse, localite, tel, dateDeNaissance, login, password) Values (?,?,?,?,?,?,?,?,?)"; 
			PreparedStatement ps = connection.prepareStatement(query);

			ps.setString(1, entity.getNom());
			ps.setString(2, entity.getPrenom());
			ps.setString(3, entity.getEmail());
			ps.setString(4, entity.getAdresse());
			ps.setInt(5,entity.getIdLocalite());
			ps.setInt(6,entity.getTel());
			ps.setString(7,entity.getDateDeNaissance());
			ps.setString(8, entity.getLogin());
			ps.setString(9, entity.getPassword());
			ps.executeUpdate();			

		} catch (Exception e) {
			throw new DAOException(e.getMessage());
		}

	}

	@Override
	public Patient read(int id) throws DAOException {
		try (Connection connection = DBManager.getConnection()) {
			String query = "Select * From patient Where id=?";
			PreparedStatement ps = connection.prepareStatement(query);

			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			if (rs.first()) {
				String nom = rs.getString("nom");
				String prenom = rs.getString("prenom");
				String email = rs.getString("email");
				String adresse = rs.getString("adresse");
				int idLocalite = rs.getInt("localite");
				int tel = rs.getInt("tel");
				String dateDeNaissance = rs.getString("dateDeNaissance");
				String login = rs.getString("login");
				String password = rs.getString("password");
				Patient patient = new Patient(id, nom, prenom, email, adresse, tel, dateDeNaissance, login, password, idLocalite);
				return patient;
			}						

		} catch (Exception e) {
			throw new DAOException(e.getMessage());
		}

		return null;
	}	


	@Override
	public List<Patient> list() throws DAOException {
		
List<Patient> patients = new ArrayList<>();
		
		try (Connection connection = DBManager.getConnection()) {
			String query = "Select * From patient";
			PreparedStatement ps = connection.prepareStatement(query);			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				int id = rs.getInt("id");
				String nom = rs.getString("nom");
				String prenom = rs.getString("prenom");
				String email = rs.getString("email");
				String adresse = rs.getString("adresse");
				int idLocalite = rs.getInt("localite");
				int tel = rs.getInt("tel");
				String dateDeNaissance = rs.getString("dateDeNaissance");
				String login = rs.getString("login");
				String password = rs.getString("password");
				Patient patient = new Patient(id, nom, prenom, email, adresse, tel, dateDeNaissance, login, password, idLocalite);		
				patients.add(patient);
			}

		} catch (Exception e) {
			throw new DAOException(e.getMessage());
		}
		
		return patients;
	}

	@Override
	public void update(Patient entity) throws DAOException {
		try (Connection connection = DBManager.getConnection()) {
			String query = "Update patient Set nom=?, prenom=?,email=?, adresse=?, localite=?, tel=?, dateDeNaissance=?, login=?,password=? Where id=?";

			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1,entity.getNom());
			ps.setString(2,entity.getPrenom());
			ps.setString(3,entity.getEmail());
			ps.setString(4,entity.getAdresse());
			ps.setInt(5, entity.getIdLocalite());
			ps.setInt(6, entity.getTel());
			ps.setString(7, entity.getDateDeNaissance());
			ps.setString(8, entity.getLogin());
			ps.setString(9, entity.getPassword());
			ps.setInt(10, entity.getId());
			ps.executeUpdate();

		} catch (Exception e) {
			throw new DAOException(e.getMessage());
		}

	}

	@Override
	public void delete(int id) throws DAOException {
		try (Connection connection = DBManager.getConnection()) {
			String query = "Delete From patient Where id=?";

			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, id);
			ps.executeUpdate();

		} catch (Exception e) {
			throw new DAOException(e.getMessage());
		}

	}

}
