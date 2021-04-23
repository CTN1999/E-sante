package project.back;

public class CasAlerte {
	private int idCas;
	private int idPatient;
	
	
	public CasAlerte(int idPatient) {
		
		this.idPatient = idPatient;
	}
	public CasAlerte(int idCas, int idPatient) {
		
		this.idCas = idCas;
		this.idPatient = idPatient;
	}
	public int getIdCas() {
		return idCas;
	}
	public void setIdCas(int idCas) {
		this.idCas = idCas;
	}
	public int getIdPatient() {
		return idPatient;
	}
	public void setIdPatient(int idPatient) {
		this.idPatient = idPatient;
	}
	
}
