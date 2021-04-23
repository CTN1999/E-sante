package project.back;

public class User {
	protected int id;
	protected String nom;
	protected String prenom;
	protected String email;
	protected String adresse;
	protected int tel;
	protected String dateDeNaissance;
	protected String login;
	protected String password;
	private int idLocalite;
	
	public User(int id) {
	
		this.id = id;
	}
	public User(int id, String nom, String email, int tel, String adresse, int idLocalite, String login,
			String password) {
		
		this.id = id;
		this.nom = nom;
		this.email = email;
		this.adresse = adresse;
		this.tel = tel;
		this.idLocalite = idLocalite;
		this.login = login;
		this.password = password;
	}
	public User(String nom, String email, int tel, String adresse, int idLocalite, String login,
			String password) {
		this.nom = nom;
		this.email = email;
		this.adresse = adresse;
		this.tel = tel;
		this.idLocalite = idLocalite;
		this.login = login;
		this.password = password;
	}
	public int getIdLocalite() {
		return idLocalite;
	}
	public void setIdLocalite(int idLocalite) {
		this.idLocalite = idLocalite;
	}
	public User(int id, String nom, String prenom, String email, String adresse, int tel, String dateDeNaissance,
			String login, String password) {
		
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.adresse = adresse;
		this.tel = tel;
		this.dateDeNaissance = dateDeNaissance;
		this.login = login;
		this.password = password;
	}
	
	public User(int id, String nom, String prenom, String email, String adresse, int tel, String dateDeNaissance,
			String login, String password, int idLocalite) {
		
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.adresse = adresse;
		this.tel = tel;
		this.dateDeNaissance = dateDeNaissance;
		this.login = login;
		this.password = password;
		this.idLocalite = idLocalite;
	}
	
	public User(String nom, String prenom, String email, String adresse, int tel, String dateDeNaissance, String login,
			String password,  int idLocalite) {
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.adresse = adresse;
		this.tel = tel;
		this.dateDeNaissance = dateDeNaissance;
		this.login = login;
		this.password = password;
		this.idLocalite = idLocalite;
	}
	public User(String nom, String prenom, String email, String adresse, int tel, String dateDeNaissance, String login,
			String password) {
		
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.adresse = adresse;
		this.tel = tel;
		this.dateDeNaissance = dateDeNaissance;
		this.login = login;
		this.password = password;
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getTel() {
		return tel;
	}
	public void setTel(int tel) {
		this.tel = tel;
	}
	public String getDateDeNaissance() {
		return dateDeNaissance;
	}
	public void setDateDeNaissance(String dateDeNaissance) {
		this.dateDeNaissance = dateDeNaissance;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	
	
	
	
	
}
