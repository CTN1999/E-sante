package project.back;

public class Consultation {
	private int idConsultation;
	private int idPatient;
	private int idStructure;
	private int idDocteur;
	private int idQualification;
	private String dateRv;
	private Boolean valider;
	private Boolean effectuer;
	public Consultation(int idConsultation, int idPatient, int idStructure, int idDocteur, int idQualification,
			String dateRv, Boolean valider, Boolean effectuer) {
		
		this.idConsultation = idConsultation;
		this.idPatient = idPatient;
		this.idStructure = idStructure;
		this.idDocteur = idDocteur;
		this.idQualification = idQualification;
		this.dateRv = dateRv;
		this.valider = valider;
		this.effectuer = effectuer;
	}
	
	
	public Consultation(int idPatient, int idStructure, int idQualification) {
		this.idPatient = idPatient;
		this.idStructure = idStructure;
		this.idQualification = idQualification;
	}


	public Consultation(int idPatient, int idStructure, int idDocteur, int idQualification, String dateRv,
			Boolean valider, Boolean effectuer) {
		super();
		this.idPatient = idPatient;
		this.idStructure = idStructure;
		this.idDocteur = idDocteur;
		this.idQualification = idQualification;
		this.dateRv = dateRv;
		this.valider = valider;
		this.effectuer = effectuer;
	}
	public int getIdConsultation() {
		return idConsultation;
	}
	public void setIdConsultation(int idConsultation) {
		this.idConsultation = idConsultation;
	}
	public int getIdPatient() {
		return idPatient;
	}
	public void setIdPatient(int idPatient) {
		this.idPatient = idPatient;
	}
	public int getIdStructure() {
		return idStructure;
	}
	public void setIdStructure(int idStructure) {
		this.idStructure = idStructure;
	}
	public int getIdDocteur() {
		return idDocteur;
	}
	public void setIdDocteur(int idDocteur) {
		this.idDocteur = idDocteur;
	}
	public int getIdQualification() {
		return idQualification;
	}
	public void setIdQualification(int idQualification) {
		this.idQualification = idQualification;
	}
	public String getDateRv() {
		return dateRv;
	}
	public void setDateRv(String dateRv) {
		this.dateRv = dateRv;
	}
	public Boolean getValider() {
		return valider;
	}
	public void setValider(Boolean valider) {
		this.valider = valider;
	}
	public Boolean getEffectuer() {
		return effectuer;
	}
	public void setEffectuer(Boolean effectuer) {
		this.effectuer = effectuer;
	}
	
	
}
