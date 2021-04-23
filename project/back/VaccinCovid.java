package project.back;

public class VaccinCovid {
	private int idVaccin;
	private int idPatient;
	
	public int getIdVaccin() {
		return idVaccin;
	}
	
	public VaccinCovid(int idVaccin, int idPatient) {
		
		this.idVaccin = idVaccin;
		this.idPatient = idPatient;
	}
	

	

	public void setIdVaccin(int idVaccin) {
		this.idVaccin = idVaccin;
	}

	public int getIdPatient() {
		return idPatient;
	}

	public void setIdPatient(int idPatient) {
		this.idPatient = idPatient;
	}

	public VaccinCovid(int idPatient) {
	
		this.idPatient = idPatient;
	}
	
	
}
