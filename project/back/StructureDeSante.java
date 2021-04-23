package project.back;

public class StructureDeSante extends User {
	
	public StructureDeSante(int id, String nom, String email, int tel, String adresse, int idLocalite, String login,
			String password) {
		super(id, nom, email, tel, adresse, idLocalite, login, password);
		
	}
	public StructureDeSante(String nom, String email, int tel, String adresse, int idLocalite, String login,
			String password) {
		super(nom, email, tel, adresse, idLocalite, login, password);
		
	}
	
}
