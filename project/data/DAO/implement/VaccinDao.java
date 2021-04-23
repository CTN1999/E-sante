package project.data.DAO.implement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import project.back.CasAlerte;
import project.back.VaccinCovid;
import project.data.DAO.DBManager;
import project.data.DAO.IDao;
import project.exceptions.DAOException;

public class VaccinDao implements IDao<VaccinCovid> {

	@Override
	public void create(VaccinCovid entity) throws DAOException {
		try (Connection connection = DBManager.getConnection()) {
			if(read(entity.getIdPatient()) == null) {
			String query = "Insert into vaccin (idPatient) Values (?)"; 
			PreparedStatement ps = connection.prepareStatement(query);

			ps.setInt(1, entity.getIdPatient());

			ps.executeUpdate();	
			}
			else {
				throw new DAOException("Vous etes déja sur la liste ");
			}
			

		} catch (Exception e) {
			throw new DAOException(e.getMessage());
		}

	}

	@Override
	public VaccinCovid read(int id) throws DAOException {
		try (Connection connection = DBManager.getConnection()) {
			String query = "Select * From vaccin Where idVaccin=?";
			PreparedStatement ps = connection.prepareStatement(query);

			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			if (rs.first()) {
				int idPatient = rs.getInt("idPatient");

				VaccinCovid vaccin = new VaccinCovid(id, idPatient);
				return vaccin;
			}						

		} catch (Exception e) {
			throw new DAOException(e.getMessage());
		}

		return null;
	}

	@Override
	public List<VaccinCovid> list() throws DAOException {

		List<VaccinCovid> vaccinCovids = new ArrayList<>();

		try (Connection connection = DBManager.getConnection()) {
			String query = "Select * From vaccin";
			PreparedStatement ps = connection.prepareStatement(query);			
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				int idVaccin = rs.getInt("idVaccin");
				int idPatient = rs.getInt("idPatient");
				VaccinCovid casCovid = new VaccinCovid(idVaccin, idPatient);
				vaccinCovids.add(casCovid);

			}

		} catch (Exception e) {
			throw new DAOException(e.getMessage());
		}

		return vaccinCovids;
	}

	@Override
	public void update(VaccinCovid entity) throws DAOException {

	}

	@Override
	public void delete(int id) throws DAOException {
		try (Connection connection = DBManager.getConnection()) {
			String query = "Delete From vaccin Where idVaccin=?";

			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, id);
			ps.executeUpdate();

		} catch (Exception e) {
			throw new DAOException(e.getMessage());
		}

	}


}


