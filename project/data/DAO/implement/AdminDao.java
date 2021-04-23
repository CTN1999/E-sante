package project.data.DAO.implement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import project.back.Admin;
import project.data.DAO.DBManager;
import project.data.DAO.IDao;
import project.exceptions.DAOException;

public class AdminDao implements IDao <Admin>{

	@Override
	public void create(Admin entity) throws DAOException {
		try (Connection connection = DBManager.getConnection()) {
			String query = "Insert into admin (login, password) Values (?,?)"; 
			PreparedStatement ps = connection.prepareStatement(query);

			ps.setString(1, entity.getLogin());
			ps.setString(2, entity.getPassword());
			ps.executeUpdate();			
			
		} catch (Exception e) {
			throw new DAOException(e.getMessage());
		}
		
	}

	@Override
	public Admin read(int id) throws DAOException {
		try (Connection connection = DBManager.getConnection()) {
			String query = "Select * From admin Where id=?";
			PreparedStatement ps = connection.prepareStatement(query);
			
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			if (rs.first()) {
				String login = rs.getString("login");
				String password = rs.getString("password");
				
				Admin admin = new Admin (id, login, password);
				return admin;
			}						

		} catch (Exception e) {
			throw new DAOException(e.getMessage());
		}
		return null;
	}

	@Override
	public List<Admin> list() throws DAOException {
		List<Admin> admins = new ArrayList<>();
		
		try (Connection connection = DBManager.getConnection()) {
			String query = "Select * From admin";
			PreparedStatement ps = connection.prepareStatement(query);			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				int identifiant = rs.getInt("id");
				String login = rs.getString("login");
				String password = rs.getString("password");
				
				Admin admin = new Admin (identifiant, login, password);				
				admins.add(admin);
			}

		} catch (Exception e) {
			throw new DAOException(e.getMessage());
		}
		
		return admins;
		
	}

	@Override
	public void update(Admin entity) throws DAOException {
		try (Connection connection = DBManager.getConnection()) {
			String query = "Update admin Set login=?, password=? Where id=?";

			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, entity.getLogin());
			ps.setString(2, entity.getPassword());
			ps.setInt(3, entity.getId());
			ps.executeUpdate();

		} catch (Exception e) {
			throw new DAOException(e.getMessage());
		}
		
	}

	@Override
	public void delete(int id) throws DAOException {
		try (Connection connection = DBManager.getConnection()) {
			String query = "Delete From admin Where id=?";

			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, id);
			ps.executeUpdate();

		} catch (Exception e) {
			throw new DAOException(e.getMessage());
		}
		
	}
	
}
