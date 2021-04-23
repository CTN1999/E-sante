package project.data.DAO.implement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import project.back.VaccinCovid;
import project.data.DAO.DBManager;
import project.data.DAO.IDao;
import project.exceptions.DAOException;

public class EnumDao {
	public static String rechercheQualification(int id) throws DAOException {
		try (Connection connection = DBManager.getConnection()) {
			String query = "Select * From qualification Where id=?";
			PreparedStatement ps = connection.prepareStatement(query);

			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			if (rs.first()) {
				String nom = rs.getString("nom");
				return nom;
			}						

		} catch (Exception e) {
			throw new DAOException(e.getMessage());
		}

		return null;
	}
	public static String rechercheLocalite(int id) throws DAOException {
		try (Connection connection = DBManager.getConnection()) {
			String query = "Select * From localité Where id=?";
			PreparedStatement ps = connection.prepareStatement(query);

			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			if (rs.first()) {
				String nom = rs.getString("nom");
				return nom;
			}						

		} catch (Exception e) {
			throw new DAOException(e.getMessage());
		}

		return null;
	}
}
