package project.back.methods;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import project.back.Admin;
import project.back.Docteur;
import project.back.Patient;
import project.back.StructureDeSante;
import project.data.DAO.DBManager;
import project.exceptions.DAOException;


public class Authentification {
	
	public  Patient verifierConnexionPatient(String loginOrEmail,String password) throws DAOException {
		try (Connection connection = DBManager.getConnection()){
			String query = "Select * From patient Where login=? and password=?" ;
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1,loginOrEmail);
			ps.setString(2,password);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				return Metier.rechercherPatient(rs.getInt("id"));
				
			}
			
			String queryMail = "Select * From patient Where email=? and password=?" ;
			PreparedStatement psMail = connection.prepareStatement(queryMail);
			psMail.setString(1,loginOrEmail);
			psMail.setString(2,password);
			ResultSet rsMail = psMail.executeQuery();
			if(rsMail.next()) {
				return Metier.rechercherPatient(rsMail.getInt("id"));
				
				
			}
			
			else {
				throw new DAOException("Vous n'avez pas de compte");
			}
			
		}catch (Exception e) {
			throw new DAOException(e.getMessage());
		}
		
		
	}
	
	public  Docteur verifierConnexionDocteur(String loginOrEmail,String password) throws DAOException {
		try (Connection connection = DBManager.getConnection()){
			String query = "Select * From docteur Where login=? and password=?" ;
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1,loginOrEmail);
			ps.setString(2,password);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				return Metier.rechercherDocteur(rs.getInt("id"));
				
			}
			
			String queryMail = "Select * From docteur Where email=? and password=?" ;
			PreparedStatement psMail = connection.prepareStatement(queryMail);
			psMail.setString(1,loginOrEmail);
			psMail.setString(2,password);
			ResultSet rsMail = psMail.executeQuery();
			if(rsMail.next()) {
				return Metier.rechercherDocteur(rsMail.getInt("id"));
				
			}
			
			else {
				throw new DAOException("Vous n'avez pas de compte");
			}
			
		}catch (Exception e) {
			throw new DAOException(e.getMessage());
		}
		
		
	}
	public  StructureDeSante verifierConnexionStructure(String loginOrEmail,String password) throws DAOException {
		try (Connection connection = DBManager.getConnection()){
			String query = "Select * From structureDeSante Where login=? and password=?" ;
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1,loginOrEmail);
			ps.setString(2,password);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				return Metier.rechercherStructure(rs.getInt("id"));
				
			}
			String queryMail = "Select * From structureDeSante Where email=? and password=?" ;
			PreparedStatement psMail = connection.prepareStatement(queryMail);
			psMail.setString(1,loginOrEmail);
			psMail.setString(2,password);
			ResultSet rsMail = psMail.executeQuery();
			if(rsMail.next()) {
				return Metier.rechercherStructure(rsMail.getInt("id"));
				
			}
			else {
				throw new DAOException("Vous n'avez  pas de compte");
			}
			
		}catch (Exception e) {
			throw new DAOException(e.getMessage());
		}
		
		
	}
	public   Admin verifierConnexionAdmin(String login,String password) throws DAOException {
		try (Connection connection = DBManager.getConnection()){
			String query = "Select * From admin Where login=? and password=?" ;
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1,login);
			ps.setString(2,password);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				return Metier.rechercherAdmin(rs.getInt("id"));
				
			}
			String queryMail = "Select * From admin Where email=? and password=?" ;
			PreparedStatement psMail = connection.prepareStatement(queryMail);
			psMail.setString(1,login);
			psMail.setString(2,password);
			ResultSet rsMail = psMail.executeQuery();
			if(rsMail.next()) {
				return Metier.rechercherAdmin(rsMail.getInt("id"));
				
			}
			else {
				throw new DAOException("Vous n'avez pas de compte");
			}
			
		}catch (Exception e) {
			throw new DAOException(e.getMessage());
		}
		
		
	}
	public  boolean  verifEmail(String email,String nameBase) throws DAOException {
		try (Connection connection = DBManager.getConnection()){
			String query = "Select * From ? Where email=?";
			PreparedStatement ps = connection.prepareStatement(query);

			ps.setString(1, nameBase);
			ps.setString(2, email);
			ResultSet rs = ps.executeQuery();
			if(rs.first()) {
				return true ;
			}
			return false;
		}catch (Exception e) {
			throw new DAOException(e.getMessage());
		}
		
	}
	
	
}
