package project.back;

public class Docteur extends User{
	private int  idQualification;
	private int idStructureDeSante;

	public Docteur(int id, String nom, String prenom, String email, String adresse, int tel, String dateDeNaissance,
			String login, String password, int idQualification, int idStructureDeSante) {
		super(id, nom, prenom, email, adresse, tel, dateDeNaissance, login, password);
		this.idStructureDeSante=idStructureDeSante;
		this.idQualification = idQualification;
	}

	

	public Docteur(String nom, String prenom, String email, String adresse, int tel, String dateDeNaissance, String login,
			String password, int idQualification, int idStructureDeSante) {
		super(nom, prenom, email, adresse, tel, dateDeNaissance, login, password);
		this.setIdStructureDeSante(idStructureDeSante);
		this.idQualification = idQualification;
	}
	
	public int getIdQualification() {
		return idQualification;
	}

	public int getIdStructureDeSante() {
		return idStructureDeSante;
	}

	public void setIdStructureDeSante(int idStructureDeSante) {
		this.idStructureDeSante = idStructureDeSante;
	}
	

	
	

	
	

}
