package project.back;

public class Patient extends User {
	
	public Patient(int id) {
		super(id);
	}


	public Patient(int id, String nom, String prenom, String email, String adresse, int tel, String dateDeNaissance,
			String login, String password, int idLocalite) {
		super(id, nom, prenom, email, adresse, tel, dateDeNaissance, login, password, idLocalite);
		
	}
	
	public Patient(String nom, String prenom, String email, String adresse, int tel, String dateDeNaissance, String login,
			String password, int idLocalite) {
		super(nom, prenom, email, adresse, tel, dateDeNaissance, login, password, idLocalite);
		
	}
	public String display() {
		String display = " Nom: "+ nom;
		display += "\n Prenom: " + prenom;
		display += "\n Email: " + email;
		display += "\n Adresse:" + adresse;
		display += "\n tel:" + tel;
		display += "\n Date de naissance:" + dateDeNaissance;
		return display;
		}
	}
	
	
	

	
	


	
	
	

