package demo001.personen;

import java.time.LocalDate;

public class Besucher extends Person {
	
	private LocalDate besuchstag;
	private String besuchsabsicht;

	public Besucher(int PNr, String firstName, String lastName, LocalDate besuchstag) {
		super(PNr, firstName, lastName);
		this.besuchstag=besuchstag;
	}

	@Override
	protected void printAusweis() {
		System.out.println("Besucherausweis:");
		System.out.println("Name: "+ firstName);
		System.out.println("Last Name: "+ lastName);
		System.out.println("Datum: "+besuchstag);
	}
	
	public String getBesuchsabsicht() {
		return besuchsabsicht;
	}
	
	public void setBesuchsabsicht(String absicht) {
		
		this.besuchsabsicht = absicht;
	}
	
	
}