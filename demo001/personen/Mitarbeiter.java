package demo001.personen;

public class Mitarbeiter extends Person {
	
	private String fakultaet;
	private String fachgebiet;

	public Mitarbeiter(int PNr, String firstName, String lastName, String fakultaet) {
		super(PNr, firstName, lastName);
		this.fakultaet=fakultaet;
	}

	@Override
	protected void printAusweis() {
		System.out.println("Mitarbeiterausweis:");
		System.out.println("Name: "+lastName);
		System.out.println("Last Name: "+lastName);
		System.out.println("Fakultaet: "+fakultaet);
	}
	
	public String getFachgebiet() {
		return fachgebiet;
	}
	
	public void setFachgebiet(String fachgebiet) {
		
		this.fachgebiet = fachgebiet;
	}
 }