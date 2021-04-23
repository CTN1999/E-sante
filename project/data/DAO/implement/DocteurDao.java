package project.data.DAO.implement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import project.back.Docteur;

import project.data.DAO.DBManager;
import project.data.DAO.IDao;
import project.exceptions.DAOException;

public class DocteurDao implements IDao<Docteur>{

	@Override
	public void create(Docteur entity) throws DAOException {
		try (Connection connection = DBManager.getConnection()) {
			String query = "Insert into docteur (nom, prenom, tel, email, adresse, dateDeNaissance, login, password, qualification, idStructure) Values (?,?,?,?,?,?,?,?,?,?)"; 
			PreparedStatement ps = connection.prepareStatement(query);

			ps.setString(1, entity.getNom());
			ps.setString(2, entity.getPrenom());
			ps.setInt(3,entity.getTel());
			ps.setString(4, entity.getEmail());
			ps.setString(5, entity.getAdresse());


			ps.setString(6,entity.getDateDeNaissance());
			ps.setString(7, entity.getLogin());
			ps.setString(8, entity.getPassword());
			ps.setInt(9,entity.getIdQualification());
			ps.setInt(10, entity.getIdStructureDeSante());
			ps.executeUpdate();			

		} catch (Exception e) {
			throw new DAOException(e.getMessage());
		}

	}

	@Override
	public Docteur read(int id) throws DAOException {
		try (Connection connection = DBManager.getConnection()) {
			String query = "Select * From docteur Where id=?";
			PreparedStatement ps = connection.prepareStatement(query);

			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			if (rs.first()) {
				String nom = rs.getString("nom");
				String prenom = rs.getString("prenom");
				String email = rs.getString("email");
				String adresse = rs.getString("adresse");
				int idQualification = rs.getInt("qualification");
				int tel = rs.getInt("tel");
				String dateDeNaissance = rs.getString("dateDeNaissance");
				String login = rs.getString("login");
				String password = rs.getString("password");
				int idStructureDeSante = rs.getInt("idStructure");
				Docteur docteur = new Docteur(id, nom, prenom, email, adresse, tel, dateDeNaissance, login, password, idQualification, idStructureDeSante);
				return docteur;
			}						

		} catch (Exception e) {
			throw new DAOException(e.getMessage());
		}
		return null;
	}
	
	public Docteur read(int idDocteur,int idStructure) throws DAOException {
		try (Connection connection = DBManager.getConnection()) {
			String query = "Select * From docteur Where id=? AND idStructure=?";
			PreparedStatement ps = connection.prepareStatement(query);

			ps.setInt(1, idDocteur);
			ps.setInt(2, idStructure);
			ResultSet rs = ps.executeQuery();

			if (rs.first()) {
				String nom = rs.getString("nom");
				String prenom = rs.getString("prenom");
				String email = rs.getString("email");
				String adresse = rs.getString("adresse");
				int idQualification = rs.getInt("qualification");
				int tel = rs.getInt("tel");
				String dateDeNaissance = rs.getString("dateDeNaissance");
				String login = rs.getString("login");
				String password = rs.getString("password");
				int idStructureDeSante = rs.getInt("idStructure");
				Docteur docteur = new Docteur(idDocteur, nom, prenom, email, adresse, tel, dateDeNaissance, login, password, idQualification, idStructureDeSante);
				return docteur;
			}						

		} catch (Exception e) {
			throw new DAOException(e.getMessage());
		}
		return null;
	}

	@Override
	public List<Docteur> list() throws DAOException {

		List<Docteur> docteurs = new ArrayList<>();

		try (Connection connection = DBManager.getConnection()) {
			String query = "Select * From docteur";
			PreparedStatement ps = connection.prepareStatement(query);			
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				String nom = rs.getString("nom");
				String prenom = rs.getString("prenom");
				String email = rs.getString("email");
				String adresse = rs.getString("adresse");
				int idQualification = rs.getInt("qualification");
				int tel = rs.getInt("tel");
				String dateDeNaissance = rs.getString("dateDeNaissance");
				String login = rs.getString("login");
				String password = rs.getString("password");
				int idStructureDeSante = rs.getInt("idStructure");
				Docteur docteur = new Docteur(id, nom, prenom, email, adresse, tel, dateDeNaissance, login, password, idQualification, idStructureDeSante);
				docteurs.add(docteur);
			}

		} catch (Exception e) {
			throw new DAOException(e.getMessage());
		}

		return docteurs;
	}

	public List<Docteur> listPourStructure(int idStructure) throws DAOException {

		List<Docteur> docteurs = new ArrayList<>();

		try (Connection connection = DBManager.getConnection()) {
			String query = "Select * From docteur Where idStructure=?";
			PreparedStatement ps = connection.prepareStatement(query);	
			ps.setInt(1, idStructure);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				String nom = rs.getString("nom");
				String prenom = rs.getString("prenom");
				String email = rs.getString("email");
				String adresse = rs.getString("adresse");
				int idQualification = rs.getInt("qualification");
				int tel = rs.getInt("tel");
				String dateDeNaissance = rs.getString("dateDeNaissance");
				String login = rs.getString("login");
				String password = rs.getString("password");
				int idStructureDeSante = rs.getInt("idStructure");
				Docteur docteur = new Docteur(id, nom, prenom, email, adresse, tel, dateDeNaissance, login, password, idQualification, idStructureDeSante);
				docteurs.add(docteur);
			}

		} catch (Exception e) {
			throw new DAOException(e.getMessage());
		}

		return docteurs;
	}


	@Override
	public void update(Docteur entity) throws DAOException {

		try (Connection connection = DBManager.getConnection()) {
			String query = "Update docteur Set nom=?, prenom=?, tel=?,email=?, adresse=?, dateDeNaissance=?, login=?, password=?,qualification=?, idStructure=? Where id=?";

			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1,entity.getNom());
			ps.setString(2,entity.getPrenom());
			ps.setString(4,entity.getEmail());
			ps.setString(5,entity.getAdresse());
			ps.setInt(3, entity.getTel());
			ps.setString(6, entity.getDateDeNaissance());
			ps.setString(7, entity.getLogin());
			ps.setString(8, entity.getPassword());
			ps.setInt(9, entity.getIdQualification());
			ps.setInt(10, entity.getIdStructureDeSante());
			ps.setInt(11, entity.getId());
			ps.executeUpdate();

		} catch (Exception e) {
			throw new DAOException(e.getMessage());
		}
	}

	@Override
	public void delete(int id) throws DAOException {
		try (Connection connection = DBManager.getConnection()) {
			String query = "Delete From docteur Where id=?";

			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, id);
			ps.executeUpdate();

		} catch (Exception e) {
			throw new DAOException(e.getMessage());
		}

	}

}
