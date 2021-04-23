package project.data.DAO.implement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import project.back.Consultation;
import project.data.DAO.DBManager;
import project.data.DAO.IDao;
import project.exceptions.DAOException;

public class ConsultationDao implements IDao<Consultation> {

	@Override
	public void create(Consultation entity) throws DAOException {
		try(Connection connection = DBManager.getConnection()) {
			String query = "Insert into consultation (idPatient, idStructure, idDocteur,  idQualification, dateRV, valider, effectuer) Values (?,?,?,?,?,?,?)"; 
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, entity.getIdPatient());
			ps.setInt(3, entity.getIdDocteur());
			ps.setInt(2, entity.getIdStructure());
			ps.setInt(4, entity.getIdQualification());
			ps.setString(5, entity.getDateRv());
			if(entity.getValider()) {
				
			}
			ps.setInt(6, 0);
			if(entity.getEffectuer()) {
				ps.setInt(7, 1);
			}
			ps.setInt(7, 0);
			ps.executeUpdate();	
			
		} catch (Exception e) {
			throw new DAOException(e.getMessage());
		}

	}

	@Override
	public Consultation read(int id) throws DAOException {
		try (Connection connection = DBManager.getConnection()) {
			String query = "Select * From consultation Where idConsultation=?";
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.first()) {
				int idPatient = rs.getInt("idPatient");
				int idDocteur = rs.getInt("idDocteur");
				int idStructure = rs.getInt("idStructure");
				int idQualification = rs.getInt("idQualification");
				String dateRv = rs.getString("dateRV");
				int Cvalider = rs.getInt("valider");
				int Ceffectuer = rs.getInt("effectuer");
				Boolean valider = false;
				Boolean effectuer = false;
				if(Cvalider != 0) valider = true;
				if(Ceffectuer != 0)effectuer = true;
				Consultation consultation = new Consultation(id, idPatient, idStructure, idDocteur, idQualification, dateRv, valider, effectuer);
				return consultation;
			}
		} catch (Exception e) {
			throw new DAOException(e.getMessage());
		}
		return null;
	}

	@Override
	public List<Consultation> list() throws DAOException {
		List<Consultation> consultations = new ArrayList<>();
		try (Connection connection = DBManager.getConnection()){
			String query = "Select * From consultation ORDER BY idConsultation DESC";
			PreparedStatement ps = connection.prepareStatement(query);			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int idConsultation = rs.getInt("idConsultation");
				int idPatient = rs.getInt("idPatient");
				int idDocteur = rs.getInt("idDocteur");
				int idStructure = rs.getInt("idStructure");
				int idQualification = rs.getInt("idQualification");
				String dateRv = rs.getString("dateRV");
				int Cvalider = rs.getInt("valider");
				int Ceffectuer = rs.getInt("effectuer");
				Boolean valider = false;
				Boolean effectuer = false;
				if(Cvalider != 0) valider = true;
				if(Ceffectuer != 0)effectuer = true;
				Consultation consultation = new Consultation(idConsultation, idPatient, idStructure, idDocteur, idQualification, dateRv, valider, effectuer);
				consultations.add(consultation);
				
			}
			
		} catch (Exception e) {
			throw new DAOException(e.getMessage());
		}
		return consultations;
	}

	@Override
	public void update(Consultation entity) throws DAOException {
		try (Connection connection = DBManager.getConnection()) {
			String query = "Update consultation Set dateRV=?, valider=?, effectuer=?, idDocteur=? Where idConsultation=?";
			PreparedStatement ps = connection.prepareStatement(query);
			
			ps.setString(1, entity.getDateRv());
			if(entity.getValider()) {
				ps.setInt(2, 1);
			}else {
				ps.setInt(2, 0);
			}
			
			if(entity.getEffectuer()) {
				ps.setInt(3, 1);
			}
			else {
				ps.setInt(3, 0);
			}
			ps.setInt(4, entity.getIdDocteur());
			ps.setInt(5, entity.getIdConsultation());
			ps.executeUpdate();

		} catch (Exception e) {
			throw new DAOException(e.getMessage());
		}

	}

	@Override
	public void delete(int id) throws DAOException {
		try (Connection connection = DBManager.getConnection()) {
			String query = "Delete From consultation Where idConsultation=?";

			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, id);
			ps.executeUpdate();

		} catch (Exception e) {
			throw new DAOException(e.getMessage());
		}

	}
	public List<Consultation> listPourPatient(int IdPatient) throws DAOException {
		List<Consultation> consultations = new ArrayList<>();
		try (Connection connection = DBManager.getConnection()){
			String query = "Select * From consultation Where idPatient=? ORDER BY idConsultation DESC";
			PreparedStatement ps = connection.prepareStatement(query);	
			ps.setInt(1, IdPatient);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int idConsultation = rs.getInt("idConsultation");
				int idPatient = rs.getInt("idPatient");
				int idDocteur = rs.getInt("idDocteur");
				int idStructure = rs.getInt("idStructure");
				int idQualification = rs.getInt("idQualification");
				String dateRv = rs.getString("dateRV");
				int Cvalider = rs.getInt("valider");
				int Ceffectuer = rs.getInt("effectuer");
				Boolean valider = false;
				Boolean effectuer = false;
				if(Cvalider != 0) valider = true;
				if(Ceffectuer != 0)effectuer = true;
				Consultation consultation = new Consultation(idConsultation, idPatient, idStructure, idDocteur, idQualification, dateRv, valider, effectuer);
				consultations.add(consultation);
				
			}
			
		} catch (Exception e) {
			throw new DAOException(e.getMessage());
		}
		return consultations;
	}
	public List<Consultation> listPourStructure(int IdStructure) throws DAOException {
		List<Consultation> consultations = new ArrayList<>();
		try (Connection connection = DBManager.getConnection()){
			String query = "Select * From consultation Where idStructure=? ORDER BY idConsultation DESC";
			PreparedStatement ps = connection.prepareStatement(query);	
			ps.setInt(1, IdStructure);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int idConsultation = rs.getInt("idConsultation");
				int idPatient = rs.getInt("idPatient");
				int idDocteur = rs.getInt("idDocteur");
				int idStructure = rs.getInt("idStructure");
				int idQualification = rs.getInt("idQualification");
				String dateRv = rs.getString("dateRV");
				int Cvalider = rs.getInt("valider");
				int Ceffectuer = rs.getInt("effectuer");
				Boolean valider = false;
				Boolean effectuer = false;
				if(Cvalider != 0) valider = true;
				if(Ceffectuer != 0)effectuer = true;
				Consultation consultation = new Consultation(idConsultation, idPatient, idStructure, idDocteur, idQualification, dateRv, valider, effectuer);
				consultations.add(consultation);
				
			}
			
		} catch (Exception e) {
			throw new DAOException(e.getMessage());
		}
		return consultations;
	}

	public List<Consultation> listPourDocteur(int IdDocteur) throws DAOException {
		List<Consultation> consultations = new ArrayList<>();
		try (Connection connection = DBManager.getConnection()){
			String query = "Select * From consultation Where idDocteur=? ORDER BY idConsultation DESC";
			PreparedStatement ps = connection.prepareStatement(query);	
			ps.setInt(1, IdDocteur);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int idConsultation = rs.getInt("idConsultation");
				int idPatient = rs.getInt("idPatient");
				int idDocteur = rs.getInt("idDocteur");
				int idStructure = rs.getInt("idStructure");
				int idQualification = rs.getInt("idQualification");
				String dateRv = rs.getString("dateRV");
				int Cvalider = rs.getInt("valider");
				int Ceffectuer = rs.getInt("effectuer");
				Boolean valider = false;
				Boolean effectuer = false;
				if(Cvalider != 0) valider = true;
				if(Ceffectuer != 0)effectuer = true;
				Consultation consultation = new Consultation(idConsultation, idPatient, idStructure, idDocteur, idQualification, dateRv, valider, effectuer);
				consultations.add(consultation);
				
			}
			
		} catch (Exception e) {
			throw new DAOException(e.getMessage());
		}
		return consultations;
	}
}
