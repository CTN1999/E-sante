package project.data.DAO.implement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import project.back.StructureDeSante;
import project.data.DAO.DBManager;
import project.data.DAO.IDao;
import project.exceptions.DAOException;

public class StructureDeSanteDao implements IDao<StructureDeSante> {

	@Override
	public void create(StructureDeSante entity) throws DAOException {
		try (Connection connection = DBManager.getConnection()) {
			String query = "Insert into structureDeSante (nom, email, tel, adresse, localite, login, password) Values (?,?,?,?,?,?,?)"; 
			PreparedStatement ps = connection.prepareStatement(query);

			ps.setString(1, entity.getNom());
			ps.setString(2, entity.getEmail());
			ps.setString(4, entity.getAdresse());
			ps.setInt(5,entity.getIdLocalite());
			ps.setInt(3,entity.getTel());
			ps.setString(6, entity.getLogin());
			ps.setString(7, entity.getPassword());
			ps.executeUpdate();			

		} catch (Exception e) {
			throw new DAOException(e.getMessage());
		}
		
		
	}

	@Override
	public StructureDeSante read(int id) throws DAOException {
		
		try (Connection connection = DBManager.getConnection()) {
			String query = "Select * From structureDeSante Where id=?";
			PreparedStatement ps = connection.prepareStatement(query);

			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			if (rs.first()) {
				String nom = rs.getString("nom");
				String email = rs.getString("email");
				String adresse = rs.getString("adresse");
				int idLocalite = rs.getInt("localite");
				int tel = rs.getInt("tel");
				String login = rs.getString("login");
				String password = rs.getString("password");
				StructureDeSante structureDeSante = new StructureDeSante(id, nom, email, tel, adresse, idLocalite, login, password);
				return structureDeSante;
			}						
;
		} catch (Exception e) {
			throw new DAOException(e.getMessage());
		}

		return null;
	}

	@Override
	public List<StructureDeSante> list() throws DAOException {
		List<StructureDeSante> structureDeSantes = new ArrayList<>();
		try (Connection connection = DBManager.getConnection()) {
			String query = "Select * From structureDeSante";
			PreparedStatement ps = connection.prepareStatement(query);			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				int id = rs.getInt("id");	
				String nom = rs.getString("nom");
				String email = rs.getString("email");
				String adresse = rs.getString("adresse");
				int idLocalite = rs.getInt("localite");
				int tel = rs.getInt("tel");
				String login = rs.getString("login");
				String password = rs.getString("password");
				StructureDeSante structureDeSante = new StructureDeSante(id, nom, email, tel, adresse, idLocalite, login, password);
				structureDeSantes.add(structureDeSante);
			}

		} catch (Exception e) {
			throw new DAOException(e.getMessage());
		}
		
		return structureDeSantes ;
		
	}

	@Override
	public void update(StructureDeSante entity) throws DAOException {
		try (Connection connection = DBManager.getConnection()) {
			String query = "Update structureDeSante Set nom=?,email=?, tel=?, adresse=?, localite=?, login=?,password=? Where id=?";

			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1,entity.getNom());			
			ps.setString(2,entity.getEmail());
			ps.setInt(3, entity.getTel());
			ps.setString(4,entity.getAdresse());
			ps.setInt(5, entity.getIdLocalite());
			ps.setString(6, entity.getLogin());
			ps.setString(7, entity.getPassword());
			ps.setInt(8, entity.getId());
			ps.executeUpdate();

		} catch (Exception e) {
			throw new DAOException(e.getMessage());
		}
		
	}

	@Override
	public void delete(int id) throws DAOException {
		try (Connection connection = DBManager.getConnection()) {
			String query = "Delete From structureDeSante Where id=?";

			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, id);
			ps.executeUpdate();

		} catch (Exception e) {
			throw new DAOException(e.getMessage());
		}
		
	}

}
