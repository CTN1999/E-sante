package project.back.methods;

import java.util.List;

import project.back.Admin;
import project.back.CasAlerte;
import project.back.Consultation;
import project.back.Docteur;
import project.back.Patient;
import project.back.Qualification;
import project.back.StructureDeSante;
import project.back.VaccinCovid;
import project.data.DAO.implement.AdminDao;
import project.data.DAO.implement.CasAlertDao;
import project.data.DAO.implement.ConsultationDao;
import project.data.DAO.implement.DocteurDao;
import project.data.DAO.implement.PatientDao;
import project.data.DAO.implement.StructureDeSanteDao;
import project.data.DAO.implement.VaccinDao;
import project.exceptions.DAOException;


public class Metier {
	public static void ajouterPatient(Patient patient) throws DAOException {
		PatientDao patientDao = new PatientDao();
		patientDao.create(patient);
	}
	
	public static void modifierPatient(Patient patient) throws DAOException {
		PatientDao patientDao = new PatientDao();
		patientDao.update(patient);
	}
	
	public static List<Patient> listerPatient () throws DAOException{
		PatientDao patientDao = new PatientDao();
		return patientDao.list();	
	}
	
	public static Patient rechercherPatient(int id) throws DAOException {
		PatientDao patientDao = new PatientDao();
		return patientDao.read(id);
	}
	
	public static void supprimerPatient(int id) throws DAOException {
		PatientDao patientDao = new PatientDao();
		patientDao.delete(id);
	}
	
	public static void ajouterDocteur(Docteur docteur) throws DAOException {
		DocteurDao docteurDao = new DocteurDao();
		docteurDao.create(docteur);
	}
	
	public static void modifierDocteur(Docteur docteur) throws DAOException{
		DocteurDao docteurDao = new DocteurDao();
		docteurDao.update(docteur);
	}
	
	public static List<Docteur> listerDocteur() throws DAOException{
		DocteurDao docteurDao = new DocteurDao();
		return docteurDao.list();
	}
	public static List<Docteur> listerDocteur(int id) throws DAOException{
		DocteurDao docteurDao = new DocteurDao();
		return docteurDao.listPourStructure(id);
	}
	
	public static Docteur rechercherDocteur(int id) throws DAOException {
		DocteurDao docteurDao = new DocteurDao();
		return docteurDao.read(id);
	}
	public static Docteur rechercherDocteur(int idDocteur,int idStructure) throws DAOException {
		DocteurDao docteurDao = new DocteurDao();
		return docteurDao.read(idDocteur,idStructure);
	}
	
	public static void supprimerDocteur(int id) throws DAOException {
		DocteurDao docteurDao = new DocteurDao();
		docteurDao.delete(id);
	}
	
	public static void ajouterStructure (StructureDeSante structureDeSante) throws DAOException{
		StructureDeSanteDao dao = new StructureDeSanteDao();
		dao.create(structureDeSante);
	}
	
	public static void modifierStructure (StructureDeSante structureDeSante) throws DAOException{
		StructureDeSanteDao dao = new StructureDeSanteDao();
		dao.update(structureDeSante);
	}
	
	public static List<StructureDeSante> listerStructure () throws DAOException{
		StructureDeSanteDao dao = new StructureDeSanteDao();
		return dao.list();
	}
	
	public static StructureDeSante rechercherStructure(int id) throws DAOException {
		StructureDeSanteDao dao = new StructureDeSanteDao();
		return dao.read(id);
		
	}
	
	public static void supprimerStructure(int id) throws DAOException {
		StructureDeSanteDao dao = new StructureDeSanteDao();
		 dao.delete(id);
		
	}
	
	
	public static void ajouterAdmin(Admin admin) throws DAOException {
		AdminDao adao = new AdminDao();
		adao.create(admin);
	}
	
	public static void modifierAdmin(Admin admin) throws DAOException {
		AdminDao adao = new AdminDao();
		adao.update(admin);
	}
	
	public static List<Admin> listerAdmin() throws DAOException {
		AdminDao adao = new AdminDao();
		return adao.list();
	}
	
	public static Admin rechercherAdmin(int id) throws DAOException{
		AdminDao adao = new AdminDao();
		return adao.read(id);
	}
	public static void supprimerAdmin(int id) throws DAOException{
		AdminDao adao = new AdminDao();
		adao.delete(id);
	}
	
	public static void ajouterCasAlert(CasAlerte cas) throws DAOException {
		CasAlertDao alertdao = new CasAlertDao();
		alertdao.create(cas);
	}
	public static CasAlerte rechercherCasAlert(int id) throws DAOException {
		CasAlertDao alertdao = new CasAlertDao();
		return alertdao.read(id);
	}
	public static List<CasAlerte> listerCasAlert() throws DAOException{
		CasAlertDao dao = new CasAlertDao();
		return dao.list();
	}
	
	public static void supprimerCasAlert(int id) throws DAOException {
		CasAlertDao alertdao = new CasAlertDao();
		alertdao.delete(id);
	}
	
	public static void ajouterPatientVaccin(VaccinCovid vaccinCovid) throws DAOException {
		
		VaccinDao vaccindao = new VaccinDao();
		vaccindao.create(vaccinCovid);
	}
	public static VaccinCovid rechercherPatientVaccin(int id) throws DAOException {
		VaccinDao vaccindao = new VaccinDao();
		return vaccindao.read(id);
	}
	public static List<VaccinCovid> listerVaccin() throws DAOException{
		VaccinDao vaccindao = new VaccinDao();
		return vaccindao.list();
	}
	
	public static void supprimerPatientVaccin(int id) throws DAOException {
		VaccinDao vaccindao = new VaccinDao();
		vaccindao.delete(id);
	}
	
	public static void ajouterConsultation(Consultation consultation) throws DAOException {
		ConsultationDao dao = new ConsultationDao();
		dao.create(consultation);
		
	}
	public static Consultation rechercherConsultation(int id) throws DAOException {
		ConsultationDao dao = new ConsultationDao();
		return dao.read(id);
		
	}
	public static void modifierConsultation(Consultation consultation) throws DAOException {
		ConsultationDao dao = new ConsultationDao();
		dao.update(consultation);
		
	}
	public static void supprimerConsultation(int id) throws DAOException {
		ConsultationDao dao = new ConsultationDao();
		dao.delete(id);
		
	}
	public static List<Consultation> listerConsultation() throws DAOException {
		ConsultationDao dao = new ConsultationDao();
		return dao.list();
	}
	public static List<Consultation> listerConsultationDocteur(int id) throws DAOException {
		ConsultationDao dao = new ConsultationDao();
		return dao.listPourDocteur(id);
	}
	public static List<Consultation> listerConsultationPatient(int id) throws DAOException {
		ConsultationDao dao = new ConsultationDao();
		return dao.listPourPatient(id);
	}
	public static List<Consultation> listerConsultationStructure(int id) throws DAOException {
		ConsultationDao dao = new ConsultationDao();
		return dao.listPourStructure(id);
	}
	
	
	
}
