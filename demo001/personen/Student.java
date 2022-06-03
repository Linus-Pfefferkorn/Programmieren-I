package demo001.personen;

public class Student extends Person {

	private String studiengruppe;
	private int notendurchschnitt;
	
	public Student(int PNr, String firstName, String lastName, String studiengruppe) {
		super(PNr, firstName, lastName);
		this.studiengruppe=studiengruppe;
	}

	@Override
	protected void printAusweis() {
		System.out.println("Studierendenausweis:");
		System.out.println("Name: "+firstName);
		System.out.println("Last Name: "+lastName);
		System.out.println("Studiengruppe: "+studiengruppe);
	}
	
	public int getNotendurchschnitt() {
		return this.notendurchschnitt;
	}
	
	public void setNotendurchschnitt(int durchschnitt) {
		
		this.notendurchschnitt = durchschnitt;
	}

}