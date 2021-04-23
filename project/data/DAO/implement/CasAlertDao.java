package project.data.DAO.implement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import project.back.CasAlerte;
import project.data.DAO.IDao;
import project.exceptions.DAOException;
import project.data.DAO.DBManager;


public class CasAlertDao implements IDao<CasAlerte> {

	@Override
	public void create(CasAlerte entity) throws DAOException {
		try (Connection connection = DBManager.getConnection()) {
			String query = "Insert into casAlert (idPatient) Values (?)"; 
			PreparedStatement ps = connection.prepareStatement(query);

			ps.setInt(1, entity.getIdPatient());

			ps.executeUpdate();			

		} catch (Exception e) {
			throw new DAOException(e.getMessage());
		}

	}

	@Override
	public CasAlerte read(int id) throws DAOException {
		try (Connection connection = DBManager.getConnection()) {
			String query = "Select * From casAlert Where idCas=?";
			PreparedStatement ps = connection.prepareStatement(query);

			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			if (rs.first()) {
				int idPatient = rs.getInt("idPatient");

				CasAlerte casAlert = new CasAlerte(id, idPatient);
				return casAlert;
			}						

		} catch (Exception e) {
			throw new DAOException(e.getMessage());
		}

		return null;
	}

	@Override
	public List<CasAlerte> list() throws DAOException {
		List<CasAlerte> casAlertes = new ArrayList<>();

		try (Connection connection = DBManager.getConnection()) {
			String query = "Select * From casAlert";
			PreparedStatement ps = connection.prepareStatement(query);			
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				int idCas = rs.getInt("idCas");
				int idPatient = rs.getInt("idPatient");
				CasAlerte casAlert = new CasAlerte(idCas, idPatient);
				casAlertes.add(casAlert);
				
			}

		} catch (Exception e) {
			throw new DAOException(e.getMessage());
		}

		return casAlertes;

	}

	@Override
	public void update(CasAlerte entity) throws DAOException {
		

	}

	@Override
	public void delete(int id) throws DAOException {
		try (Connection connection = DBManager.getConnection()) {
			String query = "Delete From casAlert Where idCas=?";

			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, id);
			ps.executeUpdate();

		} catch (Exception e) {
			throw new DAOException(e.getMessage());
		}

	}

}
